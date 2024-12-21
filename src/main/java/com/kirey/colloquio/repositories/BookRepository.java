package com.kirey.colloquio.repositories;


import com.kirey.colloquio.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
    }