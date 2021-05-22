package com.swcir.swcirsystem.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DEPENDENTES")
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "depId")
    private int depId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipoDepId", referencedColumnName = "tipoDepId")
    private TipoDependente tipoDependente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pFisId", referencedColumnName = "pFisId")
    private PFisica pFisica;

}
