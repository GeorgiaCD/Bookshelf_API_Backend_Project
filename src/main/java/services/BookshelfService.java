package services;

import models.Bookshelf;
import models.BookshelfDTO;
import models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BookRepository;
import repositories.BookshelfRepository;
import repositories.UserRepository;

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
                bookRepository.findById(bookshelfDTO.getBookId()).get(),
                Status.WANT_TO_READ
        );
        bookshelfRepository.save(bookshelf);
        return bookshelf;

    }

    public Bookshelf updateBookshelf(BookshelfDTO bookshelfDTO, Long id){
        Status status = Status.valueOf(bookshelfDTO.getStatus().toUpperCase());
        Bookshelf bookshelf = new Bookshelf(
        userRepository.findById(bookshelfDTO.getUserId()).get(),
                bookRepository.findById(bookshelfDTO.getBookId()).get(),
                status);
        bookshelfRepository.save(bookshelf);
        return bookshelf;
    }

    public Bookshelf deleteBookFromBookshelf(Long id){
        Bookshelf bookshelf = bookshelfRepository.findById(id).get();
        bookshelfRepository.deleteById(id);
        return bookshelf;
    }

}
