package com.swcir.swcirsystem.Models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity // This tells Hibernate to make a table out of this class
@Table(name="USERS")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="userId")
    private Integer userId;

    private String name;

    private String email;

    private String password;

    private String ocupacao;
    
    private String natOcupacao;

    private int numReciboAnterior;

    private Long cpf;

    @Column(name = "dataNasc")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dataNasc;

    private String nitPisPasep;

    private Long tituloEleitoral;
    
    private int numDependentes;

    @OneToMany(mappedBy="user")
    private List<Pagamento> pagamento;

    @OneToMany(mappedBy = "user")
    private List<Rendimento> rendimento;

    @OneToMany(mappedBy = "user")
    private List<Bem> bem;

    public User() {}
        
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getNatOcupacao() {
        return natOcupacao;
    }

    public void setNatOcupacao(String natOcupacao) {
        this.natOcupacao = natOcupacao;
    }

    public int getNumReciboAnterior() {
        return numReciboAnterior;
    }

    public void setNumReciboAnterior(int numReciboAnterior) {
        this.numReciboAnterior = numReciboAnterior;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNitPisPasep() {
        return nitPisPasep;
    }

    public void setNitPisPasep(String nitPisPasep) {
        this.nitPisPasep = nitPisPasep;
    }

    public Long getTituloEleitoral() {
        return tituloEleitoral;
    }

    public void setTituloEleitoral(Long tituloEleitoral) {
        this.tituloEleitoral = tituloEleitoral;
    }

    public int getNumDependentes() {
        return numDependentes;
    }

    public void setNumDependentes(int numDependentes) {
        this.numDependentes = numDependentes;
    }

}
