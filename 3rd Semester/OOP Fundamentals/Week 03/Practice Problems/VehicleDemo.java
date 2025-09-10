class Vehicle{
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    public Vehicle(String make, String model, int year, double fuelLevel){
        this.make=make;
        this.model=model;
        this.year=year;
        this.fuelLevel=fuelLevel;
    }

    public void startVehicle(){
        System.out.println(make+" "+model+" is starting...");
    }

    public void stopVehicle(){
        System.out.println(make+" "+model+" is stopping...");
    }

    public void refuel(double amount){
        fuelLevel+=amount;
        System.out.println(make+" "+model+" refueled by "+amount+". Current fuel: "+fuelLevel);
    }

    public void displayVehicleInfo(){
        System.out.println("Vehicle Info: "+year+" "+make+" "+model);
        System.out.println("Fuel Level: "+fuelLevel);
    }
}

class Car extends Vehicle{
    private int doors;

    public Car(String make, String model, int year, double fuelLevel, int doors){
        super(make,model,year,fuelLevel);
        this.doors=doors;
    }

    @Override
    public void displayVehicleInfo(){
        super.displayVehicleInfo();
        System.out.println("Doors: "+doors);
    }
}

class Truck extends Vehicle{
    private double loadCapacity;

    public Truck(String make, String model, int year, double fuelLevel, double loadCapacity){
        super(make,model,year,fuelLevel);
        this.loadCapacity=loadCapacity;
    }

    @Override
    public void displayVehicleInfo(){
        super.displayVehicleInfo();
        System.out.println("Load Capacity: "+loadCapacity+" tons");
    }
}

class Motorcycle extends Vehicle{
    private boolean hasSidecar;

    public Motorcycle(String make, String model, int year, double fuelLevel, boolean hasSidecar){
        super(make,model,year,fuelLevel);
        this.hasSidecar=hasSidecar;
    }

    @Override
    public void displayVehicleInfo(){
        super.displayVehicleInfo();
        System.out.println("Has Sidecar: "+(hasSidecar ? "Yes" : "No"));
    }
}

public class VehicleDemo{
    public static void main(String[] args){
        Vehicle car=new Car("Toyota","Camry",2022,50,4);
        Vehicle truck=new Truck("Volvo","FH16",2021,70,20);
        Vehicle motorcycle=new Motorcycle("Harley","Street 750",2020,30,false);

        Vehicle[] vehicles={car,truck,motorcycle};

        for(Vehicle v : vehicles){
            v.startVehicle();
            v.displayVehicleInfo();
            v.refuel(10);
            v.stopVehicle();
            System.out.println("----------------------------");
        }
    }
}
