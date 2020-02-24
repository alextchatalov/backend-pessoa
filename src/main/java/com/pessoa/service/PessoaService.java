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

    public void savePessoa(Pessoa pessoa) throws Exception {
        business.savePessoa(pessoa);
    }

    public void excluirPessoa(String cpf) throws Exception {
        business.excluirPessoa(cpf);
    }

    public void atualizarPessoa(Pessoa pessoa) throws Exception {
        business.atualizarPessoa(pessoa);
    }

    public Pessoa getPessoaByCpf(String cpf) throws Exception {
        return  business.getPessoaByCpf(cpf);
    }
}
