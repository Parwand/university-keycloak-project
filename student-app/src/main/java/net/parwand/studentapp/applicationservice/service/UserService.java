package net.parwand.studentapp.applicationservice.service;

import net.parwand.studentapp.applicationservice.repository.UserRepository;
import net.parwand.studentapp.domain.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
