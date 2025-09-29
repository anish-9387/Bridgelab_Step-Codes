abstract class Food{
    public final void prepare(){
        wash();
        cook();
        serve();
        System.out.println("---------------------------------------------------------");
    }

    protected abstract void wash();
    protected abstract void cook();
    protected abstract void serve();
}

class Pizza extends Food{
    @Override
    protected void wash(){
        System.out.println("Washing vegetables and preparing dough for Pizza......");
    }

    @Override
    protected void cook(){
        System.out.println("Baking pizza in the oven......");
    }

    @Override
    protected void serve(){
        System.out.println("Serving hot Pizza with cheese toppings!");
    }
}

class Soup extends Food{
    @Override
    protected void wash(){
        System.out.println("Washing vegetables and herbs for Soup......");
    }

    @Override
    protected void cook(){
        System.out.println("Boiling vegetables to make Soup......");
    }

    @Override
    protected void serve(){
        System.out.println("Serving warm Soup in a bowl!");
    }
}

public class TemplateMethodPattern{
    public static void main(String[] args){
        System.out.println("====== Preparing Pizza ======");
        Food pizza=new Pizza();
        pizza.prepare();

        System.out.println("====== Preparing Soup ======");
        Food soup=new Soup();
        soup.prepare();
    }
}
