package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.opengis.gml.v_3_2_1.CodeType;
import net.opengis.indoorgml.core.v_1_0.SpaceLayerClassTypeType;

public class SpaceLayer extends AbstractFeature {

	String usage;
	/**
	 * functionality of the feature
	 */
	List<CodeType> function;
	/**
	 * time stamp when the SpaceLayer is created
	 */
	Date createDate;
	/**
	 * time stamp when the SpaceLayer is expired
	 */
	Date terminationDate;
	/**
	 * Nodes which the SpaceLayer contains
	 */
	List<String> nodes;
	/**
	 * Edges which the SpaceLayer contains
	 */
	List<String> edges;
	/**
	 * represent Class type of the SpaceLayer
	 */
	// public SpaceLayerClassTypeType classType;
	String parentID;
	SpaceLayerClassTypeType classType;

	public void setParentID(String id) {
		this.parentID = id;
	}

	public String getParentID() {
		return this.parentID;
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
	public List<String> getNodes() {
		return new ArrayList<String>(nodes);
	}

	/**
	 * @param nodes
	 *            the nodes to set
	 */
	public void setNodes(List<String> nodes) {
		this.nodes = nodes;
	}

	/**
	 * @return the edges
	 */
	public List<String> getEdges() {
		return new ArrayList<String>(edges);
	}

	/**
	 * @param edges
	 *            the edges to set
	 */
	public void setEdges(List<String> edges) {
		this.edges = edges;
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
