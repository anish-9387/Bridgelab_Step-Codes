import java.util.*;

public class TextEditorUndo{
    public static void main(String[] args){
        Stack<String> stack=new Stack<>();
        Scanner input=new Scanner(System.in);

        while(true){
            System.out.print("Enter command (TYPE <word>/UNDO/PRINT/EXIT): ");
            String cmd=input.next();

            if(cmd.equalsIgnoreCase("TYPE")){
                String word=input.next();
                stack.push(word);
            } 
            else if(cmd.equalsIgnoreCase("UNDO")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    System.out.println("Nothing to undo!");
                }
            } 
            else if(cmd.equalsIgnoreCase("PRINT")){
                if(stack.isEmpty()){
                    System.out.println("(empty)");
                }
                else{
                    for(String word : stack){
                        System.out.print(word+" ");
                    }
                    System.out.println();
                }
            } 
            else if(cmd.equalsIgnoreCase("EXIT")){
                System.out.println("Exiting editor......");
                break;
            } 
            else{
                System.out.println("Invalid command!");
            }
        }
        input.close();
    }
}
