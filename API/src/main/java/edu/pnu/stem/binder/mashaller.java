package edu.pnu.stem.binder;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import edu.pnu.stem.reference.IndoorFeatures;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;
import net.opengis.indoorgml.core.v_1_0.ObjectFactory;
import net.opengis.indoorgml.navigation.v_1_0.RouteType;

public class mashaller {


	public static void exportIndoorGMLCore(Properties props, String id, String filePath) throws Exception {
	
		IndoorFeaturesType indoorFeaturesType = Convert2JaxbClass.change2JaxbClass((IndoorFeatures)Convert2FeatureClass.docContainer.getFeature(id));
		marshalIndoorFeatures(filePath, indoorFeaturesType);
	}



	private void marshalRoute(String path, RouteType routeType) throws JAXBException {

		JAXBContext context;
		Marshaller marshaller;

		context = JAXBContext.newInstance("net.opengis.indoorgml.core.v_1_0" + ":net.opengis.indoorgml.navigation.v_1_0"
				+ ":net.opengis.gml.v_3_2_1");

		File output = null;

		if (path == null) {
			JFileChooser save = new JFileChooser();
			int result = save.showSaveDialog(null);
			if (result == JFileChooser.CANCEL_OPTION) {
				System.exit(1);
			}
			output = save.getSelectedFile();
		} else {
			output = new File(path);
		}

		net.opengis.indoorgml.navigation.v_1_0.ObjectFactory objectFactory = new net.opengis.indoorgml.navigation.v_1_0.ObjectFactory();
		JAXBElement<RouteType> jRoute = objectFactory.createRoute(routeType);

		marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
				"http://www.opengis.net/indoorgml/1.0/core http://schemas.opengis.net/indoorgml/1.0/indoorgmlcore.xsd "
						+ "http://www.opengis.net/indoorgml/1.0/navigation http://schemas.opengis.net/indoorgml/1.0/indoorgmlnavi.xsd");
		try {
			marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new IndoorGMLNameSpaceMapper());
		} catch (PropertyException e) {
			e.printStackTrace();
		}
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		marshaller.marshal(jRoute, output);
	}

	public static void marshalIndoorFeatures(String path, IndoorFeaturesType indoorFeaturesType)
			throws JAXBException, IOException {

		JAXBContext context;
		Marshaller marshaller;

		context = JAXBContext.newInstance("net.opengis.indoorgml.core.v_1_0" + ":net.opengis.indoorgml.navigation.v_1_0"
				+ ":net.opengis.gml.v_3_2_1");

		File output = null;

		if (path == null) {
			JFileChooser save = new JFileChooser();
			int result = save.showSaveDialog(null);
			if (result == JFileChooser.CANCEL_OPTION) {
				System.exit(1);
			}
			output = save.getSelectedFile();
		} else {
			output = new File(path);
		}

		ObjectFactory objectFactory = new ObjectFactory();
		JAXBElement<IndoorFeaturesType> jIndoorFeatures = objectFactory.createIndoorFeatures(indoorFeaturesType);

		marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
				"http://www.opengis.net/indoorgml/1.0/core http://schemas.opengis.net/indoorgml/1.0/indoorgmlcore.xsd "
						+ "http://www.opengis.net/indoorgml/1.0/navigation http://schemas.opengis.net/indoorgml/1.0/indoorgmlnavi.xsd");
		try {
			marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new IndoorGMLNameSpaceMapper());
		} catch (PropertyException e) {
			e.printStackTrace();
		}
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		marshaller.marshal(jIndoorFeatures, output);
	}

	public static class IndoorGMLNameSpaceMapper extends NamespacePrefixMapper {
		private static final String DEFAULT_PREFIX = "";
		private static final String DEFAULT_URI = "http://www.opengis.net/indoorgml/1.0/core";

		private static final String NAVIGATION_PREFIX = "navi";
		private static final String NAVIGATION_URI = "http://www.opengis.net/indoorgml/1.0/navigation";

		private static final String GML_PREFIX = "gml";
		private static final String GML_URI = "http://www.opengis.net/gml/3.2";

		private static final String XLINK_PREFIX = "xlink";
		private static final String XLINK_URI = "http://www.w3.org/1999/xlink";

		@Override
		public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
			if (DEFAULT_URI.equals(namespaceUri)) {
				return DEFAULT_PREFIX;
			} else if (NAVIGATION_URI.equals(namespaceUri)) {
				return NAVIGATION_PREFIX;
			} else if (GML_URI.equals(namespaceUri)) {
				return GML_PREFIX;
			} else if (XLINK_URI.equals(namespaceUri)) {
				return XLINK_PREFIX;
			}
			return suggestion;
		}

		@Override
		public String[] getPreDeclaredNamespaceUris() {
			// TODO Auto-generated method stub
			return new String[] { DEFAULT_URI, NAVIGATION_URI, GML_URI, XLINK_URI };
		}
	}

}
