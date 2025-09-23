import java.util.Random;

class Vehicle{
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    private String registrationNumber;
    private boolean isRunning;

    public Vehicle(){
        this.brand="Unknown";
        this.model="Unknown";
        this.year=0;
        this.engineType="Unknown";
        this.registrationNumber="REG"+new Random().nextInt(1000,9999);
        this.isRunning=false;
        System.out.println("Vehicle default constructor called");
    }

    public Vehicle(String brand, String model, int year, String engineType){
        this.brand=brand;
        this.model=model;
        this.year=year;
        this.engineType=engineType;
        this.registrationNumber="REG"+new Random().nextInt(1000,9999);
        this.isRunning=false;
        System.out.println("Vehicle parameterized constructor called");
    }

    public void start(){
        isRunning=true;
        System.out.println("Vehicle started");
    }

    public void stop(){
        isRunning=false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo(){
        return "Brand: "+brand+", Model: "+model+", Year: "+year+", Engine: "+engineType+", Reg#: "+registrationNumber+", Running: "+isRunning;
    }

    public void displaySpecs(){
        System.out.println("Vehicle Specs:");
        System.out.println("Brand: "+brand);
        System.out.println("Model: "+model);
        System.out.println("Year: "+year);
        System.out.println("Engine Type: "+engineType);
    }

    public String getRegistrationNumber(){
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber){
        this.registrationNumber=registrationNumber;
    }

    public boolean isRunning(){
        return isRunning;
    }
}

public class Car extends Vehicle{
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    public Car(){
        super();
        this.numberOfDoors=4;
        this.fuelType="Petrol";
        this.transmissionType="Manual";
        System.out.println("Car default constructor called");
    }

    public Car(String brand, String model, int year, String engineType, int numberOfDoors, String fuelType, String transmissionType){
        super(brand,model,year,engineType);
        this.numberOfDoors=numberOfDoors;
        this.fuelType=fuelType;
        this.transmissionType=transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    public void start(){
        super.start();
        System.out.println("Car-specific startup: Checking seatbelts, Fuel, and Engine systems...");
    }

    public void displaySpecs(){
        super.displaySpecs();
        System.out.println("Car Specs:");
        System.out.println("Doors: "+numberOfDoors);
        System.out.println("Fuel Type: "+fuelType);
        System.out.println("Transmission: "+transmissionType);
    }

    public void openTrunk(){
        System.out.println("Trunk opened");
    }

    public void playRadio(){
        System.out.println("Radio playing music");
    }

    public static void main(String[] args){
        System.out.println("====== Test Default Constructor ======");
        Car car1=new Car();
        car1.displaySpecs();
        System.out.println(car1.getVehicleInfo());
        car1.start();
        car1.stop();
        car1.openTrunk();
        car1.playRadio();

        System.out.println("\n====== Test Parameterized Constructor ======");
        Car car2=new Car("Toyota","Corolla",2022, "Hybrid",4,"Hybrid","Automatic");
        car2.displaySpecs();
        System.out.println(car2.getVehicleInfo());
        car2.start();
        car2.stop();

        System.out.println("\n====== Polymorphic Behavior ======");
        Vehicle ref=new Car("Honda","Civic",2023,"Petrol",4,"Petrol","CVT");
        ref.start();
        ref.displaySpecs();
        System.out.println(ref.getVehicleInfo());
    }
}
