package com.cursospring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CadastroDePessoasTest {

    @Test
    @DisplayName("Deve criar o cadastro de pessoas")
    public void deveCriarOCadastroDePessoas() {
        //cenário e execução
        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        //verificação
        //verificar que em um primeiro momento o banco de pessoas está vazio
        Assertions.assertThat( cadastroPessoas.getPessoas() ).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa() {
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        //execução
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Tiago");
        cadastroPessoas.adicionarPessoa(pessoa);

        Assertions.assertThat(cadastroPessoas.getPessoas())
            .isNotEmpty()
            .hasSize(1)
            .contains(pessoa);
    }

    @Test()
    public void naoDeveAdicionarPessoaComNomeVazio() {
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        //execução
        Pessoa pessoa = new Pessoa();
        assertThrows(
                PessoaSemNomeException.class,
                ()-> cadastroPessoas.adicionarPessoa(pessoa)
        );
    }

    @Test
    public void deveRemoverUmaPessoa() {
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Tiago");
        cadastroPessoas.adicionarPessoa(pessoa);

        //execução
        cadastroPessoas.removerPessoa(pessoa);

        //verificação
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();

    }

    @Test()
    public void deveLancarErroAoRemoverPessoaInexistente() {

        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        assertThrows(
                CadastroVazioException.class,
                ()->  cadastroPessoas.removerPessoa(pessoa)
        );
    }
}
