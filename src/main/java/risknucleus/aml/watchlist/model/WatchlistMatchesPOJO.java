package risknucleus.aml.watchlist.model;

import java.util.Date;

public class WatchlistMatchesPOJO {

	Integer scenarioId, alertId,focusTypeId, score, listType, entityTypeId, customerId;
	Date matchDate;
	String focusTypeValue, watchlistId, actualName, countryToken, idRegDoc;

	
	public WatchlistMatchesPOJO() {
	}

	
	public WatchlistMatchesPOJO(Integer scenarioId, Integer alertId, Integer focusTypeId, Integer score,
			Integer listType, Integer entityTypeId, Integer customerId, Date matchDate, String focusTypeValue,
			String watchlistId, String actualName, String countryToken, String idRegDoc) {
		super();
		this.scenarioId = scenarioId;
		this.alertId = alertId;
		this.focusTypeId = focusTypeId;
		this.score = score;
		this.listType = listType;
		this.entityTypeId = entityTypeId;
		this.customerId = customerId;
		this.matchDate = matchDate;
		this.focusTypeValue = focusTypeValue;
		this.watchlistId = watchlistId;
		this.actualName = actualName;
		this.countryToken = countryToken;
		this.idRegDoc = idRegDoc;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public Integer getScenarioId() {
		return scenarioId;
	}

	public void setScenarioId(Integer scenarioId) {
		this.scenarioId = scenarioId;
	}

	public Integer getAlertId() {
		return alertId;
	}

	public void setAlertId(Integer alertId) {
		this.alertId = alertId;
	}

	public Integer getFocusTypeId() {
		return focusTypeId;
	}

	public void setFocusTypeId(Integer focusTypeId) {
		this.focusTypeId = focusTypeId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getListType() {
		return listType;
	}

	public void setListType(Integer listType) {
		this.listType = listType;
	}

	public Integer getEntityTypeId() {
		return entityTypeId;
	}

	public void setEntityTypeId(Integer entityTypeId) {
		this.entityTypeId = entityTypeId;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public String getFocusTypeValue() {
		return focusTypeValue;
	}

	public void setFocusTypeValue(String focusTypeValue) {
		this.focusTypeValue = focusTypeValue;
	}

	public String getWatchlistId() {
		return watchlistId;
	}

	public void setWatchlistId(String watchlistId) {
		this.watchlistId = watchlistId;
	}

	public String getActualName() {
		return actualName;
	}

	public void setActualName(String actualName) {
		this.actualName = actualName;
	}

	public String getCountryToken() {
		return countryToken;
	}

	public void setCountryToken(String countryToken) {
		this.countryToken = countryToken;
	}

	public String getIdRegDoc() {
		return idRegDoc;
	}

	public void setIdRegDoc(String idRegDoc) {
		this.idRegDoc = idRegDoc;
	}

	@Override
	public String toString() {
		return "Matches [scenarioId=" + scenarioId + ", alertId=" + alertId + ", focusTypeId=" + focusTypeId
				+ ", score=" + score + ", listType=" + listType + ", entityTypeId=" + entityTypeId + ", matchDate="
				+ matchDate + ", focusTypeValue=" + focusTypeValue + ", watchlistId=" + watchlistId + ", actualName="
				+ actualName + ", countryToken=" + countryToken + ", idRegDoc=" + idRegDoc + "]";
	}
	
	

	
}
