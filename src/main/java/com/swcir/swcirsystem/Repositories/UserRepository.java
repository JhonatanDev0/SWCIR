package com.swcir.swcirsystem.Repositories;


import com.swcir.swcirsystem.Models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByEmail(String email);
}