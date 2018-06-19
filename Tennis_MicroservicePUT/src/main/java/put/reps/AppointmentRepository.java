package put.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import put.jpa.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

}

