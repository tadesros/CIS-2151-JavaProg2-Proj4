package proj4;

import java.util.ArrayList;

/**
 * Class: Proj4
 * @author tomad
 * The purpose of this class is to test the functionality of the other
 * classes. 
 */
public class Proj4 {
    
    //Data Members
    static ArrayList<Artist> artistList; 
    
    /**  METHODS **/
    
     /**
     * Method: Main
     * @param args the command line arguments
     */
     public static void main(String[] args) {  
         
          //Declare an Artist ArrayList 
          artistList = new ArrayList<>(); 
          
          //Create and declare a MusicDB object
          MusicDB musicDB = new MusicDB();
          
          //Populate the artistList from the SQLlist database using getArtistList method
          artistList = musicDB.getArtistList();
         
          //Display the Main Menu
          displayIntro();
          
          //Display Artists
          displayArtists();
          
          //Display the Albums
          displayAlbums();
          
          //Display the Albums by Artist
          displayAlbumsByArtists();
      
     }//end Main
         
     /**
      * Method: displayIntro()
      * Display the Main menu
      */   
     public static void displayIntro()
     {
         System.out.println("WELCOME TO THE ARTIST AND ALBUM DATABASE");
         System.out.println(" ");                
     }
     
     /**
      * Method: displayArtists
      * Display a list of Artists in Alphabetical order from the Database
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
      * Method: displayAlbums
      * Display a list of Albums in alphabetical order from the Database
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
      * Method: displayAlbumByArtists
      * Display Artists followed by their associated Albums
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
