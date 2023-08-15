package services;

import models.Bookshelf;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BookRepository;
import repositories.BookshelfRepository;
import repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(String name){
        User user = new User(name);
        userRepository.save(user);
        return user;
    }

    public List<Bookshelf> getBookshelfByUserId(Long id){
        List<Bookshelf> bookshelves = userRepository.findById(id).get().getBookshelf();
        return bookshelves;
    }

    public User deleteUser(Long id){
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return user;
    }
}
