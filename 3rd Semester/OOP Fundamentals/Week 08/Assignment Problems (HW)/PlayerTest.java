interface Playable{
    void play();

    void pause();
}

class MusicPlayer implements Playable{
    @Override
    public void play(){
        System.out.println("Music is now playing......");
    }

    @Override
    public void pause(){
        System.out.println("Music has been paused");
    }

    public void skipTrack(){
        System.out.println("Skipping to the next music track");
    }
}

class VideoPlayer implements Playable{
    @Override
    public void play(){
        System.out.println("Video is now playing......");
    }

    @Override
    public void pause(){
        System.out.println("Video has been paused");
    }

    public void fullScreen(){
        System.out.println("Video switched to full screen mode");
    }
}

public class PlayerTest{
    public static void main(String[] args){
        Playable player=new MusicPlayer();
        player.play();
        player.pause();

        System.out.println();

        player=new VideoPlayer();
        player.play();
        player.pause();
    }
}
