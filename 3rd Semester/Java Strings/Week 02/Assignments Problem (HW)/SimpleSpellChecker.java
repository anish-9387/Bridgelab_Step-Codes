import java.util.Scanner;

public class SimpleSpellChecker{
    public static String[] extractWords(String sentence){
        int n=sentence.length();
        StringBuilder word=new StringBuilder();
        String[] temp=new String[n];
        int count=0;

        for(int i=0; i<n; i++){
            char ch=sentence.charAt(i);
            if(Character.isLetter(ch)){
                word.append(ch);
            }
            else{
                if(word.length()>0){
                    temp[count++]=word.toString();
                    word.setLength(0);
                }
            }
        }
        if(word.length()>0){
            temp[count++]=word.toString();
        }

        String[] words=new String[count];
        System.arraycopy(temp,0,words,0,count);
        return words;
    }

    public static int stringDistance(String a, String b){
        int lenA=a.length();
        int lenB=b.length();

        if(lenA==lenB){
            int diff=0;

            for(int i=0; i<lenA; i++){
                if(a.charAt(i)!=b.charAt(i))  diff++;
            }
            return diff;
        }
        else{
            return Math.abs(lenA-lenB)+Math.min(lenA,lenB);
        }
    }

    public static String suggestWord(String word, String[] dictionary){
        String suggestion=word;
        int minDist=Integer.MAX_VALUE;

        for(String dictWord : dictionary){
            int dist=stringDistance(word.toLowerCase(), dictWord.toLowerCase());
            if(dist<minDist){
                minDist=dist;
                suggestion=dictWord;
            }
        }

        if(minDist<=2 && !suggestion.equalsIgnoreCase(word)){
            return suggestion;
        }
        else{
            return "Correct";
        }
    }

    public static void displayResults(String[] words, String[] dictionary){
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Word", "Suggestion", "Distance", "Status");
        System.out.println("-------------------------------------------------------------");

        for(String word : words){
            String suggestion=word;
            String status="Correct";
            int distance=0;

            String bestMatch=word;
            int minDist=Integer.MAX_VALUE;

            for(String dictWord : dictionary){
                int dist=stringDistance(word.toLowerCase(), dictWord.toLowerCase());

                if(dist<minDist){
                    minDist=dist;
                    bestMatch=dictWord;
                }
            }

            if(minDist==0){
                status="Correct";
                suggestion="-";
            }
            else if(minDist<=2){
                status="Misspelled";
                suggestion=bestMatch;
            }
            else{
                status="Misspelled";
                suggestion="No close match";
            }

            distance=minDist;
            System.out.printf("%-15s %-15s %-15d %-15s%n",word,suggestion,distance,status);
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter number of dictionary words: ");
        int n=input.nextInt();
        input.nextLine();
        String[] dictionary=new String[n];
        System.out.println("Enter dictionary words:");

        for(int i=0; i<n; i++){
            dictionary[i]=input.nextLine().trim();
        }

        System.out.println("Enter a sentence to check:");
        String sentence=input.nextLine();

        String[] words=extractWords(sentence);

        displayResults(words,dictionary);
        input.close();
    }
}
