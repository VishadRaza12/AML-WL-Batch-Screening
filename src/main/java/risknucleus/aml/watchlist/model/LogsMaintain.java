package risknucleus.aml.watchlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOGS_MAINTAIN")
public class LogsMaintain {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOGID", length = 18)
	private Integer LOGID;

	@Column(name = "CurrentStatus")
	private String currentStatus;

	public LogsMaintain() {}
	public LogsMaintain(Integer lOGID, String currentStatus) {
		super();
		LOGID = lOGID;
		this.currentStatus = currentStatus;
	}
	public Integer getLOGID() {
		return LOGID;
	}
	public void setLOGID(Integer lOGID) {
		LOGID = lOGID;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	
	

}
