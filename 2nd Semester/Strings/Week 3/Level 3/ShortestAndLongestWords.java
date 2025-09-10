import java.util.*;

// Class creation
public class ShortestAndLongestWord{
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

    // Method to split a string into words using charAt()
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

    // Method to create 2D array of word and its length
    public String[][] getWordsWithLengths(String[] words){
        int size = getLengthOfArray(words);
        String[][] result = new String[size][2];

        for(int i=0; i<size; i++){
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    // Method to get array length without using length()
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

    public int getLengthOf2DArray(String[][] arr){
        int count = 0;
        try{
            while(true){
                String[] temp = arr[count];
                count++;
            }
        }
		catch(ArrayIndexOutOfBoundsException e){
			
        }
        return count;
    }

    // Method to find the indices of shortest and longest words
    public int[] findShortestAndLongestWords(String[][] wordData){
        int size = getLengthOf2DArray(wordData);
        int minLen = Integer.parseInt(wordData[0][1]), maxLen = minLen;
        int minIdx = 0, maxIdx = 0;

        for(int i=1; i<size; i++){
            int currentLen = Integer.parseInt(wordData[i][1]);
            if(currentLen < minLen){
                minLen = currentLen;
                minIdx = i;
            }
            if(currentLen > maxLen){
                maxLen = currentLen;
                maxIdx = i;
            }
        }
        return new int[]{minIdx, maxIdx};
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		ShortestAndLongestWord obj = new ShortestAndLongestWord();

        System.out.print("Enter a line: ");
        String line = input.nextLine();

        String[] words = obj.customSplitWords(line);
        String[][] wordWithLengths = obj.getWordsWithLengths(words);
        int[] resultIndexes = obj.findShortestAndLongestWords(wordWithLengths);

        System.out.println("\nWord\t\tLength");
        System.out.println("------------------------");
        for(int i=0; i<obj.getLengthOf2DArray(wordWithLengths); i++){
            String word = wordWithLengths[i][0];
            int length = Integer.parseInt(wordWithLengths[i][1]);
            System.out.println(word + "\t\t" + length);
        }

        System.out.println("\nShortest Word: " + wordWithLengths[resultIndexes[0]][0]);
        System.out.println("Longest Word : " + wordWithLengths[resultIndexes[1]][0]);
        input.close();
    }
}
