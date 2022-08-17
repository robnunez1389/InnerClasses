package com.company;

public class Song {
    private String songTitle;
    private double duration;

    public Song(String title, double duration) {
        this.songTitle = title;
        this.duration = duration;
    }

    public String getSongTitle() {
        return songTitle;
    }

    @Override
    public String toString() {
        return this.songTitle + ": " + this.duration;
    }

    //    public double getDuration() {
//        return duration;
//    }

}
