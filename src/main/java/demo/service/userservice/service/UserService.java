package demo.service.userservice.service;

import demo.service.userservice.entity.User;
import demo.service.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id) {
        userRepository.findUsersByFirstName("tset");
        return userRepository.getById(id);
    }

    public List<User> getAllUser() {


        List<User> all = userRepository.findAll();
        return all.stream().map(user -> {
            user.setLastName(user.getLastName().toUpperCase());
            return  user;
        }).collect(Collectors.toList());


    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User createUser(User user) {
        String fname =  user.getFirstName();
        user.setFirstName(fname.toUpperCase());
        return userRepository.save(user);
    }
    
    public User createUserAll(User user)
    {
    
    	User user1= this.userRepository.save(user);
    	
    	return user1;
    }
    public List<User> getAllUserlist() {


    	  List<User> list=(List<User>)this.userRepository.findAll();
          return list;
    }
}
