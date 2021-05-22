package com.swcir.swcirsystem.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TIPOS_PAGAMENTO")
public class TipoPagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tipoPagId")
    private int tipoPagId;

    @OneToOne(mappedBy = "tipoPagamento")
    private Pagamento pagamento;

    private String nomeTipoPag;

    public String getNomeTipoPag() {
        return nomeTipoPag;
    }

    public void setNomeTipoPag(String nomeTipoPag) {
        this.nomeTipoPag = nomeTipoPag;
    }

}
