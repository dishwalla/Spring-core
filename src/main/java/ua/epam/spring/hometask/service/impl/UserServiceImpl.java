package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.dao.MapUserRepository;
import ua.epam.spring.hometask.dao.UserRepository;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.UserService;
import java.util.Collection;
/**
 * Created by dish on 01.10.17.
 */
public class UserServiceImpl implements UserService {
    
    private UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
    
    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }
    
    @Override
    public void remove(User user) {
        userRepository.remove(user);
    }
    
    @Override
    public User getById(Long id) {
       return userRepository.getById(id);
    }
    
    @Override
    public Collection<User> getAll() {
        return userRepository.getAll();
    }
}
