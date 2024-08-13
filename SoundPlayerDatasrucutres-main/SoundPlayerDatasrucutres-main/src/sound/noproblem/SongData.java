
package sound.noproblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;

public class SongData {
    static Song [] songList = new Song[10];
    static String[] songNames = new String[10];
    
    static Song [] playlist = new Song[1000];
    static String [] playlistName = new String[1000];
    
    static int cnt = 0;
    static int cntPlay = 0;
    
    static Map<String, Integer> songMap;
    
    public SongData() {
        songMap = new HashMap<>();
        
        songList[0] = new Song("E:\\Songs\\Akon - Lonely.mp3", "Akon");
        songList[1] = new Song("E:\\Songs\\Eminem - Lose Yourself [HD]_2.mp3", "Eminem");
        songList[2] = new Song("E:\\Songs\\The Neighbourhood - Sweater Weather.mp3", "The Neighbourhood");
        songList[3] = new Song("E:\\Songs\\Arctic Monkeys - Do I Wanna Know.mp3", "Arctic Monkeys");
        songList[4] = new Song("E:\\Songs\\11 Minutes - Halsey ft. Travis Barker.mp3", "YUNGBLUD, Halsey, Travis Barker");
        songList[5] = new Song("E:\\Songs\\George Michael - Careless Whisper (Official Video)_2.mp3", "George Micheal");
        songList[6] = new Song("E:\\Songs\\Stellar - No Angels.mp3", "Stellar");
        songList[7] = new Song("E:\\Songs\\Hyper - Spoler - Original Mix 2020.mp3", "Hyper");
        songList[8] = new Song("E:\\Songs\\NEFFEX - NUMB no-copyright.mp3", "NEFFEX");
        songList[9] = new Song("E:\\Songs\\Jutine Skye, Tyga - Collide Sped-Up-Remix.mp3", "Justine Skye");

        for (int i = 0; i < 10; i++) {
            songNames[i] = songList[i].fileName;
        }
        
        for (int i = 0; i < 10; i++) {
            songNames[i] = songList[i].fileName;
            songMap.put(songList[i].fileName, 0); // Initialize play count to 0
        }
    }
    
    public static int getIndex(String song){
        for(int i=0; i<10; i++){
            if(song.equals(songNames[i])){
                return i;
            }
        }
        return 0;
    }
    
    public static void addSong(String s ){
       
        if(cnt == 999){
            System.out.println("Playlist is Full");
            return;
        }
        
        int indx = getIndex(s);
        playlist[cnt] = songList[indx];
        playlistName[cnt] = playlist[cnt].fileName;
        // Update play count in the HashMap
       // songMap.put(playlist[cnt].fileName, songMap.get(playlist[cnt].fileName) + 1);
        cnt++;    
    }
    
    public static int playing(){
        return cntPlay;
    }

     public static int next(){
         if(cntPlay == cnt-1){
             cntPlay =0;
             return cntPlay;
         }
        cntPlay++;
        return cntPlay;
     }
     public static int previous(){
        
         if(cntPlay == 0){
         cntPlay = cnt-1;
         return cntPlay;
         }
        cntPlay--;
        return cntPlay;
        
    }
     
     public static void deleteSong(int indx){
         
         if(cnt-1 == 0){
             playlistName[0] = null;
             playlist[0] = null;
             cnt--;
             cntPlay=0;
             return;
             
         }
         
         if(cntPlay == indx){
           JOptionPane.showMessageDialog(null, "You can't delete the plying song.");
             return;
         }
                
         for(int i=indx; i<cnt; i++){
            playlistName[i] =  playlistName[i+1];
            playlist[i] =  playlist[i+1];
                 }
         if(indx < cntPlay) cntPlay--;
         
         cnt--;
     }
     
    public static int getBeginning(){
        cntPlay = 0;
        return cntPlay;
    }
    
     public static int getEnd(){
        cntPlay = cnt-1;
        return cntPlay;
    }
     
     public static void moveUp(int mv){
         cntPlay = 0;
         if(cnt == 1) return;
         if(mv == 0) return;
         
        String temp = playlistName[mv];
        playlistName[mv] = playlistName[mv-1];
        playlistName[mv -1] = temp;
        
        Song tempS = playlist[mv];
        playlist[mv] = playlist[mv-1];
        playlist[mv -1] = tempS;
        
     }
     
     public static void moveDown(int mv){
         cntPlay = 0;
         if(cnt == 1) return;
         if(mv == cnt-1) return;
         
        String temp = playlistName[mv];
        playlistName[mv] = playlistName[mv+1];
        playlistName[mv+1] = temp;
        
        Song tempS = playlist[mv];
        playlist[mv] = playlist[mv+1];
        playlist[mv+1] = tempS;
     }
     
     public static String searchSongName(String text){
         
         for(int i=0; i<10; i++){
             if( text.equals(songNames[i])){
                 addSong(text);
                 return text+ " is added succesfully to list";
             }
         }
         
         return "Song is not Found";
     }
     public static String searchSongSinger(String text){
         
         for(int i=0; i<10; i++){
             if( text.equals(songList[i].singerName)){
                 addSong(songNames[i]);
                 return songNames[i] + " by "+ text + " is added succesfully to list";
             }
         }
         
         return "Singer is not Found";
     }

     public static String shuffle( ){
         
        Random rand = new Random();
        playlist[cnt] = songList[rand.nextInt(songList.length)];
        playlistName[cnt] = playlist[cnt].fileName;
       // cnt++;  
       
       
       
       int[] Ar = new int[songList.length]; 
         System.out.println(playlist[cnt]+" im from shuffle() playlist cnt");
       return  playlist[cnt].fileName;
    }
}
