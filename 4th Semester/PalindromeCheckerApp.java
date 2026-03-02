import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * =============================================================
 * MAIN CLASS - PalindromeCheckerApp_Usecase6
 * =============================================================
 *
 * Use Case 6: Queue + Stack Fairness Check
 *
 * Description:
 * This class demonstrates palindrome validation using
 * two different data structures:
 *
 * - Queue (FIFO - First In First Out)
 * - Stack (LIFO - Last In First Out)
 *
 * Characters are inserted into both structures and then
 * compared by removing from the front of the queue and
 * the top of the stack.
 *
 * If all characters match, the input string is confirmed
 * as a palindrome.
 *
 * @author Anish
 * @version 6.0
 */

public class UseCase6PalindromeCheckerApp{
    public static void main(String[] args){
        String input="civic";

        Queue<Character> queue=new LinkedList<>();

        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()){
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome=true;

        while(!queue.isEmpty()){
            if(!queue.remove().equals(stack.pop())){
                isPalindrome=false;
                break;
            }
        }

        System.out.println("Input : "+input);
        System.out.println("Is Palindrome? : "+isPalindrome);
    }
}