package com.swcir.swcirsystem.Repositories;

import com.swcir.swcirsystem.Models.Bens;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BemRepository extends JpaRepository<Bens, Integer>{
    
}
