package com.jdk.GameUp.Entity;

import jakarta.persistence.Entity;

import java.util.Set;

@Entity
public class Editore extends Azienda{

    private Set<Gioco> giochiPubblicati;
    private Set<Dlc> dlcPubblicati;

    public Editore(String nome, String sedeCitta) {
        super(nome, sedeCitta);
    }
}
