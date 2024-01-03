package com.kh.springchap01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springchap01.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
