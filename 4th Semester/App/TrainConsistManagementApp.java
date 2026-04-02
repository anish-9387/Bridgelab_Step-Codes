import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * MAIN CLASS – TrainConsistManagementApp
 * ============================================================
 *
 * Use Case 1: Initialize Train and Display Consist Summary
 *
 * Description:
 * Entry point of the Train Consist Management Application.
 *
 * At this stage, the application:
 * - Creates an empty train consist
 * - Uses a dynamic List to store bogies
 * - Displays initial bogie count
 * - Prints the current state of the train
 *
 * Author: Anish
 * Version: 1.0
 */
public class TrainConsistManagementApp{
    public static void main(String[] args){
        System.out.println("==========================================");
        System.out.println("   === Train Consist Management App ===   ");
        System.out.println("==========================================\n");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully...");

        System.out.println("Initial Bogie Count : "+trainConsist.size());

        System.out.println("Current Train Consist : "+trainConsist);

        System.out.println("\nSystem ready for operations...");
    }
}