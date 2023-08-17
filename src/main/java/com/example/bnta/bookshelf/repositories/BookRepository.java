package com.example.bnta.bookshelf.repositories;

import com.example.bnta.bookshelf.models.Author;
import com.example.bnta.bookshelf.models.Book;
import com.example.bnta.bookshelf.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, Long>{


    List<Book> findByGenre(Genre genre);
    List<Book> findByAuthorId(Long authorId);
    List<Book> findByYear(int year);
    List<Book> findByNumberOfPagesLessThan(int length);

}
