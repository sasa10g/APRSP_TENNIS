package put.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the court database table.
 * 
 */
@Entity
@NamedQuery(name="Court.findAll", query="SELECT c FROM Court c")
public class Court implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COURT_COURTID_GENERATOR", sequenceName="COURT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COURT_COURTID_GENERATOR")
	private Integer courtid;

	private String courtaddress;

	//bi-directional many-to-one association to Courttype
	@ManyToOne
	@JoinColumn(name="courttypeid")
	private Courttype courttype;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="court")
	@JsonIgnore
	private List<Match> matches;

	public Court() {
	}

	public Integer getCourtid() {
		return this.courtid;
	}

	public void setCourtid(Integer courtid) {
		this.courtid = courtid;
	}

	public String getCourtaddress() {
		return this.courtaddress;
	}

	public void setCourtaddress(String courtaddress) {
		this.courtaddress = courtaddress;
	}

	public Courttype getCourttype() {
		return this.courttype;
	}

	public void setCourttype(Courttype courttype) {
		this.courttype = courttype;
	}

	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Match addMatch(Match match) {
		getMatches().add(match);
		match.setCourt(this);

		return match;
	}

	public Match removeMatch(Match match) {
		getMatches().remove(match);
		match.setCourt(null);

		return match;
	}

}