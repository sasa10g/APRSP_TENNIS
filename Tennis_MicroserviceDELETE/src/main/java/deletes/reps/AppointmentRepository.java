package deletes.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import deletes.jpa.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

}

