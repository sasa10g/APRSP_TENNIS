package post.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import post.jpa.Court;

public interface CourtRepository extends JpaRepository<Court, Integer>{

}

