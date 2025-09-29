class SmartDevice{
    String deviceName;

    SmartDevice(String deviceName){
        this.deviceName=deviceName;
    }

    void status(){
        System.out.println(deviceName+" status: Online");
    }
}

class SmartClassroom extends SmartDevice{
    SmartClassroom(String deviceName){
        super(deviceName);
    }

    void controlLighting(int level){
        System.out.println(deviceName+": Adjusting lighting to level "+level);
    }

    void controlAC(int temperature){
        System.out.println(deviceName+": Setting AC to "+temperature+"°C");
    }

    void controlProjector(boolean on){
        System.out.println(deviceName+": Projector turned "+(on ? "ON" : "OFF"));
    }
}

class SmartLab extends SmartDevice{
    SmartLab(String deviceName){
        super(deviceName);
    }

    void manageEquipment(String equipment, boolean on){
        System.out.println(deviceName+": "+equipment+" turned "+(on ? "ON" : "OFF"));
    }

    void checkSafetySystem(){
        System.out.println(deviceName+": Safety system check complete");
    }
}

class SmartLibrary extends SmartDevice{
    SmartLibrary(String deviceName){
        super(deviceName);
    }

    void trackOccupancy(int people){
        System.out.println(deviceName+": Current occupancy = "+people);
    }

    void checkBookAvailability(String book){
        System.out.println(deviceName+": Book '"+book+"' availability checked");
    }
}

public class SmartIOTSystem{
    public static void main(String[] args){
        SmartDevice[] devices={
            new SmartClassroom("Classroom 101"),
            new SmartLab("Physics Lab"),
            new SmartLibrary("Central Library")
        };

        System.out.println("====== Campus IoT System Status ======");
        for(SmartDevice d : devices){
            d.status();

            if(d instanceof SmartClassroom){
                SmartClassroom sc=(SmartClassroom)d;
                sc.controlLighting(5);
                sc.controlAC(22);
                sc.controlProjector(true);
            }
            else if(d instanceof SmartLab){
                SmartLab sl=(SmartLab)d;
                sl.manageEquipment("Microscope",true);
                sl.checkSafetySystem();
            }
            else if(d instanceof SmartLibrary){
                SmartLibrary lib=(SmartLibrary)d;
                lib.trackOccupancy(50);
                lib.checkBookAvailability("Data Structures");
            }

            System.out.println("---------------------------------------------");
        }
    }
}
