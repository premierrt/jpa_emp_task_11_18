package boot_jpa_listopad.profile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

	@Value("${zmienna_profilowa}")
	private String profileVariable;
	
	@GetMapping("/profile")
	String getProfileTestVariable(){
		return profileVariable; 
	}
}
