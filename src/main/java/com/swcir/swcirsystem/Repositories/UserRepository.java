package com.swcir.swcirsystem.Repositories;


import com.swcir.swcirsystem.Models.User;

import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByEmail(String email);

}