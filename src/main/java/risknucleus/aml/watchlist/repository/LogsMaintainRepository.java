package risknucleus.aml.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import risknucleus.aml.watchlist.model.LogsMaintain;

@Repository
public interface LogsMaintainRepository  extends JpaRepository<LogsMaintain, Integer>{
	
	

}
