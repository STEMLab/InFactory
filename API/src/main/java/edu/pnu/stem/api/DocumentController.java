package edu.pnu.stem.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.pnu.stem.api.exception.DuplicatedFeatureException;
import edu.pnu.stem.binder.IndoorGMLMap;

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
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void getDocument(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
		//String type = json.get("type").asText().trim();
		
		File theDir = new File("temp");

		// if the directory does not exist, create it
		if (!theDir.exists()) {
		    System.out.println("creating directory: " + theDir.getName());
		    boolean result = false;

		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		        //handle it
		    }        
		    if(result) {    
		        System.out.println("DIR created");  
		    }
		}
				
		//if(type != null && type.equalsIgnoreCase("xml")) {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(id);
			map.Marshall("temp/" + id + ".igml");

			try {
				response.setContentType("text/xml;charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				File file = new File("temp/" + id + ".igml");
				
				BufferedReader reader;
				
				reader = new BufferedReader(new FileReader (file));
			    String         line = null;
			    StringBuilder  stringBuilder = new StringBuilder();
			    String         ls = System.getProperty("line.separator");

		        while((line = reader.readLine()) != null) {
		            stringBuilder.append(line);
		            stringBuilder.append(ls);
		        }
		        
			    reader.close();

			    String content = stringBuilder.toString();

				out.write(content);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}

	}
}
