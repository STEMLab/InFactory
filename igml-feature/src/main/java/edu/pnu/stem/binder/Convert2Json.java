package edu.pnu.stem.binder;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Polygon;

import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.geometry.jts.Solid;
import edu.pnu.stem.geometry.jts.WKTWriter3D;
import edu.pnu.stem.util.GeometryUtil;

public class Convert2Json {
	public ObjectNode convert2CellSpaceJSON(IndoorGMLMap map, CellSpace target) {
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		ObjectNode properties = null;
		result.put("type","CellSpace");
		Geometry targetGeometry = target.getGeometry();
		
		if(targetGeometry != null) {
			ObjectNode geometryData = JsonNodeFactory.instance.objectNode();
			ObjectNode geometryProperties = JsonNodeFactory.instance.objectNode();
			
			
			geometryProperties.put("id", GeometryUtil.getMetadata(targetGeometry, "id"));
			geometryProperties.put("type","wkt");
			
			if(targetGeometry instanceof Solid) {			
				geometryData.put("type", "Solid");
				
			}
			else if(targetGeometry instanceof Polygon) {
				geometryData.put("type", "Polygon");
			}
			else {
				//error
			}
			String wktGeometry = writer.write(targetGeometry);
			geometryData.put("coordinate",wktGeometry);
			geometryData.set("properties", geometryProperties);
			result.set("geometry", geometryData);
			//geometryData.put(fieldName, targetGeometry);
		}
		
		result.put("parentId",target.getParent().getId());
		result.put("id",target.getId());
		result.put("docId", map.getDocId());
		
		if(target.getDuality() != null) {
			properties = JsonNodeFactory.instance.objectNode();
			properties.put("duality", target.getDuality().getId());
			
		}
		
		if(target.getName() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			properties.put("name", target.getName());
		}
		
		if(target.getDescription() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			properties.put("description", target.getDescription());
		}
		
		if(properties != null) {
			result.set("properties", properties);
		}
		
		return result;
	} 
}
