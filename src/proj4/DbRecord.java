package proj4;

/**
 * Class: DbRecord
 * @author tomad
 * This class contains two elements the artistName and albumName
 * The purpose of this class is to help with parsing the incoming database record.
 */
public class DbRecord {
    
    //Member Data
    private String artistName;
    private String albumName;
        
    /*** METHODS ***/
    
    /**
     * Method: DbRecord
     * @param artistName - String artistName
     * @param albumName  - String albumName
     */
    public DbRecord(String artistName, String albumName) {
        this.artistName = artistName;
        this.albumName = albumName;
    }
        
    /**
     * Method: getArtistName 
     * @return String ArtistName
     */
    public String getArtistName() {
        return artistName;
    }
    
    /**
     * Method: getAlbumName
     * @return - String with Album Name
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * Method: setArtistName
     * @param artistName - return a string with the artist name
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /**
     * Method: setAlbumName
     * @param albumName - set the Album Name 
     */
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
       
} //End DbRecord class
