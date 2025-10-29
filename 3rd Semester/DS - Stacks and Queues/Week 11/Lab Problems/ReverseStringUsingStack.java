import java.util.Stack;
import java.util.Scanner;

public class ReverseStringUsingStack{
    static String reverseString(String str){
        Stack<Character> stack=new Stack<>();

        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
        }

        StringBuilder reversed=new StringBuilder();
        while(!stack.isEmpty()){
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str=input.nextLine();

        String reversed=reverseString(str);
        System.out.println("Reversed String: "+reversed);
        input.close();
    }
}
