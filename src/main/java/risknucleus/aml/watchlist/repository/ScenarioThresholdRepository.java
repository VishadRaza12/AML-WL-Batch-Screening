package risknucleus.aml.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import risknucleus.aml.watchlist.model.Customer_customernew;
import risknucleus.aml.watchlist.model.ScenarioThreshold;

@Repository
public interface ScenarioThresholdRepository extends JpaRepository<ScenarioThreshold, Integer> {

	
	@Query(value="select distinct t.threshold from WATCHLIST_SCENARIOTHRESHOLD t join CUSTOMER_CUSTOMERNEW c on t.focustype = c.focustype where c.uniquerefno=?1", nativeQuery = true)
	public Integer getThresholdValue(String cust );
	
	
	@Query(value="select t.threshold from WATCHLIST_SCENARIOTHRESHOLD t where t.focusType=?1", nativeQuery= true)
	public int getfocusType(Integer focusType);
	
	
	
}
