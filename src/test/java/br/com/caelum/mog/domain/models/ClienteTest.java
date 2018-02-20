package br.com.caelum.mog.domain.models;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ClienteTest {

    @Rule
    public ExpectedException throwing = ExpectedException.none();

    @Test
    public void naoDeveSerPossivelInstanciarUmClienteComUmNomeFantasiaNulo(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Nome fantasia é obrigatório");

        new Cliente(null, "Casa do código", "11.111.111/1111-11");


    }


    @Test
    public void naoDeveSerPossivelInstanciarUmClienteComUmNomeFantasiaVazio(){

        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Nome fantasia é obrigatório");

        new Cliente("", "Casa do código", "11.111.111/1111-11");
    }

    @Test
    public void naoDeveSerPossivelInstanciarUmClienteComUmaRazaoSocialNula(){

        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Razão social é obrigatória");

        new Cliente("CDC", null, "11.111.111/1111-11");



    }


    @Test
    public void naoDeveSerPossivelInstanciarUmClienteComUmaRazaoSocialVazia(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Razão social é obrigatória");

        new Cliente("CDC", "", "11.111.111/1111-11");
    }


    @Test
    public void naoDeveSerPossivelInstanciarUmClienteComUmCNPJNulo(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("CNPJ é obrigatório");

        new Cliente("CDC", "Casa do código", null);
    }

    @Test
    public void naoDeveSerPossivelInstanciarUmClienteComUmCNPJVazio(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("CNPJ é obrigatório");

        new Cliente("CDC", "Casa do código", "");
    }

}