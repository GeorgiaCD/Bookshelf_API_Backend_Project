package com.example.bnta.bookshelf.services;

import com.example.bnta.bookshelf.models.Book;
import com.example.bnta.bookshelf.models.BookDTO;
import com.example.bnta.bookshelf.models.Bookshelf;
import com.example.bnta.bookshelf.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bnta.bookshelf.repositories.BookRepository;
import com.example.bnta.bookshelf.repositories.BookshelfRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookshelfRepository bookshelfRepository;


    @Autowired
    AuthorService authorService;


    // get all books
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    // find book by id
    public Book findBookById(Long id){
        return bookRepository.findById(id).get();
    }

    // save book
    // need to get objects from ids
    public void saveBook(BookDTO bookDTO){
        Book newBook = new Book(bookDTO.getTitle(),
                                authorService.getAuthorById(bookDTO.getAuthorId()), //method to get author from id
                                bookDTO.getGenre(),
                                bookDTO.getYear(),
                                bookDTO.getNumberOfPages());
        bookRepository.save(newBook);
    }

//     update book
     public Book updateBook(BookDTO bookDTO, Long id){
        Book bookToUpdate = bookRepository.findById(id).get();
        bookToUpdate.setTitle(bookDTO.getTitle());
        bookToUpdate.setAuthor(authorService.getAuthorById(bookDTO.getAuthorId()));
        bookToUpdate.setGenre(bookDTO.getGenre());
        bookToUpdate.setYear(bookDTO.getYear());
        bookToUpdate.setNumberOfPages(bookDTO.getNumberOfPages());
//        bookToUpdate.setBookshelves(new ArrayList<>());
//
//        for(Long bookshelfId : bookDTO.getBookshelfIds()){
//            Bookshelf bookshelf = bookshelfRepository.findById(bookshelfId).get();
//            bookToUpdate.addBookshelf(bookshelf);
//        }
        bookRepository.save(bookToUpdate);
        return bookToUpdate;
        }

    // delete
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }


    // get all filtered books
    public List<Book> getByGenre(Genre genre){
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getByAuthorId(Long authorId){
        return bookRepository.findByAuthorId(authorId);
    }

    public List<Book> getByYear(int year){
        return bookRepository.findByYear(year);
    }

    public List<Book> getByLength(int length){
        return bookRepository.findByNumberOfPagesLessThan(length);
    }



}
