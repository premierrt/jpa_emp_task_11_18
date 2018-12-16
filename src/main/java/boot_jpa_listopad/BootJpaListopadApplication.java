package boot_jpa_listopad;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import boot_jpa_listopad.model.Employee;
import boot_jpa_listopad.model.Task;
import boot_jpa_listopad.repository.EmployeeRepository;
import boot_jpa_listopad.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class BootJpaListopadApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BootJpaListopadApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	@Transactional // https://grokonez.com/hibernate/use-hibernate-lazy-fetch-eager-fetch-type-spring-boot-mysql
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Employee emp1  = new Employee("Marian", "Padzioch");
		
		Task task1 = new Task("zmywanie garow");
		
		emp1.getTasks().add(task1);
		
		employeeRepository.save(emp1);
		
		
		//na tym testowac kolekcje - albo przeniesc to do testow
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("drzemka"));
		tasks.add(new Task("oranie pola"));
		tasks.add(new Task("wykopki"));
		
		//https://www.mkyong.com/java8/java-8-streams-filter-examples/
		//java 8 str.253
		tasks.forEach(el -> taskRepository.save(el) );
		
		log.info(employeeRepository.findAll().toString());
		log.info(taskRepository.findAll().toString());
	
	}
	
	
}
