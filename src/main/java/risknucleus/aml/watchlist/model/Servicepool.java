package risknucleus.aml.watchlist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE_SERVICEPOOL")

public class Servicepool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SERVICEPOOLID")
	private Integer servicePoolId;
	
	@Column(name= "FIXEDREF")
	private String fixedRef;
	
	@Column(name= "SERVICELOGID")
	private Integer serviceLogId;
	
	@Column(name= "SERVICEFLAG")
	private String serviceFlag;
	
	@Column(name= "Status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name= "FOCUSTYPEID" , referencedColumnName= "FOCUSTYPEID")
	private FocusTypes focusTypeId;
	
	@Column(name= "CREATEDON")
	private Date createdOn;

	
	public Servicepool() {}
	
	

	public Servicepool(Integer servicePoolId, String fixedRef, Integer serviceLogId, String serviceFlag, String status,
			FocusTypes focusTypeId, Date createdOn) {
		super();
		this.servicePoolId = servicePoolId;
		this.fixedRef = fixedRef;
		this.serviceLogId = serviceLogId;
		this.serviceFlag = serviceFlag;
		this.status = status;
		this.focusTypeId = focusTypeId;
		this.createdOn = createdOn;
	}



	public Integer getServicePoolId() {
		return servicePoolId;
	}

	public void setServicePoolId(Integer servicePoolId) {
		this.servicePoolId = servicePoolId;
	}

	public String getFixedRef() {
		return fixedRef;
	}

	public void setFixedRef(String fixedRef) {
		this.fixedRef = fixedRef;
	}

	public Integer getServiceLogId() {
		return serviceLogId;
	}

	public void setServiceLogId(Integer serviceLogId) {
		this.serviceLogId = serviceLogId;
	}

	public String getServiceFlag() {
		return serviceFlag;
	}

	public void setServiceFlag(String serviceFlag) {
		this.serviceFlag = serviceFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}



	public FocusTypes getFocusTypeId() {
		return focusTypeId;
	}



	public void setFocusTypeId(FocusTypes focusTypeId) {
		this.focusTypeId = focusTypeId;
	}
	
	

}
