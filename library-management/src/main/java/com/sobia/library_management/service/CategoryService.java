package com.sobia.library_management.service;

import com.sobia.library_management.dto.request.CategoryRequestDTO;
import com.sobia.library_management.dto.response.CategoryResponseDTO;
import com.sobia.library_management.entity.Category;
import com.sobia.library_management.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return convertToDTO(category);
    }

    public CategoryResponseDTO createCategory(CategoryRequestDTO requestDTO) {
        Category category = new Category();
        category.setName(requestDTO.getName());
        Category saved = categoryRepository.save(category);
        return convertToDTO(saved);
    }

    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO requestDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        category.setName(requestDTO.getName());
        Category updated = categoryRepository.save(category);
        return convertToDTO(updated);
    }

    public void deleteCategory(Long id) {
        categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        categoryRepository.deleteById(id);
    }

    private CategoryResponseDTO convertToDTO(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }
}