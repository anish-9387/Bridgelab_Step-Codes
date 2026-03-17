import java.util.LinkedList;
import java.util.Queue;

/**
 * ===============================================================
 * CLASS - Reservation
 * ===============================================================
 *
 * Use Case 5: Booking Request (FIFO)
 *
 * Description:
 * This class represents a booking request
 * made by a guest.
 *
 * At this stage, a reservation only captures
 * intent, not confirmation or room allocation.
 *
 * @version 5.0
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
 * ===============================================================
 * CLASS - BookingRequestQueue
 * ===============================================================
 *
 * Use Case 5: Booking Request (FIFO)
 *
 * Description:
 * This class manages booking requests
 * using a queue to ensure fair allocation.
 *
 * Requests are processed strictly
 * in the order they are received.
 *
 * @version 5.0
 */
class BookingRequestQueue{
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue(){
        requestQueue=new LinkedList<>();
    }

    public void addRequest(Reservation reservation){
        requestQueue.offer(reservation);
    }

    public Reservation getNextRequest(){
        return requestQueue.poll();
    }

    public boolean hasPendingRequests(){
        return !requestQueue.isEmpty();
    }
}

/**
 * ===============================================================
 * MAIN CLASS - UseCase5BookingRequestQueue
 * ===============================================================
 *
 * Use Case 5: Booking Request (FIFO)
 *
 * Description:
 * This class demonstrates how booking
 * requests are accepted and queued
 * in a fair and predictable order.
 *
 * No room allocation or inventory
 * update is performed here.
 *
 * @version 5.0
 */
public class BookMyStayApp{
    public static void main(String[] args){
        System.out.println("===== BOOKING REQUEST QUEUE =====\n");

        BookingRequestQueue bookingQueue=new BookingRequestQueue();

        Reservation r1=new Reservation("Abhi", "Single");
        Reservation r2=new Reservation("Subha", "Double");
        Reservation r3=new Reservation("Vanmathi", "Suite");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        System.out.println("Processing booking requests (FIFO):\n");

        while(bookingQueue.hasPendingRequests()){
            Reservation r=bookingQueue.getNextRequest();

            System.out.println("Guest: "+r.getGuestName());
            System.out.println("Requested Room: "+r.getRoomType());
            System.out.println("-----------------------------");
        }
        System.out.println("All requests processed.");
        System.out.println("Application terminated.");
    }
}