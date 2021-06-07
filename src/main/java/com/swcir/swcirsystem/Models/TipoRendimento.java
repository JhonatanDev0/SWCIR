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
@Table(name="TIPOS_RENDIMENTO")
public class TipoRendimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tipoRendId")
    private Integer tipoRendId;

    private String nomeTipoRend;

    @JsonManagedReference("TipoRendimentoRef")
    @JsonIgnore
    @OneToMany(mappedBy = "tipoRendimento", fetch = FetchType.LAZY)
    private List<Rendimento> rendimento;

    public TipoRendimento () {}

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

    public List<Rendimento> getRendimento() {
        return rendimento;
    }

    public void setRendimento(List<Rendimento> rendimento) {
        this.rendimento = rendimento;
    }

}
