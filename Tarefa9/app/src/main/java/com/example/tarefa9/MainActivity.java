package com.example.tarefa9;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DateDialog.OnDateSetListener, HoraDialog.OnTimeSetListener {

    private TextView dateTimeText;
    String data = "", hora = "";

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTimeText = findViewById(R.id.dateTimeText);

        Calendar now = Calendar.getInstance();
        int ano = now.get(Calendar.YEAR);
        int mes = now.get(Calendar.MONTH);
        int dia = now.get(Calendar.DAY_OF_MONTH);
        int hr = now.get(Calendar.HOUR_OF_DAY);
        int min = now.get(Calendar.MINUTE);

        data = String.format("%02d/%02d/%d", dia, mes+1, ano);
        hora = String.format("%02d:%02d", hr, min);

        dateTimeText.setText(String.format("%s %s", data, hora));

        Button dateButton = findViewById(R.id.dateButton);
        Button hourButton = findViewById(R.id.hourButton);

        dateButton.setOnClickListener(v -> {
            DateDialog dialog = new DateDialog();
            dialog.show(getSupportFragmentManager(), "dateDialog");
        });

        hourButton.setOnClickListener(v -> {
            HoraDialog dialog = new HoraDialog();
            dialog.show(getSupportFragmentManager(), "timeDialog");
        });
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onDateSet(int year, int month, int day) {
        data = String.format("%02d/%02d/%d", day, month+1, year);
        dateTimeText.setText(String.format("%s %s", data, hora));
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onTimeSet(int hour, int minute) {
        hora = String.format("%02d:%02d", hour, minute);
        dateTimeText.setText(String.format("%s %s", data, hora));
    }

}