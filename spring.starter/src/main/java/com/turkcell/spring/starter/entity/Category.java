package com.turkcell.spring.starter.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="categories")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    //Liste olacak.Çünkü bir ürünün bir kategorisi vardır
    //Bir kategorinin birden çok ürünü vardır.
    //{Bu class}to{DiğerClass}
    //mappedBy = diğer entityde bu entity'i temsil eden değişken
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;


}
