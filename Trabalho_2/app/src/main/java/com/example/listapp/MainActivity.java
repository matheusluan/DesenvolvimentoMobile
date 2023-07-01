package com.example.listapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, ActionMode.Callback, ItemDialog.OnItemListener {

    private ListView list;
    private ItemAdapter adapter;
    private boolean inserir;
    private int item_selecionado;
    private String nome_item_selecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            ItemDialog dialog = new ItemDialog();
            dialog.show(getSupportFragmentManager(), "itemDialog");
            inserir = true;
        });

        list = findViewById(R.id.list);
        adapter = new ItemAdapter(this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.config) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        item_selecionado = position;
        nome_item_selecionado = (String) adapter.getItem(position);
        view.setBackgroundColor(Color.LTGRAY);
        startActionMode(this);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.excluir) {
            adapter.removeItem(item_selecionado);
            mode.finish();
            return true;
        } else if (id == R.id.excluir) {
            ItemDialog dialog = new ItemDialog();
            dialog.setItem(nome_item_selecionado);
            dialog.show(getSupportFragmentManager(), "itemDialog");
            inserir = false;
            mode.finish();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        View view = list.getChildAt(item_selecionado);
        view.setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    public void onItem(String item) {
        if(inserir) {
            adapter.insertItem(item);
        } else {
            adapter.updateItem(item_selecionado, item);
        }
    }
}