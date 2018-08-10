package edu.pnu.stem.database;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.vividsolutions.jts.geom.Geometry;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.CellSpaceBoundary;
import edu.pnu.stem.feature.Edges;
import edu.pnu.stem.feature.IndoorFeatures;
import edu.pnu.stem.feature.InterEdges;
import edu.pnu.stem.feature.MultiLayeredGraph;
import edu.pnu.stem.feature.Nodes;
import edu.pnu.stem.feature.PrimalSpaceFeatures;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.SpaceLayers;
import edu.pnu.stem.feature.State;
import edu.pnu.stem.feature.Transition;
import edu.pnu.stem.util.GeometryUtil;

public class insertMap {
	public static void insert(Connection connection, IndoorGMLMap map) throws IOException, SQLException {

		List<String> containerNameList = new ArrayList<String>();
		containerNameList.add("IndoorFeatures");
		containerNameList.add("MultiLayeredGraph");
		containerNameList.add("PrimalSpaceFeatures");
		containerNameList.add("CellSpace");
		containerNameList.add("CellSpaceBoundary");
		containerNameList.add("SpaceLayers");
		containerNameList.add("SpaceLayer");
		containerNameList.add("Nodes");
		containerNameList.add("Edges");
		containerNameList.add("State");
		containerNameList.add("Transition");
		containerNameList.add("Geometry");

		for (String name : containerNameList) {
			ConcurrentHashMap<String, Object> featureContainer = map.getFeatureContainer(name);
			for (Entry<String, Object> elem : featureContainer.entrySet()) {
				if (name.equals("Geometry"))
					insertGeometry(connection, GeometryUtil.getMetadata((Geometry) elem.getValue(), "id"),
							(Geometry) elem.getValue());
				else {
					String sql = createInsertSql(elem.getValue());
					Statement st;
					try {
						st = connection.createStatement();
						st.execute(sql);
					} catch (SQLException e) {
						System.out.println("error at insert " + name);
						e.printStackTrace();
					}
				}

			}
		}
		
		insertSql4Id(connection,map.getFeatureContainer("ID"));
	

	}

	public static String createInsertSql(Object feature) {
		String sql = null;
		if (feature instanceof IndoorFeatures)
			sql = createInsertSql4IndoorFeatures((IndoorFeatures) feature);
		else if (feature instanceof PrimalSpaceFeatures)
			sql = createInsertSql4PrimalSpaceFeatures((PrimalSpaceFeatures) feature);
		else if (feature instanceof CellSpace)
			sql = createInsertSql4CellSpace((CellSpace) feature);
		else if (feature instanceof CellSpaceBoundary)
			sql = createInsertSql4CellSpaceBoundary((CellSpaceBoundary) feature);
		else if (feature instanceof MultiLayeredGraph)
			sql = createInsertSql4MultiLayeredGraph((MultiLayeredGraph) feature);
		else if (feature instanceof SpaceLayers)
			sql = createInsertSql4SpaceLayers((SpaceLayers) feature);
		else if (feature instanceof SpaceLayer)
			sql = createInsertSql4SpaceLayer((SpaceLayer) feature);
		else if (feature instanceof Nodes)
			sql = createInsertSql4Nodes((Nodes) feature);
		else if (feature instanceof Edges)
			sql = createInsertSql4Edges((Edges) feature);
		else if (feature instanceof State)
			sql = createInsertSql4State((State) feature);
		else if (feature instanceof Transition)
			sql = createInsertSql4Transition((Transition) feature);

		return sql;
	}
	
	public static void insertSql4Id(Connection connection, ConcurrentHashMap<String,Object> map) {
		for (Entry<String, Object> elem : map.entrySet()) {
				String sql =  "Insert into" + "Feature" + "values(" + elem.getKey() + "," + (String)elem.getValue() + ")";
				Statement st;
				try {
					st = connection.createStatement();
					st.execute(sql);
				} catch (SQLException e) {
					System.out.println("error at insert feature id");
					e.printStackTrace();
				}
			}
		
	}

	public static String createInsertSql4IndoorFeatures(IndoorFeatures feature) {
		String tableName = "IndoorFeatures";

		String id = feature.getId();
		String name = feature.getName();
		String description = feature.getDescription();
		String primalspacefeatures = feature.getPrimalSpaceFeatures().getId();
		String multilayeredgraph = feature.getMultiLayeredGraph().getId();

		String sql = "Insert into" + tableName + "values(" + id + "," + name + "," + description + ","
				+ primalspacefeatures + "," + multilayeredgraph + ")";
		return sql;

	}

	public static String createInsertSql4PrimalSpaceFeatures(PrimalSpaceFeatures feature) {
		String sql = null;
		String tableName = "PrimalSpaceFeatures";

		String id = feature.getId();
		String parentid = feature.getParent().getId();
		String name = feature.getName();
		String description = feature.getDescription();

		String csm = "(";
		for (CellSpace c : feature.getCellSpaceMember()) {
			csm += c.getId();
			csm += ',';
		}
		csm = csm.substring(0, csm.length() - 1);
		csm += ")";

		String csbm = "(";
		for (CellSpaceBoundary c : feature.getCellSpaceBoundaryMember()) {
			csbm += c.getId();
			csbm += ',';
		}
		csbm = csbm.substring(0, csm.length() - 1);
		csbm += ")";

		sql = "Insert into" + tableName + "values(" + id + "," + parentid + "," + name + "," + description + "," + csm
				+ "," + csbm + ")";
		return sql;

	}

	public static String createInsertSql4CellSpace(CellSpace feature) {
		String sql = null;
		String tableName = "CellSpace";

		String id = feature.getId();
		String parentid = feature.getParent().getId();
		String name = feature.getName();
		String description = feature.getDescription();
		String duality = feature.getDuality().getId();
		String geom = null;
		if (feature.getGeometry() != null)
			geom = GeometryUtil.getMetadata(feature.getGeometry(), "id");

		String partiallboundedby = "(";
		for (CellSpaceBoundary c : feature.getPartialboundedBy()) {
			partiallboundedby += c.getId();
			partiallboundedby += ',';
		}
		partiallboundedby = partiallboundedby.substring(0, partiallboundedby.length() - 1);
		partiallboundedby += ")";

		sql = "Insert into" + tableName + "values(" + id + "," + parentid + "," + name + "," + description + ","
				+ duality + "," + partiallboundedby + "," + geom + ")";
		return sql;
	}

	public static String createInsertSql4CellSpaceBoundary(CellSpaceBoundary feature) {
		String sql = null;
		String tableName = "CellSpaceBoundary";

		String id = feature.getId();
		String parentid = feature.getParent().getId();
		String name = feature.getName();
		String description = feature.getDescription();
		String duality = feature.getDuality().getId();
		String geom = null;
		if (feature.getGeometry() != null)
			geom = GeometryUtil.getMetadata(feature.getGeometry(), "id");

		sql = "Insert into" + tableName + "values(" + id + "," + parentid + "," + name + "," + description + ","
				+ duality + "," + geom + ")";
		return sql;
	}

	public static String createInsertSql4MultiLayeredGraph(MultiLayeredGraph feature) {
		String sql = null;
		String tableName = "MultiLayeredGraph";

		String id = feature.getId();
		String parentid = feature.getParent().getId();
		String name = feature.getName();
		String description = feature.getDescription();

		String csm = "(";
		for (SpaceLayers c : feature.getSpaceLayers()) {
			csm += c.getId();
			csm += ',';
		}
		csm = csm.substring(0, csm.length() - 1);
		csm += ")";

		String csbm = "(";
		for (InterEdges c : feature.getInterEdges()) {
			csbm += c.getId();
			csbm += ',';
		}
		csbm = csbm.substring(0, csm.length() - 1);
		csbm += ")";

		sql = "Insert into" + tableName + "values(" + id + "," + parentid + "," + name + "," + description + "," + csm
				+ "," + csbm + ")";
		return sql;
	}

	public static String createInsertSql4SpaceLayers(SpaceLayers feature) {
		String sql = null;
		String tableName = "SpaceLayers";

		String id = feature.getId();
		String parentid = feature.getParent().getId();
		String name = feature.getName();
		String description = feature.getDescription();

		String csm = "(";
		for (SpaceLayer c : feature.getSpaceLayerMember()) {
			csm += c.getId();
			csm += ',';
		}
		csm = csm.substring(0, csm.length() - 1);
		csm += ")";

		sql = "Insert into" + tableName + "values(" + id + "," + parentid + "," + name + "," + description + "," + csm
				+ ")";
		return sql;
	}

	public static String createInsertSql4SpaceLayer(SpaceLayer feature) {
		String sql = null;
		String tableName = "SpaceLayer";

		String id = feature.getId();
		String parentid = feature.getParent().getId();
		String name = feature.getName();
		String description = feature.getDescription();

		String csm = "(";
		for (Nodes c : feature.getNodes()) {
			csm += c.getId();
			csm += ',';
		}
		csm = csm.substring(0, csm.length() - 1);
		csm += ")";

		String csbm = "(";
		for (Edges c : feature.getEdges()) {
			csbm += c.getId();
			csbm += ',';
		}
		csbm = csbm.substring(0, csm.length() - 1);
		csbm += ")";

		sql = "Insert into" + tableName + "values(" + id + "," + parentid + "," + name + "," + description + "," + csm
				+ "," + csbm + ")";
		return sql;
	}

	public static String createInsertSql4Nodes(Nodes feature) {
		String sql = null;
		String tableName = "Nodes";

		String id = feature.getId();
		String parentid = feature.getParent().getId();
		String name = feature.getName();
		String description = feature.getDescription();

		String csm = "(";
		for (State c : feature.getStateMember()) {
			csm += c.getId();
			csm += ',';
		}
		csm = csm.substring(0, csm.length() - 1);
		csm += ")";

		sql = "Insert into" + tableName + "values(" + id + "," + parentid + "," + name + "," + description + "," + csm
				+ ")";
		return sql;
	}

	public static String createInsertSql4Edges(Edges feature) {
		String sql = null;
		String tableName = "Edges";

		String id = feature.getId();
		String parentid = feature.getParent().getId();
		String name = feature.getName();
		String description = feature.getDescription();

		String csm = "(";
		for (Transition c : feature.getTransitionMember()) {
			csm += c.getId();
			csm += ',';
		}
		csm = csm.substring(0, csm.length() - 1);
		csm += ")";

		sql = "Insert into" + tableName + "values(" + id + "," + parentid + "," + name + "," + description + "," + csm
				+ ")";
		return sql;
	}

	public static String createInsertSql4State(State feature) {
		String sql = null;
		String tableName = "State";

		String id = feature.getId();
		String parentid = feature.getParent().getId();
		String name = feature.getName();
		String description = feature.getDescription();
		String duality = feature.getDuality().getId();
		String geom = null;
		if (feature.getGeometry() != null)
			geom = GeometryUtil.getMetadata(feature.getGeometry(), "id");

		String connects = "(";
		for (Transition c : feature.getConnects()) {
			connects += c.getId();
			connects += ',';
		}
		connects = connects.substring(0, connects.length() - 1);
		connects += ")";

		sql = "Insert into" + tableName + "values(" + id + "," + parentid + "," + name + "," + description + ","
				+ duality + "," + connects + "," + geom + ")";
		return sql;
	}

	public static String createInsertSql4Transition(Transition feature) {
		String sql = null;
		String tableName = "Transition";

		String id = feature.getId();
		String parentid = feature.getParent().getId();
		String name = feature.getName();
		String description = feature.getDescription();
		String duality = feature.getDuality().getId();
		String geom = null;
		if (feature.getGeometry() != null)
			geom = GeometryUtil.getMetadata(feature.getGeometry(), "id");

		String connects = "(";
		for (State c : feature.getConnects()) {
			connects += c.getId();
			connects += ',';
		}
		connects = connects.substring(0, connects.length() - 1);
		connects += ")";

		sql = "Insert into" + tableName + "values(" + id + "," + parentid + "," + name + "," + description + ","
				+ duality + "," + connects + "," + geom + ")";
		return sql;
	}

	public static byte[] changeGeometry2Binary(Geometry geom) throws IOException {
		byte[] result;

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(geom);
		result = baos.toByteArray();

		return result;
	}

	public static void insertGeometry(Connection connection, String id, Geometry geom)
			throws IOException, SQLException {
		PreparedStatement pre = connection.prepareStatement("insert into geometry(id,geom)values(?,?)");
		byte[] serializedmember = changeGeometry2Binary(geom);
		pre.setString(1, id);
		pre.setBytes(2, serializedmember);
		pre.executeUpdate();
	}
}
