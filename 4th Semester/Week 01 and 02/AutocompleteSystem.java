import java.util.*;

class TrieNode{
    Map<Character, TrieNode> children=new HashMap<>();
    Map<String, Integer> queries=new HashMap<>();
    boolean isEnd=false;
}

public class AutocompleteSystem{
    private TrieNode root=new TrieNode();
    private Map<String, Integer> queryFrequency=new HashMap<>();
    private int TOP_K=10;

    public void addQuery(String query){
        queryFrequency.put(query,queryFrequency.getOrDefault(query,0)+1);

        int freq=queryFrequency.get(query);

        TrieNode node=root;

        for(char c : query.toCharArray()){
            node.children.putIfAbsent(c,new TrieNode());
            node=node.children.get(c);

            node.queries.put(query,freq);
        }

        node.isEnd=true;
    }

    public List<String> search(String prefix){
        TrieNode node=root;

        for(char c : prefix.toCharArray()){
            if(!node.children.containsKey(c)){
                return new ArrayList<>();
            }

            node=node.children.get(c);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq=new PriorityQueue<>((a, b) -> a.getValue()-b.getValue());

        for(Map.Entry<String, Integer> entry : node.queries.entrySet()){
            pq.offer(entry);

            if(pq.size()>TOP_K){
                pq.poll();
            }
        }

        List<String> result=new ArrayList<>();

        while(!pq.isEmpty()){
            result.add(pq.poll().getKey()+" ("+pq.peek()+")");
        }

        Collections.reverse(result);

        return result;
    }

    public void updateFrequency(String query){
        addQuery(query);
    }

    public static void main(String[] args){
        AutocompleteSystem system=new AutocompleteSystem();

        system.addQuery("java tutorial");
        system.addQuery("javascript");
        system.addQuery("java download");
        system.addQuery("java tutorial");
        system.addQuery("java 21 features");
        system.addQuery("java tutorial");

        System.out.println("Suggestions for 'jav':");

        List<String> suggestions=system.search("jav");

        int rank=1;

        for(String s : suggestions){
            System.out.println(rank+". "+s);
            rank++;
        }

        system.updateFrequency("java 21 features");

        System.out.println("\nUpdated frequency for 'java 21 features'");
    }
}