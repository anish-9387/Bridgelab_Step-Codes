abstract class Vehicle{
    public abstract void start();

    public void fuelType(){
        System.out.println("Uses fuel");
    }
}

class Car extends Vehicle{
    @Override
    public void start(){
        System.out.println("Car starts with key");
    }
}

class Bike extends Vehicle{
    @Override
    public void start(){
        System.out.println("Bike starts with kick");
    }
}

public class VehicleTest{
    public static void main(String[] args){
        Vehicle car=new Car();
        car.start();
        car.fuelType();

        System.out.println();

        Vehicle bike=new Bike();
        bike.start();
        bike.fuelType();
    }
}
