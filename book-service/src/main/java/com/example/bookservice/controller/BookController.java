package com.example.bookservice.controller;

import com.example.bookservice.dto.BookDto;
import com.example.bookservice.dto.BookIdDto;
import com.example.bookservice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService=bookService;
    }
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBookDto(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }



}
