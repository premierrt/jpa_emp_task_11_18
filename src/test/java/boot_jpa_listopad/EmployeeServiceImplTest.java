package boot_jpa_listopad;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import boot_jpa_listopad.model.Employee;
import boot_jpa_listopad.model.Task;
import boot_jpa_listopad.repository.EmployeeRepository;
import boot_jpa_listopad.repository.TaskRepository;
import boot_jpa_listopad.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * https://springframework.guru/mockito-mock-vs-spy-in-spring-boot-tests/
 * https://dzone.com/articles/spring-boot-unit-testing-and-mocking-with-mockito
 * @author rafal
 *
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

	//mock repo
	@Mock
	private EmployeeRepository empRepo;
	
	@Mock
	private TaskRepository taskRepo;

	
	@Mock
	private Employee emp;
	
	@Mock
	private Task task;
 
	//wstrzykniecie wszyskich mockow do serwisu
	@InjectMocks
	private EmployeeServiceImpl empService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddTaskToEmp() {
		
		log.info(" test na mockito emp: " +emp.toString());
		log.info(" test na mockito task: " +task.toString());
		
		//optinal.get
		when(empRepo.findById(1L)).thenReturn(Optional.of(emp));
		//?? optionale???
		when(taskRepo.findById(1L)).thenReturn(Optional.of(task));
		
		Employee updatedEmp= empService.addTaskToEmp(1L, 1L);
		//http://www.vogella.com/tutorials/Hamcrest/article.html
		assertThat(updatedEmp, is(emp));
	}
	
	//dodac test z  wypelnionym danym uzytkonwikiem i taskiem

}
