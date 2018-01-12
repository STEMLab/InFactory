package edu.pnu.stem.feature;

import edu.pnu.stem.api.Container;
import edu.pnu.stem.binder.IndoorGMLMap;

/**
 * @author jungh
 *	Implements CellSpaceBoundaryGeometryType of IndoorGML 1.0.3
 */
public class CellSpaceBoundaryGeometry extends AbstractFeature{
	
	private String docId;
	private String geometry2D;
	private String geometry3D;
	/**
	 * ID of parent feature instance.
	 */	
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
	
	public String getParentID(){return this.parentID;}
	public void setParentID(String id){this.parentID = id;}
	
	public Object getGeometry2D() {
		Object feature = null;
		feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Curve"), this.geometry2D);
		return feature;
	}

	public Object getGeometry3D() {
		Object feature = null;
		feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Surface"), this.geometry3D);
		return feature;
	}
}
	
