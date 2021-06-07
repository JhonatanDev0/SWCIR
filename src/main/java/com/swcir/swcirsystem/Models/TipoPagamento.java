package com.swcir.swcirsystem.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="TIPOS_PAGAMENTO")
public class TipoPagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tipoPagId")
    private Integer tipoPagId;

    @JsonManagedReference("TipoPagRef")
    @JsonIgnore
    @OneToMany(mappedBy = "tipoPagamento", fetch = FetchType.LAZY)
    private List<Pagamento> pagamento;

    private String nomeTipoPag;

    public TipoPagamento(){}

    public String getNomeTipoPag() {
        return nomeTipoPag;
    }

    public void setNomeTipoPag(String nomeTipoPag) {
        this.nomeTipoPag = nomeTipoPag;
    }

    public Integer getTipoPagId() {
        return tipoPagId;
    }

    public void setTipoPagId(Integer tipoPagId) {
        this.tipoPagId = tipoPagId;
    }

    public List<Pagamento> getPagamento() {
        return pagamento;
    }

    public void setPagamento(List<Pagamento> pagamento) {
        this.pagamento = pagamento;
    }

}
