package com.example.bookservice.service;

import com.example.bookservice.dto.BookDto;
import com.example.bookservice.dto.BookIdDto;
import com.example.bookservice.exception.BookNotFoundException;
import com.example.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public List<BookDto> getAllBooks(){
        return bookRepository.findAll()
                .stream()
                .map(BookDto::convert)
                .collect(Collectors.toList());
    }
    public BookIdDto findByIsbn(String isbn){
        return bookRepository.findBookByIsbn(isbn)
                .map(book -> new BookIdDto(book.getId(), book.getIsbn()))
                .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn: "+ isbn));
    }

    public BookDto findBookDetailsById(String id){
        return bookRepository.findById(id)
                .map(BookDto::convert)
                .orElseThrow(() -> new BookNotFoundException("Book could not found by id: " + id));
    }

}
