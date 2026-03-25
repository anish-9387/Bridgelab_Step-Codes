import java.util.*;

/**
 * CLASS InvalidBookingException
 */
class InvalidBookingException extends Exception{
    public InvalidBookingException(String message){
        super(message);
    }
}

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

    public boolean isValidRoomType(String roomType){
        return inventory.containsKey(roomType);
    }

    public int getAvailableRooms(String roomType){
        return inventory.getOrDefault(roomType,0);
    }

    public void reserveRoom(String roomType){
        int count=inventory.get(roomType);
        inventory.put(roomType, count-1);
    }

    public void displayInventory(){
        System.out.println("Current Inventory:");
        for(Map.Entry<String, Integer> entry : inventory.entrySet()){
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }
}

/**
 * CLASS ReservationValidator
 */
class ReservationValidator{
    public void validate(String guestName, String roomType, RoomInventory inventory) throws InvalidBookingException{
        if(guestName==null || guestName.trim().isEmpty()){
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        if(roomType==null || roomType.trim().isEmpty()){
            throw new InvalidBookingException("Room type cannot be empty.");
        }

        roomType=roomType.toUpperCase();

        if(!inventory.isValidRoomType(roomType)){
            throw new InvalidBookingException("Invalid room type: "+roomType);
        }

        if(inventory.getAvailableRooms(roomType)<=0){
            throw new InvalidBookingException("No rooms available for: "+roomType);
        }
    }
}

/**
 * CLASS BookingRequestQueue
 * Simulates request processing (simple queue)
 */
class BookingRequestQueue{
    private Queue<String> queue=new LinkedList<>();

    public void addRequest(String request){
        queue.offer(request);
    }

    public void processRequests(){
        while(!queue.isEmpty()){
            System.out.println("Processing: "+queue.poll());
        }
    }
}

/**
 * MAIN CLASS
 */
public class BookMyStayApp{
    public static void main(String[] args){
        System.out.println("====== Booking Validation ======");

        Scanner scanner=new Scanner(System.in);

        RoomInventory inventory=new RoomInventory();
        ReservationValidator validator=new ReservationValidator();
        BookingRequestQueue bookingQueue=new BookingRequestQueue();

        try{
            inventory.displayInventory();

            System.out.print("Enter Guest Name: ");
            String guestName=scanner.nextLine();

            System.out.print("Enter Room Type (STANDARD / DELUXE / SUITE): ");
            String roomType=scanner.nextLine();

            validator.validate(guestName,roomType,inventory);

            roomType=roomType.toUpperCase();

            inventory.reserveRoom(roomType);
            bookingQueue.addRequest("Booking confirmed for "+guestName+" ["+roomType+"]");

            System.out.println("Booking successful!");

            bookingQueue.processRequests();

            inventory.displayInventory();

        }
	catch(InvalidBookingException e){
            System.out.println("Booking failed: "+e.getMessage());
        }
	finally{
            scanner.close();
        }
    }
}