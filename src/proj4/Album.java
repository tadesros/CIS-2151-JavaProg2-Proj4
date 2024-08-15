/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj4;

/**
 * Class: Album
 * @author tomad
 */
public class Album {
    
    //Member Data
    private String AlbumName;

    /**
     * Constructor
     * @param AlbumName 
     */
    public Album(String AlbumName) {
        this.AlbumName = AlbumName;
    }

    /**
     * Getter: getAlbumName
     * @return 
     */
    public String getAlbumName() {
        return AlbumName;
    }
    /**
     * Setter: AlbumName
     * @param AlbumName 
     */
    public void setAlbumName(String AlbumName) {
        this.AlbumName = AlbumName;
    }   
    
}//end Album blass
