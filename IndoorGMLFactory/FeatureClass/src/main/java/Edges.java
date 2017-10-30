import java.util.List;

import net.opengis.indoorgml.core.v_1_0.TransitionMemberType;

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
	public List<TransitionMemberType> transitionMember;

}	
