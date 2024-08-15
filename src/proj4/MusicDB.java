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


/**
 * Class: MusicDB
 * @author tomad
 */
public class MusicDB {

    public MusicDB() {
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    public void TestDB(){
    
       Connection connection;
         
         
        try{
                connection = getConnection();
                Statement statement = connection.createStatement();
                
                String query = "SELECT * FROM ARTISTS";
                
                ResultSet artists = statement.executeQuery(query);
                
                  while(artists.next()) {
                      
                      System.out.print(artists.getString("Name") + "\t");
                  
                      
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
