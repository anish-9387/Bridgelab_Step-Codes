class Restaurant{
    protected String name;

    public Restaurant(String name){
        this.name=name;
    }

    public void prepareFood(){
        System.out.println(name+" is preparing generic food");
    }

    public void estimateTime(){
        System.out.println("Estimated time: 30 minutes");
    }
}

class PizzaPlace extends Restaurant{
    public PizzaPlace(String name){
        super(name);
    }

    public void prepareFood(){
        System.out.println(name+" is making delicious pizza with fresh toppings!");
    }

    public void estimateTime(){
        System.out.println("Pizza ready in 20 minutes!");
    }
}

class SushiBar extends Restaurant{
    public SushiBar(String name){
        super(name);
    }

    public void prepareFood(){
        System.out.println(name+" is crafting fresh sushi with precision!");
    }

    public void estimateTime(){
        System.out.println("Sushi will be ready in 25 minutes!");
    }
}

public class FoodDelivery{
    public static void main(String[] args){
        Restaurant order;

        order=new PizzaPlace("Mario's Pizza");
        order.prepareFood();
        order.estimateTime();

        System.out.println("----------------------------");

        order=new SushiBar("Tokyo Sushi");
        order.prepareFood();
        order.estimateTime();

        System.out.println("\nExplanation:");
        System.out.println("Although 'order' is a Restaurant reference,");
        System.out.println("the JVM calls the overridden method based on the actual object (PizzaPlace or SushiBar)");
        System.out.println("This is called Dynamic Method Dispatch (Runtime Polymorphism)");
    }
}
