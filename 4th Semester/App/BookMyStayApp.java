/**
 * ===============================================================
 * ABSTRACT CLASS - Room
 * ===============================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This abstract class represents a generic hotel room.
 *
 * It models attributes that are intrinsic to a room type
 * and remain constant regardless of availability.
 *
 * Inventory-related concerns are intentionally excluded.
 *
 * @version 2.1
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
 *
 * Represents a single room in the hotel.
 *
 * @version 2.1
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
 *
 * Represents a double room in the hotel.
 *
 * @version 2.1
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
 *
 * Represents a suite room in the hotel.
 *
 * @version 2.1
 */
class SuiteRoom extends Room {
    public SuiteRoom(){
        super(3, 750, 5000.0);
    }
}

/**
 *
 * MAIN CLASS - UseCase2RoomInitialization
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This class demonstrates room initialization
 * using domain models before introducing
 * centralized inventory management.
 * Availability is represented using
 * simple variables to highlight limitations.
 *
 * @version 2.1
 */
public class BookMyStayApp{
    public static void main(String[] args){
        Room singleRoom=new SingleRoom();
        Room doubleRoom=new DoubleRoom();
        Room suiteRoom=new SuiteRoom();

        int singleRoomAvailable=5;
        int doubleRoomAvailable=3;
        int suiteRoomAvailable=2;

        System.out.println("===== ROOM DETAILS =====\n");

        System.out.println("Single Room:");
        singleRoom.displayRoomDetails();
        System.out.println("Available: "+singleRoomAvailable);
        System.out.println();

        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: "+doubleRoomAvailable);
        System.out.println();

        System.out.println("Suite Room:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available: "+suiteRoomAvailable);
        System.out.println();

        System.out.println("Application terminated.");
    }
}