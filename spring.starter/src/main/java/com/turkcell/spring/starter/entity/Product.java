package com.turkcell.spring.starter.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //orm bu classı tanıyo
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id") //eğer isimler birebir aynı ise bu anatasyon opsiyeneldir.
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="unit_price")
    private BigDecimal unitPrice; // numeric => BigDecimal

    @Column(name="stock")
    private int stock;


   //İlişkiler temsil edilirken FK alan temsil edilmez.
    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;


}
