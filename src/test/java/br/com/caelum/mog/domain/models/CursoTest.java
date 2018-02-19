package br.com.caelum.mog.domain.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.Duration;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CursoTest {


    @Mock
    Curso fj11;


    @Test
    public void umCursoDeveTerNome(){
        when(fj11.getNome()).thenReturn("Java e Orientação a Objetos");

        assertThat(fj11.getNome(), is(equalTo("Java e Orientação a Objetos")));
    }


    @Test
    public void umCursoDeveTerValor(){
        when(fj11.getValor()).thenReturn(new BigDecimal("2290"));

        assertThat(fj11.getValor(), is(equalTo(new BigDecimal("2290"))));
    }


    @Test
    public void umCursoDeveTerCargaHoraria(){
        when(fj11.getCargaHoraria()).thenReturn(Duration.ofHours(40));

        assertThat(fj11.getCargaHoraria(), is(equalTo(Duration.ofHours(40))));
    }
}
