import java.util.*;

public class PrintQueueSystem{
    public static void main(String[] args){
        Queue<String> printQueue=new LinkedList<>();
        Scanner input=new Scanner(System.in);

        while(true){
            System.out.print("Command (ADD <doc>/PRINT/EXIT): ");
            String cmd=input.next();

            if(cmd.equalsIgnoreCase("ADD")){
                String document=input.next();
                printQueue.add(document);
                System.out.println("Added "+document+" to the queue");
            } 
            else if(cmd.equalsIgnoreCase("PRINT")){
                if(!printQueue.isEmpty()){
                    String doc=printQueue.poll();
                    System.out.println("Printing "+doc);
                }
                else{
                    System.out.println("No jobs left!");
                }
            } 
            else if(cmd.equalsIgnoreCase("EXIT")){
                System.out.println("Exiting Print Queue System......");
                break;
            } 
            else{
                System.out.println("Invalid command!");
            }
        }
        input.close();
    }
}
