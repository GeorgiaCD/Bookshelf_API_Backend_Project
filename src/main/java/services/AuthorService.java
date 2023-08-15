package services;

import models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id){
        return authorRepository.findById(id).get();
    }

    public void saveAuthor(Author author){
        authorRepository.save(author);
    }

//    public Author updateAuthor(Author author, Long id){
//        authorRepository.
//    }

    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

//    public void getAuthorByName(String name){
//
//    }

}
