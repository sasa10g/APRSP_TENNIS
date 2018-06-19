package post.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import post.jpa.Appointment;
import post.jpa.Court;
import post.jpa.Courttype;
import post.jpa.Employee;
import post.jpa.Game;
import post.jpa.Match;
import post.jpa.Player;
import post.jpa.Rank;

import post.reps.AppointmentRepository;
import post.reps.CourtRepository;
import post.reps.CourttypeRepository;
import post.reps.EmployeeRepository;
import post.reps.GameRepository;
import post.reps.MatchRepository;
import post.reps.PlayerRepository;
import post.reps.RankRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class PostRestController {
	
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
	
	@ApiOperation(value = "Unos novog termina u bazu podataka")
	@PostMapping("appointment")
	public ResponseEntity<Appointment> insertAppointment(@RequestBody Appointment appointment){
		if(appointmentRepository.existsById(appointment.getAppointmentid()))
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		appointmentRepository.save(appointment);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Court//
	
	@ApiOperation(value = "Unos novog terena u bazu podataka")
	@PostMapping("court")
	public ResponseEntity<Court> insertCourt(@RequestBody Court court){
		if(courtRepository.existsById(court.getCourtid()))
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		courtRepository.save(court);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// CourtType//
	
	@ApiOperation(value = "Unos novog tipa terena u bazu podataka")
	@PostMapping("courttype")
	public ResponseEntity<Courttype> insertCourttype(@RequestBody Courttype courttype){
		if(courttypeRepository.existsById(courttype.getCourttypeid()))
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		courttypeRepository.save(courttype);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Employee//
	
	@ApiOperation(value = "Unos novog zaposlenog u bazu podataka")
	@PostMapping("employee")
	public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee){
		if(employeeRepository.existsById(employee.getEmployeeid()))
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		employeeRepository.save(employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Game//
	
	@ApiOperation(value = "Unos novog game-a u bazu podataka")
	@PostMapping("game")
	public ResponseEntity<Game> insertGame(@RequestBody Game game){
		if(gameRepository.existsById(game.getGameid()))
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		gameRepository.save(game);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Match//
	
	@ApiOperation(value = "Unos novog meca u bazu podataka")
	@PostMapping("match")
	public ResponseEntity<Match> insertMatch(@RequestBody Match match){
		if(matchRepository.existsById(match.getMatchid()))
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		matchRepository.save(match);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Player//
	
	@ApiOperation(value = "Unos novog igraca u bazu podataka")
	@PostMapping("player")
	public ResponseEntity<Player> insertPlayer(@RequestBody Player player){
		if(playerRepository.existsById(player.getPlayerid()))
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		playerRepository.save(player);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Rank//
	
	@ApiOperation(value = "Unos nove pozicije ranka u bazu podataka")
	@PostMapping("rank")
	public ResponseEntity<Rank> insertRank(@RequestBody Rank rank){
		if(rankRepository.existsById(rank.getRankid()))
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		rankRepository.save(rank);
		return new ResponseEntity<>(HttpStatus.OK);
	}
		
}