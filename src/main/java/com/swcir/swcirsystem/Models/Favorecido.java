package com.swcir.swcirsystem.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FAVORECIDOS")
public class Favorecido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="favId")
    private int favId;

    @OneToOne(mappedBy = "favorecido")
    private Pagamento pagamento;

    private int docFav;

    private String nomeFav;

    public int getDocFav() {
        return docFav;
    }

    public void setDocFav(int docFav) {
        this.docFav = docFav;
    }

    public String getNomeFav() {
        return nomeFav;
    }

    public void setNomeFav(String nomeFav) {
        this.nomeFav = nomeFav;
    }

}
