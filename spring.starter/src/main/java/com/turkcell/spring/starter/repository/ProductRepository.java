package com.turkcell.spring.starter.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.spring.starter.entity.Product;
import java.util.Optional;

// DEPO
// Temel işlemleri yapabilen bir ürün deposu
//JpaRepository<...,...> hangi entity için, hangi primary key türü ile çalışacağını belirtiyoruz..


public interface ProductRepository extends JpaRepository<Product, Integer>
{
    Optional<Product> findByName(String name);
    Optional<Product> findByNameIsAndIdIsNot(String name, Integer id);
}


//    // 1- Derived Query Methods
//    // Avantaj => Basitlik, sql query yazma gereksinimi yok
//    // Dezavantaj => Uzun fonk. isimleri, kısıtlı manuel düzenleme. Fonksiyon ismi değiştirme zorunluluğu.
//    List<Product> findByNameStartingWithOrderByUnitPrice(String name);
//
//    // 2- JPQL -> SQL + JPA
//    @Query(value= "Select p from Product p where p.name LIKE %:name% and p.unitPrice = :price" ,nativeQuery = false)
//    //@Query("Select p from Product p where p.name= ?1 and p.unitPrice = ?2")
//    List<Product> search(String name, BigDecimal price);
//
//    // 3- SQL (native)
//    @Query(value = "Select * from products p where p.name LIKE %?1% and p.unit_price = ?2", nativeQuery = true)
//    List<Product> searchSql(String name, BigDecimal price);
//
//    @Query(value = "Select p from Product p JOIN p.category c where c.name LIKE %:categoryName%",nativeQuery = false)
//    List<Product> searchByCategory(String categoryName);
