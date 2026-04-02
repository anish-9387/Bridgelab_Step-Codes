import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ============================================================
 * MAIN CLASS – UseCase5TrainConsistMgmt
 * ============================================================
 *
 * Use Case 5: Preserve Insertion Order of Bogies
 *
 * Description:
 * Maintains the exact attachment order of bogies
 * while preventing duplicates using LinkedHashSet.
 *
 * - Attaches bogies in order
 * - Preserves insertion sequence
 * - Avoids duplicate bogies
 * - Displays final train formation
 *
 * Author: Anish
 * Version: 5.0
 */
public class TrainConsistentManagementApp{
    public static void main(String[] args){
        System.out.println("=========================================");
        System.out.println(" UC5 - Preserve Insertion Order of Bogies ");
        System.out.println("=========================================\n");

        Set<String> formation=new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        formation.add("Sleeper");

        System.out.println("Final Train Formation:");
        System.out.println(formation+"\n");

        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.\n");

        System.out.println("UC5 formation setup completed......");
    }
}