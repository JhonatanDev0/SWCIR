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
@Table(name="FAVORECIDOS")
public class Favorecidos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="favId")
    private Integer favId;

    @JsonManagedReference("FavRef")
    @JsonIgnore
    @OneToMany(mappedBy = "favorecido", fetch = FetchType.LAZY)
    private List<Pagamentos> pagamento;

    public Favorecidos() {}

    private Integer docFav;

    private String nomeFav;

    public Integer getFavId() {
        return favId;
    }

    public void setFavId(Integer favId) {
        this.favId = favId;
    }

    public Integer getDocFav() {
        return docFav;
    }

    public void setDocFav(Integer docFav) {
        this.docFav = docFav;
    }

    public String getNomeFav() {
        return nomeFav;
    }

    public void setNomeFav(String nomeFav) {
        this.nomeFav = nomeFav;
    }

    public List<Pagamentos> getPagamento() {
        return pagamento;
    }

    public void setPagamento(List<Pagamentos> pagamento) {
        this.pagamento = pagamento;
    }

}
