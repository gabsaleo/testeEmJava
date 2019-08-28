package com.example.testeemjava;

public class Animal {
    private String nome;
    private int idAnimal;

    public Animal(String nome, int idAnimal) {
        this.nome = nome;
        this.idAnimal = idAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
}
