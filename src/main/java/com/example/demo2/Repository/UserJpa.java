package com.example.demo2.Repository;

import com.example.demo2.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<User,Integer> {

}
