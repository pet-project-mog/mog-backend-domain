package br.com.caelum.mog.domain.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PropostaTest {


    private Curso fj11;
    private Curso fj21;
    private Cliente cdc;

    @BeforeEach
    void setup() {
        cdc = new Cliente("CDC", "Casa do código", "11.111.111/1111-11");
        fj11 = new Curso("Java e Orientação a objetos", new BigDecimal("2290"), Duration.ofHours(40));
        fj21 = new Curso("Java para Desenvolvimento web", new BigDecimal("2890"), Duration.ofHours(40));
    }


    @Test
    void naoDeveSerPossivelInstanciarUmaPropostaComClienteNulo(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                                                        () -> new Proposta(null, Period.ofWeeks(2), fj11, fj21));

        assertEquals("Cliente é obrigatório", exception.getMessage());
    }



    @Test
    void naoDeveSerPossivelInstanciarUmaPropostaComPeriodoNulo(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                                                        () -> new Proposta(cdc, null, fj11, fj21));


        assertEquals("Período é obrigatório", exception.getMessage());
    }


    @Test
    void naoDeveSerPossivelInstanciarUmaPropostaComPeriodoNegativo(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                                                        () -> new Proposta(cdc, Period.ofWeeks(-2), fj11, fj21));

        assertEquals("Período não pode ser negativo", exception.getMessage());
    }

    @Test
    void naoDeveSerPossivelInstanciarUmaPropostaComPeriodoZerado(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                                                        () -> new Proposta(cdc, Period.ofWeeks(0), fj11, fj21));

        assertEquals("Período não pode ser zero", exception.getMessage());
    }


    @Test
    void nadoDeveSerPossivelInstanciarUmaPropostaSemCursos(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                                                        () -> new Proposta(cdc, Period.ofWeeks(2)));

        assertEquals("Deve ter pelo menos um curso", exception.getMessage());
    }
}