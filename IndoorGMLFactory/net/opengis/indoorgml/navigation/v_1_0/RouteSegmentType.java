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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.v_3_2_1.AbstractFeatureType;
import net.opengis.gml.v_3_2_1.CurvePropertyType;
import net.opengis.indoorgml.core.v_1_0.TransitionPropertyType;
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
 * <p>RouteSegmentType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="RouteSegmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="connects" type="{http://www.opengis.net/indoorgml/1.0/navigation}RouteNodePropertyType" maxOccurs="2" minOccurs="2"/&gt;
 *         &lt;element name="referencedTransition" type="{http://www.opengis.net/indoorgml/1.0/core}TransitionPropertyType"/&gt;
 *         &lt;element name="geometry" type="{http://www.opengis.net/gml/3.2}CurvePropertyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteSegmentType", propOrder = {
    "weight",
    "connects",
    "referencedTransition",
    "geometry"
})
public class RouteSegmentType
    extends AbstractFeatureType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    protected double weight;
    @XmlElement(required = true)
    protected List<RouteNodePropertyType> connects;
    @XmlElement(required = true)
    protected TransitionPropertyType referencedTransition;
    @XmlElement(required = true)
    protected CurvePropertyType geometry;

    /**
     * weight 속성의 값을 가져옵니다.
     * 
     */
    public double getWeight() {
        return weight;
    }

    /**
     * weight 속성의 값을 설정합니다.
     * 
     */
    public void setWeight(double value) {
        this.weight = value;
    }

    public boolean isSetWeight() {
        return true;
    }

    /**
     * Gets the value of the connects property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connects property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConnects().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RouteNodePropertyType }
     * 
     * 
     */
    public List<RouteNodePropertyType> getConnects() {
        if (connects == null) {
            connects = new ArrayList<RouteNodePropertyType>();
        }
        return this.connects;
    }

    public boolean isSetConnects() {
        return ((this.connects!= null)&&(!this.connects.isEmpty()));
    }

    public void unsetConnects() {
        this.connects = null;
    }

    /**
     * referencedTransition 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TransitionPropertyType }
     *     
     */
    public TransitionPropertyType getReferencedTransition() {
        return referencedTransition;
    }

    /**
     * referencedTransition 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TransitionPropertyType }
     *     
     */
    public void setReferencedTransition(TransitionPropertyType value) {
        this.referencedTransition = value;
    }

    public boolean isSetReferencedTransition() {
        return (this.referencedTransition!= null);
    }

    /**
     * geometry 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CurvePropertyType }
     *     
     */
    public CurvePropertyType getGeometry() {
        return geometry;
    }

    /**
     * geometry 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CurvePropertyType }
     *     
     */
    public void setGeometry(CurvePropertyType value) {
        this.geometry = value;
    }

    public boolean isSetGeometry() {
        return (this.geometry!= null);
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
            double theWeight;
            theWeight = this.getWeight();
            strategy.appendField(locator, this, "weight", buffer, theWeight, true);
        }
        {
            List<RouteNodePropertyType> theConnects;
            theConnects = (this.isSetConnects()?this.getConnects():null);
            strategy.appendField(locator, this, "connects", buffer, theConnects, this.isSetConnects());
        }
        {
            TransitionPropertyType theReferencedTransition;
            theReferencedTransition = this.getReferencedTransition();
            strategy.appendField(locator, this, "referencedTransition", buffer, theReferencedTransition, this.isSetReferencedTransition());
        }
        {
            CurvePropertyType theGeometry;
            theGeometry = this.getGeometry();
            strategy.appendField(locator, this, "geometry", buffer, theGeometry, this.isSetGeometry());
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
        final RouteSegmentType that = ((RouteSegmentType) object);
        {
            double lhsWeight;
            lhsWeight = this.getWeight();
            double rhsWeight;
            rhsWeight = that.getWeight();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "weight", lhsWeight), LocatorUtils.property(thatLocator, "weight", rhsWeight), lhsWeight, rhsWeight, true, true)) {
                return false;
            }
        }
        {
            List<RouteNodePropertyType> lhsConnects;
            lhsConnects = (this.isSetConnects()?this.getConnects():null);
            List<RouteNodePropertyType> rhsConnects;
            rhsConnects = (that.isSetConnects()?that.getConnects():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "connects", lhsConnects), LocatorUtils.property(thatLocator, "connects", rhsConnects), lhsConnects, rhsConnects, this.isSetConnects(), that.isSetConnects())) {
                return false;
            }
        }
        {
            TransitionPropertyType lhsReferencedTransition;
            lhsReferencedTransition = this.getReferencedTransition();
            TransitionPropertyType rhsReferencedTransition;
            rhsReferencedTransition = that.getReferencedTransition();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "referencedTransition", lhsReferencedTransition), LocatorUtils.property(thatLocator, "referencedTransition", rhsReferencedTransition), lhsReferencedTransition, rhsReferencedTransition, this.isSetReferencedTransition(), that.isSetReferencedTransition())) {
                return false;
            }
        }
        {
            CurvePropertyType lhsGeometry;
            lhsGeometry = this.getGeometry();
            CurvePropertyType rhsGeometry;
            rhsGeometry = that.getGeometry();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "geometry", lhsGeometry), LocatorUtils.property(thatLocator, "geometry", rhsGeometry), lhsGeometry, rhsGeometry, this.isSetGeometry(), that.isSetGeometry())) {
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
            double theWeight;
            theWeight = this.getWeight();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "weight", theWeight), currentHashCode, theWeight, true);
        }
        {
            List<RouteNodePropertyType> theConnects;
            theConnects = (this.isSetConnects()?this.getConnects():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "connects", theConnects), currentHashCode, theConnects, this.isSetConnects());
        }
        {
            TransitionPropertyType theReferencedTransition;
            theReferencedTransition = this.getReferencedTransition();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "referencedTransition", theReferencedTransition), currentHashCode, theReferencedTransition, this.isSetReferencedTransition());
        }
        {
            CurvePropertyType theGeometry;
            theGeometry = this.getGeometry();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "geometry", theGeometry), currentHashCode, theGeometry, this.isSetGeometry());
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
        if (draftCopy instanceof RouteSegmentType) {
            final RouteSegmentType copy = ((RouteSegmentType) draftCopy);
            {
                Boolean weightShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, true);
                if (weightShouldBeCopiedAndSet == Boolean.TRUE) {
                    double sourceWeight;
                    sourceWeight = this.getWeight();
                    double copyWeight = strategy.copy(LocatorUtils.property(locator, "weight", sourceWeight), sourceWeight, true);
                    copy.setWeight(copyWeight);
                } else {
                    if (weightShouldBeCopiedAndSet == Boolean.FALSE) {
                    }
                }
            }
            {
                Boolean connectsShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetConnects());
                if (connectsShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<RouteNodePropertyType> sourceConnects;
                    sourceConnects = (this.isSetConnects()?this.getConnects():null);
                    @SuppressWarnings("unchecked")
                    List<RouteNodePropertyType> copyConnects = ((List<RouteNodePropertyType> ) strategy.copy(LocatorUtils.property(locator, "connects", sourceConnects), sourceConnects, this.isSetConnects()));
                    copy.unsetConnects();
                    if (copyConnects!= null) {
                        List<RouteNodePropertyType> uniqueConnectsl = copy.getConnects();
                        uniqueConnectsl.addAll(copyConnects);
                    }
                } else {
                    if (connectsShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetConnects();
                    }
                }
            }
            {
                Boolean referencedTransitionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetReferencedTransition());
                if (referencedTransitionShouldBeCopiedAndSet == Boolean.TRUE) {
                    TransitionPropertyType sourceReferencedTransition;
                    sourceReferencedTransition = this.getReferencedTransition();
                    TransitionPropertyType copyReferencedTransition = ((TransitionPropertyType) strategy.copy(LocatorUtils.property(locator, "referencedTransition", sourceReferencedTransition), sourceReferencedTransition, this.isSetReferencedTransition()));
                    copy.setReferencedTransition(copyReferencedTransition);
                } else {
                    if (referencedTransitionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.referencedTransition = null;
                    }
                }
            }
            {
                Boolean geometryShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetGeometry());
                if (geometryShouldBeCopiedAndSet == Boolean.TRUE) {
                    CurvePropertyType sourceGeometry;
                    sourceGeometry = this.getGeometry();
                    CurvePropertyType copyGeometry = ((CurvePropertyType) strategy.copy(LocatorUtils.property(locator, "geometry", sourceGeometry), sourceGeometry, this.isSetGeometry()));
                    copy.setGeometry(copyGeometry);
                } else {
                    if (geometryShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.geometry = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new RouteSegmentType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof RouteSegmentType) {
            final RouteSegmentType target = this;
            final RouteSegmentType leftObject = ((RouteSegmentType) left);
            final RouteSegmentType rightObject = ((RouteSegmentType) right);
            {
                Boolean weightShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, true, true);
                if (weightShouldBeMergedAndSet == Boolean.TRUE) {
                    double lhsWeight;
                    lhsWeight = leftObject.getWeight();
                    double rhsWeight;
                    rhsWeight = rightObject.getWeight();
                    double mergedWeight = ((double) strategy.merge(LocatorUtils.property(leftLocator, "weight", lhsWeight), LocatorUtils.property(rightLocator, "weight", rhsWeight), lhsWeight, rhsWeight, true, true));
                    target.setWeight(mergedWeight);
                } else {
                    if (weightShouldBeMergedAndSet == Boolean.FALSE) {
                    }
                }
            }
            {
                Boolean connectsShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetConnects(), rightObject.isSetConnects());
                if (connectsShouldBeMergedAndSet == Boolean.TRUE) {
                    List<RouteNodePropertyType> lhsConnects;
                    lhsConnects = (leftObject.isSetConnects()?leftObject.getConnects():null);
                    List<RouteNodePropertyType> rhsConnects;
                    rhsConnects = (rightObject.isSetConnects()?rightObject.getConnects():null);
                    List<RouteNodePropertyType> mergedConnects = ((List<RouteNodePropertyType> ) strategy.merge(LocatorUtils.property(leftLocator, "connects", lhsConnects), LocatorUtils.property(rightLocator, "connects", rhsConnects), lhsConnects, rhsConnects, leftObject.isSetConnects(), rightObject.isSetConnects()));
                    target.unsetConnects();
                    if (mergedConnects!= null) {
                        List<RouteNodePropertyType> uniqueConnectsl = target.getConnects();
                        uniqueConnectsl.addAll(mergedConnects);
                    }
                } else {
                    if (connectsShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetConnects();
                    }
                }
            }
            {
                Boolean referencedTransitionShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetReferencedTransition(), rightObject.isSetReferencedTransition());
                if (referencedTransitionShouldBeMergedAndSet == Boolean.TRUE) {
                    TransitionPropertyType lhsReferencedTransition;
                    lhsReferencedTransition = leftObject.getReferencedTransition();
                    TransitionPropertyType rhsReferencedTransition;
                    rhsReferencedTransition = rightObject.getReferencedTransition();
                    TransitionPropertyType mergedReferencedTransition = ((TransitionPropertyType) strategy.merge(LocatorUtils.property(leftLocator, "referencedTransition", lhsReferencedTransition), LocatorUtils.property(rightLocator, "referencedTransition", rhsReferencedTransition), lhsReferencedTransition, rhsReferencedTransition, leftObject.isSetReferencedTransition(), rightObject.isSetReferencedTransition()));
                    target.setReferencedTransition(mergedReferencedTransition);
                } else {
                    if (referencedTransitionShouldBeMergedAndSet == Boolean.FALSE) {
                        target.referencedTransition = null;
                    }
                }
            }
            {
                Boolean geometryShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetGeometry(), rightObject.isSetGeometry());
                if (geometryShouldBeMergedAndSet == Boolean.TRUE) {
                    CurvePropertyType lhsGeometry;
                    lhsGeometry = leftObject.getGeometry();
                    CurvePropertyType rhsGeometry;
                    rhsGeometry = rightObject.getGeometry();
                    CurvePropertyType mergedGeometry = ((CurvePropertyType) strategy.merge(LocatorUtils.property(leftLocator, "geometry", lhsGeometry), LocatorUtils.property(rightLocator, "geometry", rhsGeometry), lhsGeometry, rhsGeometry, leftObject.isSetGeometry(), rightObject.isSetGeometry()));
                    target.setGeometry(mergedGeometry);
                } else {
                    if (geometryShouldBeMergedAndSet == Boolean.FALSE) {
                        target.geometry = null;
                    }
                }
            }
        }
    }

    public void setConnects(List<RouteNodePropertyType> value) {
        this.connects = null;
        if (value!= null) {
            List<RouteNodePropertyType> draftl = this.getConnects();
            draftl.addAll(value);
        }
    }

    public RouteSegmentType withWeight(double value) {
        setWeight(value);
        return this;
    }

    public RouteSegmentType withConnects(RouteNodePropertyType... values) {
        if (values!= null) {
            for (RouteNodePropertyType value: values) {
                getConnects().add(value);
            }
        }
        return this;
    }

    public RouteSegmentType withConnects(Collection<RouteNodePropertyType> values) {
        if (values!= null) {
            getConnects().addAll(values);
        }
        return this;
    }

    public RouteSegmentType withReferencedTransition(TransitionPropertyType value) {
        setReferencedTransition(value);
        return this;
    }

    public RouteSegmentType withGeometry(CurvePropertyType value) {
        setGeometry(value);
        return this;
    }

    public RouteSegmentType withConnects(List<RouteNodePropertyType> value) {
        setConnects(value);
        return this;
    }

}
