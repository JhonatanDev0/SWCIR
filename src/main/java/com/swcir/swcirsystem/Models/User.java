package com.swcir.swcirsystem.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.format.annotation.DateTimeFormat;


@Entity // This tells Hibernate to make a table out of this class
@Table(name="USERS")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="userId")
    private Integer userId;

    private String name;

    private String email;

    private String password;

    private String ocupacao;
    
    private String natOcupacao;

    private Integer numReciboAnterior;

    private Long cpf;

    @Column(name = "dataNasc")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dataNasc;

    private String nitPisPasep;

    private Long tituloEleitoral;
    
    private Integer numDependentes;

    @JsonManagedReference("PagUserRef")
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Pagamento> pagamento;

    @JsonManagedReference("RendUserRef")
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Rendimento> rendimento;

    @JsonManagedReference("BemUserRef")
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
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

    public Integer getNumReciboAnterior() {
        return numReciboAnterior;
    }

    public void setNumReciboAnterior(Integer numReciboAnterior) {
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

    public Integer getNumDependentes() {
        return numDependentes;
    }

    public void setNumDependentes(Integer numDependentes) {
        this.numDependentes = numDependentes;
    }

    public List<Rendimento> getRendimento() {
        return rendimento;
    }

    public void setRendimento(List<Rendimento> rendimento) {
        this.rendimento = rendimento;
    }

    public List<Pagamento> getPagamento() {
        return pagamento;
    }

    public void setPagamento(List<Pagamento> pagamento) {
        this.pagamento = pagamento;
    }

    // public List<Bem> getBem() {
    //     return bem;
    // }

    // public void setBem(List<Bem> bem) {
    //     this.bem = bem;
    // }
}
