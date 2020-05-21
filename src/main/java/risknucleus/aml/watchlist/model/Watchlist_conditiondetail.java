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
@Table(name = "WATCHLIST_CONDITION_DETAIL")

public class Watchlist_conditiondetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Integer Id;
	
	@Column(name= "ParentID")
	private Integer parentID;
	
	@ManyToOne
	@JoinColumn(name= "Condition_ID" , referencedColumnName= "id")
	private Watchlist_condition watchlist_condition;
		
	@Column(name= "LEVELCHILD_ID")
	private String levelchildID;
	
	@Column(name= "LEVEL_ID")
	private String levelID;
	
//	@ManyToOne
//	@JoinColumn(name= "ACTIONID" , referencedColumnName="Id" )
//	private Watchlist_showaction showaction;
	
	@Column(name= "ACTIONID")
	private Integer actionID;
	
//	@ManyToOne
//	@JoinColumn(name= "FUNCTIONID" , referencedColumnName="id")
//	private Watchlist_functionsetup functionsetup;
	
	@Column(name= "FUNCTIONID")
	private Integer  functionID;
	
//	@ManyToOne
//	@JoinColumn(name= "OPERATORID", referencedColumnName="Id")
//	private Watchlist_operator operator;
	
	@Column(name= "OPERATORID")
	private Integer  operatorID;
	
	@Column(name= "INPUTID")
	private String inputID;
	
//	@ManyToOne
//	@JoinColumn(name= "TABLEID", referencedColumnName="id")
//	private Watchlist_tablesetup tablesetup;
	
	@Column(name= "TABLEID")
	private Integer tableID;
	
//	@ManyToOne
//	@JoinColumn(name= "ColumnID", referencedColumnName="id")
//	private Watchlist_columnsetup watchlist_columnsetup;
	
	@Column(name= "COLUMNID")
	private Integer columnID;
	
	@Column(name= "status")
	private String status;

	public Watchlist_conditiondetail() {}

	public Watchlist_conditiondetail(Integer id, Integer parentID, Watchlist_condition watchlist_condition,
			String levelchildID, String levelID, Integer actionID, Integer functionID, Integer operatorID,
			String inputID, Integer tableID, Integer columnID, String status) {
		super();
		Id = id;
		this.parentID = parentID;
		this.watchlist_condition = watchlist_condition;
		this.levelchildID = levelchildID;
		this.levelID = levelID;
		this.actionID = actionID;
		this.functionID = functionID;
		this.operatorID = operatorID;
		this.inputID = inputID;
		this.tableID = tableID;
		this.columnID = columnID;
		this.status = status;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public Watchlist_condition getWatchlist_condition() {
		return watchlist_condition;
	}

	public void setWatchlist_condition(Watchlist_condition watchlist_condition) {
		this.watchlist_condition = watchlist_condition;
	}

	public String getLevelchildID() {
		return levelchildID;
	}

	public void setLevelchildID(String levelchildID) {
		this.levelchildID = levelchildID;
	}

	public String getLevelID() {
		return levelID;
	}

	public void setLevelID(String levelID) {
		this.levelID = levelID;
	}

	public Integer getActionID() {
		return actionID;
	}

	public void setActionID(Integer actionID) {
		this.actionID = actionID;
	}

	public Integer getFunctionID() {
		return functionID;
	}

	public void setFunctionID(Integer functionID) {
		this.functionID = functionID;
	}

	public Integer getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(Integer operatorID) {
		this.operatorID = operatorID;
	}

	public String getInputID() {
		return inputID;
	}

	public void setInputID(String inputID) {
		this.inputID = inputID;
	}

	public Integer getTableID() {
		return tableID;
	}

	public void setTableID(Integer tableID) {
		this.tableID = tableID;
	}

	public Integer getColumnID() {
		return columnID;
	}

	public void setColumnID(Integer columnID) {
		this.columnID = columnID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
