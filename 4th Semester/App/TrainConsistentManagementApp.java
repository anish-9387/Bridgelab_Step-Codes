import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * UC13: Compare Loop vs Stream Filtering Performance
 */
public class TrainConsistentManagementApp{
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

    public static List<Bogie> filterWithLoop(List<Bogie> bogies){
        List<Bogie> result=new ArrayList<>();
        for(Bogie b : bogies){
            if(b.capacity>60){
                result.add(b);
            }
        }
        return result;
    }

    public static List<Bogie> filterWithStream(List<Bogie> bogies){
        return bogies.stream().filter(b->b.capacity>60).collect(Collectors.toList());
    }

    public static void main(String[] args){
        System.out.println("=================================");
        System.out.println(" UC13: Loop vs Stream Performance ");
        System.out.println("=================================\n");

        List<Bogie> bogies=new ArrayList<>();
        for(int i=0; i<100000; i++){
            bogies.add(new Bogie("Sleeper", (int)(Math.random() * 100)));
        }

        long startLoop=System.nanoTime();
        List<Bogie> loopResult=filterWithLoop(bogies);
        long endLoop=System.nanoTime();
        long loopTime=endLoop-startLoop;

        long startStream=System.nanoTime();
        List<Bogie> streamResult=filterWithStream(bogies);
        long endStream=System.nanoTime();
        long streamTime=endStream-startStream;

        System.out.println("Loop Filtering Time: "+loopTime+" ns");
        System.out.println("Stream Filtering Time: "+streamTime+" ns");

        System.out.println("\nLoop Result Size: "+loopResult.size());
        System.out.println("Stream Result Size: "+streamResult.size());
    }
}

/* =====================================================
   JUNIT TEST CLASS (Same File)
   ===================================================== */
class PerformanceComparisonTest{
    @Test
    void testLoopFilteringLogic(){
        List<PerformanceComparisonApp.Bogie> list=Arrays.asList(
                new PerformanceComparisonApp.Bogie("A", 50),
                new PerformanceComparisonApp.Bogie("B", 70),
                new PerformanceComparisonApp.Bogie("C", 80)
        );

        List<PerformanceComparisonApp.Bogie> result=PerformanceComparisonApp.filterWithLoop(list);

        assertEquals(2, result.size());
    }

    @Test
    void testStreamFilteringLogic(){
        List<PerformanceComparisonApp.Bogie> list=Arrays.asList(
                new PerformanceComparisonApp.Bogie("A", 40),
                new PerformanceComparisonApp.Bogie("B", 65),
                new PerformanceComparisonApp.Bogie("C", 90)
        );

        List<PerformanceComparisonApp.Bogie> result=PerformanceComparisonApp.filterWithStream(list);

        assertEquals(2, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch(){
        List<PerformanceComparisonApp.Bogie> list=Arrays.asList(
                new PerformanceComparisonApp.Bogie("A", 50),
                new PerformanceComparisonApp.Bogie("B", 70),
                new PerformanceComparisonApp.Bogie("C", 80)
        );

        List<PerformanceComparisonApp.Bogie> loopResult=PerformanceComparisonApp.filterWithLoop(list);

        List<PerformanceComparisonApp.Bogie> streamResult=PerformanceComparisonApp.filterWithStream(list);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement(){
        List<PerformanceComparisonApp.Bogie> list=new ArrayList<>();
        for(int i=0; i<1000; i++){
            list.add(new PerformanceComparisonApp.Bogie("A", i));
        }

        long start=System.nanoTime();
        PerformanceComparisonApp.filterWithLoop(list);
        long end=System.nanoTime();

        long time=end-start;

        assertTrue(time>0);
    }

    @Test
    void testLargeDatasetProcessing(){
        List<PerformanceComparisonApp.Bogie> list=new ArrayList<>();
        for (int i=0; i<100000; i++){
            list.add(new PerformanceComparisonApp.Bogie("A", (int)(Math.random() * 100)));
        }

        List<PerformanceComparisonApp.Bogie> result=PerformanceComparisonApp.filterWithStream(list);

        assertNotNull(result);
    }
}