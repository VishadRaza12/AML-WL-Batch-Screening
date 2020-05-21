package risknucleus.aml.watchlist.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATICCONFIGURATION")
public class StaticConfiguration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", length = 18)
	private Integer ID;

	@Column(name = "CODE")
	private String code;

	@Column(name = "VALUE")
	private String value;

	@Column(name = "DESCRIPTION")
	private String description;

	public StaticConfiguration() {
	}

	public StaticConfiguration(Integer iD, String code, String value, String description) {
		super();
		ID = iD;
		this.code = code;
		this.value = value;
		this.description = description;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
