package risknucleus.aml.watchlist.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import risknucleus.aml.watchlist.model.Servicepool;

public interface ServicepoolRepository extends JpaRepository<Servicepool, Integer> {
	
//	@Modifying sql
//	@Query(value="insert into service.servicepool ( createdon, fixedref, serviceflag, servicelogid, status, focustypeid) select distinct GETDATE(), A.UniqueRefNo , 'A',null,'NS' , A.FocusType from customer.CustomerNew A where A.createddate= dateadd(day,datediff(day,1,GETDATE()),0) or A.updatedDate = dateadd(day,datediff(day,1,GETDATE()),0)", nativeQuery=true)
//	@Transactional
//	public void insertCustomer();
	
	@Modifying
	@Query(value="insert into SERVICE_SERVICEPOOL ( createdon, fixedref, serviceflag, servicelogid, status, focustypeid) select distinct now(), A.UniqueRefNo , 'A',null,'NS' , A.FocusType from CUSTOMER_CUSTOMERNEW A where A.createddate= DATE(NOW() - INTERVAL 1 DAY) or A.updatedDate = DATE(NOW() - INTERVAL 1 DAY)", nativeQuery=true)
	@Transactional
	public void insertCustomer();
	
	//insert into Person (id,name,age) select :id,:name,:age from Dual
	
	
	@Query(value="select t.* from SERVICE_SERVICEPOOL t where t.status= 'NS' and t.serviceflag = 'A'", nativeQuery = true)
	public List<Servicepool> UpdateStatus(Pageable pageable);
	
	@Modifying
	@Query(value= "insert into SERVICE_SERVICEPOOL ( createdon, fixedref, serviceflag, servicelogid, status, focustypeid) select distinct now(), A.UniqueRefNo , 'D',null,'NS' , A.FocusType from CUSTOMER_CUSTOMERNEW A ", nativeQuery= true)
	@Transactional
	public void insertDifferentialCustomer();
	//GETDATE()
	
	@Query(value="select t.* from SERVICE_SERVICEPOOL t where t.status= 'NS' and t.serviceflag = 'D'", nativeQuery = true)
	public List<Servicepool> UpdateStatusDifferential(Pageable pageable);
	
	@Query(value="select count(*) from SERVICE_SERVICEPOOL t where t.status='NS' and t.serviceflag = 'D'", nativeQuery= true)
    public Integer getCount();
	
	@Query(value="select count(*) from SERVICE_SERVICEPOOL t where t.status='NS' and t.serviceflag = 'A'", nativeQuery= true)
    public Integer getIncrementalCount();
	
	@Query(value="select count(*) from SERVICE_SERVICEPOOL t where t.status='NS' and t.serviceflag?=1", nativeQuery= true)
    public Integer getFlagCount(String d);

	
	
	
	//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query("update Alerts a set a.alertScore =:alertScore where a.alertId =:alertId")
//	void updatescore(@Param("alertId") Integer alertId, @Param("alertScore") Integer alertScore);

}
