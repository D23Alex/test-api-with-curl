package com.d23alex.testapiwithcurl;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping("/api/product/all")
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/api/product/add")
    public Product addNewProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
