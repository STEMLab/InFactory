package edu.pnu.stem.feature;
import edu.pnu.stem.binder.Container;
import net.opengis.gml.v_3_2_1.AbstractGeometryType;

/**
 * @author jungh
 *	Implements CellSpaceGeometryType of IndoorGML 1.0.3
 */
public class CellSpaceGeometry extends AbstractFeature{
	
	private String docId;
	/**
	 * save geometry of feature 
	 */
	private AbstractGeometryType geometry;
	/**
	 * save geometry type of feature. 
	 * value can be set as "2D" or "3D"
	 */
	private String geometryType;
	
	private String geometry2D;
	private String geometry3D;
	
	private String parentID;
	
	/**
	 * @return the docId
	 */
	public String getDocId() {
		return new String(this.docId);
	}

	/**
	 * @param docId the docId to set
	 */
	public void setDocId(String docId) {
		if(Container.hasDoc(docId))
			this.docId = docId;
		else
			System.out.println("There is no document with that document Id.");
	}
	public String getID(){ return this.id; }
	public void setID(String id){ this.id = id;} 
	
	public String getParentID(){return this.parentID;}
	public void setParentID(String id){this.parentID = id;}
	
	public Object getGeometry2D() {
		Object feature = null;
		feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Surface"), this.geometry2D);
		return feature;
	}

	public Object getGeometry3D() {
		Object feature = null;
		feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Solid"), this.geometry3D);
		return feature;
	}
	/**
	 * @return the geometry
	 */
	public AbstractGeometryType getGeometry() {
		return geometry;
	}
	/**
	 * @param geometry the geometry to set
	 */
	public void setGeometry(AbstractGeometryType geometry) {
		this.geometry = geometry;
	}
	/**
	 * @return the geometryType
	 */
	public String getGeometryType() {
		return geometryType;
	}
	/**
	 * @param geometryType the geometryType to set
	 */
	public void setGeometryType(String geometryType) {
		this.geometryType = geometryType;
	}
	/**
	 * @param geometry2d the geometry2D to set
	 */
	public void setGeometry2D(String geometry2d) {
		geometry2D = geometry2d;
	}
	/**
	 * @param geometry3d the geometry3D to set
	 */
	public void setGeometry3D(String geometry3d) {
		geometry3D = geometry3d;
	}
	
	
	
}
