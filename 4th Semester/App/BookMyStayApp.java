import java.util.HashMap;
import java.util.Map;

/**
 * MAIN CLASS - UseCase4RoomSearch
 * Use Case 4: Room Search & Availability Check
 */
public class BookMyStayApp{
    public static void main(String[] args){
        Room singleRoom=new Room("Single", 1, 250, 1500.0);
        Room doubleRoom=new Room("Double", 2, 400, 2500.0);
        Room suiteRoom=new Room("Suite", 3, 750, 5000.0);

        RoomInventory inventory=new RoomInventory();

        RoomSearchService service=new RoomSearchService();

        service.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}

/**
 * Room class (data model)
 */
class Room{
    private String type;
    private int beds;
    private int size;
    private double price;

    public Room(String type, int beds, int size, double price){
        this.type=type;
        this.beds=beds;
        this.size=size;
        this.price=price;
    }

    public int getBeds(){
        return beds;
    }

    public int getSize(){
        return size;
    }

    public double getPrice(){
        return price;
    }
}

/**
 * Inventory class (holds availability)
 */
class RoomInventory{
    private Map<String, Integer> availability;

    public RoomInventory(){
        availability=new HashMap<>();
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability(){
        return availability;
    }
}

/**
 * Service class (search logic)
 */
class RoomSearchService{
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom){
        Map<String, Integer> availability=inventory.getRoomAvailability();

        System.out.println("Room Search\n");

        if(availability.get("Single")>0){
            System.out.println("Single Room:");
            System.out.println("Beds: "+singleRoom.getBeds());
            System.out.println("Size: "+singleRoom.getSize()+" sqft");
            System.out.println("Price per night: "+singleRoom.getPrice());
            System.out.println("Available: "+availability.get("Single"));
            System.out.println();
        }

        if(availability.get("Double")>0){
            System.out.println("Double Room:");
            System.out.println("Beds: "+doubleRoom.getBeds());
            System.out.println("Size: "+doubleRoom.getSize()+" sqft");
            System.out.println("Price per night: "+doubleRoom.getPrice());
            System.out.println("Available: "+availability.get("Double"));
            System.out.println();
        }

        if(availability.get("Suite")>0){
            System.out.println("Suite Room:");
            System.out.println("Beds: "+suiteRoom.getBeds());
            System.out.println("Size: "+suiteRoom.getSize()+" sqft");
            System.out.println("Price per night: "+suiteRoom.getPrice());
            System.out.println("Available: "+availability.get("Suite"));
        }
    }
}