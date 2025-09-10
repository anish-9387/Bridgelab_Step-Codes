import java.util.*;

// Class creation
public class PalindromeText{
    // Method to remove spaces and convert to lowercase
    public String refineText(String str){
        String cleaned = "";
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c != ' '){
                cleaned += Character.toLowerCase(c);
            }
        }
        return cleaned;
    }

    // Logic 1: Using loop to compare characters from start and end
    public boolean isPalindromeLoop(String str){
        int start = 0;
        int end = str.length() - 1;

        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Using recursion
    public boolean isPalindromeRecursive(String str, int start, int end){
        if(start >= end){
            return true;
        }
        if(str.charAt(start) != str.charAt(end)){
            return false;
        }
        return isPalindromeRecursive(str,start+1,end-1);
    }

    // Method to reverse a string using charAt()
    public char[] reverseString(String str){
        int len = str.length();
        char[] reverse = new char[len];
        for(int i=0; i<len; i++){
            reverse[i] = str.charAt(len - i - 1);
        }
        return reverse;
    }

    // Logic 3: Using character arrays
    public boolean isPalindromeArray(String str){
        char[] original = str.toCharArray();
        char[] reverse = reverseString(str);

        for(int i=0; i<original.length; i++){
            if(original[i] != reverse[i]){
                return false;
            }
        }
        return true;
    }
	
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		PalindromeText obj = new PalindromeText();

        // Taking input from the user
        System.out.print("Enter a text: ");
        String str = input.nextLine();

        String refinedText = obj.refineText(str);

        // Check palindrome using logic 1
        boolean resultLoop = obj.isPalindromeLoop(refinedText);
        System.out.println("Palindrome check using Loop: " + resultLoop);

        // Check palindrome using logic 2
        boolean resultRecursive = obj.isPalindromeRecursive(refinedText,0,refinedText.length() - 1);
        System.out.println("Palindrome check using Recursion: " + resultRecursive);

        // Check palindrome using logic 3
        boolean resultArray = obj.isPalindromeArray(refinedText);
        System.out.println("Palindrome check using Character Arrays: " + resultArray);
        input.close();
    }
}
