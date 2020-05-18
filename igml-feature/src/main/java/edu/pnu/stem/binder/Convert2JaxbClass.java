package edu.pnu.stem.binder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import edu.pnu.stem.feature.core.CellSpace;
import edu.pnu.stem.feature.core.CellSpaceBoundary;
import edu.pnu.stem.feature.core.Edges;
import edu.pnu.stem.feature.core.Envelope;
import edu.pnu.stem.feature.core.ExternalObjectReference;
import edu.pnu.stem.feature.core.ExternalReference;
import edu.pnu.stem.feature.core.IndoorFeatures;
import edu.pnu.stem.feature.core.InterEdges;
import edu.pnu.stem.feature.core.InterLayerConnection;
import edu.pnu.stem.feature.core.MultiLayeredGraph;
import edu.pnu.stem.feature.core.Nodes;
import edu.pnu.stem.feature.core.PrimalSpaceFeatures;
import edu.pnu.stem.feature.core.SpaceLayer;
import edu.pnu.stem.feature.core.SpaceLayers;
import edu.pnu.stem.feature.core.State;
import edu.pnu.stem.feature.core.Transition;
import edu.pnu.stem.feature.navigation.AnchorBoundary;
import edu.pnu.stem.feature.navigation.AnchorSpace;
import edu.pnu.stem.feature.navigation.ConnectionBoundary;
import edu.pnu.stem.feature.navigation.ConnectionSpace;
import edu.pnu.stem.feature.navigation.GeneralSpace;
import edu.pnu.stem.feature.navigation.TransitionSpace;
import edu.pnu.stem.geometry.jts.Solid;
import net.opengis.gml.v_3_2_1.BoundedFeatureType;
import net.opengis.gml.v_3_2_1.BoundingShapeType;
import net.opengis.gml.v_3_2_1.CodeType;
import net.opengis.gml.v_3_2_1.CurvePropertyType;
import net.opengis.gml.v_3_2_1.DirectPositionType;
import net.opengis.gml.v_3_2_1.EnvelopeType;
import net.opengis.gml.v_3_2_1.LineStringType;
import net.opengis.gml.v_3_2_1.PointPropertyType;
import net.opengis.gml.v_3_2_1.PointType;
import net.opengis.gml.v_3_2_1.PolygonType;
import net.opengis.gml.v_3_2_1.SolidPropertyType;
import net.opengis.gml.v_3_2_1.SolidType;
import net.opengis.gml.v_3_2_1.StringOrRefType;
import net.opengis.gml.v_3_2_1.SurfacePropertyType;
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
import net.opengis.indoorgml.core.v_1_0.MultiLayeredGraphPropertyType;
import net.opengis.indoorgml.core.v_1_0.MultiLayeredGraphType;
import net.opengis.indoorgml.core.v_1_0.NodesType;
import net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturesPropertyType;
import net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturesType;
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
import net.opengis.indoorgml.navigation.v_1_0.AnchorBoundaryType;
import net.opengis.indoorgml.navigation.v_1_0.AnchorSpaceType;
import net.opengis.indoorgml.navigation.v_1_0.ConnectionBoundaryType;
import net.opengis.indoorgml.navigation.v_1_0.ConnectionSpaceType;
import net.opengis.indoorgml.navigation.v_1_0.GeneralSpaceType;
import net.opengis.indoorgml.navigation.v_1_0.ObjectFactory;
import net.opengis.indoorgml.navigation.v_1_0.TransitionSpaceType;

public class Convert2JaxbClass {
	static net.opengis.indoorgml.core.v_1_0.ObjectFactory indoorgmlcoreOF = new net.opengis.indoorgml.core.v_1_0.ObjectFactory();

	static net.opengis.gml.v_3_2_1.ObjectFactory gmlOF = new net.opengis.gml.v_3_2_1.ObjectFactory();

	static ObjectFactory indoorgmlnaviOF = new net.opengis.indoorgml.navigation.v_1_0.ObjectFactory();

	@SuppressWarnings("unchecked")
	public static CellSpaceType change2JaxbClass(IndoorGMLMap savedMap, CellSpace feature) throws JAXBException {
		

		CellSpaceType newFeature = indoorgmlcoreOF.createCellSpaceType();
		StatePropertyType duality = new StatePropertyType();

		if (feature.getDuality() != null) {
			String href = feature.getDuality().getId();
			href = "#" + href;
			duality.setHref(href);
			newFeature.setDuality(duality);
		}

		if (feature.getName() != null) {
			List<CodeType> name = new ArrayList<CodeType>();
			CodeType e = new CodeType();
			e.setValue(feature.getName());
			name.add(e);
			newFeature.setName(name);
		}

		if (feature.getDescription() != null) {
			StringOrRefType e = new StringOrRefType();
			e.setValue(feature.getDescription());
			newFeature.setDescription(e);
		}
		newFeature.setId(feature.getId());

		List<CellSpaceBoundaryPropertyType> partialboundedBy = new ArrayList<CellSpaceBoundaryPropertyType>();

		if (feature.getPartialboundedBy() != null) {
			for (int i = 0; i < feature.getPartialboundedBy().size(); i++) {
				CellSpaceBoundaryPropertyType tempcsb = indoorgmlcoreOF.createCellSpaceBoundaryPropertyType();
				String partialboundedByHref = feature.getPartialboundedBy().get(i).getId();
				partialboundedByHref = "#" + partialboundedByHref;
				tempcsb.setHref(partialboundedByHref);
				partialboundedBy.add(tempcsb);
			}

			newFeature.setPartialboundedBy(partialboundedBy);

		}

		// TODO setting Geometry 2D
		Geometry geom = (Geometry) feature.getGeometry();
		if (geom != null) {

			if (geom instanceof Solid) {
				Solid s = (Solid) geom;
				SolidType solid = Convert2JaxbGeometry.Convert2SolidType(s);
				JAXBElement<SolidType> jaxbSolid = gmlOF.createSolid(solid);
				SolidPropertyType solidProp = gmlOF.createSolidPropertyType();
				solidProp.setAbstractSolid(jaxbSolid);

				CellSpaceGeometryType cellSpaceGeometryType = indoorgmlcoreOF.createCellSpaceGeometryType();
				cellSpaceGeometryType.setGeometry3D(solidProp);

				newFeature.setCellSpaceGeometry(cellSpaceGeometryType);
			} else if (geom instanceof Polygon) {
				Polygon p = (Polygon) geom;
				PolygonType polygon = Convert2JaxbGeometry.Convert2SurfaceType(p);
				JAXBElement<PolygonType> jaxbPolygon = gmlOF.createPolygon(polygon);
				SurfacePropertyType polygonProp = gmlOF.createSurfacePropertyType();
				polygonProp.setAbstractSurface(jaxbPolygon);

				CellSpaceGeometryType cellSpaceGeometryType = indoorgmlcoreOF.createCellSpaceGeometryType();
				cellSpaceGeometryType.setGeometry2D(polygonProp);

				newFeature.setCellSpaceGeometry(cellSpaceGeometryType);
			}
		}
		
		return newFeature;
	}

	public static CellSpaceBoundaryType change2JaxbClass(IndoorGMLMap savedMap, CellSpaceBoundary feature) {
		CellSpaceBoundaryType newFeature = indoorgmlcoreOF.createCellSpaceBoundaryType();
		TransitionPropertyType duality = new TransitionPropertyType();
		newFeature.setId(feature.getId());

		if (feature.getDuality() != null) {
			String href = feature.getDuality().getId();
			href = "#" + href;
			duality.setHref(href);
			newFeature.setDuality(duality);
			newFeature.setId(feature.getId());
		}

		if (feature.getName() != null) {
			List<CodeType> name = new ArrayList<CodeType>();
			CodeType e = new CodeType();
			e.setValue(feature.getName());
			name.add(e);
			newFeature.setName(name);
		}

		if (feature.getDescription() != null) {
			StringOrRefType e = new StringOrRefType();
			e.setValue(feature.getDescription());
			newFeature.setDescription(e);
		}

		Geometry geom = (Geometry) feature.getGeometry();
		if (geom != null) {

			if (geom instanceof Polygon) {
				Polygon p = (Polygon) geom;
				PolygonType polygon = Convert2JaxbGeometry.Convert2SurfaceType(p);
				JAXBElement<PolygonType> jaxbPolygon = gmlOF.createPolygon(polygon);
				SurfacePropertyType polygonProp = gmlOF.createSurfacePropertyType();
				polygonProp.setAbstractSurface(jaxbPolygon);

				CellSpaceBoundaryGeometryType cellSpaceBoundaryGeometryType = indoorgmlcoreOF
						.createCellSpaceBoundaryGeometryType();
				cellSpaceBoundaryGeometryType.setGeometry3D(polygonProp);

				newFeature.setCellSpaceBoundaryGeometry(cellSpaceBoundaryGeometryType);
			}
			else if (geom instanceof LineString) {
				LineString l = (LineString) geom;
				LineStringType linestring = Convert2JaxbGeometry.Convert2LineStringType(l);
				JAXBElement<LineStringType> jaxbLineString = gmlOF.createLineString(linestring);
				CurvePropertyType lineProp = gmlOF.createCurvePropertyType();
				lineProp.setAbstractCurve(jaxbLineString);

				CellSpaceBoundaryGeometryType cellSpaceBoundaryGeometryType = indoorgmlcoreOF
						.createCellSpaceBoundaryGeometryType();
				cellSpaceBoundaryGeometryType.setGeometry2D(lineProp);

				newFeature.setCellSpaceBoundaryGeometry(cellSpaceBoundaryGeometryType);
			}
		}

		return newFeature;
	}

	public static EdgesType change2JaxbClass(IndoorGMLMap savedMap, Edges p) throws JAXBException {
		EdgesType newFeature = indoorgmlcoreOF.createEdgesType();

		newFeature.setId(p.getId());

		List<TransitionMemberType> transitionmember = new ArrayList<TransitionMemberType>();

		if (p.getTransitionMember() != null) {
			for (int j = 0; j < p.getTransitionMember().size(); j++) {
				TransitionType temptransition = change2JaxbClass(savedMap,
						(Transition) savedMap.getFeature(p.getTransitionMember().get(j).getId()));
				TransitionMemberType temptm = indoorgmlcoreOF.createTransitionMemberType();
				temptm.setTransition(temptransition);
				transitionmember.add(temptm);
			}
			newFeature.setTransitionMember(transitionmember);

		}

		// newFeature.setBoundedBy(feature.);

		return newFeature;
	}

	ExternalObjectReferenceType change2JaxbClass(ExternalObjectReference feature) {
		ExternalObjectReferenceType newFeature = new ExternalObjectReferenceType();
		newFeature.setUri(feature.getUri());

		return newFeature;

	}

	ExternalReferenceType change2JaxbClass(ExternalReference feature) {
		ExternalReferenceType newFeature = new ExternalReferenceType();

		newFeature.setExternalObject(change2JaxbClass(feature.externalObject));
		// TODO:change externalObjectReference
		return newFeature;
	}

	static public IndoorFeaturesType change2JaxbClass(IndoorGMLMap savedMap, IndoorFeatures feature)
			throws JAXBException {
		IndoorFeaturesType newFeature = new IndoorFeaturesType();
		newFeature.setId(feature.getId());
		
		if(feature.getBoundedBy() != null) {
			Envelope e = (Envelope) savedMap.getFeature(feature.getBoundedBy().getId());	
			JAXBElement<EnvelopeType> jaxbEnvelope = gmlOF.createEnvelope(change2JaxbClass(savedMap,e));
			BoundingShapeType bs = gmlOF.createBoundingShapeType();							
			bs.setEnvelope(jaxbEnvelope);
			newFeature.setBoundedBy(bs);				
		}
		
		if (feature.getPrimalSpaceFeatures() != null) {
			// Convert2FeatureClass.docContainer.
			PrimalSpaceFeatures p = (PrimalSpaceFeatures) savedMap.getFeature(feature.getPrimalSpaceFeatures().getId());
			PrimalSpaceFeaturesPropertyType pp = indoorgmlcoreOF.createPrimalSpaceFeaturesPropertyType();
			pp.setPrimalSpaceFeatures(change2JaxbClass(savedMap, p));
			newFeature.setPrimalSpaceFeatures(pp);
		}
		if (feature.getMultiLayeredGraph() != null) {
			MultiLayeredGraph m = (MultiLayeredGraph) savedMap.getFeature(feature.getMultiLayeredGraph().getId());
			MultiLayeredGraphPropertyType mp = indoorgmlcoreOF.createMultiLayeredGraphPropertyType();
			mp.setMultiLayeredGraph(change2JaxbClass(savedMap, m));
			newFeature.setMultiLayeredGraph(mp);
		}

		return newFeature;
	}
	static public EnvelopeType change2JaxbClass(IndoorGMLMap savedMap, Envelope feature)
			throws JAXBException {
		EnvelopeType newFeature = new EnvelopeType();
		
		Point low = (Point) feature.getLowerCorner();
		Point upper = (Point) feature.getUpperCorner();
		if (low != null) {
			PointType point = Convert2JaxbGeometry.Convert2PointType(low);
			newFeature.setLowerCorner(point.getPos());
		}
		if (upper != null) {
			PointType point = Convert2JaxbGeometry.Convert2PointType(upper);
			
			newFeature.setUpperCorner(point.getPos());
		}
		newFeature.setSrsName(feature.getSrsName());
		newFeature.setSrsDimension(feature.getSrsDimension());

		return newFeature;
	}

	private static MultiLayeredGraphType change2JaxbClass(IndoorGMLMap savedMap, MultiLayeredGraph feature)
			throws JAXBException {
		MultiLayeredGraphType newFeature = new MultiLayeredGraphType();
		newFeature.setId(feature.getId());

		List<SpaceLayersType> spaceLayers = new ArrayList<SpaceLayersType>();
		List<InterEdgesType> interEdges = new ArrayList<InterEdgesType>();
		if (feature.getSpaceLayers() != null) {
			for (int i = 0; i < feature.getSpaceLayers().size(); i++) {
				String tempId = feature.getSpaceLayers().get(i).getId();
				SpaceLayers tempsl = (SpaceLayers) savedMap.getFeature(tempId);
				SpaceLayersType temp = change2JaxbClass(savedMap, tempsl);
				spaceLayers.add(temp);
			}
			newFeature.setSpaceLayers(spaceLayers);
		}

		if (feature.getInterEdges() != null) {
			for (int i = 0; i < feature.getInterEdges().size(); i++) {
				InterEdges tempie = (InterEdges) savedMap.getFeature(feature.getInterEdges().get(i).getId());
				InterEdgesType temp = change2JaxbClass(savedMap, tempie);
				interEdges.add(temp);
			}
			newFeature.setInterEdges(interEdges);
		}

		return newFeature;
	}

	private static InterEdgesType change2JaxbClass(IndoorGMLMap savedMap, InterEdges feature) {
		InterEdgesType newFeature = indoorgmlcoreOF.createInterEdgesType();
		newFeature.setId(feature.getId());
		List<InterLayerConnectionMemberType> interlayerconnectionmember = new ArrayList<InterLayerConnectionMemberType>();

		if (feature.getInterLayerConnectionMember() != null) {
			for (int i = 0; i < feature.getInterLayerConnectionMember().size(); i++) {
				InterLayerConnection tempilc = (InterLayerConnection) savedMap
						.getFeature(feature.getInterLayerConnectionMember().get(i).getId());
				InterLayerConnectionType temp = change2JaxbClass(savedMap, tempilc);
				InterLayerConnectionMemberType tempmember = indoorgmlcoreOF.createInterLayerConnectionMemberType();
				tempmember.setInterLayerConnection(temp);
				interlayerconnectionmember.add(tempmember);
			}
			newFeature.setInterLayerConnectionMember(interlayerconnectionmember);

		}

		return newFeature;
	}

	private static InterLayerConnectionType change2JaxbClass(IndoorGMLMap savedMap, InterLayerConnection feature) {
		InterLayerConnectionType newFeature = indoorgmlcoreOF.createInterLayerConnectionType();

		newFeature.setId(feature.getId());
		List<StatePropertyType> interConnects = new ArrayList<StatePropertyType>();
		List<SpaceLayerPropertyType> connectedLayer = new ArrayList<SpaceLayerPropertyType>();

		if (feature.getInterConnects() != null) {
			for (int i = 0; i < feature.getInterConnects().length; i++) {
				StatePropertyType temp = indoorgmlcoreOF.createStatePropertyType();
				String href = feature.getInterConnects()[i].getId();
				href = "#" + href;
				temp.setHref(href);
				interConnects.add(temp);
			}
		}

		if (feature.getConnectedLayers() != null) {
			for (int i = 0; i < feature.getConnectedLayers().length; i++) {
				SpaceLayerPropertyType temp = indoorgmlcoreOF.createSpaceLayerPropertyType();
				temp.setHref("#" + feature.getConnectedLayers()[i].getId());
				connectedLayer.add(temp);
			}
		}

		if (feature.getTypeOfTopoExpression() != null) {
			newFeature.setTypeOfTopoExpression(feature.getTypeOfTopoExpression().type.toString());

		}

		newFeature.setConnectedLayers(connectedLayer);
		newFeature.setInterConnects(interConnects);

		return newFeature;
	}

	static SpaceLayersType change2JaxbClass(IndoorGMLMap savedMap, SpaceLayers feature) throws JAXBException {
		SpaceLayersType newFeature = new SpaceLayersType();

		newFeature.setId(feature.getId());
		List<SpaceLayerMemberType> spaceLayerMember = new ArrayList<SpaceLayerMemberType>();

		if (feature.getSpaceLayerMember() != null) {
			for (int i = 0; i < feature.getSpaceLayerMember().size(); i++) {
				String tempId = feature.getSpaceLayerMember().get(i).getId();
				SpaceLayer tempsl = (SpaceLayer) savedMap.getFeature(tempId);
				SpaceLayerType temp = change2JaxbClass(savedMap, tempsl);
				SpaceLayerMemberType tempsm = new SpaceLayerMemberType();
				tempsm.setSpaceLayer(temp);
				spaceLayerMember.add(tempsm);
			}
			newFeature.setSpaceLayerMember(spaceLayerMember);

		}

		return newFeature;
	}

	private static SpaceLayerType change2JaxbClass(IndoorGMLMap savedMap, SpaceLayer feature) throws JAXBException {
		SpaceLayerType newFeature = new SpaceLayerType();
		newFeature.setId(feature.getId());

		List<EdgesType> edgesTypeList = new ArrayList<EdgesType>();

		// node ���ͼ�
		// node ���� statemember ã�Ƽ�
		// �� ������ association����.

		List<NodesType> nodesTypeList = new ArrayList<NodesType>();

		for (int i = 0; i < feature.getNodes().size(); i++) {
			Nodes tempnodes = (Nodes) savedMap.getFeature(feature.getNodes().get(i).getId());
			NodesType tempnodestype = change2JaxbClass(savedMap, tempnodes);
			nodesTypeList.add(tempnodestype);
		}
		newFeature.setNodes(nodesTypeList);

		if (feature.getEdges() != null) {
			for (int i = 0; i < feature.getEdges().size(); i++) {
				Edges tempEdge = (Edges) savedMap.getFeature(feature.getEdges().get(i).getId());
				EdgesType tempEdgesType = change2JaxbClass(savedMap, tempEdge);
				edgesTypeList.add(tempEdgesType);
			}
			newFeature.setEdges(edgesTypeList);
		}

		return newFeature;
	}

	private static NodesType change2JaxbClass(IndoorGMLMap savedMap, Nodes feature) throws JAXBException {
		NodesType newFeature = new NodesType();

		newFeature.setId(feature.getId());

		List<StateMemberType> smTypeList = new ArrayList<StateMemberType>();

		if (feature.getStateMember() != null) {
			for (int i = 0; i < feature.getStateMember().size(); i++) {
				State tempstate = (State) savedMap.getFeature(feature.getStateMember().get(i).getId());
				StateType tempstatetype = change2JaxbClass(savedMap, tempstate);
				StateMemberType tempstatemember = indoorgmlcoreOF.createStateMemberType();
				tempstatemember.setState(tempstatetype);
				smTypeList.add(tempstatemember);
			}

			newFeature.setStateMember(smTypeList);

		}

		return newFeature;
	}

	static PrimalSpaceFeaturesType change2JaxbClass(IndoorGMLMap savedMap, PrimalSpaceFeatures feature)
			throws JAXBException {
		PrimalSpaceFeaturesType newFeature = new PrimalSpaceFeaturesType();
		newFeature.setId(feature.getId());

		List<CellSpaceMemberType> cellspacemember = new ArrayList<CellSpaceMemberType>();
		List<CellSpaceBoundaryMemberType> cellspaceboundarymember = new ArrayList<CellSpaceBoundaryMemberType>();

		if (feature.getCellSpaceMember() != null) {
			for (int i = 0; i < feature.getCellSpaceMember().size(); i++) {

				if (feature.getCellSpaceMember().get(i).getClass().getSimpleName().equals("GeneralSpace")) {
					
					
					GeneralSpace tempcellspace = (GeneralSpace) savedMap.getFeature(feature.getCellSpaceMember().get(i).getId());
					CellSpaceMemberType tempcellspacemember = indoorgmlcoreOF.createCellSpaceMemberType();
					tempcellspacemember.setCellSpace(
							indoorgmlnaviOF.createGeneralSpace(change2JaxbClass(savedMap, tempcellspace)));
					cellspacemember.add(tempcellspacemember);

				} else if (feature.getCellSpaceMember().get(i).getClass().getSimpleName().equals("TransitionSpace")) {
					
					TransitionSpace tempcellspace = (TransitionSpace) savedMap
							.getFeature(feature.getCellSpaceMember().get(i).getId());
					CellSpaceMemberType tempcellspacemember = indoorgmlcoreOF.createCellSpaceMemberType();
					tempcellspacemember.setCellSpace(
							indoorgmlnaviOF.createTransitionSpace(change2JaxbClass(savedMap, tempcellspace)));
					cellspacemember.add(tempcellspacemember);
				} else if (feature.getCellSpaceMember().get(i).getClass().getSimpleName().equals("ConnectionSpace")) {
					
					ConnectionSpace tempcellspace = (ConnectionSpace) savedMap
							.getFeature(feature.getCellSpaceMember().get(i).getId());
					CellSpaceMemberType tempcellspacemember = indoorgmlcoreOF.createCellSpaceMemberType();
					tempcellspacemember.setCellSpace(
							indoorgmlnaviOF.createConnectionSpace(change2JaxbClass(savedMap, tempcellspace)));
					cellspacemember.add(tempcellspacemember);

				} else if (feature.getCellSpaceMember().get(i).getClass().getSimpleName().equals("AnchorSpace")) {
					
					AnchorSpace tempcellspace = (AnchorSpace) savedMap
							.getFeature(feature.getCellSpaceMember().get(i).getId());
					CellSpaceMemberType tempcellspacemember = indoorgmlcoreOF.createCellSpaceMemberType();
					tempcellspacemember
							.setCellSpace(indoorgmlnaviOF.createAnchorSpace(change2JaxbClass(savedMap, tempcellspace)));
					cellspacemember.add(tempcellspacemember);

				} else {
					
					CellSpace tempcellspace = (CellSpace) savedMap
							.getFeature(feature.getCellSpaceMember().get(i).getId());
					CellSpaceMemberType tempcellspacemember = indoorgmlcoreOF.createCellSpaceMemberType();
					tempcellspacemember.setCellSpace(indoorgmlcoreOF.createCellSpace(change2JaxbClass(savedMap, tempcellspace)));
					cellspacemember.add(tempcellspacemember);
				}

			}
			newFeature.setCellSpaceMember(cellspacemember);
		}

		if (feature.getCellSpaceBoundaryMember() != null) {
			for (int i = 0; i < feature.getCellSpaceBoundaryMember().size(); i++) {
				
				if (feature.getCellSpaceBoundaryMember().get(i).getClass().getSimpleName().equals("AnchorBoundary")) {
					
					AnchorBoundary tempcellspace = (AnchorBoundary) savedMap.getFeature(feature.getCellSpaceBoundaryMember().get(i).getId());
					CellSpaceBoundaryMemberType tempcellspacemember = indoorgmlcoreOF.createCellSpaceBoundaryMemberType();
					tempcellspacemember.setCellSpaceBoundary(indoorgmlnaviOF.createAnchorBoundary(change2JaxbClass(savedMap, tempcellspace)));
					cellspaceboundarymember.add(tempcellspacemember);
				}
				else if(feature.getCellSpaceBoundaryMember().get(i).getClass().getSimpleName().equals("ConnectionBoundary")) {
					
					ConnectionBoundary tempcellspace = (ConnectionBoundary) savedMap.getFeature(feature.getCellSpaceBoundaryMember().get(i).getId());
					CellSpaceBoundaryMemberType tempcellspacemember = indoorgmlcoreOF.createCellSpaceBoundaryMemberType();
					tempcellspacemember.setCellSpaceBoundary(indoorgmlnaviOF.createConnectionBoundary(change2JaxbClass(savedMap, tempcellspace)));
					cellspaceboundarymember.add(tempcellspacemember);
				}
				else {
					
					CellSpaceBoundary tempcellspace = (CellSpaceBoundary) savedMap
							.getFeature(feature.getCellSpaceBoundaryMember().get(i).getId());
					CellSpaceBoundaryMemberType tempcellspacemember = indoorgmlcoreOF.createCellSpaceBoundaryMemberType();
					tempcellspacemember.setCellSpaceBoundary(indoorgmlcoreOF.createCellSpaceBoundary(change2JaxbClass(savedMap, tempcellspace)));
					cellspaceboundarymember.add(tempcellspacemember);					
				}

			}
			newFeature.setCellSpaceBoundaryMember(cellspaceboundarymember);
		}
		// newFeature.set
		// TODO Auto-generated method stub
		return newFeature;
	}

	static StateType change2JaxbClass(IndoorGMLMap savedMap, State feature) throws JAXBException {
		StateType newFeature = new StateType();

		List<TransitionPropertyType> connects = new ArrayList<TransitionPropertyType>();

		if (feature.getConnects() != null) {
			for (int i = 0; i < feature.getConnects().size(); i++) {
				TransitionPropertyType tempTransitionPropertyType = new TransitionPropertyType();
				String href = feature.getConnects().get(i).getId();
				href = "#" + href;
				tempTransitionPropertyType.setHref(href);
				connects.add(tempTransitionPropertyType);
			}
			newFeature.setConnects(connects);
		}

		Point geom = (Point) feature.getGeometry();
		if (geom != null) {
			PointType point = Convert2JaxbGeometry.Convert2PointType(geom);
			PointPropertyType pointProp = gmlOF.createPointPropertyType();
			pointProp.setPoint(point);
			newFeature.setGeometry(pointProp);
		}

		if (feature.getDuality() != null) {
			CellSpacePropertyType duality = indoorgmlcoreOF.createCellSpacePropertyType();
			String href = feature.getDuality().getId();
			href = "#" + href;
			duality.setHref(href);
			newFeature.setDuality(duality);
		}
		// feature.geometry

		if (feature.getName() != null) {
			List<CodeType> name = new ArrayList<CodeType>();
			CodeType e = new CodeType();
			e.setValue(feature.getName());
			name.add(e);
			newFeature.setName(name);
		}

		if (feature.getDescription() != null) {
			StringOrRefType e = new StringOrRefType();
			e.setValue(feature.getDescription());
			newFeature.setDescription(e);
		}

		newFeature.setId(feature.getId());
		return newFeature;
	}

	static TransitionType change2JaxbClass(IndoorGMLMap savedMap, Transition feature) throws JAXBException {
		TransitionType newFeature = new TransitionType();
		// CurveType tempCurve = feature.geometry;
		newFeature.setId(feature.getId());

		List<StatePropertyType> connects = new ArrayList<StatePropertyType>();

		if (feature.getConnects() != null) {
			for (int i = 0; i < feature.getConnects().length; i++) {
				StatePropertyType temp = indoorgmlcoreOF.createStatePropertyType();
				String href = feature.getConnects()[i].getId();
				href = "#" + href;
				temp.setHref(href);
				connects.add(temp);
			}
			newFeature.setConnects(connects);
		}

		LineString geom = (LineString) feature.getGeometry();
		if (geom != null) {
			LineStringType linestring = Convert2JaxbGeometry.Convert2LineStringType(geom);
			CurvePropertyType curveProperty = gmlOF.createCurvePropertyType();
			curveProperty.setAbstractCurve(gmlOF.createLineString(linestring));
			newFeature.setGeometry(curveProperty);
		}

		if (feature.getDuality() != null) {
			CellSpaceBoundaryPropertyType duality = indoorgmlcoreOF.createCellSpaceBoundaryPropertyType();
			String href = feature.getDuality().getId();
			href = "#" + href;
			duality.setHref(href);
			newFeature.setDuality(duality);
		}

		if (feature.getName() != null) {
			List<CodeType> name = new ArrayList<CodeType>();
			CodeType e = new CodeType();
			e.setValue(feature.getName());
			name.add(e);
			newFeature.setName(name);
		}

		if (feature.getDescription() != null) {
			StringOrRefType e = new StringOrRefType();
			e.setValue(feature.getDescription());
			newFeature.setDescription(e);
		}

		newFeature.setWeight(feature.getWeight());

		return newFeature;

	}

	public static GeneralSpaceType change2JaxbClass(IndoorGMLMap savedMap, GeneralSpace feature) throws JAXBException {
		
		GeneralSpaceType newFeature = indoorgmlnaviOF.createGeneralSpaceType();
		StatePropertyType duality = new StatePropertyType();

		if (feature.getDuality() != null) {
			String href = feature.getDuality().getId();
			href = "#" + href;
			duality.setHref(href);
			newFeature.setDuality(duality);
		}

		if (feature.getName() != null) {
			List<CodeType> name = new ArrayList<CodeType>();
			CodeType e = new CodeType();
			e.setValue(feature.getName());
			name.add(e);
			newFeature.setName(name);
		}

		if (feature.getDescription() != null) {
			StringOrRefType e = new StringOrRefType();
			e.setValue(feature.getDescription());
			newFeature.setDescription(e);
		}
		if (feature.getClassType() != null) {
			CodeType e = new CodeType();
			e.setValue(feature.getClassType());
			newFeature.setClazz(e);
			
		}
		if (feature.getFunctionType() != null) {
			CodeType e = new CodeType();
			e.setValue(feature.getFunctionType());
			newFeature.setFunction(e);
			
		}
		if (feature.getUsageType() != null) {
			CodeType e = new CodeType();
			e.setValue(feature.getUsageType());
			newFeature.setUsage(e);
			

		}
		newFeature.setId(feature.getId());

		List<CellSpaceBoundaryPropertyType> partialboundedBy = new ArrayList<CellSpaceBoundaryPropertyType>();

		if (feature.getPartialboundedBy() != null) {
			for (int i = 0; i < feature.getPartialboundedBy().size(); i++) {
				CellSpaceBoundaryPropertyType tempcsb = indoorgmlcoreOF.createCellSpaceBoundaryPropertyType();
				String partialboundedByHref = feature.getPartialboundedBy().get(i).getId();
				partialboundedByHref = "#" + partialboundedByHref;
				tempcsb.setHref(partialboundedByHref);
				partialboundedBy.add(tempcsb);
			}

			newFeature.setPartialboundedBy(partialboundedBy);

		}

		// TODO setting Geometry 2D
		Geometry geom = (Geometry) feature.getGeometry();
		if (geom != null) {

			if (geom instanceof Solid) {
				Solid s = (Solid) geom;
				SolidType solid = Convert2JaxbGeometry.Convert2SolidType(s);
				JAXBElement<SolidType> jaxbSolid = gmlOF.createSolid(solid);
				SolidPropertyType solidProp = gmlOF.createSolidPropertyType();
				solidProp.setAbstractSolid(jaxbSolid);

				CellSpaceGeometryType cellSpaceGeometryType = indoorgmlcoreOF.createCellSpaceGeometryType();
				cellSpaceGeometryType.setGeometry3D(solidProp);

				newFeature.setCellSpaceGeometry(cellSpaceGeometryType);
			} else if (geom instanceof Polygon) {
				Polygon p = (Polygon) geom;
				PolygonType polygon = Convert2JaxbGeometry.Convert2SurfaceType(p);
				JAXBElement<PolygonType> jaxbPolygon = gmlOF.createPolygon(polygon);
				SurfacePropertyType polygonProp = gmlOF.createSurfacePropertyType();
				polygonProp.setAbstractSurface(jaxbPolygon);

				CellSpaceGeometryType cellSpaceGeometryType = indoorgmlcoreOF.createCellSpaceGeometryType();
				cellSpaceGeometryType.setGeometry2D(polygonProp);

				newFeature.setCellSpaceGeometry(cellSpaceGeometryType);
			}
		}

		return newFeature;
	}

	public static TransitionSpaceType change2JaxbClass(IndoorGMLMap savedMap, TransitionSpace feature) throws JAXBException {
		
		TransitionSpaceType newFeature = indoorgmlnaviOF.createTransitionSpaceType();
		StatePropertyType duality = new StatePropertyType();

		if (feature.getDuality() != null) {
			String href = feature.getDuality().getId();
			href = "#" + href;
			duality.setHref(href);
			newFeature.setDuality(duality);
		}

		if (feature.getName() != null) {
			List<CodeType> name = new ArrayList<CodeType>();
			CodeType e = new CodeType();
			e.setValue(feature.getName());
			name.add(e);
			newFeature.setName(name);
		}

		if (feature.getDescription() != null) {
			StringOrRefType e = new StringOrRefType();
			e.setValue(feature.getDescription());
			newFeature.setDescription(e);
		}
		if (feature.getClassType() != null) {
			CodeType e = new CodeType();
			e.setValue(feature.getClassType());
			newFeature.setClazz(e);
			
		}
		if (feature.getFunctionType() != null) {
			CodeType e = new CodeType();
			e.setValue(feature.getFunctionType());
			newFeature.setFunction(e);
			
		}
		if (feature.getUsageType() != null) {
			CodeType e = new CodeType();
			e.setValue(feature.getUsageType());
			newFeature.setUsage(e);
		}
		newFeature.setId(feature.getId());

		List<CellSpaceBoundaryPropertyType> partialboundedBy = new ArrayList<CellSpaceBoundaryPropertyType>();

		if (feature.getPartialboundedBy() != null) {
			for (int i = 0; i < feature.getPartialboundedBy().size(); i++) {
				CellSpaceBoundaryPropertyType tempcsb = indoorgmlcoreOF.createCellSpaceBoundaryPropertyType();
				String partialboundedByHref = feature.getPartialboundedBy().get(i).getId();
				partialboundedByHref = "#" + partialboundedByHref;
				tempcsb.setHref(partialboundedByHref);
				partialboundedBy.add(tempcsb);
			}

			newFeature.setPartialboundedBy(partialboundedBy);

		}

		// TODO setting Geometry 2D
		Geometry geom = (Geometry) feature.getGeometry();
		if (geom != null) {

			if (geom instanceof Solid) {
				Solid s = (Solid) geom;
				SolidType solid = Convert2JaxbGeometry.Convert2SolidType(s);
				JAXBElement<SolidType> jaxbSolid = gmlOF.createSolid(solid);
				SolidPropertyType solidProp = gmlOF.createSolidPropertyType();
				solidProp.setAbstractSolid(jaxbSolid);

				CellSpaceGeometryType cellSpaceGeometryType = indoorgmlcoreOF.createCellSpaceGeometryType();
				cellSpaceGeometryType.setGeometry3D(solidProp);

				newFeature.setCellSpaceGeometry(cellSpaceGeometryType);
			} else if (geom instanceof Polygon) {
				Polygon p = (Polygon) geom;
				PolygonType polygon = Convert2JaxbGeometry.Convert2SurfaceType(p);
				JAXBElement<PolygonType> jaxbPolygon = gmlOF.createPolygon(polygon);
				SurfacePropertyType polygonProp = gmlOF.createSurfacePropertyType();
				polygonProp.setAbstractSurface(jaxbPolygon);

				CellSpaceGeometryType cellSpaceGeometryType = indoorgmlcoreOF.createCellSpaceGeometryType();
				cellSpaceGeometryType.setGeometry2D(polygonProp);

				newFeature.setCellSpaceGeometry(cellSpaceGeometryType);
			}
		}

		return newFeature;
	}

	public static ConnectionSpaceType change2JaxbClass(IndoorGMLMap savedMap, ConnectionSpace feature)
			throws JAXBException {
		
		ConnectionSpaceType newFeature = indoorgmlnaviOF.createConnectionSpaceType();
		StatePropertyType duality = new StatePropertyType();

		if (feature.getDuality() != null) {
			String href = feature.getDuality().getId();
			href = "#" + href;
			duality.setHref(href);
			newFeature.setDuality(duality);
		}

		if (feature.getName() != null) {
			List<CodeType> name = new ArrayList<CodeType>();
			CodeType e = new CodeType();
			e.setValue(feature.getName());
			name.add(e);
			newFeature.setName(name);
		}

		if (feature.getDescription() != null) {
			StringOrRefType e = new StringOrRefType();
			e.setValue(feature.getDescription());
			newFeature.setDescription(e);
		}
		if (feature.getClassType() != null) {
			CodeType e = new CodeType();
			e.setValue(feature.getClassType());
			newFeature.setClazz(e);
			
		}
		if (feature.getFunctionType() != null) {
			CodeType e = new CodeType();
			e.setValue(feature.getFunctionType());
			newFeature.setFunction(e);
			
		}
		if (feature.getUsageType() != null) {
			CodeType e = new CodeType();
			e.setValue(feature.getUsageType());
			newFeature.setUsage(e);
			

		}
		newFeature.setId(feature.getId());

		List<CellSpaceBoundaryPropertyType> partialboundedBy = new ArrayList<CellSpaceBoundaryPropertyType>();

		if (feature.getPartialboundedBy() != null) {
			for (int i = 0; i < feature.getPartialboundedBy().size(); i++) {
				CellSpaceBoundaryPropertyType tempcsb = indoorgmlcoreOF.createCellSpaceBoundaryPropertyType();
				String partialboundedByHref = feature.getPartialboundedBy().get(i).getId();
				partialboundedByHref = "#" + partialboundedByHref;
				tempcsb.setHref(partialboundedByHref);
				partialboundedBy.add(tempcsb);
			}

			newFeature.setPartialboundedBy(partialboundedBy);

		}

		// TODO setting Geometry 2D
		Geometry geom = (Geometry) feature.getGeometry();
		if (geom != null) {

			if (geom instanceof Solid) {
				Solid s = (Solid) geom;
				SolidType solid = Convert2JaxbGeometry.Convert2SolidType(s);
				JAXBElement<SolidType> jaxbSolid = gmlOF.createSolid(solid);
				SolidPropertyType solidProp = gmlOF.createSolidPropertyType();
				solidProp.setAbstractSolid(jaxbSolid);

				CellSpaceGeometryType cellSpaceGeometryType = indoorgmlcoreOF.createCellSpaceGeometryType();
				cellSpaceGeometryType.setGeometry3D(solidProp);

				newFeature.setCellSpaceGeometry(cellSpaceGeometryType);
			} else if (geom instanceof Polygon) {
				Polygon p = (Polygon) geom;
				PolygonType polygon = Convert2JaxbGeometry.Convert2SurfaceType(p);
				JAXBElement<PolygonType> jaxbPolygon = gmlOF.createPolygon(polygon);
				SurfacePropertyType polygonProp = gmlOF.createSurfacePropertyType();
				polygonProp.setAbstractSurface(jaxbPolygon);

				CellSpaceGeometryType cellSpaceGeometryType = indoorgmlcoreOF.createCellSpaceGeometryType();
				cellSpaceGeometryType.setGeometry2D(polygonProp);

				newFeature.setCellSpaceGeometry(cellSpaceGeometryType);
			}
		}

		return newFeature;
	}

	public static AnchorSpaceType change2JaxbClass(IndoorGMLMap savedMap, AnchorSpace feature) throws JAXBException {
		
		AnchorSpaceType newFeature = indoorgmlnaviOF.createAnchorSpaceType();
		StatePropertyType duality = new StatePropertyType();

		if (feature.getDuality() != null) {
			String href = feature.getDuality().getId();
			href = "#" + href;
			duality.setHref(href);
			newFeature.setDuality(duality);
		}

		if (feature.getName() != null) {
			List<CodeType> name = new ArrayList<CodeType>();
			CodeType e = new CodeType();
			e.setValue(feature.getName());
			name.add(e);
			newFeature.setName(name);
		}

		if (feature.getDescription() != null) {
			StringOrRefType e = new StringOrRefType();
			e.setValue(feature.getDescription());
			newFeature.setDescription(e);
		}
		if (feature.getClassType() != null) {
			CodeType e = new CodeType();
			e.setValue(feature.getClassType());
			newFeature.setClazz(e);
			
		}
		if (feature.getFunctionType() != null) {
			CodeType e = new CodeType();
			e.setValue(feature.getFunctionType());
			newFeature.setFunction(e);
			
		}
		if (feature.getUsageType() != null) {
			CodeType e = new CodeType();
			e.setValue(feature.getUsageType());
			newFeature.setUsage(e);
			

		}
		newFeature.setId(feature.getId());

		List<CellSpaceBoundaryPropertyType> partialboundedBy = new ArrayList<CellSpaceBoundaryPropertyType>();

		if (feature.getPartialboundedBy() != null) {
			for (int i = 0; i < feature.getPartialboundedBy().size(); i++) {
				CellSpaceBoundaryPropertyType tempcsb = indoorgmlcoreOF.createCellSpaceBoundaryPropertyType();
				String partialboundedByHref = feature.getPartialboundedBy().get(i).getId();
				partialboundedByHref = "#" + partialboundedByHref;
				tempcsb.setHref(partialboundedByHref);
				partialboundedBy.add(tempcsb);
			}

			newFeature.setPartialboundedBy(partialboundedBy);

		}

		// TODO setting Geometry 2D
		Geometry geom = (Geometry) feature.getGeometry();
		if (geom != null) {

			if (geom instanceof Solid) {
				Solid s = (Solid) geom;
				SolidType solid = Convert2JaxbGeometry.Convert2SolidType(s);
				JAXBElement<SolidType> jaxbSolid = gmlOF.createSolid(solid);
				SolidPropertyType solidProp = gmlOF.createSolidPropertyType();
				solidProp.setAbstractSolid(jaxbSolid);

				CellSpaceGeometryType cellSpaceGeometryType = indoorgmlcoreOF.createCellSpaceGeometryType();
				cellSpaceGeometryType.setGeometry3D(solidProp);

				newFeature.setCellSpaceGeometry(cellSpaceGeometryType);
			} else if (geom instanceof Polygon) {
				Polygon p = (Polygon) geom;
				PolygonType polygon = Convert2JaxbGeometry.Convert2SurfaceType(p);
				JAXBElement<PolygonType> jaxbPolygon = gmlOF.createPolygon(polygon);
				SurfacePropertyType polygonProp = gmlOF.createSurfacePropertyType();
				polygonProp.setAbstractSurface(jaxbPolygon);

				CellSpaceGeometryType cellSpaceGeometryType = indoorgmlcoreOF.createCellSpaceGeometryType();
				cellSpaceGeometryType.setGeometry2D(polygonProp);

				newFeature.setCellSpaceGeometry(cellSpaceGeometryType);
			}
		}

		return newFeature;
	}

	public static AnchorBoundaryType change2JaxbClass(IndoorGMLMap savedMap, AnchorBoundary feature) {
		AnchorBoundaryType newFeature = indoorgmlnaviOF.createAnchorBoundaryType();
		TransitionPropertyType duality = new TransitionPropertyType();
		newFeature.setId(feature.getId());

		if (feature.getDuality() != null) {
			String href = feature.getDuality().getId();
			href = "#" + href;
			duality.setHref(href);
			newFeature.setDuality(duality);
			newFeature.setId(feature.getId());
		}

		if (feature.getName() != null) {
			List<CodeType> name = new ArrayList<CodeType>();
			CodeType e = new CodeType();
			e.setValue(feature.getName());
			name.add(e);
			newFeature.setName(name);
		}

		if (feature.getDescription() != null) {
			StringOrRefType e = new StringOrRefType();
			e.setValue(feature.getDescription());
			newFeature.setDescription(e);
		}

		Geometry geom = (Geometry) feature.getGeometry();
		if (geom != null) {

			if (geom instanceof Polygon) {
				Polygon p = (Polygon) geom;
				PolygonType polygon = Convert2JaxbGeometry.Convert2SurfaceType(p);
				JAXBElement<PolygonType> jaxbPolygon = gmlOF.createPolygon(polygon);
				SurfacePropertyType polygonProp = gmlOF.createSurfacePropertyType();
				polygonProp.setAbstractSurface(jaxbPolygon);

				CellSpaceBoundaryGeometryType cellSpaceBoundaryGeometryType = indoorgmlcoreOF
						.createCellSpaceBoundaryGeometryType();
				cellSpaceBoundaryGeometryType.setGeometry3D(polygonProp);

				newFeature.setCellSpaceBoundaryGeometry(cellSpaceBoundaryGeometryType);
			} else if (geom instanceof LineString) {
				LineString l = (LineString) geom;
				LineStringType linestring = Convert2JaxbGeometry.Convert2LineStringType(l);
				JAXBElement<LineStringType> jaxbLineString = gmlOF.createLineString(linestring);
				CurvePropertyType lineProp = gmlOF.createCurvePropertyType();
				lineProp.setAbstractCurve(jaxbLineString);

				CellSpaceBoundaryGeometryType cellSpaceBoundaryGeometryType = indoorgmlcoreOF
						.createCellSpaceBoundaryGeometryType();
				cellSpaceBoundaryGeometryType.setGeometry2D(lineProp);

				newFeature.setCellSpaceBoundaryGeometry(cellSpaceBoundaryGeometryType);
			}
		}

		return newFeature;
	}

	public static ConnectionBoundaryType change2JaxbClass(IndoorGMLMap savedMap, ConnectionBoundary feature) {
		ConnectionBoundaryType newFeature = indoorgmlnaviOF.createConnectionBoundaryType();
		TransitionPropertyType duality = new TransitionPropertyType();
		newFeature.setId(feature.getId());

		if (feature.getDuality() != null) {
			String href = feature.getDuality().getId();
			href = "#" + href;
			duality.setHref(href);
			newFeature.setDuality(duality);
			newFeature.setId(feature.getId());
		}

		if (feature.getName() != null) {
			List<CodeType> name = new ArrayList<CodeType>();
			CodeType e = new CodeType();
			e.setValue(feature.getName());
			name.add(e);
			newFeature.setName(name);
		}

		if (feature.getDescription() != null) {
			StringOrRefType e = new StringOrRefType();
			e.setValue(feature.getDescription());
			newFeature.setDescription(e);
		}

		Geometry geom = (Geometry) feature.getGeometry();
		if (geom != null) {

			if (geom instanceof Polygon) {
				Polygon p = (Polygon) geom;
				PolygonType polygon = Convert2JaxbGeometry.Convert2SurfaceType(p);
				JAXBElement<PolygonType> jaxbPolygon = gmlOF.createPolygon(polygon);
				SurfacePropertyType polygonProp = gmlOF.createSurfacePropertyType();
				polygonProp.setAbstractSurface(jaxbPolygon);

				CellSpaceBoundaryGeometryType cellSpaceBoundaryGeometryType = indoorgmlcoreOF
						.createCellSpaceBoundaryGeometryType();
				cellSpaceBoundaryGeometryType.setGeometry3D(polygonProp);

				newFeature.setCellSpaceBoundaryGeometry(cellSpaceBoundaryGeometryType);
			} else if (geom instanceof LineString) {
				LineString l = (LineString) geom;
				LineStringType linestring = Convert2JaxbGeometry.Convert2LineStringType(l);
				JAXBElement<LineStringType> jaxbLineString = gmlOF.createLineString(linestring);
				CurvePropertyType lineProp = gmlOF.createCurvePropertyType();
				lineProp.setAbstractCurve(jaxbLineString);

				CellSpaceBoundaryGeometryType cellSpaceBoundaryGeometryType = indoorgmlcoreOF
						.createCellSpaceBoundaryGeometryType();
				cellSpaceBoundaryGeometryType.setGeometry2D(lineProp);

				newFeature.setCellSpaceBoundaryGeometry(cellSpaceBoundaryGeometryType);
			}
		}

		return newFeature;
	}

}