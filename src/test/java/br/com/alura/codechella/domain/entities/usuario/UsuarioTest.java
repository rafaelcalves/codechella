package br.com.alura.codechella.domain.entities.usuario;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void erroAoInformarCPFInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Usuario("","Teste",LocalDate.parse("1990-04-11"),"mail@mail.com"));

        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Usuario(null,"Teste",LocalDate.parse("1990-04-11"),"mail@mail.com"));
        
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Usuario("12345","Teste",LocalDate.parse("1990-04-11"),"mail@mail.com"));
        
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Usuario("000.000000-00","Teste",LocalDate.parse("1990-04-11"),"mail@mail.com"));
    
    }

    @Test
    public void sucessoAoInformarCPFValido(){
        Assertions.assertNotNull(new Usuario("000.000.000-00","Teste",LocalDate.parse("1990-04-11"),"mail@mail.com"));
    }
}
