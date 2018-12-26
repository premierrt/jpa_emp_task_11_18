package boot_jpa_listopad;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import boot_jpa_listopad.JsonPlaceHolderRestClient.JsonPlaceHolderUserService;
import boot_jpa_listopad.JsonPlaceHolderRestClient.JsonPlaceHolderUserServiceImpl;
import lombok.extern.slf4j.Slf4j;


/**
 * czy musze tego runnera uzyc, skoro nie korzytam z autowired? 
 * testy powinny byc odpalane bez springa, wiec jeśli bym nie korzystac z autowired to nie potrzeba runnera.
 * Jednak musze skorzystac z url-a, ktory jest w spring.properties. Dlatego potrzebny jest runner i dodatkowo springboottest
 * The @SpringBootTest annotation tells Spring Boot to go and look for a main configuration class (one with @SpringBootApplication for instance), and use that to start a Spring application context. 
 * https://spring.io/guides/gs/testing-web/
 * 
 * dopisac test, ktory bedzie korzystal z propertisow, ktore beda mialy mocka -test.props
 * https://www.logicbig.com/tutorials/spring-framework/spring-core/test-property-source-annotation.html
 * 
 * 
 * ostaecznie zmianione na pole w klasie wstrzyiwane value przez konstruktor
 * https://stackoverflow.com/questions/17353327/populating-spring-value-during-unit-test
 * @author rafal
 *
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
@Slf4j
public class RestClientServiceUserTest {

	//@Autowired
	private JsonPlaceHolderUserService jsonPlaceHolderUserService;
	
	
	@Before
	public void setUp() {
		jsonPlaceHolderUserService = new JsonPlaceHolderUserServiceImpl("https://jsonplaceholder.typicode.com/users");
	}
	
	@Test
	public void testGetJsonPlaceHolderUser() {
		
	//zmienic na assercje z hamcresta	
		log.info("======================== "+jsonPlaceHolderUserService.getJsonPlaceHolderUser().toString());
		assertNotNull(jsonPlaceHolderUserService.getJsonPlaceHolderUser());
	}
	
	

}
