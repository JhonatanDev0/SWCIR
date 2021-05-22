package com.swcir.swcirsystem.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TIPOS_BEM")
public class TipoBem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tipoBemId")
    private int tipoBemId;

    @OneToOne(mappedBy = "tipoBem")
    private Bem bem;

    private String nomeTipoBem;

    public String getNomeTipoBem() {
        return nomeTipoBem;
    }

    public void setNomeTipoBem(String nomeTipoBem) {
        this.nomeTipoBem = nomeTipoBem;
    }

}
