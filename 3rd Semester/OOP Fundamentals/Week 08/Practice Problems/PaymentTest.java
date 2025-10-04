interface PaymentGateway{
    void pay(double amount);

    void refund(double amount);
}

class CreditCardPayment implements PaymentGateway{
    @Override
    public void pay(double amount){
        System.out.println("Paid Rs."+amount+" via Credit Card");
    }

    @Override
    public void refund(double amount){
        System.out.println("Refunded Rs."+amount+" to Credit Card");
    }
}

class UPIPayment implements PaymentGateway{
    @Override
    public void pay(double amount){
        System.out.println("Paid Rs."+amount+" via UPI");
    }

    @Override
    public void refund(double amount){
        System.out.println("Refunded Rs."+amount+" to UPI");
    }
}

public class PaymentTest{
    public static void main(String[] args){
        PaymentGateway creditCard=new CreditCardPayment();
        creditCard.pay(2500);
        creditCard.refund(500);

        System.out.println();

        PaymentGateway upi=new UPIPayment();
        upi.pay(1200);
        upi.refund(200);
    }
}
