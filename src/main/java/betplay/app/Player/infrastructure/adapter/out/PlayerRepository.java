package betplay.app.Player.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

import betplay.app.Player.application.port.out.PlayerRepositoryPort;
import betplay.app.Player.domain.Player;

/**
 * PlayerRepositoryextends
 */
public interface PlayerRepository extends JpaRepository<Player, Long>, PlayerRepositoryPort {

    
}