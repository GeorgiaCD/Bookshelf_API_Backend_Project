package com.example.bnta.bookshelf.repositories;

import com.example.bnta.bookshelf.models.Bookshelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookshelfRepository extends JpaRepository <Bookshelf, Long>{
}
