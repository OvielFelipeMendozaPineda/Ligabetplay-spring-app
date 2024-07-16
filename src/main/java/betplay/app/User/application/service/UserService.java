package betplay.app.User.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betplay.app.User.application.port.in.IUserService;
import betplay.app.User.domain.Users;
import betplay.app.User.infrastructure.adapter.out.UserRepository;
import lombok.NoArgsConstructor;

/**
 * UserService
 */
@Service
@NoArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
       return userRepository.findAll();
    }

}