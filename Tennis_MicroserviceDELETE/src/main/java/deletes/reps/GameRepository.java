package deletes.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import deletes.jpa.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{

}

