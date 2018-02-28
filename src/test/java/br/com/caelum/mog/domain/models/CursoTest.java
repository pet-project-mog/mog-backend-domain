package br.com.caelum.mog.domain.models;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CursoTest {

    @Test
    void naoDeveSerPossivelInstanciarUmCursoComNomeNulo(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                                        () -> new Curso(null, new BigDecimal("2290"), Duration.ofHours(40)));

        assertEquals("Nome é obrigatório", exception.getMessage());

    }

    @Test
    void naoDeveSerPossivelInstanciarUmCursoComNomeVazio(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                                        () -> new Curso("", new BigDecimal("2290"), Duration.ofHours(40)));

        assertEquals("Nome é obrigatório", exception.getMessage());


    }

    @Test
    void naoDeveSerPossivelInstanciarUmCursoComPrecoNulo(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                                () -> new Curso("Java e Orientação a Objetos", null, Duration.ofHours(40)));
        assertEquals("Preço é obrigatório", exception.getMessage());
    }

    @Test
    void naoDeveSerPossivelInstanciarUmCursoComPrecoNegativo(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> new Curso("Java e Orientação a Objetos", new BigDecimal("-1"), Duration.ofHours(40)));

        assertEquals("Preço deve ser maior que zero", exception.getMessage());
    }

    @Test
    void naoDeveSerPossivelInstanciarUmCursoComPrecoZerado(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                            () -> new Curso("Java e Orientação a Objetos", BigDecimal.ZERO, Duration.ofHours(40)));
        assertEquals("Preço deve ser maior que zero", exception.getMessage());
    }


    @Test
    void naoDeveSerPossivelInstanciarUmCursoComCargaHorariaNula(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> new Curso("Java e Orientação a Objetos", new BigDecimal("2290"), null));
        assertEquals("Carga horária é obrigatória", exception.getMessage());
    }


    @Test
    void naoDeveSerPossivelInstanciarUmCursoComCargaHorariaNegativa(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Curso("Java e Orientação a Objetos", new BigDecimal("2290"), Duration.ofHours(-8)));
        assertEquals("Carga horária não pode ser negativa", exception.getMessage());
    }


    @Test
    void naoDeveSerPossivelInstanciarUmCursoComCargaHorariaZerada(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Curso("Java e Orientação a Objetos", new BigDecimal("2290"), Duration.ofHours(0)));
        assertEquals("Carga horária não pode ser zero", exception.getMessage());
    }

}