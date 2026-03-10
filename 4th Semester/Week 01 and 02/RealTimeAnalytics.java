import java.util.*;

class PageViewEvent{
    String url;
    String userId;
    String source;

    public PageViewEvent(String url, String userId, String source){
        this.url=url;
        this.userId=userId;
        this.source=source;
    }
}

public class RealTimeAnalytics{
    private Map<String, Integer> pageViews;

    private Map<String, Set<String>> uniqueVisitors;

    private Map<String, Integer> trafficSources;

    public RealTimeAnalytics(){
        pageViews=new HashMap<>();
        uniqueVisitors=new HashMap<>();
        trafficSources=new HashMap<>();
    }

    public void processEvent(PageViewEvent event){
        pageViews.put(event.url,pageViews.getOrDefault(event.url,0)+1);

        uniqueVisitors.putIfAbsent(event.url,new HashSet<>());
        uniqueVisitors.get(event.url).add(event.userId);

        trafficSources.put(event.source,trafficSources.getOrDefault(event.source,0)+1);
    }

    private List<Map.Entry<String, Integer>> getTopPages(int n){
        PriorityQueue<Map.Entry<String, Integer>> pq=new PriorityQueue<>(Map.Entry.comparingByValue());

        for(Map.Entry<String, Integer> entry : pageViews.entrySet()){
            pq.offer(entry);
            if(pq.size()>n){
                pq.poll();
            }
        }

        List<Map.Entry<String, Integer>> result=new ArrayList<>(pq);
        result.sort((a,b) -> b.getValue()-a.getValue());

        return result;
    }

    public void getDashboard(){
        System.out.println("\n====== REAL-TIME ANALYTICS DASHBOARD ======");

        System.out.println("\nTop Pages:");

        List<Map.Entry<String, Integer>> topPages=getTopPages(10);

        int rank=1;

        for(Map.Entry<String, Integer> entry : topPages){
            String page=entry.getKey();
            int views=entry.getValue();
            int unique=uniqueVisitors.get(page).size();

            System.out.println(rank+". "+page+" - "+views+" views ("+unique+" unique)");

            rank++;
        }

        System.out.println("\nTraffic Sources:");

        int totalTraffic=trafficSources.values().stream().mapToInt(Integer::intValue).sum();

        for(String source : trafficSources.keySet()){
            int count=trafficSources.get(source);

            double percent=(count*100.0)/totalTraffic;

            System.out.println(source+": "+String.format("%.2f",percent)+"%");
        }
    }

    public static void main(String[] args){
        RealTimeAnalytics analytics=new RealTimeAnalytics();

        analytics.processEvent(new PageViewEvent("/article/breaking-news", "user_123", "google"));

        analytics.processEvent(new PageViewEvent("/article/breaking-news", "user_456", "facebook"));

        analytics.processEvent(new PageViewEvent("/sports/championship", "user_789", "direct"));

        analytics.processEvent(new PageViewEvent("/article/breaking-news", "user_123", "google"));

        analytics.processEvent(new PageViewEvent("/sports/championship", "user_111", "google"));

        analytics.processEvent(new PageViewEvent("/tech/ai-news", "user_999", "direct"));

        analytics.getDashboard();
    }
}