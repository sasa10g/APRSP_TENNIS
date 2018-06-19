package put.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the player database table.
 * 
 */
@Entity
@NamedQuery(name="Player.findAll", query="SELECT p FROM Player p")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PLAYER_PLAYERID_GENERATOR", sequenceName="PLAYER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PLAYER_PLAYERID_GENERATOR")
	private Integer playerid;

	@Temporal(TemporalType.DATE)
	private Date dateofjoining;

	private Integer height;

	private String playeraddress;

	@Temporal(TemporalType.DATE)
	private Date playerdateofbirth;

	private String playerfirstname;

	private String playerlastname;

	private String playerpassword;

	private String playerusername;

	private Integer weight;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="player1")
	@JsonIgnore
	private List<Match> matches1;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="player2")
	@JsonIgnore
	private List<Match> matches2;

	//bi-directional many-to-one association to Rank
	@OneToMany(mappedBy="player")
	@JsonIgnore
	private List<Rank> ranks;

	public Player() {
	}

	public Integer getPlayerid() {
		return this.playerid;
	}

	public void setPlayerid(Integer playerid) {
		this.playerid = playerid;
	}

	public Date getDateofjoining() {
		return this.dateofjoining;
	}

	public void setDateofjoining(Date dateofjoining) {
		this.dateofjoining = dateofjoining;
	}

	public Integer getHeight() {
		return this.height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getPlayeraddress() {
		return this.playeraddress;
	}

	public void setPlayeraddress(String playeraddress) {
		this.playeraddress = playeraddress;
	}

	public Date getPlayerdateofbirth() {
		return this.playerdateofbirth;
	}

	public void setPlayerdateofbirth(Date playerdateofbirth) {
		this.playerdateofbirth = playerdateofbirth;
	}

	public String getPlayerfirstname() {
		return this.playerfirstname;
	}

	public void setPlayerfirstname(String playerfirstname) {
		this.playerfirstname = playerfirstname;
	}

	public String getPlayerlastname() {
		return this.playerlastname;
	}

	public void setPlayerlastname(String playerlastname) {
		this.playerlastname = playerlastname;
	}

	public String getPlayerpassword() {
		return this.playerpassword;
	}

	public void setPlayerpassword(String playerpassword) {
		this.playerpassword = playerpassword;
	}

	public String getPlayerusername() {
		return this.playerusername;
	}

	public void setPlayerusername(String playerusername) {
		this.playerusername = playerusername;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public List<Match> getMatches1() {
		return this.matches1;
	}

	public void setMatches1(List<Match> matches1) {
		this.matches1 = matches1;
	}

	public Match addMatches1(Match matches1) {
		getMatches1().add(matches1);
		matches1.setPlayer1(this);

		return matches1;
	}

	public Match removeMatches1(Match matches1) {
		getMatches1().remove(matches1);
		matches1.setPlayer1(null);

		return matches1;
	}

	public List<Match> getMatches2() {
		return this.matches2;
	}

	public void setMatches2(List<Match> matches2) {
		this.matches2 = matches2;
	}

	public Match addMatches2(Match matches2) {
		getMatches2().add(matches2);
		matches2.setPlayer2(this);

		return matches2;
	}

	public Match removeMatches2(Match matches2) {
		getMatches2().remove(matches2);
		matches2.setPlayer2(null);

		return matches2;
	}

	public List<Rank> getRanks() {
		return this.ranks;
	}

	public void setRanks(List<Rank> ranks) {
		this.ranks = ranks;
	}

	public Rank addRank(Rank rank) {
		getRanks().add(rank);
		rank.setPlayer(this);

		return rank;
	}

	public Rank removeRank(Rank rank) {
		getRanks().remove(rank);
		rank.setPlayer(null);

		return rank;
	}

}