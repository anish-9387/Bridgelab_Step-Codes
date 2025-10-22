class Customer{
    private String name;

    public Customer(String name){
        this.name=name;
    }

    public void placeOrder(OrderService orderService, String item, double amount){
        System.out.println(name+" is placing an order for: "+item);
        orderService.createOrder(this,item,amount);
    }
}

class OrderService{
    public void createOrder(Customer customer, String item, double amount){
        System.out.println("OrderService: Creating order for "+item);
        PaymentGateway paymentGateway=new PaymentGateway();
        InventoryService inventoryService=new InventoryService();

        boolean paymentStatus=paymentGateway.processPayment(amount);
        if(paymentStatus){
            inventoryService.updateInventory(item);
            confirmOrder(customer,item);
        }
        else{
            System.out.println("OrderService: Payment failed for "+item);
        }
    }

    public void confirmOrder(Customer customer, String item){
        System.out.println("OrderService: Order confirmed for "+customer+" - Item: "+item);
    }
}

class PaymentGateway{
    public boolean processPayment(double amount){
        System.out.println("PaymentGateway: Processing payment of $"+amount);
        return true;
    }
}

class InventoryService{
    public void updateInventory(String item){
        System.out.println("InventoryService: Updating stock for "+item);
    }
}

public class OnlineOrderProcess{
    public static void main(String[] args){
        Customer customer=new Customer("Anish");
        OrderService orderService=new OrderService();

        customer.placeOrder(orderService,"Laptop",75000.00);
    }
}
