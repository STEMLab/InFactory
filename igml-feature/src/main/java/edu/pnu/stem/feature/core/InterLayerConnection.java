package edu.pnu.stem.feature.core;

import edu.pnu.stem.binder.IndoorGMLMap;

/**
 * @author jungh Implements InteraLayerConnectionType of IndoorGML 1.0.3
 */
public class InterLayerConnection extends AbstractFeature {
		
	private String parentId;
	
	private typeOfTopoExpressionCode typeOfTopoExpression;
	/**
	 * describe characteristic of this instance
	 */
	private String comment;
	/**
	 * save list of ID of States which are related with each others as this
	 * InterLayerConnection
	 */
	private String[] interConnects;
	/**
	 * save list of ID of SpaceLayers which are related with each others as this
	 * InterLayerConnection
	 */
	private String[] connectedLayers;
	
	public InterLayerConnection(IndoorGMLMap doc, String id){
		super(doc, id);
		
		
	}
	
	public Boolean checkInterConnectsNumber() {
		// Boolean flag = false;
		if (this.interConnects.length != 2 || this.connectedLayers.length != 2) {
			return false;
		}
		return true;

	}
	
	public void setParent(InterEdges parent){
		InterEdges found = null;
		found = (InterEdges)indoorGMLMap.getFeature(parent.getId());
		if(found == null){
			indoorGMLMap.setFutureFeature(parent.getId(), parent);
		}
		this.parentId = parent.getId();
	}
	
	public InterEdges getParent(){
		InterEdges found = null;
		found = (InterEdges)indoorGMLMap.getFeature(this.parentId);
		if(found == null)
			if(indoorGMLMap.hasFutureID(parentId))
				found = (InterEdges)indoorGMLMap.getFutureFeature(parentId);
		return found;
	}

	public void setConnectedLayers(SpaceLayer[] connectedLayers){
		this.connectedLayers = new String[2];
		this.connectedLayers[0] = connectedLayers[0].getId();
		this.connectedLayers[1] = connectedLayers[1].getId();
	}
	
	public SpaceLayer[] getConnectedLayers() {
		SpaceLayer[] found = new SpaceLayer[2];
		
		found[0] = (SpaceLayer)indoorGMLMap.getFeature(this.connectedLayers[0]);
		found[1] = (SpaceLayer)indoorGMLMap.getFeature(this.connectedLayers[1]);
		
		return found;
	}

	public void setInterConnects(State[] interConnects) {
		this.interConnects = new String[2];
		this.interConnects[0] = interConnects[0].getId();
		this.interConnects[1] = interConnects[1].getId();
	}

	public State[] getInterConnects() {

		State[] found = null;
		if(this.interConnects != null) {
			found = new State[2];
			found[0] = (State)indoorGMLMap.getFeature(this.interConnects[0]);
			found[1] = (State)indoorGMLMap.getFeature(this.interConnects[1]);
		}
		return found;
	}

	/**
	 * @return the typeOfTopoExpression
	 */
	public typeOfTopoExpressionCode getTypeOfTopoExpression() {
		return typeOfTopoExpression;
	}

	/**
	 * @param typeOfTopoExpression
	 *            the typeOfTopoExpression to set
	 */
	public void setTypeOfTopoExpression(typeOfTopoExpressionCode typeOfTopoExpression) {
		this.typeOfTopoExpression = typeOfTopoExpression;
	}

	public void setComment(String comment) {
		this.comment = comment;
		
	}
	
	public String getComment(){
		return new String(this.comment);
	}

	public void resetParent() {
		this.parentId = null;
		
	}


}
