package com.swcir.swcirsystem.Controllers;

import java.net.URI;
import java.util.NoSuchElementException;

import com.swcir.swcirsystem.Models.Pagamento;
import com.swcir.swcirsystem.Models.TipoPagamento;
import com.swcir.swcirsystem.Repositories.PagamentoRepository;
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
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private TipoPagamentoRepository tipoPagamentoRepository;

    @GetMapping(path="/")
    public Iterable<Pagamento> get(){
        Iterable<Pagamento> listPagamentos = this.pagamentoRepository.findAll();

        if (listPagamentos == null) {
            throw new EmptyResultDataAccessException("Nenhum Pagamento encontrado", 1);
        }

        return listPagamentos;
    }

    @GetMapping(path="/{pagId}")
    public Pagamento getById(@PathVariable Integer pagId){
        
        Pagamento pagRecovered = new Pagamento();

        try {
            pagRecovered = this.pagamentoRepository.findById(pagId).get();
        } catch (NoSuchElementException e) {
            throw new EmptyResultDataAccessException("Nao existe Pagamento com o ID informado", 1);
        }
        return pagRecovered;
    }
    
    @PostMapping("/")
        public ResponseEntity<Pagamento> create(@RequestBody Pagamento pagamento) {
            
            TipoPagamento tipoPagamento = pagamento.getTipoPagamento() == null ? null : tipoPagamentoRepository.getOne(pagamento.getUser().getUserId());
            pagamento.setTipoPagamento(tipoPagamento);
            Pagamento createdPagamento = pagamentoRepository.save(pagamento);  
            
            if (createdPagamento == null || createdPagamento.getTipoPagamento().getTipoPagId() == null || createdPagamento.getUser().getUserId() == null ) {
                return ResponseEntity.notFound().build();
            } else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPagamento.getPagId())
                .toUri();

                return ResponseEntity.created(uri)
                .body(createdPagamento);
            }
        }

        @PutMapping("/{pagId}")
        public ResponseEntity<Pagamento> update(@RequestBody Pagamento pagamento, @PathVariable Integer pagId) {
            Pagamento updatedPagamento = pagamentoRepository.getOne(pagId);
            if(updatedPagamento != null){
                pagamento.setPagId(pagId);
                pagamentoRepository.save(pagamento);
                return ResponseEntity.ok(pagamento);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping(path="/{pagId}")
        public String delete(@PathVariable Integer pagId){

            Pagamento pagToBeDeleted = new Pagamento();
            pagToBeDeleted = this.getById(pagId);

            if(pagToBeDeleted == null){
                throw new EmptyResultDataAccessException("Pagamento nao encontrado", 1);
            }

            pagamentoRepository.deleteById(pagId);
            return "Pagamento " + pagId + " has been deleted.";
         }
}
