package betplay.app.User.application.port.in;

import java.util.List;
import java.util.Optional;
import betplay.app.User.domain.Users;

/**
 * UserService
 */
public interface IUserService {
    Optional<Users> getUserById(Long id);
    Users saveUser(Users user);
    List <Users> getAllUsers();
}