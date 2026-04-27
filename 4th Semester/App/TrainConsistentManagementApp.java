import java.util.*;

public class TrainConsistentManagementApp{
    public static boolean searchBogie(String[] bogieIds, String key){
        if(bogieIds==null || bogieIds.length==0) {
            throw new IllegalStateException("No bogies available for search");
        }

        for(String id : bogieIds){
            if(id.equals(key)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        String[] bogies={};

        try{
            boolean result=searchBogie(bogies, "BG101");
            System.out.println("Search Result: "+result);

        }
        catch(IllegalStateException e){
            System.out.println("Error: "+e.getMessage());
        }

        System.out.println("Program continues safely...");
    }
}