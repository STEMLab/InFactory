package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.stem.binder.Container;
import net.opengis.gml.v_3_2_1.CodeType;
import net.opengis.indoorgml.core.v_1_0.SpaceLayerClassTypeType;

public class SpaceLayer extends AbstractFeature {

	private String docId;
	
	private String usage;
	/**
	 * functionality of the feature
	 */
	private List<CodeType> function;
	/**
	 * time stamp when the SpaceLayer is created
	 */
	private Date createDate;
	/**
	 * time stamp when the SpaceLayer is expired
	 */
	private Date terminationDate;
	/**
	 * Nodes which the SpaceLayer contains
	 */
	private List<String> nodes;
	/**
	 * Edges which the SpaceLayer contains
	 */
	private List<String> edges;
	/**
	 * represent Class type of the SpaceLayer
	 */
	// public SpaceLayerClassTypeType classType;
	private String parentId;
	private SpaceLayerClassTypeType classType;

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
	
	public void setParent(SpaceLayers parent) {
		SpaceLayers found = null;
		found = (SpaceLayers) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("SpaceLayers"),
				parent.getId());
		if (found == null) {
			IndoorGMLMap.setFeature(parent.getId(), "SpaceLayers", parent);
		}
		this.parentId = parent.getId();
	}

	public SpaceLayers getParent() {
		SpaceLayers found = null;
		found = (SpaceLayers) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("SpaceLayers"),
				this.parentId);
		return found;
	}

	/**
	 * @return the usage
	 */
	public String getUsage() {
		return new String(usage);
	}

	/**
	 * @param usage
	 *            the usage to set
	 */
	public void setUsage(String usage) {
		this.usage = usage;
	}

	/**
	 * @return the function
	 */
	public List<CodeType> getFunction() {
		return function;
	}

	/**
	 * @param function
	 *            the function to set
	 */
	public void setFunction(List<CodeType> function) {
		this.function = function;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return new Date(createDate.getTime());
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the terminationDate
	 */
	public Date getTerminationDate() {
		return new Date(terminationDate.getTime());
	}

	/**
	 * @param terminationDate
	 *            the terminationDate to set
	 */
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	/**
	 * @return the nodes
	 */
	public List<Nodes> getNodes() {
		List<Nodes>nodes = new ArrayList<Nodes>();
		for(int i = 0 ; i < this.edges.size() ; i++){
			nodes.add((Nodes)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Nodes"), this.edges.get(i)));
		}
		return nodes;
	}

	/**
	 * @param nodes
	 *            the nodes to set
	 */
	public void setNodes(List<Nodes> nodes) {
		for(int i = 0 ; i < nodes.size() ; i++ ){
			Nodes found = null;
			found = (Nodes)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Nodes"), nodes.get(i).getId());
			if(found == null){
				IndoorGMLMap.setFeature(nodes.get(i).getId(), "Nodes",nodes.get(i));
			}
			if(this.nodes.contains(nodes.get(i).getId())){
				this.nodes.add(nodes.get(i).getId());
			}			
		}
	}
	/**
	 * @return the edges
	 */
	public List<Edges> getEdges() {
		List<Edges>edges = new ArrayList<Edges>();
		for(int i = 0 ; i < this.edges.size() ; i++){
			edges.add((Edges)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Edges"), this.edges.get(i)));
		}
		return edges;
	}

	/**
	 * @param edges
	 *            the edges to set
	 */
	public void setEdges(List<Edges> edges) {
		for(int i = 0 ; i < edges.size() ; i++ ){
			Edges found = null;
			found = (Edges)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Edges"), edges.get(i).getId());
			if(found == null){
				IndoorGMLMap.setFeature(edges.get(i).getId(), "InterEdges",edges.get(i));
			}
			if(this.edges == null){
				this.edges = new ArrayList<String>();
			}
			if(this.edges.contains(edges.get(i).getId())){
				this.edges.add(edges.get(i).getId());
			}			
		}
	}

	/**
	 * @return the classType
	 */
	public SpaceLayerClassTypeType getClassType() {
		return classType;
	}

	/**
	 * @param classType
	 *            the classType to set
	 */
	public void setClassType(SpaceLayerClassTypeType classType) {
		this.classType = classType;
	}
}
