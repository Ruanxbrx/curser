package com.cursrespring.curser.repositories;

import com.cursrespring.curser.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}