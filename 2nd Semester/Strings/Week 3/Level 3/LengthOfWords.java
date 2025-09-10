import java.util.*;

// Class creation
public class LengthOfWords{
    // Method to get the length of a string without using length()
    public int getLength(String str){
        int count = 0;
        try{
            while(true){
                str.charAt(count);
                count++;
            }
        }
		catch(IndexOutOfBoundsException e){
			
        }
        return count;
    }

    // Method to split the string into words using charAt(), not split()
    public String[] customSplitWords(String str){
        int len = getLength(str);
        int wordCount = 0;
        boolean inWord = false;

        for(int i=0; i<len; i++){
            if(str.charAt(i) != ' ' && !inWord){
                wordCount++;
                inWord = true;
            }
			else if(str.charAt(i) == ' '){
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        int idx = 0;
        StringBuilder word = new StringBuilder();

        for(int i=0; i<len; i++){
            char ch = str.charAt(i);
            if(ch != ' '){
                word.append(ch);
            }
			else{
                if(word.length() > 0){
                    words[idx++] = word.toString();
                    word.setLength(0);
                }
            }
        }

        // For last word
        if(word.length() > 0){
            words[idx] = word.toString();
        }
        return words;
    }

    // Method to return a 2D String array with word and its length
    public String[][] getWordsWithLengths(String[] words){
        int size = getLengthOfArray(words);
        String[][] result = new String[size][2];

        for(int i=0; i<size; i++){
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    // Method to get length of a string array without using length()
    public int getLengthOfArray(String[] arr){
        int count = 0;
        try{
            while(true){
                String temp = arr[count];
                count++;
            }
        }
		catch(ArrayIndexOutOfBoundsException e){

        }
        return count;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		LengthOfWords obj = new LengthOfWords();

        // Taking input from the user
        System.out.print("Enter a line: ");
        String line = input.nextLine();

        String[] words = obj.customSplitWords(line);

        String[][] wordLengths = obj.getWordsWithLengths(words);

        // Displaying the results
        System.out.println("\nWord\t\tLength");
        System.out.println("-------------------------");
        for(int i=0; i<obj.getLengthOfArray(words); i++){
            String word = wordLengths[i][0];
            int length = Integer.parseInt(wordLengths[i][1]);
            System.out.println(word + "\t\t" + length);
        }
        input.close();
    }
}
