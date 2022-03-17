package com.example.voltify;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class SongManager {
    ArrayList<Song> songs = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public void addSong(String title, String artist, String genre, Integer duration) {
        Song song = new Song(title, artist, genre, duration);
        songs.add(song);
    }

    public String showSongs(Context context) {
        StringBuilder sb = new StringBuilder();
        for (Song s : songs) {
            sb.append(s.getTitle() + ",");
            sb.append(s.getArtist() + ",");
            sb.append(s.getGenre() + ",");
            sb.append(s.getDuration().toString() + ",");
        }
        String string = sb.toString();
        return string;
    }
}