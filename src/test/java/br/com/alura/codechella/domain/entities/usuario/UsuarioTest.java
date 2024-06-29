package br.com.alura.codechella.domain.entities.usuario;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import br.com.alura.codechella.domain.Endereco;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private static final String EMAIL_VALIDO = "mail@mail.com";
    private static final LocalDate DATA_NASC_VALIDA = LocalDate.parse("1990-01-01");
    private static final String NOME_VALIDO = "Teste";
    private static final String CPF_VALIDO = "000.000.000-00";
    private static final Endereco ENDERECO_VALIDO = new Endereco("00000-000",123,"");

    @Test
    public void erroCPFInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", NOME_VALIDO, DATA_NASC_VALIDA , EMAIL_VALIDO));

        assertThrows(IllegalArgumentException.class,
                () -> new Usuario(null, NOME_VALIDO, DATA_NASC_VALIDA, EMAIL_VALIDO));

        assertThrows(IllegalArgumentException.class,
                () -> new Usuario("12345", NOME_VALIDO, DATA_NASC_VALIDA, EMAIL_VALIDO));

        assertThrows(IllegalArgumentException.class,
                () -> new Usuario("000.000000-00", NOME_VALIDO, DATA_NASC_VALIDA, EMAIL_VALIDO));
    }

    @Test
    public void erroEmailInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario(CPF_VALIDO, NOME_VALIDO, DATA_NASC_VALIDA, "email"));
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario(CPF_VALIDO, NOME_VALIDO, DATA_NASC_VALIDA, "email.com"));
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario(CPF_VALIDO, NOME_VALIDO, DATA_NASC_VALIDA, "email@"));
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario(CPF_VALIDO, NOME_VALIDO, DATA_NASC_VALIDA, "email@com"));
    }

    @Test
    public void sucessoCamposValidos() {
        assertNotNull(new Usuario(CPF_VALIDO, NOME_VALIDO, DATA_NASC_VALIDA, EMAIL_VALIDO));
    }

    @Test
    public void usuariosDeMesmoCpfSaoIguais() {
        var usuario1 = new Usuario("111.111.111-11", NOME_VALIDO, DATA_NASC_VALIDA, EMAIL_VALIDO);
        var usuario2 = new Usuario("111.111.111-11", NOME_VALIDO, DATA_NASC_VALIDA, EMAIL_VALIDO);

        assertTrue(usuario1.equals(usuario2));
    }

    @Test
    public void criaUsandoBuilder(){
        var usuario = new Usuario.UsuarioBuilder(CPF_VALIDO,EMAIL_VALIDO)
                                .nome(NOME_VALIDO)
                                .nascimento(DATA_NASC_VALIDA)
                                .endereco(ENDERECO_VALIDO)
                                .build();

        assertEquals(CPF_VALIDO, usuario.getCpf());
        assertEquals(DATA_NASC_VALIDA, usuario.getNascimento());
        assertEquals(EMAIL_VALIDO, usuario.getEmail());
        assertEquals(NOME_VALIDO, usuario.getNome());
        assertEquals(ENDERECO_VALIDO, usuario.getEndereco());
    }
}
