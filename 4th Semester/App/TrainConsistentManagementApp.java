import java.util.*;

public class TrainConsistentManagementApp{
    public static boolean searchBogie(String[] bogieIds, String key){
        for(String id : bogieIds){
            if(id.equals(key)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        String[] bogies={"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchKey="BG309";

        System.out.println("Searching for: "+searchKey);

        boolean found=searchBogie(bogies, searchKey);

        if(found){
            System.out.println("Bogie found!");
        }
        else{
            System.out.println("Bogie not found.");
        }
    }
}