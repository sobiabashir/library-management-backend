package com.sobia.library_management.service;

import com.sobia.library_management.dto.request.BookRequestDTO;
import com.sobia.library_management.dto.response.BookResponseDTO;
import com.sobia.library_management.entity.Author;
import com.sobia.library_management.entity.Book;
import com.sobia.library_management.entity.Category;
import com.sobia.library_management.repository.AuthorRepository;
import com.sobia.library_management.repository.BookRepository;
import com.sobia.library_management.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BookResponseDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        return convertToDTO(book);
    }

    public List<BookResponseDTO> searchByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<BookResponseDTO> getBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthorId(authorId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BookResponseDTO createBook(BookRequestDTO requestDTO) {
        Author author = authorRepository.findById(requestDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + requestDTO.getAuthorId()));
        Category category = categoryRepository.findById(requestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + requestDTO.getCategoryId()));

        Book book = new Book();
        book.setTitle(requestDTO.getTitle());
        book.setIsbn(requestDTO.getIsbn());
        book.setPublishedYear(requestDTO.getPublishedYear());
        book.setAvailableCopies(requestDTO.getAvailableCopies());
        book.setAuthor(author);
        book.setCategory(category);

        Book saved = bookRepository.save(book);
        return convertToDTO(saved);
    }

    public BookResponseDTO updateBook(Long id, BookRequestDTO requestDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        Author author = authorRepository.findById(requestDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + requestDTO.getAuthorId()));

        Category category = categoryRepository.findById(requestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + requestDTO.getCategoryId()));

        book.setTitle(requestDTO.getTitle());
        book.setIsbn(requestDTO.getIsbn());
        book.setPublishedYear(requestDTO.getPublishedYear());
        book.setAvailableCopies(requestDTO.getAvailableCopies());
        book.setAuthor(author);
        book.setCategory(category);

        Book updated = bookRepository.save(book);
        return convertToDTO(updated);
    }

    public void deleteBook(Long id) {
        bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        bookRepository.deleteById(id);
    }

    private BookResponseDTO convertToDTO(Book book) {
        BookResponseDTO dto = new BookResponseDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setIsbn(book.getIsbn());
        dto.setPublishedYear(book.getPublishedYear());
        dto.setAvailableCopies(book.getAvailableCopies());
        dto.setAuthorName(book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
        dto.setCategoryName(book.getCategory().getName());
        return dto;
    }
}