package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boot_jpa_listopad.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
