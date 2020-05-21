package risknucleus.aml.watchlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WATCHLIST_FUNCTION_SETUP")
public class Watchlist_functionsetup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name= "Function_Name")
	private String functionName;
	
	@Column(name= "Function_Key")
	private String functionKey;
	
	@Column(name= "Function_Format")
	private String functionFormat;
	
	@Column(name= "FUNCTIONDISPLAYNAME")
	private String functionDisplayName;
	
	@Column(name= "status")
	private String status;
	
	@Column(name= "No_Of_Argument")
	private int noOfArgument;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionKey() {
		return functionKey;
	}

	public void setFunctionKey(String functionKey) {
		this.functionKey = functionKey;
	}

	public String getFunctionFormat() {
		return functionFormat;
	}

	public void setFunctionFormat(String functionFormat) {
		this.functionFormat = functionFormat;
	}

	public String getFunctionDisplayName() {
		return functionDisplayName;
	}

	public void setFunctionDisplayName(String functionDisplayName) {
		this.functionDisplayName = functionDisplayName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNoOfArgument() {
		return noOfArgument;
	}

	public void setNoOfArgument(int noOfArgument) {
		this.noOfArgument = noOfArgument;
	}

	public Watchlist_functionsetup(int id, String functionName, String functionKey, String functionFormat,
			String functionDisplayName, String status, int noOfArgument) {
		super();
		this.id = id;
		this.functionName = functionName;
		this.functionKey = functionKey;
		this.functionFormat = functionFormat;
		this.functionDisplayName = functionDisplayName;
		this.status = status;
		this.noOfArgument = noOfArgument;
	}
	
	public Watchlist_functionsetup() {
		
	}

	@Override
	public String toString() {
		return "Watchlist_functionsetup [id=" + id + ", functionName=" + functionName + ", functionKey=" + functionKey
				+ ", functionFormat=" + functionFormat + ", functionDisplayName=" + functionDisplayName + ", status="
				+ status + ", noOfArgument=" + noOfArgument + "]";
	}

}
