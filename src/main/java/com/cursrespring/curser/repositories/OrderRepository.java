package com.cursrespring.curser.repositories;

import com.cursrespring.curser.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
