package com.kirey.colloquio.services;

import com.kirey.colloquio.domain.Book;

import java.util.List;

public interface BookService {
    public Book createBook(Book book);
    public List<Book> getAllBooks();
    public Book getBookById(String id);
    public void deleteBook(String id);
    public void updateBook(Book book, String id);
}
