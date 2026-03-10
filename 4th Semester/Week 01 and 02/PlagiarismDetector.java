import java.util.*;

public class PlagiarismDetector{
    private Map<String, Set<String>> ngramIndex;

    private Map<String, List<String>> documentNgrams;

    private int N=5;

    public PlagiarismDetector(){
        ngramIndex=new HashMap<>();
        documentNgrams=new HashMap<>();
    }

    public void addDocument(String docId, String text){
        List<String> ngrams=extractNgrams(text);
        documentNgrams.put(docId,ngrams);

        for(String ngram : ngrams){
            ngramIndex.putIfAbsent(ngram, new HashSet<>());
            ngramIndex.get(ngram).add(docId);
        }
    }

    private List<String> extractNgrams(String text){
        List<String> result=new ArrayList<>();

        String[] words=text.toLowerCase().split("\\s+");

        for(int i=0; i<=words.length-N; i++){
            StringBuilder sb=new StringBuilder();

            for(int j=0; j<N; j++){
                sb.append(words[i+j]).append(" ");
            }

            result.add(sb.toString().trim());
        }
        return result;
    }

    public void analyzeDocument(String docId, String text){
        List<String> ngrams=extractNgrams(text);
        System.out.println("Extracted "+ngrams.size()+" n-grams");

        Map<String, Integer> matchCount=new HashMap<>();

        for(String ngram : ngrams){
            if(ngramIndex.containsKey(ngram)){
                for(String matchedDoc : ngramIndex.get(ngram)){
                    matchCount.put(matchedDoc,matchCount.getOrDefault(matchedDoc,0)+1);
                }
            }
        }

        for(String doc : matchCount.keySet()){
            int matches=matchCount.get(doc);

            double similarity=(matches*100.0)/ngrams.size();

            System.out.println("Found "+matches+" matching n-grams with "+doc+" → Similarity: "+String.format("%.2f",similarity)+"%");

            if(similarity>60){
                System.out.println("⚠ PLAGIARISM DETECTED with "+doc);
            }
        }
    }

    public static void main(String[] args){
        PlagiarismDetector detector=new PlagiarismDetector();

        String essay1="machine learning is a field of artificial intelligence that focuses on learning from data";
        String essay2="machine learning is a branch of artificial intelligence that learns patterns from data";
        String essay3="the history of ancient civilizations is fascinating and full of mysteries";

        detector.addDocument("essay_089.txt",essay1);
        detector.addDocument("essay_092.txt",essay2);
        detector.addDocument("essay_100.txt",essay3);

        String newEssay="machine learning is a field of artificial intelligence that focuses on learning from data and patterns";

        detector.analyzeDocument("essay_123.txt",newEssay);
    }
}