package com.turkcell.spring.starter.service;
import com.turkcell.spring.starter.dto.product.CreateProductDto;
import com.turkcell.spring.starter.dto.product.ProductListingDto;
import com.turkcell.spring.starter.dto.product.UpdateProductDto;
import com.turkcell.spring.starter.entity.Category;
import com.turkcell.spring.starter.entity.Product;
import com.turkcell.spring.starter.repository.ProductRepository;
import com.turkcell.spring.starter.rules.CategoryBusinessRules;
import com.turkcell.spring.starter.util.exception.type.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final CategoryBusinessRules categoryBusinessRules;
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, CategoryBusinessRules categoryBusinessRules) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.categoryBusinessRules = categoryBusinessRules;
    }

    @Override
    public void add(CreateProductDto createProductDto) {
        categoryBusinessRules.categoryMustExist(createProductDto.getCategoryId());


        Category category = categoryService
                .findById(createProductDto.getCategoryId())
                .orElse(null);

        Product productWithSameName = productRepository
                .findByName(createProductDto.getName())
                .orElse(null);

        if(productWithSameName != null)
            throw new BusinessException("Product already exists");


        Product product = new Product();
        product.setName(createProductDto.getName());
        product.setStock(createProductDto.getStock());
        product.setUnitPrice(createProductDto.getUnitPrice());
        product.setCategory(category);

        productRepository.save(product);
    }

    @Override
    public void update(UpdateProductDto updateProductDto) {
        categoryBusinessRules.categoryMustExist(updateProductDto.getCategoryId());


        Category category = categoryService
                .findById(updateProductDto.getCategoryId())
                .orElse(null);

        Product productWithSameName = productRepository
                .findByNameIsAndIdIsNot(updateProductDto.getName(), updateProductDto.getId())
                .orElse(null);

        if(productWithSameName != null)
            throw new BusinessException("Product already exists");

        Product productToUpdate = productRepository.findById(updateProductDto.getId()).orElseThrow(() -> new RuntimeException("Product not found"));
        productToUpdate.setName(updateProductDto.getName());
        productToUpdate.setStock(updateProductDto.getStock());
        productToUpdate.setUnitPrice(updateProductDto.getUnitPrice());
        productToUpdate.setCategory(category);
        productRepository.save(productToUpdate);
    }

    @Override
    public List<ProductListingDto> getAll() {
        List<ProductListingDto> productListingDtos = productRepository
                .findAll()
                .stream()
                .map((product) -> new ProductListingDto(product.getId(), product.getName()))
                .toList();

        return productListingDtos;
    }
}

