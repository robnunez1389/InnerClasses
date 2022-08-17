package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Copy of LinkListChallenge to
 * implement inner classes.
 */

public class MusicApp {
    private static LinkedList<Song> playlist = new LinkedList<>();
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Lil Baby");
        album.addSong("My Dawg", 4.21);
        album.addSong("Eat or Starve", 3.25);
        album.addSong("Drip Too Hard", 3.56);
        album.addSong("Yes Indeed", 4.44);
        album.addSong("Emotionally Scarred", 4.01);
        album.addSong("Solid", 5.03);
        album.addSong("No Sucker", 3.37);

        Album album1 = new Album("Drake");
        album1.addSong("In The Bible", 4.21);
        album1.addSong("Fair Trade", 3.25);
        album1.addSong("Knife Talk", 3.56);
        album1.addSong("Pound Cake", 4.44);
        album1.addSong("All Me", 4.01);
        album1.addSong("Nonstop", 5.03);
        album1.addSong("I'm Upset", 3.37);

        Album album2 = new Album("Chris Brown");
        album2.addSong("Addicted", 4.21);
        album2.addSong("Psychic", 3.25);
        album2.addSong("Privacy", 3.56);
        album2.addSong("Pills & Automobiles", 4.44);
        album2.addSong("Overtime", 4.01);
        album2.addSong("Come Together", 5.03);
        album2.addSong("No Guidance", 3.37);

        albums.add(album);
        albums.add(album1);
        albums.add(album2);

        addSong("Addicted");
        addSong("Overtime");
        addSong("In The Bible");
        addSong("All Me");
        addSong("Drip Too Hard");
        addSong("Solid");
        addSong("Eat or Starve");

        startPlaylist();

    }

    private static boolean addSong(String songTitle){
        for (Album album : albums) {
            Song song = album.findSong(songTitle);
            if (song != null) {
                playlist.add(song);
                System.out.println("Song: '" + song.getSongTitle() + "' added to playlist");
                return true;
            }
        }
        System.out.println("Song: '" + songTitle + "' could not be found.");
        return false;
    }

    private static void startPlaylist(){
        Scanner scanner = new Scanner(System.in);
        Song lastSong = null;
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if(playlist.isEmpty()){
            System.out.println("No songs in playlist");
            return;
        }else {
            System.out.println("Now playing: " + listIterator.next().toString());
            printOptions();
        }

        while(!quit){
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 0:
                    System.out.println("Quitting playlist...");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        lastSong = listIterator.next();
                        System.out.println("Now playing " + lastSong.toString());
//                        
                    } else {
                        System.out.println("Reached the end of the playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        lastSong = listIterator.previous();
                        System.out.println("Now playing " + lastSong.toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    System.out.println("Now playing: " + lastSong.toString());
                    break;
                case 4:
                    printPlaylist();
                    break;
                case 5:
                    printOptions();
                    break;
                case 6:
                    // Removing an object from linkedList without exception
                    if(playlist.size()>0){
                        int index = playlist.lastIndexOf(lastSong);
                        System.out.println(playlist.get(index).toString() + " removed from playlist.");
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());
                        }
                    }
                    break;

            }
        }

    }

    private static void printPlaylist() {
        System.out.println("Playlist Songs:");
        for(int i = 0; i<playlist.size(); i++){
            System.out.println((i+1)+ ". " + playlist.get(i).getSongTitle());
        }
    }

    private static void printOptions() {
        System.out.println("Playlist Options:\n" +
                "0 - Quit\n"+
                "1 - Next Song\n"+
                "2 - Previous Song\n"+
                "3 - Replay Current Song\n"+
                "4 - List Songs in Playlist\n" +
                "5 - Show Options\n" +
                "6 - Remove Song");
    }
}
