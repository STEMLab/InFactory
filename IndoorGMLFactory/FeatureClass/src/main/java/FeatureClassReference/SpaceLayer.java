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
}
