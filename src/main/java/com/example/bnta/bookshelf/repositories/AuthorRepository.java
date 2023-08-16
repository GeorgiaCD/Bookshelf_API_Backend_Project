package com.example.bnta.bookshelf.repositories;

import com.example.bnta.bookshelf.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
