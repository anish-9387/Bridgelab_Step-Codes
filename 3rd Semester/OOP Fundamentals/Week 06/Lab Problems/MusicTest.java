class Instrument{
    protected String name;
    protected String material;

    public Instrument(String name, String material){
        this.name=name;
        this.material=material;
    }

    public void play(){
        System.out.println("Playing the instrument: "+name);
    }

    public void showDetails(){
        System.out.println("Instrument: "+name+", Material: "+material);
    }
}

class Piano extends Instrument{
    private int keys;

    public Piano(String name, String material, int keys) {
        super(name, material);
        this.keys=keys;
    }

    @Override
    public void play(){
        System.out.println("Playing the piano: "+name+" with "+keys+" keys");
    }
}

class Guitar extends Instrument{
    private int strings;

    public Guitar(String name, String material, int strings){
        super(name,material);
        this.strings=strings;
    }

    @Override
    public void play(){
        System.out.println("Strumming the guitar: "+name+" with "+strings+" strings");
    }
}

class Drum extends Instrument{
    private String type;

    public Drum(String name, String material, String type){
        super(name,material);
        this.type=type;
    }

    @Override
    public void play(){
        System.out.println("Beating the drum: "+name+" ("+type+")");
    }
}

public class MusicTest{
    public static void main(String[] args){
        Instrument[] instruments=new Instrument[3];
        instruments[0]=new Piano("Yamaha Grand","Wood",88);
        instruments[1]=new Guitar("Fender Stratocaster","Wood",6);
        instruments[2]=new Drum("Pearl Drum","Metal","Snare Drum");

        System.out.println("\n------ Orchestra Simulation ------");
        for(Instrument i : instruments){
            i.showDetails();
            i.play();
            System.out.println();
        }
    }
}
