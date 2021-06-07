package com.swcir.swcirsystem.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;

import com.swcir.swcirsystem.Models.TipoPagamento;
import com.swcir.swcirsystem.Repositories.TipoPagamentoRepository;

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
@RequestMapping("/tipopag")
public class TipoPagamentoController {
    

    @Autowired
    private TipoPagamentoRepository tPRepository;

    @GetMapping(path="/")
    public Iterable<TipoPagamento> get(){
        Iterable<TipoPagamento> listTipoPagamentos = this.tPRepository.findAll();

        if (listTipoPagamentos == null) {
            throw new EmptyResultDataAccessException("Nenhum Tipo de Pagamento encontrado", 1);
        }

        return listTipoPagamentos;
    }
    
    @GetMapping(path="/{tipoPagId}")
    public TipoPagamento getById(@PathVariable Integer tipoPagId){
        
        TipoPagamento tPRecovered = new TipoPagamento();

        try {
            tPRecovered = this.tPRepository.findById(tipoPagId).get();
        } catch (NoSuchElementException e) {
            throw new EmptyResultDataAccessException("Nao existe Tipo de Pagamento com o ID informado", 1);
        }
        return tPRecovered;
    }

    @PostMapping("/")
        public ResponseEntity<TipoPagamento> create(@RequestBody TipoPagamento tipoPagamento) 
            throws URISyntaxException {
            TipoPagamento createdTipoPagamento = tPRepository.save(tipoPagamento);
            if (createdTipoPagamento == null || createdTipoPagamento.getNomeTipoPag().isEmpty() ) {
                return ResponseEntity.notFound().build();
            } else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTipoPagamento.getTipoPagId())
                .toUri();

                return ResponseEntity.created(uri)
                .body(createdTipoPagamento);
            }
        }

        @PutMapping("/{tipoPagId}")
        public ResponseEntity<TipoPagamento> update(@RequestBody TipoPagamento tipoPagamento, @PathVariable Integer tipoPagId) {
            TipoPagamento updatedTipoPagamento = tPRepository.getOne(tipoPagId);
            if(updatedTipoPagamento != null){
                tipoPagamento.setTipoPagId(tipoPagId);
                tPRepository.save(tipoPagamento);
                return ResponseEntity.ok(tipoPagamento);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping(path="/{tipoPagId}")
        public String delete(@PathVariable Integer tipoPagId){

            TipoPagamento tPToBeDeleted = new TipoPagamento();
            tPToBeDeleted = this.getById(tipoPagId);

            if(tPToBeDeleted == null){
                throw new EmptyResultDataAccessException("Tipo de Pagamento nao encontrado", 1);
            }

            tPRepository.deleteById(tipoPagId);
            return "Tipo de Pagamento " + tipoPagId + " has been deleted.";
         }
}
