package risknucleus.aml.watchlist.bean;

import java.util.List;

import risknucleus.aml.watchlist.model.WatchlistAlertPOJO;
import risknucleus.aml.watchlist.model.WatchlistMatchesPOJO;



public class WatchlistOutput {
	List<WatchlistMatchesPOJO> matches;
	WatchlistAlertPOJO alerts;

	public WatchlistOutput() {
	}

	public WatchlistOutput(List<WatchlistMatchesPOJO> matches, WatchlistAlertPOJO alerts) {
		super();
		this.matches = matches;
		this.alerts = alerts;
	}

	public List<WatchlistMatchesPOJO> getMatches() {
		return matches;
	}

	public void setMatches(List<WatchlistMatchesPOJO> matches) {
		this.matches = matches;
	}

	public WatchlistAlertPOJO getAlerts() {
		return alerts;
	}

	public void setAlerts(WatchlistAlertPOJO alerts) {
		this.alerts = alerts;
	}

	@Override
	public String toString() {
		return "WatchlistOutput [matches=" + matches + ", alerts=" + alerts + "]";
	}

	

}
