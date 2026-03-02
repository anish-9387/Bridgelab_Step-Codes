/**
 * =============================================================
 * MAIN CLASS - PalindromeCheckerApp_Usecase9
 * =============================================================
 *
 * Use Case 9: Recursive Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using recursion.
 *
 * Characters are compared from the outer positions
 * moving inward using recursive calls.
 *
 * The recursion stops when:
 * - All characters are matched, OR
 * - A mismatch is found.
 *
 * This demonstrates divide-and-conquer logic.
 *
 * @author Anish
 * @version 9.0
 */

public class UseCase9PalindromeCheckerApp{
    public static void main(String[] args){
        String input="madam";

        System.out.println("Input : "+input);

        boolean isPalindrome=check(input,0,input.length()-1);

        System.out.println("Is Palindrome? : "+isPalindrome);
    }

    private static boolean check(String s, int start, int end){
        if(start>=end){
            return true;
        }

        if(s.charAt(start)!=s.charAt(end)){
            return false;
        }

        return check(s,start+1,end-1);
    }
}