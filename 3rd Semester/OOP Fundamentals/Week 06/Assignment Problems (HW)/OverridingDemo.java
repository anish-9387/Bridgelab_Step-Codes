import java.util.Objects;

class Game{
    String name;
    int players;

    public Game(String name, int players){
        this.name=name;
        this.players=players;
    }

    @Override
    public String toString(){
        return "Game{name='"+name+"', players="+players+"}";
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj)  return true;
        if(obj==null || getClass()!=obj.getClass())  return false;
        Game game=(Game)obj;
        return players==game.players && Objects.equals(name,game.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,players);
    }
}

class CardGame extends Game{
    String cardType;

    public CardGame(String name, int players, String cardType){
        super(name,players);
        this.cardType=cardType;
    }

    @Override
    public String toString(){
        return super.toString()+", CardGame{cardType='"+cardType+"'}";
    }

    @Override
    public boolean equals(Object obj){
        if(!super.equals(obj))  return false;
        if(this.getClass()!=obj.getClass())  return false;
        CardGame cardGame=(CardGame)obj;
        return Objects.equals(cardType,cardGame.cardType);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(),cardType);
    }
}

public class OverridingDemo{
    public static void main(String[] args){
        Game g1=new Game("Chess",2);
        Game g2=new Game("Chess",2);
        Game g3=new Game("Ludo",4);

        CardGame cg1=new CardGame("Poker",4,"Standard");
        CardGame cg2=new CardGame("Poker",4,"Standard");
        CardGame cg3=new CardGame("Poker",4,"Special");

        System.out.println("====== toString() Demo ======");
        System.out.println(g1);
        System.out.println(cg1);

        System.out.println("\n====== equals() Demo ======");
        System.out.println("g1 equals g2: "+g1.equals(g2));
        System.out.println("g1 equals g3: "+g1.equals(g3));
        System.out.println("cg1 equals cg2: "+cg1.equals(cg2));
        System.out.println("cg1 equals cg3: "+cg1.equals(cg3));
    }
}
