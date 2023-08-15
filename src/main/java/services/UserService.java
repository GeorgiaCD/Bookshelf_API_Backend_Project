package services;

import models.Bookshelf;
import models.User;
import models.UserDTO;
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

    @Autowired
    BookshelfRepository bookshelfRepository;

    public User addUser(String name){
        User user = new User(name);
        userRepository.save(user);
        return user;
    }

    public User getUserById(Long id){
        User user = userRepository.findById(id).get();
        return user;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User deleteUser(Long id){
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return user;
    }

    public User updateUser(UserDTO userDTO, Long id){
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setUserName(userDTO.getUsername());
        for(Long bookshelvesID : userDTO.getBookshelvesIDs()){
            Bookshelf bookshelf = bookshelfRepository.findById(bookshelvesID).get();
            userToUpdate.addBookshelf(bookshelf);
        }
        userRepository.save(userToUpdate);
        return userToUpdate;
    }
}
