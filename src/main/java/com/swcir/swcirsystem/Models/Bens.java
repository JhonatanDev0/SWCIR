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
public class Bens {
   
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="bemId")
    private Integer bemId;

    @JsonBackReference("BemUserRef")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId", nullable = false)
    private Users user;

    @JsonBackReference("TipoBemRef")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipoBemId", nullable = false)
    private TiposBem tipoBem;

    private String docRef;

    private double valorDoisAnos;

    private double valorAnoAnt;

    private String discriminacao;

    public String getDocRef() {
        return docRef;
    }

    public Bens() {}

    public Integer getBemId() {
        return bemId;
    }

    public void setBemId(Integer bemId) {
        this.bemId = bemId;
    }

    public TiposBem getTipoBem() {
        return tipoBem;
    }

    public void setTipoBem(TiposBem tipoBem) {
        this.tipoBem = tipoBem;
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
