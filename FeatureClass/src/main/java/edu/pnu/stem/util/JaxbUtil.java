package edu.pnu.stem.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.sun.xml.bind.v2.runtime.JAXBContextImpl;

public class JaxbUtil {
	public static JAXBContext createIndoorGMLContext() throws JAXBException{
		JAXBContext context = (JAXBContextImpl) JAXBContext.newInstance(
				"net.opengis.indoorgml.core.v_1_0"
				+":org.w3.XMLSchema"
				+":net.opengis.gml.v_3_2"
				+":org.w3.xlink"
			);		
		return context;
	}
	public static JAXBContext createGMLContext() throws JAXBException{
		JAXBContext context = (JAXBContext) JAXBContext.newInstance(
				"net.opengis.gml.v_3_2"
				+":org.w3.XMLSchema"
				+":net.ascc.xml.schematron"
				+":org.w3.xlink"
				);
		return context;
		
	}
}

