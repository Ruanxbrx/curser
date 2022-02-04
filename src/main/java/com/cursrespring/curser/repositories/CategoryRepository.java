package com.cursrespring.curser.repositories;

import com.cursrespring.curser.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}