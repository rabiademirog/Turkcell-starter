package com.turkcell.spring.starter.repository;
import com.turkcell.spring.starter.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
