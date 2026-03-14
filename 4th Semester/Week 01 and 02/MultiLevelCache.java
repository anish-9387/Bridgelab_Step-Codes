import java.util.*;

class VideoData{
    String videoId;
    String content;

    public VideoData(String videoId, String content){
        this.videoId=videoId;
        this.content=content;
    }
}

class LRUCache<K, V> extends LinkedHashMap<K, V>{
    private int capacity;

    public LRUCache(int capacity){
        super(capacity,0.75f,true);
        this.capacity=capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
        return size()>capacity;
    }
}

public class MultiLevelCache{
    // L1 Cache (RAM)
    private LRUCache<String, VideoData> L1=new LRUCache<>(10000);

    // L2 Cache (SSD)
    private LRUCache<String, VideoData> L2=new LRUCache<>(100000);

    // L3 Database
    private HashMap<String, VideoData> database=new HashMap<>();

    // Access counter
    private HashMap<String, Integer> accessCount=new HashMap<>();

    // Statistics
    private int L1Hits=0;
    private int L2Hits=0;
    private int L3Hits=0;

    private int L1Requests=0;
    private int L2Requests=0;
    private int L3Requests=0;

    private final int PROMOTION_THRESHOLD=3;

    public MultiLevelCache(){
        for(int i=1; i<=1000000; i++){
            String id="video_"+i;
            database.put(id,new VideoData(id,"Content for "+id));
        }
    }

    public VideoData getVideo(String videoId){
        long start=System.currentTimeMillis();

        L1Requests++;
        if(L1.containsKey(videoId)){
            L1Hits++;
            simulateDelay(1);
            System.out.println("L1 Cache HIT");
            return L1.get(videoId);
        }

        System.out.println("L1 Cache MISS");

        L2Requests++;
        if(L2.containsKey(videoId)){
            L2Hits++;
            simulateDelay(5);
            System.out.println("L2 Cache HIT");

            VideoData video=L2.get(videoId);

            promoteToL1(videoId,video);

            return video;
        }

        System.out.println("L2 Cache MISS");

        L3Requests++;
        VideoData video=database.get(videoId);

        if(video!=null){
            L3Hits++;
            simulateDelay(150);
            System.out.println("L3 Database HIT");

            L2.put(videoId,video);
            accessCount.put(videoId,1);
        }

        long end=System.currentTimeMillis();

        System.out.println("Total Time: "+(end-start)+"ms\n");
        return video;
    }

    private void promoteToL1(String videoId, VideoData video){
        int count=accessCount.getOrDefault(videoId,0)+1;
        accessCount.put(videoId,count);

        if(count>=PROMOTION_THRESHOLD){
            L1.put(videoId,video);
            System.out.println("Promoted to L1 Cache");
        }
    }

    public void invalidate(String videoId){
        L1.remove(videoId);
        L2.remove(videoId);
        database.remove(videoId);
        accessCount.remove(videoId);

        System.out.println("Cache invalidated for "+videoId);
    }

    public void getStatistics(){
        double L1HitRate=(double)L1Hits/L1Requests*100;
        double L2HitRate=(double)L2Hits/L2Requests*100;
        double L3HitRate=(double)L3Hits/L3Requests*100;

        System.out.println("\nCache Statistics");
        System.out.println("------------------");

        System.out.println("L1 Hit Rate: "+L1HitRate+"%");
        System.out.println("L2 Hit Rate: "+L2HitRate+"%");
        System.out.println("L3 Hit Rate: "+L3HitRate+"%");
    }

    private void simulateDelay(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(Exception e){}
    }

    public static void main(String[] args){
        MultiLevelCache cache=new MultiLevelCache();

        cache.getVideo("video_123");
        cache.getVideo("video_123");
        cache.getVideo("video_999");

        cache.getStatistics();
    }
}