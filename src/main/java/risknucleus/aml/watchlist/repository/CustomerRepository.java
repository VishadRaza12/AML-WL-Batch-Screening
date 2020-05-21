package risknucleus.aml.watchlist.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import risknucleus.aml.watchlist.model.Customer_customernew;
@Repository
public interface CustomerRepository extends JpaRepository<Customer_customernew,Integer> {



//	@Query(value="SELECT * FROM Customer_customernew where createdDate = subdate(current_date, 1) or updatedDate = subdate(current_date, 1) ", nativeQuery = true)
//	List<Customer_customernew> getList();
	
	
	@Query(value="select * from CUSTOMER_CUSTOMERNEW c join SERVICE_SERVICEPOOL s on c.uniquerefno = s.fixedref where s.status= 'I' and s.serviceflag='A' ", nativeQuery = true)
	List<Customer_customernew> getCustomerRecords();
	
	@Query(value="select * from CUSTOMER_CUSTOMERNEW c join SERVICE_SERVICEPOOL s on c.uniquerefno = s.fixedref where s.status= 'I' and s.serviceflag='D'", nativeQuery = true)
	List<Customer_customernew> getCustomerRecordsDifferential();

}
