import java.util.Stack;
import java.util.Scanner;

public class BalancedParenthesesChecker{
    static boolean isMatchingPair(char open, char close){
        return (open=='(' && close==')') ||
               (open=='{' && close=='}') ||
               (open=='[' && close==']');
    }

    static boolean isBalanced(String expression){
        Stack<Character> stack=new Stack<>();

        for(int i=0; i<expression.length(); i++){
            char ch=expression.charAt(i);

            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }
            else if(ch==')' || ch=='}' || ch==']'){
                if(stack.isEmpty())
                    return false;

                char top=stack.pop();

                if(!isMatchingPair(top,ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter expression: ");
        String expression=input.nextLine();

        if(isBalanced(expression))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");

        input.close();
    }
}
