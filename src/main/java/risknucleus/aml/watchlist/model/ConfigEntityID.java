package risknucleus.aml.watchlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIG_WATCHLISTENTITY")
public class ConfigEntityID {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "EntityID")
	private Integer id;
	
	@Column(name= "ENTITYKEY")
	private String entityKey;
	
	@Column(name= "ENTITYNAME")
	private String entityName;
	
	@Column(name= "KEYID")
	private String keyId;
	
	@Column(name= "KEYFOR")
	private String keyFor;
	
	@Column(name= "Status")
	private String status;

	
	public ConfigEntityID() {}
	
	public ConfigEntityID(Integer id, String entityKey, String entityName, String keyId, String keyFor, String status) {
		super();
		this.id = id;
		this.entityKey = entityKey;
		this.entityName = entityName;
		this.keyId = keyId;
		this.keyFor = keyFor;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEntityKey() {
		return entityKey;
	}

	public void setEntityKey(String entityKey) {
		this.entityKey = entityKey;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getKeyFor() {
		return keyFor;
	}

	public void setKeyFor(String keyFor) {
		this.keyFor = keyFor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
