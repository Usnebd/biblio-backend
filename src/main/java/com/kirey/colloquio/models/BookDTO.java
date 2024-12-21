package com.kirey.colloquio.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDTO {
    private String id;
    private String title;
    private String author;
    private String description;
    private String publishDate;
    private int price;
}
