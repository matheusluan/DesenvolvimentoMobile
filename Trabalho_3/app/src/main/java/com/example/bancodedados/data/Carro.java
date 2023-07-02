package com.example.bancodedados.data;

import java.io.Serializable;

public class Carro implements Serializable {
    private int id;
    private String nome;
    private String marca;
    private String motor;

    public Carro(int id, String nome, String marca, String motor) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.motor = motor;
    }

    public Carro(String nome, String marca, String motor) {
        this.nome = nome;
        this.marca = marca;
        this.motor = motor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }


}
