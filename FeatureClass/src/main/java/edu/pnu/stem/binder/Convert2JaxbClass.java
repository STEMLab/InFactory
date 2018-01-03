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
import edu.pnu.stem.feature.SpaceLayers;
import edu.pnu.stem.feature.State;
import edu.pnu.stem.feature.Transition;
import net.opengis.indoorgml.core.v_1_0.CellSpaceBoundaryMemberType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceBoundaryPropertyType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceBoundaryType;
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


public class Convert2JaxbClass {
	static net.opengis.indoorgml.core.v_1_0.ObjectFactory indoorgmlcoreOF = new net.opengis.indoorgml.core.v_1_0.ObjectFactory();
	net.opengis.gml.v_3_2_1.ObjectFactory gmlOF = new net.opengis.gml.v_3_2_1.ObjectFactory();
	@SuppressWarnings("unchecked")
	public static CellSpaceType change2JaxbClass(CellSpace feature) throws JAXBException {
		//JAXBContextImpl jc = (JAXBContextImpl) JAXBContextImpl.newInstance(CellSpaceType.class);
		CellSpaceType newFeature = indoorgmlcoreOF.createCellSpaceType();
		StatePropertyType duality = new StatePropertyType();
		duality.setHref(feature.getDuality());
		//StateType referredState = new StateType();
		//referredState.setId(feature.getDuality());
		//duality.setState(referredState);

		newFeature.setDuality(duality);
		newFeature.setId(feature.id);
		
		List<CellSpaceBoundaryPropertyType> partialboundedBy = new ArrayList<CellSpaceBoundaryPropertyType>();
		
		
		for(int i = 0 ; i < ((List<String>) feature.getPartialboundedBy()).size() ; i++){
			CellSpaceBoundaryPropertyType tempcsb = indoorgmlcoreOF.createCellSpaceBoundaryPropertyType();
			tempcsb.setHref((String)(feature.getPartialboundedBy().get(i)));
			partialboundedBy.add(tempcsb);
			//CellSpaceBoundaryType tempCsb = new CellSpaceBoundaryType();
			//tempCsb.set(feature.getPartialBoundedBy().get(i));
			//JAXBElement<CellSpaceBoundaryType>  tempCsbJaxb = indoorgmlcoreOF.createCellSpaceBoundary(tempCsb);
			//CellSpaceBoundaryPropertyType tempCsbProperty = new CellSpaceBoundaryPropertyType();			
			//tempCsbProperty.setCellSpaceBoundary(tempCsbJaxb);
			//partialboundedBy.add(tempCsbProperty);
		}
		
		newFeature.setPartialboundedBy(partialboundedBy);
		//newFeature.setPartialboundedBy(feature.getPartialBoundedBy());
		/*
		 * 		if(feature.cellSpaceGeometryObject != null){
			if(feature.geometryType == "SurfaceType"){
				//newFeature.setGeometry2D((SurfacePropertyType)feature.cellSpaceGeometryObject);
				JAXBElement<? extends AbstractSurfaceType> tempGeometry = (JAXBElement<? extends AbstractSurfaceType>)feature.cellSpaceGeometryObject;			
				SurfacePropertyType tempGeometryProperty = new SurfacePropertyType();
				tempGeometryProperty.setAbstractSurface(tempGeometry);
				
			}
			else if(feature.geometryType == "CompositeSurfaceType"){
				System.out.println("Converter : CompositeSurfaceType is not yet supported");
			}
			else if(feature.geometryType == "SolidType"){
				//newFeature.setGeometry3D((SolidPropertyType)feature.cellSpaceGeometryObject);
				JAXBElement<? extends AbstractSolidType> tempGeometry = (JAXBElement<? extends AbstractSolidType>)feature.cellSpaceGeometryObject;
				// TODO: How to deal from object to JAXBElement 
				SolidPropertyType tempGeometryProperty = new SolidPropertyType();
				tempGeometryProperty.setAbstractSolid(tempGeometry);
				
			}
			else if(feature.geometryType == "CompositeSolidType"){
				System.out.println("Converter : CompositeSolidType is not yet supported");
			}
		}

		 * */
		
		return newFeature;
	}
	
	public static CellSpaceBoundaryType change2JaxbClass(CellSpaceBoundary feature){
		CellSpaceBoundaryType newFeature = indoorgmlcoreOF.createCellSpaceBoundaryType();
		TransitionPropertyType duality = new TransitionPropertyType();
		
		duality.setHref(feature.getDuality());
		newFeature.setDuality(duality);
		newFeature.setId(feature.id);
		/*
		 * if(feature.cellSpaceBoundaryGeometry != null){
			if(feature.cellSpaceBoundaryGeometry instanceof CurveType){
				JAXBElement<? extends AbstractCurveType> tempGeometry = (JAXBElement<? extends AbstractCurveType>)feature.cellSpaceBoundaryGeometry;
				CurvePropertyType tempGeometryProperty = new CurvePropertyType();
				tempGeometryProperty.setAbstractCurve(tempGeometry);
				//newFeature.setGeometry2D(tempGeometryProperty);
			}
			else if(feature.cellSpaceBoundaryGeometry instanceof SurfaceType){
				JAXBElement<? extends AbstractSurfaceType> tempGeometry = (JAXBElement<? extends AbstractSurfaceType>)feature.cellSpaceBoundaryGeometry;
				SurfacePropertyType tempGeometryProperty = new SurfacePropertyType();
				tempGeometryProperty.setAbstractSurface(tempGeometry);
				//newFeature.setGeometry3D(tempGeometryProperty);
			}
		}
		 * */
		
		//newFeature.setBoundedBy(feature.);
		
		//if(feature.)
		
		
		return newFeature;
	}
	
	public static EdgesType change2JaxbClass(String docId,Edges feature) throws JAXBException{
		EdgesType newFeature = indoorgmlcoreOF.createEdgesType();

		newFeature.setId(feature.ID);
		
		
		List<TransitionMemberType>transitionmember = new ArrayList<TransitionMemberType>();
		for(int j = 0 ; j < feature.transitionMember.size();j++){
			TransitionType temptransition = change2JaxbClass((Transition)Container.getInstance().getFeature(docId,feature.transitionMember.get(j)));
			TransitionMemberType temptm = indoorgmlcoreOF.createTransitionMemberType();
			temptm.setTransition(temptransition);
			transitionmember.add(temptm);
		}
		newFeature.setTransitionMember(transitionmember); 
		
		//newFeature.setBoundedBy(feature.);
		
		return newFeature;
	}

	ExternalObjectReferenceType change2JaxbClass(ExternalObjectReference feature){
		ExternalObjectReferenceType newFeature = new ExternalObjectReferenceType();
		newFeature.setUri(feature.uri);
		
		return newFeature;
		
	}
	
	
	ExternalReferenceType change2JaxbClass(ExternalReference feature){
		ExternalReferenceType newFeature = new ExternalReferenceType();
		
		newFeature.setExternalObject(change2JaxbClass(feature.externalObject));
		// TODO:change externalObjectReference
		return newFeature;
	}
	
	static public IndoorFeaturesType change2JaxbClass(String docId, IndoorFeatures feature) throws JAXBException{
		IndoorFeaturesType newFeature = new IndoorFeaturesType();

		newFeature.setId(feature.getId());
		if(feature.getPrimalSpaceFeatures() != null){
			//Convert2FeatureClass.docContainer.
			PrimalSpaceFeatures p = (PrimalSpaceFeatures) Container.getInstance().getFeature(docId, feature.getPrimalSpaceFeatures());
			PrimalSpaceFeaturesPropertyType pp = indoorgmlcoreOF.createPrimalSpaceFeaturesPropertyType();
			pp.setPrimalSpaceFeatures(change2JaxbClass(docId, p));
			newFeature.setPrimalSpaceFeatures(pp);
		}
		if(feature.getMultiLayeredGraph() != null){
			MultiLayeredGraph m = (MultiLayeredGraph) Container.getInstance().getFeature(docId, feature.getMultiLayeredGraph());
			MultiLayeredGraphPropertyType mp = indoorgmlcoreOF.createMultiLayeredGraphPropertyType();
			mp.setMultiLayeredGraph(change2JaxbClass(docId, m));
			newFeature.setMultiLayeredGraph(mp);
		}
		
		return newFeature;
	}
	private static MultiLayeredGraphType change2JaxbClass(String docId, MultiLayeredGraph feature) throws JAXBException {
		MultiLayeredGraphType newFeature = new MultiLayeredGraphType();
		newFeature.setId(feature.id);
		
		List<SpaceLayersType>spaceLayers = new ArrayList<SpaceLayersType>();
		List<InterEdgesType>interEdges = new ArrayList<InterEdgesType>();
		for(int i = 0 ; i < feature.getSpaceLayers().size();i++){
			String tempId = feature.getSpaceLayers().get(i);
			SpaceLayers tempsl = (SpaceLayers)Container.getInstance().getFeature(docId, tempId);
			SpaceLayersType temp = change2JaxbClass(docId, tempsl);
			spaceLayers.add(temp);
		}
		
		for(int i = 0 ; i < feature.getInterEdges().size();i++){
			InterEdges tempie = (InterEdges)Container.getInstance().getFeature(docId, feature.getInterEdges().get(i));
			InterEdgesType temp = change2JaxbClass(docId, tempie);
			interEdges.add(temp);
		}
		newFeature.setInterEdges(interEdges);
		newFeature.setSpaceLayers(spaceLayers);
		
		return newFeature;
	}
	private static InterEdgesType change2JaxbClass(String docId, InterEdges feature) {
		InterEdgesType newFeature = indoorgmlcoreOF.createInterEdgesType();
		newFeature.setId(feature.id);
		List<InterLayerConnectionMemberType>interlayerconnectionmember = new ArrayList<InterLayerConnectionMemberType>();
		
		for(int i = 0 ; i < feature.getInterLayerConnectionMember().size();i++){
			InterLayerConnection tempilc = (InterLayerConnection) Container.getInstance().getFeature(docId, feature.getInterLayerConnectionMember().get(i));
			InterLayerConnectionType temp = change2Jaxb(tempilc);
			InterLayerConnectionMemberType tempmember = indoorgmlcoreOF.createInterLayerConnectionMemberType();
			tempmember.setInterLayerConnection(temp);
			interlayerconnectionmember.add(tempmember);
		}
		newFeature.setInterLayerConnectionMember(interlayerconnectionmember);
		
		return newFeature;
	}
	

	private static InterLayerConnectionType change2Jaxb(InterLayerConnection feature) {
		InterLayerConnectionType newFeature = indoorgmlcoreOF.createInterLayerConnectionType();
		
		newFeature.setId(feature.getId());
		List<StatePropertyType>interConnects = new ArrayList<StatePropertyType>();
		List<SpaceLayerPropertyType>connectedLayer = new ArrayList<SpaceLayerPropertyType>();
		for(int i = 0 ; i < feature.getInterConnects().length; i++){
			StatePropertyType temp = indoorgmlcoreOF.createStatePropertyType();
			temp.setHref(feature.getInterConnects()[i]);
			interConnects.add(temp);
		}
		for(int i = 0 ; i < feature.getConnectedLayers().length;i++){
			SpaceLayerPropertyType temp = indoorgmlcoreOF.createSpaceLayerPropertyType();
			temp.setHref(feature.getConnectedLayers()[i]);
			connectedLayer.add(temp);
		}
		
		newFeature.setConnectedLayers(connectedLayer);
		newFeature.setInterConnects(interConnects);
				
		return newFeature;
	}

	static SpaceLayersType change2JaxbClass(String docId, SpaceLayers feature) throws JAXBException{
		SpaceLayersType newFeature = new SpaceLayersType();
		
		newFeature.setId(feature.id);
		List<SpaceLayerMemberType> spaceLayerMember = new ArrayList<SpaceLayerMemberType>(); 
		for(int i = 0 ; i < feature.getSpaceLayerMemeber().size(); i++){
			String tempId = feature.getSpaceLayerMemeber().get(i);
			SpaceLayer tempsl = (SpaceLayer) Container.getInstance().getFeature(docId, tempId);
			SpaceLayerType temp = change2JaxbClass(docId, tempsl);
			SpaceLayerMemberType tempsm = new SpaceLayerMemberType();
			tempsm.setSpaceLayer(temp);
			spaceLayerMember.add(tempsm);
		}
		
		newFeature.setSpaceLayerMember(spaceLayerMember);
		
		return newFeature;
	}
	private static SpaceLayerType change2JaxbClass(String docId, SpaceLayer feature) throws JAXBException {
		SpaceLayerType newFeature = new SpaceLayerType();
		newFeature.setId(feature.id);

		List<EdgesType>edgesTypeList = new ArrayList<EdgesType>();
		
		//node 들고와서
		//node 밑의 statemember 찾아서
		//걔 까지만 association으로.

		List<NodesType>nodesTypeList = new ArrayList<NodesType>();
		
		for(int i = 0 ; i < feature.getNodes().size() ; i++){
			Nodes tempnodes = (Nodes) Container.getInstance().getFeature(docId, feature.getNodes().get(i));
			NodesType tempnodestype = change2JaxbClass(docId, tempnodes);
			nodesTypeList.add(tempnodestype);
		}
		newFeature.setNodes(nodesTypeList);
		
		
		for(int i = 0 ; i < feature.getEdges().size() ; i++){
			Edges tempEdge = (Edges) Container.getInstance().getFeature(docId, feature.getEdges().get(i));
			EdgesType tempEdgesType = change2JaxbClass(docId, tempEdge);						
			edgesTypeList.add(tempEdgesType);
		}
		newFeature.setEdges(edgesTypeList);
		
		return newFeature;
	}

	private static NodesType change2JaxbClass(String docId, Nodes feature) throws JAXBException {
		NodesType newFeature = new NodesType();
		
		newFeature.setId(feature.id);
		
		List<StateMemberType>smTypeList = new ArrayList<StateMemberType>();
		for(int i = 0 ; i < feature.getStateMember().size();i++){
			State tempstate = (State)Container.getInstance().getFeature(docId, feature.getStateMember().get(i));
			StateType tempstatetype = change2JaxbClass(tempstate);
			StateMemberType tempstatemember = indoorgmlcoreOF.createStateMemberType();
			tempstatemember.setState(tempstatetype);
			smTypeList.add(tempstatemember);
		}
		
		newFeature.setStateMember(smTypeList);
		
	
		
		return newFeature;
	}

	static PrimalSpaceFeaturesType change2JaxbClass(String docId, PrimalSpaceFeatures feature) throws JAXBException {
		PrimalSpaceFeaturesType newFeature = new PrimalSpaceFeaturesType();
		newFeature.setId(feature.id);
		
		List<CellSpaceMemberType>cellspacemember = new ArrayList<CellSpaceMemberType>();
		List<CellSpaceBoundaryMemberType>cellspaceboundarymember = new ArrayList<CellSpaceBoundaryMemberType>();
		for(int i = 0 ; i < feature.getCellSpaceMember().size();i++){
			CellSpace tempcellspace = (CellSpace)Container.getInstance().getFeature(docId, feature.getCellSpaceMember().get(i));
			CellSpaceMemberType tempcellspacemember = indoorgmlcoreOF.createCellSpaceMemberType();			
			tempcellspacemember.setCellSpace(indoorgmlcoreOF.createCellSpace(change2JaxbClass(tempcellspace)));
			cellspacemember.add(tempcellspacemember);
		}

		for(int i = 0 ; i < feature.getCellSpaceBoundaryMember().size();i++){
			CellSpaceBoundary tempcellspace = (CellSpaceBoundary)Container.getInstance().getFeature(docId, feature.getCellSpaceBoundaryMember().get(i));
			CellSpaceBoundaryMemberType tempcellspacemember = indoorgmlcoreOF.createCellSpaceBoundaryMemberType();
			tempcellspacemember.setCellSpaceBoundary(indoorgmlcoreOF.createCellSpaceBoundary(change2JaxbClass(tempcellspace)));
			cellspaceboundarymember.add(tempcellspacemember);
		}
		
		newFeature.setCellSpaceBoundaryMember(cellspaceboundarymember);
		newFeature.setCellSpaceMember(cellspacemember);
		
		
		
		//newFeature.set
		// TODO Auto-generated method stub
		return newFeature;
	}

	
	
	static StateType change2JaxbClass(State feature) throws JAXBException{
		StateType newFeature = new StateType();
		
		List<TransitionPropertyType>connects = new ArrayList<TransitionPropertyType>();
		
		for(int i = 0 ; i < feature.getConnects().size(); i++){
			TransitionPropertyType tempTransitionPropertyType = new TransitionPropertyType();
			tempTransitionPropertyType.setHref(feature.getConnects().get(i));
			connects.add(tempTransitionPropertyType);		
		}
		CellSpacePropertyType duality = indoorgmlcoreOF.createCellSpacePropertyType();
		duality.setHref(feature.getDuality());
		newFeature.setDuality(duality);
		//feature.geometry
		newFeature.setConnects(connects);
		newFeature.setId(feature.id);
		
		return newFeature;
	}

	static TransitionType change2JaxbClass(Transition feature) throws JAXBException{
		TransitionType newFeature = new TransitionType();
		//CurveType tempCurve = feature.geometry;
		newFeature.setId(feature.id);
		
		List<StatePropertyType>connects = new ArrayList<StatePropertyType>();
		
		for(int i = 0 ; i < feature.getConnects().length;i++){
			StatePropertyType temp = indoorgmlcoreOF.createStatePropertyType();
			temp.setHref(feature.getConnects()[i]);
			connects.add(temp);
		}
		newFeature.setConnects(connects);
		
		CellSpaceBoundaryPropertyType duality = indoorgmlcoreOF.createCellSpaceBoundaryPropertyType();
		duality.setHref(feature.getDuality());
		
		newFeature.setDuality(duality);
		newFeature.setWeight(feature.getWeight());
		
		
		return newFeature;
		
	}
}