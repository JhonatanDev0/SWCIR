package com.swcir.swcirsystem.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;

import com.swcir.swcirsystem.Models.TiposRendimento;
import com.swcir.swcirsystem.Repositories.TipoRendimentoRepository;

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
@RequestMapping("/tiporend")
public class TipoRendimentoController {

    @Autowired
    private TipoRendimentoRepository tRRepository;

    @GetMapping(path="/")
    public Iterable<TiposRendimento> get(){
        Iterable<TiposRendimento> listTipoRendimentos = this.tRRepository.findAll();

        if (listTipoRendimentos == null) {
            throw new EmptyResultDataAccessException("Nenhum Tipo de Rendimento encontrado", 1);
        }

        return listTipoRendimentos;
    }
    
    @GetMapping(path="/{tipoRendId}")
    public TiposRendimento getById(@PathVariable Integer tipoRendId){
        
        TiposRendimento tRRecovered = new TiposRendimento();

        try {
            tRRecovered = this.tRRepository.findById(tipoRendId).get();
        } catch (NoSuchElementException e) {
            throw new EmptyResultDataAccessException("Nao existe Tipo de Rendimento com o ID informado", 1);
        }
        return tRRecovered;
    }

    @PostMapping("/")
        public ResponseEntity<TiposRendimento> create(@RequestBody TiposRendimento tipoRendimento) 
            throws URISyntaxException {
            TiposRendimento createdTipoRendimento = tRRepository.save(tipoRendimento);
            if (createdTipoRendimento == null || createdTipoRendimento.getNomeTipoRend().isEmpty() ) {
                return ResponseEntity.notFound().build();
            } else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTipoRendimento.getTipoRendId())
                .toUri();

                return ResponseEntity.created(uri)
                .body(createdTipoRendimento);
            }
        }

        @PutMapping("/{tipoRendId}")
        public ResponseEntity<TiposRendimento> update(@RequestBody TiposRendimento tipoRendimento, @PathVariable Integer tipoRendId) {
            TiposRendimento updatedTipoRendimento = tRRepository.getOne(tipoRendId);
            if(updatedTipoRendimento != null){
                tipoRendimento.setTipoRendId(tipoRendId);
                tRRepository.save(tipoRendimento);
                return ResponseEntity.ok(tipoRendimento);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping(path="/{tipoRendId}")
        public String delete(@PathVariable Integer tipoRendId){

            TiposRendimento tRToBeDeleted = new TiposRendimento();
            tRToBeDeleted = this.getById(tipoRendId);

            if(tRToBeDeleted == null){
                throw new EmptyResultDataAccessException("Tipo de Rendimento nao encontrado", 1);
            }

            tRRepository.deleteById(tipoRendId);
            return "Tipo de Rendimento " + tipoRendId + " has been deleted.";
         }
}
