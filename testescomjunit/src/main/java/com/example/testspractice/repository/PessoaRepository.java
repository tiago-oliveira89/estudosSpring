package com.example.testspractice.repository;

import com.example.testspractice.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa,Long> {
}
