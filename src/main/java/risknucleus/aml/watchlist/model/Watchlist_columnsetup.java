package risknucleus.aml.watchlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WATCHLIST_COLUMN_SETUP")
public class Watchlist_columnsetup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Integer id;
	
	@Column(name= "Column_Name")
	private String columnName;
	
	@Column(name= "Column_Key")
	private String columnKey;
	
	@Column(name= "COLTYPE")
	private String colType;
	
	@Column(name= "TABLEID")
	private int tableId;
	
	@Column(name= "COLUMNDISPLAYNAME")
	private String columnDisplayName;
	
	@Column(name= "status")
	private String status;

//	@Column(name="propety")
//	private String property;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getColType() {
		return colType;
	}

	public void setColType(String colType) {
		this.colType = colType;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getColumnDisplayName() {
		return columnDisplayName;
	}

	public void setColumnDisplayName(String columnDisplayName) {
		this.columnDisplayName = columnDisplayName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public Watchlist_columnsetup() {
		
	}

	public Watchlist_columnsetup(Integer id, String columnName, String columnKey, String colType, int tableId,
			String columnDisplayName, String status, String property) {
		super();
		this.id = id;
		this.columnName = columnName;
		this.columnKey = columnKey;
		this.colType = colType;
		this.tableId = tableId;
		this.columnDisplayName = columnDisplayName;
		this.status = status;
	//	this.property = property;
	}

//	public String getProperty() {
//		return property;
//	}
//
//	public void setProperty(String property) {
//		this.property = property;
//	}

//	@Override
//	public String toString() {
//		return "Watchlist_columnsetup [id=" + id + ", columnName=" + columnName + ", columnKey=" + columnKey
//				+ ", colType=" + colType + ", tableId=" + tableId + ", columnDisplayName=" + columnDisplayName
//				+ ", status=" + status + ", property=" + property + "]";
//	}
//	
	
}
