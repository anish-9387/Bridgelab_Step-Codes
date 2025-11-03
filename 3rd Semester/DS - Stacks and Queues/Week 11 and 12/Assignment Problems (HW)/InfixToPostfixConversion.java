import java.util.Stack;
import java.util.Scanner;

public class InfixToPostfixConversion{
    static int precedence(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String expression){
        StringBuilder result=new StringBuilder();
        Stack<Character> stack=new Stack<>();

        for(int i=0; i<expression.length(); i++){
            char ch=expression.charAt(i);

            if(ch==' ')
                continue;
            if(Character.isLetterOrDigit(ch)){
                result.append(ch);
            }
            else if(ch=='('){
                stack.push(ch);
            }
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    result.append(stack.pop());
                }
                if(!stack.isEmpty() && stack.peek()=='(')
                    stack.pop();
                else
                    return "Invalid Expression";
            }

            else{
                while(!stack.isEmpty() && precedence(ch)<=precedence(stack.peek())){
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while(!stack.isEmpty()){
            if(stack.peek()=='(')
                return "Invalid Expression";
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String expression=input.nextLine();

        String postfix=infixToPostfix(expression);
        System.out.println("Postfix Expression: "+postfix);
        input.close();
    }
}
