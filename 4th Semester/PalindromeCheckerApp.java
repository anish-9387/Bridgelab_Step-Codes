/**
 * =============================================================
 * MAIN CLASS - PalindromeCheckerApp_Usecase4
 * =============================================================
 *
 * Use Case 4: Character Array Based Validation
 *
 * Description:
 * This class validates a palindrome by converting
 * the string into a character array and comparing
 * characters using the two-pointer technique.
 *
 * At this stage, the application:
 * - Converts string to char array
 * - Uses start and end pointers
 * - Compares characters efficiently
 * - Displays the result
 *
 * This reduces extra memory usage.
 *
 * @author Anish
 * @version 4.0
 */

public class UseCase4PalindromeCheckerApp_Usecase4{
    public static void main(String[] args){
        String input="radar";

        char[] chars=input.toCharArray();

        int start=0;

        int end=chars.length-1;

        boolean isPalindrome=true;

        while(start<end){
            if(chars[start]!=chars[end]){
                isPalindrome=false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("Input : "+input);
        System.out.println("Is Palindrome? : "+isPalindrome);
    }
}