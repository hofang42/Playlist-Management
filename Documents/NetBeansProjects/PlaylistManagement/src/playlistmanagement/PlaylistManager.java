/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlistmanagement;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class PlaylistManager {

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===================MENU========================");
            System.out.println("Press 1 to add new song");
            System.out.println("Press 2 to add new song in index");
            System.out.println("Press 3 to remove a song");
            System.out.println("Press 4 to shuffle the playlist");
            System.out.println("Press 5 to skip to the next song");
            System.out.println("Press 6 to skip to the previous song");
            System.out.println("Press 7 to show song is playing");
            System.out.println("Press 8 to print out queue");
            System.out.println("Press any key to exit");
            System.out.println("===============================================");
            System.out.print("Enter your option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            String title, artist;
            int index;
            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    title = sc.nextLine();
                    System.out.print("Enter artist: ");
                    artist = sc.nextLine();
                    playlist.addSong(new Song(title, artist));
                    System.out.println("New song added successful");
                    playlist.print();
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    title = sc.nextLine();
                    System.out.print("Enter artist: ");
                    artist = sc.nextLine();
                    System.out.println("Enter index");
                    index = sc.nextInt();
                    playlist.addSongIndex(new Song(title, artist), index);
                    break;
                case 3:
                    System.out.print("Enter song's title need to remove: ");
                    title = sc.nextLine();
                    playlist.removeSong(title);
                    break;
                case 4:
                    playlist.shuffle();
                    System.out.println("Shuffle success");
                    break;
                case 5:
                    System.out.println("You are skip to the next song");
                    playlist.nextSong();
                    break;
                case 6:
                    System.out.println("You are skip to the previous song");
                    playlist.prevSong();
                    break;
                case 7:  
                    try {
                    System.out.println("You are playing " + playlist.getCurr().getTitle());
                } catch (NullPointerException e) {
                    System.err.println("Please choose one song");
                }
                break;
                case 8:
                    playlist.print();
//                    System.out.println("listening " + playlist.getCurr().getTitle() + "-" + playlist.getCurr().getArtist());
                    break;
                default:
                    System.exit(0);
            }
        }

    }
}
