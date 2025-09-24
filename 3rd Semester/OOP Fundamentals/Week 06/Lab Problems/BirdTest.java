class Bird{
    public void fly(){
        System.out.println("Bird is flying in a generic way...");
    }
}

class Penguin extends Bird{
    @Override
    public void fly(){
        System.out.println("Penguin cannot fly, but it swims gracefully!");
    }
}

class Eagle extends Bird{
    @Override
    public void fly(){
        System.out.println("Eagle soars high in the sky with wide wings!");
    }
}

public class BirdTest{
    public static void main(String[] args){
        Bird[] birds={ new Bird(), new Penguin(), new Eagle() };

        for(Bird b : birds){
            b.fly();
        }
    }
}
