class Artwork{
    String title;
    String artist;

    Artwork(String title, String artist){
        this.title=title;
        this.artist=artist;
    }

    void displayInfo(){
        System.out.println("Artwork: "+title+" by "+artist);
    }
}

class Painting extends Artwork{
    String brushTechnique;
    String colorPalette;
    String frame;

    Painting(String title, String artist, String brushTechnique, String colorPalette, String frame){
        super(title,artist);
        this.brushTechnique=brushTechnique;
        this.colorPalette=colorPalette;
        this.frame=frame;
    }

    void showPaintingDetails(){
        System.out.println("Painting Details: Technique = "+brushTechnique+", Colors = "+colorPalette+", Frame = "+frame);
    }
}

class Sculpture extends Artwork{
    String material;
    String dimensions;
    String lighting;

    Sculpture(String title, String artist, String material, String dimensions, String lighting){
        super(title,artist);
        this.material=material;
        this.dimensions=dimensions;
        this.lighting=lighting;
    }

    void showSculptureDetails(){
        System.out.println("Sculpture Details: Material = "+material+", Dimensions = "+dimensions+", Lighting = "+lighting);
    }
}

class DigitalArt extends Artwork{
    String resolution;
    String fileFormat;
    String interactiveElements;

    DigitalArt(String title, String artist, String resolution, String fileFormat, String interactiveElements){
        super(title,artist);
        this.resolution=resolution;
        this.fileFormat=fileFormat;
        this.interactiveElements=interactiveElements;
    }

    void showDigitalArtDetails(){
        System.out.println("Digital Art Details: Resolution = "+resolution+", Format = "+fileFormat+", Interactive = "+interactiveElements);
    }
}

class Photography extends Artwork{
    String cameraSettings;
    String editing;
    String printSpecs;

    Photography(String title, String artist, String cameraSettings, String editing, String printSpecs){
        super(title,artist);
        this.cameraSettings=cameraSettings;
        this.editing=editing;
        this.printSpecs=printSpecs;
    }

    void showPhotographyDetails(){
        System.out.println("Photography Details: Camera = "+cameraSettings+", Editing = "+editing+", Print = "+printSpecs);
    }
}

public class DigitalArtGallery{
    public static void main(String[] args){
        Artwork[] gallery={
            new Painting("Sunset Bliss","Alice","Oil Brush","Warm Tones","Gold Frame"),
            new Sculpture("The Thinker","Bob","Bronze","2m x 1m", "Spotlight"),
            new DigitalArt("Virtual Dreams","Charlie","4K","PNG","Interactive VR"),
            new Photography("Mountain Peak","Diana","f/2.8, 1/100s","Lightroom Edit","Large Print")
        };

        System.out.println("====== Art Gallery Collection ======");
        for(Artwork art : gallery){
            art.displayInfo();

            if(art instanceof Painting){
                ((Painting)art).showPaintingDetails();
            }
            else if(art instanceof Sculpture){
                ((Sculpture)art).showSculptureDetails();
            }
            else if(art instanceof DigitalArt){
                ((DigitalArt)art).showDigitalArtDetails();
            }
            else if(art instanceof Photography){
                ((Photography)art).showPhotographyDetails();
            }

            System.out.println("--------------------------");
        }
    }
}
