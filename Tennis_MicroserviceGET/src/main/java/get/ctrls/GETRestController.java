package get.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import get.jpa.Appointment;
import get.jpa.Court;
import get.jpa.Courttype;
import get.jpa.Employee;
import get.jpa.Game;
import get.jpa.Match;
import get.jpa.Player;
import get.jpa.Rank;

import get.reps.AppointmentRepository;
import get.reps.CourtRepository;
import get.reps.CourttypeRepository;
import get.reps.EmployeeRepository;
import get.reps.GameRepository;
import get.reps.MatchRepository;
import get.reps.PlayerRepository;
import get.reps.RankRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class GETRestController {

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

	@ApiOperation(value = "Vraca kolekciju svih termina iz baze podataka")
	@GetMapping("appointment")
	public Collection<Appointment> getAppointments() {
		return appointmentRepository.findAll();
	}

	@ApiOperation(value = "Vraca termin iz baze podataka ciji je id zadata vrednost")
	// prosledjnena kao path varijabla")
	@GetMapping("appointment/{id}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable("id") Integer id) {
		Appointment appointment = appointmentRepository.getOne(id);
		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}

	// Court//

	@ApiOperation(value = "Vraca kolekciju svih terena iz baze podataka")
	@GetMapping("court")
	public Collection<Court> getCourts() {
		return courtRepository.findAll();
	}

	@ApiOperation(value = "Vraca teren iz baze podataka ciji je id zadata vrednost")
	// vrednost prosledjnena kao path varijabla")
	@GetMapping("court/{id}")
	public ResponseEntity<Court> getCourt(@PathVariable("id") Integer id) {
		Court court = courtRepository.getOne(id);
		return new ResponseEntity<Court>(court, HttpStatus.OK);
	}

	@ApiOperation(value = "Vraca teren iz baze podataka cija je adresa zadata vrednost")
	// prosledjnena kao path varijabla")
	@GetMapping("courtaddress/{courtaddress}")
	public Collection<Court> getCourtByAddress(@PathVariable("courtaddress") String courtaddress) {
		return courtRepository.findByCourtaddressContainingIgnoreCase(courtaddress);
	}

	// CourtType//

	@ApiOperation(value = "Vraca kolekciju svih tipova terena iz baze podataka")
	@GetMapping("courttype")
	public Collection<Courttype> getCourttypes() {
		return courttypeRepository.findAll();
	}

	@ApiOperation(value = "Vraca tip terena iz baze podataka ciji je id zadata vrednost")
	@GetMapping("courttype/{id}")
	public ResponseEntity<Courttype> getCourttype(@PathVariable("id") Integer id) {
		Courttype courttype = courttypeRepository.getOne(id);
		return new ResponseEntity<Courttype>(courttype, HttpStatus.OK);
	}

	@ApiOperation(value = "Vraca tip terena iz baze podataka ciji je tip zadata vrednost")
	// prosledjnena kao path varijabla")
	@GetMapping("courttypet/{courttype}")
	public Collection<Courttype> getCourttypeByType(@PathVariable("courttype") String courttype) {
		return courttypeRepository.findByCourttypeContainingIgnoreCase(courttype);
	}

	// Employee//

	@ApiOperation(value = "Vraca kolekciju svih zaposlenih iz baze podataka")
	@GetMapping("employee")
	public Collection<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@ApiOperation(value = "Vraca zaposlenog iz baze podataka ciji je id zadata vrednost")
	@GetMapping("employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {
		Employee employee = employeeRepository.getOne(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@ApiOperation(value = "Vraca zaposlenog iz baze podataka cije je prezime zadata vrednost")
	// prosledjnena kao path varijabla")
	@GetMapping("employeelastname/{employeelastname}")
	public Collection<Employee> getEmployeeByLastName(@PathVariable("employeelastname") String employeelastname) {
		return employeeRepository.findByEmployeelastnameContainingIgnoreCase(employeelastname);
	}

	// Game//

	@ApiOperation(value = "Vraca kolekciju svih game-ova iz baze podataka")
	@GetMapping("game")
	public Collection<Game> getGames() {
		return gameRepository.findAll();
	}

	@ApiOperation(value = "Vraca game iz baze podataka ciji je id zadata vrednost")
	// vrednost prosledjnena kao path varijabla")
	@GetMapping("game/{id}")
	public ResponseEntity<Game> getGame(@PathVariable("id") Integer id) {
		Game game = gameRepository.getOne(id);
		return new ResponseEntity<Game>(game, HttpStatus.OK);
	}

	// Match//

	@ApiOperation(value = "Vraca kolekciju svih meceva iz baze podataka")
	@GetMapping("match")
	public Collection<Match> getMatchs() {
		return matchRepository.findAll();
	}

	@ApiOperation(value = "Vraca mec iz baze podataka ciji je id zadata vrednost")
	// vrednost prosledjnena kao path varijabla")
	@GetMapping("match/{id}")
	public ResponseEntity<Match> getMatch(@PathVariable("id") Integer id) {
		Match match = matchRepository.getOne(id);
		return new ResponseEntity<Match>(match, HttpStatus.OK);
	}

	@ApiOperation(value = "Vraca mec iz baze podataka ciji je status odobrenosti zadata vrednost")
	// prosledjnena kao path varijabla")
	@GetMapping("matchapproved/{approvedbyemployee}")
	public Collection<Match> getMatchByApproved(@PathVariable("approvedbyemployee") String approvedbyemployee) {
		if (approvedbyemployee.toLowerCase().equals("true") || approvedbyemployee.toLowerCase().equals("false"))
			return matchRepository.findByApprovedbyemployee(Boolean.parseBoolean(approvedbyemployee));
		else if (approvedbyemployee.equals("null"))
			return matchRepository.findByApprovedbyemployeeNull();
		else
			return null;
	}

	// Player//

	@ApiOperation(value = "Vraca kolekciju svih igraca iz baze podataka")
	@GetMapping("player")
	public Collection<Player> getPlayers() {
		return playerRepository.findAll();
	}

	@ApiOperation(value = "Vraca igraca iz baze podataka ciji je id zadata vrednost")
	// vrednost prosledjnena kao path varijabla")
	@GetMapping("player/{id}")
	public ResponseEntity<Player> getPlayer(@PathVariable("id") Integer id) {
		Player player = playerRepository.getOne(id);
		return new ResponseEntity<Player>(player, HttpStatus.OK);
	}

	@ApiOperation(value = "Vraca igraca iz baze podataka cije je prezime zadata vrednost")
	// prosledjnena kao path varijabla")
	@GetMapping("playerlastname/{playerlastname}")
	public Collection<Player> getPlayerByLastName(@PathVariable("playerlastname") String playerlastname) {
		return playerRepository.findByPlayerlastnameContainingIgnoreCase(playerlastname);
	}

	// Rank//

	@ApiOperation(value = "Vraca rank liste iz baze podataka")
	@GetMapping("rank")
	public Collection<Rank> getRanks() {
		return rankRepository.findAll();
	}

	@ApiOperation(value = "Vraca rank iz baze podataka ciji je id zadata vrednost")
	// vrednost prosledjnena kao path varijabla")
	@GetMapping("rank/{id}")
	public ResponseEntity<Rank> getRank(@PathVariable("id") Integer id) {
		Rank rank = rankRepository.getOne(id);
		return new ResponseEntity<Rank>(rank, HttpStatus.OK);
	}

	@ApiOperation(value = "Vraca rank iz baze podataka cija je pozicija zadata vrednost")
	// prosledjnena kao path varijabla")
	@GetMapping("rankposition/{position}")
	public Collection<Rank> getRankByPosition(@PathVariable("position") Integer position) {
		return rankRepository.findByPosition(position);
	}

}
