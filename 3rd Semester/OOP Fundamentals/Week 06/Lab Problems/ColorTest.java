class Color{
    protected String name;

    public Color(String name){
        this.name=name;
        System.out.println("Color constructor called: "+name);
    }

    public void showColor(){
        System.out.println("Color: "+name);
    }
}

class PrimaryColor extends Color{
    protected int intensity;

    public PrimaryColor(String name, int intensity){
        super(name);
        this.intensity=intensity;
        System.out.println("PrimaryColor constructor called: "+name+" with intensity "+intensity);
    }

    public void showPrimaryColor(){
        System.out.println("Primary Color: "+name+", Intensity: "+intensity);
    }
}

class RedColor extends PrimaryColor{
    private String shade;

    public RedColor(String name, int intensity, String shade){
        super(name,intensity);
        this.shade=shade;
        System.out.println("RedColor constructor called: "+name+" with shade "+shade);
    }

    public void showRedColor(){
        System.out.println("Red Color: "+name+", Intensity: "+intensity+", Shade: "+shade);
    }
}

public class ColorTest{
    public static void main(String[] args){
        RedColor red=new RedColor("Red",90,"Dark Red");

        System.out.println("\n------ Display Information ------");
        red.showColor();
        red.showPrimaryColor();
        red.showRedColor();
    }
}
