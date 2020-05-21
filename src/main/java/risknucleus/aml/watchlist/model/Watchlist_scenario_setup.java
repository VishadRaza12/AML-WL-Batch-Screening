package risknucleus.aml.watchlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WATCHLIST_SCENARIO_SETUP")

public class Watchlist_scenario_setup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ScenarioID")
	private Integer scenarioId;
	
	@Override
	public String toString() {
		return "Watchlist_scenario_setup [scenarioId=" + scenarioId + ", scenarioKey=" + scenarioKey + ", scenarioName="
				+ scenarioName + ", scenarioDesc=" + scenarioDesc + ", score=" + score + ", status=" + status + "]";
	}
	@Column(name= "SCENARIOKEY")
	private String scenarioKey;
	
	@Column(name= "SCENARIONAME")
	private String scenarioName;
	
	@Column(name= "SCENARIODESC")
	private String scenarioDesc;
	
	@Column(name= "Score")
	private Integer score;
	
	@Column(name= "Status")
	private String status;

	public Watchlist_scenario_setup() {}
	public Watchlist_scenario_setup(Integer scenarioId, String scenarioKey, String scenarioName, String scenarioDesc,
			Integer score, String status) {
		super();
		this.scenarioId = scenarioId;
		this.scenarioKey = scenarioKey;
		this.scenarioName = scenarioName;
		this.scenarioDesc = scenarioDesc;
		this.score = score;
		this.status = status;
	}
	public Integer getScenarioId() {
		return scenarioId;
	}
	public void setScenarioId(Integer scenarioId) {
		this.scenarioId = scenarioId;
	}
	public String getScenarioKey() {
		return scenarioKey;
	}
	public void setScenarioKey(String scenarioKey) {
		this.scenarioKey = scenarioKey;
	}
	public String getScenarioName() {
		return scenarioName;
	}
	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}
	public String getScenarioDesc() {
		return scenarioDesc;
	}
	public void setScenarioDesc(String scenarioDesc) {
		this.scenarioDesc = scenarioDesc;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

}
