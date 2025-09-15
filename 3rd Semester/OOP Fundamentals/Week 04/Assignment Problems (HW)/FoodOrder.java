public class FoodOrder{
    String customerName;
    String foodItem;
    int quantity;
    double price;

    static final double FIXED_RATE=150.0;

    FoodOrder(){
        this.customerName="Unknown";
        this.foodItem="Unknown";
        this.quantity=0;
        this.price=0.0;
    }

    FoodOrder(String foodItem){
        this.customerName="Guest";
        this.foodItem=foodItem;
        this.quantity=1;
        this.price=FIXED_RATE;
    }

    FoodOrder(String foodItem, int quantity){
        this.customerName="Guest";
        this.foodItem=foodItem;
        this.quantity=quantity;
        this.price=quantity*FIXED_RATE;
    }

    void printBill(){
        System.out.println("Food Order Bill");
        System.out.println("Customer: "+customerName);
        System.out.println("Food Item: "+foodItem);
        System.out.println("Quantity: "+quantity);
        System.out.println("Total Price: ₹"+price);
        System.out.println("-------------------------");
    }

    public static void main(String[] args){
        FoodOrder o1=new FoodOrder();

        FoodOrder o2=new FoodOrder("Pizza");

        FoodOrder o3=new FoodOrder("Burger",3);

        o1.printBill();
        o2.printBill();
        o3.printBill();
    }
}
