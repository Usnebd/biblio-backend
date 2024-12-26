    package com.kirey.colloquio.domain;

    import jakarta.validation.constraints.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.springframework.data.annotation.Id;
    import org.springframework.data.mongodb.core.index.Indexed;
    import org.springframework.data.mongodb.core.mapping.Document;

    @Document(collection = "book") // Collezione "book" nel DB
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Book {
        @Id
        private String id;
        @Indexed(unique = true)
        @Size(max = 50, message = "Title cannot exceed 50 characters")
        @NotBlank(message = "Title cannot be blank")
        private String title;
        @Size(max = 50, message = "Author cannot exceed 50 characters")
        @NotBlank(message = "Author cannot be blank")
        private String author;
        @Size(max = 200, message = "Description cannot exceed 100 characters")
        @NotBlank(message = "Description cannot be blank")
        private String description;
        @Min(value = 0, message = "PublishYear must be at least 0")
        private int publishYear;
        @Min(value = 0, message = "Price must be at least 0")
        @Max(value = 1000, message = "Price cannot exceed 100")
        private int price;

    }