class Fruit{
    protected String color;
    protected String taste;

    public Fruit(String color, String taste){
        this.color=color;
        this.taste=taste;
    }
}

class Apple extends Fruit{
    protected String variety;

    public Apple(String color, String taste, String variety){
        super(color,taste);
        this.variety=variety;
    }

    public void showInfo(){
        System.out.println("Apple variety: "+variety+", color: "+color+", taste: "+taste);
    }
}

public class FruitTest{
    public static void main(String[] args) {
        Apple apple=new Apple("Red","Sweet","Fuji");

        System.out.println("Color: "+apple.color);
        System.out.println("Taste: "+apple.taste);

        System.out.println("Variety: "+apple.variety);

        apple.showInfo();
    }
}
