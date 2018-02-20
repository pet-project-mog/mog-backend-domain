package br.com.caelum.mog.domain.models;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Period;

public class PropostaTest {

    @Rule
    public ExpectedException throwing = ExpectedException.none();
    private Curso fj11;
    private Curso fj21;
    private Cliente cdc;

    @Before
    public void setup() {
        cdc = new Cliente("CDC", "Casa do código", "11.111.111/1111-11");
        fj11 = new Curso("Java e Orientação a objetos", new BigDecimal("2290"), Duration.ofHours(40));
        fj21 = new Curso("Java para Desenvolvimento web", new BigDecimal("2890"), Duration.ofHours(40));
    }


    @Test
    public void naoDeveSerPossivelInstanciarUmaPropostaComClienteNulo(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Cliente é obrigatório");

        new Proposta(null, Period.ofWeeks(2), fj11, fj21);
    }



    @Test
    public void naoDeveSerPossivelInstanciarUmaPropostaComPeriodoNulo(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Período é obrigatório");

        new Proposta(cdc, null, fj11, fj21);
    }


    @Test
    public void naoDeveSerPossivelInstanciarUmaPropostaComPeriodoNegativo(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Período não pode ser negativo");

        new Proposta(cdc, Period.ofWeeks(-2), fj11, fj21);
    }

    @Test
    public void naoDeveSerPossivelInstanciarUmaPropostaComPeriodoZerado(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Período não pode ser zero");

        new Proposta(cdc, Period.ofWeeks(0), fj11, fj21);
    }


    @Test
    public void nadoDeveSerPossivelInstanciarUmaPropostaSemCursos(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Deve ter pelo menos um curso");

        new Proposta(cdc, Period.ofWeeks(2));
    }


}