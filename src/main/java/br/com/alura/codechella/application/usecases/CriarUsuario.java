package br.com.alura.codechella.application.usecases;

import org.springframework.stereotype.Component;

import br.com.alura.codechella.application.gateways.UsuarioDataSourceGateway;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

@Component
public class CriarUsuario {
    private final UsuarioDataSourceGateway usuarioDataSourceGateway;

    public CriarUsuario(UsuarioDataSourceGateway usuarioDataSourceGateway) {
        this.usuarioDataSourceGateway = usuarioDataSourceGateway;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioDataSourceGateway.cadastrarUsuario(usuario);
    }
}
