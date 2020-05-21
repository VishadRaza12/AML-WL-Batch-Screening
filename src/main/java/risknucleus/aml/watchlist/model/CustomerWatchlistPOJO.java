package risknucleus.aml.watchlist.model;

public class CustomerWatchlistPOJO {

	private WatchlistListNew listNew;
	private Customer_customernew customer;
	
	
	public CustomerWatchlistPOJO() {}
	public CustomerWatchlistPOJO(WatchlistListNew listNew, Customer_customernew customer) {
		super();
		this.listNew = listNew;
		this.customer = customer;
	}
	public WatchlistListNew getListNew() {
		return listNew;
	}
	public void setListNew(WatchlistListNew listNew) {
		this.listNew = listNew;
	}
	public Customer_customernew getCustomer() {
		return customer;
	}
	public void setCustomer(Customer_customernew customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerWatchlistPOJO [listNew=" + listNew + ", customer=" + customer + "]";
	}
	
	
}
