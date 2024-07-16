package betplay.app.Player.application.port.out;

import java.util.Optional;

import betplay.app.Player.domain.Player;

/**
 * PlayerRepositoryPort
 */
public interface PlayerRepositoryPort {
    Optional<Player> findById(Long id);
    
}