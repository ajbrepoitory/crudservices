package org.ajb.services.rest;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class DataServicesClient {

	static RestTemplate restTemplate;

	public DataServicesClient() {
		restTemplate = new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(DataServicesClient.class, args);

		try {
			JSONObject topstories = getEntity();
			System.out.println(topstories);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * get entity
	 * 
	 * @throws JSONException
	 */
	public static JSONObject getEntity() throws Exception {
		JSONObject topstories = new JSONObject();
		String getUrl = "https://api.nytimes.com/svc/topstories/v2/home.json";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("api-key", "eeac407906bb4ce585778140647f74c7");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Map> bookList = restTemplate.exchange(getUrl, HttpMethod.GET, entity, Map.class);
		if (bookList.getStatusCode() == HttpStatus.OK) {
			topstories = new JSONObject(bookList.getBody());
		}
		return topstories;
	}

}