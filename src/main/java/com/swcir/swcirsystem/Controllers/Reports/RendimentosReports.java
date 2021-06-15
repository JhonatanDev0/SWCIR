package com.swcir.swcirsystem.Controllers.Reports;

import com.swcir.swcirsystem.Repositories.RendimentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/rend")
public class RendimentosReports {

    @Autowired
    RendimentoRepository rendimentoRepository;

    @GetMapping(path="/count")
    public Long get(){
        Long countBens = rendimentoRepository.count();

        return countBens;
    }
}
