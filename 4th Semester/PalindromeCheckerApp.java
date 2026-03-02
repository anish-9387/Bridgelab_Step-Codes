/**
 * =============================================================
 * MAIN CLASS - PalindromeCheckerApp_Usecase11
 * =============================================================
 *
 * Use Case 11: Service-Based Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using a
 * separate service layer.
 *
 * The palindrome logic is encapsulated inside
 * PalindromeService to demonstrate:
 * - Separation of Concerns
 * - Code Reusability
 * - Clean Architecture
 *
 * @author Anish
 * @version 11.0
 */

public class UseCase11PalindromeCheckerApp{
    public static void main(String[] args){

        String input="racecar";

        System.out.println("Input : "+input);

        PalindromeService service=new PalindromeService();

        boolean isPalindrome=service.checkPalindrome(input);

        System.out.println("Is Palindrome? : "+isPalindrome);
    }
}

class PalindromeService{
    public boolean checkPalindrome(String input){
        int start=0;
        int end=input.length()-1;

        while(start<end){
            if(input.charAt(start)!=input.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}