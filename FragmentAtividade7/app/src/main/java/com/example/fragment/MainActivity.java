package com.example.fragment;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentBotao.OnChangeColorListener {

    private FragmentCor colorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorFragment = (FragmentCor) getSupportFragmentManager().findFragmentById(R.id.colorFragment);
    }

    @Override
    public void changeColor(int color) {
        colorFragment.setColor(color);
    }

}