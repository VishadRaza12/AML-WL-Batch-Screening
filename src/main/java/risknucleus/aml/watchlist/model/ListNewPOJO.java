package risknucleus.aml.watchlist.model;

public class ListNewPOJO {

	private Integer id;
	private String value1;
	private String value2;
	private int type;
	private String operator;
	private int input;
	
	
	public ListNewPOJO() {}
	
	

	public ListNewPOJO(Integer id, String value1, String value2, int type, String operator, int input) {
		super();
		this.id = id;
		this.value1 = value1;
		this.value2 = value2;
		this.type = type;
		this.operator = operator;
		this.input = input;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}



	public String getOperator() {
		return operator;
	}



	public void setOperator(String operator) {
		this.operator = operator;
	}



	public int getInput() {
		return input;
	}



	public void setInput(int input) {
		this.input = input;
	}
	
	
	
	
}
