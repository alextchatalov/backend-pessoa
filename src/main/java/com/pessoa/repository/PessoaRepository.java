package com.pessoa.repository;

import com.pessoa.domain.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface  PessoaRepository extends  CrudRepository<Pessoa, Long> {
    Pessoa findByCpf(String cpf);
    Pessoa findById(long id);
}
