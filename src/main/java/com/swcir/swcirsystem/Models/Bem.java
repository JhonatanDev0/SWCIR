package com.swcir.swcirsystem.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="BENS")
public class Bem {
   
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="bemId")
    private Integer bemId;

    @JsonBackReference("BemUserRef")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId", nullable = false)
    private User user;

    @JsonBackReference("TipoBemRef")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipoBemId", nullable = false)
    private TipoBem tipoBem;

    private String docRef;

    private double valorDoisAnos;

    private double valorAnoAnt;

    private String discriminacao;

    public String getDocRef() {
        return docRef;
    }

    public Bem() {}


    public Integer getBemId() {
        return bemId;
    }

    public void setBemId(Integer bemId) {
        this.bemId = bemId;
    }

    public TipoBem getTipoBem() {
        return tipoBem;
    }

    public void setTipoBem(TipoBem tipoBem) {
        this.tipoBem = tipoBem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
