package boot_jpa_listopad.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot_jpa_listopad.model.Employee;
import boot_jpa_listopad.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository empRepo;
	
	@Autowired
	public  EmployeeServiceImpl(EmployeeRepository empRep) {
			empRepo= empRep;
	}
	
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	
}
