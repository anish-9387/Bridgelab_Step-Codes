/**
 * MAIN CLASS - PalindromeCheckerApp_Usecase12
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * At this stage, the application:
 * - Defines a common PalindromeStrategy interface
 * - Implements a concrete Stack-based strategy
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 *
 * No performance comparison is done in this use case.
 * The focus is purely on algorithm interchangeability.
 *
 * The goal is to teach extensible algorithm design.
 *
 * @author Anish
 * @version 12.0
 */

import java.util.Scanner;

public class UC12PallindromeCheckerApp{
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter String -> ");
        String input=sc.nextLine();

        PalindromeStrategy strategy=new StackStrategy();

        boolean result=strategy.check(input);

        System.out.println("Input : "+input);
        System.out.println("Is Palindrome? : "+result);

        sc.close();
    }
}

interface PalindromeStrategy{
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy{
    public boolean check(String input){
        String normalized=input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        java.util.Stack<Character> stack=new java.util.Stack<>();

        for(char c : normalized.toCharArray()){
            stack.push(c);
        }

        for(char c : normalized.toCharArray()){
            if(c != stack.pop()){
                return false;
            }
        }
        return true;
    }
}