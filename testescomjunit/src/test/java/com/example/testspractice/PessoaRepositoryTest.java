package com.example.testspractice;

import com.example.testspractice.model.Pessoa;
import com.example.testspractice.repository.PessoaRepository;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void createShouldPersistData(){
        Pessoa pessoa = Pessoa.builder().id(1L).cpf("46464").nome("Tiago").idade(30).build();
        pessoaRepository.save(pessoa);
        Assertions.assertThat(pessoa.getId()).isNotNull();
        Assertions.assertThat(pessoa.getCpf()).isEqualTo("46464");
        Assertions.assertThat(pessoa.getIdade()).isEqualTo(30);
        Assertions.assertThat(pessoa.getNome()).isEqualTo("Tiago");
    }

    @Test
    public void deleteShouldRemoveDataById(){
        Pessoa pessoa1 = Pessoa.builder().id(1L).cpf("46464").nome("Tiago").idade(30).build();
        Pessoa pessoa2 = Pessoa.builder().id(2L).cpf("46464").nome("Heloisa").idade(30).build();
        pessoaRepository.save(pessoa1);
        pessoaRepository.delete(pessoa1);
        Assertions.assertThat(pessoaRepository.findById(pessoa1.getId())).isEmpty();

    }

    @Test
    public void updateShouldChangeData(){
        Pessoa pessoa1 = Pessoa.builder().id(1L).cpf("46464").nome("Tiago").idade(30).build();
        pessoaRepository.save(pessoa1);
        pessoa1.setNome("Heloisa");
        pessoaRepository.save(pessoa1);
        Assertions.assertThat(pessoa1.getNome()).isEqualTo("Heloisa");

    }

    @Test
    public void crateWhenNameEqualsNullShouldTrhowsConstraintViolationExcetion(){
        // TODO: 08/12/2019   //não está lançando essa exceção corrigir
        thrown.expect(ConstraintViolationException.class);
        pessoaRepository.save(Pessoa.builder().nome("").build());


    }
}
