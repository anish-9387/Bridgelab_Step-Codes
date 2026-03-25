import java.util.*;

/**
 * ============================================================
 * CLASS - Reservation
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
 * ============================================================
 */
class RoomInventory{
    private Map<String, Integer> inventory;

    public RoomInventory(){
        inventory=new HashMap<>();
    }

    public void addRoomType(String type, int count){
        inventory.put(type,count);
    }

    public boolean isAvailable(String type){
        return inventory.getOrDefault(type,0)>0;
    }

    public void decrement(String type){
        inventory.put(type,inventory.get(type)-1);
    }

    public void increment(String type){
        inventory.put(type,inventory.get(type)+1);
    }

    public void displayInventory(){
        System.out.println("Current Inventory: "+inventory);
    }
}

/**
 * ============================================================
 * CLASS - RoomAllocationService
 * ============================================================
 */
class RoomAllocationService{
    private Map<String, String> activeBookings;
    private Map<String, String> roomTypeByRoomId;
    private Stack<String> rollbackStack;
    private Set<String> allocatedRoomIds;
    private Map<String, Integer> roomCounters;

    public RoomAllocationService(){
        activeBookings=new HashMap<>();
        roomTypeByRoomId=new HashMap<>();
        rollbackStack=new Stack<>();
        allocatedRoomIds=new HashSet<>();
        roomCounters=new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory){
        String guest=reservation.getGuestName();
        String type=reservation.getRoomType();

        System.out.println("\nProcessing reservation for: "+guest);

        if(!inventory.isAvailable(type)){
            System.out.println("No rooms available for type: "+type);
            return;
        }

        String roomId=generateRoomId(type);

        allocatedRoomIds.add(roomId);
        activeBookings.put(guest,roomId);
        roomTypeByRoomId.put(roomId,type);

        inventory.decrement(type);

        System.out.println("Reservation CONFIRMED for "+guest);
        System.out.println("Room Type: "+type+" | Room ID: "+roomId);
    }

    public void cancelBooking(String guest, RoomInventory inventory){
        System.out.println("\nCancellation request for: "+guest);

        if(!activeBookings.containsKey(guest)){
            System.out.println("Cancellation FAILED: No active booking found.");
            return;
        }

        String roomId=activeBookings.get(guest);
        String roomType=roomTypeByRoomId.get(roomId);

        rollbackStack.push(roomId);

        activeBookings.remove(guest);
        roomTypeByRoomId.remove(roomId);
        allocatedRoomIds.remove(roomId);

        inventory.increment(roomType);

        System.out.println("Booking CANCELLED for "+guest);
        System.out.println("Room Released: "+roomId);
    }

    private String generateRoomId(String type){
        int count=roomCounters.getOrDefault(type,0)+1;
        roomCounters.put(type,count);

        String id=type.substring(0,1).toUpperCase()+count;

        while(allocatedRoomIds.contains(id)){
            count++;
            roomCounters.put(type,count);
            id=type.substring(0,1).toUpperCase()+count;
        }

        return id;
    }

    public void showRollbackStack(){
        System.out.println("\nRollback Stack (Recent cancellations): "+rollbackStack);
    }

    public void displayActiveBookings(){
        System.out.println("\nActive Bookings: "+activeBookings);
    }
}

/**
 * ============================================================
 * MAIN CLASS
 * ============================================================
 */
public class BookMyStayApp{
    public static void main(String[] args){
        RoomInventory inventory=new RoomInventory();
        inventory.addRoomType("Single",2);
        inventory.addRoomType("Double",2);

        RoomAllocationService service=new RoomAllocationService();

        service.allocateRoom(new Reservation("Alice","Single"),inventory);
        service.allocateRoom(new Reservation("Bob","Double"),inventory);
        service.allocateRoom(new Reservation("Charlie","Single"),inventory);

        inventory.displayInventory();
        service.displayActiveBookings();

        service.cancelBooking("Alice", inventory);
        service.cancelBooking("David", inventory);

        inventory.displayInventory();
        service.displayActiveBookings();
        service.showRollbackStack();
    }
}