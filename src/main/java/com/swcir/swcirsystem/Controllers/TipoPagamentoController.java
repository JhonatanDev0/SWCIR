package com.swcir.swcirsystem.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;

import com.swcir.swcirsystem.Models.TiposPagamento;
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
    public Iterable<TiposPagamento> get(){
        Iterable<TiposPagamento> listTipoPagamentos = this.tPRepository.findAll();

        if (listTipoPagamentos == null) {
            throw new EmptyResultDataAccessException("Nenhum Tipo de Pagamento encontrado", 1);
        }

        return listTipoPagamentos;
    }
    
    @GetMapping(path="/{tipoPagId}")
    public TiposPagamento getById(@PathVariable Integer tipoPagId){
        
        TiposPagamento tPRecovered = new TiposPagamento();

        try {
            tPRecovered = this.tPRepository.findById(tipoPagId).get();
        } catch (NoSuchElementException e) {
            throw new EmptyResultDataAccessException("Nao existe Tipo de Pagamento com o ID informado", 1);
        }
        return tPRecovered;
    }

    @PostMapping("/")
        public ResponseEntity<TiposPagamento> create(@RequestBody TiposPagamento tipoPagamento) 
            throws URISyntaxException {
            TiposPagamento createdTipoPagamento = tPRepository.save(tipoPagamento);
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
        public ResponseEntity<TiposPagamento> update(@RequestBody TiposPagamento tipoPagamento, @PathVariable Integer tipoPagId) {
            TiposPagamento updatedTipoPagamento = tPRepository.getOne(tipoPagId);
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

            TiposPagamento tPToBeDeleted = new TiposPagamento();
            tPToBeDeleted = this.getById(tipoPagId);

            if(tPToBeDeleted == null){
                throw new EmptyResultDataAccessException("Tipo de Pagamento nao encontrado", 1);
            }

            tPRepository.deleteById(tipoPagId);
            return "Tipo de Pagamento " + tipoPagId + " has been deleted.";
         }
}
