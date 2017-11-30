//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2017.11.22 시간 01:17:09 AM KST 
//


package net.opengis.indoorgml.navigation.v_1_0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.v_3_2_1.AbstractFeatureType;
import net.opengis.gml.v_3_2_1.AggregationType;
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
 * <p>RouteNodesType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="RouteNodesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nodeMember" type="{http://www.opengis.net/indoorgml/1.0/navigation}RouteNodeMemberType" maxOccurs="unbounded" minOccurs="2"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{http://www.opengis.net/gml/3.2}AggregationAttributeGroup"/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteNodesType", propOrder = {
    "nodeMember"
})
public class RouteNodesType
    extends AbstractFeatureType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    @XmlElement(required = true)
    protected List<RouteNodeMemberType> nodeMember;
    @XmlAttribute(name = "aggregationType")
    protected AggregationType aggregationType;

    /**
     * Gets the value of the nodeMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nodeMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNodeMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RouteNodeMemberType }
     * 
     * 
     */
    public List<RouteNodeMemberType> getNodeMember() {
        if (nodeMember == null) {
            nodeMember = new ArrayList<RouteNodeMemberType>();
        }
        return this.nodeMember;
    }

    public boolean isSetNodeMember() {
        return ((this.nodeMember!= null)&&(!this.nodeMember.isEmpty()));
    }

    public void unsetNodeMember() {
        this.nodeMember = null;
    }

    /**
     * aggregationType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AggregationType }
     *     
     */
    public AggregationType getAggregationType() {
        return aggregationType;
    }

    /**
     * aggregationType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AggregationType }
     *     
     */
    public void setAggregationType(AggregationType value) {
        this.aggregationType = value;
    }

    public boolean isSetAggregationType() {
        return (this.aggregationType!= null);
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
            List<RouteNodeMemberType> theNodeMember;
            theNodeMember = (this.isSetNodeMember()?this.getNodeMember():null);
            strategy.appendField(locator, this, "nodeMember", buffer, theNodeMember, this.isSetNodeMember());
        }
        {
            AggregationType theAggregationType;
            theAggregationType = this.getAggregationType();
            strategy.appendField(locator, this, "aggregationType", buffer, theAggregationType, this.isSetAggregationType());
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
        final RouteNodesType that = ((RouteNodesType) object);
        {
            List<RouteNodeMemberType> lhsNodeMember;
            lhsNodeMember = (this.isSetNodeMember()?this.getNodeMember():null);
            List<RouteNodeMemberType> rhsNodeMember;
            rhsNodeMember = (that.isSetNodeMember()?that.getNodeMember():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nodeMember", lhsNodeMember), LocatorUtils.property(thatLocator, "nodeMember", rhsNodeMember), lhsNodeMember, rhsNodeMember, this.isSetNodeMember(), that.isSetNodeMember())) {
                return false;
            }
        }
        {
            AggregationType lhsAggregationType;
            lhsAggregationType = this.getAggregationType();
            AggregationType rhsAggregationType;
            rhsAggregationType = that.getAggregationType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "aggregationType", lhsAggregationType), LocatorUtils.property(thatLocator, "aggregationType", rhsAggregationType), lhsAggregationType, rhsAggregationType, this.isSetAggregationType(), that.isSetAggregationType())) {
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
            List<RouteNodeMemberType> theNodeMember;
            theNodeMember = (this.isSetNodeMember()?this.getNodeMember():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nodeMember", theNodeMember), currentHashCode, theNodeMember, this.isSetNodeMember());
        }
        {
            AggregationType theAggregationType;
            theAggregationType = this.getAggregationType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aggregationType", theAggregationType), currentHashCode, theAggregationType, this.isSetAggregationType());
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
        if (draftCopy instanceof RouteNodesType) {
            final RouteNodesType copy = ((RouteNodesType) draftCopy);
            {
                Boolean nodeMemberShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetNodeMember());
                if (nodeMemberShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<RouteNodeMemberType> sourceNodeMember;
                    sourceNodeMember = (this.isSetNodeMember()?this.getNodeMember():null);
                    @SuppressWarnings("unchecked")
                    List<RouteNodeMemberType> copyNodeMember = ((List<RouteNodeMemberType> ) strategy.copy(LocatorUtils.property(locator, "nodeMember", sourceNodeMember), sourceNodeMember, this.isSetNodeMember()));
                    copy.unsetNodeMember();
                    if (copyNodeMember!= null) {
                        List<RouteNodeMemberType> uniqueNodeMemberl = copy.getNodeMember();
                        uniqueNodeMemberl.addAll(copyNodeMember);
                    }
                } else {
                    if (nodeMemberShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetNodeMember();
                    }
                }
            }
            {
                Boolean aggregationTypeShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetAggregationType());
                if (aggregationTypeShouldBeCopiedAndSet == Boolean.TRUE) {
                    AggregationType sourceAggregationType;
                    sourceAggregationType = this.getAggregationType();
                    AggregationType copyAggregationType = ((AggregationType) strategy.copy(LocatorUtils.property(locator, "aggregationType", sourceAggregationType), sourceAggregationType, this.isSetAggregationType()));
                    copy.setAggregationType(copyAggregationType);
                } else {
                    if (aggregationTypeShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.aggregationType = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new RouteNodesType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof RouteNodesType) {
            final RouteNodesType target = this;
            final RouteNodesType leftObject = ((RouteNodesType) left);
            final RouteNodesType rightObject = ((RouteNodesType) right);
            {
                Boolean nodeMemberShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetNodeMember(), rightObject.isSetNodeMember());
                if (nodeMemberShouldBeMergedAndSet == Boolean.TRUE) {
                    List<RouteNodeMemberType> lhsNodeMember;
                    lhsNodeMember = (leftObject.isSetNodeMember()?leftObject.getNodeMember():null);
                    List<RouteNodeMemberType> rhsNodeMember;
                    rhsNodeMember = (rightObject.isSetNodeMember()?rightObject.getNodeMember():null);
                    List<RouteNodeMemberType> mergedNodeMember = ((List<RouteNodeMemberType> ) strategy.merge(LocatorUtils.property(leftLocator, "nodeMember", lhsNodeMember), LocatorUtils.property(rightLocator, "nodeMember", rhsNodeMember), lhsNodeMember, rhsNodeMember, leftObject.isSetNodeMember(), rightObject.isSetNodeMember()));
                    target.unsetNodeMember();
                    if (mergedNodeMember!= null) {
                        List<RouteNodeMemberType> uniqueNodeMemberl = target.getNodeMember();
                        uniqueNodeMemberl.addAll(mergedNodeMember);
                    }
                } else {
                    if (nodeMemberShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetNodeMember();
                    }
                }
            }
            {
                Boolean aggregationTypeShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetAggregationType(), rightObject.isSetAggregationType());
                if (aggregationTypeShouldBeMergedAndSet == Boolean.TRUE) {
                    AggregationType lhsAggregationType;
                    lhsAggregationType = leftObject.getAggregationType();
                    AggregationType rhsAggregationType;
                    rhsAggregationType = rightObject.getAggregationType();
                    AggregationType mergedAggregationType = ((AggregationType) strategy.merge(LocatorUtils.property(leftLocator, "aggregationType", lhsAggregationType), LocatorUtils.property(rightLocator, "aggregationType", rhsAggregationType), lhsAggregationType, rhsAggregationType, leftObject.isSetAggregationType(), rightObject.isSetAggregationType()));
                    target.setAggregationType(mergedAggregationType);
                } else {
                    if (aggregationTypeShouldBeMergedAndSet == Boolean.FALSE) {
                        target.aggregationType = null;
                    }
                }
            }
        }
    }

    public void setNodeMember(List<RouteNodeMemberType> value) {
        this.nodeMember = null;
        if (value!= null) {
            List<RouteNodeMemberType> draftl = this.getNodeMember();
            draftl.addAll(value);
        }
    }

    public RouteNodesType withNodeMember(RouteNodeMemberType... values) {
        if (values!= null) {
            for (RouteNodeMemberType value: values) {
                getNodeMember().add(value);
            }
        }
        return this;
    }

    public RouteNodesType withNodeMember(Collection<RouteNodeMemberType> values) {
        if (values!= null) {
            getNodeMember().addAll(values);
        }
        return this;
    }

    public RouteNodesType withAggregationType(AggregationType value) {
        setAggregationType(value);
        return this;
    }

    public RouteNodesType withNodeMember(List<RouteNodeMemberType> value) {
        setNodeMember(value);
        return this;
    }

}
