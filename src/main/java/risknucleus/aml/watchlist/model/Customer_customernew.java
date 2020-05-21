package risknucleus.aml.watchlist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_CUSTOMERNEW")
public class Customer_customernew {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "Id")
	private Integer id;
	
	@Column(name= "UNIQUEREFNO")
	private String uniqueRefNo;
	
	@Column(name= "ENTITYTYPE")
	private int entityType;
	
	@Column(name= "FOCUSTYPE")
	private Integer focusType;
	
	@Column(name= "ACTUALNAME")
	private String actualName;
	
	@Column(name= "FULLNAME")
	private String fullName;
	
	@Column(name= "FULLNAMEMETA")
	private String fullNameMeta;
	
	@Column(name= "FULLNAMESANSSW")
	private String fullNameSansSW;
	
	@Column(name= "FULLNAMEMETASANSSW")
	private String fullNameMetaSansSW;
	
	@Column(name= "COUNTRYTOKEN")
	private String countryToken;
	
	@Column(name= "IDREGDOC")
	private String idRegDoc;
	
	@Column(name= "CREATEDDATE")
	private Date createdDate;
	
	@Column(name= "UPDATEDDATE")
	private Date updatedDate;
	
	@Column(name= "Translate")
	private String translate;
	
	@Column(name= "Textlanguage")
	private String textlanguage;
	
	@Column(name= "FULLNAMESOUND")
	private String fullNameSound;
	
	@Column(name= "FULLNAMESOUNDSANSSW")
	private String fullNameSoundSansSW;
	
	@Column(name= "YEAROFBIRTH")
	private Integer yearOfBirth;

	public Customer_customernew() {}
	public Customer_customernew(Integer id, String uniqueRefNo, int entityType, Integer focusType, String actualName,
			String fullName, String fullNameMeta, String fullNameSansSW, String fullNameMetaSansSW, String countryToken,
			String idRegDoc, Date createdDate, Date updatedDate, String translate, String textlanguage,
			String fullNameSound, String fullNameSoundSansSW, Integer yearOfBirth) {
		super();
		this.id = id;
		this.uniqueRefNo = uniqueRefNo;
		this.entityType = entityType;
		this.focusType = focusType;
		this.actualName = actualName;
		this.fullName = fullName;
		this.fullNameMeta = fullNameMeta;
		this.fullNameSansSW = fullNameSansSW;
		this.fullNameMetaSansSW = fullNameMetaSansSW;
		this.countryToken = countryToken;
		this.idRegDoc = idRegDoc;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.translate = translate;
		this.textlanguage = textlanguage;
		this.fullNameSound = fullNameSound;
		this.fullNameSoundSansSW = fullNameSoundSansSW;
		this.yearOfBirth = yearOfBirth;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUniqueRefNo() {
		return uniqueRefNo;
	}
	public void setUniqueRefNo(String uniqueRefNo) {
		this.uniqueRefNo = uniqueRefNo;
	}
	public int getEntityType() {
		return entityType;
	}
	public void setEntityType(int entityType) {
		this.entityType = entityType;
	}
	public Integer getFocusType() {
		return focusType;
	}
	public void setFocusType(Integer focusType) {
		this.focusType = focusType;
	}
	public String getActualName() {
		return actualName;
	}
	public void setActualName(String actualName) {
		this.actualName = actualName;
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
	public String getFullNameSansSW() {
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getTranslate() {
		return translate;
	}
	public void setTranslate(String translate) {
		this.translate = translate;
	}
	public String getTextlanguage() {
		return textlanguage;
	}
	public void setTextlanguage(String textlanguage) {
		this.textlanguage = textlanguage;
	}
	public String getFullNameSound() {
		return fullNameSound;
	}
	public void setFullNameSound(String fullNameSound) {
		this.fullNameSound = fullNameSound;
	}
	public String getFullNameSoundSansSW() {
		return fullNameSoundSansSW;
	}
	public void setFullNameSoundSansSW(String fullNameSoundSansSW) {
		this.fullNameSoundSansSW = fullNameSoundSansSW;
	}
	public Integer getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	@Override
	public String toString() {
		return "Customer_customernew [id=" + id + ", uniqueRefNo=" + uniqueRefNo + ", entityType=" + entityType
				+ ", focusType=" + focusType + ", actualName=" + actualName + ", fullName=" + fullName
				+ ", fullNameMeta=" + fullNameMeta + ", fullNameSansSW=" + fullNameSansSW + ", fullNameMetaSansSW="
				+ fullNameMetaSansSW + ", countryToken=" + countryToken + ", idRegDoc=" + idRegDoc + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", translate=" + translate + ", textlanguage="
				+ textlanguage + ", fullNameSound=" + fullNameSound + ", fullNameSoundSansSW=" + fullNameSoundSansSW
				+ ", yearOfBirth=" + yearOfBirth + "]";
	}
	
	
}
