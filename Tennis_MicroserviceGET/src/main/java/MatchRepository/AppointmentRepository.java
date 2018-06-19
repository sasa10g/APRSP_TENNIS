package MatchRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}