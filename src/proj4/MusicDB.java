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
import java.util.List;

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
  
    /**
     * Method: getArtistList
     * @return ArrayList<Artist>
     */
    public ArrayList<Artist> getArtistList()
    {
           //Connection Objects
             Connection connection;
             
           //Data Sring 
           String currArtistName = null;
           String currAlbumName = null;
            
          //Create an array lists of Record Objects
            ArrayList<DbRecord> recordList = new ArrayList<DbRecord>();
            
          //GET Data and put in an ArrayList of Albums
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
                //Let's store these in an array for now.
               while(artists.next()) {                 
                         //GET CURRENT ROW DATA FROM THE CURRENT RECORD                               
                           //Get Artist Name
                             currArtistName = artists.getString("Artist_Name");                     
                           //Get Album Name
                             currAlbumName = artists.getString("Album_Name");             
                           //Set New Album Object
                             Album currAlbum = new Album(currAlbumName); 

                           //Create a dbRecordObject
                             DbRecord currRecord = new DbRecord(currArtistName, currAlbumName);

                           //Add to Array
                             recordList.add(currRecord);                                                     
                }//end while

                //Close the connection
                connection.close();
            }          
           catch(SQLException ex) {
                System.out.println("Error accessing database: "+ ex.getMessage());
            }
           
           ArrayList<ArrayList<String>> dynamic2DArray = new ArrayList<>();
       
           //Record List Size
            Integer recordListSize = recordList.size();
         
           //Set Artist Names
             String prevRecordArtistName = null;
             String currRecordArtistName = null;
            
           //Populate 2d String Array
             Integer currIndex2d = 0;
             //Populate a list of String arrays each containing Artist Name followed by albums
             for(int i = 0; i < recordList.size(); i++) {
                          
                 //SET CURRENT ARTIST NAME
                 currRecordArtistName = recordList.get(i).getArtistName();
                 
                 
                 if(i == 0)
                 {
                   dynamic2DArray.add(new ArrayList<>()); // Add a row  
                   dynamic2DArray.get(currIndex2d).add(recordList.get(i).getArtistName()); //Add artist to row
                   dynamic2DArray.get(currIndex2d).add(recordList.get(i).getAlbumName()); //Add album to row
                   
                   prevRecordArtistName = currRecordArtistName;
                
                
                 }
                 //SAME ARTIST 
                 else if (prevRecordArtistName.equals(currRecordArtistName)){
                     
                     dynamic2DArray.get(currIndex2d).add(recordList.get(i).getAlbumName());
                     prevRecordArtistName = currRecordArtistName;                     
                 } 
                 //DIFFERENT ARTIST
                 else{
                    
                     //Increase index of 2d array
                       currIndex2d++;
                                        
                     //Add a Row
                      dynamic2DArray.add(new ArrayList<>()); // Add a row  
                      
                      dynamic2DArray.get(currIndex2d).add(recordList.get(i).getArtistName()); //Add artist to row
                      dynamic2DArray.get(currIndex2d).add(recordList.get(i).getAlbumName()); //Add album
                      
                      prevRecordArtistName = currRecordArtistName; 
                 }                               
             }
       
           //PRINT THE 2D ARRAY
    //         System.out.println("Integer List of lists - "+dynamic2DArray);
            
           //PUT THE RECORDTS INTO artistImport Object
             for (int indexOut = 0; indexOut < dynamic2DArray.size(); indexOut++)
             {
                //Get store the artist name
                 String artistName = dynamic2DArray.get(indexOut).get(0);
                 
    //             System.out.println(artistName);
                 
                //For Every Record create Album and Arist objects
                  ArrayList<Album> currAlbumList = new ArrayList<>();  
                    
                //Go thru indexes 
                for(int indexRecord = 1; indexRecord < dynamic2DArray.get(indexOut).size();indexRecord++)
                {
                    //Create Album
                    Album currAlbum = new Album(dynamic2DArray.get(indexOut).get(indexRecord));
                    
                    currAlbumList.add(currAlbum);
                                       
                    
                }
    
               //  System.out.println("Elements of ArrayList are:"+currAlbumList);
                //Create a new Artist Object
                Artist currArtistList = new Artist(artistName, currAlbumList);
                
                artistImport.add(currArtistList);
                
                
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
