package com.jdk.GameUp.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
public class Gioco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private Set<Genere> genere;
    @NotNull
    private int annoUscita;
    @NotNull
    private String sviluppatore;
    @NotNull
    private Set<Piattaforma> piattaforme;
    @OneToMany(mappedBy = "giocoDiRiferimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Dlc> dlc;

    //Costruttore parametrizzato
    public Gioco(String nome, Set<Genere> genere, int annoUscita, String sviluppatore, Set<Dlc> dlc,
                 Set<Piattaforma> piattaforme) {
        this.nome = nome;
        this.genere = genere;
        this.annoUscita = annoUscita;
        this.sviluppatore = sviluppatore;
        this.dlc = dlc;
        this.piattaforme = piattaforme;
    }

    //Costruttore per loader
    public Gioco(String nome, int annoUscita, String sviluppatore){
        this.nome = nome;
        this.annoUscita = annoUscita;
        this.sviluppatore = sviluppatore;
    };

    //Costruttore vuoto
    public Gioco(){}

    //Getter e setter
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

    public Set<Genere> getGenere() {
        return genere;
    }

    public void setGenere(Set<Genere> genere) {
        this.genere = genere;
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

    public Set<Piattaforma> getPiattaforme() {
        return piattaforme;
    }

    public void setPiattaforme(Set<Piattaforma> piattaforme) {
        this.piattaforme = piattaforme;
    }

    public Set<Dlc> getDlc() {
        return dlc;
    }

    public void setDlc(Set<Dlc> dlc) {
        this.dlc = dlc;
    }
}
