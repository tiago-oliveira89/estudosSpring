package com.curso.spring.rest.libraryapi.api.resource;

import com.curso.spring.rest.libraryapi.api.dto.BookDto;
import com.curso.spring.rest.libraryapi.api.model.entity.Book;
import com.curso.spring.rest.libraryapi.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto create(@RequestBody BookDto dto) {
        Book book = modelMapper.map(dto,Book.class);
        Book savedBook = bookService.save(book);
        return modelMapper.map(savedBook,BookDto.class);
    }
}
