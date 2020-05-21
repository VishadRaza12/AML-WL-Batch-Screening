package risknucleus.aml.watchlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WATCHLIST_CONDITION")

public class Watchlist_condition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "id")
	private Integer Id;
	
	@Column(name= "Condition_Name") 
	private String conditionName;
	@ManyToOne
	@JoinColumn(name= "Scenario_ID", referencedColumnName="ScenarioID")
	private Watchlist_scenario_setup watchlist_scenario_setup;
	

	@Column(name= "status")
	private String status;

	public Watchlist_condition() {}

	public Watchlist_condition(Integer id, String conditionName, Watchlist_scenario_setup watchlist_scenario_setup,
			String status) {
		super();
		Id = id;
		this.conditionName = conditionName;
		this.watchlist_scenario_setup = watchlist_scenario_setup;
		this.status = status;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public Watchlist_scenario_setup getWatchlist_scenario_setup() {
		return watchlist_scenario_setup;
	}

	public void setWatchlist_scenario_setup(Watchlist_scenario_setup watchlist_scenario_setup) {
		this.watchlist_scenario_setup = watchlist_scenario_setup;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Watchlist_condition [Id=" + Id + ", conditionName=" + conditionName + ", watchlist_scenario_setup="
				+ watchlist_scenario_setup + ", status=" + status + "]";
	}

	
	
}
