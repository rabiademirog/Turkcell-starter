package com.turkcell.spring.starter.dto.product;

import lombok.Data;


@Data
public class ProductListingDto
{
    private int id;
    private String name;

    public ProductListingDto(int id, String name) {
        this.id = id;
        this.name = name;
    }


}