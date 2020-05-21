package risknucleus.aml.watchlist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WATCHLIST_TABLE_SETUP")
public class Watchlist_tablesetup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name= "Table_Name")
	private String tableName;
	
	@Column(name= "Table_Key")
	private String tableKey;
	
	@Column(name= "TABLEDISPLAYNAME")
	private String tableDisplayName;
	
	@Column(name= "status")
	private String status;
	
//	@Column(name= "model")
//	private String model;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableKey() {
		return tableKey;
	}

	public void setTableKey(String tableKey) {
		this.tableKey = tableKey;
	}

	public String getTableDisplayName() {
		return tableDisplayName;
	}

	public void setTableDisplayName(String tableDisplayName) {
		this.tableDisplayName = tableDisplayName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Watchlist_tablesetup() {
		
	}

	public Watchlist_tablesetup(int id, String tableName, String tableKey, String tableDisplayName, String status,
			String model) {
		super();
		this.id = id;
		this.tableName = tableName;
		this.tableKey = tableKey;
		this.tableDisplayName = tableDisplayName;
		this.status = status;
		//this.model = model;
	}

//	public String getModel() {
//		return model;
//	}
//
//	public void setModel(String model) {
//		this.model = model;
//	}

//	@Override
//	public String toString() {
//		return "Watchlist_tablesetup [id=" + id + ", tableName=" + tableName + ", tableKey=" + tableKey
//				+ ", tableDisplayName=" + tableDisplayName + ", status=" + status + ", model=" + model + "]";
//	}


	
	
	
}


