package br.com.alura.codechella.infra.gateways;

import org.mapstruct.Mapper;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {

    UsuarioEntity toEntity(Usuario domain);

    Usuario toDomain(UsuarioEntity entity);
}
