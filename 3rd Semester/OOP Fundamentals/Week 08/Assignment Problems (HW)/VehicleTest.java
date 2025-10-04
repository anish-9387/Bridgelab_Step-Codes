abstract class Vehicle{
    public abstract void start();

    public void stop(){
        System.out.println("Vehicle has stopped");
    }
}

interface Fuel{
    void refuel();
}

class Car extends Vehicle implements Fuel{
    private String model;

    public Car(String model){
        this.model=model;
    }

    @Override
    public void start(){
        System.out.println(model+" car has started with ignition key");
    }

    @Override
    public void refuel(){
        System.out.println(model+" car is refueling with petrol");
    }
}

public class VehicleTest{
    public static void main(String[] args){
        Car car=new Car("Honda City");

        car.start();
        car.stop();
        car.refuel();
    }
}
