package get.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the appointment database table.
 * 
 */
@Entity
@NamedQuery(name="Appointment.findAll", query="SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="APPOINTMENT_APPOINTMENTID_GENERATOR", sequenceName="APPOINTMENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APPOINTMENT_APPOINTMENTID_GENERATOR")
	private Integer appointmentid;

	private Time appointmenttime;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="appointment")
	@JsonIgnore
	private List<Match> matches;

	public Appointment() {
	}

	public Integer getAppointmentid() {
		return this.appointmentid;
	}

	public void setAppointmentid(Integer appointmentid) {
		this.appointmentid = appointmentid;
	}

	public Time getAppointmenttime() {
		return this.appointmenttime;
	}

	public void setAppointmenttime(Time appointmenttime) {
		this.appointmenttime = appointmenttime;
	}

	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Match addMatch(Match match) {
		getMatches().add(match);
		match.setAppointment(this);

		return match;
	}

	public Match removeMatch(Match match) {
		getMatches().remove(match);
		match.setAppointment(null);

		return match;
	}

}