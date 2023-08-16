package com.example.bnta.bookshelf.repositories;

import com.example.bnta.bookshelf.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Long>{
}
