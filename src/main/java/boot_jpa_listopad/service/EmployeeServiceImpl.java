package boot_jpa_listopad.service;

import java.util.Collection;
import java.util.List;

import org.aspectj.weaver.patterns.IfPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot_jpa_listopad.model.Employee;
import boot_jpa_listopad.model.Task;
import boot_jpa_listopad.repository.EmployeeRepository;
import boot_jpa_listopad.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository empRepo;
	private TaskRepository taskRepo;
	
	
	
	@Autowired
	public  EmployeeServiceImpl(EmployeeRepository empRep, TaskRepository tRepo) {
			empRepo= empRep;
			taskRepo=tRepo;
	}
	
	@Override
	public List<Employee> getEmployees() {
		log.info("===========findAll");
		return empRepo.findAll();
	}

	@Override
	public Employee save(Employee newEmployee) {
		log.info("=======save");
		empRepo.save(newEmployee);
		return newEmployee;
	}

	@Override
	/**
	 * dodaje wybranego taska do emp - dodac test do tego
	 */
	public Employee addTaskToEmp(Employee emp, Task task) {
		
		//https://stackoverflow.com/questions/49316751/spring-data-jpa-findone-change-to-optional-how-to-use-this
		
		emp.getTasks().add(task);
		log.info("dodaje " +task.toString() + " i cala lista "+ emp.getTasks().toString() );
		empRepo.save(emp);
		
		return emp;
	}

	@Override
	public Employee addTaskToEmp(Long emp_id, Long task_id) {
		// TODO Auto-generated method stub
				Employee dbEmp= empRepo.findById(emp_id).orElse(null);
				log.info("update emp id: " + dbEmp.getId());
				
				Task task= taskRepo.findById(task_id).orElse(null);
				
				return addTaskToEmp(dbEmp, task);
				
	}



	
	
}
