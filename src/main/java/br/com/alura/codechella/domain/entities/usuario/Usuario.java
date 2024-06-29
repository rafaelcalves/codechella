package br.com.alura.codechella.domain.entities.usuario;

import java.time.LocalDate;

import br.com.alura.codechella.domain.Patterns;

public class Usuario {

    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;
    
    public Usuario(String cpf, String nome, LocalDate nascimento, String email) {
        if(cpf == null || !Patterns.CPF_PATTERN.matcher(cpf).matches())
            throw new IllegalArgumentException("CPF no padrão incorreto");
        if(email == null || !Patterns.EMAIL_PATTERN.matcher(email).matches())
            throw new IllegalArgumentException("Email no padrão incorreto");

        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
