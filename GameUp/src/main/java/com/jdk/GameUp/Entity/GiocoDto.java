package com.jdk.GameUp.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class GiocoDto {

    private String nome;
    private Set<Genere> genere;
    private int annoUscita;
    private String sviluppatore;
    private Set<Piattaforma> piattaforme;

    // Getter e setter
    public Set<Piattaforma> getPiattaforme() {
        return piattaforme;
    }

    public void setPiattaforme(Set<Piattaforma> piattaforme) {
        this.piattaforme = piattaforme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSviluppatore() {
        return sviluppatore;
    }

    public void setSviluppatore(String sviluppatore) {
        this.sviluppatore = sviluppatore;
    }

    public int getAnnoUscita() {
        return annoUscita;
    }

    public void setAnnoUscita(int annoUscita) {
        this.annoUscita = annoUscita;
    }

    public Set<Genere> getGenere() {
        return genere;
    }

    public void setGenere(Set<Genere> genere) {
        this.genere = genere;
    }
}
