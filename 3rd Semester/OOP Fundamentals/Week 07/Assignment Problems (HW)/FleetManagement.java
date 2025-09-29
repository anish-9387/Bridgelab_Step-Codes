abstract class Vehicle{
    String vehicleId;

    Vehicle(String vehicleId){
        this.vehicleId=vehicleId;
    }

    abstract void dispatch();
}

class Bus extends Vehicle{
    int capacity;
    String route;

    Bus(String vehicleId, int capacity, String route){
        super(vehicleId);
        this.capacity=capacity;
        this.route=route;
    }

    @Override
    void dispatch(){
        System.out.println("Bus "+vehicleId+" dispatched on route "+route+" with passenger capacity "+capacity);
    }
}

class Taxi extends Vehicle{
    String driverName;

    Taxi(String vehicleId, String driverName){
        super(vehicleId);
        this.driverName=driverName;
    }

    void calculateFare(double distance){
        double fare=distance*20;
        System.out.println("Taxi fare for "+distance+" km: Rs."+fare);
    }

    @Override
    void dispatch(){
        System.out.println("Taxi "+vehicleId+" with driver "+driverName+" dispatched for door-to-door service");
    }
}

class Train extends Vehicle{
    int cars;
    String schedule;

    Train(String vehicleId, int cars, String schedule){
        super(vehicleId);
        this.cars=cars;
        this.schedule=schedule;
    }

    @Override
    void dispatch(){
        System.out.println("Train "+vehicleId+" with "+cars+" cars dispatched according to schedule: "+schedule);
    }
}

class Bike extends Vehicle{
    String type;

    Bike(String vehicleId, String type){
        super(vehicleId);
        this.type=type;
    }

    @Override
    void dispatch(){
        System.out.println(type+" Bike "+vehicleId+" dispatched for short-distance eco-friendly trips");
    }
}

public class FleetManagement{
    public static void main(String[] args){
        Vehicle[] fleet={
            new Bus("B101",50,"Route 5"),
            new Taxi("T202","Alice"),
            new Train("TR303",10,"08:00 AM"),
            new Bike("BK404","Electric")
        };

        System.out.println("====== Fleet Dispatch ======");
        for(Vehicle v : fleet){
            v.dispatch();
        }

        System.out.println("\n====== Taxi Fare Calculation ======");
        for(Vehicle v : fleet){
            if(v instanceof Taxi){
                ((Taxi)v).calculateFare(12.5);
            }
        }
    }
}
