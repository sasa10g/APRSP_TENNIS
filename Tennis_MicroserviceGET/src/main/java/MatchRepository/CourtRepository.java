package MatchRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Court;

public interface CourtRepository extends JpaRepository<Court, Integer> {

}