package risknucleus.aml.watchlist.model;

public class Request {
	String customerName, country, identityNumber, dob, branchCode, fixedReference, systemInfo;
	Integer focusType,entityId;

	public Request() {
	}

	public Request(String customerName, Integer entityId, String country, String identityNumber, String dob,
			String branchCode, String fixedReference, String systemInfo, Integer focusType) {
		super();
		this.customerName = customerName;
		this.entityId = entityId;
		this.country = country;
		this.identityNumber = identityNumber;
		this.dob = dob;
		this.branchCode = branchCode;
		this.fixedReference = fixedReference;
		this.systemInfo = systemInfo;
		this.focusType = focusType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getFixedReference() {
		return fixedReference;
	}

	public void setFixedReference(String fixedReference) {
		this.fixedReference = fixedReference;
	}

	public String getSystemInfo() {
		return systemInfo;
	}

	public void setSystemInfo(String systemInfo) {
		this.systemInfo = systemInfo;
	}

	public Integer getFocusType() {
		return focusType;
	}

	public void setFocusType(Integer focusType) {
		this.focusType = focusType;
	}

	@Override
	public String toString() {
		return "Request [customerName=" + customerName + ", entityId=" + entityId + ", country=" + country
				+ ", identityNumber=" + identityNumber + ", dob=" + dob + ", branchCode=" + branchCode
				+ ", fixedReference=" + fixedReference + ", systemInfo=" + systemInfo + ", focusType=" + focusType
				+ "]";
	}

	
}