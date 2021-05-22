package com.swcir.swcirsystem.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONTRIBUINTES")
public class Contribuinte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="contId")
    private Integer contId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="pfisid", referencedColumnName = "pfisid")
    private PFisica pfisica;

    private String ocupacao;
    
    private String natOcupacao;

    private int numReciboAnterior;

    @OneToMany(mappedBy="contribuinte")
    private List<Pagamento> pagamento;

    @OneToMany(mappedBy = "contribuinte")
    private List<Rendimento> rendimento;

    @OneToMany(mappedBy = "contribuinte")
    private List<Bem> bem;

    public Integer getContId() {
        return contId;
    }

    public void setContId(Integer contId) {
        this.contId = contId;
    }

    public PFisica getPfisica() {
        return pfisica;
    }

    public void setPfisica(PFisica pfisica) {
        this.pfisica = pfisica;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getNatOcupacao() {
        return natOcupacao;
    }

    public void setNatOcupacao(String natOcupacao) {
        this.natOcupacao = natOcupacao;
    }

    public int getNumReciboAnterior() {
        return numReciboAnterior;
    }

    public void setNumReciboAnterior(int numReciboAnterior) {
        this.numReciboAnterior = numReciboAnterior;
    }

}
