package com.swcir.swcirsystem.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.swcir.swcirsystem.Models.Contribuinte;
import com.swcir.swcirsystem.Repositories.ContribuinteRepository;

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
@RequestMapping("/contribuinte")
public class ContribuinteController {
    
    @Autowired
    private ContribuinteRepository contRepository;

    @GetMapping(path="/find/all")
        public Iterable<Contribuinte> get(){
            Iterable<Contribuinte> listContribuintes = this.contRepository.findAll();

            if (listContribuintes == null) {
                throw new EmptyResultDataAccessException("Nenhum contribuinte encontrado", 1);
            }

            return listContribuintes;
    }

    @GetMapping(path="/find/{contId}")
        public Contribuinte getById(@PathVariable int contId){
            
            Contribuinte contRecovered = new Contribuinte();

            try {
                contRecovered = this.contRepository.findById(contId).get();
            } catch (NoSuchElementException e) {
                throw new EmptyResultDataAccessException("Nao existe contribuinte com o ID informado", 1);
            }
            return contRecovered;
        }

        @PostMapping(path="/add") // Map ONLY POST Requests
        public ResponseEntity<Contribuinte> create(@RequestBody Contribuinte contribuinte) 
        throws URISyntaxException {

        Contribuinte createdContribuinte = contRepository.save(contribuinte);        
            if (createdContribuinte == null) {
                return ResponseEntity.notFound().build();
            } else {
        
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdContribuinte.getContId())
                .toUri();

                return ResponseEntity.created(uri)
                .body(createdContribuinte);
        }
    }

    @PutMapping("/edit/{contId}")
        public ResponseEntity<Contribuinte> update(@RequestBody Contribuinte contribuinte, @PathVariable Integer contId) {
            Optional<Contribuinte> updatedCont = contRepository.findById(contId);
            if (updatedCont != null) {
                contribuinte.setContId(contId);
                contRepository.save(contribuinte);
                return ResponseEntity.ok(contribuinte);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    
        @DeleteMapping(path="/delete/{contId}")
        public String delete(@PathVariable int contId){

            Contribuinte contToBeDeleted = new Contribuinte();
            contToBeDeleted = this.getById(contId);

            if(contToBeDeleted == null){
                throw new EmptyResultDataAccessException("Pessoa Fisica nao encontrada", 1);
            }

            contRepository.deleteById(contId);
            return "Pessoa Fisica " + contId + " has been deleted.";
         }
}