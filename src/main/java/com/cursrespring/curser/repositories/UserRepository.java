package com.cursrespring.curser.repositories;

import com.cursrespring.curser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
