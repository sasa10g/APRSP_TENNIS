package post.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import post.jpa.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

}

