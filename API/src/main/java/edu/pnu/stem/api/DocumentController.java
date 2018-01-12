package edu.pnu.stem.api;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.pnu.stem.api.exception.DuplicatedFeatureException;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.binder.Mashaller;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;

@RestController
@RequestMapping("/document")
public class DocumentController {
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@PostMapping(value = "/", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createDocument(@RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {
		String id = json.get("id").asText().trim();
		
		if(id == null || id.isEmpty()) {
			id = UUID.randomUUID().toString();
		}
		
		Container container = applicationContext.getBean(Container.class);
		
		IndoorGMLMap map = container.getDocument(id);
		if(map != null) {
			//Exception
			throw new DuplicatedFeatureException();
		} else {
			map = container.createDocument(id);
		}

	    response.setHeader("Location", request.getRequestURL().append(map.getDocId()).toString());
	}
	
	@GetMapping(value = "/", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void getDocument(@RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {
		String id = json.get("id").asText().trim();

		Container container = applicationContext.getBean(Container.class);
		IndoorGMLMap map = container.getDocument(id);
		
		
		IndoorFeaturesType resultDoc = edu.pnu.stem.binder.Convert2JaxbClass.change2JaxbClass("testDoc",featureDoc);
		Mashaller.marshalIndoorFeatures("temp/" + id, resultDoc);
	}
}
