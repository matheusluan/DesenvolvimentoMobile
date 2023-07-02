package com.example.bancodedados.data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    private static CarroDAO instance;

    private SQLiteDatabase db;

    private CarroDAO(Context context) {
        DBHelper dbHelper = DBHelper.getInstance(context);
        db = dbHelper.getWritableDatabase();
    }

    //singleton
    public static CarroDAO getInstance(Context context) {
        if (instance == null) {
            instance = new CarroDAO(context.getApplicationContext());
        }
        return instance;
    }

    public List<Carro> list() {

        String[] columns = {
                CarrosContract.Columns._ID,
                CarrosContract.Columns.NOME,
                CarrosContract.Columns.MOTOR,
                CarrosContract.Columns.MARCA

        };

        List<Carro> carros = new ArrayList<>();

        try (Cursor c = db.query(CarrosContract.TABLE_NAME, columns, null, null, null, null, CarrosContract.Columns.NOME)) {
            if (c.moveToFirst()) {
                do {
                    Carro p = CarroDAO.fromCursor(c);
                    carros.add(p);
                } while (c.moveToNext());
            }

            return carros;
        }

    }

    private static Carro fromCursor(Cursor c) {
        @SuppressLint("Range") int id = c.getInt(c.getColumnIndex(CarrosContract.Columns._ID));
        @SuppressLint("Range") String nome = c.getString(c.getColumnIndex(CarrosContract.Columns.NOME));
        @SuppressLint("Range") String marca = c.getString(c.getColumnIndex(CarrosContract.Columns.MARCA));
        @SuppressLint("Range") String motor = c.getString(c.getColumnIndex(CarrosContract.Columns.MOTOR));

        return new Carro(id, nome, marca, motor);
    }

    public void save(Carro carro) {
        ContentValues values = new ContentValues();
        values.put(CarrosContract.Columns.NOME, carro.getNome());
        values.put(CarrosContract.Columns.MARCA, carro.getMarca());
        values.put(CarrosContract.Columns.MOTOR, carro.getMotor());
        long id = db.insert(CarrosContract.TABLE_NAME, null, values);
        carro.setId((int) id);
    }

    public void update(Carro carro) {
        ContentValues values = new ContentValues();
        values.put(CarrosContract.Columns.NOME, carro.getNome());
        values.put(CarrosContract.Columns.MARCA, carro.getMarca());
        values.put(CarrosContract.Columns.MOTOR, carro.getMotor());
        db.update(CarrosContract.TABLE_NAME, values, CarrosContract.Columns._ID + " = ?", new String[]{ String.valueOf(carro.getId()) });
    }

    public void delete(Carro carro) {
        db.delete(CarrosContract.TABLE_NAME, CarrosContract.Columns._ID + " = ?", new String[]{ String.valueOf(carro.getId()) });
    }
}
