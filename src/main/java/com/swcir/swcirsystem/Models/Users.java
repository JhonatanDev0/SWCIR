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
public class Users {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="userId")
    private Integer userId;

    private String name;

    private String email;

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
    private List<Pagamentos> pagamento;

    @JsonManagedReference("RendUserRef")
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Rendimentos> rendimento;

    @JsonManagedReference("BemUserRef")
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Bens> bem;

    public Users() {}
        
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

    public List<Rendimentos> getRendimento() {
        return rendimento;
    }

    public void setRendimento(List<Rendimentos> rendimento) {
        this.rendimento = rendimento;
    }

    public List<Pagamentos> getPagamento() {
        return pagamento;
    }

    public void setPagamento(List<Pagamentos> pagamento) {
        this.pagamento = pagamento;
    }

    public List<Bens> getBem() {
        return bem;
    }

    public void setBem(List<Bens> bem) {
        this.bem = bem;
    }
}
