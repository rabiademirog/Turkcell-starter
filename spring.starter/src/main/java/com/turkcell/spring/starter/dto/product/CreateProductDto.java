package com.turkcell.spring.starter.dto.product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {
    @NotBlank(message = "İsim boş olamaz")
    @Length(min=3, message = "İsim 3 haneden büyük olmalıdır.")
    private String name;
    @Min(value = 0, message = "Fiyat 0'dan büyük olmak zorundadır.")
    private BigDecimal unitPrice;
    private int stock;
    private int categoryId;


}