public class AudioMixer {
    private String mixerModel;
    private int numberOfChannels;
    private boolean hasBluetoothConnectivity;
    private double maxVolumeDecibels;
    private String[] connectedDevices;
    private int deviceCount;

    public AudioMixer(){
        this("StandardMix-8",8,false);
    }

    public AudioMixer(String mixerModel, int numberOfChannels){
        this(mixerModel,numberOfChannels,false);
    }

    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity){
        this(mixerModel,numberOfChannels,hasBluetoothConnectivity,120.0);
    }

    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity, double maxVolumeDecibels){
        this.mixerModel=mixerModel;
        this.numberOfChannels=numberOfChannels;
        this.hasBluetoothConnectivity=hasBluetoothConnectivity;
        this.maxVolumeDecibels=maxVolumeDecibels;

        this.connectedDevices=new String[numberOfChannels];
        this.deviceCount=0;

        System.out.println("Constructor executed for model: "+mixerModel);
    }

    public void connectDevice(String deviceName){
        if(deviceCount<connectedDevices.length){
            connectedDevices[deviceCount]=deviceName;
            deviceCount++;
            System.out.println("Connected: "+deviceName);
        }
        else{
            System.out.println("All channels occupied!");
        }
    }

    public void displayMixerStatus(){
        System.out.println("\n====== "+mixerModel+" STATUS ======");
        System.out.println("Channels: "+numberOfChannels);
        System.out.println("Bluetooth: "+(hasBluetoothConnectivity ? "Enabled" : "Disabled"));
        System.out.println("Max Volume: "+maxVolumeDecibels+" dB");
        System.out.println("Connected Devices: "+deviceCount+"/"+numberOfChannels);

        for(int i=0; i<deviceCount; i++){
            System.out.println(" Channel "+(i+1)+": "+connectedDevices[i]);
        }
    }

    public static void main(String[] args){
        System.out.println("====== MUSIC STUDIO SETUP ======");

        AudioMixer mixer1=new AudioMixer();

        AudioMixer mixer2=new AudioMixer("ProMix-12",12);

        AudioMixer mixer3=new AudioMixer("DJMix-6",6,true);

        AudioMixer mixer4=new AudioMixer("UltraMix-16",16,true,150.0);

        mixer1.connectDevice("Microphone");
        mixer1.connectDevice("Keyboard");

        mixer2.connectDevice("Guitar");
        mixer2.connectDevice("Drums");
        mixer2.connectDevice("Laptop");

        mixer3.connectDevice("Turntable");
        mixer3.connectDevice("Headphones");

        mixer4.connectDevice("Bass");
        mixer4.connectDevice("Synthesizer");
        mixer4.connectDevice("Vocals");
        mixer4.connectDevice("Sampler");

        mixer1.displayMixerStatus();
        mixer2.displayMixerStatus();
        mixer3.displayMixerStatus();
        mixer4.displayMixerStatus();

        System.out.println("\n------ NOTE ON CONSTRUCTOR CHAINING ------");
        System.out.println("No-argument constructor -> calls two/three-parameter constructor -> calls main constructor.");
        System.out.println("This ensures all initialization logic is centralized in the main constructor.");
    }
}
