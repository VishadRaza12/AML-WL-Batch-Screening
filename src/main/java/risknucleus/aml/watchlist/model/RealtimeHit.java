package risknucleus.aml.watchlist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIMECHECK")
public class RealtimeHit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 18)
	private Integer ID;
	
	@Column(name= "Place")
	private String place;
	
	@Column(name = "HITSTART")
	private Date hitstart;
	
	@Column(name = "HITEND")
	private Date hitend;
	
	public RealtimeHit() {}

	
	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public RealtimeHit(Integer iD, String place, Date hitstart, Date hitend) {
		super();
		ID = iD;
		this.place = place;
		this.hitstart = hitstart;
		this.hitend = hitend;
	}


	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Date getHitstart() {
		return hitstart;
	}

	public void setHitstart(Date hitstart) {
		this.hitstart = hitstart;
	}

	public Date getHitend() {
		return hitend;
	}

	public void setHitend(Date hitend) {
		this.hitend = hitend;
	}
	
	
	
}
