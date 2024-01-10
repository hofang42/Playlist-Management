/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlistmanagement;

/**
 *
 * @author hoang
 */
public class Song {

    private String title;
    private String artist;
    private Song next;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public Song() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }    
    
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Song getNext() {
        return next;
    }

    public void setNext(Song next) {
        this.next = next;
    }

}
