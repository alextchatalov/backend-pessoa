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

    @GetMapping("/list")
    public List<Pessoa> getPessoas() {
        return service.getPessoas();
    }

    @GetMapping("/cpf/{cpf}")
    public Pessoa getPessoasByCpf(@PathVariable String cpf) {
        try {
            return service.getPessoaByCpf(cpf);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage());
        }
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

    @DeleteMapping("/deleta/{cpf}")
    public void excluirPessoa(@PathVariable String cpf) {
        try {
            service.excluirPessoa(cpf);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    @PutMapping("/update")
    public void atualizarPessoa(@RequestBody Pessoa pessoa) {
        try {
            service.atualizarPessoa(pessoa);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
