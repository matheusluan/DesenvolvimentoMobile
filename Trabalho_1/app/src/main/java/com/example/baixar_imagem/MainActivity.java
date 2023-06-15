package com.example.baixar_imagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ImageButton baixarBtn;
    private EditText edit_Url;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baixarBtn = findViewById(R.id.downloadButton);
        edit_Url = findViewById(R.id.editUrl);
        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);

        baixarBtn.setOnClickListener(v -> {
            BaixarImg task = new BaixarImg(baixarBtn, imageView, progressBar);
            task.execute(edit_Url.getText().toString());
        });
    }
}