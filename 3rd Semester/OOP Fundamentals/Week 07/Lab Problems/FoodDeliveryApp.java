class DeliveryCalculator{
    public double calculateDelivery(double distance){
        double cost=distance*5;
        System.out.println("Basic Delivery: Distance = "+distance+" km, Cost = Rs."+cost);
        return cost;
    }

    public double calculateDelivery(double distance, double priorityFee){
        double cost=(distance*5)+priorityFee;
        System.out.println("Premium Delivery: Distance = "+distance+" km, Priority Fee = Rs."+priorityFee+", Total Cost = Rs."+cost);
        return cost;
    }

    public double calculateDelivery(double distance, int numberOfOrders){
        double baseCost=distance*5;
        double discount=numberOfOrders*2;
        double finalCost=baseCost-discount;
        if(finalCost<0)  finalCost=0;
        System.out.println("Group Delivery: Distance = "+distance+" km, Orders = "+numberOfOrders+", Discount = Rs."+discount+", Final Cost = Rs."+finalCost);
        return finalCost;
    }

    public double calculateDelivery(double distance, double discountPercent, double freeDeliveryThreshold){
        double baseCost=distance*5;
        if(baseCost>=freeDeliveryThreshold){
            System.out.println("Festival Special: Distance = "+distance+" km, Base Cost = Rs."+baseCost+" --> FREE Delivery (over threshold Rs."+freeDeliveryThreshold+")");
            return 0;
        }
        double discount=baseCost*(discountPercent/100);
        double finalCost=baseCost-discount;
        System.out.println("Festival Special: Distance = "+distance+" km, Base Cost = Rs."+baseCost+", Discount = "+discountPercent+"% (Rs."+discount+"), Final Cost = Rs."+finalCost);
        return finalCost;
    }
}

public class FoodDeliveryApp{
    public static void main(String[] args){
        DeliveryCalculator dc=new DeliveryCalculator();

        System.out.println("\n====== Delivery Charges Demo ======");
        dc.calculateDelivery(10);
        dc.calculateDelivery(8,50.0);
        dc.calculateDelivery(12,3);
        dc.calculateDelivery(15,20.0,100.0);
        dc.calculateDelivery(25,10.0,80.0);
    }
}
