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
@Table(name="RENDIMENTOS")
public class Rendimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="rendId")
    private Integer rendId;

    @JsonBackReference("RendUserRef")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId", nullable = false)
    private User user;

    private String tipoFontPag;

    private Integer docFontPag;

    private String nomeFontPag;

    private double valorRend;

    @JsonBackReference("TipoRendimentoRef")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipoRendId", nullable = false)
    private TipoRendimento tipoRendimento;

    public Rendimento () {}

    public Integer getRendId() {
        return rendId;
    }

    public void setRendId(Integer rendId) {
        this.rendId = rendId;
    }

    public String getTipoFontPag() {
        return tipoFontPag;
    }

    public void setTipoFontPag(String tipoFontPag) {
        this.tipoFontPag = tipoFontPag;
    }

    public Integer getDocFontPag() {
        return docFontPag;
    }

    public void setDocFontPag(Integer docFontPag) {
        this.docFontPag = docFontPag;
    }

    public String getNomeFontPag() {
        return nomeFontPag;
    }

    public void setNomeFontPag(String nomeFontPag) {
        this.nomeFontPag = nomeFontPag;
    }

    public double getValorRend() {
        return valorRend;
    }

    public void setValorRend(double valorRend) {
        this.valorRend = valorRend;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TipoRendimento getTipoRendimento() {
        return tipoRendimento;
    }

    public void setTipoRendimento(TipoRendimento tipoRendimento) {
        this.tipoRendimento = tipoRendimento;
    }
}
