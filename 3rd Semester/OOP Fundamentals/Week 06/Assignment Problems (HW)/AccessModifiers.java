class Tool{
    private String brand="Generic Brand";
    protected String material="Steel";
    public String type="Tool";

    public String getBrand(){
        return brand;
    }
}

class Hammer extends Tool{
    public void showAccess(){
        // System.out.println("Brand: "+brand);
        System.out.println("Brand (via getter): "+getBrand());
        System.out.println("Material: "+material);
        System.out.println("Type: "+type);
    }
}

public class AccessModifiers{
    public static void main(String[] args){
        Hammer hammer=new Hammer();

        System.out.println("====== Accessing fields inside child class ======");
        hammer.showAccess();

        System.out.println("\n====== Accessing fields from outside ======");
        // System.out.println(hammer.brand);
        // System.out.println(hammer.material);
        System.out.println("Type: "+hammer.type);
        System.out.println("Brand (via getter): "+hammer.getBrand());
    }
}
