package edu.pnu.stem;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import edu.pnu.stem.api.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.geometry.jts.WKTReader3D;
import junit.framework.TestCase;

public class testForCRUD extends TestCase{
	 public void testConverter(){
		 final GeometryFactory geometryFactory = new GeometryFactory();
		 WKTReader3D wkt = new WKTReader3D();
		 
		 try {
			IndoorGMLMap map = Container.createDocument("test");
			edu.pnu.stem.dao.IndoorFeaturesDAO.createIndoorFeatures(map, "if1", "indoorfeatures","testdata",null, null, "pf1");
			
			List<String>cellspacemember = new ArrayList<String>();
			cellspacemember.add("c1");
			List<String>cellspaceboundarymember = new ArrayList<String>();
			cellspaceboundarymember.add("csb1");
			
			edu.pnu.stem.dao.PrimalSpaceFeaturesDAO.createPrimalSpaceFeatures(map, "if1", "pf1", null, null,cellspacemember ,cellspaceboundarymember);
			
			List<String>partialboundedby = new ArrayList<String>();
			partialboundedby.add("csb1");
			
			/*
			 * Create JTS geometry class instance and use it at creating CellSpace feature. 
			 */
			
			// Define the WKT geometry in String.
			String wktsolid = "SOLID (( ((0 0 0, 0 1 0, 1 1 0, 1 0 0, 0 0 0)), ((0 0 0, 0 1 0, 0 1 1, 0 0 1, 0 0 0)), ((0 0 0, 1 0 0, 1 0 1, 0 0 1, 0 0 0)), ((1 1 1, 1 0 1, 0 0 1, 0 1 1, 1 1 1)), ((1 1 1, 1 0 1, 1 0 0, 1 1 0, 1 1 1)), ((1 1 1, 1 1 0, 0 1 0, 0 1 1, 1 1 1)) ))";
			Geometry cg1 = wkt.read(wktsolid);
			edu.pnu.stem.util.GeometryUtil.setMetadata(cg1, "id", "cg1");
			edu.pnu.stem.dao.CellSpaceDAO.createCellSpace(map, "pf1", "c1", null, null, cg1, null, partialboundedby);
			
			String wktSurface = "POLYGON ((72.91597221207489 43.26827584086601 0, 79.90026563212191 43.26827584086601 0, 79.90026563212191 43.26827584086601 15, 72.91597221207489 43.26827584086601 15, 72.91597221207489 43.26827584086601 0))";
			Geometry cbg1 = wkt.read(wktSurface);
			edu.pnu.stem.util.GeometryUtil.setMetadata(cbg1, "id", "cbg1");
			
			edu.pnu.stem.dao.CellSpaceBoundaryDAO.createCellSpaceBoundary(map, "pf1", "csb1", null , null, cbg1, null);
			
			edu.pnu.stem.dao.CellSpaceDAO.updateCellSpace(map, "pf1", "c1", "room1", "bedroom", cg1, null, partialboundedby);
			
			edu.pnu.stem.binder.Mashaller.marshalDocument(null, Container.getDocument("test"));
			
			edu.pnu.stem.dao.CellSpaceDAO.readCellSpace(map, "c1");
			edu.pnu.stem.dao.CellSpaceDAO.deleteCellSpace(map,"c1");
			
			//IndoorFeatures savedDoc = (IndoorFeatures)map.getFeature("if1");
			//edu.pnu.stem.binder.Mashaller.marshalIndoorFeatures(null, Convert2JaxbClass.change2JaxbClass(map,savedDoc));
			

		 } catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
