package com.br.projetoSpringBootTestes;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class MockitoTeste {

    @Test
    public void primeiroTesteMockito() {
        var lista = Mockito.mock(ArrayList.class);

        lista.add("Luffy");
        lista.add("Nami");

        Mockito.when(lista.size()).thenReturn(20);

        int tamanho = lista.size();

        Assertions.assertThat(tamanho).isEqualTo(20);
    }

    @Test
    public void usandoVerificadoDeAlteracao() {
        var lista = Mockito.mock(ArrayList.class);

        lista.add("Luffy");
        lista.add("Nami");

        Mockito.when(lista.size()).thenReturn(20);

        int tamanho = lista.size();

//        Assertions.assertThat(tamanho).isEqualTo(20);
        Mockito.verify(lista).size();
    }
}
