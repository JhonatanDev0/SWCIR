package com.swcir.swcirsystem.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TIPOS_RENDIMENTO")
public class TipoRendimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tipoRendId")
    private int tipoRendId;

    private String nomeTipoRend;

    @OneToOne(mappedBy = "tipoRendimento")
    private Rendimento rendimento;

    public String getNomeTipoRend() {
        return nomeTipoRend;
    }

    public void setNomeTipoRend(String nomeTipoRend) {
        this.nomeTipoRend = nomeTipoRend;
    }

}
