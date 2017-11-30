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
 * <p>InterEdgesType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="InterEdgesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="interLayerConnectionMember" type="{http://www.opengis.net/indoorgml/1.0/core}InterLayerConnectionMemberType" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "InterEdgesType", propOrder = {
    "interLayerConnectionMember"
})
public class InterEdgesType
    extends AbstractFeatureType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    @XmlElement(required = true)
    protected List<InterLayerConnectionMemberType> interLayerConnectionMember;
    @XmlAttribute(name = "aggregationType")
    protected AggregationType aggregationType;

    /**
     * Gets the value of the interLayerConnectionMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interLayerConnectionMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterLayerConnectionMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InterLayerConnectionMemberType }
     * 
     * 
     */
    public List<InterLayerConnectionMemberType> getInterLayerConnectionMember() {
        if (interLayerConnectionMember == null) {
            interLayerConnectionMember = new ArrayList<InterLayerConnectionMemberType>();
        }
        return this.interLayerConnectionMember;
    }

    public boolean isSetInterLayerConnectionMember() {
        return ((this.interLayerConnectionMember!= null)&&(!this.interLayerConnectionMember.isEmpty()));
    }

    public void unsetInterLayerConnectionMember() {
        this.interLayerConnectionMember = null;
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
            List<InterLayerConnectionMemberType> theInterLayerConnectionMember;
            theInterLayerConnectionMember = (this.isSetInterLayerConnectionMember()?this.getInterLayerConnectionMember():null);
            strategy.appendField(locator, this, "interLayerConnectionMember", buffer, theInterLayerConnectionMember, this.isSetInterLayerConnectionMember());
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
        final InterEdgesType that = ((InterEdgesType) object);
        {
            List<InterLayerConnectionMemberType> lhsInterLayerConnectionMember;
            lhsInterLayerConnectionMember = (this.isSetInterLayerConnectionMember()?this.getInterLayerConnectionMember():null);
            List<InterLayerConnectionMemberType> rhsInterLayerConnectionMember;
            rhsInterLayerConnectionMember = (that.isSetInterLayerConnectionMember()?that.getInterLayerConnectionMember():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "interLayerConnectionMember", lhsInterLayerConnectionMember), LocatorUtils.property(thatLocator, "interLayerConnectionMember", rhsInterLayerConnectionMember), lhsInterLayerConnectionMember, rhsInterLayerConnectionMember, this.isSetInterLayerConnectionMember(), that.isSetInterLayerConnectionMember())) {
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
            List<InterLayerConnectionMemberType> theInterLayerConnectionMember;
            theInterLayerConnectionMember = (this.isSetInterLayerConnectionMember()?this.getInterLayerConnectionMember():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "interLayerConnectionMember", theInterLayerConnectionMember), currentHashCode, theInterLayerConnectionMember, this.isSetInterLayerConnectionMember());
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
        if (draftCopy instanceof InterEdgesType) {
            final InterEdgesType copy = ((InterEdgesType) draftCopy);
            {
                Boolean interLayerConnectionMemberShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetInterLayerConnectionMember());
                if (interLayerConnectionMemberShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<InterLayerConnectionMemberType> sourceInterLayerConnectionMember;
                    sourceInterLayerConnectionMember = (this.isSetInterLayerConnectionMember()?this.getInterLayerConnectionMember():null);
                    @SuppressWarnings("unchecked")
                    List<InterLayerConnectionMemberType> copyInterLayerConnectionMember = ((List<InterLayerConnectionMemberType> ) strategy.copy(LocatorUtils.property(locator, "interLayerConnectionMember", sourceInterLayerConnectionMember), sourceInterLayerConnectionMember, this.isSetInterLayerConnectionMember()));
                    copy.unsetInterLayerConnectionMember();
                    if (copyInterLayerConnectionMember!= null) {
                        List<InterLayerConnectionMemberType> uniqueInterLayerConnectionMemberl = copy.getInterLayerConnectionMember();
                        uniqueInterLayerConnectionMemberl.addAll(copyInterLayerConnectionMember);
                    }
                } else {
                    if (interLayerConnectionMemberShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetInterLayerConnectionMember();
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
        return new InterEdgesType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof InterEdgesType) {
            final InterEdgesType target = this;
            final InterEdgesType leftObject = ((InterEdgesType) left);
            final InterEdgesType rightObject = ((InterEdgesType) right);
            {
                Boolean interLayerConnectionMemberShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetInterLayerConnectionMember(), rightObject.isSetInterLayerConnectionMember());
                if (interLayerConnectionMemberShouldBeMergedAndSet == Boolean.TRUE) {
                    List<InterLayerConnectionMemberType> lhsInterLayerConnectionMember;
                    lhsInterLayerConnectionMember = (leftObject.isSetInterLayerConnectionMember()?leftObject.getInterLayerConnectionMember():null);
                    List<InterLayerConnectionMemberType> rhsInterLayerConnectionMember;
                    rhsInterLayerConnectionMember = (rightObject.isSetInterLayerConnectionMember()?rightObject.getInterLayerConnectionMember():null);
                    List<InterLayerConnectionMemberType> mergedInterLayerConnectionMember = ((List<InterLayerConnectionMemberType> ) strategy.merge(LocatorUtils.property(leftLocator, "interLayerConnectionMember", lhsInterLayerConnectionMember), LocatorUtils.property(rightLocator, "interLayerConnectionMember", rhsInterLayerConnectionMember), lhsInterLayerConnectionMember, rhsInterLayerConnectionMember, leftObject.isSetInterLayerConnectionMember(), rightObject.isSetInterLayerConnectionMember()));
                    target.unsetInterLayerConnectionMember();
                    if (mergedInterLayerConnectionMember!= null) {
                        List<InterLayerConnectionMemberType> uniqueInterLayerConnectionMemberl = target.getInterLayerConnectionMember();
                        uniqueInterLayerConnectionMemberl.addAll(mergedInterLayerConnectionMember);
                    }
                } else {
                    if (interLayerConnectionMemberShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetInterLayerConnectionMember();
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

    public void setInterLayerConnectionMember(List<InterLayerConnectionMemberType> value) {
        this.interLayerConnectionMember = null;
        if (value!= null) {
            List<InterLayerConnectionMemberType> draftl = this.getInterLayerConnectionMember();
            draftl.addAll(value);
        }
    }

    public InterEdgesType withInterLayerConnectionMember(InterLayerConnectionMemberType... values) {
        if (values!= null) {
            for (InterLayerConnectionMemberType value: values) {
                getInterLayerConnectionMember().add(value);
            }
        }
        return this;
    }

    public InterEdgesType withInterLayerConnectionMember(Collection<InterLayerConnectionMemberType> values) {
        if (values!= null) {
            getInterLayerConnectionMember().addAll(values);
        }
        return this;
    }

    public InterEdgesType withAggregationType(AggregationType value) {
        setAggregationType(value);
        return this;
    }

    public InterEdgesType withInterLayerConnectionMember(List<InterLayerConnectionMemberType> value) {
        setInterLayerConnectionMember(value);
        return this;
    }

}
