package com.company;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private SongList trackList;

    public Album(String name) {
        this.name = name;
        this.trackList = new SongList();
    }

    public String getName() {
        return name;
    }

    public Song findSong(String songTitle){
        for (Song song : this.trackList.songs) {
            if (songTitle.equals(song.getSongTitle())) {
                return song;
            }
        }
        return null;
    }

    public void addSong(String songTitle, double duration){
        this.trackList.songs.add(new Song(songTitle,duration));
    }

    // Inner class to create list for songs.
    private class SongList {
        private List<Song> songs = new ArrayList<>();
        public List<Song> getSongs() {
            return songs;
        }
    }
}
