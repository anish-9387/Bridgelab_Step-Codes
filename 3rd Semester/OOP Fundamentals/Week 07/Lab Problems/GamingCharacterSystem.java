abstract class Character{
    String name;

    Character(String name){
        this.name=name;
    }

    abstract void attack();
}

class Warrior extends Character{
    int defense;

    Warrior(String name, int defense){
        super(name);
        this.defense=defense;
    }

    @Override
    void attack(){
        System.out.println("Warrior "+name+" attacks with a sword! Defense = "+defense);
    }
}

class Mage extends Character{
    int mana;

    Mage(String name, int mana){
        super(name);
        this.mana=mana;
    }

    @Override
    void attack(){
        System.out.println("Mage "+name+" casts a fireball! Mana left = "+mana);
    }
}

class Archer extends Character{
    int arrows;

    Archer(String name, int arrows){
        super(name);
        this.arrows=arrows;
    }

    @Override
    void attack(){
        System.out.println("Archer "+name+" shoots an arrow! Arrows left = "+arrows);
    }
}

public class GamingCharacterSystem{
    public static void main(String[] args){
        Character[] army={
            new Warrior("Thor",80),
            new Mage("Merlin",100),
            new Archer("Robin",30)
        };

        System.out.println("====== Battle Begins! ======");
        for(Character c : army){
            c.attack();
        }
    }
}
