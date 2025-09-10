import java.util.*;

public class StringManipulation{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.println("Enter a sentence (with digits, punctuation, and spaces):");
        String sentence=input.nextLine();

        System.out.println("\n====== String Manipulation Demo ======\n");

        String trimmed=sentence.trim();
        System.out.println("1. After trim(): \""+trimmed+"\"");

        String replaced=trimmed.replace(" ","_");
        System.out.println("2. After replace spaces: "+replaced);

        String noDigits=trimmed.replaceAll("\\d","");
        System.out.println("3. After removing digits: "+noDigits);

        String[] words=trimmed.split("\\s+");
        System.out.println("4. Words array: "+Arrays.toString(words));

        String joined=String.join(" | ",words);
        System.out.println("5. Rejoined with | : "+joined);

        String noPunctuation=removePunctuation(trimmed);
        System.out.println("\nExtra 1. After removing punctuation: "+noPunctuation);

        String capitalized=capitalizeWords(noPunctuation);
        System.out.println("Extra 2. Capitalized words: "+capitalized);

        String reversedOrder=reverseWordOrder(noPunctuation);
        System.out.println("Extra 3. Reversed word order: "+reversedOrder);

        System.out.println("Extra 4. Word frequency:");
        countWordFrequency(noPunctuation);
        input.close();
    }

    public static String removePunctuation(String text){
        return text.replaceAll("[\\p{Punct}]","");
    }

    public static String capitalizeWords(String text){
        String[] words=text.split("\\s+");
        StringBuilder sb=new StringBuilder();

        for(String w : words){
            if(w.length()>0){
                sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1).toLowerCase()).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String reverseWordOrder(String text){
        String[] words=text.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void countWordFrequency(String text){
        String[] words=text.toLowerCase().split("\\s+");
        List<String> uniques=new ArrayList<>();
        List<Integer> counts=new ArrayList<>();

        for(String w : words){
            if(w.isEmpty())  continue;
            int idx=uniques.indexOf(w);

            if(idx==-1){
                uniques.add(w);
                counts.add(1);
            }
            else{
                counts.set(idx, counts.get(idx)+1);
            }
        }

        for(int i=0; i<uniques.size(); i++){
            System.out.println(uniques.get(i)+" : "+counts.get(i));
        }
    }
}
