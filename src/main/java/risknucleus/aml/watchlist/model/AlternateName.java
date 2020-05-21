package risknucleus.aml.watchlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AlternateName")
public class AlternateName {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NameDescription", columnDefinition ="NVARCHAR(200)")
	private String nameDescription;
	
	@Column(name="ALternateNameDescription", columnDefinition ="NVARCHAR(200)")
	private String aLternateNameDescription;
	
	@Column(name="EntityID")
	private Integer entityID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameDescription() {
		return nameDescription;
	}

	public void setNameDescription(String nameDescription) {
		this.nameDescription = nameDescription;
	}

	public String getaLternateNameDescription() {
		return aLternateNameDescription;
	}

	public void setaLternateNameDescription(String aLternateNameDescription) {
		this.aLternateNameDescription = aLternateNameDescription;
	}

	public Integer getEntityID() {
		return entityID;
	}

	public void setEntityID(Integer entityID) {
		this.entityID = entityID;
	}
	
	
	
	
}
