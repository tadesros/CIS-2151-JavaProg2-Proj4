/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj4;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 * Class: MusicDB
 * @author tomad
 */
public class MusicDB {

    //Data Members
    static ArrayList<Artist> artistImport; 
      
    /**
     * Constructor: MusicDB
     * Initialize artistImport ArrayList
     */
    public MusicDB() {        
          //Declare an Artist ArrayList 
          artistImport = new ArrayList<>();         
    }
    
        
    public void TestDB(){
    
       Connection connection;
         
         
        try{
                connection = getConnection();
                Statement statement = connection.createStatement();
                
 
           String query =  "SELECT Artists.Name as 'Artist_Name', Albums.Name as 'Album_Name'"
                           + " FROM Artists" 
                           + " INNER JOIN Albums ON Albums.ArtistID = Artists.ArtistID"
                           + " ORDER BY Artist_Name ASC, Album_Name ASC";

                
                ResultSet artists = statement.executeQuery(query);
                
                  while(artists.next()) {
                      
                      System.out.print(artists.getString("Artist_Name") + "\n");
                      System.out.print(artists.getString("Album_Name") + "\n");
                     
                  }//end while
                  //Close the connection
                        connection.close();
        }          
        catch(SQLException ex) {
            System.out.println("Error accessing database: "+ ex.getMessage());
        }
    
    
    
   }//End TestDB
    
    
    public ArrayList<Artist> getArtistList()
    {
           //Connection Objects
             Connection connection;
             
           //String for Current Artist Name
            String prevArtistName = null; 
            String currArtistName = null;
            String currAlbumName = null;
            
          //Create an Album ArrayList
            ArrayList<Album> albumList = new ArrayList<Album>(); 
            
             
             
        try{
            //Initialize Connection Object
              connection = getConnection();
              Statement statement = connection.createStatement();
                
           //Get Artists and Albums put them in alphabetical order
           String query =  "SELECT Artists.Name as 'Artist_Name', Albums.Name as 'Album_Name'"
                           + " FROM Artists" 
                           + " INNER JOIN Albums ON Albums.ArtistID = Artists.ArtistID"
                           + " ORDER BY Artist_Name ASC, Album_Name ASC";

            //Execute the SQL - Query    
            ResultSet artists = statement.executeQuery(query);  
            
            //Create album ArrayList
              ArrayList<Album> currAlbumList = new ArrayList<Album>();
                         
            //Loop for going thru each row of the Database Results     
            while(artists.next()) {                      
                
                //GET THE NEW DATA FROM THE RECORD                               
                    //Get the next Artist Name
                      currArtistName = artists.getString("Artist_Name");
                      
                      System.out.println("Current Artist Name: "+ currArtistName);
                    //Get the next Album Name
                      currAlbumName = artists.getString("Album_Name");             
                    //Set New Album Object
                       Album currAlbum = new Album(currAlbumName); 
                          
                  
                //If Artists names are EQUAL add the album to current Artist Object
                //If NEW ARTIST NAME is not equal to the one just read in
                //Need to consider the first time where newArtistName = Null
                
                //First Run
                if(prevArtistName == null)
                {
                    System.out.println("Null");
                    
                    //Add the current Album to the Album List
                     currAlbumList.add(currAlbum);                      
                    
                }
                //If Artist are equal add to Artist ArrayList
                else if(currArtistName.equals(prevArtistName))
                {                      
                   System.out.println("Are Equal");
                    
                   //Album is for the next Artist
                   //Add the current Album to the Album List
                    currAlbumList.add(currAlbum);                            
                }
                //They are not equal then new record
                else 
                {    

                    System.out.println("They are not equal");
                    

                  for(int i = 0; i < currAlbumList.size(); i++)
                    {
                        System.out.println(currAlbumList.get(i).getAlbumName());
                    }
                    
                    
                    
                    //Clear Album List
                    currAlbumList.clear();
                    
                    
                     //Add the current Album to the Album List
                     currAlbumList.add(currAlbum);  
                }     
                
       
                //SET currentArtist to newArtist for next record check
                  prevArtistName = currArtistName;
                
              
            }//end while
                
            //Close the connection
            connection.close();
        }          
        catch(SQLException ex) {
            System.out.println("Error accessing database: "+ ex.getMessage());
        }
    
       
        return artistImport;
    }
    
    
    /**
     * Method: Connection
     * @return
     * @throws SQLException 
     */
    private static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:sqlite:music_artists.sqlite";
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }//end getConnection
    
}//end class MusicDB
