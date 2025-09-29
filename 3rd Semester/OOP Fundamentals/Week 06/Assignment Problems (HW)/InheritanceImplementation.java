class Weather{
    String type;

    Weather(String type){
        this.type=type;
        System.out.println("Weather constructor: "+type);
    }

    public void showCondition(){
        System.out.println("General weather: "+type);
    }
}

class Storm extends Weather{
    int windSpeed;

    Storm(String type, int windSpeed){
        super(type);
        this.windSpeed=windSpeed;
        System.out.println("Storm constructor: windSpeed = "+windSpeed);
    }

    @Override
    public void showCondition(){
        System.out.println("Stormy weather with wind speed: "+windSpeed+" km/h");
    }
}

class Thunderstorm extends Storm{
    boolean lightning;

    Thunderstorm(String type, int windSpeed, boolean lightning){
        super(type,windSpeed);
        this.lightning=lightning;
        System.out.println("Thunderstorm constructor: lightning = "+lightning);
    }

    @Override
    public void showCondition(){
        System.out.println("Thunderstorm with wind speed: "+windSpeed+" km/h and lightning: "+lightning);
    }
}

class Sunshine extends Weather{
    int temperature;

    Sunshine(String type, int temperature){
        super(type);
        this.temperature=temperature;
        System.out.println("Sunshine constructor: temperature = "+temperature);
    }

    @Override
    public void showCondition(){
        System.out.println("Sunny weather with temperature: "+temperature+"°C");
    }
}

public class InheritanceImplementation{
    public static void main(String[] args){
        System.out.println("====== Object Creation with Constructor Chaining ======");
        Weather w1=new Weather("Normal");
        Storm s1=new Storm("Storm",80);
        Thunderstorm t1=new Thunderstorm("Thunderstorm",120,true);
        Sunshine sun1=new Sunshine("Sunny",30);

        System.out.println("\n====== Polymorphism Demo ======");
        Weather[] weathers={w1,s1,t1,sun1};

        for(Weather w : weathers){
            w.showCondition();
        }
    }
}
