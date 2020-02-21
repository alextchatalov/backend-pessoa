package com.pessoa.controller;

import com.pessoa.domain.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pessoa.service.PessoaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping("/pessoas")
    public List<Pessoa> getPessoas() {
        System.out.println("BATEU NO END POINT");
        service.criarPessoa();
        return service.getPessoas();
    }
}
