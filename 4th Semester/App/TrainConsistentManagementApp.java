import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ============================================================
 * MAIN CLASS – UseCase7TrainConsistMgmt
 * ============================================================
 *
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 *
 * Description:
 * Sorts passenger bogies based on seating capacity
 * using a custom Comparator.
 *
 * - Creates bogie objects
 * - Stores them in a list
 * - Displays unsorted data
 * - Sorts using Comparator
 * - Displays sorted result
 *
 * Author: Anish
 * Version: 7.0
 */
public class TrainConsistentManagementApp{
    static class Bogie{
        String name;
        int capacity;

        Bogie(String name, int capacity){
            this.name=name;
            this.capacity=capacity;
        }
    }

    public static void main(String[] args){
        System.out.println("===============================================");
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator) ");
        System.out.println("===============================================\n");

        List<Bogie> bogies=new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        for(Bogie b : bogies){
            System.out.println(b.name+" -> "+b.capacity);
        }

        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity:");
        for(Bogie b : bogies){
            System.out.println(b.name+" -> "+b.capacity);
        }

        System.out.println("\nUC7 sorting completed......");
    }
}