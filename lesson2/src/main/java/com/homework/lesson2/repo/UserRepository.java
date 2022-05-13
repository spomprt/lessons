package com.homework.lesson2.repo;

import com.homework.lesson2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
