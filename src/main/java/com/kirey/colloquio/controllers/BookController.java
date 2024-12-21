package com.kirey.colloquio.controllers;

import com.kirey.colloquio.models.BookDTO;
import com.kirey.colloquio.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public List<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
    }


}
