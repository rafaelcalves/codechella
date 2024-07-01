package br.com.alura.codechella.infra.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.codechella.application.usecases.CriarUsuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final CriarUsuario criarUsuario;
    private final UsuarioDtoMapper usuarioDtoMapper;
    
    public UsuarioController(CriarUsuario criarUsuario, UsuarioDtoMapper usuarioDtoMapper) {
        this.criarUsuario = criarUsuario;
        this.usuarioDtoMapper = usuarioDtoMapper;
    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto usuario){
        var domain = criarUsuario.cadastrarUsuario(usuarioDtoMapper.toDomain(usuario));
        return usuarioDtoMapper.toDto(domain);
    }

}
