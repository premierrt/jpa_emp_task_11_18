package boot_jpa_listopad.service;

import java.util.List;

import boot_jpa_listopad.model.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();
	
	public Employee save(Employee newEmployee);
}
