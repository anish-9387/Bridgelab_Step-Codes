import java.util.concurrent.*;
import java.util.*;

class TokenBucket{
    private int tokens;
    private final int maxTokens;
    private final int refillRate;
    private long lastRefillTime;

    public TokenBucket(int maxTokens, int refillRate){
        this.maxTokens=maxTokens;
        this.refillRate=refillRate;
        this.tokens=maxTokens;
        this.lastRefillTime=System.currentTimeMillis();
    }

    private synchronized void refill(){
        long now=System.currentTimeMillis();
        long elapsedTime=now-lastRefillTime;

        int tokensToAdd=(int)(elapsedTime/1000)*refillRate;

        if(tokensToAdd>0){
            tokens=Math.min(maxTokens,tokens+tokensToAdd);
            lastRefillTime=now;
        }
    }

    public synchronized boolean allowRequest(){
        refill();

        if(tokens>0){
            tokens--;
            return true;
        }
        return false;
    }

    public synchronized int getRemainingTokens(){
        refill();
        return tokens;
    }
}

public class DistributedRateLimiter{
    private Map<String, TokenBucket> clients;

    private final int MAX_REQUESTS=1000;
    private final int REFILL_RATE=1000/3600;

    public DistributedRateLimiter(){
        clients=new ConcurrentHashMap<>();
    }

    public String checkRateLimit(String clientId){
        clients.putIfAbsent(clientId,new TokenBucket(MAX_REQUESTS,REFILL_RATE));

        TokenBucket bucket=clients.get(clientId);

        if(bucket.allowRequest()){
            int remaining=bucket.getRemainingTokens();

            return "Allowed ("+remaining+" requests remaining)";
        }

        return "Denied (Rate limit exceeded)";
    }

    public String getRateLimitStatus(String clientId){
        TokenBucket bucket=clients.get(clientId);

        if(bucket==null){
            return "Client not found";
        }

        int remaining=bucket.getRemainingTokens();
        int used=MAX_REQUESTS-remaining;

        return "{used: "+used+", limit: "+MAX_REQUESTS+", remaining: "+remaining+"}";
    }

    public static void main(String[] args){
        DistributedRateLimiter limiter=new DistributedRateLimiter();

        String client="abc123";

        for(int i=0; i<5; i++){
            System.out.println(limiter.checkRateLimit(client));
        }

        System.out.println(limiter.getRateLimitStatus(client));
    }
}