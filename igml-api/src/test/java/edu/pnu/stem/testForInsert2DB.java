package edu.pnu.stem;

import java.sql.Connection;

import org.h2.tools.Server;

import edu.pnu.stem.api.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.database.Connector;
import edu.pnu.stem.database.InsertMap;
import edu.pnu.stem.database.SearchMap;
import edu.pnu.stem.feature.IndoorFeatures;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;


public class testForInsert2DB {
	public static void main(String[] args) throws Exception {
		/*
		 IndoorGMLMap map = Container.createDocument("test");
		IndoorFeaturesType doc = edu.pnu.stem.binder.Unmashaller.importIndoorGML("test","src/test/resources/FJK_1_0_3.gml");
		Server server = Server.createTcpServer("-tcpAllowOthers", "-tcpPort", "9092").start(); // (4b)
		Server webServer = Server.createWebServer("-webAllowOthers", "-webPort", "8082").start(); // (4a)
		IndoorFeatures savedDoc = edu.pnu.stem.binder.Convert2FeatureClass.change2FeatureClass(map,"test", doc);	
		Connection connection = Connector.createConnection();
		insertMap.insert(connection, map);
		IndoorGMLMap testedResult = searchMap.search(connection, "test");
		edu.pnu.stem.binder.Mashaller.marshalDocument(null, testedResult);
		 * */
		
	}
}
