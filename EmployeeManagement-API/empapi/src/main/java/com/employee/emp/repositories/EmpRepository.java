package com.employee.emp.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.employee.emp.daos.EmployeeDao;



public interface EmpRepository extends JpaRepository<EmployeeDao, UUID>  {

	Optional<EmployeeDao> findByCompanyEmail(String email);
	
	
	@Query(value="select * from employee e where e.firstname like %:keyword% or e.lastname like %:keyword% or e.companyemail like %:keyword% or e.id like %:keyword%", nativeQuery = true)
	List<EmployeeDao> findByKeyword(@Param("keyword") String keyword);
}
