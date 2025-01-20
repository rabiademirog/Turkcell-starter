package com.turkcell.spring.starter.service;
import com.turkcell.spring.starter.entity.Category;
import java.util.Optional;

public interface CategoryService {
 Optional<Category> findById(Integer id);
}
