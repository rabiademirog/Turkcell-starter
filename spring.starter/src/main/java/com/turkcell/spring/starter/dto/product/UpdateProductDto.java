package com.turkcell.spring.starter.dto.product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductDto {
    private Integer id;
    private String name;
    private BigDecimal unitPrice;
    private int stock;
    private int categoryId;


}
