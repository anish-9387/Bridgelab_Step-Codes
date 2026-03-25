import java.util.*;

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

class BookingRequestQueue{
    private Queue<Reservation> queue=new LinkedList<>();

    public void addRequest(Reservation r){
        queue.add(r);
    }

    public Reservation getNextRequest(){
        return queue.poll();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}

class RoomInventory{
    private Map<String, Integer> rooms=new HashMap<>();

    public RoomInventory(){
        rooms.put("Single",5);
        rooms.put("Double",3);
        rooms.put("Suite",1);
    }

    public boolean allocateRoom(String roomType){
        int count=rooms.getOrDefault(roomType,0);

        if(count > 0){
            rooms.put(roomType,count-1);
            return true;
        }
        return false;
    }

    public void printInventory(){
        System.out.println("\nRemaining Inventory:");
        for(String type : rooms.keySet()){
            System.out.println(type+": "+rooms.get(type));
        }
    }
}

class RoomAllocationService{
    public void allocateRoom(Reservation reservation, RoomInventory inventory){
        boolean success=inventory.allocateRoom(reservation.getRoomType());

        if(success){
            String roomId=reservation.getRoomType()+"-"+UUID.randomUUID().toString().substring(0,1);

            System.out.println("Booking confirmed for Guest: "+reservation.getGuestName()+", Room ID: "+roomId);
        }
	else{
            System.out.println("Booking failed for Guest: "+reservation.getGuestName()+" (No rooms available)");
        }
    }
}

class ConcurrentBookingProcessor implements Runnable{
    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(BookingRequestQueue bookingQueue, RoomInventory inventory, RoomAllocationService allocationService){
        this.bookingQueue=bookingQueue;
        this.inventory=inventory;
        this.allocationService=allocationService;
    }

    @Override
    public void run(){
        while(true){
            Reservation reservation;
            synchronized(bookingQueue){
                if(bookingQueue.isEmpty()){
                    break;
                }
                reservation=bookingQueue.getNextRequest();
            }

            synchronized(inventory){
                allocationService.allocateRoom(reservation,inventory);
            }
        }
    }
}

public class BookMyStayApp{
    public static void main(String[] args){
        System.out.println("Concurrent Booking Simulation");
        BookingRequestQueue bookingQueue=new BookingRequestQueue();
        RoomInventory inventory=new RoomInventory();
        RoomAllocationService allocationService=new RoomAllocationService();

        bookingQueue.addRequest(new Reservation("Abhi","Single"));
        bookingQueue.addRequest(new Reservation("Vanmathi","Double"));
        bookingQueue.addRequest(new Reservation("Kural","Suite"));
        bookingQueue.addRequest(new Reservation("Subha","Single"));


        Thread t1=new Thread(new ConcurrentBookingProcessor(bookingQueue,inventory,allocationService));

        Thread t2=new Thread(new ConcurrentBookingProcessor(bookingQueue,inventory,allocationService));

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
	catch(InterruptedException e){
            System.out.println("Thread execution interrupted.");
        }
        inventory.printInventory();
    }
}