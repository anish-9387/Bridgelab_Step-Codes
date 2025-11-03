import java.util.*;

public class BrowserNavigation{
    public static void main(String[] args){
        Stack<String> backStack=new Stack<>();
        Stack<String> forwardStack=new Stack<>();
        Scanner input=new Scanner(System.in);
        String current="Home";

        while(true){
            System.out.print("Command (VISIT/BACK/FORWARD/PRINT/EXIT): ");
            String cmd=input.next();

            if(cmd.equalsIgnoreCase("VISIT")){
                backStack.push(current);
                current=input.next();
                forwardStack.clear();
            } 
            else if(cmd.equalsIgnoreCase("BACK")){
                if(!backStack.isEmpty()){
                    forwardStack.push(current);
                    current=backStack.pop();
                }
                else{
                    System.out.println("No previous page!");
                }
            } 
            else if(cmd.equalsIgnoreCase("FORWARD")){
                if(!forwardStack.isEmpty()){
                    backStack.push(current);
                    current=forwardStack.pop();
                }
                else{
                    System.out.println("No forward page!");
                }
            } 
            else if(cmd.equalsIgnoreCase("PRINT")){
                System.out.println("Current Page: "+current);
            } 
            else if(cmd.equalsIgnoreCase("EXIT")){
                System.out.println("Exiting browser simulation......");
                break;
            } 
            else{
                System.out.println("Invalid command!");
            }
        }
        input.close();
    }
}
