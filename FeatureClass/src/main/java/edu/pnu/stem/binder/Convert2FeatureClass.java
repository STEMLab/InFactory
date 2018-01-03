package edu.pnu.stem.binder;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import edu.pnu.stem.feature.AbstractFeature;
import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.CellSpaceBoundary;
import edu.pnu.stem.feature.Edges;
import edu.pnu.stem.feature.ExternalObjectReference;
import edu.pnu.stem.feature.ExternalReference;
import edu.pnu.stem.feature.IndoorFeatures;
import edu.pnu.stem.feature.InterEdges;
import edu.pnu.stem.feature.InterLayerConnection;
import edu.pnu.stem.feature.MultiLayeredGraph;
import edu.pnu.stem.feature.Nodes;
import edu.pnu.stem.feature.PrimalSpaceFeatures;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.SpaceLayerClassType;
import edu.pnu.stem.feature.SpaceLayers;
import edu.pnu.stem.feature.State;
import edu.pnu.stem.feature.Transition;
import edu.pnu.stem.feature.typeOfTopoExpressionCode;
import net.opengis.gml.v_3_2_1.AbstractFeatureType;
import net.opengis.gml.v_3_2_1.CompositeCurveType;
import net.opengis.gml.v_3_2_1.CompositeSolidType;
import net.opengis.gml.v_3_2_1.CompositeSurfaceType;
import net.opengis.gml.v_3_2_1.CurvePropertyType;
import net.opengis.gml.v_3_2_1.CurveType;
import net.opengis.gml.v_3_2_1.SolidType;
import net.opengis.gml.v_3_2_1.SurfaceType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceBoundaryGeometryType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceBoundaryMemberType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceBoundaryPropertyType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceBoundaryType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceGeometryType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceMemberType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceType;
import net.opengis.indoorgml.core.v_1_0.EdgesType;
import net.opengis.indoorgml.core.v_1_0.ExternalObjectReferenceType;
import net.opengis.indoorgml.core.v_1_0.ExternalReferenceType;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;
import net.opengis.indoorgml.core.v_1_0.InterEdgesType;
import net.opengis.indoorgml.core.v_1_0.InterLayerConnectionMemberType;
import net.opengis.indoorgml.core.v_1_0.InterLayerConnectionType;
import net.opengis.indoorgml.core.v_1_0.MultiLayeredGraphPropertyType;
import net.opengis.indoorgml.core.v_1_0.MultiLayeredGraphType;
import net.opengis.indoorgml.core.v_1_0.NodesType;
import net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturesPropertyType;
import net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturesType;
import net.opengis.indoorgml.core.v_1_0.SpaceLayerClassTypeType;
import net.opengis.indoorgml.core.v_1_0.SpaceLayerMemberType;
import net.opengis.indoorgml.core.v_1_0.SpaceLayerPropertyType;
import net.opengis.indoorgml.core.v_1_0.SpaceLayerType;
import net.opengis.indoorgml.core.v_1_0.SpaceLayersType;
import net.opengis.indoorgml.core.v_1_0.StateMemberType;
import net.opengis.indoorgml.core.v_1_0.StatePropertyType;
import net.opengis.indoorgml.core.v_1_0.StateType;
import net.opengis.indoorgml.core.v_1_0.TransitionMemberType;
import net.opengis.indoorgml.core.v_1_0.TransitionPropertyType;
import net.opengis.indoorgml.core.v_1_0.TransitionType;
import net.opengis.indoorgml.core.v_1_0.TypeOfTopoExpressionCodeEnumerationType;

public class Convert2FeatureClass {
	
	static AbstractFeature change2FeatureClass(AbstractFeatureType feature, String parentID) {
		AbstractFeature newFeature = new AbstractFeature();
		Object tempLocation = feature.getLocation().getValue();
		newFeature.id = feature.getId();
		newFeature.boundedBy = feature.getBoundedBy();
		return newFeature;
	}
	
	public static CellSpace change2FeatureClass(CellSpaceType feature, String parentID) {
		CellSpace newFeature = new CellSpace();

		StatePropertyType tempState = feature.getDuality();
		if(tempState != null){
	
			newFeature.setDuality(tempState.getHref());
		}
		
		newFeature.id = feature.getId();
		if (feature.getCellSpaceGeometry() != null) {
			CellSpaceGeometryType geo = feature.getCellSpaceGeometry();
			if (geo.getGeometry2D() != null) {
				Object o = geo.getGeometry2D().getAbstractSurface().getValue();
				if (o instanceof SurfaceType) {
					newFeature.setGeometry2D(((SurfaceType) o).getId());
					newFeature.setGeometryType("SurfaceType");
				} else if (o instanceof CompositeSurfaceType) {
					newFeature.setGeometry2D(((CompositeSurfaceType) o).getId());
					newFeature.setGeometryType("CompositeSurfaceType");
				}

			} else if (geo.getGeometry3D() != null) {
				Object o = geo.getGeometry3D().getAbstractSolid().getValue();
				if (o instanceof SolidType) {
					newFeature.setGeometry3D(((SolidType) o).getId());
					newFeature.setGeometryType("SolidType");
				} else if (o instanceof CompositeSolidType) {
					newFeature.setGeometry3D(((CompositeSolidType) o).getId());
					newFeature.setGeometryType("CompositeSolidType");
				}

			}
		} else {
			System.out.println("Converter : There is no Geometry Information");

		}

		List<CellSpaceBoundaryPropertyType> boundList = feature.getPartialboundedBy();
		List<String> csbList = new ArrayList<String>();

		for (int i = 0; i < boundList.size(); i++) {
			csbList.add(boundList.get(i).getHref());
		}
		newFeature.setPartialboundedBy(csbList);
		// newFeature.partialboundedBy = feature.getPartialboundedBy();

		return newFeature;
	}

	public static CellSpaceBoundary change2FeatureClass(CellSpaceBoundaryType feature, String parentID) {
		CellSpaceBoundary newFeature = new CellSpaceBoundary();
		
		newFeature.id = feature.getId();
		newFeature.setParentID(parentID);
		TransitionPropertyType tempTransition = feature.getDuality();
		if(tempTransition!=null){
			newFeature.setDuality(tempTransition.getHref());
		}
		
		CellSpaceBoundaryGeometryType geo = feature.getCellSpaceBoundaryGeometry();
		if (geo != null) {
			if (geo.getGeometry2D() != null) {
				Object o = geo.getGeometry2D().getAbstractCurve().getValue();
				if (o instanceof CurveType) {
					newFeature.setCellSpaceBoundaryGeometry(((CurveType) o).getId());
				} else if (o instanceof CompositeCurveType) {
					newFeature.setCellSpaceBoundaryGeometry(((CompositeCurveType) o).getId());
				}

			} else if (geo.getGeometry3D() != null) {
				Object o = geo.getGeometry3D().getAbstractSurface().getValue();
				if (o instanceof SurfaceType) {
					newFeature.setCellSpaceBoundaryGeometry(((SurfaceType) o).getId());
				} else if (o instanceof CompositeSurfaceType) {
					newFeature.setCellSpaceBoundaryGeometry(((CompositeSurfaceType) o).getId());
				}
			}
		} else {
			System.out.println("Warning : There is no geometry at CellSpaceBoundary : " + feature.getId());
		}

		return newFeature;
	}

	/*
	 * 
	 * CellSpaceBoundaryGeometry
	 * change2FeatureClass(CellSpaceBoundaryGeometryType feature) { return null;
	 * } CellSpaceGeometry change2FeatureClass(CellSpaceGeometryType feature) {
	 * return null; }
	 */
	ExternalObjectReference change2FeatureClass(ExternalObjectReferenceType feature) {
		ExternalObjectReference newFeature = new ExternalObjectReference();

		newFeature.uri = (String) feature.getUri();
		return newFeature;
	}

	ExternalReference change2FeatureClass(ExternalReferenceType feature) {
		ExternalReference newFeature = new ExternalReference();
		ExternalObjectReference referredObject = new ExternalObjectReference();
		referredObject.uri = feature.getExternalObject().getUri();

		newFeature.externalObject = referredObject;

		return newFeature;
	}

	public static IndoorFeatures change2FeatureClass(String docId, IndoorFeaturesType feature) throws JAXBException {
		IndoorFeatures newFeature = new IndoorFeatures();
		newFeature.id = feature.getId();
		MultiLayeredGraphType tempML = new MultiLayeredGraphType();
		// newFeature.multiLayeredGraph =
		// change2FeatureClass(feature.getMultiLayeredGraph());
		//Container.getInstance().inputID(feature.getId(), "IndoorFeatures");
		PrimalSpaceFeaturesPropertyType tempPSFP = new PrimalSpaceFeaturesPropertyType();
		tempPSFP = feature.getPrimalSpaceFeatures();
		// newFeature.primalSpaceFeatures =
		// change2FeatureClass(tempPSFP.getPrimalSpaceFeatures());

		PrimalSpaceFeatures childP = change2FeatureClass(docId, tempPSFP.getPrimalSpaceFeatures(), feature.getId());
		Container.getInstance().setFeature(docId, childP.id, "PrimalSpaceFeatures", childP);
		
		MultiLayeredGraph childM = change2FeatureClass(docId, feature.getMultiLayeredGraph(), feature.getId());
		Container.getInstance().setFeature(docId, childM.id, "MultiLayeredGraph", childM);
		
		newFeature.setPrimalSpaceFeatures(childP.getId());
		newFeature.setMultiLayeredGraph(childM.getId());
		Container.getInstance().setFeature(docId, feature.getId(), "IndoorFeatures", newFeature);

		return newFeature;
	}

	public static MultiLayeredGraph change2FeatureClass(String docId, MultiLayeredGraphPropertyType feature, String id) {
		MultiLayeredGraph newFeature = new MultiLayeredGraph();
		newFeature.setId(feature.getMultiLayeredGraph().getId());
		newFeature.setParentID(id);
		List<String> interEdges = new ArrayList<String>();
		List<String> spaceLayer = new ArrayList<String>();

		List<SpaceLayersType> spaceLayerInstanceList = new ArrayList<SpaceLayersType>();
		List<InterEdgesType> interEdgesInstanceList = new ArrayList<InterEdgesType>();

		for (int i = 0; i < feature.getMultiLayeredGraph().getInterEdges().size(); i++) {
			InterEdgesType temp = feature.getMultiLayeredGraph().getInterEdges().get(i);
			// interEdgesInstanceList.add(temp);
			interEdges.add(temp.getId());
			Container.getInstance().setFeature(docId, temp.getId(), "InterEdges", change2FeatureClass(temp, newFeature.id));
		}
		for (int i = 0; i < feature.getMultiLayeredGraph().getSpaceLayers().size(); i++) {
			SpaceLayersType temp = feature.getMultiLayeredGraph().getSpaceLayers().get(i);
			// spaceLayerInstanceList.add(temp);
			spaceLayer.add(temp.getId());
			Container.getInstance().setFeature(docId, temp.getId(), "SpaceLayers", change2FeatureClass(temp, newFeature.id));
		}

		newFeature.setSpaceLayers(spaceLayer);
		newFeature.setInterEdges(interEdges);

		return newFeature;
	}

	static SpaceLayers change2FeatureClass(String docId, SpaceLayersType feature, String parentID) {
		SpaceLayers newFeature = new SpaceLayers();

		newFeature.id = feature.getId();
		newFeature.setParentID(parentID);
		List<SpaceLayerMemberType> tempSLMList = feature.getSpaceLayerMember();
		// List<String>spaceLayerMember = new ArrayList<String>();
		List<String> slm = new ArrayList<String>();

		for (int i = 0; i < tempSLMList.size(); i++) {
			SpaceLayerType s = tempSLMList.get(i).getSpaceLayer();

			slm.add(s.getId());
			Container.getInstance().setFeature(docId, s.getId(), "SpaceLayer", change2FeatureClass(s, newFeature.id));
		}
		newFeature.setSpaceLayerMemeber(slm);

		return newFeature;

	}

	public static InterEdges change2FeatureClass(String docId, InterEdgesType feature, String parentID) {
		InterEdges newFeature = new InterEdges();

		newFeature.setId(feature.getId());
		newFeature.setParentID(parentID);
		List<InterLayerConnectionMemberType> interLayerConnectionMember = feature.getInterLayerConnectionMember();
		List<String> interLayerConnection = new ArrayList<String>();

		for (int i = 0; i < interLayerConnectionMember.size(); i++) {
			InterLayerConnectionType tempILC = new InterLayerConnectionType();
			tempILC = interLayerConnectionMember.get(i).getInterLayerConnection();
			interLayerConnection.add(tempILC.getId());
			Container.getInstance().setFeature(docId, tempILC.getId(), "InterLayerConnection",
					change2FeatureClass(tempILC, newFeature.id));
		}

		newFeature.setInterLayerConnectionMember(interLayerConnection);

		return newFeature;
	}

	static Edges change2FeatureClass(String docId, EdgesType feature, String parentID) {
		Edges newFeature = new Edges();

		newFeature.ID = feature.getId();
		newFeature.setParentID(parentID);
		List<TransitionMemberType> tm = feature.getTransitionMember();
		List<String> transitionMemberReference = new ArrayList<String>();

		for (int i = 0; i < tm.size(); i++) {
			TransitionType tempTM = tm.get(i).getTransition();
			Container.getInstance().setFeature(docId, tempTM.getId(), "Transition", change2FeatureClass(tempTM, newFeature.ID));
			//transitionMemberReference.add(change2FeatureClass(tempTM, newFeature.ID));
			transitionMemberReference.add(tempTM.getId());
		}
		newFeature.transitionMember = transitionMemberReference;
		return newFeature;
	}

	static InterLayerConnection change2FeatureClass(String docId, InterLayerConnectionType feature, String parentID) {
		InterLayerConnection newFeature = new InterLayerConnection();

		newFeature.id = feature.getId();
		newFeature.setParentID(parentID);

		List<SpaceLayerPropertyType> tempSLList = feature.getConnectedLayers();
		List<StatePropertyType> tempILCList = feature.getInterConnects();
		List<String> spacelayerList = new ArrayList<String>();
		List<String> interConnectionList = new ArrayList<String>();

		for (int i = 0; i < tempSLList.size(); i++) {
			SpaceLayerType sl = tempSLList.get(i).getSpaceLayer();
			Container.getInstance().setFeature(docId,sl.getId(), "SpaceLayer", change2FeatureClass(sl, newFeature.id));
			spacelayerList.add(sl.getId());
		}

		for (int i = 0; i < tempILCList.size(); i++) {
			StateType s = tempILCList.get(i).getState();
			interConnectionList.add(s.getId());
			Container.getInstance().setFeature(docId, s.getId(), "State", change2FeatureClass(s, newFeature.id));
		}

		if (spacelayerList.size() != 2 || interConnectionList.size() != 2) {
			System.out.println("Converter : number of SpaceLayer or InterConnection is not 2 at InterLayerConnection");
		} else {
			String[] connectedLayers =null;
			String[] interConnection = null;
			
			spacelayerList.toArray(connectedLayers);
			interConnectionList.toArray(interConnection);
			newFeature.setConnectedLayers(connectedLayers);
			newFeature.setInterConnects(interConnection);
		}
		
		return newFeature;
	}

	public static PrimalSpaceFeatures change2FeatureClass(String docId, PrimalSpaceFeaturesType feature, String parentID)
			throws JAXBException {
		PrimalSpaceFeatures newFeature = new PrimalSpaceFeatures();
		//JAXBContext context = JaxbUtil.createIndoorGMLContext();
		// net.opengis.indoorgml.core.v_1_0.ObjectFactory objectFactory = new
		// ObjectFactory();
		newFeature.id = feature.getId();
		newFeature.setParentID(parentID);
		List<String>cellspacemember = new ArrayList<String>();
		List<String>cellspaceboundarymember = new ArrayList<String>();
		
		for (int i = 0; i < feature.getCellSpaceBoundaryMember().size(); i++) {
			CellSpaceBoundaryMemberType temp = feature.getCellSpaceBoundaryMember().get(i);
			CellSpaceBoundaryType cs = temp.getCellSpaceBoundary().getValue();
			Container.getInstance().setFeature(docId, cs.getId(), "CellSpaceBoundary", change2FeatureClass(cs, newFeature.id));
			cellspaceboundarymember.add(cs.getId());
		}
		for (int i = 0; i < feature.getCellSpaceMember().size(); i++) {
			CellSpaceMemberType temp = feature.getCellSpaceMember().get(i);
			CellSpaceType cs = temp.getCellSpace().getValue();
			Container.getInstance().setFeature(docId, cs.getId(), "CellSpace", change2FeatureClass(cs, newFeature.id));
			cellspacemember.add(cs.getId());
			// CellSpaceType cellSpace =
			// objectFactory.createCellSpace(temp.getCellSpace().getValue());

		}
		newFeature.setCellSpaceBoundaryMember(cellspaceboundarymember);
		newFeature.setCellSpaceMember(cellspacemember);;
		return newFeature;
	}

	static Nodes change2FeatureClass(String docId, NodesType feature, String parentID) {
		Nodes newFeature = new Nodes();

		newFeature.setId(feature.getId());
		newFeature.setParentID(parentID);
		List<StateMemberType> tempML = feature.getStateMember();
		List<String> stateList = new ArrayList<String>();

		for (int i = 0; i < tempML.size(); i++) {
			StateType tempState = tempML.get(i).getState();
			Container.getInstance().setFeature(docId, tempState.getId(), "State", change2FeatureClass(tempState, newFeature.id));
			stateList.add(tempState.getId());
		}
		newFeature.setStateMember(stateList);
		return newFeature;
	}

	static SpaceLayer change2FeatureClass(String docId, SpaceLayerType feature, String parentID) {
		SpaceLayer newFeature = new SpaceLayer();

		newFeature.id = feature.getId();
		newFeature.setFunction(feature.getFunction());
		newFeature.setParentID(parentID);
		// newFeature.createDate = feature.getCreationDate();
		// newFeature.terminateDate = feature.getTerminateDate();
		newFeature.setClassType(feature.getClazz());

		List<String> edgeList = new ArrayList<String>();
		List<EdgesType> tempEL = feature.getEdges();

		List<String> nodesList = new ArrayList<String>();
		List<NodesType> tempNL = feature.getNodes();

		for (int i = 0; i < tempEL.size(); i++) {
			edgeList.add(tempEL.get(i).getId());
			Container.getInstance().setFeature(docId, tempEL.get(i).getId(), "Edges", change2FeatureClass(tempEL.get(i), newFeature.id));
			// tempEdgeList.add(change2FeatureClass(tempEL.get(i)));

		}
		for (int i = 0; i < tempNL.size(); i++) {
			nodesList.add(tempNL.get(i).getId());
			Container.getInstance().setFeature(docId, tempNL.get(i).getId(), "Nodes", change2FeatureClass(tempNL.get(i), newFeature.id));
		}
		newFeature.setEdges(edgeList);
		newFeature.setNodes(nodesList);
		return newFeature;
	}

	SpaceLayerClassType change2FeatureClass(SpaceLayerClassTypeType feature) {
		return null;
	}
	static State change2FeatureClass(String docId, StateType feature, String parentID){
		State newFeature = new State();
		newFeature.setId(feature.getId());
		newFeature.setParentID(parentID);
		//newFeature.geometry = 
		
		if(feature.getDuality() == null){
			System.out.println("Convert to State : There is no Duality");
		}
		else{
			newFeature.setDuality(feature.getDuality().getHref());					
		}
		
		List<TransitionPropertyType>featureConnects = feature.getConnects();
		List<String>connects = new ArrayList<String>();
		for(int i = 0 ; i < featureConnects.size();i++){
			connects.add(featureConnects.get(i).getHref());
		}
		newFeature.setConnects(connects);
				/*
		 * if(feature.getHref() != null){
			newFeature.setDuality(feature.getHref());
		}
		 * */
		return newFeature;
	}
	static Transition change2FeatureClass(String docId, TransitionType feature, String parentID) {
		Transition newFeature = new Transition();

		newFeature.setId(feature.getId());
		newFeature.setParentID(parentID);

		Object geometry = feature.getGeometry().getAbstractCurve().getValue();
		if (geometry instanceof CurvePropertyType) {
			//newFeature.geometry = (CurveType) geometry;
			System.out.println("Converter to Transition : Not yet support");

		} else {
			System.out.println("Converter to Transition : This is not CurveType geometry");

		}
		
		List<StatePropertyType> tempConnect = feature.getConnects();
		String[] connects = null;
		tempConnect.toArray(connects);
		newFeature.setConnects(connects);
		// newFeature.duality =
		// change2FeatureClass((CellSpaceBoundaryType)feature.getDuality().getCellSpaceBoundary().getValue());
		Object duality = feature.getDuality();
		if(duality == null){
			System.out.println("Converter to Transition : There is no Duality");
		}
		else{
			CellSpaceBoundaryType tempBoundary = feature.getDuality().getCellSpaceBoundary().getValue();
			newFeature.setDuality(tempBoundary.getId());
		}
		newFeature.setWeight(feature.getWeight());
		newFeature.setName(feature.getRole());
		return newFeature;
	}

	typeOfTopoExpressionCode change2FeatureClass(TypeOfTopoExpressionCodeEnumerationType feature) {
		typeOfTopoExpressionCode newFeature = new typeOfTopoExpressionCode();

		return null;
	}

}
