package com.example.bnta.bookshelf.repositories;

import com.example.bnta.bookshelf.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
}
