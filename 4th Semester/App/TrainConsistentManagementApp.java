import java.util.LinkedList;
import java.util.List;

/**
 * ============================================================
 * MAIN CLASS – UseCase4TrainConsistMgmt
 * ============================================================
 *
 * Use Case 4: Maintain Ordered Bogie Consist
 *
 * Description:
 * Models physical chaining of train bogies using LinkedList.
 *
 * - Adds bogies in sequence
 * - Inserts at specific position
 * - Removes from front and rear
 * - Displays updated train structure
 *
 * Author: Anish
 * Version: 4.0
 */
public class TrainConsistentManagementApp{
    public static void main(String[] args){
        System.out.println("=========================================");
        System.out.println("   UC4 - Maintain Ordered Bogie Consist  ");
        System.out.println("=========================================\n");

        List<String> trainConsist=new LinkedList<>();

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist+"\n");

        trainConsist.add(2, "Pantry Car");

        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist+"\n");

        ((LinkedList<String>) trainConsist).removeFirst();
        ((LinkedList<String>) trainConsist).removeLast();

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(trainConsist+"\n");

        System.out.println("UC4 ordered consist operations completed......");
    }
}