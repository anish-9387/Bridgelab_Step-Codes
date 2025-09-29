class Content{
    String title;

    Content(String title){
        this.title=title;
    }

    void play(){
        System.out.println("Playing content: "+title);
    }
}

class Movie extends Content{
    double rating;
    int duration;
    boolean subtitles;

    Movie(String title, double rating, int duration, boolean subtitles){
        super(title);
        this.rating=rating;
        this.duration=duration;
        this.subtitles=subtitles;
    }

    void showDetails(){
        System.out.println("Movie: "+title+", Rating: "+rating+", Duration: "+duration+" mins, Subtitles: "+subtitles);
    }
}

class TVSeries extends Content{
    int seasons;
    int episodes;
    String nextEpisode;

    TVSeries(String title, int seasons, int episodes, String nextEpisode){
        super(title);
        this.seasons=seasons;
        this.episodes=episodes;
        this.nextEpisode=nextEpisode;
    }

    void showDetails(){
        System.out.println("TV Series: "+title+", Seasons: "+seasons+", Episodes: "+episodes+", Next Episode: "+nextEpisode);
    }
}

class Documentary extends Content{
    String[] tags;
    String relatedContent;

    Documentary(String title, String[] tags, String relatedContent){
        super(title);
        this.tags=tags;
        this.relatedContent=relatedContent;
    }

    void showDetails(){
        System.out.print("Documentary: "+title+", Tags: ");
        for(String tag : tags)  System.out.print(tag+" ");
        System.out.println(", Related Content: "+relatedContent);
    }
}

public class MovieStreamingPlatform{
    public static void main(String[] args){
        Content[] library={
            new Movie("Inception",8.8,148,true),
            new TVSeries("Stranger Things",4,34,"Chapter 2"),
            new Documentary("Planet Earth",new String[]{"Nature", "Wildlife"},"Blue Planet")
        };

        System.out.println("====== Streaming Library ======");
        for(Content c : library){
            c.play();

            if(c instanceof Movie){
                ((Movie)c).showDetails();
            }
            else if(c instanceof TVSeries){
                ((TVSeries)c).showDetails();
            }
            else if(c instanceof Documentary){
                ((Documentary)c).showDetails();
            }

            System.out.println("----------------------------------------------");
        }
    }
}
