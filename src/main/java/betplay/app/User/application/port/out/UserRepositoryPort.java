package betplay.app.User.application.port.out;

import java.util.List;
import java.util.Optional;

import betplay.app.User.domain.Users;

/**
 * UserRepositoryPort
 */
public interface UserRepositoryPort {
    Optional<Users> findById(Long id);
    List <Users> findAll();
    Users save(Users user);

    
}