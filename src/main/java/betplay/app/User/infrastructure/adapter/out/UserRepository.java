package betplay.app.User.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import betplay.app.User.application.port.out.UserRepositoryPort;
import betplay.app.User.domain.Users;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long>, UserRepositoryPort{

    
}