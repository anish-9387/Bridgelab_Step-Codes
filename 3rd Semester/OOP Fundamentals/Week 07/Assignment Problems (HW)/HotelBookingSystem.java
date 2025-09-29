class HotelBooking{
    public double calculatePrice(String roomType, int nights){
        double rate=getRoomRate(roomType);
        double total=rate*nights;
        System.out.println("Standard Booking: Room Type = "+roomType+", Nights = "+nights+", Total = Rs."+total);
        return total;
    }

    public double calculatePrice(String roomType, int nights, double seasonalMultiplier){
        double rate=getRoomRate(roomType);
        double total=rate*nights*seasonalMultiplier;
        System.out.println("Seasonal Booking: Room Type = "+roomType+", Nights = "+nights+", Seasonal Multiplier = "+seasonalMultiplier+", Total = Rs."+total);
        return total;
    }

    public double calculatePrice(String roomType, int nights, double corporateDiscount, double mealPackage){
        double rate=getRoomRate(roomType);
        double total=rate*nights+mealPackage;
        double discounted=total*(1-corporateDiscount/100);
        System.out.println("Corporate Booking: Room Type = "+roomType+", Nights = "+nights+", Meal Package = Rs."+mealPackage+", Corporate Discount = "+corporateDiscount+"%, Total after discount = Rs."+discounted);
        return discounted;
    }

    public double calculatePrice(String roomType, int nights, int guests, double decorationFee, double cateringFee){
        double rate=getRoomRate(roomType);
        double total=(rate*nights)+decorationFee+(cateringFee*guests);
        System.out.println("Wedding Package: Room Type = "+roomType+", Nights = "+nights+", Guests = "+guests+", Decoration = Rs."+decorationFee+", Catering = Rs."+cateringFee+" per guest, Total = Rs."+total);
        return total;
    }

    private double getRoomRate(String roomType){
        switch(roomType.toLowerCase()){
            case "deluxe": return 5000;
            case "suite": return 8000;
            case "standard": return 3000;
            default: return 4000;
        }
    }
}

public class HotelBookingSystem{
    public static void main(String[] args){
        HotelBooking hb=new HotelBooking();

        System.out.println("====== Hotel Booking Examples ======");
        hb.calculatePrice("Standard",3);
        hb.calculatePrice("Deluxe",5,1.2);
        hb.calculatePrice("Suite",4,15.0,2000.0);
        hb.calculatePrice("Deluxe",2,50,5000,1500);
    }
}
