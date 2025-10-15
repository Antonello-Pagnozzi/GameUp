package com.jdk.GameUp.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Azienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sedeCitta;

    public Azienda(String nome, String sedeCitta) {
        this.nome = nome;
        this.sedeCitta = sedeCitta;
    }

    //getter e setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSedeCitta() {
        return sedeCitta;
    }

    public void setSedeCitta(String sedeCitta) {
        this.sedeCitta = sedeCitta;
    }
}
