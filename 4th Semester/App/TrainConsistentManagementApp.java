import java.util.*;

class CargoSafetyException extends RuntimeException{
    public CargoSafetyException(String message){
        super(message);
    }
}

class GoodsBogie{
    String shape;
    String cargo;

    public GoodsBogie(String shape){
        this.shape=shape;
    }

    public void assignCargo(String cargoType){
        try{
            if(shape.equalsIgnoreCase("Rectangular") && cargoType.equalsIgnoreCase("Petroleum")){
                throw new CargoSafetyException("Unsafe: Cannot assign Petroleum to Rectangular bogie");
            }

            this.cargo=cargoType;
            System.out.println("Cargo assigned successfully: "+cargoType);

        }
        catch(CargoSafetyException e){
            System.out.println("Error: "+e.getMessage());

        }
        finally{
            System.out.println("Cargo assignment attempt completed.\n");
        }
    }

    public String getCargo(){
        return cargo;
    }

    public String getShape(){
        return shape;
    }
}

public class TrainConsistentManagementApp{
    public static void main(String[] args){
        GoodsBogie b1=new GoodsBogie("Cylindrical");
        GoodsBogie b2=new GoodsBogie("Rectangular");

        b1.assignCargo("Petroleum");

        b2.assignCargo("Petroleum");

        b2.assignCargo("Grains");

        System.out.println("Program continues safely...");
    }
}