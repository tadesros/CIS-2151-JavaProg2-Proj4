/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj4;

import java.util.ArrayList;

/**
 * Class: Proj4
 * @author tomad
 */
public class Proj4 {
    
    //Data Members
    static ArrayList<Artist> artistList; 
    
    
     /**
     * Method: Main
     * @param args the command line arguments
     */
     public static void main(String[] args) {                             
          //Declare an Artist ArrayList 
          artistList = new ArrayList<>(); 
          
          //Create and declare a MusicDB object
          MusicDB musicDB = new MusicDB();
          
          //Populate the artistList using getArtistList method
          artistList = musicDB.getArtistList();
         
          displayIntro();
          
          //Display Artists
          displayArtists();
          
          //Display Albums
          displayAlbums();
          
          //Display Albums by Artist
          displayAlbumsByArtists();
      
     }//end Main
    
     
     /**]
      * 
      */   
     public static void displayIntro()
     {
         System.out.println("WELCOME TO THE ARTIST AND ALBUM DATABASE");
         System.out.println(" ");                
     }
     
     /**
      * 
      */
     public static void displayArtists()
     {
         
         System.out.println("Artists");
         System.out.println("-------");
         
         for (Artist artist : artistList)
         {
            //Print the Artist
             System.out.println(artist.getName());
         }
         
         System.out.println(" ");
     }
     
     
      /**
      * 
      */
     public static void displayAlbums()
     {         
         System.out.println("Albums");
         System.out.println("-------");
         
         //Outer Loop
         for (int indexOut=0; indexOut < artistList.size(); indexOut++)
         {                
               ArrayList<Album> albumList = new ArrayList<>();  
             
               albumList = artistList.get(indexOut).getAlbumList();

                for (Album album : albumList)
                {
                   //Print the Artist
                    System.out.println(album.getAlbumName());
                }                  
         }         
         System.out.println(" ");
     }
     
     
      
      /**
      * 
      */
     public static void displayAlbumsByArtists()
     {         
         System.out.println("Albums by Artist");
         System.out.println("----------------");
         
         //Outer Loop
         for (int indexOut=0; indexOut < artistList.size(); indexOut++)
         {           
             
               System.out.println(artistList.get(indexOut).getName());
             
               ArrayList<Album> albumList = new ArrayList<>();  
             
               albumList = artistList.get(indexOut).getAlbumList();

                for (Album album : albumList)
                {
                   //Print the Artist
                    System.out.println("     " + album.getAlbumName());
                }                  
         }         
         System.out.println(" ");
     }
     
}//end class Proj4
