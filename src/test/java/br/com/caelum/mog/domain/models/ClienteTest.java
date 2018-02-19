package br.com.caelum.mog.domain.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClienteTest {

    @Mock
    Cliente cdc;

    @Test
    public void umClienteDeveTerNomeFantasia(){

        when(cdc.getNomeFantasia()).thenReturn("Casa do código");

        assertThat(cdc.getNomeFantasia(), is(equalTo("Casa do código")));

    }


    @Test
    public void umClienteDeveTerRazaoSocial(){
        when(cdc.getRazaoSocial()).thenReturn("Casa do código LTDA.");

        assertThat(cdc.getRazaoSocial(), is(equalTo("Casa do código LTDA.")));

    }


    @Test
    public void umClienteDeveTerCnpj(){
        when(cdc.getCnpj()).thenReturn("11.111.111/1111-11");

        assertThat(cdc.getCnpj(), is(equalTo("11.111.111/1111-11")));
    }
}
