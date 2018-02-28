package br.com.caelum.mog.domain.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClienteTest {
    
    @Test
    void naoDeveSerPossivelInstanciarUmClienteComUmNomeFantasiaNulo(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
                () ->  new Cliente(null, "Casa do código", "11.111.111/1111-11"));
        assertEquals("Nome fantasia é obrigatório", exception.getMessage());
    }


    @Test
    void naoDeveSerPossivelInstanciarUmClienteComUmNomeFantasiaVazio(){

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Cliente("", "Casa do código", "11.111.111/1111-11"));
        assertEquals("Nome fantasia é obrigatório", exception.getMessage());

    }

    @Test
    void naoDeveSerPossivelInstanciarUmClienteComUmaRazaoSocialNula(){

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Cliente("CDC", null, "11.111.111/1111-11"));

        assertEquals("Razão social é obrigatória", exception.getMessage());
    }


    @Test
    void naoDeveSerPossivelInstanciarUmClienteComUmaRazaoSocialVazia(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Cliente("CDC", "", "11.111.111/1111-11"));
        assertEquals("Razão social é obrigatória", exception.getMessage());
    }


    @Test
    void naoDeveSerPossivelInstanciarUmClienteComUmCNPJNulo(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Cliente("CDC", "Casa do código", null));
        assertEquals("CNPJ é obrigatório", exception.getMessage());
    }

    @Test
    void naoDeveSerPossivelInstanciarUmClienteComUmCNPJVazio(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Cliente("CDC", "Casa do código", ""));
        assertEquals("CNPJ é obrigatório", exception.getMessage());
    }

}