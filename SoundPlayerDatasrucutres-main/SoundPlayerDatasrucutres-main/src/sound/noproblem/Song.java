
package sound.noproblem;

import jaco.mp3.player.MP3Player;
import java.io.File;

public class Song {
    
    
    private int playCount;
    
    
    MP3Player player;
    File songfile;
    String fileName;
    String singerName;
    String currentPath;
    
    public Song(String s,String h){
        this.songfile = new File(s); 
        this.fileName = songfile.getName();
        this.currentPath = s;
        this.player = new MP3Player();
        this.singerName = h; 
        this.playCount = 0;
    }
    
    public String getSongName(){
        return fileName;
        
    }
    
    public MP3Player GetMp3player (){
        return player;
    }
    
    public int getPlayCount() {
        return playCount;
    }

    public void incrementPlayCount() {
        playCount++;
    }
    
}
