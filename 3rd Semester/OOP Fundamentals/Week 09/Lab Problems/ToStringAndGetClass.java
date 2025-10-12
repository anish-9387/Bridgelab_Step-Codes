class Car{
    private String brand;
    private String model;
    private double price;

    public Car(String brand, String model, double price){
        this.brand=brand;
        this.model=model;
        this.price=price;
    }

    @Override
    public String toString(){
        return "Car [Brand="+brand+", Model="+model+", Price="+price+"]";
    }
}

public class ToStringAndGetClass{
    public static void main(String[] args){
        Car car1=new Car("Tesla", "Model S", 79999.99);

        System.out.println(car1);

        System.out.println("Class Name: "+car1.getClass().getName());
    }
}
