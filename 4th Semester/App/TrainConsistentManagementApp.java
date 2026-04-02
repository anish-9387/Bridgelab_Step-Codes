import java.util.HashSet;
import java.util.Set;

/**
 * ============================================================
 * MAIN CLASS – UseCase3TrainConsistMgmt
 * ============================================================
 *
 * Use Case 3: Track Unique Bogie IDs
 *
 * Description:
 * Ensures that duplicate bogie IDs are not added
 * using HashSet (Set interface).
 *
 * - Stores bogie IDs
 * - Prevents duplicates automatically
 * - Displays unique bogie identifiers
 *
 * Author: Anish
 * Version: 3.0
 */
public class TrainConsistentManagementApp{
    public static void main(String[] args){
        System.out.println("=========================================");
        System.out.println("        UC3 - Track Unique Bogie IDs     ");
        System.out.println("=========================================\n");

        Set<String> bogies=new HashSet<>();

        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        bogies.add("BG101");
        bogies.add("BG102");

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogies+"\n");

        System.out.println("Note:");
        System.out.println("Duplicates are automatically ignored by HashSet.\n");

        System.out.println("UC3 uniqueness validation completed......");
    }
}