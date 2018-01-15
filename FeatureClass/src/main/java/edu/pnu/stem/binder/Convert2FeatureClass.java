package edu.pnu.stem.binder;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

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
import edu.pnu.stem.util.GeometryUtil;
import net.opengis.gml.v_3_2_1.AbstractCurveType;
import net.opengis.gml.v_3_2_1.AbstractSurfaceType;
import net.opengis.gml.v_3_2_1.CompositeCurveType;
import net.opengis.gml.v_3_2_1.CompositeSurfaceType;
import net.opengis.gml.v_3_2_1.CurvePropertyType;
import net.opengis.gml.v_3_2_1.CurveType;
import net.opengis.gml.v_3_2_1.LineStringType;
import net.opengis.gml.v_3_2_1.OrientableCurveType;
import net.opengis.gml.v_3_2_1.OrientableSurfaceType;
import net.opengis.gml.v_3_2_1.PolygonType;
import net.opengis.gml.v_3_2_1.SurfacePropertyType;
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
import net.opengis.indoorgml.core.v_1_0.MultiLayeredGraphType;
import net.opengis.indoorgml.core.v_1_0.NodesType;
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

	public static IndoorFeatures change2FeatureClass(IndoorGMLMap savedMap, String docId, IndoorFeaturesType feature) throws JAXBException {
		IndoorFeatures newFeature = new IndoorFeatures(savedMap);
		newFeature.setId(feature.getId());

		PrimalSpaceFeatures childP = change2FeatureClass(savedMap, feature.getPrimalSpaceFeatures().getPrimalSpaceFeatures(),
				feature.getId());
		savedMap.setFeature(childP.getId(), "PrimalSpaceFeatures", childP);

		MultiLayeredGraph childM = change2FeatureClass(savedMap, feature.getMultiLayeredGraph().getMultiLayeredGraph(),
				feature.getId());
		savedMap.setFeature(childM.getId(), "MultiLayeredGraph", childM);

		newFeature.setPrimalSpaceFeatures(childP);
		newFeature.setMultiLayeredGraph(childM);
		savedMap.setFeature(feature.getId(), "IndoorFeatures", newFeature);
		return newFeature;
	}

	public static Object change2FeatureClass(IndoorGMLMap savedMap, String parentId, CellSpaceGeometryType feature) {
		Object newFeature = null;
		if (feature.isSetGeometry2D()) {
			AbstractSurfaceType temp = feature.getGeometry2D().getAbstractSurface().getValue();
			if (temp instanceof CompositeSurfaceType) {
				CompositeSurfaceType tempGeo = (CompositeSurfaceType) temp;
				List<SurfacePropertyType> surfList = tempGeo.getSurfaceMember();
			}

			else if (feature.isSetGeometry3D()) {

			}

			if (newFeature != null) {
				savedMap.setFeature(parentId, "Geometry", newFeature);
			}
		}
		return newFeature;
	}

	public static Object change2FeatureClass(IndoorGMLMap savedMap, String parentId, CellSpaceBoundaryGeometryType feature) {
		Object newFeature = null;
		if (feature.isSetGeometry2D()) {
			AbstractCurveType temp = feature.getGeometry2D().getAbstractCurve().getValue();
			if (temp instanceof CompositeCurveType) {
				newFeature = (CompositeCurveType) temp;
			} else if (temp instanceof CurveType) {
				newFeature = (CurveType) temp;
			} else if (temp instanceof LineStringType) {
				newFeature = (LineStringType) temp;
			} else if (temp instanceof OrientableCurveType) {
				newFeature = (OrientableCurveType) temp;
			}
		} else if (feature.isSetGeometry3D()) {
			AbstractSurfaceType temp = feature.getGeometry3D().getAbstractSurface().getValue();
			if (temp instanceof CompositeSurfaceType) {
				newFeature = (CompositeSurfaceType) temp;
			} else if (temp instanceof OrientableSurfaceType) {
				newFeature = (OrientableSurfaceType) temp;
			} else if (temp instanceof PolygonType) {
				newFeature = (PolygonType) temp;
			} else if (temp instanceof SurfaceType) {
				newFeature = (SurfaceType) temp;
			}
		}

		if (newFeature != null) {
			savedMap.setFeature(parentId, "Geometry", newFeature);
		}

		return newFeature;

	}

	public static CellSpace change2FeatureClass(IndoorGMLMap savedMap, CellSpaceType feature, String parentId) {
		CellSpace newFeature = new CellSpace(savedMap);
		PrimalSpaceFeatures parent = new PrimalSpaceFeatures(savedMap);
		parent.setId(parentId);
		newFeature.setParent(parent);
		StatePropertyType tempState = feature.getDuality();
		if(tempState != null){
			State duality = new State(savedMap);
			duality.setId(tempState.getHref().substring(1));
			newFeature.setDuality(duality);
		}
		
		newFeature.setId(feature.getId());
		if (feature.getCellSpaceGeometry() != null) {
			CellSpaceGeometryType geo = feature.getCellSpaceGeometry();
			change2FeatureClass(savedMap, feature.getId(),geo);
			

		} else {
			System.out.println("Converter : There is no Geometry Information");

		}

		List<CellSpaceBoundaryPropertyType> boundList = feature.getPartialboundedBy();
		List<CellSpaceBoundary> csbList = new ArrayList<CellSpaceBoundary>();

		for (int i = 0; i < boundList.size(); i++) {
			CellSpaceBoundary temp = new CellSpaceBoundary(savedMap);
			temp.setId(boundList.get(i).getHref());
		}
		newFeature.setPartialboundedBy(csbList);
		// newFeature.partialboundedBy = feature.getPartialboundedBy();

		return newFeature;
	}

	public static CellSpaceBoundary change2FeatureClass(IndoorGMLMap savedMap, CellSpaceBoundaryType feature, String parentId) {
		CellSpaceBoundary newFeature = new CellSpaceBoundary(savedMap);

		newFeature.setId(feature.getId());
		PrimalSpaceFeatures parent = new PrimalSpaceFeatures(savedMap);
		parent.setId(parentId);
		newFeature.setParent(parent);
		TransitionPropertyType tempTransition = feature.getDuality();
		if (tempTransition != null) {
			Transition duality = new Transition(savedMap);
			duality.setId(tempTransition.getHref().substring(1));
			newFeature.setDuality(duality);
		}

		CellSpaceBoundaryGeometryType geo = feature.getCellSpaceBoundaryGeometry();
		if (geo != null) {
			change2FeatureClass(savedMap, feature.getId(), geo);
		} else {
			System.out.println("Warning : There is no geometry at CellSpaceBoundary : " + feature.getId());
		}

		return newFeature;
	}

	ExternalObjectReference change2FeatureClass(ExternalObjectReferenceType feature) {
		ExternalObjectReference newFeature = new ExternalObjectReference();

		newFeature.setUri(feature.getUri());
		return newFeature;
	}

	ExternalReference change2FeatureClass(ExternalReferenceType feature) {
		ExternalReference newFeature = new ExternalReference();
		ExternalObjectReference referredObject = new ExternalObjectReference();
		referredObject.setUri(feature.getExternalObject().getUri());

		newFeature.externalObject = referredObject;

		return newFeature;
	}

	public static MultiLayeredGraph change2FeatureClass(IndoorGMLMap savedMap, MultiLayeredGraphType feature, String parentId) {
		MultiLayeredGraph newFeature = new MultiLayeredGraph(savedMap);
		newFeature.setId(feature.getId());
		IndoorFeatures parent = new IndoorFeatures(savedMap);
		parent.setId(parentId);
		newFeature.setParent(parent);
		List<InterEdges> interEdges = new ArrayList<InterEdges>();
		List<SpaceLayers> spaceLayers = new ArrayList<SpaceLayers>();

		List<SpaceLayersType> spaceLayerInstanceList = new ArrayList<SpaceLayersType>();
		List<InterEdgesType> interEdgesInstanceList = new ArrayList<InterEdgesType>();

		for (int i = 0; i < feature.getInterEdges().size(); i++) {
			InterEdgesType temp = feature.getInterEdges().get(i);
			// interEdgesInstanceList.add(temp);
			InterEdges tempInterEdges = new InterEdges(savedMap);
			tempInterEdges.setId(temp.getId());
			interEdges.add(tempInterEdges);
			savedMap.setFeature(temp.getId(), "InterEdges", change2FeatureClass(savedMap, temp, newFeature.getId()));
		}
		for (int i = 0; i < feature.getSpaceLayers().size(); i++) {
			SpaceLayersType temp = feature.getSpaceLayers().get(i);
			// spaceLayerInstanceList.add(temp);
			SpaceLayers tempSpaceLayers = new SpaceLayers(savedMap);
			tempSpaceLayers.setId(temp.getId());
			spaceLayers.add(tempSpaceLayers);
			savedMap.setFeature(temp.getId(), "SpaceLayers", change2FeatureClass(savedMap, temp, newFeature.getId()));
		}

		newFeature.setSpaceLayers(spaceLayers);
		newFeature.setInterEdges(interEdges);

		return newFeature;
	}

	static SpaceLayers change2FeatureClass(IndoorGMLMap savedMap, SpaceLayersType feature, String parentId) {
		SpaceLayers newFeature = new SpaceLayers(savedMap);

		newFeature.setId(feature.getId());
		MultiLayeredGraph parent = new MultiLayeredGraph(savedMap);
		parent.setId(parentId);
		newFeature.setParent(parent);
		List<SpaceLayerMemberType> tempSLMList = feature.getSpaceLayerMember();
		// List<String>spaceLayerMember = new ArrayList<String>();
		List<SpaceLayer> slm = new ArrayList<SpaceLayer>();

		for (int i = 0; i < tempSLMList.size(); i++) {
			SpaceLayerType s = tempSLMList.get(i).getSpaceLayer();
			SpaceLayer temp = change2FeatureClass(savedMap, s, newFeature.getId());
			savedMap.setFeature(s.getId(), "SpaceLayer", temp);
			slm.add(temp);		
		}
		newFeature.setSpaceLayerMember(slm);

		return newFeature;

	}

	public static InterEdges change2FeatureClass(IndoorGMLMap savedMap, InterEdgesType feature, String parentId) {
		InterEdges newFeature = new InterEdges(savedMap);

		newFeature.setId(feature.getId());
		MultiLayeredGraph parent = new MultiLayeredGraph(savedMap);
		parent.setId(parentId);
		newFeature.setParent(parent);
		List<InterLayerConnectionMemberType> interLayerConnectionMember = feature.getInterLayerConnectionMember();
		List<InterLayerConnection> interLayerConnection = new ArrayList<InterLayerConnection>();

		for (int i = 0; i < interLayerConnectionMember.size(); i++) {
			InterLayerConnectionType tempILC = new InterLayerConnectionType();
			tempILC = interLayerConnectionMember.get(i).getInterLayerConnection();
			InterLayerConnection temp = new InterLayerConnection(savedMap);
			temp.setId(tempILC.getId());
			interLayerConnection.add(temp);
			savedMap.setFeature(tempILC.getId(), "InterLayerConnection",
					change2FeatureClass(savedMap, tempILC, newFeature.getId()));
		}

		newFeature.setInterLayerConnectionMember(interLayerConnection);

		return newFeature;
	}

	static Edges change2FeatureClass(IndoorGMLMap savedMap, EdgesType feature, String parentId) {
		Edges newFeature = new Edges(savedMap);

		newFeature.setId(feature.getId());
		SpaceLayer parent = new SpaceLayer(savedMap);
		parent.setId(parentId);
		newFeature.setParent(parent);
		List<TransitionMemberType> tm = feature.getTransitionMember();
		List<Transition> transitionMemberReference = new ArrayList<Transition>();

		for (int i = 0; i < tm.size(); i++) {
			TransitionType tempTM = tm.get(i).getTransition();
			Transition temp = change2FeatureClass(savedMap, tempTM, newFeature.getId());
			savedMap.setFeature(tempTM.getId(), "Transition", temp);
			// transitionMemberReference.add(change2FeatureClass(tempTM,
			// newFeature.setId()));
			transitionMemberReference.add(temp);
		}
		newFeature.setTransitionMembers(transitionMemberReference);
		return newFeature;
	}

	static InterLayerConnection change2FeatureClass(IndoorGMLMap savedMap, InterLayerConnectionType feature, String parentId) {
		InterLayerConnection newFeature = new InterLayerConnection(savedMap);

		newFeature.setId(feature.getId());
		InterEdges parent = new InterEdges(savedMap);
		parent.setId(parentId);
		newFeature.setParent(parent);

		List<SpaceLayerPropertyType> tempSLList = feature.getConnectedLayers();
		List<StatePropertyType> tempILCList = feature.getInterConnects();
		List<SpaceLayer> spacelayerList = new ArrayList<SpaceLayer>();
		List<State> interConnectionList = new ArrayList<State>();

		for (int i = 0; i < tempSLList.size(); i++) {
			SpaceLayerType sl = tempSLList.get(i).getSpaceLayer();
			SpaceLayer temp = new SpaceLayer(savedMap);
			temp.setId(sl.getId());
			savedMap.setFeature(sl.getId(), "SpaceLayer", change2FeatureClass(savedMap, sl, newFeature.getId()));
			spacelayerList.add(temp);
		}

		for (int i = 0; i < tempILCList.size(); i++) {
			StateType s = tempILCList.get(i).getState();
			State temp = new State(savedMap);
			temp.setId(s.getId());
			interConnectionList.add(temp);
			savedMap.setFeature(s.getId(), "State", change2FeatureClass(savedMap, s, newFeature.getId()));
		}

		if (spacelayerList.size() != 2 || interConnectionList.size() != 2) {
			System.out.println("Converter : number of SpaceLayer or InterConnection is not 2 at InterLayerConnection");
		} else {
			SpaceLayer[] connectedLayers = null;
			State[] interConnection = null;

			spacelayerList.toArray(connectedLayers);
			interConnectionList.toArray(interConnection);
			newFeature.setConnectedLayers(connectedLayers);
			newFeature.setInterConnects(interConnection);
		}

		return newFeature;
	}

	public static PrimalSpaceFeatures change2FeatureClass(IndoorGMLMap savedMap, PrimalSpaceFeaturesType feature, String parentId)
			throws JAXBException {
		PrimalSpaceFeatures newFeature = new PrimalSpaceFeatures(savedMap);
		newFeature.setId(feature.getId());
		IndoorFeatures parent = new IndoorFeatures(savedMap);
		parent.setId(parentId);
		newFeature.setParent(parent);
		List<CellSpace> cellspacemember = new ArrayList<CellSpace>();
		List<CellSpaceBoundary> cellspaceboundarymember = new ArrayList<CellSpaceBoundary>();

		for (int i = 0; i < feature.getCellSpaceBoundaryMember().size(); i++) {
			CellSpaceBoundaryMemberType csbm = feature.getCellSpaceBoundaryMember().get(i);
			CellSpaceBoundaryType cs = csbm.getCellSpaceBoundary().getValue();
			CellSpaceBoundary temp = change2FeatureClass(savedMap, cs, newFeature.getId());
			savedMap.setFeature(cs.getId(), "CellSpaceBoundary", temp);
			temp.setId(cs.getId());
			cellspaceboundarymember.add(temp);
		}
		for (int i = 0; i < feature.getCellSpaceMember().size(); i++) {
			CellSpaceMemberType csm = feature.getCellSpaceMember().get(i);
			CellSpaceType cs = csm.getCellSpace().getValue();
			CellSpace temp = change2FeatureClass(savedMap, cs, newFeature.getId());
			savedMap.setFeature(cs.getId(), "CellSpace", temp);
			temp.setId(cs.getId());
			cellspacemember.add(temp);
			// CellSpaceType cellSpace =
			// objectFactory.createCellSpace(temp.getCellSpace().getValue());

		}
		newFeature.setCellSpaceBoundaryMember(cellspaceboundarymember);
		newFeature.setCellSpaceMember(cellspacemember);
		return newFeature;
	}

	static Nodes change2FeatureClass(IndoorGMLMap savedMap, NodesType feature, String parentId) {
		Nodes newFeature = new Nodes(savedMap);

		newFeature.setId(feature.getId());
		SpaceLayer parent = new SpaceLayer(savedMap);
		parent.setId(parentId);
		newFeature.setParent(parent);
		List<StateMemberType> tempML = feature.getStateMember();
		List<State> stateList = new ArrayList<State>();

		for (int i = 0; i < tempML.size(); i++) {
			StateType tempState = tempML.get(i).getState();
			State temp = change2FeatureClass(savedMap, tempState, newFeature.getId());
			savedMap.setFeature(tempState.getId(), "State", temp);
			stateList.add(temp);
		}
		newFeature.setStateMember(stateList);
		return newFeature;
	}

	static SpaceLayer change2FeatureClass(IndoorGMLMap savedMap, SpaceLayerType feature, String parentId) {
		SpaceLayer newFeature = new SpaceLayer(savedMap);

		newFeature.setId(feature.getId());
		newFeature.setFunction(feature.getFunction());
		SpaceLayers parent = new SpaceLayers(savedMap);
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
			Edges temp = change2FeatureClass(savedMap, tempEL.get(i), newFeature.getId());
			edgeList.add(temp);
			savedMap.setFeature(tempEL.get(i).getId(), "Edges", temp);
			// tempEdgeList.add(change2FeatureClass(tempEL.get(i)));

		}
		for (int i = 0; i < tempNL.size(); i++) {
			Nodes temp = change2FeatureClass(savedMap, tempNL.get(i), newFeature.getId());
			temp.setId(tempNL.get(i).getId());
			nodesList.add(temp);
			savedMap.setFeature(tempNL.get(i).getId(), "Nodes", temp);
		}
		newFeature.setEdges(edgeList);
		newFeature.setNodes(nodesList);
		return newFeature;
	}

	SpaceLayerClassType change2FeatureClass(SpaceLayerClassTypeType feature) {
		return null;
	}

	static State change2FeatureClass(IndoorGMLMap savedMap, StateType feature, String parentId) {
		State newFeature = new State(savedMap);
		newFeature.setId(feature.getId());
		Nodes parent = new Nodes(savedMap);
		parent.setId(parentId);
		newFeature.setParent(parent);
		
		if(feature.isSetGeometry()){
			com.vividsolutions.jts.geom.Point geom = Convert2JTSGeometry.convert2Point(feature.getGeometry().getPoint());
			GeometryUtil.setMetadata(geom, "id", feature.getGeometry().getPoint().getId());
			newFeature.setGeometry(geom);
		}

		if (feature.getDuality() == null) {
			System.out.println("Convert to State : There is no Duality");
		} else {
			CellSpace duality = new CellSpace(savedMap);
			duality.setId(feature.getDuality().getHref().substring(1));
			newFeature.setDuality(duality);
		}

		List<TransitionPropertyType> featureConnects = feature.getConnects();
		List<Transition> connects = new ArrayList<Transition>();
		for (int i = 0; i < featureConnects.size(); i++) {
			Transition temp = new Transition(savedMap);
			temp.setId(featureConnects.get(i).getHref().substring(1));
			connects.add(temp);
		}
		newFeature.setConnects(connects);
		/*
		 * if(feature.getHref() != null){
		 * newFeature.setDuality(feature.getHref()); }
		 */
		return newFeature;
	}

	static Transition change2FeatureClass(IndoorGMLMap savedMap, TransitionType feature, String parentId) {
		Transition newFeature = new Transition(savedMap);

		newFeature.setId(feature.getId());
		Edges parent = new Edges(savedMap);
		parent.setId(parentId);
		newFeature.setParent(parent);

		Object geometry = feature.getGeometry().getAbstractCurve().getValue();
		if (geometry instanceof CurvePropertyType) {
			// newFeature.geometry = (CurveType) geometry;
			System.out.println("Converter to Transition : Not yet support");

		} else {
			System.out.println("Converter to Transition : This is not CurveType geometry");

		}

		List<StatePropertyType> tempConnect = feature.getConnects();
		State[] connects = new State[2];
		State connects1 = new State(savedMap);
		State connects2 = new State(savedMap);
		connects1.setId(tempConnect.get(0).getHref().substring(1));
		connects2.setId(tempConnect.get(1).getHref().substring(1));
		connects[0] = connects1;
		connects[1] = connects2;
		newFeature.setConnects(connects);
		// newFeature.duality =
		// change2FeatureClass((CellSpaceBoundaryType)feature.getDuality().getCellSpaceBoundary().getValue());
		if (feature.getDuality() == null) {
			System.out.println("Converter to Transition : There is no Duality");
		} else {
			CellSpaceBoundaryType tempBoundary = feature.getDuality().getCellSpaceBoundary().getValue();
			CellSpaceBoundary duality = new CellSpaceBoundary(savedMap);
			if (tempBoundary.getId().contains("#")) {
				duality.setId(tempBoundary.getId().substring(1));
			} else {
				duality.setId(tempBoundary.getId());
			}
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
