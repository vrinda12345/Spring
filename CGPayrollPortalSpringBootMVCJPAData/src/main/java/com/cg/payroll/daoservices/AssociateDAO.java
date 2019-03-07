package com.cg.payroll.daoservices;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.payroll.beans.Associate;
public interface AssociateDAO extends JpaRepository<Associate, Integer>{
//	@Query(value="from associate where a.firstName=:name")
//	List<Associate>getAllAssociateDetailsByName(String name);
}