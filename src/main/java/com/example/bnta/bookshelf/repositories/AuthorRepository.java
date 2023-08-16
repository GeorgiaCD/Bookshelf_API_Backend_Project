package com.example.bnta.bookshelf.repositories;

import com.example.bnta.bookshelf.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

   List<Author> findAuthorByName(String name);

}
