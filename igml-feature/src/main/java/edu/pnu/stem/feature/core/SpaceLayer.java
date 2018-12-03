package edu.pnu.stem.feature.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.stem.binder.IndoorGMLMap;
import net.opengis.gml.v_3_2_1.CodeType;
import net.opengis.indoorgml.core.v_1_0.SpaceLayerClassTypeType;

public class SpaceLayer extends AbstractFeature {

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

	public SpaceLayer(IndoorGMLMap doc, String id) {
		super(doc, id);
		
	}

	public void setParent(SpaceLayers parent) {
		SpaceLayers found = null;
		found = (SpaceLayers) indoorGMLMap.getFeature(parent.getId());
		if (found == null) {
			indoorGMLMap.setFutureFeature(parent.getId(), parent);
		}
		this.parentId = parent.getId();
	}

	public SpaceLayers getParent() {
		SpaceLayers found = null;
		found = (SpaceLayers) indoorGMLMap.getFeature(this.parentId);
		if(found == null) {
			if(indoorGMLMap.hasFutureID(parentId))
				found = (SpaceLayers)indoorGMLMap.getFutureFeature(parentId);
		}
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
		List<Nodes> nodes = null;
		if(this.nodes != null) {
			nodes = new ArrayList<Nodes>();
			for (int i = 0; i < this.nodes.size(); i++) {
				Nodes found = (Nodes) indoorGMLMap.getFeature(this.nodes.get(i));
				if(found == null) {
					found = (Nodes)indoorGMLMap.getFutureFeature(this.nodes.get(i));
				}
				nodes.add(found);
			}
		}	 
		return nodes;
	}

	/**
	 * @param nodes
	 *            the nodes to set
	 */
	public void setNodes(List<Nodes> nodes) {

		this.nodes = new ArrayList<String>();
		for (int i = 0; i < nodes.size(); i++) {
			Nodes found = null;
			found = (Nodes) indoorGMLMap.getFeature(nodes.get(i).getId());
			if (found == null) {
				indoorGMLMap.setFutureFeature(nodes.get(i).getId(), nodes.get(i));
			}
			if (!this.nodes.contains(nodes.get(i).getId())) {
				this.nodes.add(nodes.get(i).getId());
			}
		}
	}

	public void addNodes(Nodes ns) {
		if(this.nodes == null)
			this.nodes = new ArrayList<String>();
		Nodes found = null;
		found = (Nodes) indoorGMLMap.getFeature(ns.getId());
		if(found == null){
			indoorGMLMap.setFutureFeature(ns.getId(), ns);
		}
		if(!this.nodes.contains(ns.getId())){
			this.nodes.add(ns.getId());
		}
	}
	
	/**
	 * @return the edges
	 */
	public List<Edges> getEdges() {
		List<Edges> edges = null;
		if (this.edges != null) {
			edges = new ArrayList<Edges>();
			for (int i = 0; i < this.edges.size(); i++) {
				Edges found = (Edges) indoorGMLMap.getFeature(this.edges.get(i));
				if(found == null)
					found = (Edges)indoorGMLMap.getFutureFeature(this.edges.get(i));
				edges.add(found);
			}
		}
		return edges;
	}

	/**
	 * @param edges
	 *            the edges to set
	 */
	public void setEdges(List<Edges> edges) {
		if(edges != null && edges.size() != 0)
			this.edges = new ArrayList<String>();
		for (int i = 0; i < edges.size(); i++) {
			Edges found = null;
			found = (Edges) indoorGMLMap.getFeature(edges.get(i).getId());
			if (found == null) {
				indoorGMLMap.setFutureFeature(edges.get(i).getId(), edges.get(i));
			}
			if (!this.edges.contains(edges.get(i).getId())) {
				this.edges.add(edges.get(i).getId());
			}
		}
	}
	
	public void addEdges(Edges es) {
		Edges found = null;
		if(this.edges == null)
			this.edges = new ArrayList<String>();
		found = (Edges)indoorGMLMap.getFeature(es.getId());
		if(found == null){
			indoorGMLMap.setFutureFeature(es.getId(), es);
		}
		if(!this.edges.contains(es.getId())){
			this.edges.add(es.getId());
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

	public void deleteNodes(Nodes n) {
		// TODO Auto-generated method stub
		if(this.nodes != null)
			if(this.nodes.contains(n.getId()))
				this.nodes.remove(n.getId());
	}

	public void deleteEdges(Edges e) {
		if(this.edges != null)	
			if(this.edges.contains(e.getId())) {
				this.edges.remove(e.getId());
			}
	}
	
	public void resetParent() {
		this.parentId = null;
	}
}
