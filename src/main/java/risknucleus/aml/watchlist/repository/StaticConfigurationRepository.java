package risknucleus.aml.watchlist.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import risknucleus.aml.watchlist.model.StaticConfiguration;


@Repository
public interface StaticConfigurationRepository extends JpaRepository<StaticConfiguration, Integer> {

	@Query("select value from StaticConfiguration where code=?1")
	public String findByCode(String code);

}
