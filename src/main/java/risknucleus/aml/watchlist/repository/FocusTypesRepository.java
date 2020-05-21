package risknucleus.aml.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import risknucleus.aml.watchlist.model.FocusTypes;



public interface FocusTypesRepository extends JpaRepository<FocusTypes, Integer> {
//LIKE %:focusTypeKey%
	@Query("select c from FocusTypes c where c.focusTypeKey =:focusTypeKey")
	public FocusTypes findByFocusTypeKey(String focusTypeKey);
}
