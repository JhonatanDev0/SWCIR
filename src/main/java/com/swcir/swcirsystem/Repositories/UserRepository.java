package com.swcir.swcirsystem.Repositories;


import com.swcir.swcirsystem.Models.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {

}