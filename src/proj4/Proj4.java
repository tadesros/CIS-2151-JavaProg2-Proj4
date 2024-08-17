/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj4;

import java.util.ArrayList;

/**
 * Class: Proj4
 * @author tomad
 */
public class Proj4 {
    
       //Data Members
       static ArrayList<Artist> artistList; 
    
    
     /**
     * Method: Main
     * @param args the command line arguments
     */
     public static void main(String[] args) {  
         
          System.out.println("Main Menu!");
         
         
         //Declare an Artist ArrayList 
          artistList = new ArrayList<>(); 
          
          
           MusicDB conDB;
         //Declare a connection object
           conDB = new MusicDB();
         
     //      conDB.TestDB();
        artistList = conDB.getArtistList();
         
      
     }//end Main
    
    
    
    
    
}//end class Proj4
