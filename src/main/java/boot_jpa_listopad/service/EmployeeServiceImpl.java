package boot_jpa_listopad.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot_jpa_listopad.model.Employee;
import boot_jpa_listopad.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository empRepo;
	
	@Autowired
	public  EmployeeServiceImpl(EmployeeRepository empRep) {
			empRepo= empRep;
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

	
	
}
