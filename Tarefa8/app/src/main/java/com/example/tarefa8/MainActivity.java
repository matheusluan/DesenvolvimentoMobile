package com.example.tarefa8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView golfs = findViewById(R.id.list_golf_mkr);

        List<Golf> golfss = Golf.getGolfs();

        golfs.setAdapter(new Adapter(this, golfss));
        golfs.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Golf golfao = (Golf) parent.getAdapter().getItem(position);
        Toast.makeText(this, "Golfão: " + golfao.nome, Toast.LENGTH_SHORT).show();
    }
}