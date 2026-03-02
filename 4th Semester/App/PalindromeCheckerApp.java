/**
 * ============================================================
 * MAIN CLASS - PalindromeCheckerApp_Usecase13
 * ============================================================
 *
 * Use Case 13: Full Performance Comparison (UC1 - UC12)
 *
 * Description:
 * This class executes and compares all palindrome
 * validation approaches implemented from UC1 to UC12.
 *
 * It measures execution time using System.nanoTime()
 * and prints benchmarking results.
 *
 * @author Anish
 * @version 13.0
 */

import java.util.*;

public class PalindromeCheckerApp{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("Palindrome Checker App - UC13");
        System.out.println("Full Performance Comparison (UC1-UC12)");
        System.out.println("Version 13.0");
        System.out.println("==========================================");

        System.out.print("Enter String -> ");
        String input=sc.nextLine();

        List<PalindromeStrategy> strategies=Arrays.asList(
                new HardcodedStrategy(),          // UC2
                new ReverseStringStrategy(),      // UC3
                new CharArrayStrategy(),          // UC4
                new StackStrategy(),              // UC5
                new QueueStackStrategy(),         // UC6
                new DequeStrategyImpl(),          // UC7
                new LinkedListStrategy(),         // UC8
                new RecursiveStrategy(),          // UC9
                new CaseInsensitiveStrategy(),    // UC10
                new OOPServiceStrategy(),         // UC11
                new StrategyPatternStack(),       // UC12
                new TwoPointerStrategy()          // Optimized baseline
        );

        for(PalindromeStrategy strategy : strategies){
            long start=System.nanoTime();
            boolean result=strategy.check(input);
            long end=System.nanoTime();

            System.out.println("------------------------------------------");
            System.out.println("Algorithm : "+strategy.getClass().getSimpleName());
            System.out.println("Result    : "+result);
            System.out.println("Time      : "+(end-start)+" ns");
        }
        sc.close();
    }
}

/* ============================================================
   Strategy Interface
   ============================================================ */
interface PalindromeStrategy{
    boolean check(String input);
}

/* ================= UC2 ================= */
class HardcodedStrategy implements PalindromeStrategy{
    public boolean check(String input){
        String str=input;
        String reversed=new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}

/* ================= UC3 ================= */
class ReverseStringStrategy implements PalindromeStrategy{
    public boolean check(String input){
        String reversed="";
        for(int i=input.length()-1; i>=0; i--)
            reversed+=input.charAt(i);
        return input.equals(reversed);
    }
}

/* ================= UC4 ================= */
class CharArrayStrategy implements PalindromeStrategy{
    public boolean check(String input){
        char[] arr=input.toCharArray();
        int left=0, right=arr.length-1;
        while(left<right){
            if(arr[left++]!=arr[right--])
                return false;
        }
        return true;
    }
}

/* ================= UC5 ================= */
class StackStrategy implements PalindromeStrategy{
    public boolean check(String input){
        Stack<Character> stack=new Stack<>();
        for(char c : input.toCharArray())
            stack.push(c);
        for(char c : input.toCharArray())
            if(c!=stack.pop())
                return false;
        return true;
    }
}

/* ================= UC6 ================= */
class QueueStackStrategy implements PalindromeStrategy{
    public boolean check(String input){
        Queue<Character> queue=new LinkedList<>();
        Stack<Character> stack=new Stack<>();
        for(char c : input.toCharArray()){
            queue.add(c);
            stack.push(c);
        }
        while(!queue.isEmpty())
            if(!queue.remove().equals(stack.pop()))
                return false;
        return true;
    }
}

/* ================= UC7 ================= */
class DequeStrategyImpl implements PalindromeStrategy{
    public boolean check(String input){
        Deque<Character> deque=new ArrayDeque<>();
        for(char c : input.toCharArray())
            deque.add(c);
        while(deque.size()>1)
            if(!deque.pollFirst().equals(deque.pollLast()))
                return false;
        return true;
    }
}

/* ================= UC8 ================= */
class LinkedListStrategy implements PalindromeStrategy{
    public boolean check(String input){
        LinkedList<Character> list=new LinkedList<>();
        for(char c : input.toCharArray())
            list.add(c);
        while(list.size()>1)
            if(!list.removeFirst().equals(list.removeLast()))
                return false;
        return true;
    }
}

/* ================= UC9 ================= */
class RecursiveStrategy implements PalindromeStrategy{
    public boolean check(String input){
        return recursiveCheck(input, 0, input.length()-1);
    }

    private boolean recursiveCheck(String str, int left, int right){
        if(left>=right)  return true;
        if(str.charAt(left)!=str.charAt(right))  return false;
        return recursiveCheck(str,left+1,right-1);
    }
}

/* ================= UC10 ================= */
class CaseInsensitiveStrategy implements PalindromeStrategy{
    public boolean check(String input){
        String normalized=input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return new StringBuilder(normalized).reverse().toString().equals(normalized);
    }
}

/* ================= UC11 ================= */
class OOPServiceStrategy implements PalindromeStrategy{
    private final PalindromeService service=new PalindromeService();

    public boolean check(String input){
        return service.checkPalindrome(input);
    }
}

class PalindromeService{
    public boolean checkPalindrome(String input){
        int left=0, right=input.length()-1;
        while(left<right){
            if(input.charAt(left++)!=input.charAt(right--))
                return false;
        }
        return true;
    }
}

/* ================= UC12 ================= */
class StrategyPatternStack implements PalindromeStrategy{
    public boolean check(String input){
        Stack<Character> stack=new Stack<>();
        for(char c : input.toCharArray())
            stack.push(c);
        for(char c : input.toCharArray())
            if(c!=stack.pop())
                return false;
        return true;
    }
}

/* ================= Extra Optimized ================= */
class TwoPointerStrategy implements PalindromeStrategy{
    public boolean check(String input){
        int left=0, right=input.length()-1;
        while(left<right)
            if(input.charAt(left++)!=input.charAt(right--))
                return false;
        return true;
    }
}