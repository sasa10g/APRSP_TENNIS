package post.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the courttype database table.
 * 
 */
@Entity
@NamedQuery(name="Courttype.findAll", query="SELECT c FROM Courttype c")
public class Courttype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COURTTYPE_COURTTYPEID_GENERATOR", sequenceName="COURT_TYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COURTTYPE_COURTTYPEID_GENERATOR")
	private Integer courttypeid;

	private String courttype;

	//bi-directional many-to-one association to Court
	@OneToMany(mappedBy="courttype")
	@JsonIgnore
	private List<Court> courts;

	public Courttype() {
	}

	public Integer getCourttypeid() {
		return this.courttypeid;
	}

	public void setCourttypeid(Integer courttypeid) {
		this.courttypeid = courttypeid;
	}

	public String getCourttype() {
		return this.courttype;
	}

	public void setCourttype(String courttype) {
		this.courttype = courttype;
	}

	public List<Court> getCourts() {
		return this.courts;
	}

	public void setCourts(List<Court> courts) {
		this.courts = courts;
	}

	public Court addCourt(Court court) {
		getCourts().add(court);
		court.setCourttype(this);

		return court;
	}

	public Court removeCourt(Court court) {
		getCourts().remove(court);
		court.setCourttype(null);

		return court;
	}

}