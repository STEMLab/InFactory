package edu.pnu.stem.api;

import java.math.BigInteger;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.locationtech.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.pnu.stem.api.exception.UndefinedDocumentException;
import edu.pnu.stem.binder.Convert2Json;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.dao.EnvelopeDAO;
import edu.pnu.stem.feature.core.Envelope;

@RestController
@RequestMapping("/documents/{docId}/envelope")
public class EnvelopeController {
	@Autowired
	private ApplicationContext applicationContext;

	@PostMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createEnvelope(@PathVariable("docId") String docId, @PathVariable("id") String id,
			@RequestBody ObjectNode json, HttpServletRequest request, HttpServletResponse response) {

		String parentId = null;
		String srsName = null;
		BigInteger srsDimension =null;

		Geometry upperCorner = null;
		Geometry lowerCorner = null;
		Envelope en;
		if (json.has("parentId")) {
			parentId = json.get("parentId").asText().trim();

		}
		if (id == null || id.isEmpty()) {
			id = UUID.randomUUID().toString();
		}

		if (json.has("upperCorner")) {
			upperCorner = Convert2Json.json2Geometry(json.get("upperCorner"));
			
		}

		if (json.has("lowerCorner")) {
			lowerCorner = Convert2Json.json2Geometry(json.get("lowerCorner"));
			
		}

		if (json.has("srsName")) {
			srsName = json.get("srsName").asText().trim();
			
		}
		if (json.has("srsDimension")) {
			srsDimension = BigInteger.valueOf(Long.parseLong(json.get("srsDimension").asText().trim()));
		}
		try {			
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(docId);
			en = EnvelopeDAO.createEnvelope(map, parentId, id, upperCorner, lowerCorner, srsName, srsDimension);
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
		response.setHeader("Location", request.getRequestURL().append(en.getId()).toString());
	}

}
