package com.pessoa.business;

import com.pessoa.domain.Pessoa;
import com.pessoa.utils.CpfCnpjUtils;
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

    public void criarPessoa() throws Exception {
        Pessoa pessoa = Pessoa.builder().nome("Alex").cpf("1111").build();
        boolean cpfValid = CpfCnpjUtils.isValid(pessoa.getCpf());
        if (cpfValid) {
            repository.save(pessoa);
        } else {
            throw new Exception("CPF inválido!");
        }

    }

    public void savePessoa(Pessoa pessoa) throws Exception {
        if (pessoa == null) {
            throw new Exception("Informe uma pessoa para um novo cadastro!");
        }
        boolean cpfValid = CpfCnpjUtils.isValid(pessoa.getCpf());
        if (cpfValid) {
            repository.save(pessoa);
        } else {
            throw new Exception("CPF inválido!");
        }
    }

    public void excluirPessoa(String cpf) throws Exception {
        Pessoa pessoaDeleta = validarPessoaSeExistePeloCPF(cpf);
        repository.delete(pessoaDeleta);
    }

    private Pessoa validarPessoaSeExistePeloCPF(String cpf) throws Exception {
        Pessoa pessoa = repository.findByCpf(cpf);
        if (pessoa == null) {
            throw new Exception("Pessoa não encontrada com o CPF: " + cpf);
        }
        return pessoa;
    }

    public void atualizarPessoa(Pessoa pessoa) throws Exception {
        Pessoa pessoaBase = validarPessoaSeExistePeloCPF(pessoa.getCpf());
        Pessoa pessoaUpdate = Pessoa.builder().id(pessoaBase.getId()).cpf(pessoa.getCpf()).nome(pessoa.getNome()).build();
        repository.save(pessoaUpdate);
    }

    public Pessoa getPessoaByCpf(String cpf) throws Exception {
        return validarPessoaSeExistePeloCPF(cpf);
    }
}
