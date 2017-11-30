//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2017.11.22 시간 01:17:09 AM KST 
//


package net.opengis.indoorgml.core.v_1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * <p>IndoorFeaturesType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="IndoorFeaturesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="primalSpaceFeatures" type="{http://www.opengis.net/indoorgml/1.0/core}PrimalSpaceFeaturesPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="multiLayeredGraph" type="{http://www.opengis.net/indoorgml/1.0/core}MultiLayeredGraphPropertyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndoorFeaturesType", propOrder = {
    "primalSpaceFeatures",
    "multiLayeredGraph"
})
public class IndoorFeaturesType
    extends AbstractFeatureType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    protected PrimalSpaceFeaturesPropertyType primalSpaceFeatures;
    protected MultiLayeredGraphPropertyType multiLayeredGraph;

    /**
     * primalSpaceFeatures 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PrimalSpaceFeaturesPropertyType }
     *     
     */
    public PrimalSpaceFeaturesPropertyType getPrimalSpaceFeatures() {
        return primalSpaceFeatures;
    }

    /**
     * primalSpaceFeatures 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimalSpaceFeaturesPropertyType }
     *     
     */
    public void setPrimalSpaceFeatures(PrimalSpaceFeaturesPropertyType value) {
        this.primalSpaceFeatures = value;
    }

    public boolean isSetPrimalSpaceFeatures() {
        return (this.primalSpaceFeatures!= null);
    }

    /**
     * multiLayeredGraph 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link MultiLayeredGraphPropertyType }
     *     
     */
    public MultiLayeredGraphPropertyType getMultiLayeredGraph() {
        return multiLayeredGraph;
    }

    /**
     * multiLayeredGraph 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiLayeredGraphPropertyType }
     *     
     */
    public void setMultiLayeredGraph(MultiLayeredGraphPropertyType value) {
        this.multiLayeredGraph = value;
    }

    public boolean isSetMultiLayeredGraph() {
        return (this.multiLayeredGraph!= null);
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
            PrimalSpaceFeaturesPropertyType thePrimalSpaceFeatures;
            thePrimalSpaceFeatures = this.getPrimalSpaceFeatures();
            strategy.appendField(locator, this, "primalSpaceFeatures", buffer, thePrimalSpaceFeatures, this.isSetPrimalSpaceFeatures());
        }
        {
            MultiLayeredGraphPropertyType theMultiLayeredGraph;
            theMultiLayeredGraph = this.getMultiLayeredGraph();
            strategy.appendField(locator, this, "multiLayeredGraph", buffer, theMultiLayeredGraph, this.isSetMultiLayeredGraph());
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
        final IndoorFeaturesType that = ((IndoorFeaturesType) object);
        {
            PrimalSpaceFeaturesPropertyType lhsPrimalSpaceFeatures;
            lhsPrimalSpaceFeatures = this.getPrimalSpaceFeatures();
            PrimalSpaceFeaturesPropertyType rhsPrimalSpaceFeatures;
            rhsPrimalSpaceFeatures = that.getPrimalSpaceFeatures();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "primalSpaceFeatures", lhsPrimalSpaceFeatures), LocatorUtils.property(thatLocator, "primalSpaceFeatures", rhsPrimalSpaceFeatures), lhsPrimalSpaceFeatures, rhsPrimalSpaceFeatures, this.isSetPrimalSpaceFeatures(), that.isSetPrimalSpaceFeatures())) {
                return false;
            }
        }
        {
            MultiLayeredGraphPropertyType lhsMultiLayeredGraph;
            lhsMultiLayeredGraph = this.getMultiLayeredGraph();
            MultiLayeredGraphPropertyType rhsMultiLayeredGraph;
            rhsMultiLayeredGraph = that.getMultiLayeredGraph();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "multiLayeredGraph", lhsMultiLayeredGraph), LocatorUtils.property(thatLocator, "multiLayeredGraph", rhsMultiLayeredGraph), lhsMultiLayeredGraph, rhsMultiLayeredGraph, this.isSetMultiLayeredGraph(), that.isSetMultiLayeredGraph())) {
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
            PrimalSpaceFeaturesPropertyType thePrimalSpaceFeatures;
            thePrimalSpaceFeatures = this.getPrimalSpaceFeatures();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "primalSpaceFeatures", thePrimalSpaceFeatures), currentHashCode, thePrimalSpaceFeatures, this.isSetPrimalSpaceFeatures());
        }
        {
            MultiLayeredGraphPropertyType theMultiLayeredGraph;
            theMultiLayeredGraph = this.getMultiLayeredGraph();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "multiLayeredGraph", theMultiLayeredGraph), currentHashCode, theMultiLayeredGraph, this.isSetMultiLayeredGraph());
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
        if (draftCopy instanceof IndoorFeaturesType) {
            final IndoorFeaturesType copy = ((IndoorFeaturesType) draftCopy);
            {
                Boolean primalSpaceFeaturesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetPrimalSpaceFeatures());
                if (primalSpaceFeaturesShouldBeCopiedAndSet == Boolean.TRUE) {
                    PrimalSpaceFeaturesPropertyType sourcePrimalSpaceFeatures;
                    sourcePrimalSpaceFeatures = this.getPrimalSpaceFeatures();
                    PrimalSpaceFeaturesPropertyType copyPrimalSpaceFeatures = ((PrimalSpaceFeaturesPropertyType) strategy.copy(LocatorUtils.property(locator, "primalSpaceFeatures", sourcePrimalSpaceFeatures), sourcePrimalSpaceFeatures, this.isSetPrimalSpaceFeatures()));
                    copy.setPrimalSpaceFeatures(copyPrimalSpaceFeatures);
                } else {
                    if (primalSpaceFeaturesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.primalSpaceFeatures = null;
                    }
                }
            }
            {
                Boolean multiLayeredGraphShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetMultiLayeredGraph());
                if (multiLayeredGraphShouldBeCopiedAndSet == Boolean.TRUE) {
                    MultiLayeredGraphPropertyType sourceMultiLayeredGraph;
                    sourceMultiLayeredGraph = this.getMultiLayeredGraph();
                    MultiLayeredGraphPropertyType copyMultiLayeredGraph = ((MultiLayeredGraphPropertyType) strategy.copy(LocatorUtils.property(locator, "multiLayeredGraph", sourceMultiLayeredGraph), sourceMultiLayeredGraph, this.isSetMultiLayeredGraph()));
                    copy.setMultiLayeredGraph(copyMultiLayeredGraph);
                } else {
                    if (multiLayeredGraphShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.multiLayeredGraph = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IndoorFeaturesType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof IndoorFeaturesType) {
            final IndoorFeaturesType target = this;
            final IndoorFeaturesType leftObject = ((IndoorFeaturesType) left);
            final IndoorFeaturesType rightObject = ((IndoorFeaturesType) right);
            {
                Boolean primalSpaceFeaturesShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetPrimalSpaceFeatures(), rightObject.isSetPrimalSpaceFeatures());
                if (primalSpaceFeaturesShouldBeMergedAndSet == Boolean.TRUE) {
                    PrimalSpaceFeaturesPropertyType lhsPrimalSpaceFeatures;
                    lhsPrimalSpaceFeatures = leftObject.getPrimalSpaceFeatures();
                    PrimalSpaceFeaturesPropertyType rhsPrimalSpaceFeatures;
                    rhsPrimalSpaceFeatures = rightObject.getPrimalSpaceFeatures();
                    PrimalSpaceFeaturesPropertyType mergedPrimalSpaceFeatures = ((PrimalSpaceFeaturesPropertyType) strategy.merge(LocatorUtils.property(leftLocator, "primalSpaceFeatures", lhsPrimalSpaceFeatures), LocatorUtils.property(rightLocator, "primalSpaceFeatures", rhsPrimalSpaceFeatures), lhsPrimalSpaceFeatures, rhsPrimalSpaceFeatures, leftObject.isSetPrimalSpaceFeatures(), rightObject.isSetPrimalSpaceFeatures()));
                    target.setPrimalSpaceFeatures(mergedPrimalSpaceFeatures);
                } else {
                    if (primalSpaceFeaturesShouldBeMergedAndSet == Boolean.FALSE) {
                        target.primalSpaceFeatures = null;
                    }
                }
            }
            {
                Boolean multiLayeredGraphShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetMultiLayeredGraph(), rightObject.isSetMultiLayeredGraph());
                if (multiLayeredGraphShouldBeMergedAndSet == Boolean.TRUE) {
                    MultiLayeredGraphPropertyType lhsMultiLayeredGraph;
                    lhsMultiLayeredGraph = leftObject.getMultiLayeredGraph();
                    MultiLayeredGraphPropertyType rhsMultiLayeredGraph;
                    rhsMultiLayeredGraph = rightObject.getMultiLayeredGraph();
                    MultiLayeredGraphPropertyType mergedMultiLayeredGraph = ((MultiLayeredGraphPropertyType) strategy.merge(LocatorUtils.property(leftLocator, "multiLayeredGraph", lhsMultiLayeredGraph), LocatorUtils.property(rightLocator, "multiLayeredGraph", rhsMultiLayeredGraph), lhsMultiLayeredGraph, rhsMultiLayeredGraph, leftObject.isSetMultiLayeredGraph(), rightObject.isSetMultiLayeredGraph()));
                    target.setMultiLayeredGraph(mergedMultiLayeredGraph);
                } else {
                    if (multiLayeredGraphShouldBeMergedAndSet == Boolean.FALSE) {
                        target.multiLayeredGraph = null;
                    }
                }
            }
        }
    }

    public IndoorFeaturesType withPrimalSpaceFeatures(PrimalSpaceFeaturesPropertyType value) {
        setPrimalSpaceFeatures(value);
        return this;
    }

    public IndoorFeaturesType withMultiLayeredGraph(MultiLayeredGraphPropertyType value) {
        setMultiLayeredGraph(value);
        return this;
    }

}
