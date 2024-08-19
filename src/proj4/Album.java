package proj4;

/**
 * Class: Album
 * @author tomad
 * This class holds an Album Name 
 */
public class Album {
    
    //Member Data
    private String AlbumName;
    
    
    //** METHODS **

    /**
     * Constructor
     * @param String AlbumName : Holds the name of the Album 
     */
    public Album(String AlbumName) {
        this.AlbumName = AlbumName;
    }

    /**
     * Method: getAlbumName
     * @return Return the Album Name - String 
     */
    public String getAlbumName() {
        return AlbumName;
    }
    
    /**
     * Setter: AlbumName
     * @param AlbumName - String AlbumName
     * Set the Album name 
     */
    public void setAlbumName(String AlbumName) {
        this.AlbumName = AlbumName;
    }   
    
}//end Album class
