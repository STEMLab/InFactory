package Util;

import javax.xml.bind.JAXBException;

import com.sun.xml.bind.v2.runtime.JAXBContextImpl;

public class JaxbUtil {
	public static JAXBContextImpl createIndoorGMLContext() throws JAXBException{
		JAXBContextImpl context = (JAXBContextImpl) JAXBContextImpl.newInstance(
				"net.opengis.indoorgml.core.v_1_0"
				+":org.w3.XMLSchema"
				+":net.opengis.gml.v_3_2"
				+":org.w3.xlink"
			);		
		return context;
	}
	public static JAXBContextImpl createGMLContext() throws JAXBException{
		JAXBContextImpl context = (JAXBContextImpl) JAXBContextImpl.newInstance(
				"net.opengis.gml.v_3_2"
				+":org.w3.XMLSchema"
				+":net.ascc.xml.schematron"
				+":org.w3.xlink"
				);
		return context;
		
	}
}

