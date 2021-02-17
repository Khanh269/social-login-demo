package com.example.sociallogindemo.repository;

import com.example.sociallogindemo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByUserName(String userName);
    Users findByEmail(String email);
}
