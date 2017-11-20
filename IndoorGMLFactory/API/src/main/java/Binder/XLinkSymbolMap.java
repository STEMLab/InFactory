package Binder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hgryoo
 *
 */
public class XLinkSymbolMap {
	
	private Map<String, Object> idRegistryMap;
	private Map<Object, Object> parentMap;
	private Map<String, Object> referenceRegistryMap;
	
	public XLinkSymbolMap(Map<String, Object> idRegistryMap, Map<Object, Object> parentMap, Map<String, Object> referenceRegistryMap) {
		this.idRegistryMap = idRegistryMap;
		this.parentMap = parentMap;
		this.referenceRegistryMap = referenceRegistryMap;
	}
	
	public XLinkSymbolMap() {
		this.idRegistryMap = new HashMap<String, Object>();
		this.parentMap = new HashMap<Object, Object>();
		this.referenceRegistryMap = new HashMap<String, Object>();
	}
	
	public Object getObjectById(String id) {
		return idRegistryMap.get(id);
	}
	
	public Object getParentById(String id) {
		Object o = idRegistryMap.get(id);
		if(o == null) {
			return null;
		} else {
			return parentMap.get(o);
		}
	}
	
	public Object getParentByObject(Object o) {
		return parentMap.get(o);
	}
	
	public Object getXlinkObjectById(String id) {
		return referenceRegistryMap.get(id);
	}
	
	public Map<String, Object> getReferenceRegistryMap() {
		return referenceRegistryMap;
	}
	
	public Map<String, Object> getIdRegistryMap() {
		return idRegistryMap;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "XLinkSymbolMap [idRegistryMap=" + idRegistryMap + ", parentMap=" + parentMap + ", referenceRegistryMap="
				+ referenceRegistryMap + "]";
	}
	
	
	
}

