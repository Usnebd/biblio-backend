package com.kirey.colloquio.services;

import com.kirey.colloquio.domain.Book;
import com.kirey.colloquio.models.BookDTO;
import com.kirey.colloquio.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookList = new ArrayList<>();
        List<Book> books;
        books = bookRepository.findAll();
        for(Book book: books){
            bookList.add(bookMap(book));
        }
        return bookList;
    }
    public BookDTO bookMap(Book book){
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getDescription(), book.getPublishDate(), book.getPrice());
    }
}
