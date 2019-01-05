package boot_jpa_listopad.JsonPlaceHolderRestClient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Profile("dev")
@Slf4j
public class JsonPlaceHolderUserServiceMock implements JsonPlaceHolderUserService {

	@Override
	public List<JsonPlaceHolderUser> getJsonPlaceHolderUser() {
		JsonPlaceHolderUser mockUser = new JsonPlaceHolderUser();
		mockUser.setEmail("mockEmail");
		mockUser.setId(1L);
		mockUser.setName("MockName");
		mockUser.setUsername("MockUserName");
	    ArrayList<JsonPlaceHolderUser> al= new ArrayList<JsonPlaceHolderUser>();
	    al.add(mockUser);
	    log.info("============== Mock Rest Service get returns: "+al.toString());
	    return al;
	}

	@Override
	public JsonPlaceHolderPostDTO setPost(JsonPlaceHolderPostDTO jsonPlaceHolderPostDTO) {
		log.info("============= mock rest service post. returns: "+jsonPlaceHolderPostDTO.toString());
		return jsonPlaceHolderPostDTO;
	}

}
