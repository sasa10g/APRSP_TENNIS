package put.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import put.jpa.Appointment;
import put.jpa.Court;
import put.jpa.Courttype;
import put.jpa.Employee;
import put.jpa.Game;
import put.jpa.Match;
import put.jpa.Player;
import put.jpa.Rank;

import put.reps.AppointmentRepository;
import put.reps.CourtRepository;
import put.reps.CourttypeRepository;
import put.reps.EmployeeRepository;
import put.reps.GameRepository;
import put.reps.MatchRepository;
import put.reps.PlayerRepository;
import put.reps.RankRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class PutRestController {

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

	@ApiOperation(value = "Azuriranje termina u bazi podataka")
	@PutMapping("appointment")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment){
		if(!appointmentRepository.existsById(appointment.getAppointmentid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		appointmentRepository.save(appointment);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Court//

	@ApiOperation(value = "Azuriranje terena u bazi podataka")
	@PutMapping("court")
	public ResponseEntity<Court> updateCourt(@RequestBody Court court) {
		if (!courtRepository.existsById(court.getCourtid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		courtRepository.save(court);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// CourtType//

	@ApiOperation(value = "Azuriranje tipa terena u bazi podataka")
	@PutMapping("courttype")
	public ResponseEntity<Courttype> updateCourttype(@RequestBody Courttype courttype) {
		if (!courttypeRepository.existsById(courttype.getCourttypeid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		courttypeRepository.save(courttype);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// Employee//

	@ApiOperation(value = "Azuriranje zaposlenog u bazi podataka")
	@PutMapping("employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		if (!employeeRepository.existsById(employee.getEmployeeid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		employeeRepository.save(employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// Game//

	@ApiOperation(value = "Azuriranje game-a u bazi podataka")
	@PutMapping("game")
	public ResponseEntity<Game> updateGame(@RequestBody Game game) {
		if (!gameRepository.existsById(game.getGameid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		gameRepository.save(game);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// Match//

	@ApiOperation(value = "Azuriranje meca u bazi podataka")
	@PutMapping("match")
	public ResponseEntity<Match> updateMatch(@RequestBody Match match) {
		if (!matchRepository.existsById(match.getMatchid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		matchRepository.save(match);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// Player//

	@ApiOperation(value = "Azuriranje igraca u bazi podataka")
	@PutMapping("player")
	public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
		if (!playerRepository.existsById(player.getPlayerid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		playerRepository.save(player);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// Rank//

	@ApiOperation(value = "Azuriranje ranka u bazi podataka")
	@PutMapping("rank")
	public ResponseEntity<Rank> updateRank(@RequestBody Rank rank) {
		if (!rankRepository.existsById(rank.getRankid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		rankRepository.save(rank);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}