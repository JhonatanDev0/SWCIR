package com.swcir.swcirsystem.Controllers.Reports;

import com.swcir.swcirsystem.Repositories.BemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/bem")
public class BensReports {

    @Autowired
    BemRepository bemRepository;

    @GetMapping(path="/count")
    public Long get(){
        Long countBens = bemRepository.count();

        return countBens;
    }
}
