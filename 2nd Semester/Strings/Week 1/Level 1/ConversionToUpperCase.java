import java.util.*;

// Class creation
public class ConversionToUpperCase{
    // Method to convert text to uppercase using ASCII logic
    public String toUpperCaseUsingCharAt(String str){
        String ans = "";
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch>='a' && ch<='z'){
                ans += (char)(ch - 32);
            }
			else{
                ans += ch;
            }
        }
        return ans;
    }

    // Method to compare two strings
    public boolean compareTwoStrings(String str1, String str2){
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
		ConversionToUpperCase obj = new ConversionToUpperCase();

        // Taking line as input
        System.out.print("Enter a sentence: ");
        String sent = input.nextLine();

        String userDefinedUpper = obj.toUpperCaseUsingCharAt(sent);

        String builtInUpper = sent.toUpperCase();

        // Displaying the results
        System.out.println("Converted using user-defined method: " + userDefinedUpper);
        System.out.println("Converted using built-in method: " + builtInUpper);
        System.out.println("Are both uppercase method's result equal? " + obj.compareTwoStrings(userDefinedUpper,builtInUpper));
    }
}
