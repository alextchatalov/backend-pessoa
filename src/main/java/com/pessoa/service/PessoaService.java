package com.pessoa.service;

import com.pessoa.business.PessoaBusiness;
import com.pessoa.domain.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaBusiness business;

    public List<Pessoa> getPessoas() {
        return business.getPessoas();
    }

    public void criarPessoa(){
        business.criarPessoa();
    }

}
