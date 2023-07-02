package com.example.bancodedados.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bancodedados.R;
import com.example.bancodedados.data.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroAdapter extends BaseAdapter {
    private Context context;
    private List<Carro> carros = new ArrayList<>();

    public CarroAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Carro getItem(int i) {
        return carros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return carros.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_listprodutos, viewGroup, false);

        TextView txtNome = v.findViewById(R.id.txt_nome);
        TextView txtMarca = v.findViewById(R.id.txt_marca);
        TextView txtMotor = v.findViewById(R.id.txt_motor);

        Carro carro = carros.get(i);
        txtNome.setText(carro.getNome());
        txtMarca.setText(carro.getMarca());
        txtMotor.setText(carro.getMotor());

        return v;
    }

    public void setItems(List<Carro> carros) {
        this.carros = carros;
        notifyDataSetChanged();
    }
}
