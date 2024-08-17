/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj4;

/**
 *
 * @author tomad
 */
public class DbRecord {
    
    //Member Data
    private String artistName;
    private String albumName;
    
    //Constructor

    public DbRecord(String artistName, String albumName) {
        this.artistName = artistName;
        this.albumName = albumName;
    }
        

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
       
}
