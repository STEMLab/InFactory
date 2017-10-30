import java.util.List;

import net.opengis.indoorgml.core.v_1_0.TransitionType;

/**
 * @author jungh
 *	Implements EdgesType of IndoorGML 1.0.3
 */
public class Edges {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * contains list of Transitions as list
	 */
	public List<TransitionType> transitionMember;

}	
