package com.turkcell.spring.starter.service;

import com.turkcell.spring.starter.dto.product.CreateProductDto;
import com.turkcell.spring.starter.dto.product.ProductListingDto;
import com.turkcell.spring.starter.dto.product.UpdateProductDto;

import java.util.List;

public interface ProductService
{
    void add(CreateProductDto createProductDto);
    void update(UpdateProductDto updateProductDto);
    List<ProductListingDto> getAll();
}



