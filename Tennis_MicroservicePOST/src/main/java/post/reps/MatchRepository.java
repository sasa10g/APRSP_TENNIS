package post.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import post.jpa.Match;

public interface MatchRepository extends JpaRepository<Match, Integer>{

}

