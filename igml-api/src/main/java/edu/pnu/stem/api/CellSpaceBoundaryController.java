/**
 * 
 */
package edu.pnu.stem.api;

import java.io.IOException;
import java.util.ArrayList;
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
import com.vividsolutions.jts.geom.Geometry;

import edu.pnu.stem.api.exception.UndefinedDocumentException;
import edu.pnu.stem.binder.Convert2Json;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.dao.CellSpaceBoundaryDAO;
import edu.pnu.stem.dao.CellSpaceDAO;
import edu.pnu.stem.feature.CellSpaceBoundary;

/**
 * @author Hyung-Gyu Ryoo (hyunggyu.ryoo@gmail.com, Pusan National University)
 *
 */
@RestController
@RequestMapping("documents/{docId}/cellspaceboundarys")
public class CellSpaceBoundaryController {
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@PostMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createCellSpaceBoundary(@PathVariable("docId") String docId,@PathVariable("id") String id, @RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {
		String parentId = json.get("parentId").asText().trim();
		String geomFormatType = "GEOJSON";
		String geom = json.get("geometry").asText().trim();
		final ObjectMapper mapper = new ObjectMapper();
		String duality = null;
		Geometry geometry = null;
		
		if(id == null || id.isEmpty()) {
			id = UUID.randomUUID().toString();
		}
		
		try{			
			 mapper.readTree(geom);
			 geometry = Convert2Json.json2Geometry(json.get("geometry"));
		}
		catch (IOException e){
			geomFormatType = "WKT";
		}
		
		if(json.has("geometry")) {
			geometry = Convert2Json.json2Geometry(json.get("geometry"));
		}
		
		//TODO : 나중에 고칠 것. 임시로.
		if(json.has("duality")){
			duality = json.get("duality").asText().trim();
		}
		if(json.has("properties")){
			if(json.get("properties").has("duality")){
				duality = json.get("properties").get("duality").asText().trim();
			}
		}
		CellSpaceBoundary c = null;
		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);
			/*
			 * 
			 if(geomFormatType.equals("GEOJSON")){
				c = CellSpaceBoundaryDAO.createCellSpaceBoundary(map, parentId, id, geometry, duality);
			}
			else if(geomFormatType.equals("WKT")){
				c = CellSpaceBoundaryDAO.createCellSpaceBoundary(map, parentId, id, geom, duality);
			}
			 * */
			
			c = CellSpaceBoundaryDAO.createCellSpaceBoundary(map, parentId, id, geometry, duality); 
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
		response.setHeader("Location", request.getRequestURL().append(c.getId()).toString());
	}
	
	
	@PostMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateCellSpaceBoundary(@PathVariable("docId") String docId,@PathVariable("id") String id, @RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {
		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);
			String duality = null;
			JsonNode geometry = null;
			Geometry geom = null;
			String parentId = null;
			String name = null;
			String description = null;

			if(json.has("parentId")) {
				parentId = json.get("parentId").asText().trim();
			}
			
			if(json.has("duality")){
				
				duality = json.get("duality").asText().trim();
				
			}
			if(json.has("properties")){
				if(json.get("properties").has("duality")){
					duality = json.get("properties").get("duality").asText().trim();
					
				}
				
			}
			if(json.has("geometry")) {
				geometry = json.get("geometry");
				geom = Convert2Json.json2Geometry(geometry);
			
			}
			
			if(json.has("properties")){
				if(json.get("properties").has("name")) {
					name = json.get("properties").get("name").asText().trim();
				}
				if(json.get("properties").has("description")) {
					description = json.get("properties").get("description").asText().trim();
				}
			}
			
			CellSpaceBoundaryDAO.updateCellSpaceBoundary(map, parentId, id, name, description, geom, duality);
		}
		catch(NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
	}
	
	public void getCellSpaceBoundary() {}
	
	public void getCellSpaceBoundarys() {}
	
}
