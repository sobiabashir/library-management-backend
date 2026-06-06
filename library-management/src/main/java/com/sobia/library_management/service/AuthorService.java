package com.sobia.library_management.service;

import com.sobia.library_management.dto.request.AuthorRequestDTO;
import com.sobia.library_management.dto.response.AuthorResponseDTO;
import com.sobia.library_management.entity.Author;
import com.sobia.library_management.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // GET ALL
    public List<AuthorResponseDTO> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public AuthorResponseDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
        return convertToDTO(author);
    }

    // CREATE
    public AuthorResponseDTO createAuthor(AuthorRequestDTO requestDTO) {
        Author author = new Author();
        author.setFirstName(requestDTO.getFirstName());
        author.setLastName(requestDTO.getLastName());
        author.setEmail(requestDTO.getEmail());
        Author saved = authorRepository.save(author);
        return convertToDTO(saved);
    }

    // UPDATE
    public AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO requestDTO) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
        author.setFirstName(requestDTO.getFirstName());
        author.setLastName(requestDTO.getLastName());
        author.setEmail(requestDTO.getEmail());
        Author updated = authorRepository.save(author);
        return convertToDTO(updated);
    }

    // DELETE
    public void deleteAuthor(Long id) {
        authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
        authorRepository.deleteById(id);
    }

    // CONVERT Entity → DTO
    private AuthorResponseDTO convertToDTO(Author author) {
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setId(author.getId());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLastName());
        dto.setEmail(author.getEmail());
        return dto;
    }
}
