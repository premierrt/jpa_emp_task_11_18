package boot_jpa_listopad.JsonPlaceHolderRestClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceHolderClientController {

	@Autowired
	private JsonPlaceHolderUserService jsonPlaceHolderUserService;
	
	@GetMapping("/client")
	public List<JsonPlaceHolderUser> getEmpsFromExternalService() {
		return jsonPlaceHolderUserService.getJsonPlaceHolderUser();
	}
	
}
