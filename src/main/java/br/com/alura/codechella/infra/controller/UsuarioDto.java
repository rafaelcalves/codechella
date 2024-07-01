package br.com.alura.codechella.infra.controller;

import java.time.LocalDate;

import br.com.alura.codechella.domain.values.Endereco;

public record UsuarioDto (
    String cpf,
    String nome,
    LocalDate nascimento,
    String email,
    Endereco endereco
){}
