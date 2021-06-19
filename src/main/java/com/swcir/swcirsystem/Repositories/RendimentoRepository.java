package com.swcir.swcirsystem.Repositories;

import com.swcir.swcirsystem.Models.Rendimentos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RendimentoRepository extends JpaRepository<Rendimentos,Integer> {

    @Query(value = "SELECT sum(rendimentos.valor_rend) FROM rendimentos WHERE user_id = :userid", nativeQuery = true)
    public Double sumValores(@Param("userid") Integer userid);    
    
}
