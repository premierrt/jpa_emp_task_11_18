package boot_jpa_listopad.JsonPlaceHolderRestClient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class JsonPlaceHolderPostDTO {

	private Long id;
	private String title;
	private String body;
	private Long userId;
}
