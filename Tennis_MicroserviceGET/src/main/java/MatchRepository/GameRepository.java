package MatchRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}