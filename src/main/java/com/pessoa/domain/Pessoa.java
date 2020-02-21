package com.pessoa.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private @NotNull Long id;
    private @NotNull String nome;
    private @NotNull String cpf;

}
