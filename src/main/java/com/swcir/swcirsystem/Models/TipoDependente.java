package com.swcir.swcirsystem.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TIPOS_DEPENDENTE")
public class TipoDependente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tipoDepId")
    private int tipoDepId;

    private String nomeTipoDependente;

    @OneToOne(mappedBy = "tipoDependente")
    private Dependente dependente;

    public void setNomeTipoDependente(String nomeTipoDependente) {
        this.nomeTipoDependente = nomeTipoDependente;
    }

    public String getNomeTipoDependente() {
        return nomeTipoDependente;
    }

}
