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
	
	static AbstractFeature change2FeatureClass(AbstractFeatureType feature, String parentId) {
		AbstractFeature newFeature = new AbstractFeature();
		Object tempLocation = feature.getLocation().getValue();
		newFeature.setId( feature.getId());
		//newFeature.boundedBy = feature.getBoundedBy();
		//TODO : implement geometry of boundedBy using jts geometry library
		return newFeature;
	}
	
	public static CellSpace change2FeatureClass(CellSpaceType feature, String parentId) {
		CellSpace newFeature = new CellSpace();
		PrimalSpaceFeatures parent = new PrimalSpaceFeatures();
		parent.setId(parentId);
		newFeature.setParent(parent);
		StatePropertyType tempState = feature.getDuality();
		if(tempState != null){
			State duality = new State();
			duality.setId(tempState.getHref());
			newFeature.setDuality(duality);
		}
		
		newFeature.setId(feature.getId());
		if (feature.getCellSpaceGeometry() != null) {
			CellSpaceGeometryType geo = feature.getCellSpaceGeometry();
			if (geo.getGeometry2D() != null) {
				Object o = geo.getGeometry2D().getAbstractSurface().getValue();
				if (o instanceof SurfaceType) {
					//newFeature.setGeometry2D(((SurfaceType) o).getId());
					newFeature.setGeometryType("SurfaceType");
				} else if (o instanceof CompositeSurfaceType) {
					//newFeature.setGeometry2D(((CompositeSurfaceType) o).getId());
					newFeature.setGeometryType("CompositeSurfaceType");
				}

			} else if (geo.getGeometry3D() != null) {
				Object o = geo.getGeometry3D().getAbstractSolid().getValue();
				if (o instanceof SolidType) {
					//newFeature.setGeometry3D(((SolidType) o).getId());
					newFeature.setGeometryType("SolidType");
				} else if (o instanceof CompositeSolidType) {
					//newFeature.setGeometry3D(((CompositeSolidType) o).getId());
					newFeature.setGeometryType("CompositeSolidType");
				}

			}
		} else {
			System.out.println("Converter : There is no Geometry Information");

		}

		List<CellSpaceBoundaryPropertyType> boundList = feature.getPartialboundedBy();
		List<CellSpaceBoundary> csbList = new ArrayList<CellSpaceBoundary>();

		for (int i = 0; i < boundList.size(); i++) {
			CellSpaceBoundary temp = new CellSpaceBoundary();
			temp.setId(boundList.get(i).getHref());
		}
		newFeature.setPartialboundedBy(csbList);
		// newFeature.partialboundedBy = feature.getPartialboundedBy();

		return newFeature;
	}

	public static CellSpaceBoundary change2FeatureClass(CellSpaceBoundaryType feature, String parentId) {
		CellSpaceBoundary newFeature = new CellSpaceBoundary();
		
		newFeature.setId(feature.getId());
		PrimalSpaceFeatures parent = new PrimalSpaceFeatures();
		parent.setId(parentId);
		newFeature.setParent(parent);
		TransitionPropertyType tempTransition = feature.getDuality();
		if(tempTransition!=null){
			Transition duality = new Transition();
			duality.setId(tempTransition.getHref());
			newFeature.setDuality(duality);
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
		newFeature.setId(feature.getId());
		MultiLayeredGraphType tempML = new MultiLayeredGraphType();
		// newFeature.multiLayeredGraph =
		// change2FeatureClass(feature.getMultiLayeredGraph());
		//Container.getInstance().inputID(feature.getId(), "s");
		PrimalSpaceFeaturesPropertyType tempPSFP = new PrimalSpaceFeaturesPropertyType();
		tempPSFP = feature.getPrimalSpaceFeatures();
		// newFeature.primalSpaceFeatures =
		// change2FeatureClass(tempPSFP.getPrimalSpaceFeatures());

		PrimalSpaceFeatures childP = change2FeatureClass(docId, tempPSFP.getPrimalSpaceFeatures(), feature.getId());
		Container.getInstance().setFeature(docId, childP.getId(), "PrimalSpaceFeatures", childP);
		
		MultiLayeredGraph childM = change2FeatureClass(docId, feature.getMultiLayeredGraph(), feature.getId());
		Container.getInstance().setFeature(docId, childM.getId(), "MultiLayeredGraph", childM);
		
		newFeature.setPrimalSpaceFeatures(childP.getId());
		newFeature.setMultiLayeredGraph(childM.getId());
		Container.getInstance().setFeature(docId, feature.getId(), "IndoorFeatures", newFeature);

		return newFeature;
	}

	public static MultiLayeredGraph change2FeatureClass(String docId, MultiLayeredGraphPropertyType feature, String parentId) {
		MultiLayeredGraph newFeature = new MultiLayeredGraph();
		newFeature.setId(feature.getMultiLayeredGraph().getId());
		IndoorFeatures parent = new IndoorFeatures();
		parent.setId(parentId);
		newFeature.setParent(parent);
		List<InterEdges> interEdges = new ArrayList<InterEdges>();
		List<SpaceLayers> spaceLayers = new ArrayList<SpaceLayers>();

		List<SpaceLayersType> spaceLayerInstanceList = new ArrayList<SpaceLayersType>();
		List<InterEdgesType> interEdgesInstanceList = new ArrayList<InterEdgesType>();

		for (int i = 0; i < feature.getMultiLayeredGraph().getInterEdges().size(); i++) {
			InterEdgesType temp = feature.getMultiLayeredGraph().getInterEdges().get(i);
			// interEdgesInstanceList.add(temp);
			InterEdges tempInterEdges = new InterEdges();
			tempInterEdges.setId(temp.getId());
			interEdges.add(tempInterEdges);
			Container.getInstance().setFeature(docId, temp.getId(), "InterEdges", change2FeatureClass(temp, newFeature.getId()));
		}
		for (int i = 0; i < feature.getMultiLayeredGraph().getSpaceLayers().size(); i++) {
			SpaceLayersType temp = feature.getMultiLayeredGraph().getSpaceLayers().get(i);
			// spaceLayerInstanceList.add(temp);
			SpaceLayers tempSpaceLayers = new SpaceLayers();
			tempSpaceLayers.setId(temp.getId());
			spaceLayers.add(tempSpaceLayers);
			Container.getInstance().setFeature(docId, temp.getId(), "SpaceLayers", change2FeatureClass(temp, newFeature.getId()));
		}

		newFeature.setSpaceLayers(spaceLayers);
		newFeature.setInterEdges(interEdges);

		return newFeature;
	}

	static SpaceLayers change2FeatureClass(String docId, SpaceLayersType feature, String parentId) {
		SpaceLayers newFeature = new SpaceLayers();

		newFeature.setId(feature.getId());
		MultiLayeredGraph parent = new MultiLayeredGraph();
		parent.setId(parentId);
		newFeature.setParent(parent);
		List<SpaceLayerMemberType> tempSLMList = feature.getSpaceLayerMember();
		// List<String>spaceLayerMember = new ArrayList<String>();
		List<SpaceLayer> slm = new ArrayList<SpaceLayer>();

		for (int i = 0; i < tempSLMList.size(); i++) {
			SpaceLayerType s = tempSLMList.get(i).getSpaceLayer();
			SpaceLayer spacelayer = new SpaceLayer();
			spacelayer.setId(s.getId());
			slm.add(spacelayer);
			Container.getInstance().setFeature(docId, s.getId(), "SpaceLayer", change2FeatureClass(s, newFeature.getId()));
		}
		newFeature.setSpaceLayerMember(slm);

		return newFeature;

	}

	public static InterEdges change2FeatureClass(String docId, InterEdgesType feature, String parentId) {
		InterEdges newFeature = new InterEdges();

		newFeature.setId(feature.getId());
		MultiLayeredGraph parent = new MultiLayeredGraph();
		parent.setId(parentId);
		newFeature.setParent(parent);
		List<InterLayerConnectionMemberType> interLayerConnectionMember = feature.getInterLayerConnectionMember();
		List<InterLayerConnection> interLayerConnection = new ArrayList<InterLayerConnection>();

		for (int i = 0; i < interLayerConnectionMember.size(); i++) {
			InterLayerConnectionType tempILC = new InterLayerConnectionType();
			tempILC = interLayerConnectionMember.get(i).getInterLayerConnection();
			InterLayerConnection temp = new InterLayerConnection();
			temp.setId(tempILC.getId());
			interLayerConnection.add(temp);
			Container.getInstance().setFeature(docId, tempILC.getId(), "InterLayerConnection",
					change2FeatureClass(tempILC, newFeature.getId()));
		}

		newFeature.setInterLayerConnectionMember(interLayerConnection);

		return newFeature;
	}

	static Edges change2FeatureClass(String docId, EdgesType feature, String parentId) {
		Edges newFeature = new Edges();

		newFeature.setId(feature.getId());
		SpaceLayer parent = new SpaceLayer();
		parent.setId(parentId);
		newFeature.setParent(parent);
		List<TransitionMemberType> tm = feature.getTransitionMember();
		List<Transition> transitionMemberReference = new ArrayList<Transition>();

		for (int i = 0; i < tm.size(); i++) {
			TransitionType tempTM = tm.get(i).getTransition();
			Container.getInstance().setFeature(docId, tempTM.getId(), "Transition", change2FeatureClass(tempTM, newFeature.getId()));
			//transitionMemberReference.add(change2FeatureClass(tempTM, newFeature.setId()));
			Transition temp = new Transition();
			temp.setId(tempTM.getId());
			transitionMemberReference.add(temp);
		}
		newFeature.setTransitionMembers(transitionMemberReference);
		return newFeature;
	}

	static InterLayerConnection change2FeatureClass(String docId, InterLayerConnectionType feature, String parentId) {
		InterLayerConnection newFeature = new InterLayerConnection();
		
		newFeature.setId(feature.getId());
		InterEdges parent = new InterEdges();
		parent.setId(parentId);
		newFeature.setParent(parent);

		List<SpaceLayerPropertyType> tempSLList = feature.getConnectedLayers();
		List<StatePropertyType> tempILCList = feature.getInterConnects();
		List<SpaceLayer> spacelayerList = new ArrayList<SpaceLayer>();
		List<State> interConnectionList = new ArrayList<State>();

		for (int i = 0; i < tempSLList.size(); i++) {
			SpaceLayerType sl = tempSLList.get(i).getSpaceLayer();
			SpaceLayer temp = new SpaceLayer();
			temp.setId(sl.getId());
			Container.getInstance().setFeature(docId,sl.getId(), "SpaceLayer", change2FeatureClass(sl, newFeature.getId()));
			spacelayerList.add(temp);
		}

		for (int i = 0; i < tempILCList.size(); i++) {
			StateType s = tempILCList.get(i).getState();
			State temp = new State();
			temp.setId(s.getId());
			interConnectionList.add(temp);
			Container.getInstance().setFeature(docId, s.getId(), "State", change2FeatureClass(s, newFeature.getId()));
		}

		if (spacelayerList.size() != 2 || interConnectionList.size() != 2) {
			System.out.println("Converter : number of SpaceLayer or InterConnection is not 2 at InterLayerConnection");
		} else {
			SpaceLayer[] connectedLayers =null;
			State[] interConnection = null;
			
			spacelayerList.toArray(connectedLayers);
			interConnectionList.toArray(interConnection);
			newFeature.setConnectedLayers(connectedLayers);
			newFeature.setInterConnects(interConnection);
		}
		
		return newFeature;
	}

	public static PrimalSpaceFeatures change2FeatureClass(String docId, PrimalSpaceFeaturesType feature, String parentId)
			throws JAXBException {
		PrimalSpaceFeatures newFeature = new PrimalSpaceFeatures();
		newFeature.setId(feature.getId());
		IndoorFeatures parent = new IndoorFeatures();
		parent.setId(parentId);
		newFeature.setParent(parent);
		List<CellSpace>cellspacemember = new ArrayList<CellSpace>();
		List<CellSpaceBoundary>cellspaceboundarymember = new ArrayList<CellSpaceBoundary>();
		
		for (int i = 0; i < feature.getCellSpaceBoundaryMember().size(); i++) {
			CellSpaceBoundaryMemberType csbm = feature.getCellSpaceBoundaryMember().get(i);
			CellSpaceBoundaryType cs = csbm.getCellSpaceBoundary().getValue();
			Container.getInstance().setFeature(docId, cs.getId(), "CellSpaceBoundary", change2FeatureClass(cs, newFeature.getId()));
			CellSpaceBoundary temp = new CellSpaceBoundary();
			temp.setId(cs.getId());
			cellspaceboundarymember.add(temp);
		}
		for (int i = 0; i < feature.getCellSpaceMember().size(); i++) {
			CellSpaceMemberType csm = feature.getCellSpaceMember().get(i);
			CellSpaceType cs = csm.getCellSpace().getValue();
			Container.getInstance().setFeature(docId, cs.getId(), "CellSpace", change2FeatureClass(cs, newFeature.getId()));
			CellSpace temp = new CellSpace();
			temp.setId(cs.getId());
			cellspacemember.add(temp);
			// CellSpaceType cellSpace =
			// objectFactory.createCellSpace(temp.getCellSpace().getValue());

		}
		newFeature.setCellSpaceBoundaryMember(cellspaceboundarymember);
		newFeature.setCellSpaceMember(cellspacemember);;
		return newFeature;
	}

	static Nodes change2FeatureClass(String docId, NodesType feature, String parentId) {
		Nodes newFeature = new Nodes();

		newFeature.setId(feature.getId());
		SpaceLayer parent = new SpaceLayer();
		parent.setId(parentId);
		newFeature.setParent(parent);
		List<StateMemberType> tempML = feature.getStateMember();
		List<State> stateList = new ArrayList<State>();

		for (int i = 0; i < tempML.size(); i++) {
			StateType tempState = tempML.get(i).getState();
			Container.getInstance().setFeature(docId, tempState.getId(), "State", change2FeatureClass(tempState, newFeature.getId()));
			State temp = new State();
			temp.setId(tempState.getId());
			stateList.add(temp);
		}
		newFeature.setStateMember(stateList);
		return newFeature;
	}

	static SpaceLayer change2FeatureClass(String docId, SpaceLayerType feature, String parentId) {
		SpaceLayer newFeature = new SpaceLayer();

		newFeature.setId(feature.getId());
		newFeature.setFunction(feature.getFunction());
		SpaceLayers parent = new SpaceLayers();
		parent.setId(parentId);
		newFeature.setParent(parent);
		// newFeature.createDate = feature.getCreationDate();
		// newFeature.terminateDate = feature.getTerminateDate();
		newFeature.setClassType(feature.getClazz());

		List<Edges> edgeList = new ArrayList<Edges>();
		List<EdgesType> tempEL = feature.getEdges();

		List<Nodes> nodesList = new ArrayList<Nodes>();
		List<NodesType> tempNL = feature.getNodes();

		for (int i = 0; i < tempEL.size(); i++) {
			Edges temp = new Edges();
			temp.setId(tempEL.get(i).getId());
			edgeList.add(temp);
			Container.getInstance().setFeature(docId, tempEL.get(i).getId(), "Edges", change2FeatureClass(tempEL.get(i), newFeature.getId()));
			// tempEdgeList.add(change2FeatureClass(tempEL.get(i)));

		}
		for (int i = 0; i < tempNL.size(); i++) {
			Nodes temp = new Nodes();
			temp.setId(tempNL.get(i).getId());
			nodesList.add(temp);
			Container.getInstance().setFeature(docId, tempNL.get(i).getId(), "Nodes", change2FeatureClass(tempNL.get(i), newFeature.getId()));
		}
		newFeature.setEdges(edgeList);
		newFeature.setNodes(nodesList);
		return newFeature;
	}

	SpaceLayerClassType change2FeatureClass(SpaceLayerClassTypeType feature) {
		return null;
	}
	static State change2FeatureClass(String docId, StateType feature, String parentId){
		State newFeature = new State();
		newFeature.setId(feature.getId());
		SpaceLayer parent = new SpaceLayer();
		parent.setId(parentId);
		newFeature.setParent(parent);
		//newFeature.geometry = 
		
		if(feature.getDuality() == null){
			System.out.println("Convert to State : There is no Duality");
		}
		else{
			CellSpace duality = new CellSpace();
			duality.setId(feature.getDuality().getHref());
			newFeature.setDuality(duality);					
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
	static Transition change2FeatureClass(String docId, TransitionType feature, String parentId) {
		Transition newFeature = new Transition();

		newFeature.setId(feature.getId());
		Edges parent = new Edges();
		parent.setId(parentId);
		newFeature.setParent(parent);

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
		if(feature.getDuality() == null){
			System.out.println("Converter to Transition : There is no Duality");
		}
		else{
			CellSpaceBoundaryType tempBoundary = feature.getDuality().getCellSpaceBoundary().getValue();
			CellSpaceBoundary duality = new CellSpaceBoundary();
			duality.setId(tempBoundary.getId());
			newFeature.setDuality(duality);
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
