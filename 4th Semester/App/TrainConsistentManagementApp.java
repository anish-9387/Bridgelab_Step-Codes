import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * UC9: Map + Reduce using Java Streams
 * Goal: Calculate total seating capacity of passenger bogies
 */

public class UC9TrainConsistApp{
    static class Bogie{
        String type;
        int capacity;

        public Bogie(String type, int capacity){
            this.type=type;
            this.capacity=capacity;
        }

        @Override
        public String toString(){
            return type+" Bogie-Capacity: "+capacity;
        }
    }

    public static int calculateTotalSeats(List<Bogie> bogies){
        return bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
    }

    public static void main(String[] args){
        System.out.println("========================================");
        System.out.println(" UC9: Map & Reduce Passenger Bogies ");
        System.out.println("========================================\n");

        List<Bogie> bogies=new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 60));
        bogies.add(new Bogie("AC Chair", 75));
        bogies.add(new Bogie("First Class", 50));
        bogies.add(new Bogie("AC Chair", 65));

        int totalSeats=calculateTotalSeats(bogies);

        System.out.println("Total Seating Capacity: "+totalSeats);

        System.out.println("\nOriginal Bogie List:");
        bogies.forEach(System.out::println);

        System.out.println("\nUC9 Map+Reduce completed......");
    }
}

class ReduceTest{
    private int calculateTotalSeats(List<UC9TrainConsistApp.Bogie> bogies){
        return UC9TrainConsistApp.calculateTotalSeats(bogies);
    }

    @Test
    void testReduce_TotalSeatCalculation(){
        List<UC9TrainConsistApp.Bogie> list=Arrays.asList(
                new UC9TrainConsistApp.Bogie("Sleeper", 70),
                new UC9TrainConsistApp.Bogie("AC", 80),
                new UC9TrainConsistApp.Bogie("FC", 50)
        );
        assertEquals(200, calculateTotalSeats(list));
    }

    @Test
    void testReduce_MultipleBogiesAggregation(){
        List<UC9TrainConsistApp.Bogie> list=Arrays.asList(
                new UC9TrainConsistApp.Bogie("Sleeper", 60),
                new UC9TrainConsistApp.Bogie("AC", 75),
                new UC9TrainConsistApp.Bogie("FC", 65)
        );
        assertEquals(200, calculateTotalSeats(list));
    }

    @Test
    void testReduce_SingleBogieCapacity(){
        List<UC9TrainConsistApp.Bogie> list=Collections.singletonList(new UC9TrainConsistApp.Bogie("Sleeper", 90));
        assertEquals(90, calculateTotalSeats(list));
    }

    @Test
    void testReduce_EmptyBogieList(){
        List<UC9TrainConsistApp.Bogie> list=new ArrayList<>();
        assertEquals(0, calculateTotalSeats(list));
    }

    @Test
    void testReduce_CorrectCapacityExtraction(){
        List<UC9TrainConsistApp.Bogie> list=Arrays.asList(
                new UC9TrainConsistApp.Bogie("Sleeper", 40),
                new UC9TrainConsistApp.Bogie("AC", 60)
        );
        assertEquals(100, calculateTotalSeats(list));
    }

    @Test
    void testReduce_AllBogiesIncluded(){
        List<UC9TrainConsistApp.Bogie> list=Arrays.asList(
                new UC9TrainConsistApp.Bogie("Sleeper", 50),
                new UC9TrainConsistApp.Bogie("AC", 50),
                new UC9TrainConsistApp.Bogie("FC", 50)
        );
        assertEquals(150, calculateTotalSeats(list));
    }

    @Test
    void testReduce_OriginalListUnchanged(){
        List<UC9TrainConsistApp.Bogie> list=new ArrayList<>();
        list.add(new UC9TrainConsistApp.Bogie("Sleeper", 70));
        list.add(new UC9TrainConsistApp.Bogie("AC", 80));

        int originalSize=list.size();
        calculateTotalSeats(list);

        assertEquals(originalSize, list.size());
        assertEquals(2, list.size());
    }
}