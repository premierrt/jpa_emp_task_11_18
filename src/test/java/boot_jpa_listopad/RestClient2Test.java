package boot_jpa_listopad;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import boot_jpa_listopad.JsonPlaceHolderRestClient.JsonPlaceHolderUserService;
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
 * @author rafal
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RestClient2Test {

	@Autowired
	private JsonPlaceHolderUserService jsonPlaceHolderUserService;
	
	
//	@Before
//	public void setUp() {
//		service = new JsonPlaceHolderUserServiceImpl();
//	}
	
	@Test
	public void testGetJsonPlaceHolderUser() {
		
	//zmienic na assercje z hamcresta	
		log.info("======================== "+jsonPlaceHolderUserService.getJsonPlaceHolderUser().toString());
		assertNotNull(jsonPlaceHolderUserService.getJsonPlaceHolderUser());
	}
	
	

}