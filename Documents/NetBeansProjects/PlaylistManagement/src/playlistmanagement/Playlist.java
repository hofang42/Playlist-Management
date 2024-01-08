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
            head = head.getNext();
            if (curr == head) {
                curr = head;
            }
            return;
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

    public void removeSongIndex(int index) {
        if (isEmpty()) {
            return;
        }
        if (index < 0) {
            return;
        }
        if (index == 0) {
            removeSong(head.getTitle());
        } else {
            Song temp = head;
            int pos = 0;
            while (temp.getNext() != null) {
                if (index - 1 == pos) {
                    break;
                }
                temp = temp.getNext();
                pos++;
            }
            if (temp.getNext() == null) {
                return;
            }
            if (temp.getNext() == tail) {
                removeSong(tail.getTitle());
                tail = temp;
            } else {
                curr = temp.getNext();
                temp.setNext(curr);
            }
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
        Song temp = head;
        int songCount = 0;
        while (temp != null) {
            songCount++;
            temp = temp.getNext();
        }
        for (int i = 0; i < songCount; i++) {
            int randomRemoveIndex = rand.nextInt(songCount - i);
            int randomAddIndex = rand.nextInt(songCount);
            System.out.println(randomRemoveIndex + " - " + randomAddIndex);
            Song removedSong = findIndex(randomRemoveIndex);
            removeSongIndex(randomRemoveIndex);
            addSongIndex(removedSong, randomAddIndex);
            if (removedSong == tail) {
                tail = findIndex(songCount - 1);
            }
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

    public void print() {
        Song temp = head;
        while (temp != null) {
            System.out.println(temp.getTitle() + " - " + temp.getArtist());
            temp = temp.getNext();
        }
    }

}
