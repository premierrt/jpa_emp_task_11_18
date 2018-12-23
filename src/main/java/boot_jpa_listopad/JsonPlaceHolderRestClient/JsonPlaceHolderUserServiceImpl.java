package boot_jpa_listopad.JsonPlaceHolderRestClient;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JsonPlaceHolderUserServiceImpl implements JsonPlaceHolderUserService{

	@Override
	public List<JsonPlaceHolderUser> getJsonPlaceHolderUser() {

		//https://www.baeldung.com/spring-rest-template-list
		RestTemplate rt = new RestTemplate();
		//przeniesc do propertisow
		
		ResponseEntity<List<JsonPlaceHolderUser> > response = rt.exchange("https://jsonplaceholder.typicode.com/users",  HttpMethod.GET,
  null,
  new ParameterizedTypeReference<List<JsonPlaceHolderUser>>(){});;
		
	//	JsonPlaceHolderUserList list =  rt.getForObject("https://jsonplaceholder.typicode.com/users",JsonPlaceHolderUserList.class);
		// return list.getJsonPlaceHolderUserlist();
  
	List<JsonPlaceHolderUser> list = response.getBody()	;
	return list;
  
	}

}
