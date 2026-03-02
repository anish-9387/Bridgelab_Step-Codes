/**
 * =============================================================
 * MAIN CLASS - PalindromeCheckerApp_Usecase10
 * =============================================================
 *
 * Use Case 10: Case-Insensitive Palindrome Checker
 * (Ignoring Spaces & Special Characters)
 *
 * Description:
 * This class validates a palindrome by:
 * - Removing non-alphanumeric characters
 * - Converting text to lowercase
 * - Comparing characters from both ends
 *
 * This enables real-world palindrome validation.
 *
 * Example:
 * "A man a plan a canal Panama" → Palindrome
 *
 * @author Anish
 * @version 10.0
 */

public class UseCase10PalindromeCheckerApp{
    public static void main(String[] args){
        String input="A man a plan a canal Panama";

        System.out.println("Input : "+input);

        String normalized=input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindrome=true;

        for(int i=0; i<normalized.length()/2; i++){
            if(normalized.charAt(i)!=normalized.charAt(normalized.length()-1-i)){
                isPalindrome=false;
                break;
            }
        }

        System.out.println("Is Palindrome? : "+isPalindrome);
    }
}