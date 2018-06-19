package get.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Court;

public interface CourtRepository extends JpaRepository<Court, Integer> {
	Collection<Court> findByCourtaddressContainingIgnoreCase (String courtaddress);
}