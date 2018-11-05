package boot_jpa_listopad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boot_jpa_listopad.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
