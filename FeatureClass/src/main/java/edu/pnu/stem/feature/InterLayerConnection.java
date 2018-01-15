package edu.pnu.stem.feature;

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
	
	public InterLayerConnection(IndoorGMLMap doc){
		super(doc);
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
			indoorGMLMap.setFeature(parent.getId(), "InterEdges", parent);
		}
		this.parentId = parent.getId();
	}
	
	public InterEdges getParent(){
		InterEdges found = null;
		found = (InterEdges)indoorGMLMap.getFeature(this.parentId);
		return found;
	}

	public void setConnectedLayers(SpaceLayer[] connectedLayers){
		SpaceLayer[]found = new SpaceLayer[2];
		found[0] = (SpaceLayer)indoorGMLMap.getFeature(connectedLayers[0].getId());
		found[1] = (SpaceLayer)indoorGMLMap.getFeature(connectedLayers[1].getId());
		if(found[0] == null){
			indoorGMLMap.setFeature(connectedLayers[0].getId(), "SpaceLayer", connectedLayers[0]);
		}
		if(found[1] == null){
			indoorGMLMap.setFeature(connectedLayers[1].getId(), "SpaceLayer", connectedLayers[1]);
		}
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
		State[]found = new State[2];
		found[0] = (State)indoorGMLMap.getFeature(interConnects[0].getId());
		found[1] = (State)indoorGMLMap.getFeature(interConnects[1].getId());
		if(found[0] == null){
			indoorGMLMap.setFeature(interConnects[0].getId(), "State", interConnects[0]);
		}
		if(found[1] == null){
			indoorGMLMap.setFeature(interConnects[1].getId(), "State", interConnects[1]);
		}
		this.interConnects[0] = interConnects[0].getId();
		this.interConnects[1] = interConnects[1].getId();
	}

	public State[] getInterConnects() {
		State[] found = new State[2];
		found[0] = (State)indoorGMLMap.getFeature(this.interConnects[0]);
		found[1] = (State)indoorGMLMap.getFeature(this.interConnects[1]);
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


}
