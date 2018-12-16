package boot_jpa_listopad.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import boot_jpa_listopad.model.Employee;
import boot_jpa_listopad.service.EmployeeServiceImpl;

@RestController
public class EmployeeControler {

	private EmployeeServiceImpl empService;
	
	
	//https://spring.io/guides/tutorials/rest/
	//https://www.restapitutorial.com/lessons/httpmethods.html
	
	@Autowired
	public  EmployeeControler(EmployeeServiceImpl empSer) {
		empService=empSer;
	}
	
	@GetMapping("/emps")
	public List<Employee> getEmployessService(){
		return  empService.getEmployees();
	}
	
	
	// !!!!! dopisać wywołania curla do tworzenia 
	@PostMapping("/emps")
	//The @RequestBody method parameter annotation should bind the json value in the HTTP request body to the java object by using a HttpMessageConverter.
	public Employee newEmployee(@RequestBody Employee newEmployee){
		return empService.save(newEmployee);
		
	}
	
	@GetMapping("/dupa")
	public String getNapis(){
		return "dupa";
	}
	
	@PatchMapping("/emp/{emp_id}/task/{task_id}")
	public ResponseEntity<?> addTaskToEmp(@PathVariable("emp_id") Long emp_id, @PathVariable("task_id") Long task_id){
		
		Employee updateEmp = empService.addTaskToEmp(emp_id, task_id);
		return ResponseEntity.ok().body(updateEmp);
	}
}
