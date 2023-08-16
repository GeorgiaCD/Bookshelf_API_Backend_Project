package com.example.bnta.bookshelf.components;

import com.example.bnta.bookshelf.models.*;
import com.example.bnta.bookshelf.repositories.AuthorRepository;
import com.example.bnta.bookshelf.repositories.BookRepository;
import com.example.bnta.bookshelf.repositories.BookshelfRepository;
import com.example.bnta.bookshelf.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import java.util.Arrays;

import static com.example.bnta.bookshelf.models.Genre.*;
import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookshelfRepository bookshelfRepository;


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

        Book bookSK1 = new Book("It", author3, HORROR, 1986, 1138);
        Book bookSK2 = new Book("The Shining", author3, HORROR, 1977, 447);
        Book bookJKR1 = new Book("Harry Potter and the Philosophers Stone", author4,  FANTASY, 1997, 223);
        Book bookJKR2 = new Book("Harry Potter and the Goblet of Fire", author4,  FANTASY, 2000, 640);
        Book bookHM1 = new Book("Norwegian Wood", author5, ROMANCE, 1987, 296);
        Book bookAC1 = new Book("Murder on the Orient Express", author6, THRILLER, 1934, 256);
        Book bookJA1 = new Book("Pride and Prejudice", author8, ROMANCE, 1813, 304);
        Book bookGGM1 = new Book("One Hundred Years of Solitude", author10, FANTASY, 1970, 417);
        Book bookTM1 = new Book("Paradise", author11, Genre.TRAVEL, 1998, 318);
        Book bookFSF1 = new Book("The Great Gatsby", author12, BUSINESS, 1925, 208);
        Book bookLT1 = new Book("War and Peace", author13, COMEDY, 1869, 1225);
        Book bookEHW1 = new Book("The Old Man and the Sea", author14, MEMOIR, 1952, 127);
        Book bookVW1 = new Book("Mrs Dalloway", author15, HISTORY, 1925, 176);
        Book bookSR1 = new Book("Normal People", author2, Genre.CONTEMPORARY, 2018, 273);
        Book bookSR2 = new Book("Conversations with Friends", author2, Genre.CONTEMPORARY, 2017, 304);
        Book bookSR3 = new Book("Beautiful World, Where Are You", author2, Genre.CONTEMPORARY, 2021, 368);
        Book bookSR4 = new Book("Color and Light", author2, Genre.POETRY, 2022, 192);
        Book bookEH2 = new Book("People We Meet on Vacation", author1, ROMANCE, 2021, 384);
        Book bookEH3 = new Book("A Million Junes", author1, FANTASY, 2017, 350);
        Book bookEH4 = new Book("When the Sky Fell on Splendor", author1, Genre.SCIENCE, 2019, 336);
        Book bookKI2 = new Book("The Remains of the Day", author9, Genre.LITERARY, 1989, 258);
        Book bookKI3 = new Book("Klara and the Sun", author9, Genre.SCIENCE, 2021, 320);
        Book bookKI4 = new Book("An Artist of the Floating World", author9, Genre.HISTORY, 1986, 206);
        Book bookEH1 = new Book("Beach Read", author1, Genre.TECHNOLOGY, 2020, 384);
        Book bookGO1 = new Book("1984", author7, Genre.DYSTOPIAN, 1949, 328);
        Book bookKI1 = new Book("Never Let Me Go", author9, Genre.SCIENCE, 2005, 288);

        bookRepository.saveAll(Arrays.asList(
                bookSK1,
                bookSK2,
                bookJKR1,
                bookJKR2,
                bookHM1,
                bookAC1,
                bookJA1,
                bookGGM1,
                bookTM1,
                bookFSF1,
                bookLT1,
                bookEHW1,
                bookVW1,
                bookSR2,
                bookSR3,
                bookEH2,
                bookEH3,
                bookEH4,
                bookKI2,
                bookKI3,
                bookKI4,
                bookEH1,
                bookSR1,
                bookGO1,
                bookKI1
        ));


        User user1 = new User("Kevin");
        User user2 = new User("Georgia");
        User user3 = new User("Rohaib");
        User user4 = new User("Francesca");
        User user5 = new User("Zsolt");
        User user6 = new User("Colin");
        User user7 = new User("Anna");
        User user8 = new User("Phil");
        User user9 = new User("Richard");
        User user10 = new User("Ed");

        userRepository.saveAll(Arrays.asList(
                user1,
                user2,
                user3,
                user4,
                user5,
                user6,
                user7,
                user8,
                user9,
                user10
        ));


        Bookshelf bookshelf1 = new Bookshelf(user1, bookSR1);
        Bookshelf bookshelf2 = new Bookshelf(user1, bookKI4);
        Bookshelf bookshelf3 = new Bookshelf(user1, bookEH1);
        Bookshelf bookshelf4 = new Bookshelf(user2, bookKI3);
        Bookshelf bookshelf5 = new Bookshelf(user2, bookKI4);
        Bookshelf bookshelf6 = new Bookshelf(user3, bookKI2);
        Bookshelf bookshelf7 = new Bookshelf(user4, bookTM1);
        Bookshelf bookshelf8 = new Bookshelf(user4, bookFSF1);
        Bookshelf bookshelf9 = new Bookshelf(user5, bookEHW1);
        Bookshelf bookshelf10 = new Bookshelf(user6, bookKI2);
        Bookshelf bookshelf11 = new Bookshelf(user7, bookJKR2);
        Bookshelf bookshelf12 = new Bookshelf(user8, bookJKR2);
        Bookshelf bookshelf13 = new Bookshelf(user9, bookSK2);
        Bookshelf bookshelf14 = new Bookshelf(user10, bookSK1);
        Bookshelf bookshelf15 = new Bookshelf(user5, bookKI2);
        Bookshelf bookshelf16 = new Bookshelf(user5, bookHM1);
        Bookshelf bookshelf17 = new Bookshelf(user7, bookKI2);
        Bookshelf bookshelf18 = new Bookshelf(user6, bookAC1);
        Bookshelf bookshelf19 = new Bookshelf(user7, bookKI2);
        Bookshelf bookshelf20 = new Bookshelf(user5, bookGO1);

        bookshelfRepository.saveAll(Arrays.asList(
                bookshelf1,
                bookshelf2,
                bookshelf3,
                bookshelf4,
                bookshelf5,
                bookshelf6,
                bookshelf7,
                bookshelf8,
                bookshelf9,
                bookshelf10,
                bookshelf11,
                bookshelf12,
                bookshelf13,
                bookshelf14,
                bookshelf15,
                bookshelf16,
                bookshelf17,
                bookshelf18,
                bookshelf19,
                bookshelf20
        ));


    }





}
