package br.com.alura.codechella.infra.controller;

import org.mapstruct.Mapper;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioDtoMapper {
    UsuarioDto toDto(Usuario domain);
    Usuario toDomain(UsuarioDto dto);
}
