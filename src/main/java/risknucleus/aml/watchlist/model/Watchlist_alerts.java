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
////@Table(name = "ALERTS",schema="Watchlist")
//@Table(name = "WATCHLIST_ALERTS")
//
//public class Watchlist_alerts {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "AlertID")
//	private Integer alertId;
//	
//	@Column(name= "ScenarioClassID")
//	private int scenarioClassId;
//	
//	@Column(name= "FocusTypeID")
//	private int focusTypeId;
//	
//	@Column(name= "FocusColumnValue")
//	private String focusColumnValue;
//	
//	@Column(name= "AlertDate")
//	private Date alertDate;
//	
//	@Column(name= "AlertScore")
//	private int alertScore;
//	
//	@Column(name= "AlertType")
//	private String alertType;
//	
//	@Column(name= "wfstatus")
//	private int wfstatus;
//	
//	@Column(name= "AssignTo")
//	private int assignTo;
//	
//	@Column(name= "AlertDueDate")
//	private Date alertDueDate;
//	
//	@Column(name= "ActivityStatus")
//	private int activityStatus;
//	
//	@Column(name= "Suppress")
//	private int suppress;
//	
//	@Column(name= "LastActivityDate")
//	private Date lastActivityDate;
//	
//	@Column(name= "Hcode")
//	private int hcode;
//	
//	@Column(name= "ServiceTypeID")
//	private int serviceTypeId;
//
//	public Watchlist_alerts() {}
//	
//	public Watchlist_alerts(Integer alertId, int scenarioClassId, int focusTypeId, String focusColumnValue,
//			Date alertDate, int alertScore, String alertType, int wfstatus, int assignTo, Date alertDueDate,
//			int activityStatus, int suppress, Date lastActivityDate, int hcode, int serviceTypeId) {
//		super();
//		this.alertId = alertId;
//		this.scenarioClassId = scenarioClassId;
//		this.focusTypeId = focusTypeId;
//		this.focusColumnValue = focusColumnValue;
//		this.alertDate = alertDate;
//		this.alertScore = alertScore;
//		this.alertType = alertType;
//		this.wfstatus = wfstatus;
//		this.assignTo = assignTo;
//		this.alertDueDate = alertDueDate;
//		this.activityStatus = activityStatus;
//		this.suppress = suppress;
//		this.lastActivityDate = lastActivityDate;
//		this.hcode = hcode;
//		this.serviceTypeId = serviceTypeId;
//	}
//
//	public Integer getAlertId() {
//		return alertId;
//	}
//
//	public void setAlertId(Integer alertId) {
//		this.alertId = alertId;
//	}
//
//	public int getScenarioClassId() {
//		return scenarioClassId;
//	}
//
//	public void setScenarioClassId(int scenarioClassId) {
//		this.scenarioClassId = scenarioClassId;
//	}
//
//	public int getFocusTypeId() {
//		return focusTypeId;
//	}
//
//	public void setFocusTypeId(int focusTypeId) {
//		this.focusTypeId = focusTypeId;
//	}
//
//	public String getFocusColumnValue() {
//		return focusColumnValue;
//	}
//
//	public void setFocusColumnValue(String focusColumnValue) {
//		this.focusColumnValue = focusColumnValue;
//	}
//
//	public Date getAlertDate() {
//		return alertDate;
//	}
//
//	public void setAlertDate(Date alertDate) {
//		this.alertDate = alertDate;
//	}
//
//	public int getAlertScore() {
//		return alertScore;
//	}
//
//	public void setAlertScore(int alertScore) {
//		this.alertScore = alertScore;
//	}
//
//	public String getAlertType() {
//		return alertType;
//	}
//
//	public void setAlertType(String alertType) {
//		this.alertType = alertType;
//	}
//
//	public int getWfstatus() {
//		return wfstatus;
//	}
//
//	public void setWfstatus(int wfstatus) {
//		this.wfstatus = wfstatus;
//	}
//
//	public int getAssignTo() {
//		return assignTo;
//	}
//
//	public void setAssignTo(int assignTo) {
//		this.assignTo = assignTo;
//	}
//
//	public Date getAlertDueDate() {
//		return alertDueDate;
//	}
//
//	public void setAlertDueDate(Date alertDueDate) {
//		this.alertDueDate = alertDueDate;
//	}
//
//	public int getActivityStatus() {
//		return activityStatus;
//	}
//
//	public void setActivityStatus(int activityStatus) {
//		this.activityStatus = activityStatus;
//	}
//
//	public int getSuppress() {
//		return suppress;
//	}
//
//	public void setSuppress(int suppress) {
//		this.suppress = suppress;
//	}
//
//	public Date getLastActivityDate() {
//		return lastActivityDate;
//	}
//
//	public void setLastActivityDate(Date lastActivityDate) {
//		this.lastActivityDate = lastActivityDate;
//	}
//
//	public int getHcode() {
//		return hcode;
//	}
//
//	public void setHcode(int hcode) {
//		this.hcode = hcode;
//	}
//
//	public int getServiceTypeId() {
//		return serviceTypeId;
//	}
//
//	public void setServiceTypeId(int serviceTypeId) {
//		this.serviceTypeId = serviceTypeId;
//	}
//	
//	
//	
//	
//}
