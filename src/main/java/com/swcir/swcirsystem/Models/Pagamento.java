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
@Table(name="PAGAMENTOS")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pagId")
    private int pagId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="favId", referencedColumnName = "favId")
    private Favorecido favorecido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tipoPagId", referencedColumnName = "tipoPagId")
    private TipoPagamento tipoPagamento;

    @ManyToOne
    @JoinColumn(name="contId", nullable = false)
    private Contribuinte contribuinte;

    private String realizadoCom;

    private double valorPago;

    public void setRealizadoCom(String realizadoCom) {
        this.realizadoCom = realizadoCom;
    }

    public String getRealizadoCom() {
        return realizadoCom;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorPago() {
        return valorPago;
    }

}
