import java.util.HashMap;
import java.util.Map;

/**
 * ===============================================================
 * ABSTRACT CLASS - Room
 * ===============================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * @version 3.1
 */
abstract class Room{
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight){
        this.numberOfBeds=numberOfBeds;
        this.squareFeet=squareFeet;
        this.pricePerNight=pricePerNight;
    }

    public void displayRoomDetails(){
        System.out.println("Beds: "+numberOfBeds);
        System.out.println("Size: "+squareFeet+" sq.ft");
        System.out.println("Price per night: ₹"+pricePerNight);
    }
}

/**
 * ===============================================================
 * CLASS - SingleRoom
 * ===============================================================
 */
class SingleRoom extends Room{
    public SingleRoom(){
        super(1, 250, 1500.0);
    }
}

/**
 * ===============================================================
 * CLASS - DoubleRoom
 * ===============================================================
 */
class DoubleRoom extends Room{
    public DoubleRoom(){
        super(2, 400, 2500.0);
    }
}

/**
 * ===============================================================
 * CLASS - SuiteRoom
 * ===============================================================
 */
class SuiteRoom extends Room{
    public SuiteRoom(){
        super(3, 750, 5000.0);
    }
}

/**
 * ===============================================================
 * CLASS - RoomInventory
 * ===============================================================
 *
 * Acts as centralized inventory using HashMap
 *
 * @version 3.1
 */
class RoomInventory{
    private Map<String, Integer> roomAvailability;

    public RoomInventory(){
        roomAvailability=new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory(){
        roomAvailability.put("SingleRoom", 5);
        roomAvailability.put("DoubleRoom", 3);
        roomAvailability.put("SuiteRoom", 2);
    }

    public Map<String, Integer> getRoomAvailability(){
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count){
        roomAvailability.put(roomType, count);
    }
}

/**
 * ===============================================================
 * MAIN CLASS - UseCase3InventorySetup
 * ===============================================================
 *
 * @version 3.1
 */
public class BookMyStayApp{
    public static void main(String[] args){
        Room singleRoom=new SingleRoom();
        Room doubleRoom=new DoubleRoom();
        Room suiteRoom=new SuiteRoom();

        RoomInventory inventory=new RoomInventory();

        System.out.println("===== CENTRALIZED ROOM INVENTORY =====\n");

        System.out.println("Single Room:");
        singleRoom.displayRoomDetails();
        System.out.println("Available: "+inventory.getRoomAvailability().get("SingleRoom"));
        System.out.println();

        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: "+inventory.getRoomAvailability().get("DoubleRoom"));
        System.out.println();

        System.out.println("Suite Room:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available: "+inventory.getRoomAvailability().get("SuiteRoom"));
        System.out.println();

        System.out.println("Updating SingleRoom availability...\n");
        inventory.updateAvailability("SingleRoom", 4);

        System.out.println("Updated Availability: "+inventory.getRoomAvailability().get("SingleRoom"));

        System.out.println("\nApplication terminated.");
    }
}