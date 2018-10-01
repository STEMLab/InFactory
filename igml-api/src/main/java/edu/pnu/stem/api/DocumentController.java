package edu.pnu.stem.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.stem.api.exception.DocumentNotFoundException;
import edu.pnu.stem.api.exception.UndefinedDocumentException;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.database.DeleteMap;
import edu.pnu.stem.database.InsertMap;
import edu.pnu.stem.database.SearchMap;
import edu.pnu.stem.database.SqlUtil;
import edu.pnu.stem.feature.IndoorFeatures;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;

/**
 * @author Hyung-Gyu Ryoo (hyunggyu.ryoo@gmail.com, Pusan National University)
 *
 */
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/documents")
public class DocumentController {
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@PostMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createDocument(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {

		if(id == null || id.isEmpty()) {
			id = UUID.randomUUID().toString();
		}
		
		Container container = applicationContext.getBean(Container.class);
		
		
		
		//try {
			IndoorGMLMap map = container.getDocument(id);
			//Connection connection = DriverManager.getConnection("jdbc:h2:file:~/test;","sa","sa");
			
			//Statement st = connection.createStatement();
			//ResultSet rs = st.executeQuery("SELECT * FROM DOCUMENTS WHERE id="+SqlUtil.change2SqlString(id));
			
			//if(rs.next()) {
				//map = SearchMap.search(connection, rs.getString("id"));
				//System.out.println("This document: "+id+" is already saved in Database!");
			//}
			//else{
				
				map = container.createDocument(id);
				String contentType = request.getContentType();
				if(contentType != null) {
					if(request.getContentType().contains("xml")) {
						// Importing IndoorGML Document
						try {
							InputStream xml = request.getInputStream();
							IndoorFeaturesType doc = edu.pnu.stem.binder.Unmashaller.importIndoorGML(id, xml);
							IndoorFeatures savedDoc = edu.pnu.stem.binder.Convert2FeatureClass.change2FeatureClass(map, id, doc);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if(request.getContentType().contains("json")) {
						//TODO : indoorJSON
					}
				}
				
				// Empty Document is made.

			    response.setHeader("Location", request.getRequestURL().append(map.getDocId()).toString());
			    System.out.println("Document is created : "+id);
				
			//}
			

		    
		   // connection.close();
			
		//} catch (SQLException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		//}
		
		
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public void getDocument(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
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
			
			if(map == null) {
				Connection connection;
				try {
					connection = DriverManager.getConnection("jdbc:h2:file:~/test;","sa","sa");
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM DOCUMENTS WHERE id="+SqlUtil.change2SqlString(id));
					
					if(rs.next()) {
						map = SearchMap.search(connection, rs.getString("id"));
						System.out.println("This document: "+id+" is already saved in Database!");
					}
					InsertMap.insert(connection, map);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			if(map != null) {
				map.Marshall("temp/" + id + ".igml");
				
				try {
					
					System.out.println(map);
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
			} else {
				throw new DocumentNotFoundException();
			}
		//}

	}
	@DeleteMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDocument(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
		try {
			Container container = applicationContext.getBean(Container.class);
			IndoorGMLMap map = container.getDocument(id);	
			if(map != null) {
			//	map.clearMap();
				container.removeDocument(id);
			}		
			//Connection connection = DriverManager.getConnection("jdbc:h2:file:~/test;","sa","sa");
			//DeleteMap.dropMap(connection, id);
		}
		//catch(NullPointerException | SQLException e) {
		catch(NullPointerException e) {
			e.printStackTrace();
			throw new UndefinedDocumentException();
		}
	}
}
