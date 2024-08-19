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
    
    //Arraylist of Artist objects
    static ArrayList<Artist> artistImport; 
    
    /** METHODS **/
          
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
     * This method connects to the database SQLLite
     * Pulls in the data
     * Stores the data in appropriate format
     * Returns the data in Artist - Album, Album, etc.  = format
     */
    public ArrayList<Artist> getArtistList()
    {
           //Connection Object        
            Connection connection;
             
           //Artist Name and Album Name Strings = Null
           String currArtistName = null;
           String currAlbumName = null;
            
          //Create an array lists of Record Objects - to help parsing data records
            ArrayList<DbRecord> recordList = new ArrayList<DbRecord>();
            
          //GET Data and put in an ArrayList of Albums
           try{
                //Initialize Connection Object
                  connection = getConnection();
                  Statement statement = connection.createStatement();

               //Get Artists and Albums put them in alphabetical order 
               //Store the album names as "Artist_Name" and "Album_Name"
               String query =  "SELECT Artists.Name as 'Artist_Name', Albums.Name as 'Album_Name'"
                               + " FROM Artists" 
                               + " INNER JOIN Albums ON Albums.ArtistID = Artists.ArtistID"
                               + " ORDER BY Artist_Name ASC, Album_Name ASC";

                //Execute the SQL - query and return results in ResultSet
                  ResultSet artists = statement.executeQuery(query);  

                //Create album ArrayList
                  ArrayList<Album> currAlbumList = new ArrayList<Album>();

                //Loop for going thru each row of the Database Results     
                //Let's store these in an array for now.
               while(artists.next()) {                 
                         //GET DATA FROM THE CURRENT RECORD                               
                           //Get Artist Name
                             currArtistName = artists.getString("Artist_Name");                     
                           //Get Album Name
                             currAlbumName = artists.getString("Album_Name");             
                           //Create an Albumn object 
                             Album currAlbum = new Album(currAlbumName); 

                           //Create a dbRecordObject
                             DbRecord currRecord = new DbRecord(currArtistName, currAlbumName);

                           //Add to recordList the dbRecordObject
                             recordList.add(currRecord);                                                     
                }//end while

                //Close the connection
                connection.close();
            }          
           catch(SQLException ex) {
                System.out.println("Error accessing database: "+ ex.getMessage());
            }
                  
           //Need a dynamic2DArray to help combine Artist records with Album records
             ArrayList<ArrayList<String>> dynamic2DArray = new ArrayList<>();
       
           //Get the list size of the record
            Integer recordListSize = recordList.size();
         
           //For checking if same artist on next record need String variables. 
             String prevRecordArtistName = null;
             String currRecordArtistName = null;
            
           //Populate 2d String Array
           //As you go thru store the results in the form = "Artist - ALbum - Album - etc."
             Integer currIndex2d = 0;
             //Populate a list of String arrays each containing Artist Name followed by albums
             for(int i = 0; i < recordList.size(); i++) {
                          
                 //SET CURRENT ARTIST NAME
                 currRecordArtistName = recordList.get(i).getArtistName();
                 
                 //If this is the first record in the list
                 if(i == 0)
                 {
                   dynamic2DArray.add(new ArrayList<>()); // Add a row  
                   dynamic2DArray.get(currIndex2d).add(recordList.get(i).getArtistName()); //Add artist to row
                   dynamic2DArray.get(currIndex2d).add(recordList.get(i).getAlbumName()); //Add album to row
                   
                   prevRecordArtistName = currRecordArtistName;
                
                
                 }
                 //Current record has the same artist as previous. 
                 //Same the album name under previous artist.
                 else if (prevRecordArtistName.equals(currRecordArtistName)){
                     
                     dynamic2DArray.get(currIndex2d).add(recordList.get(i).getAlbumName());
                     prevRecordArtistName = currRecordArtistName;                     
                 } 
                 //Current artist and previous artist are not equal
                 //Create a new entry 
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
       
  
           //PUT THE RECORDTS INTO artistImport Object
             for (int indexOut = 0; indexOut < dynamic2DArray.size(); indexOut++)
             {
                //Get store the artist name
                 String artistName = dynamic2DArray.get(indexOut).get(0);                 
           
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
     * @return a connection object
     * @throws SQLException 
     */
    private static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:sqlite:music_artists.sqlite";
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }//end getConnection
    
}//end class MusicDB
