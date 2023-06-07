package com.example.atv6;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Toast.makeText(this, R.string.add_message, Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit:
                Toast.makeText(this, R.string.edit_message, Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove:
                Toast.makeText(this, R.string.remove_message, Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(this, R.string.help_message, Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}