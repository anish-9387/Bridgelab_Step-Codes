import java.util.*;

// Class creation
public class CompareSubstring{
    // Method to create a substring using charAt
    public String substringUsingCharAt(String str, int start, int end){
        String substring = "";
        for(int i=start; i<end; i++){
            substring += str.charAt(i);
        }
        return substring;
    }

    // Method to compare two strings using charAt
    public boolean compareStringsUsingCharAt(String str1, String str2){
        if(str1.length() == str2.length()){
			for(int i=0; i<str1.length(); i++){
				if(str1.charAt(i) != str2.charAt(i))   return false;
			}
			return true;
		}
		else   return false;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		CompareSubstring obj = new CompareSubstring();

        // Taking string, starting index and ending index from the user
        System.out.print("Enter a string: ");
        String str = input.next();
        System.out.print("Enter the starting index: ");
        int start = input.nextInt();
        System.out.print("Enter the ending index: ");
        int end = input.nextInt();
		
		String substrUsingCharAt = obj.substringUsingCharAt(str,start,end);
		String substrUsingBuiltIn = str.substring(start,end);
		
        System.out.println("Substring using charAt(): " + substrUsingCharAt);
        System.out.println("Substring using built-in method: " + substrUsingBuiltIn);
        System.out.println("Are both substrings equal? " + obj.compareStringsUsingCharAt(substrUsingCharAt,substrUsingBuiltIn));
		
		input.close();
    }
}
