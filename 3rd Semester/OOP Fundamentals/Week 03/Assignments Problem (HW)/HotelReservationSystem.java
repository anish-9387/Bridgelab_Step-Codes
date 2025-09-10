import java.time.LocalDate;
import java.time.format.DateTimeParseException;

class Room{
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    private int maxOccupancy;
    private int timesBooked;

    public Room(String roomNumber, String roomType, double pricePerNight, int maxOccupancy){
        this.roomNumber=roomNumber;
        this.roomType=roomType;
        this.pricePerNight=pricePerNight;
        this.maxOccupancy=maxOccupancy;
        this.isAvailable=true;
        this.timesBooked=0;
    }

    public String getRoomNumber(){ return roomNumber; }
    public String getRoomType(){ return roomType; }
    public double getPricePerNight(){ return pricePerNight; }
    public boolean isAvailable(){ return isAvailable; }
    public int getMaxOccupancy(){ return maxOccupancy; }
    public int getTimesBooked(){ return timesBooked; }

    public void setAvailable(boolean available){ this.isAvailable=available; }
    public void incrementTimesBooked(){ this.timesBooked++; }

    public void displayRoomInfo(){
        System.out.println("Room "+roomNumber+" | Type: "+roomType+" | Price/Night: $"+pricePerNight+" | Max Occ: "+maxOccupancy+" | Available: "+(isAvailable ? "Yes" : "No"));
    }
}

class Guest{
    private String guestId;
    private String guestName;
    private String phoneNumber;
    private String email;
    private String[] bookingHistory;
    private int bookingCount;

    private static int guestCounter=0;

    public Guest(String guestName, String phoneNumber, String email, int maxHistory){
        this.guestId=generateGuestId();
        this.guestName=guestName;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.bookingHistory=new String[maxHistory];
        this.bookingCount=0;
    }

    private static String generateGuestId(){
        guestCounter++;
        return String.format("G%03d",guestCounter);
    }

    public String getGuestId(){ return guestId; }
    public String getGuestName(){ return guestName; }

    public void addBookingToHistory(String bookingId){
        if(bookingCount<bookingHistory.length){
            bookingHistory[bookingCount++]=bookingId;
        }
        else{
            for(int i=1; i<bookingHistory.length; i++)  bookingHistory[i-1]=bookingHistory[i];
            bookingHistory[bookingHistory.length-1]=bookingId;
        }
    }

    public void displayGuestInfo(){
        System.out.println("Guest ID: "+guestId+" | Name: "+guestName+" | Phone: "+phoneNumber+" | Email: "+email);
        System.out.print("Booking History: ");
        if(bookingCount==0)  System.out.print("None");
        else{
            for(int i=0; i<bookingCount; i++){
                System.out.print(bookingHistory[i]+(i<bookingCount-1 ? ", " : ""));
            }
        }
        System.out.println();
    }
}

class Booking{
    private String bookingId;
    private Guest guest;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private double totalAmount;
    private boolean active;

    private static int bookingCounter=0;

    public Booking(Guest guest, Room room, String checkInDate, String checkOutDate){
        this.bookingId=generateBookingId();
        this.guest=guest;
        this.room=room;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
        this.totalAmount=0.0;
        this.active=true;
    }

    private static String generateBookingId(){
        bookingCounter++;
        return String.format("B%04d",bookingCounter);
    }

    public int calculateNights() throws DateTimeParseException{
        LocalDate in=LocalDate.parse(checkInDate);
        LocalDate out=LocalDate.parse(checkOutDate);
        int nights=(int)(out.toEpochDay()-in.toEpochDay());
        return Math.max(nights,0);
    }

    public void calculateBill(){
        try{
            int nights=calculateNights();
            this.totalAmount=nights*room.getPricePerNight();
        }
        catch(DateTimeParseException e){
            System.out.println("Invalid date format for booking "+bookingId);
            this.totalAmount=0.0;
        }
    }

    public String getBookingId(){ return bookingId; }
    public Guest getGuest(){ return guest; }
    public Room getRoom(){ return room; }
    public double getTotalAmount(){ return totalAmount; }
    public boolean isActive(){ return active; }

    public void cancel(){
        if(!active){
            System.out.println("Booking "+bookingId+" is already inactive");
            return;
        }
        active=false;
        room.setAvailable(true);
        System.out.println("Booking "+bookingId+" cancelled");
    }

    public void checkOut(){
        if(!active){
            System.out.println("Booking "+bookingId+" is not active");
            return;
        }
        active=false;
        room.setAvailable(true);
        Hotel.incrementRevenue(totalAmount);
        Hotel.incrementTotalBookings();
        room.incrementTimesBooked();
        guest.addBookingToHistory(bookingId);
        System.out.println("Checked out booking "+bookingId+". Amount paid: $"+totalAmount);
    }

    public void displayBooking(){
        System.out.println("Booking ID: "+bookingId);
        System.out.println(" Guest: "+guest.getGuestName()+" ("+guest.getGuestId()+")");
        System.out.println(" Room: "+room.getRoomNumber()+" ("+room.getRoomType()+")");
        System.out.println(" Check-in: "+checkInDate+" | Check-out: "+checkOutDate);
        System.out.println(" Total Amount: $"+totalAmount);
        System.out.println(" Active: "+(active ? "Yes" : "No"));
        System.out.println("---------------------------");
    }
}

class Hotel{
    public static String hotelName;
    private static int totalBookings=0;
    private static double hotelRevenue=0.0;

    public static void setHotelName(String name){
        hotelName=name;
    }
    public static int getTotalBookings(){ return totalBookings; }
    public static double getHotelRevenue(){ return hotelRevenue; }
    public static void incrementTotalBookings(){ totalBookings++; }
    public static void incrementRevenue(double amount){ hotelRevenue+=amount; }

    public static boolean checkAvailability(Room room){
        return room.isAvailable();
    }

    public static Room findAvailableRoomByType(Room[] rooms, String roomType, int requiredOccupancy){
        for(Room r : rooms){
            if(r!=null && r.getRoomType().equalsIgnoreCase(roomType) && r.isAvailable() && r.getMaxOccupancy()>=requiredOccupancy){
                return r;
            }
        }
        return null;
    }

    public static double getOccupancyRate(Room[] rooms, Booking[] bookings){
        int totalRooms=0;
        int bookedRooms=0;
        for(Room r : rooms)  if(r!=null)  totalRooms++;
        for(Booking b : bookings)  if(b!=null && b.isActive())  bookedRooms++;
        if(totalRooms==0)  return 0.0;
        return (bookedRooms*100.0)/totalRooms;
    }

    public static String getMostPopularRoomType(Room[] rooms){
        if(rooms==null || rooms.length==0)  return "N/A";
        java.util.Map<String, Integer> map=new java.util.HashMap<>();
        for(Room r : rooms){
            if(r==null)  continue;
            map.put(r.getRoomType(), map.getOrDefault(r.getRoomType(), 0) + r.getTimesBooked());
        }
        String bestType="N/A";
        int max=-1;
        for(String type : map.keySet()){
            int v=map.get(type);
            if(v>max){ max=v; bestType=type; }
        }
        return bestType;
    }
}

public class HotelReservationSystem{
    public static void main(String[] args){
        Hotel.setHotelName("Seaside Grand Hotel");
        System.out.println("Welcome to "+Hotel.hotelName+"\n");

        Room[] rooms=new Room[8];
        rooms[0]=new Room("101","Single",80.0,1);
        rooms[1]=new Room("102","Single",85.0,1);
        rooms[2]=new Room("201","Double",120.0,2);
        rooms[3]=new Room("202", "Double",130.0,2);
        rooms[4]=new Room("301","Suite",250.0,4);
        rooms[5]=new Room("302","Suite",270.0,4);
        rooms[6]=new Room("401","Family",180.0,3);
        rooms[7]=new Room("402","Double",125.0,2);

        System.out.println("Available Rooms:");
        for(Room r : rooms)  r.displayRoomInfo();
        System.out.println();

        Guest[] guests=new Guest[3];
        guests[0]=new Guest("Alice Johnson","999-111-2222","alice@example.com",5);
        guests[1]=new Guest("Bob Smith","999-222-3333","bob@example.com",5);
        guests[2]=new Guest("Carol Lee","999-333-4444","carol@example.com",5);

        Booking[] bookings=new Booking[10];
        int bookingIndex=0;

        System.out.println("Guest "+guests[0].getGuestName()+" searches for a Double room for 2 people");
        Room avail=Hotel.findAvailableRoomByType(rooms,"Double",2);
        if(avail!=null){
            System.out.println("Found room: "+avail.getRoomNumber());
            Booking b1=new Booking(guests[0],avail,"2025-09-10","2025-09-13");
            b1.calculateBill();
            bookings[bookingIndex++]=b1;
            avail.setAvailable(false);
            System.out.println("Reservation created:");
            b1.displayBooking();
        }
        else{
            System.out.println("No available room found");
        }

        System.out.println("\nGuest "+guests[1].getGuestName()+" books a Suite");
        Room avail2=Hotel.findAvailableRoomByType(rooms,"Suite",2);
        if(avail2!=null){
            Booking b2=new Booking(guests[1],avail2,"2025-09-12","2025-09-15");
            b2.calculateBill();
            bookings[bookingIndex++]=b2;
            avail2.setAvailable(false);
            System.out.println("Reservation created:");
            b2.displayBooking();
        }

        System.out.println("\nGuest "+guests[2].getGuestName()+" looks for Double room");
        Room avail3=Hotel.findAvailableRoomByType(rooms,"Double",2);
        if(avail3!=null){
            Booking b3=new Booking(guests[2],avail3,"2025-09-11","2025-09-14");
            b3.calculateBill();
            bookings[bookingIndex++]=b3;
            avail3.setAvailable(false);
            System.out.println("Reservation created:");
            b3.displayBooking();
        }
        else{
            System.out.println("No available Double rooms at the moment");
        }

        double occupancy=Hotel.getOccupancyRate(rooms,bookings);
        System.out.printf("\nCurrent Occupancy Rate: %.2f%%\n", occupancy);

        System.out.println("\nGuest "+guests[0].getGuestName()+" cancels their booking");
        Booking toCancel=bookings[0];
        if(toCancel!=null){
            toCancel.cancel();
        }

        System.out.println("\nGuest "+guests[1].getGuestName()+" checks out");
        Booking toCheckout=bookings[1];
        if(toCheckout!=null){
            toCheckout.checkOut();
        }

        System.out.println("\n====== Final Room Status ======");
        for(Room r : rooms)  r.displayRoomInfo();

        System.out.println("\n====== Guest Info ======");
        for(Guest g : guests)  g.displayGuestInfo();

        System.out.println("\n====== Bookings Summary ======");
        for(int i=0; i<bookingIndex; i++){
            if(bookings[i]!=null)  bookings[i].displayBooking();
        }

        System.out.println("\nHotel-wide Stats:");
        System.out.println("Hotel Name: "+Hotel.hotelName);
        System.out.println("Total Bookings Confirmed (checked out): "+Hotel.getTotalBookings());
        System.out.println("Total Revenue: $"+Hotel.getHotelRevenue());
        System.out.printf("Occupancy Rate: %.2f%%\n", Hotel.getOccupancyRate(rooms,bookings));
        System.out.println("Most Popular Room Type: "+Hotel.getMostPopularRoomType(rooms));
    }
}
