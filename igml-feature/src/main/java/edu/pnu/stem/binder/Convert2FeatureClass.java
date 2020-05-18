package edu.pnu.stem.binder;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import edu.pnu.stem.feature.core.AbstractFeature;
import edu.pnu.stem.feature.core.CellSpace;
import edu.pnu.stem.feature.core.CellSpaceBoundary;
import edu.pnu.stem.feature.core.Edges;
import edu.pnu.stem.feature.core.ExternalObjectReference;
import edu.pnu.stem.feature.core.ExternalReference;
import edu.pnu.stem.feature.core.IndoorFeatures;
import edu.pnu.stem.feature.core.InterEdges;
import edu.pnu.stem.feature.core.InterLayerConnection;
import edu.pnu.stem.feature.core.MultiLayeredGraph;
import edu.pnu.stem.feature.core.Nodes;
import edu.pnu.stem.feature.core.PrimalSpaceFeatures;
import edu.pnu.stem.feature.core.SpaceLayer;
import edu.pnu.stem.feature.core.SpaceLayerClassType;
import edu.pnu.stem.feature.core.SpaceLayers;
import edu.pnu.stem.feature.core.State;
import edu.pnu.stem.feature.core.Transition;
import edu.pnu.stem.feature.core.typeOfTopoExpressionCode;
import edu.pnu.stem.feature.navigation.AnchorBoundary;
import edu.pnu.stem.feature.navigation.GeneralSpace;
import edu.pnu.stem.geometry.jts.Solid;
import edu.pnu.stem.util.GeometryUtil;
import net.opengis.gml.v_3_2_1.AbstractCurveType;
import net.opengis.gml.v_3_2_1.AbstractFeatureType;
import net.opengis.gml.v_3_2_1.AbstractSolidType;
import net.opengis.gml.v_3_2_1.AbstractSurfaceType;
import net.opengis.gml.v_3_2_1.CompositeCurveType;
import net.opengis.gml.v_3_2_1.CompositeSolidType;
import net.opengis.gml.v_3_2_1.CompositeSurfaceType;
import net.opengis.gml.v_3_2_1.CurveType;
import net.opengis.gml.v_3_2_1.LineStringType;
import net.opengis.gml.v_3_2_1.OrientableCurveType;
import net.opengis.gml.v_3_2_1.OrientableSurfaceType;
import net.opengis.gml.v_3_2_1.PolygonType;
import net.opengis.gml.v_3_2_1.SolidType;
import net.opengis.gml.v_3_2_1.SurfacePropertyType;
import net.opengis.gml.v_3_2_1.SurfaceType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceBoundaryGeometryType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceBoundaryMemberType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceBoundaryPropertyType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceBoundaryType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceGeometryType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceMemberType;
import net.opengis.indoorgml.core.v_1_0.CellSpacePropertyType;
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
import net.opengis.indoorgml.navigation.v_1_0.AnchorBoundaryType;
import net.opengis.indoorgml.navigation.v_1_0.GeneralSpaceType;

/**
 * 
 * @author Hyung-Gyu Ryoo (hyunggyu.ryoo@gmail.com, Pusan National Univeristy)
 *
 */
public class Convert2FeatureClass {

	public static IndoorFeatures change2FeatureClass(IndoorGMLMap savedMap, String docId, IndoorFeaturesType feature) throws JAXBException {
		// Creating this feature
		IndoorFeatures newFeature = (IndoorFeatures) savedMap.getFeature(feature.getId());
		if(newFeature == null) {
			newFeature = new IndoorFeatures(savedMap, feature.getId());
			savedMap.setFeature(feature.getId(), "IndoorFeatures", newFeature);
		}		
		// Creating containing features
		PrimalSpaceFeatures childP = change2FeatureClass(savedMap, feature.getPrimalSpaceFeatures().getPrimalSpaceFeatures(),
				feature.getId());
		newFeature.setPrimalSpaceFeatures(childP);
		
		MultiLayeredGraph childM = change2FeatureClass(savedMap, feature.getMultiLayeredGraph().getMultiLayeredGraph(),
				feature.getId());
		newFeature.setMultiLayeredGraph(childM);
		
		return newFeature;
	}

	public static Object change2FeatureClass(IndoorGMLMap savedMap, String parentId, CellSpaceGeometryType feature) {
		Object newFeature = null;
		
		if (feature.isSetGeometry2D()) {
			AbstractSurfaceType geom = feature.getGeometry2D().getAbstractSurface().getValue();
			if (geom instanceof PolygonType) {
				PolygonType poly = (PolygonType) geom;
				
			} else if (geom instanceof SurfaceType) {
				
			} else if (geom instanceof OrientableSurfaceType) {
				
			} else if (geom instanceof CompositeSurfaceType) {
				CompositeSurfaceType tempGeo = (CompositeSurfaceType) geom;
				List<SurfacePropertyType> surfList = tempGeo.getSurfaceMember();
			} else {
				//TODO : Exception
			}
		} else { //feature.isSetGeometry3D()
			AbstractSolidType geom = feature.getGeometry3D().getAbstractSolid().getValue();
			if (geom instanceof SolidType) {
			
			} else if (geom instanceof CompositeSolidType) {
				
			} else {
				//TODO : Exception
			}
		}
		
		if (newFeature != null) {
			savedMap.setFeature(parentId, "Geometry", newFeature);
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
			} else {
				//Excception
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
		// Creating this feature
		CellSpace newFeature = (CellSpace) savedMap.getFeature(feature.getId());
		if(newFeature == null) {	
			if(savedMap.hasFutureID(feature.getId())){
				newFeature = (CellSpace)savedMap.getFutureFeature(feature.getId());
			}
			else{
			newFeature = new CellSpace(savedMap, feature.getId());
			}
			savedMap.setFeature(feature.getId(), "CellSpace", newFeature);
		}
		
		// Setting parent 
		PrimalSpaceFeatures parent = (PrimalSpaceFeatures) savedMap.getFeature(parentId);
		newFeature.setParent(parent);
		
		// Creating containing features
		
		// 1. duality
		StatePropertyType stateProp = feature.getDuality();
		if(stateProp != null){
			// Check state is defined as instance or is referenced
			
			if(stateProp.getHref() != null) {
				String dualityId = stateProp.getHref().substring(1);
				
				State duality = (State) savedMap.getFeature(dualityId);
				if(duality != null) {
					newFeature.setDuality(duality);
				} else {
					//TODO
					savedMap.setFutureFeature(dualityId, new State(savedMap,dualityId));
				}
			} else {
				//TODO
			}
		}
		
		// 2. geometry
		CellSpaceGeometryType cellSpaceGeom = feature.getCellSpaceGeometry();
		if (cellSpaceGeom != null) {
			change2FeatureClass(savedMap, feature.getId(), cellSpaceGeom);			
			if(cellSpaceGeom.isSetGeometry2D()){
				Polygon geom = Convert2JTSGeometry.convert2Polygon((PolygonType)feature.getCellSpaceGeometry().getGeometry2D().getAbstractSurface().getValue());
				//GeometryUtil.setMetadata(geom, "id", feature.getCellSpaceGeometry().getGeometry2D().getAbstractSurface().getValue().getId());
				newFeature.setGeometry(geom);
			}
			else if(cellSpaceGeom.isSetGeometry3D()){
				Solid geom = Convert2JTSGeometry.Convert2Solid((SolidType)feature.getCellSpaceGeometry().getGeometry3D().getAbstractSolid().getValue());
				//GeometryUtil.setMetadata(geom, "id", feature.getCellSpaceGeometry().getGeometry3D().getAbstractSolid().getValue().getId());
				newFeature.setGeometry(geom);
			}
			
		} else {
			//TODO : Exception
			System.out.println("Converter : There is no Geometry Information");
		}

		// 3. connects
		List<CellSpaceBoundaryPropertyType> partialBoundaries = feature.getPartialboundedBy();
		for (CellSpaceBoundaryPropertyType cbpProp : partialBoundaries) {
			if(cbpProp.getHref() != null) {
				String connectsId = cbpProp.getHref().substring(1);
				CellSpaceBoundary connects = (CellSpaceBoundary) savedMap.getFeature(connectsId);
				if(connects != null) {
					newFeature.addPartialBoundedBy(connects);
				} else {
					//TODO
					savedMap.setFutureFeature(connectsId, new CellSpaceBoundary(savedMap,connectsId));
				}
			} else {
				//TODO
			};
		}
		
		savedMap.removeFutureID(feature.getId());
		
		return newFeature;
	}

	public static CellSpaceBoundary change2FeatureClass(IndoorGMLMap savedMap, CellSpaceBoundaryType feature, String parentId) {
		// Creating this feature
		CellSpaceBoundary newFeature = (CellSpaceBoundary) savedMap.getFeature(feature.getId());
		if(newFeature == null) {
			
			if(savedMap.hasFutureID(feature.getId())){
				newFeature = (CellSpaceBoundary)savedMap.getFutureFeature(feature.getId());
			}
			else {
				newFeature = new CellSpaceBoundary(savedMap, feature.getId());
			}			
			savedMap.setFeature(feature.getId(), "CellSpaceBoundary", newFeature);
		}
		
		// Setting parent 
		PrimalSpaceFeatures parent = (PrimalSpaceFeatures) savedMap.getFeature(parentId);
		newFeature.setParent(parent);
		
		// Creating containing features

		// 1. duality
		TransitionPropertyType transitionProp = feature.getDuality();
		if (transitionProp != null) {
			// Check transition is defined as instance or is referenced
			
			if(transitionProp.getHref() != null) {
				String dualityId = transitionProp.getHref().substring(1);
				
				Transition duality = (Transition) savedMap.getFeature(dualityId);
				if(duality != null) {
					newFeature.setDuality(duality);
				} else {
					//TODO
					savedMap.setFutureFeature(dualityId, new Transition(savedMap,dualityId));
				}
			} else {
				//TODO
			}
		}
		
		// 2. geometry
		CellSpaceBoundaryGeometryType cellSpaceBoundaryGeom = feature.getCellSpaceBoundaryGeometry();
		if (cellSpaceBoundaryGeom != null) {
			change2FeatureClass(savedMap, feature.getId(), cellSpaceBoundaryGeom);
		} else {
			//TODO : Exception
			System.out.println("Converter : There is no Geometry Information");
		}
		
		return newFeature;
	}

	public static ExternalObjectReference change2FeatureClass(ExternalObjectReferenceType feature) {
		ExternalObjectReference newFeature = new ExternalObjectReference();

		newFeature.setUri(feature.getUri());
		return newFeature;
	}

	public static ExternalReference change2FeatureClass(ExternalReferenceType feature) {
		ExternalReference newFeature = new ExternalReference();
		ExternalObjectReference referredObject = new ExternalObjectReference();
		referredObject.setUri(feature.getExternalObject().getUri());

		newFeature.externalObject = referredObject;

		return newFeature;
	}

	public static MultiLayeredGraph change2FeatureClass(IndoorGMLMap savedMap, MultiLayeredGraphType feature, String parentId) {
		// Creating this feature
		MultiLayeredGraph newFeature = (MultiLayeredGraph) savedMap.getFeature(feature.getId());
		if(newFeature == null) {
			if(savedMap.hasFutureID(feature.getId())){
				newFeature = (MultiLayeredGraph)savedMap.getFutureFeature(feature.getId());
			}
			else{
				newFeature = new MultiLayeredGraph(savedMap, feature.getId());
			}
			
			savedMap.setFeature(feature.getId(), "MultiLayeredGraph", newFeature);
		}
		
		// Setting parent 
		IndoorFeatures parent = (IndoorFeatures) savedMap.getFeature(parentId);
		newFeature.setParent(parent);

		// Creating containing features
		ArrayList<SpaceLayers> spaceLayers = new ArrayList<SpaceLayers>();
		for (SpaceLayersType slsType : feature.getSpaceLayers()) {
			SpaceLayers sls = change2FeatureClass(savedMap, slsType, newFeature.getId());
			spaceLayers.add(sls);
			//newFeature.addSpaceLayers(sls);
		}
		newFeature.setSpaceLayers(spaceLayers);
		
		ArrayList<InterEdges> interEdges = new ArrayList<InterEdges>();
		for (InterEdgesType iet : feature.getInterEdges()) {
			InterEdges ie = change2FeatureClass(savedMap, iet, newFeature.getId());
			interEdges.add(ie);
		}
		newFeature.setInterEdges(interEdges);

		return newFeature;
	}

	public static SpaceLayers change2FeatureClass(IndoorGMLMap savedMap, SpaceLayersType feature, String parentId) {
		// Creating this feature
		SpaceLayers newFeature = (SpaceLayers) savedMap.getFeature(feature.getId());
		if(newFeature == null) {
			if(savedMap.hasFutureID(feature.getId())){
				newFeature = (SpaceLayers)savedMap.getFutureFeature(feature.getId());
			}
			else{
				newFeature = new SpaceLayers(savedMap, feature.getId());
			}
			
			savedMap.setFeature(feature.getId(), "SpaceLayers", newFeature);
		}
		
		// Setting parent 
		MultiLayeredGraph parent = (MultiLayeredGraph) savedMap.getFeature(parentId);
		newFeature.setParent(parent);
		
		// Creating containing features
		ArrayList<SpaceLayer>spaceLayerMember = new ArrayList<SpaceLayer>();
		for (SpaceLayerMemberType slmType : feature.getSpaceLayerMember()) {
			SpaceLayerType slType = slmType.getSpaceLayer();
			SpaceLayer sl = change2FeatureClass(savedMap, slType, newFeature.getId());
			spaceLayerMember.add(sl);
		}
		newFeature.setSpaceLayerMember(spaceLayerMember);

		return newFeature;
	}

	public static InterEdges change2FeatureClass(IndoorGMLMap savedMap, InterEdgesType feature, String parentId) {
		// Creating this feature
		InterEdges newFeature = (InterEdges) savedMap.getFeature(feature.getId());
		if(newFeature == null) {
			newFeature = new InterEdges(savedMap, feature.getId());
			savedMap.setFeature(feature.getId(), "InterEdges", newFeature);
		}
		
		// Setting parent 
		MultiLayeredGraph parent = (MultiLayeredGraph) savedMap.getFeature(parentId);
		newFeature.setParent(parent);
		
		//TODO
		List<InterLayerConnectionMemberType> interLayerConnectionMember = feature.getInterLayerConnectionMember();
		List<InterLayerConnection> interLayerConnection = new ArrayList<InterLayerConnection>();

		for (int i = 0; i < interLayerConnectionMember.size(); i++) {
			InterLayerConnectionType tempILC = new InterLayerConnectionType();
			tempILC = interLayerConnectionMember.get(i).getInterLayerConnection();
			InterLayerConnection temp = new InterLayerConnection(savedMap, tempILC.getId());
			interLayerConnection.add(temp);
			savedMap.setFeature(tempILC.getId(), "InterLayerConnection",
					change2FeatureClass(savedMap, tempILC, newFeature.getId()));
		}

		newFeature.setInterLayerConnectionMember(interLayerConnection);

		return newFeature;
	}

	public static Edges change2FeatureClass(IndoorGMLMap savedMap, EdgesType feature, String parentId) {
		// Creating this feature
		Edges newFeature = (Edges) savedMap.getFeature(feature.getId());
		if(newFeature == null) {
			
			if(savedMap.hasFutureID(feature.getId())){
				newFeature = (Edges)savedMap.getFutureFeature(feature.getId());
			}
			else{
				newFeature = new Edges(savedMap, feature.getId());
			}
			
			savedMap.setFeature(feature.getId(), "Edges", newFeature);
		}
		
		// Setting parent 
		SpaceLayer parent = (SpaceLayer) savedMap.getFeature(parentId);
		newFeature.setParent(parent);
		
		List<TransitionMemberType> tms = feature.getTransitionMember();
		List<Transition> transitionMemberReference = new ArrayList<Transition>();
		
		for(TransitionMemberType tmType : tms) {
			TransitionType tType = tmType.getTransition();
			Transition t = change2FeatureClass(savedMap, tType, newFeature.getId());
			transitionMemberReference.add(t);
			//newFeature.addTransitionMember(t);
		}
		
		newFeature.setTransitionMembers(transitionMemberReference);
		return newFeature;
	}

	public static InterLayerConnection change2FeatureClass(IndoorGMLMap savedMap, InterLayerConnectionType feature, String parentId) {
		// Creating this feature
		InterLayerConnection newFeature = (InterLayerConnection) savedMap.getFeature(feature.getId());
		if(newFeature == null) {
			if(savedMap.hasFutureID(feature.getId())){
				newFeature = (InterLayerConnection)savedMap.getFutureFeature(feature.getId());
			}
			else{
				newFeature = new InterLayerConnection(savedMap, feature.getId());
			}
			
			savedMap.setFeature(feature.getId(), "InterLayerConnection", newFeature);
		}
		
		// Setting parent 
		InterEdges parent = (InterEdges) savedMap.getFeature(parentId);
		newFeature.setParent(parent);

		List<SpaceLayer> spacelayerList = new ArrayList<SpaceLayer>();
		for (SpaceLayerPropertyType slpProp : feature.getConnectedLayers()) {
			
			SpaceLayer connected = null;
			if(slpProp.getHref() != null) {
				String href = slpProp.getHref().substring(1);
				
				connected = (SpaceLayer) savedMap.getFeature(href);
				if(connected == null) {
					//TODO
					connected = new SpaceLayer(savedMap, href);
					savedMap.setFeature(href, "SpaceLayer", connected);
				}
			} else {
				//TODO
				SpaceLayerType sl = slpProp.getSpaceLayer();
			}
			spacelayerList.add(connected);
		}
		SpaceLayer[] connectedLayers = new SpaceLayer[2];
		spacelayerList.toArray(connectedLayers);
		newFeature.setConnectedLayers(connectedLayers);

		List<State> interConnectionList = new ArrayList<State>();
		for (StatePropertyType stateProp : feature.getInterConnects()) {
			
			State s = null;
			if(stateProp.getHref() != null) {
				String href = stateProp.getHref().substring(1);
				
				s = (State) savedMap.getFeature(href);
				if(s == null) {
					//TODO
					s = new State(savedMap, href);
					savedMap.setFeature(href, "State", s);
				}
			} else {
				//TODO
				StateType sl = stateProp.getState();
			}
			interConnectionList.add(s);
		}
		State[] interConnection = new State[2];
		interConnectionList.toArray(interConnection);
		newFeature.setInterConnects(interConnection);

		if (spacelayerList.size() != 2 || interConnectionList.size() != 2) {
			System.out.println("Converter : number of SpaceLayer or InterConnection is not 2 at InterLayerConnection");
		} else {
			
		}

		return newFeature;
	}

	public static PrimalSpaceFeatures change2FeatureClass(IndoorGMLMap savedMap, PrimalSpaceFeaturesType feature, String parentId)
			throws JAXBException {
		// Creating this feature
		PrimalSpaceFeatures newFeature = (PrimalSpaceFeatures) savedMap.getFeature(feature.getId());
		if(newFeature == null) {
			if(savedMap.hasFutureID(feature.getId())){
				newFeature = (PrimalSpaceFeatures)savedMap.getFutureFeature(feature.getId());
			}
			else{
				newFeature = new PrimalSpaceFeatures(savedMap, feature.getId());
			}
			
			savedMap.setFeature(feature.getId(), "PrimalSpaceFeatures", newFeature);
		}
		
		// Setting parent 
		IndoorFeatures parent = (IndoorFeatures) savedMap.getFeature(parentId);
		newFeature.setParent(parent);
		
		// Creating containing features
		for (CellSpaceMemberType csm : feature.getCellSpaceMember()) {
			CellSpaceType cs = csm.getCellSpace().getValue();
			CellSpace c = change2FeatureClass(savedMap, cs, newFeature.getId());
			newFeature.addCellSpaceMember(c);
		}
		
		for (CellSpaceBoundaryMemberType csbm : feature.getCellSpaceBoundaryMember()) {
			CellSpaceBoundaryType cs = csbm.getCellSpaceBoundary().getValue();
			CellSpaceBoundary cb = change2FeatureClass(savedMap, cs, newFeature.getId());
			newFeature.addCellSpaceBoundaryMember(cb);
		}
		
		return newFeature;
	}

	public static Nodes change2FeatureClass(IndoorGMLMap savedMap, NodesType feature, String parentId) {
		// Creating this feature
		Nodes newFeature = (Nodes) savedMap.getFeature(feature.getId());
		if(newFeature == null) {
			
			if(savedMap.hasFutureID(feature.getId())){
				newFeature = (Nodes)savedMap.getFutureFeature(feature.getId());
			}
			else{
				newFeature = new Nodes(savedMap, feature.getId());
			}
			savedMap.setFeature(feature.getId(), "Nodes", newFeature);
			
		}
		
		// Setting parent
		SpaceLayer parent = (SpaceLayer) savedMap.getFeature(parentId);
		newFeature.setParent(parent);
		
		List<StateMemberType> tempML = feature.getStateMember();
		List<State> stateList = new ArrayList<State>();

		for (int i = 0; i < tempML.size(); i++) {
			StateType tempState = tempML.get(i).getState();
			State temp = change2FeatureClass(savedMap, tempState, newFeature.getId());
			stateList.add(temp);
		}
		newFeature.setStateMember(stateList);
		
		savedMap.setFeature(feature.getId(), "Nodes", newFeature);
		return newFeature;
	}

	public static SpaceLayer change2FeatureClass(IndoorGMLMap savedMap, SpaceLayerType feature, String parentId) {
		// Creating this feature
		SpaceLayer newFeature = (SpaceLayer) savedMap.getFeature(feature.getId());
		if(newFeature == null) {
			if(savedMap.hasFutureID(feature.getId())){
				newFeature = (SpaceLayer)savedMap.getFutureFeature(feature.getId());
			}
			else{
				newFeature = new SpaceLayer(savedMap, feature.getId());
			}
			
			savedMap.setFeature(feature.getId(), "SpaceLayer", newFeature);
		}
		
		// Setting parent
		SpaceLayers parent = (SpaceLayers) savedMap.getFeature(parentId);
		newFeature.setParent(parent);
		
		// newFeature.createDate = feature.getCreationDate();
		// newFeature.terminateDate = feature.getTerminateDate();
		newFeature.setClassType(feature.getClazz());

		// Creating containing features
		for (NodesType nodesType : feature.getNodes()) {
			Nodes ns = change2FeatureClass(savedMap, nodesType, newFeature.getId());
			newFeature.addNodes(ns);
		}
		
		for (EdgesType edgesType : feature.getEdges()) {
			Edges ns = change2FeatureClass(savedMap, edgesType, newFeature.getId());
			newFeature.addEdges(ns);
		}
		return newFeature;
	}

	public static SpaceLayerClassType change2FeatureClass(SpaceLayerClassTypeType feature) {
		return null;
	}

	public static State change2FeatureClass(IndoorGMLMap savedMap, StateType feature, String parentId) {
		// Creating this feature
		State newFeature = (State) savedMap.getFeature(feature.getId());
		if(newFeature == null) {
			if(savedMap.hasFutureID(feature.getId())){
				newFeature = (State)savedMap.getFutureFeature(feature.getId());
			}
			else{
				newFeature = new State(savedMap, feature.getId());
			}
			
		}
		
		// Setting parent
		Nodes parent = (Nodes) savedMap.getFeature(parentId);
		if(parent == null){
			if(savedMap.hasFutureID(parentId)){
				parent = (Nodes)savedMap.getFutureFeature(parentId);
				//savedMap.removeFutureID(parentId);
			}
			parent = new Nodes(savedMap, parentId);
		}
		newFeature.setParent(parent);
		
		// 1. duality
		CellSpacePropertyType cellSpaceProp = feature.getDuality();
		if(cellSpaceProp != null){
			// Check state is defined as instance or is referenced
			
			if(cellSpaceProp.getHref() != null) {
				String dualityId = cellSpaceProp.getHref().substring(1);
				
				CellSpace duality = (CellSpace) savedMap.getFeature(dualityId);
				if(duality != null) {
					newFeature.setDuality(duality);
				} else {
					//TODO
					savedMap.setFutureFeature(dualityId, new CellSpace(savedMap,dualityId));
				}
			} else {
				//TODO
			}
		}
		
		// 2. geometry
		if(feature.isSetGeometry()){
			Point geom = Convert2JTSGeometry.convert2Point(feature.getGeometry().getPoint());
			GeometryUtil.setMetadata(geom, "id", feature.getGeometry().getPoint().getId());
			newFeature.setGeometry(geom);
		}
		
		// 3. connects
		List<TransitionPropertyType> featureConnects =  feature.getConnects();
		for (TransitionPropertyType tProp : featureConnects) {
			if(tProp.getHref() != null) {
				String connectsId = tProp.getHref().substring(1);
				newFeature.addConnects(new Transition(savedMap,connectsId));
			} else {
				//TODO
			};
		}
		
		savedMap.setFeature(feature.getId(), "State", newFeature);
		return newFeature;
	}

	public static Transition change2FeatureClass(IndoorGMLMap savedMap, TransitionType feature, String parentId) {
		// Creating this feature
		Transition newFeature = (Transition) savedMap.getFeature(feature.getId());
		if(newFeature == null) {
			if(savedMap.hasFutureID(feature.getId())){
				newFeature = (Transition)savedMap.getFutureFeature(feature.getId());
			}
			else{
				newFeature = new Transition(savedMap, feature.getId());
			}
			
		}
		
		// Setting parent
		Edges parent = (Edges) savedMap.getFeature(parentId);
		newFeature.setParent(parent);
		
		// 2. geometry
		if(feature.isSetGeometry()){
			LineString geom = Convert2JTSGeometry.convert2LineString((LineStringType)feature.getGeometry().getAbstractCurve().getValue());
			GeometryUtil.setMetadata(geom, "id", feature.getGeometry().getAbstractCurve().getValue().getId());
			newFeature.setGeometry(geom);
		}

		// 3. connects
		List<StatePropertyType> connects = feature.getConnects();
		State[] sArr = new State[2];
		
		String connects1Id = connects.get(0).getHref().substring(1);
		State connects1 = new State(savedMap,connects1Id);
		sArr[0] = connects1;
		
		String connects2Id = connects.get(1).getHref().substring(1);
		State connects2 = new State(savedMap,connects2Id);
		sArr[1] = connects2;
		newFeature.setConnects(sArr);
		
		// 4. duality
		CellSpaceBoundaryPropertyType cellSpaceBoundaryProp = feature.getDuality();
		if(cellSpaceBoundaryProp != null){
			// Check state is defined as instance or is referenced
			
			if(cellSpaceBoundaryProp.getHref() != null) {
				String dualityId = cellSpaceBoundaryProp.getHref().substring(1);
				
				CellSpaceBoundary duality = (CellSpaceBoundary) savedMap.getFeature(dualityId);
				if(duality != null) {
					newFeature.setDuality(duality);
				} else {
					//TODO
					savedMap.setFutureFeature(dualityId, new CellSpaceBoundary(savedMap,dualityId));
				}
			} else {
				//TODO
			}
		}

		newFeature.setWeight(feature.getWeight());
		newFeature.setName(feature.getRole());
		savedMap.setFeature(feature.getId(), "Transition", newFeature);
		return newFeature;
	}
	
	
	public static AnchorBoundary change2FeatureClass(IndoorGMLMap savedMap, AnchorBoundaryType feature, String parentId) {
		// Creating this feature
		AnchorBoundary newFeature = (AnchorBoundary) savedMap.getFeature(feature.getId());
		if(newFeature == null) {
			
			if(savedMap.hasFutureID(feature.getId())){
				newFeature = (AnchorBoundary)savedMap.getFutureFeature(feature.getId());
			}
			else {
				newFeature = new AnchorBoundary(savedMap, feature.getId());
			}			
			savedMap.setFeature(feature.getId(), "AnchorBoundary", newFeature);
		}
		
		// Setting parent 
		PrimalSpaceFeatures parent = (PrimalSpaceFeatures) savedMap.getFeature(parentId);
		newFeature.setParent(parent);
		
		// Creating containing features

		// 1. duality
		TransitionPropertyType transitionProp = feature.getDuality();
		if (transitionProp != null) {
			// Check transition is defined as instance or is referenced
			
			if(transitionProp.getHref() != null) {
				String dualityId = transitionProp.getHref().substring(1);
				
				Transition duality = (Transition) savedMap.getFeature(dualityId);
				if(duality != null) {
					newFeature.setDuality(duality);
				} else {
					//TODO
					savedMap.setFutureFeature(dualityId, new Transition(savedMap,dualityId));
				}
			} else {
				//TODO
			}
		}
		
		// 2. geometry
		CellSpaceBoundaryGeometryType cellSpaceBoundaryGeom = feature.getCellSpaceBoundaryGeometry();
		if (cellSpaceBoundaryGeom != null) {
			change2FeatureClass(savedMap, feature.getId(), cellSpaceBoundaryGeom);
		} else {
			//TODO : Exception
			System.out.println("Converter : There is no Geometry Information");
		}
		
		return newFeature;
	}

	public static typeOfTopoExpressionCode change2FeatureClass(TypeOfTopoExpressionCodeEnumerationType feature) {
		typeOfTopoExpressionCode newFeature = new typeOfTopoExpressionCode();

		return null;
	}
	

}
