//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2017.11.22 시간 01:17:09 AM KST 
//


package net.opengis.indoorgml.core.v_1_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.indoorgml.core.v_1_0 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CellSpace_QNAME = new QName("http://www.opengis.net/indoorgml/1.0/core", "CellSpace");
    private final static QName _CellSpaceBoundary_QNAME = new QName("http://www.opengis.net/indoorgml/1.0/core", "CellSpaceBoundary");
    private final static QName _IndoorFeatures_QNAME = new QName("http://www.opengis.net/indoorgml/1.0/core", "IndoorFeatures");
    private final static QName _PrimalSpaceFeatures_QNAME = new QName("http://www.opengis.net/indoorgml/1.0/core", "PrimalSpaceFeatures");
    private final static QName _MultiLayeredGraph_QNAME = new QName("http://www.opengis.net/indoorgml/1.0/core", "MultiLayeredGraph");
    private final static QName _InterLayerConnection_QNAME = new QName("http://www.opengis.net/indoorgml/1.0/core", "InterLayerConnection");
    private final static QName _SpaceLayer_QNAME = new QName("http://www.opengis.net/indoorgml/1.0/core", "SpaceLayer");
    private final static QName _State_QNAME = new QName("http://www.opengis.net/indoorgml/1.0/core", "State");
    private final static QName _Transition_QNAME = new QName("http://www.opengis.net/indoorgml/1.0/core", "Transition");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.indoorgml.core.v_1_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CellSpaceType }
     * 
     */
    public CellSpaceType createCellSpaceType() {
        return new CellSpaceType();
    }

    /**
     * Create an instance of {@link CellSpaceBoundaryType }
     * 
     */
    public CellSpaceBoundaryType createCellSpaceBoundaryType() {
        return new CellSpaceBoundaryType();
    }

    /**
     * Create an instance of {@link IndoorFeaturesType }
     * 
     */
    public IndoorFeaturesType createIndoorFeaturesType() {
        return new IndoorFeaturesType();
    }

    /**
     * Create an instance of {@link PrimalSpaceFeaturesType }
     * 
     */
    public PrimalSpaceFeaturesType createPrimalSpaceFeaturesType() {
        return new PrimalSpaceFeaturesType();
    }

    /**
     * Create an instance of {@link MultiLayeredGraphType }
     * 
     */
    public MultiLayeredGraphType createMultiLayeredGraphType() {
        return new MultiLayeredGraphType();
    }

    /**
     * Create an instance of {@link InterLayerConnectionType }
     * 
     */
    public InterLayerConnectionType createInterLayerConnectionType() {
        return new InterLayerConnectionType();
    }

    /**
     * Create an instance of {@link SpaceLayerType }
     * 
     */
    public SpaceLayerType createSpaceLayerType() {
        return new SpaceLayerType();
    }

    /**
     * Create an instance of {@link StateType }
     * 
     */
    public StateType createStateType() {
        return new StateType();
    }

    /**
     * Create an instance of {@link TransitionType }
     * 
     */
    public TransitionType createTransitionType() {
        return new TransitionType();
    }

    /**
     * Create an instance of {@link PrimalSpaceFeaturesPropertyType }
     * 
     */
    public PrimalSpaceFeaturesPropertyType createPrimalSpaceFeaturesPropertyType() {
        return new PrimalSpaceFeaturesPropertyType();
    }

    /**
     * Create an instance of {@link CellSpaceMemberType }
     * 
     */
    public CellSpaceMemberType createCellSpaceMemberType() {
        return new CellSpaceMemberType();
    }

    /**
     * Create an instance of {@link CellSpaceBoundaryMemberType }
     * 
     */
    public CellSpaceBoundaryMemberType createCellSpaceBoundaryMemberType() {
        return new CellSpaceBoundaryMemberType();
    }

    /**
     * Create an instance of {@link MultiLayeredGraphPropertyType }
     * 
     */
    public MultiLayeredGraphPropertyType createMultiLayeredGraphPropertyType() {
        return new MultiLayeredGraphPropertyType();
    }

    /**
     * Create an instance of {@link SpaceLayersType }
     * 
     */
    public SpaceLayersType createSpaceLayersType() {
        return new SpaceLayersType();
    }

    /**
     * Create an instance of {@link SpaceLayerMemberType }
     * 
     */
    public SpaceLayerMemberType createSpaceLayerMemberType() {
        return new SpaceLayerMemberType();
    }

    /**
     * Create an instance of {@link InterEdgesType }
     * 
     */
    public InterEdgesType createInterEdgesType() {
        return new InterEdgesType();
    }

    /**
     * Create an instance of {@link InterLayerConnectionMemberType }
     * 
     */
    public InterLayerConnectionMemberType createInterLayerConnectionMemberType() {
        return new InterLayerConnectionMemberType();
    }

    /**
     * Create an instance of {@link InterLayerConnectionPropertyType }
     * 
     */
    public InterLayerConnectionPropertyType createInterLayerConnectionPropertyType() {
        return new InterLayerConnectionPropertyType();
    }

    /**
     * Create an instance of {@link SpaceLayerPropertyType }
     * 
     */
    public SpaceLayerPropertyType createSpaceLayerPropertyType() {
        return new SpaceLayerPropertyType();
    }

    /**
     * Create an instance of {@link NodesType }
     * 
     */
    public NodesType createNodesType() {
        return new NodesType();
    }

    /**
     * Create an instance of {@link StateMemberType }
     * 
     */
    public StateMemberType createStateMemberType() {
        return new StateMemberType();
    }

    /**
     * Create an instance of {@link EdgesType }
     * 
     */
    public EdgesType createEdgesType() {
        return new EdgesType();
    }

    /**
     * Create an instance of {@link TransitionMemberType }
     * 
     */
    public TransitionMemberType createTransitionMemberType() {
        return new TransitionMemberType();
    }

    /**
     * Create an instance of {@link StatePropertyType }
     * 
     */
    public StatePropertyType createStatePropertyType() {
        return new StatePropertyType();
    }

    /**
     * Create an instance of {@link TransitionPropertyType }
     * 
     */
    public TransitionPropertyType createTransitionPropertyType() {
        return new TransitionPropertyType();
    }

    /**
     * Create an instance of {@link CellSpacePropertyType }
     * 
     */
    public CellSpacePropertyType createCellSpacePropertyType() {
        return new CellSpacePropertyType();
    }

    /**
     * Create an instance of {@link CellSpaceGeometryType }
     * 
     */
    public CellSpaceGeometryType createCellSpaceGeometryType() {
        return new CellSpaceGeometryType();
    }

    /**
     * Create an instance of {@link CellSpaceBoundaryGeometryType }
     * 
     */
    public CellSpaceBoundaryGeometryType createCellSpaceBoundaryGeometryType() {
        return new CellSpaceBoundaryGeometryType();
    }

    /**
     * Create an instance of {@link CellSpaceBoundaryPropertyType }
     * 
     */
    public CellSpaceBoundaryPropertyType createCellSpaceBoundaryPropertyType() {
        return new CellSpaceBoundaryPropertyType();
    }

    /**
     * Create an instance of {@link ExternalReferenceType }
     * 
     */
    public ExternalReferenceType createExternalReferenceType() {
        return new ExternalReferenceType();
    }

    /**
     * Create an instance of {@link ExternalObjectReferenceType }
     * 
     */
    public ExternalObjectReferenceType createExternalObjectReferenceType() {
        return new ExternalObjectReferenceType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CellSpaceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/indoorgml/1.0/core", name = "CellSpace", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<CellSpaceType> createCellSpace(CellSpaceType value) {
        return new JAXBElement<CellSpaceType>(_CellSpace_QNAME, CellSpaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CellSpaceBoundaryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/indoorgml/1.0/core", name = "CellSpaceBoundary", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<CellSpaceBoundaryType> createCellSpaceBoundary(CellSpaceBoundaryType value) {
        return new JAXBElement<CellSpaceBoundaryType>(_CellSpaceBoundary_QNAME, CellSpaceBoundaryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndoorFeaturesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/indoorgml/1.0/core", name = "IndoorFeatures", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<IndoorFeaturesType> createIndoorFeatures(IndoorFeaturesType value) {
        return new JAXBElement<IndoorFeaturesType>(_IndoorFeatures_QNAME, IndoorFeaturesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrimalSpaceFeaturesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/indoorgml/1.0/core", name = "PrimalSpaceFeatures", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<PrimalSpaceFeaturesType> createPrimalSpaceFeatures(PrimalSpaceFeaturesType value) {
        return new JAXBElement<PrimalSpaceFeaturesType>(_PrimalSpaceFeatures_QNAME, PrimalSpaceFeaturesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiLayeredGraphType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/indoorgml/1.0/core", name = "MultiLayeredGraph", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<MultiLayeredGraphType> createMultiLayeredGraph(MultiLayeredGraphType value) {
        return new JAXBElement<MultiLayeredGraphType>(_MultiLayeredGraph_QNAME, MultiLayeredGraphType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InterLayerConnectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/indoorgml/1.0/core", name = "InterLayerConnection", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<InterLayerConnectionType> createInterLayerConnection(InterLayerConnectionType value) {
        return new JAXBElement<InterLayerConnectionType>(_InterLayerConnection_QNAME, InterLayerConnectionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpaceLayerType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/indoorgml/1.0/core", name = "SpaceLayer", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<SpaceLayerType> createSpaceLayer(SpaceLayerType value) {
        return new JAXBElement<SpaceLayerType>(_SpaceLayer_QNAME, SpaceLayerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/indoorgml/1.0/core", name = "State", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<StateType> createState(StateType value) {
        return new JAXBElement<StateType>(_State_QNAME, StateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransitionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/indoorgml/1.0/core", name = "Transition", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<TransitionType> createTransition(TransitionType value) {
        return new JAXBElement<TransitionType>(_Transition_QNAME, TransitionType.class, null, value);
    }

}
