//package risknucleus.aml.watchlist.model;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
////@Table(name = "MATCHES",schema="Watchlist")
//@Table(name = "WATCHLIST_MATCHES")
//public class Watchlist_matches {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "Id")
//	private Integer id;
//	
//	@Column(name= "ScenarioID")
//	private int scenarionId;
//	
//	@Column(name= "AlertID")
//	private int alertId;
//	
//	@Column(name= "FocusTypeID")
//	private int focusTypeId;
//	
//	@Column(name= "FocusTypeValue")
//	private String focusTypeValue;
//	
//	@Column(name= "MatchDate")
//	private Date matchDate;
//	
//	@Column(name= "Score")
//	private int score;
//	
//	@Column(name= "WatchlistID")
//	private String watchlistId;
//	
//	@Column(name= "ListType")
//	private int listType;
//	
//	@Column(name= "EntityTypeID")
//	private int entityTypeId;
//	
//	@Column(name= "ActualName")
//	private String actualName;
//	
//	@Column(name= "CountryToken")
//	private String countryToken;
//	
//	@Column(name= "IdRegDoc")
//	private String idRegDoc;
//
//	public Watchlist_matches() {}
//	public Watchlist_matches(Integer id, int scenarionId, int alertId, int focusTypeId, String focusTypeValue,
//			Date matchDate, int score, String watchlistId, int listType, int entityTypeId, String actualName,
//			String countryToken, String idRegDoc) {
//		super();
//		this.id = id;
//		this.scenarionId = scenarionId;
//		this.alertId = alertId;
//		this.focusTypeId = focusTypeId;
//		this.focusTypeValue = focusTypeValue;
//		this.matchDate = matchDate;
//		this.score = score;
//		this.watchlistId = watchlistId;
//		this.listType = listType;
//		this.entityTypeId = entityTypeId;
//		this.actualName = actualName;
//		this.countryToken = countryToken;
//		this.idRegDoc = idRegDoc;
//	}
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public int getScenarionId() {
//		return scenarionId;
//	}
//	public void setScenarionId(int scenarionId) {
//		this.scenarionId = scenarionId;
//	}
//	public int getAlertId() {
//		return alertId;
//	}
//	public void setAlertId(int alertId) {
//		this.alertId = alertId;
//	}
//	public int getFocusTypeId() {
//		return focusTypeId;
//	}
//	public void setFocusTypeId(int focusTypeId) {
//		this.focusTypeId = focusTypeId;
//	}
//	public String getFocusTypeValue() {
//		return focusTypeValue;
//	}
//	public void setFocusTypeValue(String focusTypeValue) {
//		this.focusTypeValue = focusTypeValue;
//	}
//	public Date getMatchDate() {
//		return matchDate;
//	}
//	public void setMatchDate(Date matchDate) {
//		this.matchDate = matchDate;
//	}
//	public int getScore() {
//		return score;
//	}
//	public void setScore(int score) {
//		this.score = score;
//	}
//	public String getWatchlistId() {
//		return watchlistId;
//	}
//	public void setWatchlistId(String watchlistId) {
//		this.watchlistId = watchlistId;
//	}
//	public int getListType() {
//		return listType;
//	}
//	public void setListType(int listType) {
//		this.listType = listType;
//	}
//	public int getEntityTypeId() {
//		return entityTypeId;
//	}
//	public void setEntityTypeId(int entityTypeId) {
//		this.entityTypeId = entityTypeId;
//	}
//	public String getActualName() {
//		return actualName;
//	}
//	public void setActualName(String actualName) {
//		this.actualName = actualName;
//	}
//	public String getCountryToken() {
//		return countryToken;
//	}
//	public void setCountryToken(String countryToken) {
//		this.countryToken = countryToken;
//	}
//	public String getIdRegDoc() {
//		return idRegDoc;
//	}
//	public void setIdRegDoc(String idRegDoc) {
//		this.idRegDoc = idRegDoc;
//	}
//	
//	
//	
//	
//	
//}
