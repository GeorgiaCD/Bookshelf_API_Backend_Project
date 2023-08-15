package services;

import models.Author;
import models.Book;
import models.BookDTO;
import models.Bookshelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AuthorRepository;
import repositories.BookRepository;
import repositories.BookshelfRepository;

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
                                bookDTO.getAuthorId(), //method to get author from id
                                bookDTO.getGenreId(),  // method to get genre from id
                                bookDTO.getYearPublished(),
                                bookDTO.getNumberOfPages());
        bookRepository.save(newBook);
    }

//     update book
     public Book updateBook(BookDTO bookDTO, Long id){
        Book bookToUpdate = bookRepository.findById(id).get();
        bookToUpdate.setTitle(bookDTO.getTitle());
        bookToUpdate.setAuthor(authorService.getAuthorById(bookDTO.getAuthorId()));
        bookToUpdate.setGenre(bookDTO.getGenreId());
        bookToUpdate.setYear(bookDTO.getYearPublished());
        bookToUpdate.setNumberOfPages(bookDTO.getNumberOfPages());
        bookToUpdate.setBookshelf(new ArrayList<>());

        for(Long bookshelfId : bookDTO.getBookshelfIds()){
            Bookshelf bookshelf = bookshelfRepository.findById(bookshelfId).get();
            bookToUpdate.addBookshelf(bookshelf);
        }
        bookRepository.save(bookToUpdate);
        return bookToUpdate;
        }

    // delete
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

//    public void addEstate(Estate estate){
//        this.estates.add(estate);
//    }

}
