import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * UC12: Validate Goods Bogie Safety using Stream allMatch()
 * Rule:
 * Cylindrical bogies must carry ONLY Petroleum
 */
public class TrainConsistentManagementApp{
    static class GoodsBogie{
        String type;
        String cargo;

        public GoodsBogie(String type, String cargo){
            this.type=type;
            this.cargo=cargo;
        }

        @Override
        public String toString(){
            return type+" Bogie carrying "+cargo;
        }
    }

    public static boolean isTrainSafe(List<GoodsBogie> bogies){
        return bogies.stream().allMatch(b->!b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum"));
    }

    public static void main(String[] args){
        System.out.println("=================================");
        System.out.println(" UC12: Goods Train Safety Check ");
        System.out.println("=================================\n");

        List<GoodsBogie> bogies=new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        boolean isSafe=isTrainSafe(bogies);

        System.out.println("Goods Bogies:");
        bogies.forEach(System.out::println);

        if(isSafe)
            System.out.println("\nTrain is SAFETY COMPLIANT");
        else
            System.out.println("\nTrain is NOT SAFE");
    }
}

/* =====================================================
   JUNIT TEST CLASS (Same File)
   ===================================================== */
class TrainSafetyTest{
    @Test
    void testSafety_AllBogiesValid(){
        List<TrainSafetyApp.GoodsBogie> list=Arrays.asList(
                new TrainSafetyApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainSafetyApp.GoodsBogie("Open", "Coal"),
                new TrainSafetyApp.GoodsBogie("Box", "Grain")
        );
        assertTrue(TrainSafetyApp.isTrainSafe(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo(){
        List<TrainSafetyApp.GoodsBogie> list=Arrays.asList(
                new TrainSafetyApp.GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(TrainSafetyApp.isTrainSafe(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed(){
        List<TrainSafetyApp.GoodsBogie> list=Arrays.asList(
                new TrainSafetyApp.GoodsBogie("Open", "Coal"),
                new TrainSafetyApp.GoodsBogie("Box", "Grain")
        );
        assertTrue(TrainSafetyApp.isTrainSafe(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation(){
        List<TrainSafetyApp.GoodsBogie> list=Arrays.asList(
                new TrainSafetyApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainSafetyApp.GoodsBogie("Cylindrical", "Coal"),
                new TrainSafetyApp.GoodsBogie("Open", "Grain")
        );
        assertFalse(TrainSafetyApp.isTrainSafe(list));
    }

    @Test
    void testSafety_EmptyBogieList(){
        List<TrainSafetyApp.GoodsBogie> list=new ArrayList<>();
        assertTrue(TrainSafetyApp.isTrainSafe(list));
    }
}