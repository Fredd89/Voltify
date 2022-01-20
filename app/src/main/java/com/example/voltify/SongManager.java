package com.example.voltify;

import android.util.Log;

import java.util.ArrayList;

public class SongManager {
    ArrayList<Song> songs = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public void addSong(String title, String artist, String genre, Integer duration) {
        Song song = new Song(title, artist, genre, duration);
        songs.add(song);
    }

    public String showSongs() {
        Log.d("stringBuilded", "ciaooo");
        StringBuilder sb = new StringBuilder();
        for (Song s : songs) {
            sb.append(s.getTitle() + "-");
            sb.append(s.getArtist() + "-");
            sb.append(s.getDuration() + "-");
            sb.append(s.getGenre() + "-");
        }
        String s = sb.toString();
        return s;
    }
}