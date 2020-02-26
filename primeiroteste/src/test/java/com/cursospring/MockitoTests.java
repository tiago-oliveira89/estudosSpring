package com.cursospring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockitoTests {

    @Mock
    List<String> lista;

    @Test
    public void primeiroTesteMockito() {
        Mockito.when(lista.size()).thenReturn(20);
        int size = lista.size();
        Assertions.assertThat(size).isEqualTo(20);
        Mockito.verify(lista,Mockito.times(1)).size();
    }

    @Test
    public void segundoTesteMockito() {
        //maneira de fazer sem annotation
        List<String> lista = Mockito.mock(ArrayList.class);
        //verifica se não foi chamado o método
        Mockito.verify(lista,Mockito.never()).size();
    }

    @Test
    public void terceiroTesteMOckito() {
        //verifica se os méotodos foram executados em uma determinada ordem
        lista.size();
        lista.add("");

        InOrder inOrder = Mockito.inOrder(lista);
        inOrder.verify(lista).size();
        inOrder.verify(lista).add("");
    }
}
