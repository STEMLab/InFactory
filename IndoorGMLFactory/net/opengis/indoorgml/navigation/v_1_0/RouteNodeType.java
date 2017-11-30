//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2017.11.22 시간 01:17:09 AM KST 
//


package net.opengis.indoorgml.navigation.v_1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.v_3_2_1.AbstractFeatureType;
import net.opengis.gml.v_3_2_1.PointPropertyType;
import net.opengis.indoorgml.core.v_1_0.StatePropertyType;
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
 * <p>RouteNodeType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="RouteNodeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="referencedState" type="{http://www.opengis.net/indoorgml/1.0/core}StatePropertyType"/&gt;
 *         &lt;element name="geometry" type="{http://www.opengis.net/gml/3.2}PointPropertyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteNodeType", propOrder = {
    "referencedState",
    "geometry"
})
public class RouteNodeType
    extends AbstractFeatureType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    @XmlElement(required = true)
    protected StatePropertyType referencedState;
    @XmlElement(required = true)
    protected PointPropertyType geometry;

    /**
     * referencedState 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StatePropertyType }
     *     
     */
    public StatePropertyType getReferencedState() {
        return referencedState;
    }

    /**
     * referencedState 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StatePropertyType }
     *     
     */
    public void setReferencedState(StatePropertyType value) {
        this.referencedState = value;
    }

    public boolean isSetReferencedState() {
        return (this.referencedState!= null);
    }

    /**
     * geometry 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PointPropertyType }
     *     
     */
    public PointPropertyType getGeometry() {
        return geometry;
    }

    /**
     * geometry 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PointPropertyType }
     *     
     */
    public void setGeometry(PointPropertyType value) {
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
            StatePropertyType theReferencedState;
            theReferencedState = this.getReferencedState();
            strategy.appendField(locator, this, "referencedState", buffer, theReferencedState, this.isSetReferencedState());
        }
        {
            PointPropertyType theGeometry;
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
        final RouteNodeType that = ((RouteNodeType) object);
        {
            StatePropertyType lhsReferencedState;
            lhsReferencedState = this.getReferencedState();
            StatePropertyType rhsReferencedState;
            rhsReferencedState = that.getReferencedState();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "referencedState", lhsReferencedState), LocatorUtils.property(thatLocator, "referencedState", rhsReferencedState), lhsReferencedState, rhsReferencedState, this.isSetReferencedState(), that.isSetReferencedState())) {
                return false;
            }
        }
        {
            PointPropertyType lhsGeometry;
            lhsGeometry = this.getGeometry();
            PointPropertyType rhsGeometry;
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
            StatePropertyType theReferencedState;
            theReferencedState = this.getReferencedState();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "referencedState", theReferencedState), currentHashCode, theReferencedState, this.isSetReferencedState());
        }
        {
            PointPropertyType theGeometry;
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
        if (draftCopy instanceof RouteNodeType) {
            final RouteNodeType copy = ((RouteNodeType) draftCopy);
            {
                Boolean referencedStateShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetReferencedState());
                if (referencedStateShouldBeCopiedAndSet == Boolean.TRUE) {
                    StatePropertyType sourceReferencedState;
                    sourceReferencedState = this.getReferencedState();
                    StatePropertyType copyReferencedState = ((StatePropertyType) strategy.copy(LocatorUtils.property(locator, "referencedState", sourceReferencedState), sourceReferencedState, this.isSetReferencedState()));
                    copy.setReferencedState(copyReferencedState);
                } else {
                    if (referencedStateShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.referencedState = null;
                    }
                }
            }
            {
                Boolean geometryShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetGeometry());
                if (geometryShouldBeCopiedAndSet == Boolean.TRUE) {
                    PointPropertyType sourceGeometry;
                    sourceGeometry = this.getGeometry();
                    PointPropertyType copyGeometry = ((PointPropertyType) strategy.copy(LocatorUtils.property(locator, "geometry", sourceGeometry), sourceGeometry, this.isSetGeometry()));
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
        return new RouteNodeType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof RouteNodeType) {
            final RouteNodeType target = this;
            final RouteNodeType leftObject = ((RouteNodeType) left);
            final RouteNodeType rightObject = ((RouteNodeType) right);
            {
                Boolean referencedStateShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetReferencedState(), rightObject.isSetReferencedState());
                if (referencedStateShouldBeMergedAndSet == Boolean.TRUE) {
                    StatePropertyType lhsReferencedState;
                    lhsReferencedState = leftObject.getReferencedState();
                    StatePropertyType rhsReferencedState;
                    rhsReferencedState = rightObject.getReferencedState();
                    StatePropertyType mergedReferencedState = ((StatePropertyType) strategy.merge(LocatorUtils.property(leftLocator, "referencedState", lhsReferencedState), LocatorUtils.property(rightLocator, "referencedState", rhsReferencedState), lhsReferencedState, rhsReferencedState, leftObject.isSetReferencedState(), rightObject.isSetReferencedState()));
                    target.setReferencedState(mergedReferencedState);
                } else {
                    if (referencedStateShouldBeMergedAndSet == Boolean.FALSE) {
                        target.referencedState = null;
                    }
                }
            }
            {
                Boolean geometryShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetGeometry(), rightObject.isSetGeometry());
                if (geometryShouldBeMergedAndSet == Boolean.TRUE) {
                    PointPropertyType lhsGeometry;
                    lhsGeometry = leftObject.getGeometry();
                    PointPropertyType rhsGeometry;
                    rhsGeometry = rightObject.getGeometry();
                    PointPropertyType mergedGeometry = ((PointPropertyType) strategy.merge(LocatorUtils.property(leftLocator, "geometry", lhsGeometry), LocatorUtils.property(rightLocator, "geometry", rhsGeometry), lhsGeometry, rhsGeometry, leftObject.isSetGeometry(), rightObject.isSetGeometry()));
                    target.setGeometry(mergedGeometry);
                } else {
                    if (geometryShouldBeMergedAndSet == Boolean.FALSE) {
                        target.geometry = null;
                    }
                }
            }
        }
    }

    public RouteNodeType withReferencedState(StatePropertyType value) {
        setReferencedState(value);
        return this;
    }

    public RouteNodeType withGeometry(PointPropertyType value) {
        setGeometry(value);
        return this;
    }

}
