package put.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import put.jpa.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{

}

