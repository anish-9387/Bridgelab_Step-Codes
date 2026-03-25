import java.util.*;

/**
 *
 * CLASS AddOnService
 *
 * Represents an optional service that can be added to a reservation.
 *
 */
class AddOnService{
    private String serviceName;
    private double cost;

    public AddOnService(String serviceName, double cost){
        this.serviceName=serviceName;
        this.cost=cost;
    }

    public String getServiceName(){
        return serviceName;
    }

    public double getCost(){
        return cost;
    }

    @Override
    public String toString(){
        return serviceName+" (₹"+cost+")";
    }
}

/**
 *
 * CLASS AddOnServiceManager
 *
 * Manages services associated with reservations.
 *
 */
class AddOnServiceManager{
    private Map<String, List<AddOnService>> servicesByReservation;

    public AddOnServiceManager(){
        servicesByReservation=new HashMap<>();
    }

    public void addService(String reservationId, AddOnService service){
        servicesByReservation.computeIfAbsent(reservationId, k->new ArrayList<>()).add(service);
    }

    public double calculateTotalServiceCost(String reservationId){
        List<AddOnService> services=servicesByReservation.get(reservationId);

        if(services==null)  return 0.0;

        double total=0.0;
        for(AddOnService service : services){
            total+=service.getCost();
        }
        return total;
    }

    public void displayServices(String reservationId){
        List<AddOnService> services=servicesByReservation.get(reservationId);

        if(services==null || services.isEmpty()){
            System.out.println("No add-on services selected.");
            return;
        }

        System.out.println("Selected Services:");
        for(AddOnService service : services){
            System.out.println("- "+service);
        }
    }
}

/**
 *
 * MAIN CLASS
 *
 * Demonstrates Add-On Service Selection
 *
 */
public class BookMyStayApp{
    public static void main(String[] args){
        String reservationId="RES123";

        AddOnServiceManager manager=new AddOnServiceManager();

        AddOnService breakfast=new AddOnService("Breakfast",500);
        AddOnService spa=new AddOnService("Spa",1500);
        AddOnService airportPickup=new AddOnService("Airport Pickup",800);

        manager.addService(reservationId,breakfast);
        manager.addService(reservationId,spa);
        manager.addService(reservationId,airportPickup);

        System.out.println("Reservation ID: "+reservationId);
        manager.displayServices(reservationId);

        double totalCost=manager.calculateTotalServiceCost(reservationId);
        System.out.println("Total Add-On Cost: ₹"+totalCost);
    }
}