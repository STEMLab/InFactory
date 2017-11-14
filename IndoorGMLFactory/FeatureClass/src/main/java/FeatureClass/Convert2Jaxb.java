package FeatureClass;
import net.opengis.gml.v_3_2_1.SolidPropertyType;
import net.opengis.gml.v_3_2_1.SurfacePropertyType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceType;
import net.opengis.indoorgml.core.v_1_0.StatePropertyType;
import net.opengis.indoorgml.core.v_1_0.StateType;

public class Convert2Jaxb {
	public CellSpaceType change2JaxbClass(CellSpace feature) {
		//JAXBContextImpl jc = (JAXBContextImpl) JAXBContextImpl.newInstance(CellSpaceType.class);
		CellSpaceType newFeature = new CellSpaceType();
		StatePropertyType duality = new StatePropertyType();
		StateType referredState = new StateType();

		referredState.setId(feature.duality);
		duality.setState(referredState);

		newFeature.setDuality(duality);
		newFeature.setId(feature.ID);
		newFeature.setPartialboundedBy(feature.partialboundedBy);
		
		if(feature.geometryType == "SurfaceType"){
			newFeature.setGeometry2D((SurfacePropertyType)feature.cellSpaceGeometryObject);
		}
		else if(feature.geometryType == "CompositeSurfaceType"){}
		else if(feature.geometryType == "SolidType"){
			newFeature.setGeometry3D((SolidPropertyType)feature.cellSpaceGeometryObject);
		}
		else if(feature.geometryType == "CompositeSolidType"){}
		
		return newFeature;
	}
}
