import java.util.*;
import java.util.concurrent.*;

class DNSEntry{
    String domain;
    String ipAddress;
    long expiryTime;

    public DNSEntry(String domain, String ipAddress, long ttlSeconds){
        this.domain=domain;
        this.ipAddress=ipAddress;
        this.expiryTime=System.currentTimeMillis()+(ttlSeconds*1000);
    }

    public boolean isExpired(){
        return System.currentTimeMillis()>expiryTime;
    }
}

public class DNSCache{
    private final int MAX_CACHE_SIZE;

    private Map<String, DNSEntry> cache;

    private long cacheHits=0;
    private long cacheMisses=0;

    public DNSCache(int maxSize){
        this.MAX_CACHE_SIZE=maxSize;

        cache=new LinkedHashMap<String, DNSEntry>(16, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry<String, DNSEntry> eldest){
                return size()>MAX_CACHE_SIZE;
            }
        };

        startCleanupTask();
    }

    public synchronized String resolve(String domain){
        DNSEntry entry=cache.get(domain);

        if(entry!=null){
            if(!entry.isExpired()){
                cacheHits++;
                System.out.println("Cache HIT → "+entry.ipAddress);
                return entry.ipAddress;
            }
	    else{
                cache.remove(domain);
                System.out.println("Cache EXPIRED → querying upstream");
            }
        }
        cacheMisses++;

        String ip=queryUpstreamDNS(domain);

        cache.put(domain, new DNSEntry(domain,ip,300));

        System.out.println("Cache MISS → Upstream returned "+ip);

        return ip;
    }

    private String queryUpstreamDNS(String domain){
        Random rand=new Random();

        return "172.217.14."+(rand.nextInt(50)+1);
    }

    private void startCleanupTask(){
        ScheduledExecutorService scheduler=Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(() ->{
            synchronized(this){
                Iterator<Map.Entry<String, DNSEntry>> iterator=cache.entrySet().iterator();

                while(iterator.hasNext()){
                    Map.Entry<String, DNSEntry> entry=iterator.next();

                    if(entry.getValue().isExpired()){
                        iterator.remove();
                    }
                }
            }

        },30,30,TimeUnit.SECONDS);
    }

    public void getCacheStats(){
        long total=cacheHits+cacheMisses;

        double hitRate=total==0 ? 0 : ((double)cacheHits/total)*100;

        System.out.println("Cache Hits: "+cacheHits);
        System.out.println("Cache Misses: "+cacheMisses);
        System.out.println("Hit Rate: "+String.format("%.2f",hitRate)+"%");
    }

    public static void main(String[] args) throws Exception{
        DNSCache dnsCache=new DNSCache(5);

        dnsCache.resolve("google.com");
        dnsCache.resolve("google.com");
        dnsCache.resolve("openai.com");
        dnsCache.resolve("google.com");

        Thread.sleep(1000);

        dnsCache.getCacheStats();
    }
}