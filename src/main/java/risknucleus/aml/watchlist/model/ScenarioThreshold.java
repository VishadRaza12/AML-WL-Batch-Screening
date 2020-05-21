package risknucleus.aml.watchlist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WATCHLIST_SCENARIOTHRESHOLD")
public class ScenarioThreshold {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer ID;
	
	@Column(name= "Name")
	private String name;
	
	@Column(name= "Threshold")
	private int threshold;
	
	@Column(name= "status")
	private String status;
	
	@Column(name= "CREATEDBY")
	private int createdBy;
	
	@Column(name= "UPDATEDBY")
	private int updatedBy;
	
	@Column(name= "UPDATEDON")
	private Date updatedOn;
	
	@Column(name= "CREATEDON")
	private Date createdOn;
	
	@Column(name= "FOCUSTYPE")
	private int focusType;

	
	public ScenarioThreshold() {}


	public ScenarioThreshold(Integer iD, String name, int threshold, String status, int createdBy, int updatedBy,
			Date updatedOn, Date createdOn, int focusType) {
		super();
		ID = iD;
		this.name = name;
		this.threshold = threshold;
		this.status = status;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
		this.createdOn = createdOn;
		this.focusType = focusType;
	}


	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getThreshold() {
		return threshold;
	}


	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}


	public int getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Date getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public int getFocusType() {
		return focusType;
	}


	public void setFocusType(int focusType) {
		this.focusType = focusType;
	}
	

}
