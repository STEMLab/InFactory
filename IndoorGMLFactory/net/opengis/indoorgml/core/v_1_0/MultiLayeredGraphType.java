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
 * <p>MultiLayeredGraphType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="MultiLayeredGraphType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="spaceLayers" type="{http://www.opengis.net/indoorgml/1.0/core}SpaceLayersType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="interEdges" type="{http://www.opengis.net/indoorgml/1.0/core}InterEdgesType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiLayeredGraphType", propOrder = {
    "spaceLayers",
    "interEdges"
})
public class MultiLayeredGraphType
    extends AbstractFeatureType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    @XmlElement(required = true)
    protected List<SpaceLayersType> spaceLayers;
    protected List<InterEdgesType> interEdges;

    /**
     * Gets the value of the spaceLayers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spaceLayers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpaceLayers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpaceLayersType }
     * 
     * 
     */
    public List<SpaceLayersType> getSpaceLayers() {
        if (spaceLayers == null) {
            spaceLayers = new ArrayList<SpaceLayersType>();
        }
        return this.spaceLayers;
    }

    public boolean isSetSpaceLayers() {
        return ((this.spaceLayers!= null)&&(!this.spaceLayers.isEmpty()));
    }

    public void unsetSpaceLayers() {
        this.spaceLayers = null;
    }

    /**
     * Gets the value of the interEdges property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interEdges property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterEdges().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InterEdgesType }
     * 
     * 
     */
    public List<InterEdgesType> getInterEdges() {
        if (interEdges == null) {
            interEdges = new ArrayList<InterEdgesType>();
        }
        return this.interEdges;
    }

    public boolean isSetInterEdges() {
        return ((this.interEdges!= null)&&(!this.interEdges.isEmpty()));
    }

    public void unsetInterEdges() {
        this.interEdges = null;
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
            List<SpaceLayersType> theSpaceLayers;
            theSpaceLayers = (this.isSetSpaceLayers()?this.getSpaceLayers():null);
            strategy.appendField(locator, this, "spaceLayers", buffer, theSpaceLayers, this.isSetSpaceLayers());
        }
        {
            List<InterEdgesType> theInterEdges;
            theInterEdges = (this.isSetInterEdges()?this.getInterEdges():null);
            strategy.appendField(locator, this, "interEdges", buffer, theInterEdges, this.isSetInterEdges());
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
        final MultiLayeredGraphType that = ((MultiLayeredGraphType) object);
        {
            List<SpaceLayersType> lhsSpaceLayers;
            lhsSpaceLayers = (this.isSetSpaceLayers()?this.getSpaceLayers():null);
            List<SpaceLayersType> rhsSpaceLayers;
            rhsSpaceLayers = (that.isSetSpaceLayers()?that.getSpaceLayers():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "spaceLayers", lhsSpaceLayers), LocatorUtils.property(thatLocator, "spaceLayers", rhsSpaceLayers), lhsSpaceLayers, rhsSpaceLayers, this.isSetSpaceLayers(), that.isSetSpaceLayers())) {
                return false;
            }
        }
        {
            List<InterEdgesType> lhsInterEdges;
            lhsInterEdges = (this.isSetInterEdges()?this.getInterEdges():null);
            List<InterEdgesType> rhsInterEdges;
            rhsInterEdges = (that.isSetInterEdges()?that.getInterEdges():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "interEdges", lhsInterEdges), LocatorUtils.property(thatLocator, "interEdges", rhsInterEdges), lhsInterEdges, rhsInterEdges, this.isSetInterEdges(), that.isSetInterEdges())) {
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
            List<SpaceLayersType> theSpaceLayers;
            theSpaceLayers = (this.isSetSpaceLayers()?this.getSpaceLayers():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "spaceLayers", theSpaceLayers), currentHashCode, theSpaceLayers, this.isSetSpaceLayers());
        }
        {
            List<InterEdgesType> theInterEdges;
            theInterEdges = (this.isSetInterEdges()?this.getInterEdges():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "interEdges", theInterEdges), currentHashCode, theInterEdges, this.isSetInterEdges());
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
        if (draftCopy instanceof MultiLayeredGraphType) {
            final MultiLayeredGraphType copy = ((MultiLayeredGraphType) draftCopy);
            {
                Boolean spaceLayersShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetSpaceLayers());
                if (spaceLayersShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<SpaceLayersType> sourceSpaceLayers;
                    sourceSpaceLayers = (this.isSetSpaceLayers()?this.getSpaceLayers():null);
                    @SuppressWarnings("unchecked")
                    List<SpaceLayersType> copySpaceLayers = ((List<SpaceLayersType> ) strategy.copy(LocatorUtils.property(locator, "spaceLayers", sourceSpaceLayers), sourceSpaceLayers, this.isSetSpaceLayers()));
                    copy.unsetSpaceLayers();
                    if (copySpaceLayers!= null) {
                        List<SpaceLayersType> uniqueSpaceLayersl = copy.getSpaceLayers();
                        uniqueSpaceLayersl.addAll(copySpaceLayers);
                    }
                } else {
                    if (spaceLayersShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetSpaceLayers();
                    }
                }
            }
            {
                Boolean interEdgesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetInterEdges());
                if (interEdgesShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<InterEdgesType> sourceInterEdges;
                    sourceInterEdges = (this.isSetInterEdges()?this.getInterEdges():null);
                    @SuppressWarnings("unchecked")
                    List<InterEdgesType> copyInterEdges = ((List<InterEdgesType> ) strategy.copy(LocatorUtils.property(locator, "interEdges", sourceInterEdges), sourceInterEdges, this.isSetInterEdges()));
                    copy.unsetInterEdges();
                    if (copyInterEdges!= null) {
                        List<InterEdgesType> uniqueInterEdgesl = copy.getInterEdges();
                        uniqueInterEdgesl.addAll(copyInterEdges);
                    }
                } else {
                    if (interEdgesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetInterEdges();
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new MultiLayeredGraphType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof MultiLayeredGraphType) {
            final MultiLayeredGraphType target = this;
            final MultiLayeredGraphType leftObject = ((MultiLayeredGraphType) left);
            final MultiLayeredGraphType rightObject = ((MultiLayeredGraphType) right);
            {
                Boolean spaceLayersShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetSpaceLayers(), rightObject.isSetSpaceLayers());
                if (spaceLayersShouldBeMergedAndSet == Boolean.TRUE) {
                    List<SpaceLayersType> lhsSpaceLayers;
                    lhsSpaceLayers = (leftObject.isSetSpaceLayers()?leftObject.getSpaceLayers():null);
                    List<SpaceLayersType> rhsSpaceLayers;
                    rhsSpaceLayers = (rightObject.isSetSpaceLayers()?rightObject.getSpaceLayers():null);
                    List<SpaceLayersType> mergedSpaceLayers = ((List<SpaceLayersType> ) strategy.merge(LocatorUtils.property(leftLocator, "spaceLayers", lhsSpaceLayers), LocatorUtils.property(rightLocator, "spaceLayers", rhsSpaceLayers), lhsSpaceLayers, rhsSpaceLayers, leftObject.isSetSpaceLayers(), rightObject.isSetSpaceLayers()));
                    target.unsetSpaceLayers();
                    if (mergedSpaceLayers!= null) {
                        List<SpaceLayersType> uniqueSpaceLayersl = target.getSpaceLayers();
                        uniqueSpaceLayersl.addAll(mergedSpaceLayers);
                    }
                } else {
                    if (spaceLayersShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetSpaceLayers();
                    }
                }
            }
            {
                Boolean interEdgesShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetInterEdges(), rightObject.isSetInterEdges());
                if (interEdgesShouldBeMergedAndSet == Boolean.TRUE) {
                    List<InterEdgesType> lhsInterEdges;
                    lhsInterEdges = (leftObject.isSetInterEdges()?leftObject.getInterEdges():null);
                    List<InterEdgesType> rhsInterEdges;
                    rhsInterEdges = (rightObject.isSetInterEdges()?rightObject.getInterEdges():null);
                    List<InterEdgesType> mergedInterEdges = ((List<InterEdgesType> ) strategy.merge(LocatorUtils.property(leftLocator, "interEdges", lhsInterEdges), LocatorUtils.property(rightLocator, "interEdges", rhsInterEdges), lhsInterEdges, rhsInterEdges, leftObject.isSetInterEdges(), rightObject.isSetInterEdges()));
                    target.unsetInterEdges();
                    if (mergedInterEdges!= null) {
                        List<InterEdgesType> uniqueInterEdgesl = target.getInterEdges();
                        uniqueInterEdgesl.addAll(mergedInterEdges);
                    }
                } else {
                    if (interEdgesShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetInterEdges();
                    }
                }
            }
        }
    }

    public void setSpaceLayers(List<SpaceLayersType> value) {
        this.spaceLayers = null;
        if (value!= null) {
            List<SpaceLayersType> draftl = this.getSpaceLayers();
            draftl.addAll(value);
        }
    }

    public void setInterEdges(List<InterEdgesType> value) {
        this.interEdges = null;
        if (value!= null) {
            List<InterEdgesType> draftl = this.getInterEdges();
            draftl.addAll(value);
        }
    }

    public MultiLayeredGraphType withSpaceLayers(SpaceLayersType... values) {
        if (values!= null) {
            for (SpaceLayersType value: values) {
                getSpaceLayers().add(value);
            }
        }
        return this;
    }

    public MultiLayeredGraphType withSpaceLayers(Collection<SpaceLayersType> values) {
        if (values!= null) {
            getSpaceLayers().addAll(values);
        }
        return this;
    }

    public MultiLayeredGraphType withInterEdges(InterEdgesType... values) {
        if (values!= null) {
            for (InterEdgesType value: values) {
                getInterEdges().add(value);
            }
        }
        return this;
    }

    public MultiLayeredGraphType withInterEdges(Collection<InterEdgesType> values) {
        if (values!= null) {
            getInterEdges().addAll(values);
        }
        return this;
    }

    public MultiLayeredGraphType withSpaceLayers(List<SpaceLayersType> value) {
        setSpaceLayers(value);
        return this;
    }

    public MultiLayeredGraphType withInterEdges(List<InterEdgesType> value) {
        setInterEdges(value);
        return this;
    }

}
