package Binder;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.helpers.DefaultValidationEventHandler;

import net.opengis.gml.v_3_2_1.AbstractGMLType;

public class unmashaller {	

	private XLinkSymbolMap mXLinkSymbolMap;

	public Object unmarshalIndoorGML(String path) throws JAXBException, IOException {
		
		JAXBContext context;
		Unmarshaller unmarshaller;
		SymbolListener listener;
		
		context = JAXBContext.newInstance("net.opengis.indoorgml.core.v_1_0:net.opengis.indoorgml.navigation.v_1_0:net.opengis.gml.v_3_2_1");
		unmarshaller = context.createUnmarshaller();
		listener = new SymbolListener(AbstractGMLType.class);
		
		unmarshaller.setListener(listener);
		
		unmarshaller.setEventHandler( new DefaultValidationEventHandler() );
		
		File input = new File(path);
		Object unmarshalResult = JAXBIntrospector.getValue(unmarshaller.unmarshal(input));
		
		this.mXLinkSymbolMap = listener.getSymbolMap();
		
		return unmarshalResult;
	}


}
