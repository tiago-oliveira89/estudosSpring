package com.example.testspractice.service;

import com.example.testspractice.model.Pessoa;
import com.example.testspractice.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa findPessoaById(Long id){
        return pessoaRepository.findById(id).get();
    }

}
