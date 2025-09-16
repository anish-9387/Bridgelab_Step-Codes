public class GameController{
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;

    public GameController(){
        this.controllerBrand="GenericPad";
        this.connectionType="USB";
        this.hasVibration=true;
        this.batteryLevel=100;
        this.sensitivity=1.0;
    }

    public GameController(String controllerBrand, String connectionType, boolean hasVibration, int batteryLevel, double sensitivity){
        this.controllerBrand=controllerBrand;
        this.connectionType=connectionType;
        this.hasVibration=hasVibration;

        if(batteryLevel<0){
            this.batteryLevel=0;
        }
        else if(batteryLevel>100){
            this.batteryLevel=100;
        }
        else{
            this.batteryLevel=batteryLevel;
        }

        if(sensitivity<0.1){
            this.sensitivity=0.1;
        }
        else if(sensitivity>3.0){
            this.sensitivity=3.0;
        }
        else{
            this.sensitivity=sensitivity;
        }
    }

    public GameController(String brand, String connectionType){
        this(brand,connectionType,true,100,1.0); // defaults
    }

    public void calibrateController(){
        System.out.println("Calibrating "+controllerBrand+" controller...");
    }

    public void displayConfiguration(){
        System.out.println("Controller Brand: "+controllerBrand);
        System.out.println("Connection Type : "+connectionType);
        System.out.println("Has Vibration   : "+hasVibration);
        System.out.println("Battery Level   : "+batteryLevel+"%");
        System.out.println("Sensitivity     : "+sensitivity);
        System.out.println("---------------------------");
    }

    public void testVibration(){
        if(hasVibration){
            System.out.println("*BUZZ* Vibration test successful!");
        }
        else{
            System.out.println("Vibration disabled on this controller.");
        }
    }

    public static void main(String[] args){
        System.out.println("====== GAMING CONTROLLER SETUP ======");

        GameController controller1=new GameController();

        GameController controller2=new GameController("XPad Pro","Bluetooth",true,85,2.5);

        GameController controller3=new GameController("RetroStick","USB");

        controller1.displayConfiguration();
        controller1.calibrateController();
        controller1.testVibration();

        controller2.displayConfiguration();
        controller2.calibrateController();
        controller2.testVibration();

        controller3.displayConfiguration();
        controller3.calibrateController();
        controller3.testVibration();

        System.out.println("Comparing controller setups:");
        System.out.println("Controller1 brand: "+controller1.controllerBrand);
        System.out.println("Controller2 brand: "+controller2.controllerBrand);
        System.out.println("Controller3 brand: "+controller3.controllerBrand);
    }
}
