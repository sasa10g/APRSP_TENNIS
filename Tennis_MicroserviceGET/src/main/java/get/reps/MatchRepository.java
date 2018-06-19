package get.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Match;

public interface MatchRepository extends JpaRepository<Match, Integer> {
	Collection<Match> findByApprovedbyemployee (Boolean approvedbyemployee);
	Collection<Match> findByApprovedbyemployeeNull();
}