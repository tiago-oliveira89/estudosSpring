package com.example.testspractice.controller;
import com.example.testspractice.model.Pessoa;
import com.example.testspractice.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public Pessoa findPessoaById(@PathVariable Long id){
        return pessoaService.findPessoaById(id);
    }
}
