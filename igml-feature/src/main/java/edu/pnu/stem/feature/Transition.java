package edu.pnu.stem.feature;

import com.vividsolutions.jts.geom.Geometry;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.util.GeometryUtil;

/**
 * @author jungh Implements TransitionType of IndoorGML 1.0.3
 */
public class Transition extends AbstractFeature {

	private String geometry;
	/**
	 * value of CellSpaceBoundary feature which has duality relationship with
	 * this feature
	 */
	private String duality;
	/**
	 * value of weight which usally is used for transfering cost in road
	 * network, etc.
	 */
	private double weight;

	/**
	 * Array of connected States. minimum and maximum of the number of element
	 * needs to be 2
	 */
	private String[] connects;

	private String parentId;

	private ExternalReference externalReference;

	public Transition(IndoorGMLMap doc, String id){
		super(doc, id);
		connects = new String[2];
	}
	
	public boolean hasDuality() {
		if (this.duality == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public void setExternalReference(ExternalReference reference) {		
		this.externalReference = reference;
	}

	public ExternalReference getExternalReference() {
		return this.externalReference;
	}

	public void setParent(Edges parent) {
		Edges found = (Edges)indoorGMLMap.getFeature(parent.getId());
		if(found == null){
			if(!indoorGMLMap.hasFutureID(parent.getId())){
				indoorGMLMap.setFutureFeature(parent.getId(), parent);
			}
		}		
		this.parentId = parent.getId();
	}

	public Edges getParent() {
		Edges feature = null;
		feature = (Edges) indoorGMLMap.getFeature(this.parentId);
		return feature;
	}

	public CellSpaceBoundary getDuality() {
		CellSpaceBoundary found = null;
		if(hasDuality()){
			found = (CellSpaceBoundary)indoorGMLMap.getFeature(this.duality);
		}
		return found;
	}

	public void setDuality(CellSpaceBoundary duality) {
		CellSpaceBoundary found = null;
		found = (CellSpaceBoundary)indoorGMLMap.getFeature(duality.getId());
		if(found == null){
			indoorGMLMap.setFutureFeature(duality.getId(), duality);
		}
		this.duality = duality.getId();
	}
	public Geometry getGeometry() {
		Geometry feature = null;
		feature = (Geometry) indoorGMLMap.getFeature(this.geometry);
		return feature;
	}
	
	public void setGeometry(Geometry geom) {
		String gId = GeometryUtil.getMetadata(geom, "id");
		Geometry found = (Geometry) indoorGMLMap.getFeature(gId);
		if(found == null) {
			indoorGMLMap.setFeature(gId, "Geometry", geom);
		}
		this.geometry = gId;
	}
	public void setConnects(State[] connects) {
		if (connects.length != 2) {
			System.out.println("FeatureClass.Transition.setConnects : The size of input is not 2");
		} else {
			State found1 = null;
			State found2 = null;
			found1 = (State)indoorGMLMap.getFeature(connects[0].getId());
			found2 = (State)indoorGMLMap.getFeature(connects[1].getId());
			
			if(found1 == null){
				indoorGMLMap.setFutureFeature(connects[0].getId(), connects[0]);
			}
			if(found2 == null){
				indoorGMLMap.setFutureFeature(connects[1].getId(), connects[1]);
			} 
			
			this.connects[0] = connects[0].getId();
			this.connects[1] = connects[1].getId();
		}
	}

	public State[] getConnects() {	
		State[] connects = new State[2];
		connects[0] = (State)indoorGMLMap.getFeature(this.connects[0]);
		connects[1] = (State)indoorGMLMap.getFeature(this.connects[1]);
		return connects;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return new Double(weight);
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void resetDuality() {
		this.duality = null;
		
	}

	public void resetParent() {
		this.parentId = null;
		
	}

}
