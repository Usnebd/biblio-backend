package com.kirey.colloquio.services;

import com.kirey.colloquio.domain.Book;
import com.kirey.colloquio.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> books;
        books = bookRepository.findAll();
        return books;
    }

    public Book createBook(Book book) {
        if (bookRepository.existsByTitle(book.getTitle())) {
            throw new IllegalArgumentException("Book already exists");
        }
        return bookRepository.save(book);
    }

    public void deleteBook(String id) {
        if (!bookRepository.existsById(id)){
            throw new IllegalArgumentException("Book doesn't exists");
        }
        bookRepository.deleteById(id);
    }

    public void updateBook(Book book, String id){
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book doesn't exist"));
        if (!existingBook.getId().equals(id) && book.getTitle().equals(existingBook.getTitle())){
            throw new IllegalArgumentException("Cannot have multiple books with same title");
        }
        bookRepository.save(book);
    }
}