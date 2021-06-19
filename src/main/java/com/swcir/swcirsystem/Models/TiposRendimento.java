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
@Table(name="TIPOSRENDIMENTO")
public class TiposRendimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tipoRendId")
    private Integer tipoRendId;

    private String nomeTipoRend;

    @JsonManagedReference("TipoRendimentoRef")
    @JsonIgnore
    @OneToMany(mappedBy = "tipoRendimento", fetch = FetchType.LAZY)
    private List<Rendimentos> rendimento;

    public TiposRendimento () {}

    public String getNomeTipoRend() {
        return nomeTipoRend;
    }

    public void setNomeTipoRend(String nomeTipoRend) {
        this.nomeTipoRend = nomeTipoRend;
    }

    public Integer getTipoRendId() {
        return tipoRendId;
    }

    public void setTipoRendId(Integer tipoRendId) {
        this.tipoRendId = tipoRendId;
    }

    public List<Rendimentos> getRendimento() {
        return rendimento;
    }

    public void setRendimento(List<Rendimentos> rendimento) {
        this.rendimento = rendimento;
    }

}
