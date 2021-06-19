package com.swcir.swcirsystem.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;

import com.swcir.swcirsystem.Models.TiposBem;
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
@RequestMapping("/tipobem")
public class TipoBemController {
    @Autowired
    private TipoBemRepository tBRepository;

    @GetMapping(path="/")
    public Iterable<TiposBem> get(){
        Iterable<TiposBem> listTipoBens = this.tBRepository.findAll();

        if (listTipoBens == null) {
            throw new EmptyResultDataAccessException("Nenhum Tipo de Bem encontrado", 1);
        }

        return listTipoBens;
    }

    @GetMapping(path="/{tipoBemId}")
    public TiposBem getById(@PathVariable Integer tipoBemId){
        
        TiposBem tBRecovered = new TiposBem();

        try {
            tBRecovered = this.tBRepository.findById(tipoBemId).get();
        } catch (NoSuchElementException e) {
            throw new EmptyResultDataAccessException("Nao existe Tipo de Bem com o ID informado", 1);
        }
        return tBRecovered;
    }

    @PostMapping("/")
        public ResponseEntity<TiposBem> create(@RequestBody TiposBem tipoBem) 
            throws URISyntaxException {
            TiposBem createdTipoBem = tBRepository.save(tipoBem);
            if (createdTipoBem == null || createdTipoBem.getNomeTipoBem().isEmpty() ) {
                return ResponseEntity.notFound().build();
            } else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTipoBem.getTipoBemId())
                .toUri();

                return ResponseEntity.created(uri)
                .body(createdTipoBem);
            }
        }

        @PutMapping("/{tipoBemId}")
        public ResponseEntity<TiposBem> update(@RequestBody TiposBem tipoBem, @PathVariable Integer tipoBemId) {
            TiposBem updatedTipoBem = tBRepository.getOne(tipoBemId);
            if(updatedTipoBem != null){
                tipoBem.setTipoBemId(tipoBemId);
                tBRepository.save(tipoBem);
                return ResponseEntity.ok(tipoBem);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping(path="/{tipoBemId}")
        public String delete(@PathVariable Integer tipoBemId){

            TiposBem tPToBeDeleted = new TiposBem();
            tPToBeDeleted = this.getById(tipoBemId);

            if(tPToBeDeleted == null){
                throw new EmptyResultDataAccessException("Tipo de Bem nao encontrado", 1);
            }

            tBRepository.deleteById(tipoBemId);
            return "Tipo de Bem " + tipoBemId + " has been deleted.";
         }
}


    

  
    
    
