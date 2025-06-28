package com.example.LibraryApplication.repository;

import com.example.LibraryApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
