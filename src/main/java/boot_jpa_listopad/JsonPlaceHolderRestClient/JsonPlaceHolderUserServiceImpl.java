package boot_jpa_listopad.JsonPlaceHolderRestClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JsonPlaceHolderUserServiceImpl implements JsonPlaceHolderUserService{

	@Value("${restserver.url}")
	private String url;
	
	@Override
	public List<JsonPlaceHolderUser> getJsonPlaceHolderUser() {

		//https://www.baeldung.com/spring-rest-template-list
		RestTemplate rt = new RestTemplate();		
		ResponseEntity<List<JsonPlaceHolderUser> > response = rt.exchange(url,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<JsonPlaceHolderUser>>(){});
  
	List<JsonPlaceHolderUser> list = response.getBody()	;
	return list;
  
	}

}
