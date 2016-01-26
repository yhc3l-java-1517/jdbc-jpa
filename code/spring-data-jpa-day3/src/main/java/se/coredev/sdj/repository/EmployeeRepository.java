package se.coredev.sdj.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import se.coredev.sdj.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{

	List<Employee> findByFirstName(String firstName);
	List<Employee> findByLastNameContaining(String value);
	List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
	Long countByLastName(String lastName);
	
	List<Employee> findByAddressStreet(String street);
	
	@Transactional
	List<Employee> removeByLastName(String lastName);
	
//	Page<Employee> findByLastNameLike(String lastName, Pageable pageable);
	Slice<Employee> findByLastNameLike(String lastName, Pageable pageable);
	
//	List<Employee> getByNumber(String number);
	
//	@Query("select e from Employee e where e.employeeNumber = ?1")
	@Query("select e from #{#entityName} e where e.employeeNumber = ?1")
	List<Employee> getByNumber(String number);
}

















