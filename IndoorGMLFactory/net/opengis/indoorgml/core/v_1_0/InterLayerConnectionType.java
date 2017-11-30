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
import net.opengis.gml.v_3_2_1.AbstractFeatureType;
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
 * <p>InterLayerConnectionType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="InterLayerConnectionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="typeOfTopoExpression" type="{http://www.opengis.net/indoorgml/1.0/core}typeOfTopoExpressionCodeType" minOccurs="0"/&gt;
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="interConnects" type="{http://www.opengis.net/indoorgml/1.0/core}StatePropertyType" maxOccurs="2" minOccurs="2"/&gt;
 *         &lt;element name="ConnectedLayers" type="{http://www.opengis.net/indoorgml/1.0/core}SpaceLayerPropertyType" maxOccurs="2" minOccurs="2"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterLayerConnectionType", propOrder = {
    "typeOfTopoExpression",
    "comment",
    "interConnects",
    "connectedLayers"
})
public class InterLayerConnectionType
    extends AbstractFeatureType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    @XmlSchemaType(name = "anySimpleType")
    protected String typeOfTopoExpression;
    protected String comment;
    @XmlElement(required = true)
    protected List<StatePropertyType> interConnects;
    @XmlElement(name = "ConnectedLayers", required = true)
    protected List<SpaceLayerPropertyType> connectedLayers;

    /**
     * typeOfTopoExpression 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOfTopoExpression() {
        return typeOfTopoExpression;
    }

    /**
     * typeOfTopoExpression 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOfTopoExpression(String value) {
        this.typeOfTopoExpression = value;
    }

    public boolean isSetTypeOfTopoExpression() {
        return (this.typeOfTopoExpression!= null);
    }

    /**
     * comment 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * comment 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    public boolean isSetComment() {
        return (this.comment!= null);
    }

    /**
     * Gets the value of the interConnects property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interConnects property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterConnects().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatePropertyType }
     * 
     * 
     */
    public List<StatePropertyType> getInterConnects() {
        if (interConnects == null) {
            interConnects = new ArrayList<StatePropertyType>();
        }
        return this.interConnects;
    }

    public boolean isSetInterConnects() {
        return ((this.interConnects!= null)&&(!this.interConnects.isEmpty()));
    }

    public void unsetInterConnects() {
        this.interConnects = null;
    }

    /**
     * Gets the value of the connectedLayers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connectedLayers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConnectedLayers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpaceLayerPropertyType }
     * 
     * 
     */
    public List<SpaceLayerPropertyType> getConnectedLayers() {
        if (connectedLayers == null) {
            connectedLayers = new ArrayList<SpaceLayerPropertyType>();
        }
        return this.connectedLayers;
    }

    public boolean isSetConnectedLayers() {
        return ((this.connectedLayers!= null)&&(!this.connectedLayers.isEmpty()));
    }

    public void unsetConnectedLayers() {
        this.connectedLayers = null;
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
            String theTypeOfTopoExpression;
            theTypeOfTopoExpression = this.getTypeOfTopoExpression();
            strategy.appendField(locator, this, "typeOfTopoExpression", buffer, theTypeOfTopoExpression, this.isSetTypeOfTopoExpression());
        }
        {
            String theComment;
            theComment = this.getComment();
            strategy.appendField(locator, this, "comment", buffer, theComment, this.isSetComment());
        }
        {
            List<StatePropertyType> theInterConnects;
            theInterConnects = (this.isSetInterConnects()?this.getInterConnects():null);
            strategy.appendField(locator, this, "interConnects", buffer, theInterConnects, this.isSetInterConnects());
        }
        {
            List<SpaceLayerPropertyType> theConnectedLayers;
            theConnectedLayers = (this.isSetConnectedLayers()?this.getConnectedLayers():null);
            strategy.appendField(locator, this, "connectedLayers", buffer, theConnectedLayers, this.isSetConnectedLayers());
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
        final InterLayerConnectionType that = ((InterLayerConnectionType) object);
        {
            String lhsTypeOfTopoExpression;
            lhsTypeOfTopoExpression = this.getTypeOfTopoExpression();
            String rhsTypeOfTopoExpression;
            rhsTypeOfTopoExpression = that.getTypeOfTopoExpression();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "typeOfTopoExpression", lhsTypeOfTopoExpression), LocatorUtils.property(thatLocator, "typeOfTopoExpression", rhsTypeOfTopoExpression), lhsTypeOfTopoExpression, rhsTypeOfTopoExpression, this.isSetTypeOfTopoExpression(), that.isSetTypeOfTopoExpression())) {
                return false;
            }
        }
        {
            String lhsComment;
            lhsComment = this.getComment();
            String rhsComment;
            rhsComment = that.getComment();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "comment", lhsComment), LocatorUtils.property(thatLocator, "comment", rhsComment), lhsComment, rhsComment, this.isSetComment(), that.isSetComment())) {
                return false;
            }
        }
        {
            List<StatePropertyType> lhsInterConnects;
            lhsInterConnects = (this.isSetInterConnects()?this.getInterConnects():null);
            List<StatePropertyType> rhsInterConnects;
            rhsInterConnects = (that.isSetInterConnects()?that.getInterConnects():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "interConnects", lhsInterConnects), LocatorUtils.property(thatLocator, "interConnects", rhsInterConnects), lhsInterConnects, rhsInterConnects, this.isSetInterConnects(), that.isSetInterConnects())) {
                return false;
            }
        }
        {
            List<SpaceLayerPropertyType> lhsConnectedLayers;
            lhsConnectedLayers = (this.isSetConnectedLayers()?this.getConnectedLayers():null);
            List<SpaceLayerPropertyType> rhsConnectedLayers;
            rhsConnectedLayers = (that.isSetConnectedLayers()?that.getConnectedLayers():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "connectedLayers", lhsConnectedLayers), LocatorUtils.property(thatLocator, "connectedLayers", rhsConnectedLayers), lhsConnectedLayers, rhsConnectedLayers, this.isSetConnectedLayers(), that.isSetConnectedLayers())) {
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
            String theTypeOfTopoExpression;
            theTypeOfTopoExpression = this.getTypeOfTopoExpression();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "typeOfTopoExpression", theTypeOfTopoExpression), currentHashCode, theTypeOfTopoExpression, this.isSetTypeOfTopoExpression());
        }
        {
            String theComment;
            theComment = this.getComment();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "comment", theComment), currentHashCode, theComment, this.isSetComment());
        }
        {
            List<StatePropertyType> theInterConnects;
            theInterConnects = (this.isSetInterConnects()?this.getInterConnects():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "interConnects", theInterConnects), currentHashCode, theInterConnects, this.isSetInterConnects());
        }
        {
            List<SpaceLayerPropertyType> theConnectedLayers;
            theConnectedLayers = (this.isSetConnectedLayers()?this.getConnectedLayers():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "connectedLayers", theConnectedLayers), currentHashCode, theConnectedLayers, this.isSetConnectedLayers());
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
        if (draftCopy instanceof InterLayerConnectionType) {
            final InterLayerConnectionType copy = ((InterLayerConnectionType) draftCopy);
            {
                Boolean typeOfTopoExpressionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetTypeOfTopoExpression());
                if (typeOfTopoExpressionShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceTypeOfTopoExpression;
                    sourceTypeOfTopoExpression = this.getTypeOfTopoExpression();
                    String copyTypeOfTopoExpression = ((String) strategy.copy(LocatorUtils.property(locator, "typeOfTopoExpression", sourceTypeOfTopoExpression), sourceTypeOfTopoExpression, this.isSetTypeOfTopoExpression()));
                    copy.setTypeOfTopoExpression(copyTypeOfTopoExpression);
                } else {
                    if (typeOfTopoExpressionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.typeOfTopoExpression = null;
                    }
                }
            }
            {
                Boolean commentShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetComment());
                if (commentShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceComment;
                    sourceComment = this.getComment();
                    String copyComment = ((String) strategy.copy(LocatorUtils.property(locator, "comment", sourceComment), sourceComment, this.isSetComment()));
                    copy.setComment(copyComment);
                } else {
                    if (commentShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.comment = null;
                    }
                }
            }
            {
                Boolean interConnectsShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetInterConnects());
                if (interConnectsShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<StatePropertyType> sourceInterConnects;
                    sourceInterConnects = (this.isSetInterConnects()?this.getInterConnects():null);
                    @SuppressWarnings("unchecked")
                    List<StatePropertyType> copyInterConnects = ((List<StatePropertyType> ) strategy.copy(LocatorUtils.property(locator, "interConnects", sourceInterConnects), sourceInterConnects, this.isSetInterConnects()));
                    copy.unsetInterConnects();
                    if (copyInterConnects!= null) {
                        List<StatePropertyType> uniqueInterConnectsl = copy.getInterConnects();
                        uniqueInterConnectsl.addAll(copyInterConnects);
                    }
                } else {
                    if (interConnectsShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetInterConnects();
                    }
                }
            }
            {
                Boolean connectedLayersShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetConnectedLayers());
                if (connectedLayersShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<SpaceLayerPropertyType> sourceConnectedLayers;
                    sourceConnectedLayers = (this.isSetConnectedLayers()?this.getConnectedLayers():null);
                    @SuppressWarnings("unchecked")
                    List<SpaceLayerPropertyType> copyConnectedLayers = ((List<SpaceLayerPropertyType> ) strategy.copy(LocatorUtils.property(locator, "connectedLayers", sourceConnectedLayers), sourceConnectedLayers, this.isSetConnectedLayers()));
                    copy.unsetConnectedLayers();
                    if (copyConnectedLayers!= null) {
                        List<SpaceLayerPropertyType> uniqueConnectedLayersl = copy.getConnectedLayers();
                        uniqueConnectedLayersl.addAll(copyConnectedLayers);
                    }
                } else {
                    if (connectedLayersShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetConnectedLayers();
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new InterLayerConnectionType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof InterLayerConnectionType) {
            final InterLayerConnectionType target = this;
            final InterLayerConnectionType leftObject = ((InterLayerConnectionType) left);
            final InterLayerConnectionType rightObject = ((InterLayerConnectionType) right);
            {
                Boolean typeOfTopoExpressionShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetTypeOfTopoExpression(), rightObject.isSetTypeOfTopoExpression());
                if (typeOfTopoExpressionShouldBeMergedAndSet == Boolean.TRUE) {
                    String lhsTypeOfTopoExpression;
                    lhsTypeOfTopoExpression = leftObject.getTypeOfTopoExpression();
                    String rhsTypeOfTopoExpression;
                    rhsTypeOfTopoExpression = rightObject.getTypeOfTopoExpression();
                    String mergedTypeOfTopoExpression = ((String) strategy.merge(LocatorUtils.property(leftLocator, "typeOfTopoExpression", lhsTypeOfTopoExpression), LocatorUtils.property(rightLocator, "typeOfTopoExpression", rhsTypeOfTopoExpression), lhsTypeOfTopoExpression, rhsTypeOfTopoExpression, leftObject.isSetTypeOfTopoExpression(), rightObject.isSetTypeOfTopoExpression()));
                    target.setTypeOfTopoExpression(mergedTypeOfTopoExpression);
                } else {
                    if (typeOfTopoExpressionShouldBeMergedAndSet == Boolean.FALSE) {
                        target.typeOfTopoExpression = null;
                    }
                }
            }
            {
                Boolean commentShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetComment(), rightObject.isSetComment());
                if (commentShouldBeMergedAndSet == Boolean.TRUE) {
                    String lhsComment;
                    lhsComment = leftObject.getComment();
                    String rhsComment;
                    rhsComment = rightObject.getComment();
                    String mergedComment = ((String) strategy.merge(LocatorUtils.property(leftLocator, "comment", lhsComment), LocatorUtils.property(rightLocator, "comment", rhsComment), lhsComment, rhsComment, leftObject.isSetComment(), rightObject.isSetComment()));
                    target.setComment(mergedComment);
                } else {
                    if (commentShouldBeMergedAndSet == Boolean.FALSE) {
                        target.comment = null;
                    }
                }
            }
            {
                Boolean interConnectsShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetInterConnects(), rightObject.isSetInterConnects());
                if (interConnectsShouldBeMergedAndSet == Boolean.TRUE) {
                    List<StatePropertyType> lhsInterConnects;
                    lhsInterConnects = (leftObject.isSetInterConnects()?leftObject.getInterConnects():null);
                    List<StatePropertyType> rhsInterConnects;
                    rhsInterConnects = (rightObject.isSetInterConnects()?rightObject.getInterConnects():null);
                    List<StatePropertyType> mergedInterConnects = ((List<StatePropertyType> ) strategy.merge(LocatorUtils.property(leftLocator, "interConnects", lhsInterConnects), LocatorUtils.property(rightLocator, "interConnects", rhsInterConnects), lhsInterConnects, rhsInterConnects, leftObject.isSetInterConnects(), rightObject.isSetInterConnects()));
                    target.unsetInterConnects();
                    if (mergedInterConnects!= null) {
                        List<StatePropertyType> uniqueInterConnectsl = target.getInterConnects();
                        uniqueInterConnectsl.addAll(mergedInterConnects);
                    }
                } else {
                    if (interConnectsShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetInterConnects();
                    }
                }
            }
            {
                Boolean connectedLayersShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetConnectedLayers(), rightObject.isSetConnectedLayers());
                if (connectedLayersShouldBeMergedAndSet == Boolean.TRUE) {
                    List<SpaceLayerPropertyType> lhsConnectedLayers;
                    lhsConnectedLayers = (leftObject.isSetConnectedLayers()?leftObject.getConnectedLayers():null);
                    List<SpaceLayerPropertyType> rhsConnectedLayers;
                    rhsConnectedLayers = (rightObject.isSetConnectedLayers()?rightObject.getConnectedLayers():null);
                    List<SpaceLayerPropertyType> mergedConnectedLayers = ((List<SpaceLayerPropertyType> ) strategy.merge(LocatorUtils.property(leftLocator, "connectedLayers", lhsConnectedLayers), LocatorUtils.property(rightLocator, "connectedLayers", rhsConnectedLayers), lhsConnectedLayers, rhsConnectedLayers, leftObject.isSetConnectedLayers(), rightObject.isSetConnectedLayers()));
                    target.unsetConnectedLayers();
                    if (mergedConnectedLayers!= null) {
                        List<SpaceLayerPropertyType> uniqueConnectedLayersl = target.getConnectedLayers();
                        uniqueConnectedLayersl.addAll(mergedConnectedLayers);
                    }
                } else {
                    if (connectedLayersShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetConnectedLayers();
                    }
                }
            }
        }
    }

    public void setInterConnects(List<StatePropertyType> value) {
        this.interConnects = null;
        if (value!= null) {
            List<StatePropertyType> draftl = this.getInterConnects();
            draftl.addAll(value);
        }
    }

    public void setConnectedLayers(List<SpaceLayerPropertyType> value) {
        this.connectedLayers = null;
        if (value!= null) {
            List<SpaceLayerPropertyType> draftl = this.getConnectedLayers();
            draftl.addAll(value);
        }
    }

    public InterLayerConnectionType withTypeOfTopoExpression(String value) {
        setTypeOfTopoExpression(value);
        return this;
    }

    public InterLayerConnectionType withComment(String value) {
        setComment(value);
        return this;
    }

    public InterLayerConnectionType withInterConnects(StatePropertyType... values) {
        if (values!= null) {
            for (StatePropertyType value: values) {
                getInterConnects().add(value);
            }
        }
        return this;
    }

    public InterLayerConnectionType withInterConnects(Collection<StatePropertyType> values) {
        if (values!= null) {
            getInterConnects().addAll(values);
        }
        return this;
    }

    public InterLayerConnectionType withConnectedLayers(SpaceLayerPropertyType... values) {
        if (values!= null) {
            for (SpaceLayerPropertyType value: values) {
                getConnectedLayers().add(value);
            }
        }
        return this;
    }

    public InterLayerConnectionType withConnectedLayers(Collection<SpaceLayerPropertyType> values) {
        if (values!= null) {
            getConnectedLayers().addAll(values);
        }
        return this;
    }

    public InterLayerConnectionType withInterConnects(List<StatePropertyType> value) {
        setInterConnects(value);
        return this;
    }

    public InterLayerConnectionType withConnectedLayers(List<SpaceLayerPropertyType> value) {
        setConnectedLayers(value);
        return this;
    }

}
