package com.turkcell.spring.starter.rules;

import com.turkcell.spring.starter.repository.CategoryRepository;
import com.turkcell.spring.starter.util.exception.type.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class CategoryBusinessRules {
    private final CategoryRepository categoryRepository;

    public CategoryBusinessRules(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void categoryMustExist(Integer id)
    {
        categoryRepository.findById(id).orElseThrow(() -> new BusinessException("Category not found"));
    }
}