package com.example.bnta.bookshelf.services;

import com.example.bnta.bookshelf.models.Author;
import com.example.bnta.bookshelf.models.AuthorDTO;
import com.example.bnta.bookshelf.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bnta.bookshelf.repositories.AuthorRepository;
import com.example.bnta.bookshelf.repositories.BookRepository;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id){
        return authorRepository.findById(id).get();
    }

    public void saveAuthor(AuthorDTO authorDTO){
        Author newAuthor = new Author(authorDTO.getName());
        authorRepository.save(newAuthor);
    }

    public Author updateAuthor(AuthorDTO authorDTO, Long id){
        Author authorToUpdate = authorRepository.findById(id).get();
        authorToUpdate.setName(authorDTO.getName());

//        for(Long bookId : authorDTO.getBookIds()){
//            Book book = bookRepository.findById(bookId).get();
//            book.setAuthor(authorToUpdate);
//            bookRepository.save(book);
//        }

        authorRepository.save(authorToUpdate);
        return authorToUpdate;
    }

    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

    public List<Author> getAuthorByName(String name){
        List<Author> author = authorRepository.findAuthorByName(name);
        return author;
    }

}
