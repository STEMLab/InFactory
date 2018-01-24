package edu.pnu.stem.feature;

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
		nodes = new ArrayList<String>();
		edges = new ArrayList<String>();
	}

	public void setParent(SpaceLayers parent) {
		SpaceLayers found = null;
		found = (SpaceLayers) indoorGMLMap.getFeature(parent.getId());
		if (found == null) {
			indoorGMLMap.setFeature(parent.getId(), "SpaceLayers", parent);
		}
		this.parentId = parent.getId();
	}

	public SpaceLayers getParent() {
		SpaceLayers found = null;
		found = (SpaceLayers) indoorGMLMap.getFeature(this.parentId);
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
		List<Nodes> nodes = new ArrayList<Nodes>();
		nodes = new ArrayList<Nodes>();
		for (int i = 0; i < this.nodes.size(); i++) {
			nodes.add((Nodes) indoorGMLMap.getFeature(this.nodes.get(i)));
		}
		return nodes;
	}

	/**
	 * @param nodes
	 *            the nodes to set
	 */
	public void setNodes(List<Nodes> nodes) {
		for (int i = 0; i < nodes.size(); i++) {
			Nodes found = null;
			found = (Nodes) indoorGMLMap.getFeature(nodes.get(i).getId());
			if (found == null) {
				indoorGMLMap.setFeature(nodes.get(i).getId(), "Nodes", nodes.get(i));
			}
			if (!this.nodes.contains(nodes.get(i).getId())) {
				this.nodes.add(nodes.get(i).getId());
			}
		}
	}

	public void addNodes(Nodes ns) {
		if(!this.nodes.contains(ns.getId())){
			this.nodes.add(ns.getId());
			indoorGMLMap.setFeature(ns.getId(), "Nodes", ns);
		}
	}
	
	/**
	 * @return the edges
	 */
	public List<Edges> getEdges() {
		List<Edges> edges = null;
		if (this.edges.size() != 0) {
			edges = new ArrayList<Edges>();
			for (int i = 0; i < this.edges.size(); i++) {
				edges.add(
						(Edges) indoorGMLMap.getFeature(this.edges.get(i)));
			}
		}
		return edges;
	}

	/**
	 * @param edges
	 *            the edges to set
	 */
	public void setEdges(List<Edges> edges) {
		for (int i = 0; i < edges.size(); i++) {
			Edges found = null;
			found = (Edges) indoorGMLMap.getFeature(edges.get(i).getId());
			if (found == null) {
				indoorGMLMap.setFeature(edges.get(i).getId(), "Edges", edges.get(i));
			}
			if (!this.edges.contains(edges.get(i).getId())) {
				this.edges.add(edges.get(i).getId());
			}
		}
	}
	
	public void addEdges(Edges es) {
		if(!this.edges.contains(es.getId())){
			this.edges.add(es.getId());
			indoorGMLMap.setFeature(es.getId(), "Edges", es);
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
