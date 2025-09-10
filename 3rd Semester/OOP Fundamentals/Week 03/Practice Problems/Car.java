public class Car{
    String brand, color, model;
    int year;
    boolean isRunning;

    public Car(String brand, String model, int year, String color){
        this.brand=brand;
        this.model=model;
        this.year=year;
        this.color=color;
        this.isRunning=false;
    }

    public void startEngine(){
        if(!isRunning){
            isRunning=true;
            System.out.println(brand+" "+model+" engine started");
        }
        else{
            System.out.println(brand+" "+model+" engine is already running");
        }
    }

    public void stopEngine(){
        if(isRunning){
            isRunning=false;
            System.out.println(brand+" "+model+" engine stopped");
        }
        else{
            System.out.println(brand+" "+model+" engine is already off");
        }
    }

    public void displayInfo(){
        System.out.println("======CAR INFORMATION======");
        System.out.println("Brand: "+brand);
        System.out.println("Model: "+model);
        System.out.println("Year: "+year);
        System.out.println("Color: "+color);
        System.out.println("Running status: "+(isRunning ? "Yes" : "No"));
        System.out.println("---------------------------");
    }

    public int getAge(int currentYear){
        return (currentYear-year);
    }

    public static void main(String[] args){
        Car c1=new Car("Maruti Suzuki","Celerio",2017,"White");
        Car c2=new Car("Tata","Nexon",2014,"Red");
        Car c3=new Car("Tata","Punch",2019,"Blue");

        c1.displayInfo();
        c1.startEngine();
        c1.stopEngine();
        System.out.println("Age of "+c1.brand+": "+c1.getAge(2025)+" years\n");

        c2.displayInfo();
        c2.startEngine();
        System.out.println("Age of "+c2.brand+": "+c2.getAge(2025)+" years\n");

        c3.displayInfo();
        c3.startEngine();
        c3.stopEngine();
        System.out.println("Age of "+c3.brand+": "+c3.getAge(2025)+" years\n");
    }
}
