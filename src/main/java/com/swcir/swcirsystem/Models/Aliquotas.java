package com.swcir.swcirsystem.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ALIQUOTAS")
public class Aliquotas {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="aliqId")
    private Integer aliqId;

    private Double aliqValue;
    
    
    public Integer getAliqId() {
        return aliqId;
    }

    public void setAliqId(Integer aliqId) {
        this.aliqId = aliqId;
    }

    public Double getAliqValue() {
        return aliqValue;
    }

    public void setAliqValue(Double aliqValue) {
        this.aliqValue = aliqValue;
    }

}
