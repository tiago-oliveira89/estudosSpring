package com.cursospring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimeiroTeste {

    Calculadora calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = new Calculadora();
    }


    //convenção descrever a ação do método
    @Test
    public void deveSomar2Numeros() {
        //primeiro criar o cenário de teste
        int numero1 = 10,numero2 = 5;

        //execução do teste
        int resultado = calculadora.somar(numero1,numero2);

        //verificações
        assertEquals(resultado,15);

        //exemplo com assertJ
        Assertions.assertThat(resultado).isEqualTo(15);

    }

    @Test
    public void deveSubtrair2Numeros() {
        //primeiro criar o cenário de teste
        int numero1 = 10,numero2 = 5;

        //execução do teste
        int resultado = calculadora.subtrair(numero1,numero2);

        //verificações
        assertEquals(resultado,5);

        //exemplo com assertJ
        Assertions.assertThat(resultado).isEqualTo(5);

    }

    @Test
    public void deveMultiplicar2Numeros() {
        //primeiro criar o cenário de teste
        int numero1 = 10,numero2 = 5;

        //execução do teste
        int resultado = calculadora.multiplicar(numero1,numero2);

        //verificações
        assertEquals(resultado,50);

        //exemplo com assertJ
        Assertions.assertThat(resultado).isEqualTo(50);

    }

    @Test
    public void deveDividir2Numeros() {
        //primeiro criar o cenário de teste
        int numero1 = 10,numero2 = 5;

        //execução do teste
        float resultado = calculadora.dividir(numero1,numero2);

        //exemplo com assertJ
        Assertions.assertThat(resultado).isEqualTo(2);

    }


    public void naoDeveDividirPorZero() {
        //cenário
        int numero1 = 10, numero2 = 0;

        assertThrows(
                ArithmeticException.class,
                ()->   calculadora.dividir(numero1,numero2)
        );
    }

    public void naoDeveSomarNumerosNegativos() {
        //cenário
        int numero1 = -10, numero2 = 5;
        assertThrows(
                RuntimeException.class,
                ()->   calculadora.somar(numero1,numero2)
        );
    }
}

class Calculadora {

    int somar(int num,int num2) {
        if(num < 0 || num2 < 0 ) {
            throw new RuntimeException("Não permitido somar números negativos");
        }
        return num + num2;
    }

    int subtrair(int num,int num2) {
        return num - num2;
    }

    int multiplicar(int num,int num2) {
        return num * num2;
    }

    float dividir(int num,int num2) {
        return num / num2;
    }
}
