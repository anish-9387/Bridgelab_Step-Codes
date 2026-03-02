import java.util.LinkedList;

/**
 * =============================================================
 * MAIN CLASS - PalindromeCheckerApp_Usecase8
 * =============================================================
 *
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * This class validates whether a string is a palindrome
 * using a LinkedList.
 *
 * Characters are added to the list and then compared
 * by removing elements from both ends:
 * - removeFirst()
 * - removeLast()
 *
 * This enables symmetric comparison similar to a Deque.
 *
 * @author Anish
 * @version 8.0
 */

public class UseCase8PalindromeCheckerApp{
    public static void main(String[] args){
        String input="level";

        System.out.println("Input : "+input);

        LinkedList<Character> list=new LinkedList<>();

        for(char c : input.toCharArray()){
            list.add(c);
        }

        boolean isPalindrome=true;

        while(list.size()>1){

            char first=list.removeFirst();
            char last=list.removeLast();

            if(first!=last){
                isPalindrome=false;
                break;
            }
        }

        System.out.println("Is Palindrome? : "+isPalindrome);
    }
}