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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.v_3_2_1.AbstractFeatureType;
import net.opengis.indoorgml.navigation.v_1_0.NavigableBoundaryType;
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
 * <p>CellSpaceBoundaryType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="CellSpaceBoundaryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="duality" type="{http://www.opengis.net/indoorgml/1.0/core}TransitionPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="cellSpaceBoundaryGeometry" type="{http://www.opengis.net/indoorgml/1.0/core}CellSpaceBoundaryGeometryType" minOccurs="0"/&gt;
 *         &lt;element name="externalReference" type="{http://www.opengis.net/indoorgml/1.0/core}ExternalReferenceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CellSpaceBoundaryType", propOrder = {
    "duality",
    "cellSpaceBoundaryGeometry",
    "externalReference"
})
@XmlSeeAlso({
    NavigableBoundaryType.class
})
public class CellSpaceBoundaryType
    extends AbstractFeatureType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    protected TransitionPropertyType duality;
    protected CellSpaceBoundaryGeometryType cellSpaceBoundaryGeometry;
    protected List<ExternalReferenceType> externalReference;

    /**
     * duality 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TransitionPropertyType }
     *     
     */
    public TransitionPropertyType getDuality() {
        return duality;
    }

    /**
     * duality 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TransitionPropertyType }
     *     
     */
    public void setDuality(TransitionPropertyType value) {
        this.duality = value;
    }

    public boolean isSetDuality() {
        return (this.duality!= null);
    }

    /**
     * cellSpaceBoundaryGeometry 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CellSpaceBoundaryGeometryType }
     *     
     */
    public CellSpaceBoundaryGeometryType getCellSpaceBoundaryGeometry() {
        return cellSpaceBoundaryGeometry;
    }

    /**
     * cellSpaceBoundaryGeometry 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CellSpaceBoundaryGeometryType }
     *     
     */
    public void setCellSpaceBoundaryGeometry(CellSpaceBoundaryGeometryType value) {
        this.cellSpaceBoundaryGeometry = value;
    }

    public boolean isSetCellSpaceBoundaryGeometry() {
        return (this.cellSpaceBoundaryGeometry!= null);
    }

    /**
     * Gets the value of the externalReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the externalReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternalReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalReferenceType }
     * 
     * 
     */
    public List<ExternalReferenceType> getExternalReference() {
        if (externalReference == null) {
            externalReference = new ArrayList<ExternalReferenceType>();
        }
        return this.externalReference;
    }

    public boolean isSetExternalReference() {
        return ((this.externalReference!= null)&&(!this.externalReference.isEmpty()));
    }

    public void unsetExternalReference() {
        this.externalReference = null;
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
            TransitionPropertyType theDuality;
            theDuality = this.getDuality();
            strategy.appendField(locator, this, "duality", buffer, theDuality, this.isSetDuality());
        }
        {
            CellSpaceBoundaryGeometryType theCellSpaceBoundaryGeometry;
            theCellSpaceBoundaryGeometry = this.getCellSpaceBoundaryGeometry();
            strategy.appendField(locator, this, "cellSpaceBoundaryGeometry", buffer, theCellSpaceBoundaryGeometry, this.isSetCellSpaceBoundaryGeometry());
        }
        {
            List<ExternalReferenceType> theExternalReference;
            theExternalReference = (this.isSetExternalReference()?this.getExternalReference():null);
            strategy.appendField(locator, this, "externalReference", buffer, theExternalReference, this.isSetExternalReference());
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
        final CellSpaceBoundaryType that = ((CellSpaceBoundaryType) object);
        {
            TransitionPropertyType lhsDuality;
            lhsDuality = this.getDuality();
            TransitionPropertyType rhsDuality;
            rhsDuality = that.getDuality();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "duality", lhsDuality), LocatorUtils.property(thatLocator, "duality", rhsDuality), lhsDuality, rhsDuality, this.isSetDuality(), that.isSetDuality())) {
                return false;
            }
        }
        {
            CellSpaceBoundaryGeometryType lhsCellSpaceBoundaryGeometry;
            lhsCellSpaceBoundaryGeometry = this.getCellSpaceBoundaryGeometry();
            CellSpaceBoundaryGeometryType rhsCellSpaceBoundaryGeometry;
            rhsCellSpaceBoundaryGeometry = that.getCellSpaceBoundaryGeometry();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cellSpaceBoundaryGeometry", lhsCellSpaceBoundaryGeometry), LocatorUtils.property(thatLocator, "cellSpaceBoundaryGeometry", rhsCellSpaceBoundaryGeometry), lhsCellSpaceBoundaryGeometry, rhsCellSpaceBoundaryGeometry, this.isSetCellSpaceBoundaryGeometry(), that.isSetCellSpaceBoundaryGeometry())) {
                return false;
            }
        }
        {
            List<ExternalReferenceType> lhsExternalReference;
            lhsExternalReference = (this.isSetExternalReference()?this.getExternalReference():null);
            List<ExternalReferenceType> rhsExternalReference;
            rhsExternalReference = (that.isSetExternalReference()?that.getExternalReference():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalReference", lhsExternalReference), LocatorUtils.property(thatLocator, "externalReference", rhsExternalReference), lhsExternalReference, rhsExternalReference, this.isSetExternalReference(), that.isSetExternalReference())) {
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
            TransitionPropertyType theDuality;
            theDuality = this.getDuality();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "duality", theDuality), currentHashCode, theDuality, this.isSetDuality());
        }
        {
            CellSpaceBoundaryGeometryType theCellSpaceBoundaryGeometry;
            theCellSpaceBoundaryGeometry = this.getCellSpaceBoundaryGeometry();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cellSpaceBoundaryGeometry", theCellSpaceBoundaryGeometry), currentHashCode, theCellSpaceBoundaryGeometry, this.isSetCellSpaceBoundaryGeometry());
        }
        {
            List<ExternalReferenceType> theExternalReference;
            theExternalReference = (this.isSetExternalReference()?this.getExternalReference():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalReference", theExternalReference), currentHashCode, theExternalReference, this.isSetExternalReference());
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
        if (draftCopy instanceof CellSpaceBoundaryType) {
            final CellSpaceBoundaryType copy = ((CellSpaceBoundaryType) draftCopy);
            {
                Boolean dualityShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetDuality());
                if (dualityShouldBeCopiedAndSet == Boolean.TRUE) {
                    TransitionPropertyType sourceDuality;
                    sourceDuality = this.getDuality();
                    TransitionPropertyType copyDuality = ((TransitionPropertyType) strategy.copy(LocatorUtils.property(locator, "duality", sourceDuality), sourceDuality, this.isSetDuality()));
                    copy.setDuality(copyDuality);
                } else {
                    if (dualityShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.duality = null;
                    }
                }
            }
            {
                Boolean cellSpaceBoundaryGeometryShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetCellSpaceBoundaryGeometry());
                if (cellSpaceBoundaryGeometryShouldBeCopiedAndSet == Boolean.TRUE) {
                    CellSpaceBoundaryGeometryType sourceCellSpaceBoundaryGeometry;
                    sourceCellSpaceBoundaryGeometry = this.getCellSpaceBoundaryGeometry();
                    CellSpaceBoundaryGeometryType copyCellSpaceBoundaryGeometry = ((CellSpaceBoundaryGeometryType) strategy.copy(LocatorUtils.property(locator, "cellSpaceBoundaryGeometry", sourceCellSpaceBoundaryGeometry), sourceCellSpaceBoundaryGeometry, this.isSetCellSpaceBoundaryGeometry()));
                    copy.setCellSpaceBoundaryGeometry(copyCellSpaceBoundaryGeometry);
                } else {
                    if (cellSpaceBoundaryGeometryShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.cellSpaceBoundaryGeometry = null;
                    }
                }
            }
            {
                Boolean externalReferenceShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetExternalReference());
                if (externalReferenceShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<ExternalReferenceType> sourceExternalReference;
                    sourceExternalReference = (this.isSetExternalReference()?this.getExternalReference():null);
                    @SuppressWarnings("unchecked")
                    List<ExternalReferenceType> copyExternalReference = ((List<ExternalReferenceType> ) strategy.copy(LocatorUtils.property(locator, "externalReference", sourceExternalReference), sourceExternalReference, this.isSetExternalReference()));
                    copy.unsetExternalReference();
                    if (copyExternalReference!= null) {
                        List<ExternalReferenceType> uniqueExternalReferencel = copy.getExternalReference();
                        uniqueExternalReferencel.addAll(copyExternalReference);
                    }
                } else {
                    if (externalReferenceShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetExternalReference();
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new CellSpaceBoundaryType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof CellSpaceBoundaryType) {
            final CellSpaceBoundaryType target = this;
            final CellSpaceBoundaryType leftObject = ((CellSpaceBoundaryType) left);
            final CellSpaceBoundaryType rightObject = ((CellSpaceBoundaryType) right);
            {
                Boolean dualityShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetDuality(), rightObject.isSetDuality());
                if (dualityShouldBeMergedAndSet == Boolean.TRUE) {
                    TransitionPropertyType lhsDuality;
                    lhsDuality = leftObject.getDuality();
                    TransitionPropertyType rhsDuality;
                    rhsDuality = rightObject.getDuality();
                    TransitionPropertyType mergedDuality = ((TransitionPropertyType) strategy.merge(LocatorUtils.property(leftLocator, "duality", lhsDuality), LocatorUtils.property(rightLocator, "duality", rhsDuality), lhsDuality, rhsDuality, leftObject.isSetDuality(), rightObject.isSetDuality()));
                    target.setDuality(mergedDuality);
                } else {
                    if (dualityShouldBeMergedAndSet == Boolean.FALSE) {
                        target.duality = null;
                    }
                }
            }
            {
                Boolean cellSpaceBoundaryGeometryShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetCellSpaceBoundaryGeometry(), rightObject.isSetCellSpaceBoundaryGeometry());
                if (cellSpaceBoundaryGeometryShouldBeMergedAndSet == Boolean.TRUE) {
                    CellSpaceBoundaryGeometryType lhsCellSpaceBoundaryGeometry;
                    lhsCellSpaceBoundaryGeometry = leftObject.getCellSpaceBoundaryGeometry();
                    CellSpaceBoundaryGeometryType rhsCellSpaceBoundaryGeometry;
                    rhsCellSpaceBoundaryGeometry = rightObject.getCellSpaceBoundaryGeometry();
                    CellSpaceBoundaryGeometryType mergedCellSpaceBoundaryGeometry = ((CellSpaceBoundaryGeometryType) strategy.merge(LocatorUtils.property(leftLocator, "cellSpaceBoundaryGeometry", lhsCellSpaceBoundaryGeometry), LocatorUtils.property(rightLocator, "cellSpaceBoundaryGeometry", rhsCellSpaceBoundaryGeometry), lhsCellSpaceBoundaryGeometry, rhsCellSpaceBoundaryGeometry, leftObject.isSetCellSpaceBoundaryGeometry(), rightObject.isSetCellSpaceBoundaryGeometry()));
                    target.setCellSpaceBoundaryGeometry(mergedCellSpaceBoundaryGeometry);
                } else {
                    if (cellSpaceBoundaryGeometryShouldBeMergedAndSet == Boolean.FALSE) {
                        target.cellSpaceBoundaryGeometry = null;
                    }
                }
            }
            {
                Boolean externalReferenceShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetExternalReference(), rightObject.isSetExternalReference());
                if (externalReferenceShouldBeMergedAndSet == Boolean.TRUE) {
                    List<ExternalReferenceType> lhsExternalReference;
                    lhsExternalReference = (leftObject.isSetExternalReference()?leftObject.getExternalReference():null);
                    List<ExternalReferenceType> rhsExternalReference;
                    rhsExternalReference = (rightObject.isSetExternalReference()?rightObject.getExternalReference():null);
                    List<ExternalReferenceType> mergedExternalReference = ((List<ExternalReferenceType> ) strategy.merge(LocatorUtils.property(leftLocator, "externalReference", lhsExternalReference), LocatorUtils.property(rightLocator, "externalReference", rhsExternalReference), lhsExternalReference, rhsExternalReference, leftObject.isSetExternalReference(), rightObject.isSetExternalReference()));
                    target.unsetExternalReference();
                    if (mergedExternalReference!= null) {
                        List<ExternalReferenceType> uniqueExternalReferencel = target.getExternalReference();
                        uniqueExternalReferencel.addAll(mergedExternalReference);
                    }
                } else {
                    if (externalReferenceShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetExternalReference();
                    }
                }
            }
        }
    }

    public void setExternalReference(List<ExternalReferenceType> value) {
        this.externalReference = null;
        if (value!= null) {
            List<ExternalReferenceType> draftl = this.getExternalReference();
            draftl.addAll(value);
        }
    }

    public CellSpaceBoundaryType withDuality(TransitionPropertyType value) {
        setDuality(value);
        return this;
    }

    public CellSpaceBoundaryType withCellSpaceBoundaryGeometry(CellSpaceBoundaryGeometryType value) {
        setCellSpaceBoundaryGeometry(value);
        return this;
    }

    public CellSpaceBoundaryType withExternalReference(ExternalReferenceType... values) {
        if (values!= null) {
            for (ExternalReferenceType value: values) {
                getExternalReference().add(value);
            }
        }
        return this;
    }

    public CellSpaceBoundaryType withExternalReference(Collection<ExternalReferenceType> values) {
        if (values!= null) {
            getExternalReference().addAll(values);
        }
        return this;
    }

    public CellSpaceBoundaryType withExternalReference(List<ExternalReferenceType> value) {
        setExternalReference(value);
        return this;
    }

}
