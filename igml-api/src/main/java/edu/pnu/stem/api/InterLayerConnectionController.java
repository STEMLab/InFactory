package edu.pnu.stem.api;

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
import edu.pnu.stem.dao.InterLayerConnectionDAO;
import edu.pnu.stem.dao.TransitionDAO;
import edu.pnu.stem.feature.InterLayerConnection;


@RestController
@RequestMapping("/documents/{docId}/interlayerconnection")
public class InterLayerConnectionController {
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@PostMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createInterLayerConnection(@PathVariable("docId") String docId,@PathVariable("id") String id, @RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {
		String parentId = json.get("parentId").asText().trim();
		String name = null;
		String description = null;
		
		String comment = null;
		String typeOfTopoExpression = null;
		
		String[] interConnects = null;
		String[] connectedLayers = null;
		
		List<String> spacelayers = null;
		List<String> interedges = null;
		
		InterLayerConnection ilc;
		
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
			if(json.get("properties").has("comment")) {
				comment = json.get("properties").get("comment").asText().trim();
			}
			if(json.get("properties").has("interConnects")){
				JsonNode connectsNode = json.get("properties").get("interConnects");
				if(connectsNode.isArray()) {
					interConnects = new String[2];
					interConnects[0] = connectsNode.get(0).asText().trim();
					interConnects[1] = connectsNode.get(1).asText().trim();
				}
			}
			if(json.get("properties").has("connectedLayers")){
				JsonNode connectsNode = json.get("properties").get("connectedLayers");
				if(connectsNode.isArray()) {
					connectedLayers = new String[2];
					connectedLayers[0] = connectsNode.get(0).asText().trim();
					connectedLayers[1] = connectsNode.get(1).asText().trim();
				}
			}
			
		}
		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);
			ilc = InterLayerConnectionDAO.createInterLayerConnection(map, parentId, id, name, description, typeOfTopoExpression, comment, interConnects, connectedLayers);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
		response.setHeader("Location", request.getRequestURL().append(ilc.getId()).toString());
	}

}
