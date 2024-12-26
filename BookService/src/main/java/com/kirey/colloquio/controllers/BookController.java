package com.kirey.colloquio.controllers;

import com.kirey.colloquio.domain.Book;
import com.kirey.colloquio.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book){
        Book savedBook = bookService.createBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @Valid @RequestBody Book book) {
        try {
            bookService.updateBook(book,id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals("Book doesn't exist")) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT); // 409 Conflict
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable String id) {
       try {
           bookService.deleteBook(id);
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       } catch (IllegalArgumentException e) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
}
