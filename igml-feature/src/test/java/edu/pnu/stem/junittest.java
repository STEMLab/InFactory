package edu.pnu.stem;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.core.CellSpace;
import edu.pnu.stem.feature.core.Edges;
import edu.pnu.stem.feature.core.IndoorFeatures;
import edu.pnu.stem.feature.core.MultiLayeredGraph;
import edu.pnu.stem.feature.core.Nodes;
import edu.pnu.stem.feature.core.PrimalSpaceFeatures;
import edu.pnu.stem.feature.core.SpaceLayer;
import edu.pnu.stem.feature.core.SpaceLayers;
import edu.pnu.stem.feature.core.State;
import edu.pnu.stem.feature.core.Transition;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;

public class junittest {
    private static IndoorGMLMap map = new IndoorGMLMap();
    private static IndoorFeaturesType doc;
    private static IndoorFeatures testObject;
    
     @BeforeClass    
     public static void InitXMLtoJava() {
        try {         
            map.setDocId("test");        
            doc = edu.pnu.stem.binder.Unmashaller.importIndoorGML("test","src/test/resources/example1.gml");
            testObject = edu.pnu.stem.binder.Convert2FeatureClass.change2FeatureClass(map,"test", doc);
        } catch (JAXBException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
     }
    // @Ignore
     @Test//primespace id check
     public void PriamlSpace_id(){
    	 IndoorFeatures indoor_features=(IndoorFeatures)map.getFeature("IFs");
    	 assertEquals("PS1",indoor_features.getPrimalSpaceFeatures().getId());
     }
     
     
     @Ignore
     @Test//Cellspace id check
     public void cellspace_id(){
    	 PrimalSpaceFeatures primalspace_features=(PrimalSpaceFeatures)map.getFeature("PS1");
    	 Set <String> cellspaceMember = new HashSet<String>();
       	 Set <String> cellspaceMember_temp = new HashSet<String>();
       	 cellspaceMember_temp.add("");
       	 for(int i=0;i<primalspace_features.getCellSpaceMember().size();i++){
       		 cellspaceMember.add(primalspace_features.getCellSpaceMember().get(i).getId());
       	 }
       	assertEquals(cellspaceMember,cellspaceMember_temp);
     }
     
     @Ignore
     @Test//Cellspace boundary id check
     public void cellspace_boundary_id(){
    	 PrimalSpaceFeatures primalspace_features=(PrimalSpaceFeatures)map.getFeature("PS1");
    	 Set <String> cellspaceboundaryMember = new HashSet<String>();
       	 Set <String> cellspaceboundaryMember_temp = new HashSet<String>();
       	cellspaceboundaryMember_temp.add("");
       	for(int i=0;i<primalspace_features.getCellSpaceBoundaryMember().size();i++){
       		cellspaceboundaryMember.add(primalspace_features.getCellSpaceBoundaryMember().get(i).getId());
       	}
    	assertEquals(cellspaceboundaryMember,cellspaceboundaryMember_temp);
     }

     @Ignore
     @Test//Multilayered id check
     public void multilayered_id(){
    	 IndoorFeatures indoor_features=(IndoorFeatures)map.getFeature("IFs");
    	 assertEquals("MG1",indoor_features.getMultiLayeredGraph().getId());
     }
     @Ignore
     @Test//spacelayers id check
     public void spacelayers_id(){
    	 MultiLayeredGraph multilayered_feature = (MultiLayeredGraph)map.getFeature("MG1");//Parent
    	 Set<String> spaceLayersMember_temp = new HashSet<String>();
      	 Set<String> spaceLayersMember = new HashSet<String>();
      	 spaceLayersMember_temp.add("SL1");//expect
    	 for(int i=0;i<multilayered_feature.getSpaceLayers().size();i++){
    		 spaceLayersMember.add(multilayered_feature.getSpaceLayers().get(i).getId());
    	 }
    	 assertEquals(spaceLayersMember,spaceLayersMember_temp);
     }
     @Ignore
     @Test//spacelayer id check
     public void spacelayer_id(){
    	 SpaceLayers spacelayers_feature=(SpaceLayers)map.getFeature("SL1");//Parent
    	 Set<String> spaceLayerMember_temp = new HashSet<String>();
      	 Set<String> spaceLayerMember = new HashSet<String>();
      	 spaceLayerMember_temp.add("IS1");//expect
      	 for(int i=0;i<spacelayers_feature.getSpaceLayerMember().size();i++){
      		spaceLayerMember.add(spacelayers_feature.getSpaceLayerMember().get(i).getId());
    	 }
      	assertEquals(spaceLayerMember,spaceLayerMember_temp);
     }
     @Ignore
     @Test//Node id check
     public void node_id(){
    	 SpaceLayer spacelayer_feature=(SpaceLayer)map.getFeature("IS1");//parent
    	 Set<String> nodeMember_temp = new HashSet<String>();
    	 Set<String> nodeMember = new HashSet<String>();
    	 nodeMember_temp.add("N1");//expect
    	 for(int i=0;i<spacelayer_feature.getNodes().size();i++){
       		nodeMember.add(spacelayer_feature.getNodes().get(i).getId());
     	 }
    	 assertEquals(nodeMember,nodeMember_temp);
    }
     @Ignore
     @Test//edge id check
     public void edge_id(){
    	 SpaceLayer spacelayer_feature=(SpaceLayer)map.getFeature("IS1");//parent
    	 Set<String> edgeMember_temp = new HashSet<String>();
    	 Set<String> edgeMember = new HashSet<String>();
    	 edgeMember_temp.add("E1");//expect
    	 for(int i=0;i<spacelayer_feature.getEdges().size();i++){
       		edgeMember.add(spacelayer_feature.getEdges().get(i).getId());
     	 }
    	 assertEquals(edgeMember,edgeMember_temp);
     }
     @Ignore
     @Test//state id check
     public void state_id(){
    	 Nodes node_feature=(Nodes)map.getFeature("N1");//parent
    	 Set<String> stateMember_temp = new HashSet<String>();
    	 Set<String> stateMember = new HashSet<String>();
    	 stateMember_temp.add("R1");//expect
    	 for(int i=0;i<node_feature.getStateMember().size();i++){
       		stateMember.add(node_feature.getStateMember().get(i).getId());
     	 }
    	 assertEquals(stateMember_temp,stateMember);
     }
     @Ignore
     @Test//transition id check
     public void transition_id(){
    	 Edges edge_feature=(Edges)map.getFeature("E1");//parent
    	 Set<String> transitionMember_temp = new HashSet<String>();
    	 Set<String> transitionMember = new HashSet<String>();
    	 transitionMember_temp.add("T0");//expect
    	 for(int i=0;i<edge_feature.getTransitionMember().size();i++){
       		transitionMember.add(edge_feature.getTransitionMember().get(i).getId());
     	 }
    	 assertEquals(transitionMember_temp,transitionMember);
     }
     @Ignore
     @Test//state_duality id check
     public void state_duality_id(){
    	 State state_feature = (State)map.getFeature("R1");
    	 String expect_id="C1";
    	 assertEquals(expect_id,state_feature.getDuality().getId());
     }
     @Ignore
     @Test//state_coonects id check
     public void state_connects_id(){
    	 State state_feature = (State)map.getFeature("R1");
    	 Set<String> connectsMember = new HashSet<String>();
    	 Set<String> connectsMember_temp = new HashSet<String>();
    	 connectsMember_temp.add("T1");
    	 connectsMember_temp.add("T0");
    	 for(int i=0;i<state_feature.getConnects().size();i++){
    		 connectsMember.add(state_feature.getConnects().get(i).getId());
    	 }
    	 assertEquals(connectsMember_temp,connectsMember);
    	 
     }
     @Ignore
     @Test//transition_duality_id check
     public void transition_duality_id(){
    	 Transition transition_feature = (Transition)map.getFeature("T0");
    	 String expect_id="";
    	 //gSystem.out.println(transition_feature.getDuality().getId());
    	 assertEquals(expect_id,transition_feature.getDuality().getId());
     }
     
     @Ignore
     @Test//Cellspace duality id check
     public void cellspace_duality_id(){
    	CellSpace cellspace_feature = (CellSpace)map.getFeature("");
    	String expect_id="";
    	assertEquals(expect_id,cellspace_feature.getDuality().getId());
     }

}