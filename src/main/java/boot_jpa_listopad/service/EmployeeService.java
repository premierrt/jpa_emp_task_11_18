package boot_jpa_listopad.service;

import java.util.List;

import boot_jpa_listopad.model.Employee;
import boot_jpa_listopad.model.Task;

public interface EmployeeService {
	public List<Employee> getEmployees();
	
	public Employee save(Employee newEmployee);
	
	public Employee addTaskToEmp(Employee emp, Task task);

}
