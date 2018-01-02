package FeatureClassReference;
import java.util.Date;
import java.util.List;

import net.opengis.gml.v_3_2_1.CodeType;
import net.opengis.indoorgml.core.v_1_0.SpaceLayerClassTypeType;

public class SpaceLayer {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * description of usage of the feature
	 */
	public String usage;
	/**
	 * functionality of the feature
	 */
	public List<CodeType> function;
	/**
	 * time stamp when the SpaceLayer is created
	 */
	public Date createDate;
	/**
	 * time stamp when the SpaceLayer is expired
	 */
	public Date terminationDate;
	/**
	 * Nodes which the SpaceLayer contains
	 */
	public List<String> nodes;
	/**
	 * Edges which the SpaceLayer contains
	 */
	public List<String> edges;
	/**
	 * represent Class type of the SpaceLayer
	 */
	//public SpaceLayerClassTypeType classType;
	public String parentID;
	public SpaceLayerClassTypeType classType;
	public void setID(String id){this.ID = id;};
	public String getID(){return this.ID;};
	public void setParentID(String id){this.parentID = id;}
	public String getParentID(){return this.parentID;}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the usage
	 */
	public String getUsage() {
		return usage;
	}
	/**
	 * @param usage the usage to set
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
	 * @param function the function to set
	 */
	public void setFunction(List<CodeType> function) {
		this.function = function;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the terminationDate
	 */
	public Date getTerminationDate() {
		return terminationDate;
	}
	/**
	 * @param terminationDate the terminationDate to set
	 */
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
	/**
	 * @return the nodes
	 */
	public List<String> getNodes() {
		return nodes;
	}
	/**
	 * @param nodes the nodes to set
	 */
	public void setNodes(List<String> nodes) {
		this.nodes = nodes;
	}
	/**
	 * @return the edges
	 */
	public List<String> getEdges() {
		return edges;
	}
	/**
	 * @param edges the edges to set
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
	 * @param classType the classType to set
	 */
	public void setClassType(SpaceLayerClassTypeType classType) {
		this.classType = classType;
	}
}
