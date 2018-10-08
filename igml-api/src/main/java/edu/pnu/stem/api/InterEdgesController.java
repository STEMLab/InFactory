package edu.pnu.stem.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.pnu.stem.api.exception.UndefinedDocumentException;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.dao.InterEdgesDAO;
import edu.pnu.stem.feature.InterEdges;

@RestController
@RequestMapping("/documents/{docId}/interedges")
public class InterEdgesController {
	@Autowired
    private ApplicationContext applicationContext;
	
	@PostMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createInterEdges(@PathVariable("docId") String docId,@PathVariable("id") String id, @RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {
		String parentId = json.get("parentId").asText().trim();
		String name = null;
		String description = null;
		List<String> interlayerconnection = null;

		
		if(id == null || id.isEmpty()) {
			id = UUID.randomUUID().toString();
		}
		
		if(json.has("properties")) {
			if(json.get("properties").has("name")) {
				name = json.get("properties").get("name").asText().trim();
			}
			if(json.get("properties").has("description")) {
				description = json.get("properties").get("description").asText().trim();
			}
			
			if(json.get("properties").has("interLayerConnection")){
				interlayerconnection = new ArrayList<String>();
				JsonNode partialBoundedByList = json.get("properties").get("interLayerConnection");
				for(int i = 0 ; i < partialBoundedByList.size() ; i++){
					interlayerconnection.add(partialBoundedByList.get(i).asText().trim());
				}
			}
		}
		
		
		InterEdges mg;
		
		
		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);
			mg = InterEdgesDAO.createInterEdges(map, parentId, id, name, description, interlayerconnection);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
		response.setHeader("Location", request.getRequestURL().append(mg.getId()).toString());
	}
}
