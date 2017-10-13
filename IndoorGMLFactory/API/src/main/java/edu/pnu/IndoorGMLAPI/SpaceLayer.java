package edu.pnu.IndoorGMLAPI;

import java.util.Date;

import edu.pnu.stemlab.IndoorGMLFeatureClass.FeatureClass.SpaceLayerClassType;

public class SpaceLayer {
	/**
	 * @param ID ID of SpaceLayer
	 * @param parentID ID of parent which will hold this feature
	 * @param usage Comment on usage
	 * @param function explanation about functionality of this SpaceLayer
	 * @param createDate the time when this SpaceLayer is created
	 * @param terminationDate the time when this SpaceLayer is expired
	 * @param n nodes which is contained in this SpaceLayer
	 * @param e	edges which is contained in this SpaceLayer
	 * @param ct SpaceLayerClassType of this SpaceLayer
	 * @return created SpaceLayer feature instance
	 */
	public SpaceLayer createSpaceLayer(String ID, String parentID, String usage, String function, Date createDate,
			Date terminationDate, Nodes n, Edges e, SpaceLayerClassType ct) {
		return null;
	}

	/**
	 * @param ID ID of target
	 * @return searched SpaceLayer feature instance
	 */
	public SpaceLayer readSpaceLayer(String ID) {
		return null;
	}

	/**
	 * @param ID ID of target
	 * @param usage Comment on usage
	 * @param function explanation about functionality of this SpaceLayer
	 * @param createDate the time when this SpaceLayer is created
	 * @param terminationDate the time when this SpaceLayer is expired
	 * @param n nodes which is contained in this SpaceLayer
	 * @param e	edges which is contained in this SpaceLayer
	 * @param ct SpaceLayerClassType of this SpaceLayer
	 * @return edited SpaceLayer feature instance
	 */
	public SpaceLayer updateSpaceLayer(String ID, String usage, String function, Date createDate, Date terminationDate,
			Nodes n, Edges e, SpaceLayerClassType ct) {
		return null;
	}

	/**
	 * @param ID ID of target
	 */
	public void deleteSpaceLayer(String ID) {
	}

}
