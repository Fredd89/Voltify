package com.example.voltify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText title, artist, genre, duration;
    Button insert, show;
    SongManager songManager = new SongManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        artist = findViewById(R.id.artist);
        genre = findViewById(R.id.genre);
        duration = findViewById(R.id.duration);
        insert = findViewById(R.id.insert);
        show = findViewById(R.id.show);
        SongManager songManager = new SongManager();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songManager.addSong(title.getText().toString(), artist.getText().toString(), genre.getText().toString(), Integer.getInteger(duration.getText().toString()));
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}