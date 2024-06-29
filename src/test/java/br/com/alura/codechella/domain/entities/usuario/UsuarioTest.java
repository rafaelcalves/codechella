package br.com.alura.codechella.domain.entities.usuario;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    private static final String EMAIL_VALIDO = "mail@mail.com";
    private static final String DATA_NASC_VALIDA = "1990-04-11";
    private static final String NOME_VALIDO = "Teste";
    private static final String CPF_VALIDO = "000.000.000-00";

    @Test
    public void erroCPFInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Usuario("",NOME_VALIDO,LocalDate.parse(DATA_NASC_VALIDA),EMAIL_VALIDO));

        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Usuario(null,NOME_VALIDO,LocalDate.parse(DATA_NASC_VALIDA),EMAIL_VALIDO));
        
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Usuario("12345",NOME_VALIDO,LocalDate.parse(DATA_NASC_VALIDA),EMAIL_VALIDO));
        
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Usuario("000.000000-00",NOME_VALIDO,LocalDate.parse(DATA_NASC_VALIDA),EMAIL_VALIDO));
    }

    @Test
    public void erroEmailInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Usuario(CPF_VALIDO,NOME_VALIDO,LocalDate.parse(DATA_NASC_VALIDA),"email"));
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Usuario(CPF_VALIDO,NOME_VALIDO,LocalDate.parse(DATA_NASC_VALIDA),"email.com"));
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Usuario(CPF_VALIDO,NOME_VALIDO,LocalDate.parse(DATA_NASC_VALIDA),"email@"));
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Usuario(CPF_VALIDO,NOME_VALIDO,LocalDate.parse(DATA_NASC_VALIDA),"email@com"));
    }

    @Test
    public void sucessoCamposValidos(){
        Assertions.assertNotNull(new Usuario(CPF_VALIDO,NOME_VALIDO,LocalDate.parse(DATA_NASC_VALIDA),EMAIL_VALIDO));
    }

}
