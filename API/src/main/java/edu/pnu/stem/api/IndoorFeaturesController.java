/**
 * 
 */
package edu.pnu.stem.api;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.pnu.stem.api.exception.DuplicatedFeatureException;
import edu.pnu.stem.api.exception.UndefinedDocumentException;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.dao.IndoorFeaturesDAO;
import edu.pnu.stem.feature.IndoorFeatures;

/**
 * @author hyung
 *
 */
@RestController
@RequestMapping("/indoorfeatures")
public class IndoorFeaturesController {
	
	
	
	@PostMapping(value = "/", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createIndoorFeatures(@RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {
		String docId = json.get("docId").asText().trim();
		String id = json.get("id").asText().trim();
		
		if(id == null || id.isEmpty()) {
			id = UUID.randomUUID().toString();
		}
		
		IndoorFeatures f;
		try {
			f = IndoorFeaturesDAO.createIndoorFeatures(docId, id);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
		response.setHeader("Location", request.getRequestURL().append(f.getId()).toString());
	}
	
}
