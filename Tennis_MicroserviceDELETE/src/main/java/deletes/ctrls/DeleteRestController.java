package deletes.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import deletes.jpa.Appointment;
import deletes.jpa.Court;
import deletes.jpa.Courttype;
import deletes.jpa.Employee;
import deletes.jpa.Game;
import deletes.jpa.Match;
import deletes.jpa.Player;
import deletes.jpa.Rank;
import deletes.reps.AppointmentRepository;
import deletes.reps.CourtRepository;
import deletes.reps.CourttypeRepository;
import deletes.reps.EmployeeRepository;
import deletes.reps.GameRepository;
import deletes.reps.MatchRepository;
import deletes.reps.PlayerRepository;
import deletes.reps.RankRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class DeleteRestController {
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private CourtRepository courtRepository;

	@Autowired
	private CourttypeRepository courttypeRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private MatchRepository matchRepository;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private RankRepository rankRepository;
	
	// Appointment//
	
	@ApiOperation(value = "Brisanje termina iz baze podataka")
	@DeleteMapping("appointment/{id}")
	public ResponseEntity<Appointment> deleteAppointment(@PathVariable ("id") Integer id){
		if(!appointmentRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		appointmentRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Court//
	
	@ApiOperation(value = "Brisanje terena iz baze podataka")
	@DeleteMapping("court/{id}")
	public ResponseEntity<Court> deleteCourt(@PathVariable ("id") Integer id){
		if(!courtRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		courtRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
		
		// CourtType//
		
	@ApiOperation(value = "Brisanje tipa terena iz baze podataka")
	@DeleteMapping("courttype/{id}")
	public ResponseEntity<Courttype> deleteCourttype(@PathVariable ("id") Integer id){
		if(!courttypeRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		courttypeRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
		
		// Employee//
		
	@ApiOperation(value = "Brisanje zaposlenog iz baze podataka")
	@DeleteMapping("employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable ("id") Integer id){
		if(!employeeRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		employeeRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
		
		// Game//
		
	@ApiOperation(value = "Brisanje game-a iz baze podataka")
	@DeleteMapping("game/{id}")
	public ResponseEntity<Game> deleteGame(@PathVariable ("id") Integer id){
		if(!gameRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		gameRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
		
		// Match//
		
	@ApiOperation(value = "Brisanje meca iz baze podataka")
	@DeleteMapping("match/{id}")
	public ResponseEntity<Match> deleteMatch(@PathVariable ("id") Integer id){
		if(!matchRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		matchRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
		
		// Player//
		
	@ApiOperation(value = "Brisanje igraca iz baze podataka")
	@DeleteMapping("player/{id}")
	public ResponseEntity<Player> deletePlayer(@PathVariable ("id") Integer id){
		if(!playerRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		playerRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
		
		// Rank//
		
	@ApiOperation(value = "Brisanje ranka iz baze podataka")
	@DeleteMapping("rank/{id}")
	public ResponseEntity<Rank> deleteRank(@PathVariable ("id") Integer id){
		if(!rankRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		rankRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
