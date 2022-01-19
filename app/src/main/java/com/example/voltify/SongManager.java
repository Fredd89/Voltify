package com.example.voltify;

import java.util.ArrayList;

public class SongManager {
    ArrayList<Song> songs = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public void addSong(String title, String artist, String genre, Integer duration) {
        Song song = new Song(title, artist, genre, duration);
        songs.add(song);
    }

    public void showSongs() {
        
    }

}