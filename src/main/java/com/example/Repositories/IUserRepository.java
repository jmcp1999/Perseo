package com.example.Repositories;

import com.example.Models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByUsername(String username);
}
