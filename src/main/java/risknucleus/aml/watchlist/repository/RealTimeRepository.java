package risknucleus.aml.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import risknucleus.aml.watchlist.model.RealtimeHit;

@Repository
public interface RealTimeRepository extends JpaRepository<RealtimeHit, Integer> {

}
