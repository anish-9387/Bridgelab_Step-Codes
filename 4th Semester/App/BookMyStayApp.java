import java.util.*;

/**
 * ============================================================
 * CLASS - Reservation
 * Represents a booking request
 * ============================================================
 */
class Reservation{
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType){
        this.guestName=guestName;
        this.roomType=roomType;
    }

    public String getGuestName(){
        return guestName;
    }

    public String getRoomType(){
        return roomType;
    }
}

/**
 * ============================================================
 * CLASS - RoomInventory
 * Maintains room availability
 * ============================================================
 */
class RoomInventory{
    private Map<String, Integer> inventory;

    public RoomInventory(){
        inventory=new HashMap<>();
    }

    public void addRoomType(String type, int count){
        inventory.put(type, count);
    }

    public boolean isAvailable(String type){
        return inventory.getOrDefault(type, 0)>0;
    }

    public void decrement(String type){
        inventory.put(type, inventory.get(type)-1);
    }

    public void displayInventory(){
        System.out.println("Current Inventory: "+inventory);
    }
}

/**
 * ============================================================
 * CLASS - RoomAllocationService
 * Handles safe allocation of rooms
 * ============================================================
 */
class RoomAllocationService{
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;
    private Map<String, Integer> roomCounters;

    public RoomAllocationService(){
        allocatedRoomIds=new HashSet<>();
        assignedRoomsByType=new HashMap<>();
        roomCounters=new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory){
        String roomType=reservation.getRoomType();

        System.out.println("\nProcessing reservation for: "+reservation.getGuestName());

        if(!inventory.isAvailable(roomType)){
            System.out.println("No rooms available for type: "+roomType);
            return;
        }

        String roomId=generateRoomId(roomType);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType.computeIfAbsent(roomType, k->new HashSet<>()).add(roomId);

        inventory.decrement(roomType);

        System.out.println("Reservation CONFIRMED for "+reservation.getGuestName());
        System.out.println("Room Type: "+roomType+" | Assigned Room ID: "+roomId);
    }

    private String generateRoomId(String roomType){
        int count=roomCounters.getOrDefault(roomType, 0)+1;
        roomCounters.put(roomType, count);

        String roomId=roomType.substring(0, 1).toUpperCase()+count;

        while(allocatedRoomIds.contains(roomId)){
            count++;
            roomCounters.put(roomType, count);
            roomId=roomType.substring(0, 1).toUpperCase()+count;
        }

        return roomId;
    }

    public void displayAllocations(){
        System.out.println("\nAllocated Rooms By Type:");
        for(String type : assignedRoomsByType.keySet()){
            System.out.println(type+" -> "+assignedRoomsByType.get(type));
        }
    }
}

/**
 * ============================================================
 * MAIN CLASS - UseCase6RoomAllocationService
 * ============================================================
 */
public class BookMyStayApp{
    public static void main(String[] args){
        RoomInventory inventory=new RoomInventory();
        inventory.addRoomType("Single", 2);
        inventory.addRoomType("Double", 2);

        Queue<Reservation> bookingQueue=new LinkedList<>();

        bookingQueue.add(new Reservation("Alice", "Single"));
        bookingQueue.add(new Reservation("Bob", "Double"));
        bookingQueue.add(new Reservation("Charlie", "Single"));
        bookingQueue.add(new Reservation("David", "Single"));

        RoomAllocationService allocationService=new RoomAllocationService();

        while(!bookingQueue.isEmpty()){
            Reservation reservation=bookingQueue.poll();
            allocationService.allocateRoom(reservation, inventory);
            inventory.displayInventory();
        }
        allocationService.displayAllocations();
    }
}