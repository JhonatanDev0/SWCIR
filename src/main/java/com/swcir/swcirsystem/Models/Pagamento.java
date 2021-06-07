package com.swcir.swcirsystem.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="PAGAMENTOS")
public class Pagamento {

    @Id
    @GeneratedValue
    @Column(name="pagId")
    private Integer pagId;

    @JsonBackReference("FavRef")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="favId", nullable = false)
    private Favorecido favorecido;

    @JsonBackReference("TipoPagRef")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipoPagId", nullable = false)
    private TipoPagamento tipoPagamento;

    @JsonBackReference("PagUserRef")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId", nullable = false)
    private User user;

    private String realizadoCom;

    private double valorPago;

    public Pagamento() {}

    public void setPagId(Integer pagId) {
        this.pagId = pagId;
    }

    public Integer getPagId() {
        return pagId;
    }

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

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
