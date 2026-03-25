import java.io.*;
import java.util.*;

/**
 * CLASS RoomInventory
 * Maintains room availability
 */
class RoomInventory{
    private Map<String, Integer> inventory;

    public RoomInventory(){
        inventory=new HashMap<>();
        inventory.put("STANDARD",2);
        inventory.put("DELUXE",2);
        inventory.put("SUITE",1);
    }

    public Map<String, Integer> getInventory(){
        return inventory;
    }

    public void setInventory(Map<String, Integer> newInventory){
        this.inventory=newInventory;
    }

    public void displayInventory(){
        System.out.println("Current Inventory:");
        for(Map.Entry<String, Integer> entry : inventory.entrySet()){
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }
}

/**
 * CLASS FilePersistenceService
 */
class FilePersistenceService{
    public void saveInventory(RoomInventory inventory, String filePath){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(filePath))){
            for(Map.Entry<String, Integer> entry : inventory.getInventory().entrySet()){
                writer.write(entry.getKey()+"="+entry.getValue());
                writer.newLine();
            }
            System.out.println("Inventory saved successfully.");

        }
	catch(IOException e){
            System.out.println("Error saving inventory: "+e.getMessage());
        }
    }

    public void loadInventory(RoomInventory inventory, String filePath){
        File file=new File(filePath);

        if(!file.exists()){
            System.out.println("No persistence file found. Starting fresh.");
            return;
        }

        Map<String, Integer> loadedInventory=new HashMap<>();

        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            String line;

            while((line=reader.readLine())!=null){
                String[] parts=line.split("=");

                if(parts.length!=2){
                    System.out.println("Skipping invalid line: "+line);
                    continue;
                }

                String roomType=parts[0];
                int count=Integer.parseInt(parts[1]);

                loadedInventory.put(roomType,count);
            }

            inventory.setInventory(loadedInventory);
            System.out.println("Inventory loaded successfully.");

        }
	catch(IOException | NumberFormatException e){
            System.out.println("Error loading inventory. Starting with default state.");
        }
    }
}

/**
 * MAIN CLASS
 */
public class BookMyStayApp{
    public static void main(String[] args){
        System.out.println("====== Data Persistence & Recovery ======");

        String filePath="inventory.txt";

        RoomInventory inventory=new RoomInventory();
        FilePersistenceService persistenceService=new FilePersistenceService();

        persistenceService.loadInventory(inventory,filePath);

        inventory.displayInventory();

        System.out.println("\nSimulating booking: Reserving 1 STANDARD room...");
        Map<String, Integer> map=inventory.getInventory();

        if(map.get("STANDARD")>0){
            map.put("STANDARD", map.get("STANDARD")-1);
        }

        inventory.displayInventory();

        persistenceService.saveInventory(inventory,filePath);

        System.out.println("\nRestart the program to see recovery in action.");
    }
}