package edu.pnu.stem;

import edu.pnu.stem.api.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.IndoorFeatures;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;

public class testForInsert2DB {
	public static void main(String[] args) throws Exception {
		IndoorGMLMap map = Container.createDocument("test");
		IndoorFeaturesType doc = edu.pnu.stem.binder.Unmashaller.importIndoorGML("test","src/test/resources/FJK_1_0_3.gml");
		IndoorFeatures savedDoc = edu.pnu.stem.binder.Convert2FeatureClass.change2FeatureClass(map,"test", doc);	
	}
}
