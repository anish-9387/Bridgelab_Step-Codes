public class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    private int totalRentedDays;

    private static int totalVehicles=0;
    private static double totalRevenue=0.0;
    private static String companyName;
    private static int rentalDays = 0;

    public Vehicle(String brand, String model, double rentPerDay){
        this.vehicleId="V"+String.format("%03d",++totalVehicles);
        this.brand=brand;
        this.model=model;
        this.rentPerDay=rentPerDay;
        this.isAvailable=true;
        this.totalRentedDays=0;
    }

    public double calculateRent(int days){
        return rentPerDay*days;
    }

    public void rentVehicle(int days){
        if(isAvailable){
            double rent=calculateRent(days);
            isAvailable=false;
            totalRevenue+=rent;
            rentalDays+=days;
            totalRentedDays+=days;
            System.out.println(vehicleId+" rented for "+days+ " days. Rent: $"+rent);
        }
        else{
            System.out.println(vehicleId+" is not available for rent");
        }
    }

    public void returnVehicle(){
        if(!isAvailable){
            isAvailable=true;
            System.out.println(vehicleId+" has been returned and is now available");
        }
        else{
            System.out.println(vehicleId+" was not rented out");
        }
    }

    public void displayVehicleInfo(){
        System.out.println("Vehicle ID: "+vehicleId);
        System.out.println("Brand: "+brand);
        System.out.println("Model: "+model);
        System.out.println("Rent per Day: $"+rentPerDay);
        System.out.println("Available: "+(isAvailable ? "Yes" : "No"));
        System.out.println("Total Days Rented: "+totalRentedDays);
        System.out.println("-------------------------");
    }

    public static void setCompanyName(String name){
        companyName=name;
    }

    public static double getTotalRevenue(){
        return totalRevenue;
    }

    public static double getAverageRentPerDay(){
        if(rentalDays==0)  return 0.0;
        return totalRevenue/rentalDays;
    }

    public static void displayCompanyStats(){
        System.out.println("Company Name: "+companyName);
        System.out.println("Total Vehicles: "+totalVehicles);
        System.out.println("Total Revenue: $"+totalRevenue);
        System.out.println("Total Rental Days: "+rentalDays);
        System.out.println("Average Revenue per Day: $"+getAverageRentPerDay());
        System.out.println("=========================");
    }

    public static void main(String[] args){
        Vehicle.setCompanyName("ZoomCars Rental");

        Vehicle v1=new Vehicle("Toyota","Corolla",50);
        Vehicle v2=new Vehicle("Honda","Civic",60);
        Vehicle v3=new Vehicle("Ford","Mustang",120);

        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        v1.rentVehicle(3);
        v2.rentVehicle(5);

        v1.rentVehicle(2);

        v1.returnVehicle();

        v1.rentVehicle(2);

        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        Vehicle.displayCompanyStats();
    }
}
