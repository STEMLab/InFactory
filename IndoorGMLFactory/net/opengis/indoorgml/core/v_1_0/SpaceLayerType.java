//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2017.11.22 시간 01:17:09 AM KST 
//


package net.opengis.indoorgml.core.v_1_0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import net.opengis.gml.v_3_2_1.AbstractFeatureType;
import net.opengis.gml.v_3_2_1.CodeType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy2;
import org.jvnet.jaxb2_commons.lang.CopyTo2;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.HashCode2;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy2;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBMergeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.MergeFrom2;
import org.jvnet.jaxb2_commons.lang.MergeStrategy2;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>SpaceLayerType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="SpaceLayerType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/gml/3.2}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="terminationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/gml/3.2}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="class" type="{http://www.opengis.net/indoorgml/1.0/core}SpaceLayerClassTypeType" minOccurs="0"/&gt;
 *         &lt;element name="nodes" type="{http://www.opengis.net/indoorgml/1.0/core}NodesType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="edges" type="{http://www.opengis.net/indoorgml/1.0/core}EdgesType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpaceLayerType", propOrder = {
    "usage",
    "terminationDate",
    "function",
    "creationDate",
    "clazz",
    "nodes",
    "edges"
})
public class SpaceLayerType
    extends AbstractFeatureType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    protected List<CodeType> usage;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar terminationDate;
    protected List<CodeType> function;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "class")
    @XmlSchemaType(name = "string")
    protected SpaceLayerClassTypeType clazz;
    @XmlElement(required = true)
    protected List<NodesType> nodes;
    protected List<EdgesType> edges;

    /**
     * Gets the value of the usage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getUsage() {
        if (usage == null) {
            usage = new ArrayList<CodeType>();
        }
        return this.usage;
    }

    public boolean isSetUsage() {
        return ((this.usage!= null)&&(!this.usage.isEmpty()));
    }

    public void unsetUsage() {
        this.usage = null;
    }

    /**
     * terminationDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTerminationDate() {
        return terminationDate;
    }

    /**
     * terminationDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTerminationDate(XMLGregorianCalendar value) {
        this.terminationDate = value;
    }

    public boolean isSetTerminationDate() {
        return (this.terminationDate!= null);
    }

    /**
     * Gets the value of the function property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the function property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getFunction() {
        if (function == null) {
            function = new ArrayList<CodeType>();
        }
        return this.function;
    }

    public boolean isSetFunction() {
        return ((this.function!= null)&&(!this.function.isEmpty()));
    }

    public void unsetFunction() {
        this.function = null;
    }

    /**
     * creationDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * creationDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    public boolean isSetCreationDate() {
        return (this.creationDate!= null);
    }

    /**
     * clazz 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SpaceLayerClassTypeType }
     *     
     */
    public SpaceLayerClassTypeType getClazz() {
        return clazz;
    }

    /**
     * clazz 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SpaceLayerClassTypeType }
     *     
     */
    public void setClazz(SpaceLayerClassTypeType value) {
        this.clazz = value;
    }

    public boolean isSetClazz() {
        return (this.clazz!= null);
    }

    /**
     * Gets the value of the nodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NodesType }
     * 
     * 
     */
    public List<NodesType> getNodes() {
        if (nodes == null) {
            nodes = new ArrayList<NodesType>();
        }
        return this.nodes;
    }

    public boolean isSetNodes() {
        return ((this.nodes!= null)&&(!this.nodes.isEmpty()));
    }

    public void unsetNodes() {
        this.nodes = null;
    }

    /**
     * Gets the value of the edges property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the edges property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEdges().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EdgesType }
     * 
     * 
     */
    public List<EdgesType> getEdges() {
        if (edges == null) {
            edges = new ArrayList<EdgesType>();
        }
        return this.edges;
    }

    public boolean isSetEdges() {
        return ((this.edges!= null)&&(!this.edges.isEmpty()));
    }

    public void unsetEdges() {
        this.edges = null;
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        super.appendFields(locator, buffer, strategy);
        {
            List<CodeType> theUsage;
            theUsage = (this.isSetUsage()?this.getUsage():null);
            strategy.appendField(locator, this, "usage", buffer, theUsage, this.isSetUsage());
        }
        {
            XMLGregorianCalendar theTerminationDate;
            theTerminationDate = this.getTerminationDate();
            strategy.appendField(locator, this, "terminationDate", buffer, theTerminationDate, this.isSetTerminationDate());
        }
        {
            List<CodeType> theFunction;
            theFunction = (this.isSetFunction()?this.getFunction():null);
            strategy.appendField(locator, this, "function", buffer, theFunction, this.isSetFunction());
        }
        {
            XMLGregorianCalendar theCreationDate;
            theCreationDate = this.getCreationDate();
            strategy.appendField(locator, this, "creationDate", buffer, theCreationDate, this.isSetCreationDate());
        }
        {
            SpaceLayerClassTypeType theClazz;
            theClazz = this.getClazz();
            strategy.appendField(locator, this, "clazz", buffer, theClazz, this.isSetClazz());
        }
        {
            List<NodesType> theNodes;
            theNodes = (this.isSetNodes()?this.getNodes():null);
            strategy.appendField(locator, this, "nodes", buffer, theNodes, this.isSetNodes());
        }
        {
            List<EdgesType> theEdges;
            theEdges = (this.isSetEdges()?this.getEdges():null);
            strategy.appendField(locator, this, "edges", buffer, theEdges, this.isSetEdges());
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final SpaceLayerType that = ((SpaceLayerType) object);
        {
            List<CodeType> lhsUsage;
            lhsUsage = (this.isSetUsage()?this.getUsage():null);
            List<CodeType> rhsUsage;
            rhsUsage = (that.isSetUsage()?that.getUsage():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "usage", lhsUsage), LocatorUtils.property(thatLocator, "usage", rhsUsage), lhsUsage, rhsUsage, this.isSetUsage(), that.isSetUsage())) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsTerminationDate;
            lhsTerminationDate = this.getTerminationDate();
            XMLGregorianCalendar rhsTerminationDate;
            rhsTerminationDate = that.getTerminationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "terminationDate", lhsTerminationDate), LocatorUtils.property(thatLocator, "terminationDate", rhsTerminationDate), lhsTerminationDate, rhsTerminationDate, this.isSetTerminationDate(), that.isSetTerminationDate())) {
                return false;
            }
        }
        {
            List<CodeType> lhsFunction;
            lhsFunction = (this.isSetFunction()?this.getFunction():null);
            List<CodeType> rhsFunction;
            rhsFunction = (that.isSetFunction()?that.getFunction():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "function", lhsFunction), LocatorUtils.property(thatLocator, "function", rhsFunction), lhsFunction, rhsFunction, this.isSetFunction(), that.isSetFunction())) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsCreationDate;
            lhsCreationDate = this.getCreationDate();
            XMLGregorianCalendar rhsCreationDate;
            rhsCreationDate = that.getCreationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "creationDate", lhsCreationDate), LocatorUtils.property(thatLocator, "creationDate", rhsCreationDate), lhsCreationDate, rhsCreationDate, this.isSetCreationDate(), that.isSetCreationDate())) {
                return false;
            }
        }
        {
            SpaceLayerClassTypeType lhsClazz;
            lhsClazz = this.getClazz();
            SpaceLayerClassTypeType rhsClazz;
            rhsClazz = that.getClazz();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "clazz", lhsClazz), LocatorUtils.property(thatLocator, "clazz", rhsClazz), lhsClazz, rhsClazz, this.isSetClazz(), that.isSetClazz())) {
                return false;
            }
        }
        {
            List<NodesType> lhsNodes;
            lhsNodes = (this.isSetNodes()?this.getNodes():null);
            List<NodesType> rhsNodes;
            rhsNodes = (that.isSetNodes()?that.getNodes():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nodes", lhsNodes), LocatorUtils.property(thatLocator, "nodes", rhsNodes), lhsNodes, rhsNodes, this.isSetNodes(), that.isSetNodes())) {
                return false;
            }
        }
        {
            List<EdgesType> lhsEdges;
            lhsEdges = (this.isSetEdges()?this.getEdges():null);
            List<EdgesType> rhsEdges;
            rhsEdges = (that.isSetEdges()?that.getEdges():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "edges", lhsEdges), LocatorUtils.property(thatLocator, "edges", rhsEdges), lhsEdges, rhsEdges, this.isSetEdges(), that.isSetEdges())) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            List<CodeType> theUsage;
            theUsage = (this.isSetUsage()?this.getUsage():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "usage", theUsage), currentHashCode, theUsage, this.isSetUsage());
        }
        {
            XMLGregorianCalendar theTerminationDate;
            theTerminationDate = this.getTerminationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "terminationDate", theTerminationDate), currentHashCode, theTerminationDate, this.isSetTerminationDate());
        }
        {
            List<CodeType> theFunction;
            theFunction = (this.isSetFunction()?this.getFunction():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "function", theFunction), currentHashCode, theFunction, this.isSetFunction());
        }
        {
            XMLGregorianCalendar theCreationDate;
            theCreationDate = this.getCreationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "creationDate", theCreationDate), currentHashCode, theCreationDate, this.isSetCreationDate());
        }
        {
            SpaceLayerClassTypeType theClazz;
            theClazz = this.getClazz();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "clazz", theClazz), currentHashCode, theClazz, this.isSetClazz());
        }
        {
            List<NodesType> theNodes;
            theNodes = (this.isSetNodes()?this.getNodes():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nodes", theNodes), currentHashCode, theNodes, this.isSetNodes());
        }
        {
            List<EdgesType> theEdges;
            theEdges = (this.isSetEdges()?this.getEdges():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "edges", theEdges), currentHashCode, theEdges, this.isSetEdges());
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        super.copyTo(locator, draftCopy, strategy);
        if (draftCopy instanceof SpaceLayerType) {
            final SpaceLayerType copy = ((SpaceLayerType) draftCopy);
            {
                Boolean usageShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetUsage());
                if (usageShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<CodeType> sourceUsage;
                    sourceUsage = (this.isSetUsage()?this.getUsage():null);
                    @SuppressWarnings("unchecked")
                    List<CodeType> copyUsage = ((List<CodeType> ) strategy.copy(LocatorUtils.property(locator, "usage", sourceUsage), sourceUsage, this.isSetUsage()));
                    copy.unsetUsage();
                    if (copyUsage!= null) {
                        List<CodeType> uniqueUsagel = copy.getUsage();
                        uniqueUsagel.addAll(copyUsage);
                    }
                } else {
                    if (usageShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetUsage();
                    }
                }
            }
            {
                Boolean terminationDateShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetTerminationDate());
                if (terminationDateShouldBeCopiedAndSet == Boolean.TRUE) {
                    XMLGregorianCalendar sourceTerminationDate;
                    sourceTerminationDate = this.getTerminationDate();
                    XMLGregorianCalendar copyTerminationDate = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "terminationDate", sourceTerminationDate), sourceTerminationDate, this.isSetTerminationDate()));
                    copy.setTerminationDate(copyTerminationDate);
                } else {
                    if (terminationDateShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.terminationDate = null;
                    }
                }
            }
            {
                Boolean functionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetFunction());
                if (functionShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<CodeType> sourceFunction;
                    sourceFunction = (this.isSetFunction()?this.getFunction():null);
                    @SuppressWarnings("unchecked")
                    List<CodeType> copyFunction = ((List<CodeType> ) strategy.copy(LocatorUtils.property(locator, "function", sourceFunction), sourceFunction, this.isSetFunction()));
                    copy.unsetFunction();
                    if (copyFunction!= null) {
                        List<CodeType> uniqueFunctionl = copy.getFunction();
                        uniqueFunctionl.addAll(copyFunction);
                    }
                } else {
                    if (functionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetFunction();
                    }
                }
            }
            {
                Boolean creationDateShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetCreationDate());
                if (creationDateShouldBeCopiedAndSet == Boolean.TRUE) {
                    XMLGregorianCalendar sourceCreationDate;
                    sourceCreationDate = this.getCreationDate();
                    XMLGregorianCalendar copyCreationDate = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "creationDate", sourceCreationDate), sourceCreationDate, this.isSetCreationDate()));
                    copy.setCreationDate(copyCreationDate);
                } else {
                    if (creationDateShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.creationDate = null;
                    }
                }
            }
            {
                Boolean clazzShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetClazz());
                if (clazzShouldBeCopiedAndSet == Boolean.TRUE) {
                    SpaceLayerClassTypeType sourceClazz;
                    sourceClazz = this.getClazz();
                    SpaceLayerClassTypeType copyClazz = ((SpaceLayerClassTypeType) strategy.copy(LocatorUtils.property(locator, "clazz", sourceClazz), sourceClazz, this.isSetClazz()));
                    copy.setClazz(copyClazz);
                } else {
                    if (clazzShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.clazz = null;
                    }
                }
            }
            {
                Boolean nodesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetNodes());
                if (nodesShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<NodesType> sourceNodes;
                    sourceNodes = (this.isSetNodes()?this.getNodes():null);
                    @SuppressWarnings("unchecked")
                    List<NodesType> copyNodes = ((List<NodesType> ) strategy.copy(LocatorUtils.property(locator, "nodes", sourceNodes), sourceNodes, this.isSetNodes()));
                    copy.unsetNodes();
                    if (copyNodes!= null) {
                        List<NodesType> uniqueNodesl = copy.getNodes();
                        uniqueNodesl.addAll(copyNodes);
                    }
                } else {
                    if (nodesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetNodes();
                    }
                }
            }
            {
                Boolean edgesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetEdges());
                if (edgesShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<EdgesType> sourceEdges;
                    sourceEdges = (this.isSetEdges()?this.getEdges():null);
                    @SuppressWarnings("unchecked")
                    List<EdgesType> copyEdges = ((List<EdgesType> ) strategy.copy(LocatorUtils.property(locator, "edges", sourceEdges), sourceEdges, this.isSetEdges()));
                    copy.unsetEdges();
                    if (copyEdges!= null) {
                        List<EdgesType> uniqueEdgesl = copy.getEdges();
                        uniqueEdgesl.addAll(copyEdges);
                    }
                } else {
                    if (edgesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetEdges();
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SpaceLayerType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof SpaceLayerType) {
            final SpaceLayerType target = this;
            final SpaceLayerType leftObject = ((SpaceLayerType) left);
            final SpaceLayerType rightObject = ((SpaceLayerType) right);
            {
                Boolean usageShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetUsage(), rightObject.isSetUsage());
                if (usageShouldBeMergedAndSet == Boolean.TRUE) {
                    List<CodeType> lhsUsage;
                    lhsUsage = (leftObject.isSetUsage()?leftObject.getUsage():null);
                    List<CodeType> rhsUsage;
                    rhsUsage = (rightObject.isSetUsage()?rightObject.getUsage():null);
                    List<CodeType> mergedUsage = ((List<CodeType> ) strategy.merge(LocatorUtils.property(leftLocator, "usage", lhsUsage), LocatorUtils.property(rightLocator, "usage", rhsUsage), lhsUsage, rhsUsage, leftObject.isSetUsage(), rightObject.isSetUsage()));
                    target.unsetUsage();
                    if (mergedUsage!= null) {
                        List<CodeType> uniqueUsagel = target.getUsage();
                        uniqueUsagel.addAll(mergedUsage);
                    }
                } else {
                    if (usageShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetUsage();
                    }
                }
            }
            {
                Boolean terminationDateShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetTerminationDate(), rightObject.isSetTerminationDate());
                if (terminationDateShouldBeMergedAndSet == Boolean.TRUE) {
                    XMLGregorianCalendar lhsTerminationDate;
                    lhsTerminationDate = leftObject.getTerminationDate();
                    XMLGregorianCalendar rhsTerminationDate;
                    rhsTerminationDate = rightObject.getTerminationDate();
                    XMLGregorianCalendar mergedTerminationDate = ((XMLGregorianCalendar) strategy.merge(LocatorUtils.property(leftLocator, "terminationDate", lhsTerminationDate), LocatorUtils.property(rightLocator, "terminationDate", rhsTerminationDate), lhsTerminationDate, rhsTerminationDate, leftObject.isSetTerminationDate(), rightObject.isSetTerminationDate()));
                    target.setTerminationDate(mergedTerminationDate);
                } else {
                    if (terminationDateShouldBeMergedAndSet == Boolean.FALSE) {
                        target.terminationDate = null;
                    }
                }
            }
            {
                Boolean functionShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetFunction(), rightObject.isSetFunction());
                if (functionShouldBeMergedAndSet == Boolean.TRUE) {
                    List<CodeType> lhsFunction;
                    lhsFunction = (leftObject.isSetFunction()?leftObject.getFunction():null);
                    List<CodeType> rhsFunction;
                    rhsFunction = (rightObject.isSetFunction()?rightObject.getFunction():null);
                    List<CodeType> mergedFunction = ((List<CodeType> ) strategy.merge(LocatorUtils.property(leftLocator, "function", lhsFunction), LocatorUtils.property(rightLocator, "function", rhsFunction), lhsFunction, rhsFunction, leftObject.isSetFunction(), rightObject.isSetFunction()));
                    target.unsetFunction();
                    if (mergedFunction!= null) {
                        List<CodeType> uniqueFunctionl = target.getFunction();
                        uniqueFunctionl.addAll(mergedFunction);
                    }
                } else {
                    if (functionShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetFunction();
                    }
                }
            }
            {
                Boolean creationDateShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetCreationDate(), rightObject.isSetCreationDate());
                if (creationDateShouldBeMergedAndSet == Boolean.TRUE) {
                    XMLGregorianCalendar lhsCreationDate;
                    lhsCreationDate = leftObject.getCreationDate();
                    XMLGregorianCalendar rhsCreationDate;
                    rhsCreationDate = rightObject.getCreationDate();
                    XMLGregorianCalendar mergedCreationDate = ((XMLGregorianCalendar) strategy.merge(LocatorUtils.property(leftLocator, "creationDate", lhsCreationDate), LocatorUtils.property(rightLocator, "creationDate", rhsCreationDate), lhsCreationDate, rhsCreationDate, leftObject.isSetCreationDate(), rightObject.isSetCreationDate()));
                    target.setCreationDate(mergedCreationDate);
                } else {
                    if (creationDateShouldBeMergedAndSet == Boolean.FALSE) {
                        target.creationDate = null;
                    }
                }
            }
            {
                Boolean clazzShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetClazz(), rightObject.isSetClazz());
                if (clazzShouldBeMergedAndSet == Boolean.TRUE) {
                    SpaceLayerClassTypeType lhsClazz;
                    lhsClazz = leftObject.getClazz();
                    SpaceLayerClassTypeType rhsClazz;
                    rhsClazz = rightObject.getClazz();
                    SpaceLayerClassTypeType mergedClazz = ((SpaceLayerClassTypeType) strategy.merge(LocatorUtils.property(leftLocator, "clazz", lhsClazz), LocatorUtils.property(rightLocator, "clazz", rhsClazz), lhsClazz, rhsClazz, leftObject.isSetClazz(), rightObject.isSetClazz()));
                    target.setClazz(mergedClazz);
                } else {
                    if (clazzShouldBeMergedAndSet == Boolean.FALSE) {
                        target.clazz = null;
                    }
                }
            }
            {
                Boolean nodesShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetNodes(), rightObject.isSetNodes());
                if (nodesShouldBeMergedAndSet == Boolean.TRUE) {
                    List<NodesType> lhsNodes;
                    lhsNodes = (leftObject.isSetNodes()?leftObject.getNodes():null);
                    List<NodesType> rhsNodes;
                    rhsNodes = (rightObject.isSetNodes()?rightObject.getNodes():null);
                    List<NodesType> mergedNodes = ((List<NodesType> ) strategy.merge(LocatorUtils.property(leftLocator, "nodes", lhsNodes), LocatorUtils.property(rightLocator, "nodes", rhsNodes), lhsNodes, rhsNodes, leftObject.isSetNodes(), rightObject.isSetNodes()));
                    target.unsetNodes();
                    if (mergedNodes!= null) {
                        List<NodesType> uniqueNodesl = target.getNodes();
                        uniqueNodesl.addAll(mergedNodes);
                    }
                } else {
                    if (nodesShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetNodes();
                    }
                }
            }
            {
                Boolean edgesShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetEdges(), rightObject.isSetEdges());
                if (edgesShouldBeMergedAndSet == Boolean.TRUE) {
                    List<EdgesType> lhsEdges;
                    lhsEdges = (leftObject.isSetEdges()?leftObject.getEdges():null);
                    List<EdgesType> rhsEdges;
                    rhsEdges = (rightObject.isSetEdges()?rightObject.getEdges():null);
                    List<EdgesType> mergedEdges = ((List<EdgesType> ) strategy.merge(LocatorUtils.property(leftLocator, "edges", lhsEdges), LocatorUtils.property(rightLocator, "edges", rhsEdges), lhsEdges, rhsEdges, leftObject.isSetEdges(), rightObject.isSetEdges()));
                    target.unsetEdges();
                    if (mergedEdges!= null) {
                        List<EdgesType> uniqueEdgesl = target.getEdges();
                        uniqueEdgesl.addAll(mergedEdges);
                    }
                } else {
                    if (edgesShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetEdges();
                    }
                }
            }
        }
    }

    public void setUsage(List<CodeType> value) {
        this.usage = null;
        if (value!= null) {
            List<CodeType> draftl = this.getUsage();
            draftl.addAll(value);
        }
    }

    public void setFunction(List<CodeType> value) {
        this.function = null;
        if (value!= null) {
            List<CodeType> draftl = this.getFunction();
            draftl.addAll(value);
        }
    }

    public void setNodes(List<NodesType> value) {
        this.nodes = null;
        if (value!= null) {
            List<NodesType> draftl = this.getNodes();
            draftl.addAll(value);
        }
    }

    public void setEdges(List<EdgesType> value) {
        this.edges = null;
        if (value!= null) {
            List<EdgesType> draftl = this.getEdges();
            draftl.addAll(value);
        }
    }

    public SpaceLayerType withUsage(CodeType... values) {
        if (values!= null) {
            for (CodeType value: values) {
                getUsage().add(value);
            }
        }
        return this;
    }

    public SpaceLayerType withUsage(Collection<CodeType> values) {
        if (values!= null) {
            getUsage().addAll(values);
        }
        return this;
    }

    public SpaceLayerType withTerminationDate(XMLGregorianCalendar value) {
        setTerminationDate(value);
        return this;
    }

    public SpaceLayerType withFunction(CodeType... values) {
        if (values!= null) {
            for (CodeType value: values) {
                getFunction().add(value);
            }
        }
        return this;
    }

    public SpaceLayerType withFunction(Collection<CodeType> values) {
        if (values!= null) {
            getFunction().addAll(values);
        }
        return this;
    }

    public SpaceLayerType withCreationDate(XMLGregorianCalendar value) {
        setCreationDate(value);
        return this;
    }

    public SpaceLayerType withClazz(SpaceLayerClassTypeType value) {
        setClazz(value);
        return this;
    }

    public SpaceLayerType withNodes(NodesType... values) {
        if (values!= null) {
            for (NodesType value: values) {
                getNodes().add(value);
            }
        }
        return this;
    }

    public SpaceLayerType withNodes(Collection<NodesType> values) {
        if (values!= null) {
            getNodes().addAll(values);
        }
        return this;
    }

    public SpaceLayerType withEdges(EdgesType... values) {
        if (values!= null) {
            for (EdgesType value: values) {
                getEdges().add(value);
            }
        }
        return this;
    }

    public SpaceLayerType withEdges(Collection<EdgesType> values) {
        if (values!= null) {
            getEdges().addAll(values);
        }
        return this;
    }

    public SpaceLayerType withUsage(List<CodeType> value) {
        setUsage(value);
        return this;
    }

    public SpaceLayerType withFunction(List<CodeType> value) {
        setFunction(value);
        return this;
    }

    public SpaceLayerType withNodes(List<NodesType> value) {
        setNodes(value);
        return this;
    }

    public SpaceLayerType withEdges(List<EdgesType> value) {
        setEdges(value);
        return this;
    }

}
