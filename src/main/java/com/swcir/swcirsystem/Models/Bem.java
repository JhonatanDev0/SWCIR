package com.swcir.swcirsystem.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BENS")
public class Bem {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="bemId")
    private int bemId;

    @ManyToOne
    @JoinColumn(name="contId", nullable = false)
    private Contribuinte contribuinte;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tipoBemId", referencedColumnName = "tipoBemId")
    private TipoBem tipoBem;

    private String docRef;

    private double valorDoisAnos;

    private double valorAnoAnt;

    private String discriminacao;

    public String getDocRef() {
        return docRef;
    }

    public void setDocRef(String docRef) {
        this.docRef = docRef;
    }

    public double getValorDoisAnos() {
        return valorDoisAnos;
    }

    public void setValorDoisAnos(double valorDoisAnos) {
        this.valorDoisAnos = valorDoisAnos;
    }

    public double getValorAnoAnt() {
        return valorAnoAnt;
    }

    public void setValorAnoAnt(double valorAnoAnt) {
        this.valorAnoAnt = valorAnoAnt;
    }

    public String getDiscriminacao() {
        return discriminacao;
    }

    public void setDiscriminacao(String discriminacao) {
        this.discriminacao = discriminacao;
    }
}
