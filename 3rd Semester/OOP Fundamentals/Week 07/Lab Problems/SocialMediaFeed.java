import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Post{
    String author;
    String content;
    LocalDateTime time;

    public Post(String author, String content){
        this.author=author;
        this.content=content;
        this.time=LocalDateTime.now();
    }

    public void display(){
        System.out.println("["+time.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))+"]");
        System.out.println(author+": "+content);
    }
}

class InstagramPost extends Post{
    int likes;
    String hashtags;

    public InstagramPost(String author, String content, int likes, String hashtags){
        super(author,content);
        this.likes=likes;
        this.hashtags=hashtags;
    }

    @Override
    public void display(){
        System.out.println("Instagram Post by "+author);
        System.out.println(content+" "+hashtags);
        System.out.println("Likes: "+likes);
        System.out.println("Posted on: "+time.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm")));
        System.out.println("-------------------------------------------------");
    }
}

class TwitterPost extends Post{
    int retweets;

    public TwitterPost(String author, String content, int retweets){
        super(author,content);
        this.retweets=retweets;
    }

    @Override
    public void display(){
        System.out.println("Twitter Post by @"+author);
        System.out.println("\""+content+"\" ("+content.length()+" chars)");
        System.out.println("Retweets: "+retweets);
        System.out.println("Time: "+time.format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")));
        System.out.println("-------------------------------------------------");
    }
}

class LinkedInPost extends Post{
    int connections;

    public LinkedInPost(String author, String content, int connections){
        super(author,content);
        this.connections=connections;
    }

    @Override
    public void display(){
        System.out.println("LinkedIn Post by "+author);
        System.out.println(content);
        System.out.println("Connections: "+connections);
        System.out.println("Published on: "+time.format(DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy")));
        System.out.println("-------------------------------------------------");
    }
}

public class SocialMediaFeed{
    public static void main(String[] args){
        Post insta=new InstagramPost("Alice","Enjoying the beach!",120,"#sunset #vacation");
        Post twitter=new TwitterPost("Bob","Java is awesome!",45);
        Post linkedin=new LinkedInPost("Charlie","Excited to start my new role at TechCorp!",500);

        System.out.println("====== Social Media Feed ======");
        insta.display();
        twitter.display();
        linkedin.display();
    }
}
