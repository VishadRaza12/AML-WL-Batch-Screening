package risknucleus.aml.watchlist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import risknucleus.aml.watchlist.model.WatchlistListNew;

@Repository
public interface WatchListlistNewRepository extends JpaRepository<WatchlistListNew,Integer> {

	@Query(value="SELECT * FROM WATCHLIST_LISTNEW where CreatedDate =CURDATE() or UpdatedDate = CURDATE()", nativeQuery = true)
	List<WatchlistListNew> getWatchList();
	//SELECT * FROM watchlist.listnew where CreatedDate =convert( date, getdate()) or UpdatedDate = convert( date, getdate())", nativeQuery = true
	
	
	@Query(value="SELECT * FROM WATCHLIST_LISTNEW where status = 'A'  and entitytype=1", nativeQuery = true)
	List<WatchlistListNew> getActiveList();
}
