package risknucleus.aml.watchlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WATCHLIST_OPERATOR")
public class Watchlist_operator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Integer Id;
	
	@Column(name= "Operator_Name")
	private String operatorName;
	
	@Column(name= "Operator_Key")
	private String operatorKey;
	
	@Column(name= "OPERATORDISPLAYNAME")
	private String operatorDisplayName;
	
	@Column(name= "status")
	private String status;

	public Watchlist_operator() {}
	public Watchlist_operator(Integer id, String operatorName, String operatorKey, String operatorDisplayName,
			String status) {
		super();
		Id = id;
		this.operatorName = operatorName;
		this.operatorKey = operatorKey;
		this.operatorDisplayName = operatorDisplayName;
		this.status = status;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getOperatorKey() {
		return operatorKey;
	}
	public void setOperatorKey(String operatorKey) {
		this.operatorKey = operatorKey;
	}
	public String getOperatorDisplayName() {
		return operatorDisplayName;
	}
	public void setOperatorDisplayName(String operatorDisplayName) {
		this.operatorDisplayName = operatorDisplayName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Watchlist_operator [Id=" + Id + ", operatorName=" + operatorName + ", operatorKey=" + operatorKey
				+ ", operatorDisplayName=" + operatorDisplayName + ", status=" + status + "]";
	}
	
	
	
	
}
