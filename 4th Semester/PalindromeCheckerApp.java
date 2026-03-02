/**
 * ==========================================================
 * MAIN CLASS – PalindromeCheckerApp_Usecase2
 * ==========================================================
 *
 * Use Case 2: Hardcoded Palindrome Validation
 *
 * Description:
 * This class demonstrates basic palindrome validation
 * using a hardcoded string value.
 *
 * @author Anish
 * @version 2.0
 */

public class PalindromeCheckerApp_Usecase2{
    public static void main(String[] args){
        String input="madam";

        System.out.println("Input text: "+input);

        boolean isPalindrome=true;

        for(int i=0; i<input.length()/2; i++){
            if(input.charAt(i)!=input.charAt(input.length()-1-i)){
                isPalindrome=false;
                break;
            }
        }

        if(isPalindrome){
            System.out.println("Is it a Palindrome? : true");
        }
	else{
            System.out.println("Is it a Palindrome? : false");
        }
    }
}