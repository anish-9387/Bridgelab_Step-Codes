class Cart{
    public void addItem(String item){
        System.out.println("Cart: Adding item -> "+item);
    }

    public void viewItems(){
        System.out.println("Cart: Viewing items in the cart......");
    }
}

class PaymentService{
    public boolean makePayment(double amount){
        System.out.println("PaymentService: Processing payment of Rs."+amount);
        System.out.println("PaymentService: Payment successful!");
        return true;
    }
}

class OrderService{
    public void confirmOrder(String customerName){
        System.out.println("OrderService: Order confirmed for "+customerName);
    }
}

class Customer{
    String name;
    Cart cart;
    PaymentService paymentService;
    OrderService orderService;

    public Customer(String name){
        this.name=name;
        this.cart=new Cart();
        this.paymentService=new PaymentService();
        this.orderService=new OrderService();
    }

    public void placeOrder(String item, double amount){
        System.out.println("Customer: "+name+" is placing an order......");
        cart.addItem(item);
        cart.viewItems();

        boolean paymentStatus=paymentService.makePayment(amount);
        if(paymentStatus){
            orderService.confirmOrder(name);
        }
    }
}

public class OnlineShoppingDemo{
    public static void main(String[] args){
        Customer customer1=new Customer("Anish");
        customer1.placeOrder("Wireless Mouse",899.00);
    }
}
