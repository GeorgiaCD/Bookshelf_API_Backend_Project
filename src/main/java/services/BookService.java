package services;

import models.Book;
import models.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BookRepository;

import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository;

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
                                bookDTO.getAuthorId(), //method to get author from id
                                bookDTO.getGenreId(),  // method to get genre from id
                                bookDTO.getYearPublished(),
                                bookDTO.getNumberOfPages());
        bookRepository.save(newBook);
    }

    // update book
//        public Book updateBook(Book book, Long id){
//        bookRepository.
//    }


}
