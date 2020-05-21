package risknucleus.aml.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import risknucleus.aml.watchlist.model.Watchlist_columnsetup;

@Repository
public interface ColumnSetupRepository extends JpaRepository<Watchlist_columnsetup, Integer> {

	@Query(value="select t.Column_Key from WATCHLIST_COLUMN_SETUP t where id=?1", nativeQuery= true)
	public String findById(int id);
}
