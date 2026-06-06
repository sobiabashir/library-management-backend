package com.sobia.library_management.dto.request;
import lombok.Data;

@Data
public class BookRequestDTO {

    private String title;
    private String isbn;
    private int publishedYear;
    private int availableCopies;
    private Long authorId;
    private Long categoryId;
}
