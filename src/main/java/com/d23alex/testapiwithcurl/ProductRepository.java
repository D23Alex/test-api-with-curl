package com.d23alex.testapiwithcurl;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    public List<Product> findAll();
}
