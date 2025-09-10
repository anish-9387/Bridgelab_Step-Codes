import java.util.*;

public class TextProcessor{
    public static String cleanInput(String input){
        input=input.trim().replaceAll("\\s+"," ");

        String[] sentences=input.split("(?<=[.!?])\\s*");
        StringBuilder cleaned=new StringBuilder();

        for(String s : sentences){
            if(s.length()>0){
                cleaned.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1).toLowerCase()).append(" ");
            }
        }
        return cleaned.toString().trim();
    }

    public static void analyzeText(String text){
        int charCount=text.replace(" ","").length();
        int wordCount=text.split("\\s+").length;
        int sentenceCount=text.split("[.!?]").length;

        String longestWord="";
        for(String word : text.split("\\W+")){
            if(word.length()>longestWord.length()){
                longestWord=word;
            }
        }

        int[] freq=new int[Character.MAX_VALUE+1];
        for(char c : text.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                freq[c]++;
            }
        }
        char mostCommonChar=' ';
        int maxFreq=0;
        for(int i=0; i<freq.length; i++){
            if(freq[i]>maxFreq){
                maxFreq=freq[i];
                mostCommonChar=(char)i;
            }
        }

        System.out.println("\n------TEXT ANALYSIS------");
        System.out.println("Characters (no spaces): "+charCount);
        System.out.println("Words: "+wordCount);
        System.out.println("Sentences: "+sentenceCount);
        System.out.println("Longest word: "+longestWord);
        System.out.println("Most common character: '"+mostCommonChar+"' ("+maxFreq+" times)");
    }

    public static String[] getWordsSorted(String text){
        String[] words=text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]","").split("\\s+");
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.println("======TEXT PROCESSOR======");
        System.out.println("Enter a paragraph of text:");
        String para=input.nextLine();

        String cleanedText=cleanInput(para);
        System.out.println("\nCleaned Text:\n"+cleanedText);

        analyzeText(cleanedText);

        String[] sortedWords=getWordsSorted(cleanedText);
        System.out.println("\n------SORTED WORDS------");
        for(String word : sortedWords){
            System.out.print(word+" ");
        }
        System.out.println();

        System.out.print("\nEnter a word to search: ");
        String searchWord=input.nextLine().toLowerCase();

        boolean found=Arrays.asList(sortedWords).contains(searchWord);
        if(found){
            System.out.println("Word '"+searchWord+"' found in text");
        }
        else {
            System.out.println("Word '"+searchWord+"' not found");
        }
        input.close();
    }
}
