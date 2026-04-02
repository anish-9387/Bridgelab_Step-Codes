import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * MAIN CLASS – UseCase6TrainConsistMgmt
 * ============================================================
 *
 * Use Case 6: Map Bogie to Capacity (HashMap)
 *
 * Description:
 * Associates each bogie with its seating or load capacity
 * using key–value mapping.
 *
 * - Creates a HashMap
 * - Inserts bogie-capacity pairs
 * - Iterates through entries
 * - Displays capacity details
 *
 * Author: Anish
 * Version: 6.0
 */
public class TrainConsistentManagementApp{
    public static void main(String[] args){
        System.out.println("===============================================");
        System.out.println(" UC6 - Map Bogie to Capacity (HashMap) ");
        System.out.println("===============================================\n");

        Map<String, Integer> capacityMap=new HashMap<>();

        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);

        System.out.println("Bogie Capacity Details:");

        for(Map.Entry<String, Integer> entry : capacityMap.entrySet()){
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed......");
    }
}