import java.util.List;

import net.opengis.gml.v_3_2_1.AbstractFeatureType;
import net.opengis.gml.v_3_2_1.SolidPropertyType;
import net.opengis.gml.v_3_2_1.SurfacePropertyType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceBoundaryType;
import net.opengis.indoorgml.core.v_1_0.CellSpacePropertyType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceType;
import net.opengis.indoorgml.core.v_1_0.EdgesType;
import net.opengis.indoorgml.core.v_1_0.ExternalObjectReferenceType;
import net.opengis.indoorgml.core.v_1_0.ExternalReferenceType;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;
import net.opengis.indoorgml.core.v_1_0.InterEdgesType;
import net.opengis.indoorgml.core.v_1_0.InterLayerConnectionType;
import net.opengis.indoorgml.core.v_1_0.MultiLayeredGraphPropertyType;
import net.opengis.indoorgml.core.v_1_0.MultiLayeredGraphType;
import net.opengis.indoorgml.core.v_1_0.NodesType;
import net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturesPropertyType;
import net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturesType;
import net.opengis.indoorgml.core.v_1_0.SpaceLayerClassTypeType;
import net.opengis.indoorgml.core.v_1_0.SpaceLayerPropertyType;
import net.opengis.indoorgml.core.v_1_0.SpaceLayerType;
import net.opengis.indoorgml.core.v_1_0.StatePropertyType;
import net.opengis.indoorgml.core.v_1_0.StateType;
import net.opengis.indoorgml.core.v_1_0.TransitionPropertyType;
import net.opengis.indoorgml.core.v_1_0.TransitionType;
import net.opengis.indoorgml.core.v_1_0.TypeOfTopoExpressionCodeEnumerationType;

public class Converter {
	AbstractFeatures change2FeatureClass(AbstractFeatureType feature) {
		AbstractFeatures newFeature = new AbstractFeatures();
		
		newFeature.ID = feature.getId();
		newFeature.boundedBy = feature.getBoundedBy();
		return newFeature;
	}

	CellSpace change2FeatureClass(CellSpaceType feature) {
		CellSpace newFeature = new CellSpace();
		
		StatePropertyType tempState = feature.getDuality();
		newFeature.duality = tempState.getState();
		newFeature.ID = feature.getId();
		if(feature.getGeometry3D() instanceof SolidPropertyType ){
			newFeature.cellSpaceGeometry.geometry = feature.getGeometry3D().getAbstractSolid();
		}
		else if(feature.getGeometry2D() instanceof SurfacePropertyType){
			
		}
		newFeature.partialboundedBy = feature.getPartialboundedBy();
		
		return newFeature;
	}

	CellSpaceBoundary change2FeatureClass(CellSpaceBoundaryType feature) {
		CellSpaceBoundary newFeature = new CellSpaceBoundary();
		
		newFeature.ID = feature.getId();
		TransitionPropertyType tempTransition = feature.getDuality();		
		newFeature.duality = tempTransition.getTransition();
		
		
		return newFeature;
	}

	/*
	 * 
	 * CellSpaceBoundaryGeometry
	 * change2FeatureClass(CellSpaceBoundaryGeometryType feature) { return null;
	 * } CellSpaceGeometry change2FeatureClass(CellSpaceGeometryType feature) {
	 * return null; }
	 */

	Edges change2FeatureClass(EdgesType feature) {
		Edges newFeature = new Edges();
		
		newFeature.ID = feature.getId();
		newFeature.transitionMember = feature.getTransitionMember();
		
		return newFeature;
	}

	ExternalObjectReference change2FeatureClass(ExternalObjectReferenceType feature) {
		ExternalObjectReference newFeature = new ExternalObjectReference();
		
		newFeature.uri = feature.getUri();
		return newFeature;
	}

	ExternalReference change2FeatureClass(ExternalReferenceType feature) {
		ExternalReference newFeature = new ExternalReference();
		
		newFeature.externalObject = feature.getExternalObject();
		
		return newFeature;
	}

	IndoorFeatures change2FeatureClass(IndoorFeaturesType feature) {
		IndoorFeatures newFeature = new IndoorFeatures();
		
		newFeature.ID = feature.getId();
		MultiLayeredGraphPropertyType tempML = new MultiLayeredGraphPropertyType();
		
		newFeature.multiLayeredGraph = feature.getMultiLayeredGraph();
		
		PrimalSpaceFeaturesPropertyType tempPSFP = new PrimalSpaceFeaturesPropertyType();
		tempPSFP = feature.getPrimalSpaceFeatures();
		newFeature.primalSpaceFeatures = tempPSFP.getPrimalSpaceFeatures();
		return newFeature;
	}

	InterEdges change2FeatureClass(InterEdgesType feature) {
		InterEdges newFeature = new InterEdges();
		
		newFeature.ID = feature.getId();
		newFeature.interLayerConnectionMember = feature.getInterLayerConnectionMember();
		
		
		return newFeature;
	}

	InterLayerConnection change2FeatureClass(InterLayerConnectionType feature) {
		InterLayerConnection newFeature = new InterLayerConnection();
		
		newFeature.ID = feature.getId();
		List<SpaceLayerPropertyType> tempSLList = feature.getConnectedLayers();
		for(int i = 0 ; i < tempSLList.size(); i++){
			SpaceLayerPropertyType tempSingleSL = tempSLList.get(i);
			//.add(tempSingleSL.getSpaceLayer())
			//change List of PropertyType to just Type.
			
		}
		return null;
	}

	MultiLayeredGraph change2FeatureClass(MultiLayeredGraphType feature) {
		return null;
	}

	Nodes change2FeatureClass(NodesType feature) {
		return null;
	}

	PrimalSpaceFeatures change2FeatureClass(PrimalSpaceFeaturesType feature) {
		return null;
	}

	SpaceLayer change2FeatureClass(SpaceLayerType feature) {
		return null;
	}

	SpaceLayerClassType change2FeatureClass(SpaceLayerClassTypeType feature) {
		return null;
	}

	State change2FeatureClass(StateType feature) {
		State newFeature = new State();
		CellSpacePropertyType tempCS = feature.getDuality();
		List<TransitionPropertyType> tempTransition = feature.getConnects();
		
		
		newFeature.ID = feature.getId();
		newFeature.geometry = feature.getGeometry();
		
		newFeature.duality = tempCS.getCellSpace();
		
		newFeature.connects = feature.getConnects();
		
		return newFeature;
	}

	Transition change2FeatureClass(TransitionType feature) {
		return null;
	}

	typeOfTopoExpressionCode change2FeatureClass(TypeOfTopoExpressionCodeEnumerationType feature) {
		return null;
	}
}
