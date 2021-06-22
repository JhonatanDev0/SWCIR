package com.swcir.swcirsystem.Controllers;

import java.net.URI;
import java.util.NoSuchElementException;


import com.swcir.swcirsystem.Models.Rendimentos;
import com.swcir.swcirsystem.Models.TiposRendimento;
import com.swcir.swcirsystem.Repositories.RendimentoRepository;
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
@RequestMapping("/rend")
public class RendimentoController {
    @Autowired
    private RendimentoRepository rendimentoRepository;

    @Autowired
    private TipoRendimentoRepository tipoRendimentoRepository;

    @GetMapping(path="/")
    public Iterable<Rendimentos> get(){
        Iterable<Rendimentos> listRendimentos = this.rendimentoRepository.findAll();

        if (listRendimentos == null) {
            throw new EmptyResultDataAccessException("Nenhum Rendimento encontrado", 1);
        }

        return listRendimentos;
    }

    @GetMapping(path="/{rendId}")
    public Rendimentos getById(@PathVariable Integer rendId){
        
        Rendimentos rendRecovered = new Rendimentos();

        try {
            rendRecovered = this.rendimentoRepository.findById(rendId).get();
        } catch (NoSuchElementException e) {
            throw new EmptyResultDataAccessException("Nao existe Rendimento com o ID informado", 1);
        }
        return rendRecovered;
    }

    @GetMapping(path="/sum/{userId}")
    public Double sum(@PathVariable Integer userId){
        Double sumRendimentos = rendimentoRepository.sumValores(userId);
        return sumRendimentos;
    }
         

    @PostMapping("/")
        public ResponseEntity<Rendimentos> create(@RequestBody Rendimentos rendimento) {
            
            TiposRendimento tipoRendimento = rendimento.getTipoRendimento() == null ? null : tipoRendimentoRepository.getOne(rendimento.getUser().getUserId());
            rendimento.setTipoRendimento(tipoRendimento);
            Rendimentos createdRendimento = rendimentoRepository.save(rendimento);  
            
            if (createdRendimento == null || createdRendimento.getNomeFontPag().isEmpty() || createdRendimento.getTipoRendimento().getTipoRendId() == null || createdRendimento.getUser().getUserId() == null ) {
                return ResponseEntity.notFound().build();
            } else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdRendimento.getRendId())
                .toUri();

                return ResponseEntity.created(uri)
                .body(createdRendimento);
            }
        }

        @PutMapping("/{rendId}")
        public ResponseEntity<Rendimentos> update(@RequestBody Rendimentos rendimento, @PathVariable Integer rendId) {
            Rendimentos updatedRendimento = rendimentoRepository.getOne(rendId);
            if(updatedRendimento != null){
                rendimento.setRendId(rendId);
                rendimentoRepository.save(rendimento);
                return ResponseEntity.ok(rendimento);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping(path="/{rendId}")
        public String delete(@PathVariable Integer rendId){

            Rendimentos rendToBeDeleted = new Rendimentos();
            rendToBeDeleted = this.getById(rendId);

            if(rendToBeDeleted == null){
                throw new EmptyResultDataAccessException("Rendimento nao encontrado", 1);
            }

            rendimentoRepository.deleteById(rendId);
            return "Rendimento " + rendId + " has been deleted.";
         }
}


    

  
    
    
