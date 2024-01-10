/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlistmanagement;

import java.util.Random;

/**
 *
 * @author hoang
 */
public class Playlist {

    private Song head;
    private Song curr;
    private Song tail;

    public boolean isEmpty() {
        return head == null;
    }

    public Song getHead() {
        return head;
    }

    public Song getCurr() {
        return curr;
    }

    public void addSong(Song newSong) {
        if (isEmpty()) {
            head = newSong;
            curr = head;
        } else {
            Song temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newSong);
        }
    }

    public void addSongIndex(Song newSong, int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            addSongFirst(newSong);
        } else {
            Song temp = head;
            int pos = 0;
            while (temp != null) {
                if (index - 1 == pos) {
                    break;
                }
                temp = temp.getNext();
                pos++;
            }
            if (temp == null) {
                return;
            } else {
                if (temp.getNext() == null) {
                    addSong(newSong);
                } else {
                    newSong.setNext(temp.getNext());
                    temp.setNext(newSong);
                }

            }

        }
    }

    public void addSongFirst(Song newSong) {
        if (isEmpty()) {
//            head = newSong;
            head = tail = newSong;
            curr = head;
        } else {
            newSong.setNext(head);
            head = newSong;
        }
    }

    public void removeSong(String title) {
        if (isEmpty()) {
            return;
        }
        if (head.getTitle().equals(title)) {
            if (curr == head) {
                head = head.getNext();
                curr = head;
            }
            return;
        }
        if (curr.getTitle().equals(title)) {
            curr = curr.getNext();
        }
        Song temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getTitle().equals(title)) {
                temp.setNext(temp.getNext().getNext());
                if (curr == temp.getNext()) {
                    curr = temp;
                }
                return;
            }
            temp = temp.getNext();
        }
    }

    public void nextSong() {
        if (curr != null && curr.getNext() != null) {
            curr = curr.getNext();
        }
    }

    public void prevSong() {
        if (head == null || curr == head) {
            return;
        }

        Song temp = head;
        while (temp.getNext() != curr) {
            temp = temp.getNext();
        }
        curr = temp;
    }

    public void shuffle() {
        Random rand = new Random();
        int songCount = 0;
        Song temp = head;

        while (temp != null) {
            songCount++;
            temp = temp.getNext();
        }

        for (int i = songCount - 1; i > 0; i--) {
            int randomIndex = rand.nextInt(i + 1);

            Song song1 = findIndex(randomIndex);
            Song song2 = findIndex(i);

            swapSongs(song1, song2);
        }

        curr = head;
    }

    Song findIndex(int index) {
        if (index < 0 || head == null) {
            return null;
        }
        if (index == 0) {
            return head;
        }
        Song temp = head;
        int pos = 0;
        while (temp != null) {
            if (index == pos) {
                break;
            }
            temp = temp.getNext();
            pos++;
        }
        return temp;
    }

    public void swapSongs(Song song1, Song song2) {
        if (song1 == null || song2 == null || song1 == song2) {
            return;
        }
        Song pred1 = findPrevSong(song1);
        Song pred2 = findPrevSong(song2);
        if (pred1 != null) {
            pred1.setNext(song2);
        } else {
            head = song2;
        }
        if (pred2 != null) {
            pred2.setNext(song1);
        } else {
            head = song1;
        }

        Song temp = song1.getNext();
        song1.setNext(song2.getNext());
        song2.setNext(temp);

        if (tail == song1) {
            tail = song2;
        } else if (tail == song2) {
            tail = song1;
        }
    }

    public Song findPrevSong(Song song) {
        if (song == null || head == null || head == song) {
            return null;
        }
        Song current = head;

        while (current != null && current.getNext() != song) {
            current = current.getNext();
        }

        return current;
    }

    public void print() {
        Song temp = head;
        while (temp != null) {
            System.out.println(temp.getTitle() + " - " + temp.getArtist());
            temp = temp.getNext();
        }
    }

    //
//    void removeFirst() {
//        if (isEmpty()) {
//            return;
//        } else {
//            head = head.getNext();
//        }
//    }
//
//    void removeLast() {
//        if (isEmpty()) {
//            return;
//        } else {
//            Song temp = head;
//            while (temp != tail) {
//                temp = temp.getNext();
//            }
//            temp.setNext(null);
//            tail = temp;
//        }
//    }
//    public void removeSongIndex(int index) {
//        if (index < 0) {
//            return;
//        }
//        if (index == 0) {
//            removeFirst();
//        } else {
//            Song temp = head;
//            int pos = 0;
//            while (temp.getNext() != null) {
//                if (index - 1 == pos) {
//                    break;
//                }
//                temp = temp.getNext();
//                pos++;
//            }
//            if (temp.getNext() == null) {
//                return;
//            }
//            if (temp.getNext() == tail) {
//                removeLast();
//            } else {
//                curr = temp.getNext();
//                temp.setNext(curr);
//            }
//        }
//    }
}
