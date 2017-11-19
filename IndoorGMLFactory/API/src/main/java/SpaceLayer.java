

import java.util.Date;

import FeatureClass.Edges;
import FeatureClass.Nodes;
import FeatureClass.SpaceLayerClassType;


public class SpaceLayer {
	/**
	 * Create SpaceLayer feature instance
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
	public FeatureClass.SpaceLayer createSpaceLayer(String ID, String parentID, String usage, String function, Date createDate,
			Date terminationDate, Nodes n, Edges e, SpaceLayerClassType ct) {
		return null;
	}

	/**
	 * Search SpaceLayer feature in document
	 * @param ID ID of target
	 * @return searched SpaceLayer feature instance
	 */
	public FeatureClass.SpaceLayer readSpaceLayer(String ID) {
		return null;
	}

	/**
	 * Search SpaceLayer feature and edit it as the Parameters
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
	public FeatureClass.SpaceLayer updateSpaceLayer(String ID, String usage, String function, Date createDate, Date terminationDate,
			Nodes n, Edges e, SpaceLayerClassType ct) {
		return null;
	}

	/**
	 * Search SpaceLayer feature and delete it
	 * @param ID ID of target
	 */
	public void deleteSpaceLayer(String ID) {
	}

}
