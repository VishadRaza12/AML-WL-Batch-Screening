package risknucleus.aml.watchlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CNFG_FOCUSTYPES")
public class FocusTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FOCUSTYPEID")
	private Integer focusTypeId;

	@Column(name = "FOCUSTYPENAME")
	private String focusTypeName;

	@Column(name = "FOCUSTYPEKEY")
	private String focusTypeKey;

	@Column(name = "STATUS")
	private String status;

	public FocusTypes() {
	}

	public FocusTypes(Integer focusTypeId, String focusTypeName, String focusTypeKey, String status) {
		super();
		this.focusTypeId = focusTypeId;
		this.focusTypeName = focusTypeName;
		this.focusTypeKey = focusTypeKey;
		this.status = status;
	}

	public Integer getFocusTypeId() {
		return focusTypeId;
	}

	public void setFocusTypeId(Integer focusTypeId) {
		this.focusTypeId = focusTypeId;
	}

	public String getFocusTypeName() {
		return focusTypeName;
	}

	public void setFocusTypeName(String focusTypeName) {
		this.focusTypeName = focusTypeName;
	}

	public String getFocusTypeKey() {
		return focusTypeKey;
	}

	public void setFocusTypeKey(String focusTypeKey) {
		this.focusTypeKey = focusTypeKey;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
