package com.jdk.GameUp.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public class DlcDto {

    private String nomeDlc;
    private int annoUscita;

    public String getNomeDlc() {
        return nomeDlc;
    }

    public void setNomeDlc(String nomeDlc) {
        this.nomeDlc = nomeDlc;
    }

    public int getAnnoUscita() {
        return annoUscita;
    }

    public void setAnnoUscita(int annoUscita) {
        this.annoUscita = annoUscita;
    }
}
