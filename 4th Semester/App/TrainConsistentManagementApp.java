import java.util.*;

public class TrainConsistentManagementApp{
    public static void sortBogieNames(String[] bogieNames){
        Arrays.sort(bogieNames);    }

    public static void main(String[] args){
        String[] bogies={"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogies));

        sortBogieNames(bogies);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(bogies));
    }
}