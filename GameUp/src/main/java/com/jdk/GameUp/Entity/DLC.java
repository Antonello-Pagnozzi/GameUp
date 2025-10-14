package com.jdk.GameUp.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class DLC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nomeDlc;
    @ManyToOne
    @JoinColumn(name = "gioco_id")
    @NotNull
    private Gioco giocoDiRiferimento;
    @NotNull
    private int annoUscita;


    //costruttore parametrizzato
    public DLC(String nomeDlc, Gioco giocoDiRiferimento, int annoUscita) {
        this.nomeDlc = nomeDlc;
        this.giocoDiRiferimento = giocoDiRiferimento;
        this.annoUscita = annoUscita;
    }

    //costruttore vuoto
    public DLC(){}

    //Getter e setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDlc() {
        return nomeDlc;
    }

    public void setNomeDlc(String nomeDlc) {
        this.nomeDlc = nomeDlc;
    }

    public Gioco getGiocoDiRiferimento() {
        return giocoDiRiferimento;
    }

    public void setGiocoDiRiferimento(Gioco giocoDiRiferimento) {
        this.giocoDiRiferimento = giocoDiRiferimento;
    }

    public int getAnnoUscita() {
        return annoUscita;
    }

    public void setAnnoUscita(int annoUscita) {
        this.annoUscita = annoUscita;
    }
}
