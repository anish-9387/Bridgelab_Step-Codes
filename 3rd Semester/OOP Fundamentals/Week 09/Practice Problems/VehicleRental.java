class Vehicle{
    private String registrationNo;
    private String type;
    private double ratePerDay;

    public Vehicle(String registrationNo, String type, double ratePerDay){
        this.registrationNo=registrationNo;
        this.type=type;
        this.ratePerDay=ratePerDay;
    }

    public String getRegistrationNo(){
        return registrationNo;
    }

    public String getType(){
        return type;
    }

    public double getRatePerDay(){
        return ratePerDay;
    }

    @Override
    public String toString(){
        return "Vehicle: "+registrationNo+", Type: "+type+", Rate: Rs."+ratePerDay+"/day";
    }
}

public class VehicleRental{
    public static void main(String[] args){
        Vehicle v1=new Vehicle("MH14GH6801","Sedan",1500);
        System.out.println(v1);

        Vehicle v2=new Vehicle("MH14CD5678","SUV",2000);
        System.out.println(v2);

        if(v1.getRatePerDay()>v2.getRatePerDay()){
            System.out.println(v1.getType()+" is more expensive per day");
        }
        else if(v1.getRatePerDay()<v2.getRatePerDay()){
            System.out.println(v2.getType()+" is more expensive per day");
        }
        else{
            System.out.println("Both vehicles have the same rate per day");
        }
    }
}
