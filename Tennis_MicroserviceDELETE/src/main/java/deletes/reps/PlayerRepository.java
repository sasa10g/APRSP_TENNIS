package deletes.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import deletes.jpa.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

}

