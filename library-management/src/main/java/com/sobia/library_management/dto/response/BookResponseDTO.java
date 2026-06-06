package com.sobia.library_management.dto.response;
import lombok.Data;

@Data
public class BookResponseDTO {

    private Long id;
    private String title;
    private String isbn;
    private int publishedYear;
    private int availableCopies;
    private String authorName;
    private String categoryName;
}
