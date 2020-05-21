package risknucleus.aml.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import risknucleus.aml.watchlist.model.Watchlist_tablesetup;

public interface TableSetupRepository extends JpaRepository<Watchlist_tablesetup, Integer> {

//	@Query("select t.model from Watchlist_tablesetup t where t.id=?1")
//	String getmodel(int id);
}
