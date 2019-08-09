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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.pnu.stem.api.exception.UndefinedDocumentException;
import edu.pnu.stem.binder.Convert2Json;
import edu.pnu.stem.binder.IndoorGMLMap;

import edu.pnu.stem.dao.GeneralSpaceDAO;

import edu.pnu.stem.feature.navigation.GeneralSpace;

@RestController
@RequestMapping("/documents/{docId}/generalspace")
public class GeneralSpaceController {
	@Autowired
    private ApplicationContext applicationContext;
	
	@PostMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createGeneralSpace(@PathVariable("id") String id, @RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String docId = json.get("docId").asText().trim();
		String parentId = json.get("parentId").asText().trim();
		String name = null; 
		String description = null;
		String functionType = null;
		String classType = null;
		String usageType = null;
		
		String geomFormatType = "GEOJSON";
		final ObjectMapper mapper = new ObjectMapper();
				
		String geom = json.get("geometry").asText().trim();
		String duality = null;
		Geometry generalGeometry = null;
		JsonNode geometry = null;
		
		List<String> partialBoundedBy = null;
		
		if(id == null || id.isEmpty()) {
			id = UUID.randomUUID().toString();
		}
		
		try{			
			 mapper.readTree(geom);
		}
		catch (IOException e){
			geomFormatType = "WKT";
		}
		if(json.has("duality")){
			duality = json.get("duality").asText().trim();
		}
		if(json.has("properties")){
			if(json.get("properties").has("duality")){
				duality = json.get("properties").get("duality").asText().trim();
			}
			if(json.get("properties").has("name")) {
				name = json.get("properties").get("name").asText().trim();
			}
			if(json.get("properties").has("description")) {
				description = json.get("properties").get("description").asText().trim();
			}
			//class,function,usage 
			if(json.get("properties").has("class")) {
				classType = json.get("properties").get("class").asText().trim();
				
			}
			if(json.get("properties").has("function")) {
				functionType = json.get("properties").get("function").asText().trim();
				
			}
			if(json.get("properties").has("usage")) {
				usageType = json.get("properties").get("usage").asText().trim();
				
			}
			if(json.get("properties").has("partialboundedBy")){
				partialBoundedBy = new ArrayList<String>();
				JsonNode partialBoundedByList = json.get("properties").get("partialboundedBy");
				for(int i = 0 ; i < partialBoundedByList.size() ; i++){
					partialBoundedBy.add(partialBoundedByList.get(i).asText().trim());
				}
				
			}
			
		}
		
		if(json.has("geometry")) {
			geometry = json.get("geometry");
			generalGeometry = Convert2Json.json2Geometry(geometry);
		}
		

		//TODO : 나중에 고치기!!
		//String properties = json.get("properties").asText().trim();
		//String duality = null;

		
		GeneralSpace c = null;
		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);
			/*
			 * if(geomFormatType.equals("GEOJSON")){
				c = CellSpaceDAO.createCellSpace(map, parentId, id, geometry, duality);
			}
			else if(geomFormatType.equals("WKT")){
				c = CellSpaceDAO.createCellSpace(map, parentId, id, geom, duality);
			}
			 * */
			c = GeneralSpaceDAO.createGeneralSpace(map, parentId, id, name, description, generalGeometry, duality, partialBoundedBy, classType, functionType, usageType);
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
		response.setHeader("Location", request.getRequestURL().append(c.getId()).toString());
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.FOUND)
	public void getGeneralSpace(@PathVariable("docId") String docId,@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);
			
			ObjectNode target = Convert2Json.convert2JSON(map, GeneralSpaceDAO.readGeneralSpace(map, id));
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(target);
			
			out.flush();			
			
		}catch(NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
	}
	
	@PutMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateGeneralSpace(@PathVariable("docId") String docId,@PathVariable("id") String id, @RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {
		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);
			String duality = null;
			JsonNode geometry = null;
			List<String> partialBoundedBy = null;
			Geometry geom = null;
			String parentId = null;
			
			
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
			
			
			//TODO : 나중에 고치기!!
			//String properties = json.get("properties").asText().trim();
			//String duality = null;
			
			if(json.has("properties")){
				if(json.get("properties").has("partialboundedBy")){
					partialBoundedBy = new ArrayList<String>();
					JsonNode partialBoundedByList = json.get("properties").get("partialboundedBy");
					for(int i = 0 ; i < partialBoundedByList.size() ; i++){
						partialBoundedBy.add(partialBoundedByList.get(i).asText().trim());
					}
				}
			}
			
		GeneralSpaceDAO.updateGeneralSpace(map, parentId, id, null, null, geom, duality, partialBoundedBy );
			
		}
		catch(NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteGeneralSpace(@PathVariable("docId") String docId,@PathVariable("id") String id, @RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {
		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);			
			GeneralSpaceDAO.deleteGeneralSpace(map, id);
		}
		catch(NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
	}
}
