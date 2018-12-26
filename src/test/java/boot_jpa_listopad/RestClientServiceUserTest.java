package boot_jpa_listopad;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

import org.hamcrest.*;
import org.hamcrest.core.IsNot;
import org.junit.Before;

import boot_jpa_listopad.JsonPlaceHolderRestClient.JsonPlaceHolderUserServiceImpl;
import lombok.extern.slf4j.Slf4j;


//czy musze tego runnera uzyc, skoro nie korzytam z autowired?
//@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class RestClientServiceUserTest {

	
	private JsonPlaceHolderUserServiceImpl service;
	
	
	@Before
	public void setUp() {
		service = new JsonPlaceHolderUserServiceImpl();
	}
	
	@Test
	public void testGetJsonPlaceHolderUser() {
		
	//zmienic na assercje z hamcresta	
		log.info("======================== "+service.getJsonPlaceHolderUser().toString());
		assertNotNull(service.getJsonPlaceHolderUser());
	}

}
