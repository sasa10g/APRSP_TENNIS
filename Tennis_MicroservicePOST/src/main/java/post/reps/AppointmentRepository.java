package post.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import post.jpa.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

}

