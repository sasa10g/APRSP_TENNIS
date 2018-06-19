package get.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Courttype;

public interface CourttypeRepository extends JpaRepository<Courttype, Integer> {
	Collection<Courttype> findByCourttypeContainingIgnoreCase (String courttype);
}