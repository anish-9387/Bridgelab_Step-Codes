public class MovieTicket{
    String movieName;
    String theatreName;
    int seatNumber;
    double price;

    MovieTicket(){
        this.movieName="Unknown";
        this.theatreName="Not Assigned";
        this.seatNumber=0;
        this.price=0.0;
    }

    MovieTicket(String movieName){
        this.movieName=movieName;
        this.theatreName="Not Assigned";
        this.seatNumber=0;
        this.price=200.0;
    }

    MovieTicket(String movieName, int seatNumber){
        this.movieName=movieName;
        this.seatNumber=seatNumber;
        this.theatreName="PVR";
        this.price=200.0;
    }

    MovieTicket(String movieName, String theatreName, int seatNumber, double price){
        this.movieName=movieName;
        this.theatreName=theatreName;
        this.seatNumber=seatNumber;
        this.price=price;
    }

    void printTicket(){
        System.out.println("Ticket Details:");
        System.out.println("Movie: "+movieName);
        System.out.println("Theatre: "+theatreName);
        System.out.println("Seat No: "+seatNumber);
        System.out.println("Price: ₹"+price);
        System.out.println("-------------------------");
    }

    public static void main(String[] args){
        MovieTicket t1=new MovieTicket();

        MovieTicket t2=new MovieTicket("Inception");

        MovieTicket t3=new MovieTicket("Avengers",15);

        MovieTicket t4=new MovieTicket("Interstellar","INOX",25,350.0);

        t1.printTicket();
        t2.printTicket();
        t3.printTicket();
        t4.printTicket();
    }
}
