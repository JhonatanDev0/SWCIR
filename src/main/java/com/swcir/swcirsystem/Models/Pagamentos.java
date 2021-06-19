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
public class Pagamentos {

    @Id
    @GeneratedValue
    @Column(name="pagId")
    private Integer pagId;

    @JsonBackReference("FavRef")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="favId", nullable = false)
    private Favorecidos favorecido;

    @JsonBackReference("TipoPagRef")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipoPagId", nullable = false)
    private TiposPagamento tipoPagamento;

    @JsonBackReference("PagUserRef")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId", nullable = false)
    private Users user;

    private String realizadoCom;

    private double valorPago;

    public Pagamentos() {}

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

    public void setTipoPagamento(TiposPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public TiposPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

}
