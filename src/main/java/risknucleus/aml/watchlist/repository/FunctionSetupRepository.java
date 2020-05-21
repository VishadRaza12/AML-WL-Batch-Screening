package risknucleus.aml.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import risknucleus.aml.watchlist.model.Watchlist_functionsetup;

@Repository
public interface FunctionSetupRepository extends JpaRepository<Watchlist_functionsetup,Integer> {

	@Query(value="select t.Function_Name from WATCHLIST_FUNCTION_SETUP t where id=?1", nativeQuery = true)
	public String findById(int id);
	
}
