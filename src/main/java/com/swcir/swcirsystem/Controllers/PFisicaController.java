package com.swcir.swcirsystem.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;

import com.swcir.swcirsystem.Models.PFisica;
import com.swcir.swcirsystem.Repositories.PFisicaRepository;

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
@RequestMapping("/pfisica")
public class PFisicaController {
    
        @Autowired
        private PFisicaRepository pfisicaRepository;

        @GetMapping(path="/")
        public Iterable<PFisica> get(){
            Iterable<PFisica> listPFisicas = this.pfisicaRepository.findAll();

            if (listPFisicas == null) {
                throw new EmptyResultDataAccessException("Nenhum usuario encontrado", 1);
            }

            return listPFisicas;
        }

        @GetMapping(path="/{pfisid}")
        public PFisica getById(@PathVariable int pfisid){
            
            PFisica pfisicaRecovered = new PFisica();

            try {
                pfisicaRecovered = this.pfisicaRepository.findById(pfisid).get();
            } catch (NoSuchElementException e) {
                throw new EmptyResultDataAccessException("Nao existe pessoa fisica com o ID informado", 1);
            }
            return pfisicaRecovered;
        }

        @PostMapping(path="/") // Map ONLY POST Requests
            public ResponseEntity<PFisica> create(@RequestBody PFisica pfisica) 
            throws URISyntaxException {

            PFisica createdPFisica = pfisicaRepository.save(pfisica);        
                if (createdPFisica == null || createdPFisica.getCpf().equals(null) || createdPFisica.getDataNasc().equals(null)) {
                    return ResponseEntity.notFound().build();
                } else {
            
                    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{pfisid}")
                    .buildAndExpand(createdPFisica.getPFisId())
                    .toUri();

                    return ResponseEntity.created(uri)
                    .body(createdPFisica);
            }
        }

        @PutMapping("/{pfisid}")
        public ResponseEntity<PFisica> update(@RequestBody PFisica pfisica, @PathVariable Integer pfisid) {
            PFisica updatedPFisica = pfisicaRepository.getOne(pfisid);
            if (updatedPFisica != null) {
                pfisica.setPFisId(pfisid);
                pfisicaRepository.save(pfisica);
                return ResponseEntity.ok(pfisica);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping(path="/{pfisid}")
        public String delete(@PathVariable int pfisid){

            PFisica pfisToBeDeleted = new PFisica();
            pfisToBeDeleted = this.getById(pfisid);

            if(pfisToBeDeleted == null){
                throw new EmptyResultDataAccessException("Pessoa Fisica nao encontrada", 1);
            }

            pfisicaRepository.deleteById(pfisid);
            return "Pessoa Fisica " + pfisid + " has been deleted.";
         }
}