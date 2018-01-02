package edu.pnu.stem;

import javax.xml.bind.JAXBException;

import junit.framework.TestCase;

public class testApp extends TestCase {
 public void testConverter(){
	 try {
		edu.pnu.stem.binder.Convert2FeatureClass.change2FeatureClass(edu.pnu.stem.binder.Unmashaller.importIndoorGML("test","src/test/resources/converted.gml"));
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
