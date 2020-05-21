package risknucleus.aml.watchlist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import risknucleus.aml.watchlist.model.AlternateName;

public interface AlternateNameRepository extends JpaRepository<AlternateName, Integer>{
	
	@Query("select t from AlternateName t")
	List<AlternateName> getNameList();

	Boolean existsByNameDescription(String chck);
	
	

}
