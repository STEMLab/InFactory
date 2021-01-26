/**
 * 
 */
package edu.pnu.stem.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.locationtech.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.pnu.stem.api.exception.UndefinedDocumentException;
import edu.pnu.stem.binder.Convert2Json;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.dao.TransitionDAO;
import edu.pnu.stem.feature.core.Transition;

/**
 * @author Hyung-Gyu Ryoo (hyunggyu.ryoo@gmail.com, Pusan National University)
 *
 */
@RestController
@RequestMapping("/documents/{docId}/transition")
public class TransitionController {
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@PostMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createSpaceLayer(@PathVariable("docId") String docId,@PathVariable("id") String id, @RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {

		String parentId = json.get("parentId").asText().trim();
		String name = null;
		String description = null;
		double weight = 0;
		String[] connects = null;
		
		String duality = null;
		String geom = json.get("geometry").asText().trim();
	
		Transition t;
		Geometry geometry = null;

		
		if(id == null || id.isEmpty()) {
			id = UUID.randomUUID().toString();
		}
		
		
		if(json.has("properties")){
			if(json.get("properties").has("connects")){
				connects = new String[2];
				connects[0] = json.get("properties").get("connects").get(0).asText().trim();
				connects[1] = json.get("properties").get("connects").get(1).asText().trim();
			}
			if(json.get("properties").has("duality")){
				duality = json.get("properties").get("duality").asText().trim();
			}
			
			if(json.get("properties").has("name")) {
				name = json.get("properties").get("name").asText().trim();
			}
			
			if(json.get("properties").has("description")) {
				description = json.get("properties").get("description").asText().trim();
			}
			
			if(json.get("properties").has("weight")) {
				weight = json.get("properties").get("weight").asDouble();
			}
		}
		if(json.has("connects")){
			JsonNode connectsNode = json.get("connects");
			if(connectsNode.isArray()) {
				connects[0] = connectsNode.get(0).asText().trim();
				connects[1] = connectsNode.get(1).asText().trim();
			}
		}
		
		if(json.has("geometry")) {
			geometry = Convert2Json.json2Geometry(json.get("geometry"));
		}

		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);
			t = TransitionDAO.createTransition(map, parentId, id, name, description, geometry, duality, connects, weight);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
		response.setHeader("Location", request.getRequestURL().append(t.getId()).toString());
	}
	
	@PutMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateTransition(@PathVariable("docId") String docId,@PathVariable("id") String id, @RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {
		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);
			String duality = null;
			JsonNode geometry = null;
			List<String> connects = null;
			Geometry geom = null;
			String parentId = null;
			String name = null;
			String description = null;
			String[] arrConnects = null;
			double weight = 0;
			
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
				
				if(json.get("properties").has("weight")){
					weight = json.get("properties").get("weight").asDouble();		
				}
				
			}
			if(json.has("geometry")) {
				geometry = json.get("geometry");
				geom = Convert2Json.json2Geometry(geometry);
			
			}
			
			//TODO: fix it later
			//String properties = json.get("properties").asText().trim();
			//String duality = null;
			
			if(json.has("properties")){
				if(json.get("properties").has("connects")){
					connects = new ArrayList<String>();
					JsonNode partialBoundedByList = json.get("properties").get("connects");
					for(int i = 0 ; i < partialBoundedByList.size() ; i++){
						connects.add(partialBoundedByList.get(i).asText().trim());
					}
					arrConnects = new String[2];
					connects.toArray(arrConnects);
				}

				
			}
			
			
		TransitionDAO.updateTransition(map, parentId, id, name, description, geom, duality, arrConnects);
			
		}
		catch(NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
	}
	@GetMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.FOUND)
	public void getTransition(@PathVariable("docId") String docId,@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);
			
			ObjectNode target = Convert2Json.convert2JSON(map,TransitionDAO.readTransition(map, id));
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(target);
			out.flush();			
			
		}catch(NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTransition(@PathVariable("docId") String docId,@PathVariable("id") String id, @RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {
		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);			
			TransitionDAO.deleteTransition(map, id);
		}
		catch(NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
	}
	
}
