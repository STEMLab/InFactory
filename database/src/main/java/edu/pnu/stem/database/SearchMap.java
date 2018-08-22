package edu.pnu.stem.database;

import java.io.IOException;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.CellSpaceBoundary;
import edu.pnu.stem.feature.Edges;
import edu.pnu.stem.feature.IndoorFeatures;
import edu.pnu.stem.feature.InterEdges;
import edu.pnu.stem.feature.InterLayerConnection;
import edu.pnu.stem.feature.MultiLayeredGraph;
import edu.pnu.stem.feature.Nodes;
import edu.pnu.stem.feature.PrimalSpaceFeatures;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.SpaceLayers;
import edu.pnu.stem.feature.State;
import edu.pnu.stem.feature.Transition;

public class SearchMap {

	public static IndoorGMLMap search(Connection connection, String docId) throws ClassNotFoundException, IOException {
		IndoorGMLMap result = new IndoorGMLMap();
		result.setDocId(docId);
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("Select * from Feature");
			while (rs.next()) {
				String id = rs.getString("id");
				String type = rs.getString("type");
				if (type.equals("IndoorFeatures")) {
					result.setFeature(id, "IndoorFeatures", searchIndoorFeatures(connection, result, id));
				} else if (type.equals("MultiLayeredGraph")) {
					result.setFeature(id, "MultiLayeredGraph", searchMultiLayeredGraph(connection, result, id));
				} else if (type.equals("PrimalSpaceFeatures")) {
					result.setFeature(id, "PrimalSpaceFeatures", searchPrimalSpaceFeatures(connection, result, id));
				} else if (type.equals("CellSpace")) {
					result.setFeature(id, "CellSpace", searchCellSpace(connection, result, id));
				} else if (type.equals("CellSpaceBoundary")) {
					result.setFeature(id, "CellSpaceBoundary", searchCellSpaceBoundary(connection, result, id));
				} else if (type.equals("SpaceLayers")) {
					result.setFeature(id, "SpaceLayers", searchSpaceLayers(connection, result, id));
				} else if (type.equals("SpaceLayer")) {
					result.setFeature(id, "SpaceLayer", searchSpaceLayer(connection, result, id));
				} else if (type.equals("Nodes")) {
					result.setFeature(id, "Nodes", searchNodes(connection, result, id));
				} else if (type.equals("Edges")) {
					result.setFeature(id, "Edges", searchEdges(connection, result, id));
				} else if (type.equals("State")) {
					result.setFeature(id, "State", searchState(connection, result, id));
				} else if (type.equals("Transition")) {
					result.setFeature(id, "Transition", searchTransition(connection, result, id));
				} else if (type.equals("InterEdges")) {
					result.setFeature(id, "InterEdges", searchInterEdges(connection, result, id));
				} else if (type.equals("InterLayerConnection")) {
					result.setFeature(id, "InterLayerConnection",
							searchInterLayerConnection(connection, result, id));
				} else if (type.equals("Geometry")) {
					result.setFeature4Geometry(id, searchGeometry(connection, result, id));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.setDocId(docId);
		return result;
	}

	private static Geometry searchGeometry(Connection connection, IndoorGMLMap result, String id)
			throws ClassNotFoundException, IOException {
		Geometry feature = null;

		String getgeomsql = "SELECT geom FROM Geometry WHERE id = '" + id + "'" + " AND documentid = " + SqlUtil.change2SqlString(result.getDocId());

		PreparedStatement pre;
		try {
			pre = connection.prepareStatement(getgeomsql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				Blob blob = rs.getBlob("geom");
				feature = SqlUtil.changeBinary2Geometry(blob);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;

	}

	public static IndoorFeatures searchIndoorFeatures(Connection connection, IndoorGMLMap map, String id) {
		IndoorFeatures feature = new IndoorFeatures(map, id);
		String sql = "SELECT * from IndoorFeatures where id =" + SqlUtil.change2SqlString(id) + " AND " + "documentId = " + SqlUtil.change2SqlString(map.getDocId());
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String primalSpaceFeatures = rs.getString("primalspacefeatures");
				String multiLayeredGraph = rs.getString("multiLayeredGraph");

				feature.setName(name);
				feature.setDescription(description);
				if (primalSpaceFeatures != null)
					feature.setPrimalSpaceFeatures(new PrimalSpaceFeatures(map, primalSpaceFeatures));
				if (multiLayeredGraph != null)
					feature.setMultiLayeredGraph(new MultiLayeredGraph(map, multiLayeredGraph));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;
	}

	public static PrimalSpaceFeatures searchPrimalSpaceFeatures(Connection connection, IndoorGMLMap map, String id) {
		PrimalSpaceFeatures feature = new PrimalSpaceFeatures(map, id);
		String sql = "SELECT * from PrimalSpaceFeatures where id =" + SqlUtil.change2SqlString(id) + " AND " + "documentId = " + SqlUtil.change2SqlString(map.getDocId());
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String parentId = rs.getString("parentId");
				String name = rs.getString("name");
				String description = rs.getString("description");
				if(rs.getArray("cellspacemember")!=null) {
					List<String> csm = SqlUtil.getArray(rs.getArray("cellspacemember"));
					List<CellSpace> csml = new ArrayList<CellSpace>();
					for (String c : csm) {
						csml.add(new CellSpace(map, c));
					}

					feature.setCellSpaceMember(csml);
				}
				
				if(rs.getArray("cellspaceboundarymember")!=null) {
					List<String> csbm = SqlUtil.getArray(rs.getArray("cellspaceboundarymember"));
					List<CellSpaceBoundary> csbml = new ArrayList<CellSpaceBoundary>();
					
					for (String c : csbm) {
						csbml.add(new CellSpaceBoundary(map, c));
					}

					feature.setCellSpaceBoundaryMember(csbml);
				}
	
				feature.setName(name);
				feature.setDescription(description);
				feature.setParent(new IndoorFeatures(map, parentId));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;
	}

	public static CellSpace searchCellSpace(Connection connection, IndoorGMLMap map, String id) throws ClassNotFoundException, IOException {
		CellSpace feature = new CellSpace(map, id);
		String sql = "SELECT * from CellSpace where id =" + SqlUtil.change2SqlString(id)+ " AND " + " documentId = " + SqlUtil.change2SqlString(map.getDocId());
		// String sql = "SELECT * from CellSpace";
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String parentId = rs.getString("parentId");
				String duality = rs.getString("duality");
				String geom = rs.getString("geometry");
				
				if(rs.getArray("partialboundedby") != null) {
					List<String> pb = SqlUtil.getArray(rs.getArray("partialboundedby"));
					List<CellSpaceBoundary> partialBoundedBy = new ArrayList<CellSpaceBoundary>();
					for (String c : pb) {
						partialBoundedBy.add(new CellSpaceBoundary(map, c));
					}
					feature.setPartialboundedBy(partialBoundedBy);
				}
				
				if(geom != null) {
					Geometry g = searchGeometry(connection,map,geom);
					feature.setGeometry(g);
				}
				
				feature.setName(name);
				feature.setDescription(description);
				feature.setParent(new PrimalSpaceFeatures(map, parentId));
				
				if (duality != null) {
					feature.setDuality(new State(map, duality));
				}
				

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;
	}

	public static CellSpaceBoundary searchCellSpaceBoundary(Connection connection, IndoorGMLMap map, String id) throws ClassNotFoundException, IOException {
		CellSpaceBoundary feature = new CellSpaceBoundary(map, id);
		String sql = "SELECT * from CellSpaceBoundary where id =" + SqlUtil.change2SqlString(id)+ " AND " + "documentId = " + SqlUtil.change2SqlString(map.getDocId());;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String parentId = rs.getString("parentId");
				String duality = rs.getString("duality");
				String primalSpaceFeatures = rs.getString("primalspacefeatures");
				String multiLayeredGraph = rs.getString("multiLayeredGraph");
				String geom = rs.getString("geometry");

				if (duality != null)
					feature.setDuality(new Transition(map, duality));
				
				if(geom != null) {
					Geometry g = searchGeometry(connection,map,geom);
					feature.setGeometry(g);
				}
				feature.setName(name);
				feature.setDescription(description);
				feature.setParent(new PrimalSpaceFeatures(map, parentId));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;
	}

	public static MultiLayeredGraph searchMultiLayeredGraph(Connection connection, IndoorGMLMap map, String id) {
		MultiLayeredGraph feature = new MultiLayeredGraph(map, id);
		String sql = "SELECT * from MultiLayeredGraph where id =" + SqlUtil.change2SqlString(id)+ " AND " + "documentId = " + SqlUtil.change2SqlString(map.getDocId());;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String parentId = rs.getString("parentId");

				if (rs.getArray("InterEdges") != null) {
					List<String> ie = SqlUtil.getArray(rs.getArray("InterEdges"));
					List<InterEdges> iel = new ArrayList<InterEdges>();
					for (String i : ie) {
						iel.add(new InterEdges(map, i));
					}
					feature.setInterEdges(iel);
				}

				if (rs.getArray("SpaceLayers") != null) {
					List<String> sls = SqlUtil.getArray(rs.getArray("SpaceLayers"));
					List<SpaceLayers> slsl = new ArrayList<SpaceLayers>();

					for (String s : sls) {
						slsl.add(new SpaceLayers(map, s));
					}
					feature.setSpaceLayers(slsl);
				}

				feature.setName(name);
				feature.setParent(new IndoorFeatures(map, parentId));
				feature.setDescription(description);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;
	}

	public static SpaceLayers searchSpaceLayers(Connection connection, IndoorGMLMap map, String id) {
		SpaceLayers feature = new SpaceLayers(map, id);
		String sql = "SELECT * from SpaceLayers where id =" + SqlUtil.change2SqlString(id)+ " AND " + "documentId = " + SqlUtil.change2SqlString(map.getDocId());;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String parentId = rs.getString("parentId");

				feature.setName(name);
				feature.setDescription(description);

				if (rs.getArray("spacelayermember") != null) {
					List<String> sl = SqlUtil.getArray(rs.getArray("spacelayermember"));
					List<SpaceLayer> spacelayer = new ArrayList<SpaceLayer>();
					for (String s : sl) {
						spacelayer.add(new SpaceLayer(map, s));
					}
					feature.setSpaceLayerMember(spacelayer);

				}
				feature.setParent(new MultiLayeredGraph(map, parentId));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;
	}

	public static SpaceLayer searchSpaceLayer(Connection connection, IndoorGMLMap map, String id) {
		SpaceLayer feature = new SpaceLayer(map, id);
		String sql = "SELECT * from SpaceLayer where id =" + SqlUtil.change2SqlString(id)+ " AND " + "documentId = " + SqlUtil.change2SqlString(map.getDocId());;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String parentId = rs.getString("parentId");

				if (rs.getArray("nodes") != null) {
					List<String> n = SqlUtil.getArray(rs.getArray("nodes"));
					List<Nodes> nodes = new ArrayList<Nodes>();

					for (String s : n) {
						nodes.add(new Nodes(map, s));
					}
					feature.setNodes(nodes);

				}

				if (rs.getArray("edges") != null) {
					List<String> e = SqlUtil.getArray(rs.getArray("edges"));
					List<Edges> edges = new ArrayList<Edges>();

					for (String s : e) {
						edges.add(new Edges(map, s));
					}
					feature.setEdges(edges);

				}

				feature.setName(name);
				feature.setDescription(description);
				feature.setParent(new SpaceLayers(map, parentId));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;
	}

	public static Nodes searchNodes(Connection connection, IndoorGMLMap map, String id) {
		Nodes feature = new Nodes(map, id);
		String sql = "SELECT * from IndoorFeatures where id =" + SqlUtil.change2SqlString(id)+ " AND " + "documentId = " + SqlUtil.change2SqlString(map.getDocId());;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String parentId = rs.getString("parentId");

				feature.setName(name);
				feature.setDescription(description);

				if (rs.getArray("statemember") != null) {
					List<String> sm = SqlUtil.getArray(rs.getArray("statemember"));
					List<State> statemember = new ArrayList<State>();

					for (String s : sm) {
						statemember.add(new State(map, s));
					}

					feature.setStateMember(statemember);

				}
				feature.setParent(new SpaceLayer(map, parentId));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;
	}

	public static Edges searchEdges(Connection connection, IndoorGMLMap map, String id) {
		Edges feature = new Edges(map, id);
		String sql = "SELECT * from Edges where id =" + SqlUtil.change2SqlString(id)+ " AND " + "documentId = " + SqlUtil.change2SqlString(map.getDocId());;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String parentId = rs.getString("parentId");

				if (rs.getArray("transitionMember") != null) {
					List<String> sm = SqlUtil.getArray(rs.getArray("transitionmember"));
					List<Transition> statemember = new ArrayList<Transition>();

					for (String s : sm) {
						statemember.add(new Transition(map, s));
					}

					feature.setTransitionMembers(statemember);

				}
				feature.setParent(new SpaceLayer(map, parentId));

				feature.setName(name);
				feature.setDescription(description);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;
	}

	public static State searchState(Connection connection, IndoorGMLMap map, String id) throws ClassNotFoundException, IOException {
		State feature = new State(map, id);
		String sql = "SELECT * from State where id =" + SqlUtil.change2SqlString(id)+ " AND " + "documentId = " + SqlUtil.change2SqlString(map.getDocId());;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String parentId = rs.getString("parentId");
				String duality = rs.getString("duality");
				String geom = rs.getString("geometry");

				if (rs.getArray("connects") != null) {
					List<String> c = SqlUtil.getArray(rs.getArray("connects"));

					List<Transition> t = new ArrayList<Transition>();

					for (String i : c) {
						t.add(new Transition(map, id));
					}

					feature.setConnects(t);
				}
				if(geom != null) {
					
					Geometry g = searchGeometry(connection,map,geom);
					feature.setGeometry(g);
				}

				feature.setName(name);
				feature.setDescription(description);
				if (duality != null) {
					feature.setDuality(new CellSpace(map, duality));
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;
	}

	public static Transition searchTransition(Connection connection, IndoorGMLMap map, String id) throws ClassNotFoundException, IOException {
		Transition feature = new Transition(map, id);
		String sql = "SELECT * from Transition where id =" + SqlUtil.change2SqlString(id)+ " AND " + "documentId = " + SqlUtil.change2SqlString(map.getDocId());;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String parentId = rs.getString("parentId");
				String geom = rs.getString("geometry");
				String duality = rs.getString("duality");

				if (rs.getArray("connects") != null) {
					List<String> c = SqlUtil.getArray(rs.getArray("connects"));

					State[] t = new State[2];

					t[0] = new State(map, c.get(0));
					t[1] = new State(map, c.get(1));

					feature.setConnects(t);
				}
				
				if(geom != null) {
					Geometry g = searchGeometry(connection,map,geom);
					feature.setGeometry(g);
				}
				
				feature.setName(name);
				feature.setDescription(description);

				if (duality != null) {
					feature.setDuality(new CellSpaceBoundary(map, duality));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;
	}

	public static InterEdges searchInterEdges(Connection connection, IndoorGMLMap map, String id) {
		InterEdges feature = new InterEdges(map, id);
		String sql = "SELECT * from InterEdges where id =" + SqlUtil.change2SqlString(id)+ " AND " + "documentId = " + SqlUtil.change2SqlString(map.getDocId());;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String parentId = rs.getString("parentId");

				feature.setName(name);
				feature.setDescription(description);
				feature.setParent(new MultiLayeredGraph(map, parentId));

				if (rs.getArray("InterLayerConnectionMember") != null) {
					List<String> c = SqlUtil.getArray(rs.getArray("connects"));

					List<InterLayerConnection> t = new ArrayList<InterLayerConnection>();

					for (String i : c) {
						t.add(new InterLayerConnection(map, id));
					}

					feature.setInterLayerConnectionMember(t);
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;
	}

	public static InterLayerConnection searchInterLayerConnection(Connection connection, IndoorGMLMap map, String id) {
		InterLayerConnection feature = new InterLayerConnection(map, id);
		String sql = "SELECT * from InterLayerConnection where id =" + SqlUtil.change2SqlString(id)+ " AND " + "documentId = " + SqlUtil.change2SqlString(map.getDocId());;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String parentId = rs.getString("parentId");

				if (rs.getArray("connecteLayers") != null) {
					List<String> c = SqlUtil.getArray(rs.getArray("connectedLayers"));

					SpaceLayer[] t = new SpaceLayer[2];

					t[0] = new SpaceLayer(map, c.get(0));
					t[1] = new SpaceLayer(map, c.get(1));

					feature.setConnectedLayers(t);
				}

				if (rs.getArray("interConnects") != null) {
					List<String> c = SqlUtil.getArray(rs.getArray("interConnects"));

					State[] t = new State[2];

					t[0] = new State(map, c.get(0));
					t[1] = new State(map, c.get(1));

					feature.setInterConnects(t);
				}
				feature.setName(name);
				feature.setDescription(description);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feature;
	}

}
