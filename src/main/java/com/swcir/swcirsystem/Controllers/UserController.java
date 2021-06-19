package com.swcir.swcirsystem.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;

import com.swcir.swcirsystem.Models.Users;
import com.swcir.swcirsystem.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/")
    public Iterable<Users> get(){
        Iterable<Users> listUsers = this.userRepository.findAll();

        if (listUsers == null) {
            throw new EmptyResultDataAccessException("Nenhum usuario encontrado", 1);
        }

        return listUsers;
    }

    @GetMapping(path="/{userId}")
    public Users getById(@PathVariable int userId){
        
        Users userRecovered = new Users();

        try {
            userRecovered = this.userRepository.findById(userId).get();
        } catch (NoSuchElementException e) {
            throw new EmptyResultDataAccessException("Nao existe usuario com o ID informado", 1);
        }
        return userRecovered;
    }

    @PostMapping("/")
        public ResponseEntity<Users> create(@RequestBody Users user) 
            throws URISyntaxException {
            Users createdUser = userRepository.save(user);
            if (createdUser == null || createdUser.getEmail().isEmpty() || createdUser.getName().isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getUserId())
                .toUri();

                return ResponseEntity.created(uri)
                .body(createdUser);
            }
        }

    @PutMapping("/{userId}")
        public ResponseEntity<Users> update(@RequestBody Users user, @PathVariable Integer userId) {
            Users updatedUser = userRepository.getOne(userId);
            if(updatedUser != null){
                user.setUserId(userId);
                userRepository.save(user);
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    @DeleteMapping(path="/{userId}")
        public String delete(@PathVariable int userId){

            Users userToBeDeleted = new Users();
            userToBeDeleted = this.getById(userId);

            if(userToBeDeleted == null){
                throw new EmptyResultDataAccessException("Usuario nao encontrado", 1);
            }

            userRepository.deleteById(userId);
            return "User " + userId + " has been deleted.";
         }
        
}