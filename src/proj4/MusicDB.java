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
                
        }          
        catch(SQLException ex) {
            System.out.println("Error accessing database: "+ ex.getMessage());
        }
    
    
    
   }//End TestDB
    
    
    
    
    
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
