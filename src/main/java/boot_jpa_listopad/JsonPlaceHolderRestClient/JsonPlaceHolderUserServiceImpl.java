package boot_jpa_listopad.JsonPlaceHolderRestClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Profile({"prod","default"})
@Slf4j
public class JsonPlaceHolderUserServiceImpl implements JsonPlaceHolderUserService{

	
	private String url;
	
	//
	//ostaecznie zmianione na pole w klasie wstrzyiwane value przez konstruktor
	// https://stackoverflow.com/questions/17353327/populating-spring-value-during-unit-test
	//
	public JsonPlaceHolderUserServiceImpl(@Value("${restserver.url}") String url) {
		this.url=url;
	}
	
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

	@Override
	public JsonPlaceHolderPostDTO setPost(JsonPlaceHolderPostDTO jsonPlaceHolderPostDTO) {
		RestTemplate rt = new RestTemplate();
		//??? co to za klasa httpentinty/
		HttpEntity<JsonPlaceHolderPostDTO> postObject = new HttpEntity<JsonPlaceHolderPostDTO>(jsonPlaceHolderPostDTO);
		JsonPlaceHolderPostDTO returnPostDTO = rt.postForObject(url, postObject, JsonPlaceHolderPostDTO.class);
		log.info("------------------------- "+ returnPostDTO.toString());
		return returnPostDTO;
	}

}
