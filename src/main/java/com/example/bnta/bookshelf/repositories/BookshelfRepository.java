package com.example.bnta.bookshelf.repositories;

import com.example.bnta.bookshelf.models.Bookshelf;
import com.example.bnta.bookshelf.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookshelfRepository extends JpaRepository <Bookshelf, Long>{

    List<Bookshelf> findByUserId(Long userId);
//    List<Bookshelf> findByStatus(Status status);
}
