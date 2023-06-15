package com.example.tarefa8;

import java.util.ArrayList;
import java.util.List;

public class Golf {

    public String nome;
    public Integer image;
    public String modelo;

    public Golf(String nome, Integer image, String modelo) {
        this.nome = nome;
        this.image = image;
        this.modelo = modelo;
    }

    public static List<Golf> getGolfs() {
        List<Golf> golfList = new ArrayList<>();

        golfList.add(new Golf("Sapão", R.drawable.golf, "MK4 - 1.6"));
        golfList.add(new Golf("VR6", R.drawable.vr6, "VR6 - 2.8"));
        golfList.add(new Golf("R32", R.drawable.r32, "R32 - 3.2t"));

        return golfList;
    }

}