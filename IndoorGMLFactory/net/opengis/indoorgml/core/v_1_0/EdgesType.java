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
 * <p>EdgesType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="EdgesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="transitionMember" type="{http://www.opengis.net/indoorgml/1.0/core}TransitionMemberType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{http://www.opengis.net/gml/3.2}AggregationAttributeGroup"/&gt;
 *       &lt;attGroup ref="{http://www.opengis.net/gml/3.2}OwnershipAttributeGroup"/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EdgesType", propOrder = {
    "transitionMember"
})
public class EdgesType
    extends AbstractFeatureType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    protected List<TransitionMemberType> transitionMember;
    @XmlAttribute(name = "aggregationType")
    protected AggregationType aggregationType;
    @XmlAttribute(name = "owns")
    protected Boolean owns;

    /**
     * Gets the value of the transitionMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transitionMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransitionMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransitionMemberType }
     * 
     * 
     */
    public List<TransitionMemberType> getTransitionMember() {
        if (transitionMember == null) {
            transitionMember = new ArrayList<TransitionMemberType>();
        }
        return this.transitionMember;
    }

    public boolean isSetTransitionMember() {
        return ((this.transitionMember!= null)&&(!this.transitionMember.isEmpty()));
    }

    public void unsetTransitionMember() {
        this.transitionMember = null;
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

    /**
     * owns 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isOwns() {
        if (owns == null) {
            return false;
        } else {
            return owns;
        }
    }

    /**
     * owns 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOwns(boolean value) {
        this.owns = value;
    }

    public boolean isSetOwns() {
        return (this.owns!= null);
    }

    public void unsetOwns() {
        this.owns = null;
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
            List<TransitionMemberType> theTransitionMember;
            theTransitionMember = (this.isSetTransitionMember()?this.getTransitionMember():null);
            strategy.appendField(locator, this, "transitionMember", buffer, theTransitionMember, this.isSetTransitionMember());
        }
        {
            AggregationType theAggregationType;
            theAggregationType = this.getAggregationType();
            strategy.appendField(locator, this, "aggregationType", buffer, theAggregationType, this.isSetAggregationType());
        }
        {
            boolean theOwns;
            theOwns = (this.isSetOwns()?this.isOwns():false);
            strategy.appendField(locator, this, "owns", buffer, theOwns, this.isSetOwns());
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
        final EdgesType that = ((EdgesType) object);
        {
            List<TransitionMemberType> lhsTransitionMember;
            lhsTransitionMember = (this.isSetTransitionMember()?this.getTransitionMember():null);
            List<TransitionMemberType> rhsTransitionMember;
            rhsTransitionMember = (that.isSetTransitionMember()?that.getTransitionMember():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transitionMember", lhsTransitionMember), LocatorUtils.property(thatLocator, "transitionMember", rhsTransitionMember), lhsTransitionMember, rhsTransitionMember, this.isSetTransitionMember(), that.isSetTransitionMember())) {
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
        {
            boolean lhsOwns;
            lhsOwns = (this.isSetOwns()?this.isOwns():false);
            boolean rhsOwns;
            rhsOwns = (that.isSetOwns()?that.isOwns():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "owns", lhsOwns), LocatorUtils.property(thatLocator, "owns", rhsOwns), lhsOwns, rhsOwns, this.isSetOwns(), that.isSetOwns())) {
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
            List<TransitionMemberType> theTransitionMember;
            theTransitionMember = (this.isSetTransitionMember()?this.getTransitionMember():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transitionMember", theTransitionMember), currentHashCode, theTransitionMember, this.isSetTransitionMember());
        }
        {
            AggregationType theAggregationType;
            theAggregationType = this.getAggregationType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aggregationType", theAggregationType), currentHashCode, theAggregationType, this.isSetAggregationType());
        }
        {
            boolean theOwns;
            theOwns = (this.isSetOwns()?this.isOwns():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "owns", theOwns), currentHashCode, theOwns, this.isSetOwns());
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
        if (draftCopy instanceof EdgesType) {
            final EdgesType copy = ((EdgesType) draftCopy);
            {
                Boolean transitionMemberShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetTransitionMember());
                if (transitionMemberShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<TransitionMemberType> sourceTransitionMember;
                    sourceTransitionMember = (this.isSetTransitionMember()?this.getTransitionMember():null);
                    @SuppressWarnings("unchecked")
                    List<TransitionMemberType> copyTransitionMember = ((List<TransitionMemberType> ) strategy.copy(LocatorUtils.property(locator, "transitionMember", sourceTransitionMember), sourceTransitionMember, this.isSetTransitionMember()));
                    copy.unsetTransitionMember();
                    if (copyTransitionMember!= null) {
                        List<TransitionMemberType> uniqueTransitionMemberl = copy.getTransitionMember();
                        uniqueTransitionMemberl.addAll(copyTransitionMember);
                    }
                } else {
                    if (transitionMemberShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetTransitionMember();
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
            {
                Boolean ownsShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetOwns());
                if (ownsShouldBeCopiedAndSet == Boolean.TRUE) {
                    boolean sourceOwns;
                    sourceOwns = (this.isSetOwns()?this.isOwns():false);
                    boolean copyOwns = strategy.copy(LocatorUtils.property(locator, "owns", sourceOwns), sourceOwns, this.isSetOwns());
                    copy.setOwns(copyOwns);
                } else {
                    if (ownsShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetOwns();
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new EdgesType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof EdgesType) {
            final EdgesType target = this;
            final EdgesType leftObject = ((EdgesType) left);
            final EdgesType rightObject = ((EdgesType) right);
            {
                Boolean transitionMemberShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetTransitionMember(), rightObject.isSetTransitionMember());
                if (transitionMemberShouldBeMergedAndSet == Boolean.TRUE) {
                    List<TransitionMemberType> lhsTransitionMember;
                    lhsTransitionMember = (leftObject.isSetTransitionMember()?leftObject.getTransitionMember():null);
                    List<TransitionMemberType> rhsTransitionMember;
                    rhsTransitionMember = (rightObject.isSetTransitionMember()?rightObject.getTransitionMember():null);
                    List<TransitionMemberType> mergedTransitionMember = ((List<TransitionMemberType> ) strategy.merge(LocatorUtils.property(leftLocator, "transitionMember", lhsTransitionMember), LocatorUtils.property(rightLocator, "transitionMember", rhsTransitionMember), lhsTransitionMember, rhsTransitionMember, leftObject.isSetTransitionMember(), rightObject.isSetTransitionMember()));
                    target.unsetTransitionMember();
                    if (mergedTransitionMember!= null) {
                        List<TransitionMemberType> uniqueTransitionMemberl = target.getTransitionMember();
                        uniqueTransitionMemberl.addAll(mergedTransitionMember);
                    }
                } else {
                    if (transitionMemberShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetTransitionMember();
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
            {
                Boolean ownsShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetOwns(), rightObject.isSetOwns());
                if (ownsShouldBeMergedAndSet == Boolean.TRUE) {
                    boolean lhsOwns;
                    lhsOwns = (leftObject.isSetOwns()?leftObject.isOwns():false);
                    boolean rhsOwns;
                    rhsOwns = (rightObject.isSetOwns()?rightObject.isOwns():false);
                    boolean mergedOwns = ((boolean) strategy.merge(LocatorUtils.property(leftLocator, "owns", lhsOwns), LocatorUtils.property(rightLocator, "owns", rhsOwns), lhsOwns, rhsOwns, leftObject.isSetOwns(), rightObject.isSetOwns()));
                    target.setOwns(mergedOwns);
                } else {
                    if (ownsShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetOwns();
                    }
                }
            }
        }
    }

    public void setTransitionMember(List<TransitionMemberType> value) {
        this.transitionMember = null;
        if (value!= null) {
            List<TransitionMemberType> draftl = this.getTransitionMember();
            draftl.addAll(value);
        }
    }

    public EdgesType withTransitionMember(TransitionMemberType... values) {
        if (values!= null) {
            for (TransitionMemberType value: values) {
                getTransitionMember().add(value);
            }
        }
        return this;
    }

    public EdgesType withTransitionMember(Collection<TransitionMemberType> values) {
        if (values!= null) {
            getTransitionMember().addAll(values);
        }
        return this;
    }

    public EdgesType withAggregationType(AggregationType value) {
        setAggregationType(value);
        return this;
    }

    public EdgesType withOwns(boolean value) {
        setOwns(value);
        return this;
    }

    public EdgesType withTransitionMember(List<TransitionMemberType> value) {
        setTransitionMember(value);
        return this;
    }

}
