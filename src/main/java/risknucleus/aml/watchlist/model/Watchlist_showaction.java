package risknucleus.aml.watchlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WATCHLIST_SHOW_ACTION")
public class Watchlist_showaction {

	@Override
	public String toString() {
		return "Watchlist_showaction [Id=" + Id + ", actionName=" + actionName + ", actionKey=" + actionKey
				+ ", status=" + status + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Integer Id;
	
	@Column(name= "Action_Name")
	private String actionName;
	
	@Column(name= "Action_Key")
	private String actionKey;
	
	@Column(name= "status")
	private String status;
	
	public Watchlist_showaction() {}

	public Watchlist_showaction(Integer id, String actionName, String actionKey, String status) {
		super();
		Id = id;
		this.actionName = actionName;
		this.actionKey = actionKey;
		this.status = status;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionKey() {
		return actionKey;
	}

	public void setActionKey(String actionKey) {
		this.actionKey = actionKey;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
