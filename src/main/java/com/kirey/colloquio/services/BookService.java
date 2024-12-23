package com.kirey.colloquio.services;

import com.kirey.colloquio.domain.Book;
import com.kirey.colloquio.repositories.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    public List<Book> getAllBooks() {
        List<Book> books;
        books = bookRepository.findAll();
        return books;
    }
    public Book deleteBook(String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
            return book.get(); // Restituisce il libro eliminato
        } else {
            return null; // Restituisce null se il libro non è stato trovato
        }
    }
}
