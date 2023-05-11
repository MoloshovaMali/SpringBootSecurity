package peaksoft.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.springboot.entity.User;
import peaksoft.springboot.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public List<User>getAllUsers(){
        return userRepository.findAll();
    }
    public void  addUser(User user){
        userRepository.save(user);
    }
    public  User getUserByName(String name){
        return userRepository.getUserByName(name);
    }
    public  void updateUser(Long id,User user){
        User user1=userRepository.findById(id).get();
        user1.setUserName(user.getUserName());
        user1.setLastName(user.getLastName());
        user1.setAge(user.getAge());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setRoles(user.getRoles());
        userRepository.save(user);
    }
    public    void deleteUser(User user){
        userRepository.delete(user);
    }
}

