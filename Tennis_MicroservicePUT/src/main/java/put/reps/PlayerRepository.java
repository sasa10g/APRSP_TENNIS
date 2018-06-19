package put.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import put.jpa.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

}

