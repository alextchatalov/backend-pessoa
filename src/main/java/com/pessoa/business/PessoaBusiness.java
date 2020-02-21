package com.pessoa.business;

import com.pessoa.domain.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pessoa.repository.PessoaRepository;

import java.util.List;

@Component
public class PessoaBusiness {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> getPessoas() {
        return (List<Pessoa>) repository.findAll();
    }

    public void criarPessoa() {
        Pessoa pessoa = Pessoa.builder().nome("Alex").cpf("1111").build();
        repository.save(pessoa);

    }
}
