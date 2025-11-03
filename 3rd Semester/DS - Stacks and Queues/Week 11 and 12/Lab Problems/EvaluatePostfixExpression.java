import java.util.Stack;
import java.util.Scanner;

public class EvaluatePostfixExpression{
    static int evaluatePostfix(String expression){
        Stack<Integer> stack=new Stack<>();
        String[] tokens=expression.split(" ");

        for(String token : tokens){
            if(token.matches("\\d+")){
                stack.push(Integer.parseInt(token));
            }
            else{
                int val2=stack.pop();
                int val1=stack.pop();

                switch (token){
                    case "+":
                        stack.push(val1+val2);
                        break;
                    case "-":
                        stack.push(val1-val2);
                        break;
                    case "*":
                        stack.push(val1*val2);
                        break;
                    case "/":
                        stack.push(val1/val2);
                        break;
                    default:
                        System.out.println("Invalid operator: "+token);
                        return 0;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter postfix expression (space separated): ");
        String expression=input.nextLine();

        int result=evaluatePostfix(expression);
        System.out.println("Result: "+result);
        input.close();
    }
}
