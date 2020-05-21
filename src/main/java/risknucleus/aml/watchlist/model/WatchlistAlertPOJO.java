package risknucleus.aml.watchlist.model;

import java.util.Date;

public class WatchlistAlertPOJO {
	Integer alertId,scenarioClassId, focusTypeId, alertScore, wfStatus, activityStatus, hCode, serviceTypeID, suppress,
			assignTo;
	String focusColumnValue, alertType;
	Date alertDate, alertDueDate, lastActivityDate;
	
	public WatchlistAlertPOJO() {}

	public WatchlistAlertPOJO(Integer alertId, Integer scenarioClassId, Integer focusTypeId, Integer alertScore, Integer wfStatus,
			Integer activityStatus, Integer hCode, Integer serviceTypeID, Integer suppress, Integer assignTo,
			String focusColumnValue, String alertType, Date alertDate, Date alertDueDate, Date lastActivityDate) {
		super();
		this.alertId = alertId;
		this.scenarioClassId = scenarioClassId;
		this.focusTypeId = focusTypeId;
		this.alertScore = alertScore;
		this.wfStatus = wfStatus;
		this.activityStatus = activityStatus;
		this.hCode = hCode;
		this.serviceTypeID = serviceTypeID;
		this.suppress = suppress;
		this.assignTo = assignTo;
		this.focusColumnValue = focusColumnValue;
		this.alertType = alertType;
		this.alertDate = alertDate;
		this.alertDueDate = alertDueDate;
		this.lastActivityDate = lastActivityDate;
	}

	public Integer getAlertId() {
		return alertId;
	}

	public void setAlertId(Integer alertId) {
		this.alertId = alertId;
	}

	public Integer getScenarioClassId() {
		return scenarioClassId;
	}

	public void setScenarioClassId(Integer scenarioClassId) {
		this.scenarioClassId = scenarioClassId;
	}

	public Integer getFocusTypeId() {
		return focusTypeId;
	}

	public void setFocusTypeId(Integer focusTypeId) {
		this.focusTypeId = focusTypeId;
	}

	public Integer getAlertScore() {
		return alertScore;
	}

	public void setAlertScore(Integer alertScore) {
		this.alertScore = alertScore;
	}

	public Integer getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(Integer wfStatus) {
		this.wfStatus = wfStatus;
	}

	public Integer getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(Integer activityStatus) {
		this.activityStatus = activityStatus;
	}

	public Integer gethCode() {
		return hCode;
	}

	public void sethCode(Integer hCode) {
		this.hCode = hCode;
	}

	public Integer getServiceTypeID() {
		return serviceTypeID;
	}

	public void setServiceTypeID(Integer serviceTypeID) {
		this.serviceTypeID = serviceTypeID;
	}

	public Integer getSuppress() {
		return suppress;
	}

	public void setSuppress(Integer suppress) {
		this.suppress = suppress;
	}

	public Integer getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(Integer assignTo) {
		this.assignTo = assignTo;
	}

	public String getFocusColumnValue() {
		return focusColumnValue;
	}

	public void setFocusColumnValue(String focusColumnValue) {
		this.focusColumnValue = focusColumnValue;
	}

	public String getAlertType() {
		return alertType;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	public Date getAlertDate() {
		return alertDate;
	}

	public void setAlertDate(Date alertDate) {
		this.alertDate = alertDate;
	}

	public Date getAlertDueDate() {
		return alertDueDate;
	}

	public void setAlertDueDate(Date alertDueDate) {
		this.alertDueDate = alertDueDate;
	}

	public Date getLastActivityDate() {
		return lastActivityDate;
	}

	public void setLastActivityDate(Date lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	@Override
	public String toString() {
		return "Alert [alertId=" + alertId + ", scenarioClassId=" + scenarioClassId + ", focusTypeId=" + focusTypeId
				+ ", alertScore=" + alertScore + ", wfStatus=" + wfStatus + ", activityStatus=" + activityStatus
				+ ", hCode=" + hCode + ", serviceTypeID=" + serviceTypeID + ", suppress=" + suppress + ", assignTo="
				+ assignTo + ", focusColumnValue=" + focusColumnValue + ", alertType=" + alertType + ", alertDate="
				+ alertDate + ", alertDueDate=" + alertDueDate + ", lastActivityDate=" + lastActivityDate + "]";
	}

	

}
