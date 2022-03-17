package com.example.voltify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity {

    EditText edtTxt;
    Button importButton, exportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        ManageFile manageFile = new ManageFile();
        Context context = getApplicationContext();
        edtTxt = findViewById(R.id.edtTxt);
        importButton = findViewById(R.id.importButton);
        exportButton = findViewById(R.id.exportButton);

        Intent intent = getIntent();
        String s = intent.getStringExtra("songsList");
        edtTxt.setText(s);

        importButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageFile.jsonDecode(context);
            }
        });

        exportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = edtTxt.getText().toString();
                manageFile.writeFile("Text.txt", txt, context);
                Toast.makeText(context, "File correctly written", Toast.LENGTH_SHORT).show();
            }
        });

    }
}