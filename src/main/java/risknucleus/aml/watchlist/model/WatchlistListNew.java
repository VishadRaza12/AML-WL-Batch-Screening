package risknucleus.aml.watchlist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "WATCHLIST_LISTNEW")
public class WatchlistListNew {

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ListType;
		result = prime * result + ((actualName == null) ? 0 : actualName.hashCode());
		result = prime * result + ((countryToken == null) ? 0 : countryToken.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((entityID == null) ? 0 : entityID.hashCode());
		result = prime * result + entityType;
		result = prime * result + ((idRegDOc == null) ? 0 : idRegDOc.hashCode());
		result = prime * result + status;
		result = prime * result + ((uniqueRefNo == null) ? 0 : uniqueRefNo.hashCode());
		result = prime * result + ((yearOfBirth == null) ? 0 : yearOfBirth.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WatchlistListNew other = (WatchlistListNew) obj;
		if (ListType != other.ListType)
			return false;
		if (actualName == null) {
			if (other.actualName != null)
				return false;
		} else if (!actualName.equals(other.actualName))
			return false;
		if (countryToken == null) {
			if (other.countryToken != null)
				return false;
		} else if (!countryToken.equals(other.countryToken))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (entityID == null) {
			if (other.entityID != null)
				return false;
		} else if (!entityID.equals(other.entityID))
			return false;
		if (entityType != other.entityType)
			return false;
		if (idRegDOc == null) {
			if (other.idRegDOc != null)
				return false;
		} else if (!idRegDOc.equals(other.idRegDOc))
			return false;
		if (status != other.status)
			return false;
		if (uniqueRefNo == null) {
			if (other.uniqueRefNo != null)
				return false;
		} else if (!uniqueRefNo.equals(other.uniqueRefNo))
			return false;
		if (yearOfBirth == null) {
			if (other.yearOfBirth != null)
				return false;
		} else if (!yearOfBirth.equals(other.yearOfBirth))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WATCHLIST_ID")
	private Integer id;

	@Column(name = "LISTTYPE")
	private Integer ListType;

	@Column(name = "ENTITYTYPE")
	private Integer entityType;

	@Column(name = "ACTUALNAME", length = 3000)
	private String actualName;

	@Column(name = "ENTITYID")
	private String entityID;

	@Column(name = "COUNTRYTOKEN")
	private String countryToken;

	@Column(name = "UNIQUEREFNO")
	private String uniqueRefNo;

	@Column(name = "IDREGDOC")
	private String idRegDOc;

	@Column(name = "CREATEDDATE")
	private Date createdDate;

	@Column(name = "YEAROFBIRTH",nullable = true)
	private Integer yearOfBirth;

	@Column(name = "FULLNAME", length = 500)
	private String fullName;

	@Column(name = "FULLNAMEMETA", length = 500)
	private String fullNameMeta;

	@Column(name = "FULLNAMESANSSW", length = 500)
	private String fullNameSansSW;

	@Column(name = "FULLNAMEMETASANSSW")
	private String fullNameMetaSansSW;

	@Column(name = "UPDATEDDATE")
	private Date updatedDate;

	@Column(name = "SERVICELOGID")
	private int serviceLogId;

	@Column(name = "STATUS")
	private char status;

	@Column(name = "TRANSLATE", length = 2000)
	private String translate;

	@Column(name = "TEXTLANGUAGE", length = 100)
	private String textLanguage;

	@Column(name = "FULLNAMESOUND", length = 2000)
	private String fullNameSound;

	@Column(name = "FULLNAMESOUNDSANSSW", length = 2000)
	private String fullNameSoundSansSw;

	public WatchlistListNew() {
	}

	public WatchlistListNew(Integer id, Integer listType, int entityType, String actualName, String entityID, String countryToken,
			String uniqueRefNo, String idRegDOc, Date createdDate, int yearOfBirth, String fullName,
			String fullNameMeta, String fullNameSansSW, String fullNameMetaSansSW, Date updatedDate, int serviceLogId,
			char status, String translate, String textLanguage, String fullNameSound, String fullNameSoundSansSw) {
		super();
		this.id = id;
		ListType = listType;
		this.entityType = entityType;
		this.actualName = actualName;
		this.entityID = entityID;
		this.countryToken = countryToken;
		this.uniqueRefNo = uniqueRefNo;
		this.idRegDOc = idRegDOc;
		this.createdDate = createdDate;
		this.yearOfBirth = yearOfBirth;
		this.fullName = fullName;
		this.fullNameMeta = fullNameMeta;
		this.fullNameSansSW = fullNameSansSW;
		this.fullNameMetaSansSW = fullNameMetaSansSW;
		this.updatedDate = updatedDate;
		this.serviceLogId = serviceLogId;
		this.status = status;
		this.translate = translate;
		this.textLanguage = textLanguage;
		this.fullNameSound = fullNameSound;
		this.fullNameSoundSansSw = fullNameSoundSansSw;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getListType() {
		return ListType;
	}

	public void setListType(Integer listType) {
		ListType = listType;
	}

	public Integer getEntityType() {
		return entityType;
	}

	public void setEntityType(Integer entityType) {
		this.entityType = entityType;
	}

	public String getActualName() {
		return actualName;
	}

	public void setActualName(String actualName) {
		this.actualName = actualName;
	}

	public String getEntityID() {
		return entityID;
	}

	public void setEntityID(String string) {
		this.entityID = string;
	}

	public String getCountryToken() {
		return countryToken;
	}

	public void setCountryToken(String countryToken) {
		this.countryToken = countryToken;
	}

	public String getUniqueRefNo() {
		return uniqueRefNo;
	}

	public void setUniqueRefNo(String uniqueRefNo) {
		this.uniqueRefNo = uniqueRefNo;
	}

	public String getIdRegDOc() {
		return idRegDOc;
	}

	public void setIDRegDOc(String idRegDOc) {
		this.idRegDOc = idRegDOc;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullNameMeta() {
		return fullNameMeta;
	}

	public void setFullNameMeta(String fullNameMeta) {
		this.fullNameMeta = fullNameMeta;
	}

	public String getFullNameSanSW() {
		return fullNameSansSW;
	}

	public void setFullNameSansSW(String fullNameSansSW) {
		this.fullNameSansSW = fullNameSansSW;
	}

	public String getFullNameMetaSansSW() {
		return fullNameMetaSansSW;
	}

	public void setFullNameMetaSansSW(String fullNameMetaSansSW) {
		this.fullNameMetaSansSW = fullNameMetaSansSW;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getServiceLogId() {
		return serviceLogId;
	}

	public void setServiceLogId(int serviceLogId) {
		this.serviceLogId = serviceLogId;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getTranslate() {
		return translate;
	}

	public void setTranslate(String translate) {
		this.translate = translate;
	}

	public String getTextLanguage() {
		return textLanguage;
	}

	public void setTextLanguage(String textLanguage) {
		this.textLanguage = textLanguage;
	}

	public String getFullNameSound() {
		return fullNameSound;
	}

	public void setFullNameSound(String fullNameSound) {
		this.fullNameSound = fullNameSound;
	}

	public String getFullNameSoundSansSw() {
		return fullNameSoundSansSw;
	}

	public void setFullNameSoundSansSw(String fullNameSoundSansSw) {
		this.fullNameSoundSansSw = fullNameSoundSansSw;
	}

	@Override
	public String toString() {
		return "Watchlist [id=" + id + ", ListType=" + ListType + ", entityType=" + entityType + ", actualName="
				+ actualName + ", entityID=" + entityID + ", countryToken=" + countryToken + ", uniqueRefNo="
				+ uniqueRefNo + ", idRegDOc=" + idRegDOc + ", createdDate=" + createdDate + ", yearOfBirth="
				+ yearOfBirth + ", fullName=" + fullName + ", fullNameMeta=" + fullNameMeta + ", fullNameSanSW="
				+ fullNameSansSW + ", fullNameMetaSansSW=" + fullNameMetaSansSW + ", updatedDate=" + updatedDate
				+ ", serviceLogId=" + serviceLogId + ", status=" + status + ", translate=" + translate
				+ ", textLanguage=" + textLanguage + ", fullNameSound=" + fullNameSound + ", fullNameSoundSansSw="
				+ fullNameSoundSansSw + "]";
	}

}
