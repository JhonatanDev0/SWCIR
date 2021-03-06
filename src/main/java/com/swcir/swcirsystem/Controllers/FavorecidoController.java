package com.swcir.swcirsystem.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;

import com.swcir.swcirsystem.Models.Favorecidos;
import com.swcir.swcirsystem.Repositories.FavorecidoRepository;

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
@RequestMapping("/fav")
public class FavorecidoController {
    @Autowired
    private FavorecidoRepository favRepository;

    @GetMapping(path="/")
    public Iterable<Favorecidos> get(){
        Iterable<Favorecidos> listFavorecidos = this.favRepository.findAll();

        if (listFavorecidos == null) {
            throw new EmptyResultDataAccessException("Nenhum Favorecido encontrado", 1);
        }

        return listFavorecidos;
    }

    @GetMapping(path="/{favId}")
    public Favorecidos getById(@PathVariable Integer favId){
        
        Favorecidos favRecovered = new Favorecidos();

        try {
            favRecovered = this.favRepository.findById(favId).get();
        } catch (NoSuchElementException e) {
            throw new EmptyResultDataAccessException("Nao existe Favorecido com o ID informado", 1);
        }
        return favRecovered;
    }

    @PostMapping("/")
        public ResponseEntity<Favorecidos> create(@RequestBody Favorecidos favorecido) 
            throws URISyntaxException {
            Favorecidos createdFavorecido = favRepository.save(favorecido);
            if (createdFavorecido == null || createdFavorecido.getNomeFav().isEmpty() ){
                return ResponseEntity.notFound().build();
            } else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdFavorecido.getFavId())
                .toUri();

                return ResponseEntity.created(uri)
                .body(createdFavorecido);
            }
        }

        @PutMapping("/{favId}")
        public ResponseEntity<Favorecidos> update(@RequestBody Favorecidos favorecido, @PathVariable Integer favId) {
            Favorecidos updatedFavorecido = favRepository.getOne(favId);
            if(updatedFavorecido != null){
                favorecido.setFavId(favId);
                favRepository.save(favorecido);
                return ResponseEntity.ok(favorecido);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping(path="/{favId}")
        public String delete(@PathVariable Integer favId){

            Favorecidos favToBeDeleted = new Favorecidos();
            favToBeDeleted = this.getById(favId);

            if(favToBeDeleted == null){
                throw new EmptyResultDataAccessException("Favorecido nao encontrado", 1);
            }

            favRepository.deleteById(favId);
            return "Favorecido " + favId + " has been deleted.";
         }

}
