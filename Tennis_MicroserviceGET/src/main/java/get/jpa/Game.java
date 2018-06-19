package get.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the game database table.
 * 
 */
@Entity
@NamedQuery(name="Game.findAll", query="SELECT g FROM Game g")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GAME_GAMEID_GENERATOR", sequenceName="GAME_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GAME_GAMEID_GENERATOR")
	private Integer gameid;

	private Integer firstplayerpoints;

	private Integer secondplayerpoints;

	//bi-directional many-to-one association to Match
	@ManyToOne
	@JoinColumn(name="matchid")
	private Match match;

	public Game() {
	}

	public Integer getGameid() {
		return this.gameid;
	}

	public void setGameid(Integer gameid) {
		this.gameid = gameid;
	}

	public Integer getFirstplayerpoints() {
		return this.firstplayerpoints;
	}

	public void setFirstplayerpoints(Integer firstplayerpoints) {
		this.firstplayerpoints = firstplayerpoints;
	}

	public Integer getSecondplayerpoints() {
		return this.secondplayerpoints;
	}

	public void setSecondplayerpoints(Integer secondplayerpoints) {
		this.secondplayerpoints = secondplayerpoints;
	}

	public Match getMatch() {
		return this.match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

}