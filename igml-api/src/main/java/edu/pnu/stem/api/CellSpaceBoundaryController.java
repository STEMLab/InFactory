/**
 * 
 */
package edu.pnu.stem.api;

import java.io.IOException;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.pnu.stem.api.exception.UndefinedDocumentException;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.dao.CellSpaceBoundaryDAO;
import edu.pnu.stem.feature.CellSpaceBoundary;

/**
 * @author Hyung-Gyu Ryoo (hyunggyu.ryoo@gmail.com, Pusan National University)
 *
 */
@RestController
@RequestMapping("/cellspaceboundary")
public class CellSpaceBoundaryController {
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@PostMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createSpaceLayer(@PathVariable("id") String id, @RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {
		String docId = json.get("docId").asText().trim();
		String parentId = json.get("parentId").asText().trim();
		String geomFormatType = "GEOJSON";
		String geom = json.get("geometry").asText().trim();
		final ObjectMapper mapper = new ObjectMapper();
		String duality = null;
		JsonNode geometry = null;
		
		if(id == null || id.isEmpty()) {
			id = UUID.randomUUID().toString();
		}
		
		try{			
			 mapper.readTree(geom);
			 geometry = json.get("geometry");
		}
		catch (IOException e){
			geomFormatType = "WKT";
		}
		
		if(json.has("duality")){
			duality = json.get("duality").asText().trim();
		}
		CellSpaceBoundary c = null;
		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);
			if(geomFormatType.equals("GEOJSON")){
				c = CellSpaceBoundaryDAO.createCellSpaceBoundary(map, parentId, id, geometry, duality);
			}
			else if(geomFormatType.equals("WKT")){
				c = CellSpaceBoundaryDAO.createCellSpaceBoundary(map, parentId, id, geom, duality);
			}
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
		response.setHeader("Location", request.getRequestURL().append(c.getId()).toString());
	}
	
}
