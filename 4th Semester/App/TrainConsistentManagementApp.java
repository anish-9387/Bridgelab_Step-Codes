import java.util.*;

public class TrainConsistentManagementApp{
    public static boolean binarySearch(String[] bogieIds, String key){
        if(bogieIds==null || bogieIds.length==0){
            return false;
        }

        Arrays.sort(bogieIds);

        int low=0;
        int high=bogieIds.length-1;

        while(low<=high){
            int mid=(low+high)/2;

            int comparison=bogieIds[mid].compareTo(key);

            if(comparison==0){
                return true;
            }
            else if(comparison<0){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        String[] bogies={"BG309","BG101","BG550","BG205","BG412"};

        String searchKey="BG205";

        System.out.println("Searching for: "+searchKey);

        boolean found=binarySearch(bogies, searchKey);

        if(found){
            System.out.println("Bogie found!");
        }
        else{
            System.out.println("Bogie not found.");
        }
    }
}