import java.util.*;

// Class creation
public class StringSplitting{
    // Method to find the length of a string without using length()
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

    // Method to split a string into words without using split()
    public String[] customSplitWords(String str){
        int len = getLength(str);
        int countOfSpace = 0;

        for(int i=0; i<len; i++){
            if(str.charAt(i) == ' '){
                countOfSpace++;
            }
        }

        int[] spaceIndexes = new int[countOfSpace];
        int idx = 0;
        for(int i=0; i<len; i++){
            if(str.charAt(i) == ' '){
                spaceIndexes[idx++] = i;
            }
        }

        String[] words = new String[countOfSpace + 1];
        int start = 0;
        int wordIdx = 0;

        for(int i=0; i<countOfSpace; i++){
            int end = spaceIndexes[i];
            words[wordIdx++] = str.substring(start,end);
            start = end + 1;
        }

		// For last word
        words[wordIdx] = str.substring(start,len);
        return words;
    }

    // Method to compare two arrays of strings
    public boolean compareTwoArrays(String[] arr1, String[] arr2){
        if(arr1.length != arr2.length)   return false;

        for(int i=0; i<arr1.length; i++){
            if(!arr1[i].equals(arr2[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		StringSplitting obj = new StringSplitting();

        // Taking input from the user
        System.out.print("Enter a line: ");
        String line = input.nextLine();

        String[] customWords = obj.customSplitWords(line);

        String[] builtInWords = line.split(" ");

        // Comparing the two results
        boolean isSame = obj.compareTwoArrays(customWords,builtInWords);

        // Displaying the results
        System.out.println("\nResult of custom splitting:");
        for(String word : customWords){
            System.out.println(word);
        }

        System.out.println("\nResult of built-in splitting:");
        for(String word : builtInWords){
            System.out.println(word);
        }
        System.out.println("\nAre both results equal? " + isSame);
        input.close();
    }
}
