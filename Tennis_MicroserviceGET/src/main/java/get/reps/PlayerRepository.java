package get.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	Collection<Player> findByPlayerlastnameContainingIgnoreCase (String playerlastname);
}