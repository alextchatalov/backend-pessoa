package com.pessoa.controller;

import com.pessoa.domain.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.pessoa.service.PessoaService;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping("/pessoas")
    public List<Pessoa> getPessoas() {
        return service.getPessoas();
    }

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public void novo(@RequestBody Pessoa pessoaRequest) {
        try {
            service.savePessoa(pessoaRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
