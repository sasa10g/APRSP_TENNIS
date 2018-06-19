package get.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Rank;

public interface RankRepository extends JpaRepository<Rank, Integer> {
	Collection<Rank> findByPosition (Integer position);
}