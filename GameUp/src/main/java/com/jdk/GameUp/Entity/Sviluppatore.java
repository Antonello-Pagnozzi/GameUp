package com.jdk.GameUp.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Sviluppatore extends Azienda {

    @OneToMany(mappedBy = "sviluppatore", cascade = CascadeType.ALL)
    private Set<Gioco> giochiSviluppati;
    private Set<Dlc> dlcSviluppati;

    public Sviluppatore(String nome, String sedeCitta) {
        super(nome, sedeCitta);
    }

    public Set<Gioco> getGiochiSviluppati() {
        return giochiSviluppati;
    }

    public void setGiochiSviluppati(Set<Gioco> giochiSviluppati) {
        this.giochiSviluppati = giochiSviluppati;
    }

    public Set<Dlc> getDlcSviluppati() {
        return dlcSviluppati;
    }

    public void setDlcSviluppati(Set<Dlc> dlcSviluppati) {
        this.dlcSviluppati = dlcSviluppati;
    }
}
