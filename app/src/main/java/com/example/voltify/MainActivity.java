package com.example.voltify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText title, artist, duration;
    Spinner genre;
    Button insert, show;
    SongManager songManager = new SongManager();
    String genres[] = {"Pop", "Rap", "Classic", "Rock"};

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
        Context context = getApplicationContext();
        SongManager songManager = new SongManager();
        ArrayAdapter genresAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, genres);

        genre.setAdapter(genresAdapter);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songManager.addSong(title.getText().toString(), artist.getText().toString(), genre.getSelectedItem().toString(), Integer.parseInt(duration.getText().toString()));
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                String string = songManager.showSongs(context);
                Log.d("Dio lupo", string);
                intent.putExtra("songsList", string);
                startActivity(intent);
            }
        });
    }
}