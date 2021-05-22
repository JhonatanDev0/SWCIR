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
@Table(name="RENDIMENTOS")
public class Rendimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="rendId")
    private int rendId;

    @ManyToOne
    @JoinColumn(name="contId", nullable = false)
    private Contribuinte contribuinte;

    private String tipoFontPag;

    private int docFontPag;

    private String nomeFontPag;

    private double valorRend;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tipoRendId", referencedColumnName = "tipoRendId")
    private TipoRendimento tipoRendimento;

    public String getTipoFontPag() {
        return tipoFontPag;
    }

    public void setTipoFontPag(String tipoFontPag) {
        this.tipoFontPag = tipoFontPag;
    }

    public int getDocFontPag() {
        return docFontPag;
    }

    public void setDocFontPag(int docFontPag) {
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
}
