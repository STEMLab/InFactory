package edu.pnu.stem.database;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

public class searchMap {
	public static void search(Connection connection, String docId) {
		
	}
	public static IndoorFeatures searchIndoorFeatures(Connection connection, IndoorGMLMap map, String id) {
		IndoorFeatures feature = new IndoorFeatures(map, id);
		String sql = "SELECT * from IndoorFeatures where id ="+id;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String name = rs.getString("name");
			String description = rs.getString("description");
			String primalSpaceFeatures = rs.getString("primalspacefeatures");
			String multiLayeredGraph = rs.getString("multiLayeredGraph");
			
			feature.setName(name);
			feature.setDescription(description);
			feature.setPrimalSpaceFeatures(new PrimalSpaceFeatures(map,primalSpaceFeatures));
			feature.setMultiLayeredGraph(new MultiLayeredGraph(map,multiLayeredGraph));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feature;
	}
	
	public static List<String> getArray(Array a) throws SQLException {
		List<String> result = new ArrayList<String>();
		Object[] tempArr = (Object[]) a.getArray();
		for(Object o : tempArr) {
			result.add((String)o);
		}
		return result;
	}
	
	public static PrimalSpaceFeatures searchPrimalSpaceFeatures(Connection connection, IndoorGMLMap map, String id) {
		PrimalSpaceFeatures feature = new PrimalSpaceFeatures(map, id);
		String sql = "SELECT * from PrimalSpaceFeatures where id ="+id;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String parentId = rs.getString("parentId");
			String name = rs.getString("name");
			String description = rs.getString("description");
			List<String>csm = getArray(rs.getArray("cellspacemember"));
			List<String>csbm = getArray(rs.getArray("cellspaceboundarymember"));
 			
			List<CellSpace> csml = new ArrayList<CellSpace>();
			List<CellSpaceBoundary> csbml = new ArrayList<CellSpaceBoundary>();
			
			feature.setName(name);
			feature.setDescription(description);
			
			for(String c : csm) {
				csml.add(new CellSpace(map,c));
			}
			for(String c : csbm) {
				csbml.add(new CellSpaceBoundary(map,c));
			}
			
			feature.setCellSpaceMember(csml);
			feature.setCellSpaceBoundaryMember(csbml);
			feature.setParent(new IndoorFeatures(map,parentId));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feature;
	}
	public static CellSpace searchCellSpace(Connection connection, IndoorGMLMap map, String id) {
		CellSpace feature = new CellSpace(map, id);
		String sql = "SELECT * from CellSpace where id ="+id;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String name = rs.getString("name");
			String description = rs.getString("description");
			String parentId = rs.getString("parentId");
			String duality = rs.getString("duality");
			List<String>pb = getArray(rs.getArray("partialboundedby"));
			List<CellSpaceBoundary>partialBoundedBy = new ArrayList<CellSpaceBoundary>();
			for(String c : pb) {
				partialBoundedBy.add(new CellSpaceBoundary(map,c));
			}
			
			feature.setName(name);
			feature.setDescription(description);
			feature.setParent(new PrimalSpaceFeatures(map,parentId));
			feature.setDuality(new State(map, duality));
			feature.setPartialboundedBy(partialBoundedBy);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feature;
	}
	public static CellSpaceBoundary searchCellSpaceBoundary(Connection connection, IndoorGMLMap map, String id) {
		CellSpaceBoundary feature = new CellSpaceBoundary(map, id);
		String sql = "SELECT * from CellSpaceBoundary where id ="+id;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String name = rs.getString("name");
			String description = rs.getString("description");
			String parentId = rs.getString("parentId");
			String duality = rs.getString("duality");
			String primalSpaceFeatures = rs.getString("primalspacefeatures");
			String multiLayeredGraph = rs.getString("multiLayeredGraph");
			
			feature.setDuality(new Transition(map,duality));
			feature.setName(name);
			feature.setDescription(description);
			feature.setParent(new PrimalSpaceFeatures(map,parentId));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feature;
	}
	public static MultiLayeredGraph searchMultiLayeredGraph(Connection connection, IndoorGMLMap map, String id) {
		MultiLayeredGraph feature = new MultiLayeredGraph(map, id);
		String sql = "SELECT * from MultiLayeredGraph where id ="+id;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String name = rs.getString("name");
			String description = rs.getString("description");
			String parentId = rs.getString("parentId");
			List<String>ie = getArray(rs.getArray("InterEdges"));
			List<String>sls = getArray(rs.getArray("SpaceLayers"));
			
			List<InterEdges> iel = new ArrayList<InterEdges>();
			List<SpaceLayers>slsl = new ArrayList<SpaceLayers>();
			
			for(String i : ie) {
				iel.add(new InterEdges(map,i));
			}
			
			for(String s : sls) {
				slsl.add(new SpaceLayers(map,s));
			}
			
		
			feature.setName(name);
			feature.setParent(new IndoorFeatures(map,parentId));
			feature.setDescription(description);
			feature.setInterEdges(iel);
			feature.setSpaceLayers(slsl);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feature;
	}
	public static SpaceLayers searchSpaceLayers(Connection connection, IndoorGMLMap map, String id) {
		SpaceLayers feature = new SpaceLayers(map, id);
		String sql = "SELECT * from SpaceLayers where id ="+id;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String name = rs.getString("name");
			String description = rs.getString("description");
			String parentId = rs.getString("parentId");
			String primalSpaceFeatures = rs.getString("primalspacefeatures");
			String multiLayeredGraph = rs.getString("multiLayeredGraph");
			
			feature.setName(name);
			feature.setDescription(description);
			
			List<String>sl = getArray(rs.getArray("spacelayer"));
			List<SpaceLayer>spacelayer= new ArrayList<SpaceLayer>();
			for(String s : sl) {
				spacelayer.add(new SpaceLayer(map,s));
			}
			feature.setSpaceLayerMember(spacelayer);
			feature.setParent(new MultiLayeredGraph(map,parentId));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feature;
	}
	public static SpaceLayer searchSpaceLayer(Connection connection, IndoorGMLMap map, String id) {
		SpaceLayer feature = new SpaceLayer(map, id);
		String sql = "SELECT * from SpaceLayer where id ="+id;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String name = rs.getString("name");
			String description = rs.getString("description");
			String primalSpaceFeatures = rs.getString("primalspacefeatures");
			String parentId = rs.getString("parentId");
			String multiLayeredGraph = rs.getString("multiLayeredGraph");
			
			List<String>n = getArray(rs.getArray("nodes"));
			List<Nodes> nodes = new ArrayList<Nodes>();
			
			for(String s :n) {
				nodes.add(new Nodes(map,s));
			}
			
			List<String>e = getArray(rs.getArray("edges"));
			List<Edges> edges = new ArrayList<Edges>();
			
			for(String s :e) {
				edges.add(new Edges(map,s));
			}
			
			feature.setName(name);
			feature.setDescription(description);
			feature.setParent(new SpaceLayers(map,parentId));
			feature.setNodes(nodes);
			feature.setEdges(edges);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feature;
	}
	public static Nodes searchNodes(Connection connection, IndoorGMLMap map, String id) {
		Nodes feature = new Nodes(map, id);
		String sql = "SELECT * from IndoorFeatures where id ="+id;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String name = rs.getString("name");
			String description = rs.getString("description");
			String parentId = rs.getString("parentId");
			
			feature.setName(name);
			feature.setDescription(description);
			
			List<String>sm = getArray(rs.getArray("statemember"));
			List<State> statemember = new ArrayList<State>();
			
			for(String s :sm) {
				statemember.add(new State(map,s));
			}
			
			feature.setStateMember(statemember);
			feature.setParent(new SpaceLayer(map,parentId));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feature;
	}
	public static Edges searchEdges(Connection connection, IndoorGMLMap map, String id) {
		Edges feature = new Edges(map, id);
		String sql = "SELECT * from Edges where id ="+id;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String name = rs.getString("name");
			String description = rs.getString("description");
			String primalSpaceFeatures = rs.getString("primalspacefeatures");
			String multiLayeredGraph = rs.getString("multiLayeredGraph");
			String parentId = rs.getString("parentId");
			
			List<String>sm = getArray(rs.getArray("transitionmember"));
			List<Transition> statemember = new ArrayList<Transition>();
			
			for(String s :sm) {
				statemember.add(new Transition(map,s));
			}
			
			feature.setTransitionMembers(statemember);
			feature.setParent(new SpaceLayer(map,parentId));
			
			feature.setName(name);
			feature.setDescription(description);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feature;
	}
	public static State searchState(Connection connection, IndoorGMLMap map, String id) {
		State feature = new State(map, id);
		String sql = "SELECT * from State where id ="+id;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String name = rs.getString("name");
			String description = rs.getString("description");
			String parentId = rs.getString("parentId");
			
			feature.setName(name);
			feature.setDescription(description);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feature;
	}
	public static Transition searchTransition(Connection connection, IndoorGMLMap map, String id) {
		Transition feature = new Transition(map, id);
		String sql = "SELECT * from Transition where id ="+id;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String name = rs.getString("name");
			String description = rs.getString("description");
			String parentId = rs.getString("parentId");
			
			feature.setName(name);
			feature.setDescription(description);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feature;
	}
	public static  InterEdges searchInterEdges(Connection connection, IndoorGMLMap map, String id) {
		InterEdges feature = new InterEdges(map, id);
		String sql = "SELECT * from InterEdges where id ="+id;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String name = rs.getString("name");
			String description = rs.getString("description");
			String parentId = rs.getString("parentId");
			
			feature.setName(name);
			feature.setDescription(description);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feature;
	}
	public static InterLayerConnection searchInterLayerConnection(Connection connection, IndoorGMLMap map, String id) {
		InterLayerConnection feature = new InterLayerConnection(map, id);
		String sql = "SELECT * from InterLayerConnection where id ="+id;
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String name = rs.getString("name");
			String description = rs.getString("description");
			String parentId = rs.getString("parentId");
			
			feature.setName(name);
			feature.setDescription(description);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feature;
	}

}
