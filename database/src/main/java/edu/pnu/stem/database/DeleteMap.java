package edu.pnu.stem.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeleteMap {
	public static void dropMap(Connection connection, String docId) {
		try {
			Statement st = connection.createStatement();
			
			List<String> tableName = new ArrayList<String>();
			tableName.add("IndoorFeatures");
			tableName.add("PrimalSpaceFeatures");
			tableName.add("MultiLayeredGraph");
			tableName.add("CellSpace");
			tableName.add("CellSpaceBoundary");
			tableName.add("SpaceLayers");
			tableName.add("SpaceLayer");
			tableName.add("Nodes");
			tableName.add("Edges");
			tableName.add("State");
			tableName.add("Transition");
			tableName.add("InterEdges");
			tableName.add("InterLayerConnection");
			tableName.add("Geometry");
			tableName.add("Feature");
			//tableName.add("Documents");

			for (int i = 0; i < tableName.size(); i++) {
				//String clearDB = "Drop table If Exists `" + tableName.get(i) + "`";
				String deleteDoc = "Delete from "+tableName.get(i) + " where documentid = "+SqlUtil.change2SqlString(docId);
				//System.out.println(deleteDoc);
				st.executeUpdate(deleteDoc);
			}
			String deleteDoc = "Delete from Documents where id="+SqlUtil.change2SqlString(docId);
			st.executeUpdate(deleteDoc);
			System.out.println("Delete document which ID is :"+docId);
			st.close();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
