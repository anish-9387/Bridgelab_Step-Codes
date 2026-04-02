import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * MAIN CLASS – UseCase2TrainConsistMgmt
 * ============================================================
 *
 * Use Case 2: Add Passenger Bogies to Train
 *
 * Description:
 * Demonstrates dynamic management of passenger bogies
 * using ArrayList operations (CRUD).
 *
 * - Add bogies
 * - Remove bogies
 * - Check existence
 * - Display final consist
 *
 * Author: Anish
 * Version: 2.0
 */
public class TrainConsistentManagementApp{
    public static void main(String[] args){
        System.out.println("=========================================");
        System.out.println("   UC2 - Add Passenger Bogies to Train   ");
        System.out.println("=========================================\n");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies : "+passengerBogies+"\n");

        passengerBogies.remove("AC Chair");

        System.out.println("After Removing 'AC Chair':");
        System.out.println("Passenger Bogies : "+passengerBogies+"\n");

        boolean exists=passengerBogies.contains("Sleeper");

        System.out.println("Checking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper?: "+exists+"\n");

        System.out.println("Final Train Passenger Consist:");
        System.out.println(passengerBogies+"\n");

        System.out.println("UC2 operations completed successfully......");
    }
}