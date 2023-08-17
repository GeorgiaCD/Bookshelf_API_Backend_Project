package com.example.bnta.bookshelf.repositories;

import com.example.bnta.bookshelf.models.Book;
import com.example.bnta.bookshelf.models.Bookshelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, Long>{



}
