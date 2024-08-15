/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj4;
import java.util.ArrayList;

/**
 * Class: Artist
 * @author tomad
 */
public class Artist {
    
    //Data
    private String Name;
    
    //List of Albums       
    private ArrayList<Album> albumList; 

    /**
     * Constructor
     * @param Name 
     */
    public Artist(String Name, ArrayList<Album> albumList) {     
        this.Name = Name;
        this.albumList = albumList;
    }

    /**
     * Getter
     * @return 
     */
    public String getName() {
        return Name;
    }    
    
    /**
     * Get Album
     * @return 
     */
    public ArrayList<Album> getAlbumList() {
        return albumList;
    }      
    
    /**
     * Setter
     * @param Name 
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * 
     * @param albumList 
     */
    public void setAlbumList(ArrayList<Album> albumList) {
        this.albumList = albumList;
    }
        
    
}//end Artist class
