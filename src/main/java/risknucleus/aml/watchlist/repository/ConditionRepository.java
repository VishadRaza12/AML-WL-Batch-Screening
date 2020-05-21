package risknucleus.aml.watchlist.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import risknucleus.aml.watchlist.model.Watchlist_condition;
import risknucleus.aml.watchlist.model.Watchlist_scenario_setup;
@Repository
public interface ConditionRepository extends JpaRepository<Watchlist_condition,Integer> {

	@Query("select t from Watchlist_condition t where t.watchlist_scenario_setup=?1")
	public ArrayList<Watchlist_condition> findAllByScenarioID(Watchlist_scenario_setup Scenario_ID);
	
}
