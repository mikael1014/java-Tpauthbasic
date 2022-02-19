package org.mn.tpspringconso.sercives;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.mn.tpspringconso.models.Specialite;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

@Service
public class SpecialiteServiceImpl implements SpecialiteService {
	private final RestTemplate restTemplate = new RestTemplate();
	private final String URL_SPECIALITE = "http://localhost:8082/TpDaoApiTomcat/api/specialite";

	@Override
	public Specialite getById(long id) {
		String URL_SPECIALITE_ID = URL_SPECIALITE+ "/"+ id;
		Specialite specialite = restTemplate.getForObject(URL_SPECIALITE_ID, Specialite.class);		
		return specialite;
	}

	@Override
	public List<Specialite> lister() {
		// TODO Auto-generated method stub
		ResponseEntity<List<Specialite>> responseEntity  = restTemplate.exchange(URL_SPECIALITE,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Specialite>>() {});
		return responseEntity.getBody();
	}

	@Override
	public String ajouter(Specialite specialite) {
		// TODO Auto-generated method stub
		HttpEntity<Specialite> requestBody =new HttpEntity<>(specialite);
		String msg =restTemplate.postForObject(URL_SPECIALITE, requestBody, String.class);
		return msg;
	}

}
