import java.util.*;
import java.util.stream.Collectors;

/**
 * Use Case 8: Filter Passenger Bogies Using Streams
 * Demonstrates filtering using Java Stream API
 */
public class TrainConsistentManagementApp{
    static class Bogie{
        String name;
        int capacity;

        Bogie(String name, int capacity){
            this.name=name;
            this.capacity=capacity;
        }

        @Override
        public String toString(){
            return name+" -> "+capacity;
        }
    }

    public static void main(String[] args){
        System.out.println("\n========================================");
        System.out.println(" UC8: Filter Passenger Bogies Using Streams ");
        System.out.println("========================================\n");

        List<Bogie> bogies=new ArrayList<>();
        bogies.add(new Bogie("Sleeper",72));
        bogies.add(new Bogie("AC Chair",56));
        bogies.add(new Bogie("First Class",24));
        bogies.add(new Bogie("General",90));

        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        int threshold=60;

        List<Bogie> filteredBogies=bogies.stream().filter(b->b.capacity>threshold).collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (Capacity > "+threshold+"):");
        filteredBogies.forEach(System.out::println);

        System.out.println("\nUC8 Filtering completed......");
    }
}