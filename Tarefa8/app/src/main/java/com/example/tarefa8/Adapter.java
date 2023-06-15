package com.example.tarefa8;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    private final Context context;
    private final List<Golf> golfs;

    public Adapter(Context context, List<Golf> golfs) {
        this.context = context;
        this.golfs = golfs;
    }

    @Override
    public int getCount() {
        return golfs.size();
    }

    @Override
    public Object getItem(int position) {
        return golfs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder")
        View view = LayoutInflater.from(context).inflate(R.layout.list_golf_mkr, parent, false);
        TextView nome = view.findViewById(R.id.nome_golf);
        ImageView img = view.findViewById(R.id.img_golf);
        TextView modelo = view.findViewById(R.id.modelo_golf);

        Golf golf = golfs.get(position);

        nome.setText(golf.nome);
        img.setImageResource(golf.image);
        modelo.setText(golf.modelo);

        return view;
    }
}
