package com.example.tarefa9;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Calendar;

public class DateDialog extends AppCompatDialogFragment implements DatePickerDialog.OnDateSetListener {

    private OnDateSetListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar now = Calendar.getInstance();
        int dia = now.get(Calendar.DAY_OF_MONTH);

        int mes = now.get(Calendar.MONTH);
        int ano = now.get(Calendar.YEAR);


        return new DatePickerDialog(getActivity(), this, ano, mes, dia);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (!(context instanceof OnDateSetListener)) {
            throw new IllegalArgumentException("Activity must implement DateDialog.OnDateSetListener");
        }

        this.listener = (OnDateSetListener) context;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        listener.onDateSet(year, month, dayOfMonth);
    }

    public interface OnDateSetListener{
        void onDateSet(int year, int month, int day);

        @SuppressLint("DefaultLocale")
        void onTimeSet(int hour, int minute);
    }

}