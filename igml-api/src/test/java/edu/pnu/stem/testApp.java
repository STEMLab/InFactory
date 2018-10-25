package edu.pnu.stem;

import javax.xml.bind.JAXBException;

import edu.pnu.stem.api.Container;
import edu.pnu.stem.binder.Convert2JaxbClass;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.core.IndoorFeatures;
import junit.framework.TestCase;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;

public class testApp extends TestCase {
 public void testConverter(){
	 try {
		IndoorGMLMap map = Container.createDocument("test");
		IndoorFeaturesType doc = edu.pnu.stem.binder.Unmashaller.importIndoorGML("test","src/test/resources/FJK_1_0_3.gml");
		IndoorFeatures savedDoc = edu.pnu.stem.binder.Convert2FeatureClass.change2FeatureClass(map,"test", doc);		
		edu.pnu.stem.binder.Mashaller.marshalIndoorFeatures(null, Convert2JaxbClass.change2JaxbClass(map,savedDoc));
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
