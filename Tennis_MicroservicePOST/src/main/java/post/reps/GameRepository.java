package post.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import post.jpa.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{

}

