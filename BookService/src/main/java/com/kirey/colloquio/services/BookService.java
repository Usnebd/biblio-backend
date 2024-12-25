package com.kirey.colloquio.services;

import com.kirey.colloquio.domain.Book;
import com.kirey.colloquio.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    public List<Book> getAllBooks() {
        List<Book> books;
        books = bookRepository.findAll();
        return books;
    }
    public boolean deleteBookById(String id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true; // Eliminazione avvenuta con successo
        }
        return false; // Nessun record trovato con quell'ID
    }
}
