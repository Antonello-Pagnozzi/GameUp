package com.jdk.GameUp.Security.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private RoleName ruolo;

    //Costruttori
    public Role(){}

    public Role(RoleName ruolo) {
        this.ruolo = ruolo;
    }
    //Getter e setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getRuolo() {
        return ruolo;
    }

    public void setRuolo(RoleName ruolo) {
        this.ruolo = ruolo;
    }
}
