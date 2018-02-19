package br.com.caelum.mog.domain.models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropostaTest {

    @Mock
    Proposta proposta;

    @Mock
    Curso fj11;

    @Mock
    Curso fj21;

    @Mock
    Cliente cdc;


    @Before
    public void setup(){
        BigDecimal doisMilDuzentosENoventaReais = new BigDecimal("2290");

        when(fj11.getValor()).thenReturn(doisMilDuzentosENoventaReais);
        when(fj21.getValor()).thenReturn(doisMilDuzentosENoventaReais);
    }

    @Test
    public void umaPropostaDeveTerVariosCursos(){

        List<Curso> fj11Efj21 = List.of(fj11, fj21);

        when(proposta.getCursos()).thenReturn(fj11Efj21);

        assertThat(proposta.getCursos(), contains(fj11, fj21));
    }

    @Test
    public void umPropostaDeveTerUmCliente(){

        when(proposta.getCliente()).thenReturn(cdc);

        assertThat(proposta.getCliente(), is(equalTo(cdc)));

    }


    @Test
    public void umaPropostaDeveTerUmPeriodo(){
        LocalDate hoje = LocalDate.now();
        LocalDate amanha = hoje.plusDays(1);

        Period periodo = Period.between(hoje, amanha);

        when(proposta.getPeriodo()).thenReturn(periodo);

        assertThat(proposta.getPeriodo(), is(equalTo(periodo)));
    }

    @Test
    public void umaPropostaDeveTerOTotal(){
        BigDecimal quatroMilQuinhentosEOitentaReais = new BigDecimal("4580");

        List<Curso> fj11Efj21 = List.of(fj11, fj21);

        when(proposta.getCursos()).thenReturn(fj11Efj21);
        when(proposta.getTotal()).thenCallRealMethod();

        assertThat(proposta.getTotal(), is(equalTo(quatroMilQuinhentosEOitentaReais)));

    }
}
