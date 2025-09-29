class SmartDevice{
    String deviceName;

    SmartDevice(String deviceName){
        this.deviceName=deviceName;
    }

    void status(){
        System.out.println(deviceName+" status: Online");
    }
}

class SmartTV extends SmartDevice{
    SmartTV(String deviceName){
        super(deviceName);
    }

    void changeChannel(int channel){
        System.out.println(deviceName+": Channel changed to "+channel);
    }

    void adjustVolume(int level){
        System.out.println(deviceName+": Volume set to "+level);
    }

    void openApp(String app){
        System.out.println(deviceName+": Opening app "+app);
    }
}

class SmartThermostat extends SmartDevice{
    SmartThermostat(String deviceName){
        super(deviceName);
    }

    void setTemperature(double temp){
        System.out.println(deviceName+": Temperature set to "+temp+"°C");
    }

    void setHumidity(double humidity){
        System.out.println(deviceName+": Humidity set to "+humidity+"%");
    }

    void enableEnergySaving(boolean enable){
        System.out.println(deviceName+": Energy saving mode "+(enable ? "enabled" : "disabled"));
    }
}

class SmartSecuritySystem extends SmartDevice{
    SmartSecuritySystem(String deviceName){
        super(deviceName);
    }

    void monitorCameras(){
        System.out.println(deviceName+": Monitoring cameras");
    }

    void triggerAlarm(){
        System.out.println(deviceName+": Alarm triggered!");
    }

    void controlAccess(String user, boolean allow){
        System.out.println(deviceName+": Access "+(allow ? "granted" : "denied")+" to "+user);
    }
}

class SmartKitchenAppliance extends SmartDevice{
    SmartKitchenAppliance(String deviceName){
        super(deviceName);
    }

    void setCookingTime(int minutes){
        System.out.println(deviceName+": Cooking time set to "+minutes+" minutes");
    }

    void setTemperature(double temp){
        System.out.println(deviceName+": Temperature set to "+temp+"°C");
    }

    void selectRecipe(String recipe){
        System.out.println(deviceName+": Recipe selected: "+recipe);
    }
}

public class SmartHomeAutomation{
    public static void main(String[] args){
        SmartDevice[] devices={
            new SmartTV("Living Room TV"),
            new SmartThermostat("Main Thermostat"),
            new SmartSecuritySystem("Home Security"),
            new SmartKitchenAppliance("Smart Oven")
        };

        System.out.println("====== Smart Home Status ======");
        for(SmartDevice d : devices){
            d.status();

            if(d instanceof SmartTV tv){
                tv.changeChannel(5);
                tv.adjustVolume(20);
                tv.openApp("Netflix");
            }
            else if(d instanceof SmartThermostat th){
                th.setTemperature(22.5);
                th.setHumidity(50);
                th.enableEnergySaving(true);
            }
            else if(d instanceof SmartSecuritySystem ss){
                ss.monitorCameras();
                ss.triggerAlarm();
                ss.controlAccess("Guest", false);
            }
            else if(d instanceof SmartKitchenAppliance ka){
                ka.setCookingTime(45);
                ka.setTemperature(180);
                ka.selectRecipe("Lasagna");
            }
            System.out.println("--------------------------");
        }
    }
}
