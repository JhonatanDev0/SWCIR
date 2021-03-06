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
@Table(name="TIPOSBEM")
public class TiposBem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tipoBemId")
    private Integer tipoBemId;

    @JsonManagedReference("TipoBemRef")
    @JsonIgnore
    @OneToMany(mappedBy = "tipoBem", fetch = FetchType.LAZY)
    private List<Bens> bem;

    private String nomeTipoBem;

    public String getNomeTipoBem() {
        return nomeTipoBem;
    }

    public void setNomeTipoBem(String nomeTipoBem) {
        this.nomeTipoBem = nomeTipoBem;
    }

    public Integer getTipoBemId() {
        return tipoBemId;
    }
    
    public void setTipoBemId(Integer tipoBemId) {
        this.tipoBemId = tipoBemId;
    }

    public List<Bens> getBem() {
        return bem;
    }

    public void setBem(List<Bens> bem) {
        this.bem = bem;
    }
}
