/**
 * 
 */
package edu.pnu.stem.util;

import java.util.HashMap;
import java.util.Map;

import com.vividsolutions.jts.geom.Geometry;

/**
 * @author hyung
 *
 */
public class GeometryUtil {
	
	public static String getMetadata(Geometry g, String metadata) {
        if (g.getUserData() instanceof Map) {
            Map userData = (Map) g.getUserData();
            return (String) userData.get(metadata);
        }

        return null;
    }
	
	public static void setMetadata(Geometry g, String metadata, Object value) {
		Map userData = null;
		
		if (g.getUserData() != null) {
	        if (g.getUserData() instanceof Map) {
	            userData = (Map) g.getUserData();
	        } else {
	            userData = new HashMap();
	            userData.put(g.getUserData().getClass(), g.getUserData());
	        }
	    } else {
	        userData = new HashMap();
	    }
		
		userData.put(metadata, value);
		g.setUserData(userData);
	}
	
}
