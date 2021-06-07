package com.swcir.swcirsystem.Controllers;

import java.net.URI;
import java.util.NoSuchElementException;

import com.swcir.swcirsystem.Models.Rendimento;
import com.swcir.swcirsystem.Models.TipoRendimento;
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
    public Iterable<Rendimento> get(){
        Iterable<Rendimento> listRendimentos = this.rendimentoRepository.findAll();

        if (listRendimentos == null) {
            throw new EmptyResultDataAccessException("Nenhum Rendimento encontrado", 1);
        }

        return listRendimentos;
    }

    @GetMapping(path="/{rendId}")
    public Rendimento getById(@PathVariable Integer rendId){
        
        Rendimento rendRecovered = new Rendimento();

        try {
            rendRecovered = this.rendimentoRepository.findById(rendId).get();
        } catch (NoSuchElementException e) {
            throw new EmptyResultDataAccessException("Nao existe Rendimento com o ID informado", 1);
        }
        return rendRecovered;
    }

    @PostMapping("/")
        public ResponseEntity<Rendimento> create(@RequestBody Rendimento rendimento) {
            
            TipoRendimento tipoRendimento = rendimento.getTipoRendimento() == null ? null : tipoRendimentoRepository.getOne(rendimento.getUser().getUserId());
            rendimento.setTipoRendimento(tipoRendimento);
            Rendimento createdRendimento = rendimentoRepository.save(rendimento);  
            
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
        public ResponseEntity<Rendimento> update(@RequestBody Rendimento rendimento, @PathVariable Integer rendId) {
            Rendimento updatedRendimento = rendimentoRepository.getOne(rendId);
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

            Rendimento rendToBeDeleted = new Rendimento();
            rendToBeDeleted = this.getById(rendId);

            if(rendToBeDeleted == null){
                throw new EmptyResultDataAccessException("Rendimento nao encontrado", 1);
            }

            rendimentoRepository.deleteById(rendId);
            return "Rendimento " + rendId + " has been deleted.";
         }
}


    

  
    
    
