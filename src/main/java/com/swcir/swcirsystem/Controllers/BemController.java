package com.swcir.swcirsystem.Controllers;

import java.net.URI;
import java.util.NoSuchElementException;

import com.swcir.swcirsystem.Models.Bens;
import com.swcir.swcirsystem.Models.TiposBem;
import com.swcir.swcirsystem.Repositories.BemRepository;
import com.swcir.swcirsystem.Repositories.TipoBemRepository;

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
@RequestMapping("/bem")
public class BemController {

    @Autowired
    private BemRepository bemRepository;

    @Autowired
    private TipoBemRepository tipoBemRepository;

    @GetMapping(path="/")
    public Iterable<Bens> get(){
        Iterable<Bens> listBens = this.bemRepository.findAll();

        if (listBens == null) {
            throw new EmptyResultDataAccessException("Nenhum Bem encontrado", 1);
        }

        return listBens;
    }

    @GetMapping(path="/{bemId}")
    public Bens getById(@PathVariable Integer bemId){
        
        Bens bemRecovered = new Bens();

        try {
            bemRecovered = this.bemRepository.findById(bemId).get();
        } catch (NoSuchElementException e) {
            throw new EmptyResultDataAccessException("Nao existe Bem com o ID informado", 1);
        }
        return bemRecovered;
    }
    
    @PostMapping("/")
        public ResponseEntity<Bens> create(@RequestBody Bens bem) {
            
            TiposBem tipoBem = bem.getTipoBem() == null ? null : tipoBemRepository.getOne(bem.getUser().getUserId());
            bem.setTipoBem(tipoBem);
            Bens createdBem = bemRepository.save(bem);  
            
            if (createdBem == null || createdBem.getTipoBem().getTipoBemId() == null || createdBem.getUser().getUserId() == null ) {
                return ResponseEntity.notFound().build();
            } else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdBem.getBemId())
                .toUri();

                return ResponseEntity.created(uri)
                .body(createdBem);
            }
        }

        @PutMapping("/{bemId}")
        public ResponseEntity<Bens> update(@RequestBody Bens bem, @PathVariable Integer bemId) {
            Bens updatedBem = bemRepository.getOne(bemId);
            if(updatedBem != null){
                bem.setBemId(bemId);
                bemRepository.save(bem);
                return ResponseEntity.ok(bem);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping(path="/{bemId}")
        public String delete(@PathVariable Integer bemId){

            Bens pagToBeDeleted = new Bens();
            pagToBeDeleted = this.getById(bemId);

            if(pagToBeDeleted == null){
                throw new EmptyResultDataAccessException("Bem nao encontrado", 1);
            }

            bemRepository.deleteById(bemId);
            return "Bem " + bemId + " has been deleted.";
         }
}
