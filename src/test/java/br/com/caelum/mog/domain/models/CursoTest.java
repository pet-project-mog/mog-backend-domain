package br.com.caelum.mog.domain.models;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.time.Duration;

public class CursoTest {


    @Rule
    public ExpectedException throwing = ExpectedException.none();


    @Test
    public void naoDeveSerPossivelInstanciarUmCursoComNomeNulo(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Nome é obrigatório");

        new Curso(null, new BigDecimal("2290"), Duration.ofHours(40));

    }

    @Test
    public void naoDeveSerPossivelInstanciarUmCursoComNomeVazio(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Nome é obrigatório");

        new Curso("", new BigDecimal("2290"), Duration.ofHours(40));
    }

    @Test
    public void naoDeveSerPossivelInstanciarUmCursoComPrecoNulo(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Preço é obrigatório");


        new Curso("Java e Orientação a Objetos", null, Duration.ofHours(40));
    }

    @Test
    public void naoDeveSerPossivelInstanciarUmCursoComPrecoNegativo(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Preço deve ser maior que zero");

        new Curso("Java e Orientação a Objetos", new BigDecimal("-1"), Duration.ofHours(40));

    }

    @Test
    public void naoDeveSerPossivelInstanciarUmCursoComPrecoZerado(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Preço deve ser maior que zero");

        new Curso("Java e Orientação a Objetos", BigDecimal.ZERO, Duration.ofHours(40));
    }


    @Test
    public void naoDeveSerPossivelInstanciarUmCursoComCargaHorariaNula(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Carga horária é obrigatória");


        new Curso("Java e Orientação a Objetos", new BigDecimal("2290"), null);
    }


    @Test
    public void naoDeveSerPossivelInstanciarUmCursoComCargaHorariaNegativa(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Carga horária não pode ser negativa");


        new Curso("Java e Orientação a Objetos", new BigDecimal("2290"), Duration.ofHours(-8));
    }


    @Test
    public void naoDeveSerPossivelInstanciarUmCursoComCargaHorariaZerada(){
        throwing.expect(IllegalArgumentException.class);
        throwing.expectMessage("Carga horária não pode ser zero");


        new Curso("Java e Orientação a Objetos", new BigDecimal("2290"), Duration.ofHours(0));
    }

}