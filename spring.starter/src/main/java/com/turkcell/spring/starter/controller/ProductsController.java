package com.turkcell.spring.starter.controller;
//Endpoint -> İstemci ve Sunucunun birleştiği nokta. Her bir endpoints farklı bir schemaya sahip.
//Schema -> HTTP isteğinin tüm yapısı.

import com.turkcell.spring.starter.dto.product.CreateProductDto;
import com.turkcell.spring.starter.dto.product.ProductListingDto;
import com.turkcell.spring.starter.dto.product.UpdateProductDto;
import com.turkcell.spring.starter.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController()
@RequestMapping("/api/v1/products")
public class ProductsController
{
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void add(@RequestBody @Valid CreateProductDto createProductDto)
    {
        this.productService.add(createProductDto);
    }

    @GetMapping
    public List<ProductListingDto> getAll() {
        return this.productService.getAll();
    }

    @PutMapping
    public void update(@RequestBody UpdateProductDto updateProductDto)
    {
        this.productService.update(updateProductDto);
    }
}


//Basit veriler -> metinsel -> Query String, Path Variable (URL üzerinden)
//Kompleks veriler ->Class -> Body

//@RequestParam -> Query String'den okumak için
//@PathVariable -> Path
//Spring Boot




//private final ProductRepository productRepository;
//2 get , 1 post, 1 put, 1 delete, 1 patch
//Her mappingin en az 1 özelliği ile diğerlerinden ayrılması

//    @GetMapping("hello/{name}") //HTTP METHODS -> GET(örn ürün listeleme),POST(ürün ekleme),PUT(Güncelleme),DELETE
//    public String hello(@PathVariable String name){
//        return "hello " +name ;
//    }
//    //http://localhost:8080/api/v1/products/hello/halit
//
//    @GetMapping("")
//    public String goodbye(@RequestParam String name)
//    {
//        return "goodbye " +name ;
//    }
//    //http://localhost:8080/api/v1/products?name=halit
//
//    @GetMapping("turkcell")
//    public String turkcell(){
//        return "turkcell";
//    }
//    //http://localhost:8080/api/v1/products/turkcell
//
//    @PostMapping
//    public Product addProduct(@RequestBody Product product){
//        //SQL
//        //Veritabanına gönder
//        //...
//        //SOLID
//
//        product.setId(1);
//        return product;
//    }

//    private ProductService productService;
//
//    //DI -> Dependency Injection Pattern
//    public ProductsController(ProductService productService, ProductRepository productRepository) {
//        this.productService = productService;
//        this.productRepository = productRepository;
//    }
//
//    @GetMapping()
//        public List<Product> getAll(){
//          return productService.getAll();
//        }
//
////    @GetMapping("{name}")
////    public Product getByName(@RequestParam("name") String name){
////        return productRepository.getByName(name);
////    }
//
//    @GetMapping("name-price")
//    public List<Product> getByNameAndPrice(@RequestParam("name") String name, @RequestParam("price") BigDecimal price){
//     return productService.getByNameAndPrice(name, price);
//    }
//
//     @GetMapping("{id}")
//     public Product getById(@PathVariable int id){
//       return productService.getById(id);
//     }
//
//    @PostMapping()
//    public Product add(@RequestBody @Valid Product product){
//        return productService.add(product);
//    }
//
//    //Ödev
//    @DeleteMapping("{id}")
//    public Product delete(@PathVariable int id){
//     return productService.delete(id);
//    }
//
//    @PutMapping("{id}")
//    public Product update(@PathVariable int id,@RequestBody Product product){
//        return productService.update(id,product);
//    }
