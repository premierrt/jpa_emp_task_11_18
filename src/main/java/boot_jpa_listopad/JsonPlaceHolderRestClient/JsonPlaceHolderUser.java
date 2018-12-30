package boot_jpa_listopad.JsonPlaceHolderRestClient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class JsonPlaceHolderUser {

	private Long id;
	private String name;
	private String username;
	private String email;
	
	
	
}
