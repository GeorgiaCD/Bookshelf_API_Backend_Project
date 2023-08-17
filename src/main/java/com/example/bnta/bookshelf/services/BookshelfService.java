package com.example.bnta.bookshelf.services;

import com.example.bnta.bookshelf.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bnta.bookshelf.repositories.BookRepository;
import com.example.bnta.bookshelf.repositories.BookshelfRepository;
import com.example.bnta.bookshelf.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookshelfService {

    @Autowired
    BookshelfRepository bookshelfRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    public
    Bookshelf addToBookshelf(BookshelfDTO bookshelfDTO){
        Bookshelf bookshelf = new Bookshelf(
                userRepository.findById(bookshelfDTO.getUserId()).get(),
                bookRepository.findById(bookshelfDTO.getBookId()).get()
//                Status.WANT_TO_READ
        );
        bookshelfRepository.save(bookshelf);
        return bookshelf;
    }

//    public Bookshelf updateBookshelf(BookshelfDTO bookshelfDTO, Long id){
//        Status status = Status.valueOf(bookshelfDTO.getStatus().toUpperCase());
//        Bookshelf bookshelf = new Bookshelf(
//        userRepository.findById(bookshelfDTO.getUserId()).get(),
//                bookRepository.findById(bookshelfDTO.getBookId()).get(),
//                status);
//        bookshelfRepository.save(bookshelf);
//        return bookshelf;
//    }

    public Bookshelf updateStatus(StatusDTO statusDTO, Long id){
        Bookshelf bookshelf = bookshelfRepository.findById(id).get();
        bookshelf.setStatus(statusDTO.getStatus());
        bookshelfRepository.save(bookshelf);
        return bookshelf;
    }

    public Bookshelf updateBookshelf(BookshelfDTO bookshelfDTO, Long id){
        Bookshelf bookshelfToUpdate = bookshelfRepository.findById(id).get();
        bookshelfToUpdate.setBook(bookRepository.findById(bookshelfDTO.getBookId()).get());
        bookshelfToUpdate.setUser(userRepository.findById(bookshelfDTO.getUserId()).get());
        bookshelfRepository.save(bookshelfToUpdate);
        return bookshelfToUpdate;
    }

    public Bookshelf deleteBookFromBookshelf(Long id){
        Bookshelf bookshelf = bookshelfRepository.findById(id).get();
        bookshelfRepository.deleteById(id);
        return bookshelf;
    }

    public List<UserBookshelfDTO> findBookshelfById(Long userId){
        List<Bookshelf> bookshelf = bookshelfRepository.findByUserId(userId);
        List<UserBookshelfDTO> simpleBookshelf = new ArrayList<>();
        UserBookshelfDTO userBookshelf;
        for(Bookshelf currentBookshelf : bookshelf){
            userBookshelf = new UserBookshelfDTO(currentBookshelf.getBook(),currentBookshelf.getStatus(), currentBookshelf.getRating());
            simpleBookshelf.add(userBookshelf);
        }
        return simpleBookshelf;
    }

//    public List<Bookshelf> findBookshelfById(Long userId){
//        List<Bookshelf> bookshelf = bookshelfRepository.findByUserId(userId);
//        return bookshelf;
//    }


    public Bookshelf updateRating(RatingDTO ratingDTO, Long id){
        Bookshelf bookshelf = bookshelfRepository.findById(id).get();
        bookshelf.setRating(ratingDTO.getRating());
        bookshelfRepository.save(bookshelf);
        return bookshelf;
    }

//    public List<Bookshelf> getByStatus(Status status){
//        return bookshelfRepository.findByStatus(status);
//    }

    public List<Bookshelf> getStatusByUser(Status status, Long userId){
        List<Bookshelf> bookshelf = bookshelfRepository.findByUserId(userId);
        List<Bookshelf> filteredBookshelf = new ArrayList<>();
        for(Bookshelf filterBookshelf : bookshelf){
            if(filterBookshelf.getStatus() == status){
                filteredBookshelf.add(filterBookshelf);
            }
        }
        return filteredBookshelf;
    }
}
