package com.swcir.swcirsystem.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;

import com.swcir.swcirsystem.Models.Aliquotas;
import com.swcir.swcirsystem.Repositories.AliquotasRepository;

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
@RequestMapping("/aliq")
public class AliquotasController {

    @Autowired
    private AliquotasRepository aliqRepository;

    @GetMapping(path="/")
    public Iterable<Aliquotas> get(){
        Iterable<Aliquotas> listAliquotas = this.aliqRepository.findAll();

        if (listAliquotas == null) {
            throw new EmptyResultDataAccessException("Nenhuma Aliquota encontrado", 1);
        }

        return listAliquotas;
    }

    @GetMapping(path="/{aliqId}")
    public Aliquotas getById(@PathVariable Integer aliqId){
        
        Aliquotas favRecovered = new Aliquotas();

        try {
            favRecovered = this.aliqRepository.findById(aliqId).get();
        } catch (NoSuchElementException e) {
            throw new EmptyResultDataAccessException("Nao existe Aliquota com o ID informado", 1);
        }
        return favRecovered;
    }

    @PostMapping("/")
        public ResponseEntity<Aliquotas> create(@RequestBody Aliquotas aliquota) 
            throws URISyntaxException {
            Aliquotas createdFavorecido = aliqRepository.save(aliquota);
            if (createdFavorecido == null || createdFavorecido.getAliqValue() == null ){
                return ResponseEntity.notFound().build();
            } else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdFavorecido.getAliqId())
                .toUri();

                return ResponseEntity.created(uri)
                .body(createdFavorecido);
            }
        }

        @PutMapping("/{aliqId}")
        public ResponseEntity<Aliquotas> update(@RequestBody Aliquotas favorecido, @PathVariable Integer aliqId) {
            Aliquotas updatedFavorecido = aliqRepository.getOne(aliqId);
            if(updatedFavorecido != null){
                favorecido.setAliqId(aliqId);
                aliqRepository.save(favorecido);
                return ResponseEntity.ok(favorecido);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping(path="/{aliqId}")
        public String delete(@PathVariable Integer aliqId){

            Aliquotas favToBeDeleted = new Aliquotas();
            favToBeDeleted = this.getById(aliqId);

            if(favToBeDeleted == null){
                throw new EmptyResultDataAccessException("Aliquota nao encontrada", 1);
            }

            aliqRepository.deleteById(aliqId);
            return "Aliquota " + aliqId + " has been deleted.";
         }

}
