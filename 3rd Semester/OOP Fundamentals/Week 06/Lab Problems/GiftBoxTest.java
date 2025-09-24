class Box{
    protected String item;

    public Box(String item){
        this.item=item;
    }

    public void pack(){
        System.out.println("Packing item: "+item);
    }

    public void unpack(){
        System.out.println("Unpacking item: "+item);
    }
}

class GiftBox extends Box{
    private String wrappingPaper;

    public GiftBox(String item, String wrappingPaper){
        super(item);
        this.wrappingPaper=wrappingPaper;
    }

    @Override
    public void pack(){
        super.pack();
        System.out.println("Adding beautiful "+wrappingPaper+" wrapping");
    }

    @Override
    public void unpack(){
        super.unpack();
        System.out.println("Unwrapping "+wrappingPaper+" wrapping");
    }
}

public class GiftBoxTest{
    public static void main(String[] args){
        Box normalBox=new Box("Books");
        GiftBox giftBox=new GiftBox("Watch","Golden Paper");

        System.out.println("\n------ Normal Box ------");
        normalBox.pack();
        normalBox.unpack();

        System.out.println("\n------ Gift Box ------");
        giftBox.pack();
        giftBox.unpack();
    }
}
