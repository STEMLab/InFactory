package FeatureClassReference;

/**
 * @author jungh 
 * Implements typeOfTopoExpressionCodeType of IndoorGML 1.0.3
 */
public class typeOfTopoExpressionCode {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;

	/**
	 * @author jungh
	 *	type of typeOfTopoExpressionCodeType
	 */
	public enum Type {
		CONTAINS, OVERLAPS, EQUALS, WITHIN, CROSSES, INTERSECTS
	}

	public class typeOfTopoExpressionCodeOther {
	}

}
