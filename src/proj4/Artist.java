package proj4;
import java.util.ArrayList;

/**
 * Class: Artist
 * @author tomad
 * This class holds properties of an artist including their name and 
 * a list of their Albums.
 */
public class Artist {
    
    //Member Data
    private String Name;
    
    //List of Albums       
    private ArrayList<Album> albumList; 

    
    /** METHODS **/
    
    /**
     * Constructor
     * @param Name - Name of the artist
     * @param albumList - ArrayList of Album objects
     */
    public Artist(String Name, ArrayList<Album> albumList) {     
        this.Name = Name;
        this.albumList = albumList;
    }

    /**
     * Method getName
     * @return - String Artist Name
     */
    public String getName() {
        return Name;
    }    
    
    /**
     * Method: getAlbumList 
     * @return  - array list of album Objects
     */
    public ArrayList<Album> getAlbumList() {
        return albumList;
    }      
    
    /**
     * Set artist Name
     * @param String - Artist Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Method: Set Album List
     * @param albumList - Album
     * Set the arrayList of Album elements
     */
    public void setAlbumList(ArrayList<Album> albumList) {
        this.albumList = albumList;
    }   
}//end Artist class
