class Light{
    Light(){
        this("White");
        System.out.println("Light: Default constructor called");
    }

    Light(String color){
        this(color,60);
        System.out.println("Light: Constructor with color = "+color);
    }

    Light(String color, int wattage){
        System.out.println("Light: Constructor with color = "+color+", wattage = "+wattage);
    }
}

class LED extends Light{
    LED(){
        super();
        System.out.println("LED: Default constructor called");
    }

    LED(String type){
        this(type,100);
        System.out.println("LED: Constructor with type = "+type);
    }

    LED(String type, int brightness){
        super("Blue",10);
        System.out.println("LED: Constructor with type = "+type+", brightness = "+brightness);
    }
}

public class ConstructorChaining{
    public static void main(String[] args){
        System.out.println("Creating Light object:");
        Light l1=new Light();

        System.out.println("\nCreating LED object with default constructor:");
        LED led1=new LED();

        System.out.println("\nCreating LED object with one-parameter constructor:");
        LED led2=new LED("Smart LED");

        System.out.println("\nCreating LED object with two-parameter constructor:");
        LED led3=new LED("Gaming LED",500);
    }
}
