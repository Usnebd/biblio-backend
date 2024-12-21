package com.kirey.colloquio.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String title;
    private String author;
    private String description;
    private String publishDate;
    private int price;
}
