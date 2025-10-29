import java.util.Scanner;
import java.util.Stack;

public class StackBasedUndoFeature{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        Stack<String> textStack=new Stack<>();
        String currentText="";
        int choice;

        while(true){
            System.out.println("\n------ Simple Text Editor ------");
            System.out.println("1. Type Text");
            System.out.println("2. Undo Last Action");
            System.out.println("3. Show Current Text");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice=input.nextInt();
            input.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Enter text to append: ");
                    String newText=input.nextLine();
                    textStack.push(currentText);
                    currentText+=newText;
                    System.out.println("Text added successfully");
                    break;

                case 2:
                    if(!textStack.isEmpty()){
                        currentText=textStack.pop();
                        System.out.println("Last action undone");
                    }
                    else{
                        System.out.println("Nothing to undo!");
                    }
                    break;

                case 3:
                    System.out.println("Current Text: \""+currentText+"\"");
                    break;

                case 4:
                    System.out.println("Exiting Text Editor......");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again");
            }
        }
    }
}
