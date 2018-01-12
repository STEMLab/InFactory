package edu.pnu.stem;

import javax.xml.bind.JAXBException;

import edu.pnu.stem.binder.Container;
import edu.pnu.stem.feature.IndoorFeatures;
import junit.framework.TestCase;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;

public class testApp extends TestCase {
	public void testConverter(){
		 try {
			 IndoorFeaturesType importedDoc = (IndoorFeaturesType)edu.pnu.stem.binder.Unmashaller.importIndoorGML("test","src/test/resources/FJK-Haus_IndoorGML_withEXR-corrected_1_0_3.gml");
			 Container.setDocument("testDoc");
			 IndoorFeatures featureDoc = edu.pnu.stem.binder.Convert2FeatureClass.change2FeatureClass("testDoc", importedDoc);
			 IndoorFeaturesType resultDoc = edu.pnu.stem.binder.Convert2JaxbClass.change2JaxbClass("testDoc",featureDoc);
			 edu.pnu.stem.binder.Mashaller.marshalIndoorFeatures(null, resultDoc);
			 
		 } catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
