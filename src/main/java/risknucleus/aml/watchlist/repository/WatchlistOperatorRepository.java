package risknucleus.aml.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import risknucleus.aml.watchlist.model.Watchlist_operator;

public interface WatchlistOperatorRepository extends JpaRepository<Watchlist_operator, Integer> {

}
