package deletes.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rank database table.
 * 
 */
@Entity
@NamedQuery(name="Rank.findAll", query="SELECT r FROM Rank r")
public class Rank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RANK_RANKID_GENERATOR", sequenceName="RANK_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RANK_RANKID_GENERATOR")
	private Integer rankid;

	private Integer position;

	private Integer previousposition;

	//bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="playerid")
	private Player player;

	public Rank() {
	}

	public Integer getRankid() {
		return this.rankid;
	}

	public void setRankid(Integer rankid) {
		this.rankid = rankid;
	}

	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getPreviousposition() {
		return this.previousposition;
	}

	public void setPreviousposition(Integer previousposition) {
		this.previousposition = previousposition;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}