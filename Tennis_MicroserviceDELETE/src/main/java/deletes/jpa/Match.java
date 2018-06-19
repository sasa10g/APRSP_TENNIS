package deletes.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the match database table.
 * 
 */
@Entity
@NamedQuery(name="Match.findAll", query="SELECT m FROM Match m")
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MATCH_MATCHID_GENERATOR", sequenceName="MATCH_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MATCH_MATCHID_GENERATOR")
	private Integer matchid;

	private Boolean approvedbyemployee;

	private Boolean approvedbysecondplayer;

	private Integer courttypeid;

	private Integer firstplayersets;

	@Temporal(TemporalType.DATE)
	private Date matchdate;

	private Integer seondplayersets;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="match")
	@JsonIgnore
	private List<Game> games;

	//bi-directional many-to-one association to Appointment
	@ManyToOne
	@JoinColumn(name="appointmentid")
	private Appointment appointment;

	//bi-directional many-to-one association to Court
	@ManyToOne
	@JoinColumn(name="courtid")
	private Court court;

	//bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="firstplayerid")
	private Player player1;

	//bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="secondplayerid")
	private Player player2;

	public Match() {
	}

	public Integer getMatchid() {
		return this.matchid;
	}

	public void setMatchid(Integer matchid) {
		this.matchid = matchid;
	}

	public Boolean getApprovedbyemployee() {
		return this.approvedbyemployee;
	}

	public void setApprovedbyemployee(Boolean approvedbyemployee) {
		this.approvedbyemployee = approvedbyemployee;
	}

	public Boolean getApprovedbysecondplayer() {
		return this.approvedbysecondplayer;
	}

	public void setApprovedbysecondplayer(Boolean approvedbysecondplayer) {
		this.approvedbysecondplayer = approvedbysecondplayer;
	}

	public Integer getCourttypeid() {
		return this.courttypeid;
	}

	public void setCourttypeid(Integer courttypeid) {
		this.courttypeid = courttypeid;
	}

	public Integer getFirstplayersets() {
		return this.firstplayersets;
	}

	public void setFirstplayersets(Integer firstplayersets) {
		this.firstplayersets = firstplayersets;
	}

	public Date getMatchdate() {
		return this.matchdate;
	}

	public void setMatchdate(Date matchdate) {
		this.matchdate = matchdate;
	}

	public Integer getSeondplayersets() {
		return this.seondplayersets;
	}

	public void setSeondplayersets(Integer seondplayersets) {
		this.seondplayersets = seondplayersets;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Game addGame(Game game) {
		getGames().add(game);
		game.setMatch(this);

		return game;
	}

	public Game removeGame(Game game) {
		getGames().remove(game);
		game.setMatch(null);

		return game;
	}

	public Appointment getAppointment() {
		return this.appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Court getCourt() {
		return this.court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public Player getPlayer1() {
		return this.player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return this.player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

}