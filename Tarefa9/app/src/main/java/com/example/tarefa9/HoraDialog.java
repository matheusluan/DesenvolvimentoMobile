package com.example.tarefa9;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Calendar;

public class HoraDialog extends AppCompatDialogFragment implements TimePickerDialog.OnTimeSetListener {

    private OnTimeSetListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar now = Calendar.getInstance();
        int hora = now.get(Calendar.HOUR_OF_DAY);
        int min = now.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hora, min, true);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (!(context instanceof OnTimeSetListener)) {
            throw new IllegalArgumentException("Activity must implement TimeDialog.OnTimeSetListener");
        }

        this.listener = (OnTimeSetListener) context;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        listener.onTimeSet(hourOfDay, minute);
    }

    public interface OnTimeSetListener{
        void onTimeSet(int hour, int minute);
    }

}
