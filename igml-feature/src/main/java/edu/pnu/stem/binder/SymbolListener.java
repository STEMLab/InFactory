package edu.pnu.stem.binder;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Listener for constructing symbol table
 * @author hgryoo
 *
 */
public class SymbolListener extends javax.xml.bind.Unmarshaller.Listener {
	
	private Map<String, Object> idRegistryMap;
	private Map<Object, Object> parentMap;
	private Map<String, Object> referenceRegistryMap;
	
	/**
	 * AbstractGML Type
	 */
	private final Class<?> _GMLType;
	
	/**
	 * 
	 */
	public SymbolListener(Class<?> abstractGMLType) {
		this.idRegistryMap = new HashMap<String, Object>();
		this.parentMap = new HashMap<Object, Object>();
		this.referenceRegistryMap = new HashMap<String, Object>();
		this._GMLType = abstractGMLType;
	}

	@Override
	public void afterUnmarshal(Object target, Object parent) {
		try {
			Method getHref = target.getClass().getMethod("getHref", null);
			String href = (String) getHref.invoke(target, null);
			if(href != null) {
				href = href.replaceAll("#", "");
				/*System.out.println("XLink : " + href);*/
				

				//System.out.println("xlink target : " + target.getClass());
				
				referenceRegistryMap.put(href, target);
				
			}
		} catch ( Exception e ) {
			//e.printStackTrace();
		}

		try {
			/*			
			if(target instanceof net.opengis.gml.v_3_1_1.AbstractGMLType) {
				String gmlId = ((net.opengis.gml.v_3_1_1.AbstractGMLType) target).getId();
				if( gmlId != null ) {
					idRegistryMap.put(gmlId, target);
					parentMap.put(target, parent);
					//System.out.println("GMLID : " + gmlId);
				}
			}
			*/

			if(_GMLType.isAssignableFrom(target.getClass())) {
				Method idMethod = _GMLType.getMethod("getId", null);
				String gmlId = (String) idMethod.invoke(target, null);
				if( gmlId != null ) {
					idRegistryMap.put(gmlId, target);
					parentMap.put(target, parent);
					/*System.out.println("GMLID : " + gmlId);*/
					
					//System.out.println("gml target : " + target.getClass());
				}
			}
		} catch( Exception e ) {
			//e.printStackTrace();
		}
	}
	
	public XLinkSymbolMap getSymbolMap() {
		return new XLinkSymbolMap(idRegistryMap, parentMap, referenceRegistryMap);
	}
}

