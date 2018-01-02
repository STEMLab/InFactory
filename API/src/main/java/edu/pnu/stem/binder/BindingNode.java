package edu.pnu.stem.binder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hgryoo
 *
 */
public class BindingNode {
	
	private Map<String, Object> attributes = new HashMap<String, Object>();
	
	private Map<String, BindingNode> associations = new HashMap<String, BindingNode>();
	
	private Map<String, List<BindingNode>> collections = new HashMap<String, List<BindingNode>>();
	
	public void addAttribute(String key, Object value) {
		key = key.toUpperCase();
		if( !attributes.containsKey(key)) {
			attributes.put(key, value);
		} else {
			String msg = "Duplicated Key : " + key;
			throw new IllegalArgumentException(msg);
		}
		
	}
	
	public Object getAttribute(String key) {
		key = key.toUpperCase();
		int idx= key.indexOf("/");
		
		if(idx == -1) {
			return attributes.get(key);
		} else {
			String assoName = key.substring(0, idx);
			BindingNode bn = associations.get(assoName);
			if(bn == null) {
				return null;
/*				String msg = assoName + "is not exist";
				throw new IllegalArgumentException(msg);*/
			} else {
				return bn.getAttribute( key.substring(idx + 1));
			}
		}
	}
	
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	
	
	public void addAssociation(String key, BindingNode node) {
		key = key.toUpperCase();
		if( !associations.containsKey(key)) {
			associations.put(key, node);
		} else {
			String msg = "Duplicated Key : " + key;
			throw new IllegalArgumentException(msg);	
		}
	}
	
	public BindingNode getAssociation(String key) {
		key = key.toUpperCase();
		int idx= key.indexOf("/");
		
		if(idx == -1) {
			return associations.get(key);
		} else {
			String assoName = key.substring(0, idx - 1);
			BindingNode bn = associations.get(assoName);
			if(bn == null) {
				String msg = assoName + "is not exist";
				throw new IllegalArgumentException(msg);
			} else {
				return bn.getAssociation(key.substring(idx + 1));
			}
		}
	}
	
	public void addCollection(String key, BindingNode node) {
		key = key.toUpperCase();
		if(!collections.containsKey(key)) {
			collections.put(key, new ArrayList<BindingNode>());
		}
		List<BindingNode> bindingList = collections.get(key);
		bindingList.add(node);
	}
	
	public List<BindingNode> getCollection(String key) {
		key = key.toUpperCase();
		if(collections.containsKey(key)) {
			return collections.get(key);
		} else {
			return Collections.EMPTY_LIST;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BindingNode [attributes=" + attributes + ", associations=" + associations + ", collections="
				+ collections + "]";
	}

	//GET METHODS
	public Integer getInteger(String key) {
		Object value = getAttribute(key);
		if(value == null) {
			return null; //default value
		} else {
			return (Integer) value;
		}
	}
	
	public String getString(String key) {
		Object value = getAttribute(key);
		if(value == null) {
			return null; //default value
		} else {
			return (String) value;
		}
	}
	
	
}

