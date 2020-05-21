package risknucleus.aml.watchlist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import risknucleus.aml.watchlist.model.Watchlist_scenario_setup;
@Repository
public interface ScenarioSetupRepository extends JpaRepository<Watchlist_scenario_setup, Integer> {

	@Query("select t from Watchlist_scenario_setup t  where t.status = 'A' and t.score >=?1 order by t.score desc, t.scenarioId asc")
	public List<Watchlist_scenario_setup> getActivescenarios(int score);

	@Query("select t from Watchlist_scenario_setup t  where t.status = 'A' order by t.score desc, t.scenarioId asc")
	public List<Watchlist_scenario_setup> findAllActiveScenarios();
	
	
	
	
}
