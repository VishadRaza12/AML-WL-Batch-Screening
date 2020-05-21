package risknucleus.aml.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import risknucleus.aml.watchlist.model.Watchlist_showaction;

@Repository
public interface ActionRepository extends JpaRepository<Watchlist_showaction,Integer> {

}
