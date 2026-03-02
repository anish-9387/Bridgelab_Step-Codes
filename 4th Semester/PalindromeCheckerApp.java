/**
 * ==========================================================
 * MAIN CLASS – PalindromeCheckerApp_Usecase3
 * ==========================================================
 *
 * Use Case 3: Reverse String Based Palindrome Check
 *
 * Description:
 * This class checks whether a string is a palindrome
 * by reversing the string and comparing it with
 * the original value.
 *
 * @author Anish
 * @version 3.0
 */

public class PalindromeCheckerApp_Usecase3{
    public static void main(String[] args) {
        String input="madam";

        System.out.println("Input text: "+input);

        String reversed="";

        for(int i=input.length()-1; i>=0; i--){
            reversed=reversed+input.charAt(i);
        }

        if(input.equals(reversed)){
            System.out.println("Is it a Palindrome? : true");
        }
	else{
            System.out.println("Is it a Palindrome? : false");
        }
    }
}