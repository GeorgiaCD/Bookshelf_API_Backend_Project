package com.example.bnta.bookshelf.components;

import com.example.bnta.bookshelf.models.Author;
import com.example.bnta.bookshelf.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    AuthorRepository authorRepository;

    public DataLoader(){
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Author author1 = new Author("Emily Henry");
        Author author2 = new Author("Sally Rooney");
        Author author3 = new Author("Stephen King");
        Author author4 = new Author("J.K. Rowling");
        Author author5 = new Author("Haruki Murakami");
        Author author6 = new Author("Agatha Christie");
        Author author7 = new Author("George Orwell");
        Author author8 = new Author("Jane Austen");
        Author author9 = new Author("Kazuo Ishiguro");
        Author author10 = new Author("Gabriel García Márquez");
        Author author11 = new Author("Toni Morrison");
        Author author12 = new Author("F. Scott Fitzgerald");
        Author author13 = new Author("Leo Tolstoy");
        Author author14 = new Author("Ernest Hemingway");
        Author author15 = new Author("Virginia Woolf");

        authorRepository.saveAll(Arrays.asList(
        author1,
        author2,
        author3,
        author4,
        author5,
        author6,
        author7,
        author8,
        author9,
        author10,
        author11,
        author12,
        author13,
        author14,
        author15));
        
    }
}
