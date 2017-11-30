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
import net.opengis.indoorgml.navigation.v_1_0.NavigableSpaceType;
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
 * <p>CellSpaceType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="CellSpaceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cellSpaceGeometry" type="{http://www.opengis.net/indoorgml/1.0/core}CellSpaceGeometryType" minOccurs="0"/&gt;
 *         &lt;element name="duality" type="{http://www.opengis.net/indoorgml/1.0/core}StatePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="externalReference" type="{http://www.opengis.net/indoorgml/1.0/core}ExternalReferenceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="partialboundedBy" type="{http://www.opengis.net/indoorgml/1.0/core}CellSpaceBoundaryPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CellSpaceType", propOrder = {
    "cellSpaceGeometry",
    "duality",
    "externalReference",
    "partialboundedBy"
})
@XmlSeeAlso({
    NavigableSpaceType.class
})
public class CellSpaceType
    extends AbstractFeatureType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    protected CellSpaceGeometryType cellSpaceGeometry;
    protected StatePropertyType duality;
    protected List<ExternalReferenceType> externalReference;
    protected List<CellSpaceBoundaryPropertyType> partialboundedBy;

    /**
     * cellSpaceGeometry 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CellSpaceGeometryType }
     *     
     */
    public CellSpaceGeometryType getCellSpaceGeometry() {
        return cellSpaceGeometry;
    }

    /**
     * cellSpaceGeometry 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CellSpaceGeometryType }
     *     
     */
    public void setCellSpaceGeometry(CellSpaceGeometryType value) {
        this.cellSpaceGeometry = value;
    }

    public boolean isSetCellSpaceGeometry() {
        return (this.cellSpaceGeometry!= null);
    }

    /**
     * duality 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StatePropertyType }
     *     
     */
    public StatePropertyType getDuality() {
        return duality;
    }

    /**
     * duality 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StatePropertyType }
     *     
     */
    public void setDuality(StatePropertyType value) {
        this.duality = value;
    }

    public boolean isSetDuality() {
        return (this.duality!= null);
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

    /**
     * Gets the value of the partialboundedBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partialboundedBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartialboundedBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CellSpaceBoundaryPropertyType }
     * 
     * 
     */
    public List<CellSpaceBoundaryPropertyType> getPartialboundedBy() {
        if (partialboundedBy == null) {
            partialboundedBy = new ArrayList<CellSpaceBoundaryPropertyType>();
        }
        return this.partialboundedBy;
    }

    public boolean isSetPartialboundedBy() {
        return ((this.partialboundedBy!= null)&&(!this.partialboundedBy.isEmpty()));
    }

    public void unsetPartialboundedBy() {
        this.partialboundedBy = null;
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
            CellSpaceGeometryType theCellSpaceGeometry;
            theCellSpaceGeometry = this.getCellSpaceGeometry();
            strategy.appendField(locator, this, "cellSpaceGeometry", buffer, theCellSpaceGeometry, this.isSetCellSpaceGeometry());
        }
        {
            StatePropertyType theDuality;
            theDuality = this.getDuality();
            strategy.appendField(locator, this, "duality", buffer, theDuality, this.isSetDuality());
        }
        {
            List<ExternalReferenceType> theExternalReference;
            theExternalReference = (this.isSetExternalReference()?this.getExternalReference():null);
            strategy.appendField(locator, this, "externalReference", buffer, theExternalReference, this.isSetExternalReference());
        }
        {
            List<CellSpaceBoundaryPropertyType> thePartialboundedBy;
            thePartialboundedBy = (this.isSetPartialboundedBy()?this.getPartialboundedBy():null);
            strategy.appendField(locator, this, "partialboundedBy", buffer, thePartialboundedBy, this.isSetPartialboundedBy());
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
        final CellSpaceType that = ((CellSpaceType) object);
        {
            CellSpaceGeometryType lhsCellSpaceGeometry;
            lhsCellSpaceGeometry = this.getCellSpaceGeometry();
            CellSpaceGeometryType rhsCellSpaceGeometry;
            rhsCellSpaceGeometry = that.getCellSpaceGeometry();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cellSpaceGeometry", lhsCellSpaceGeometry), LocatorUtils.property(thatLocator, "cellSpaceGeometry", rhsCellSpaceGeometry), lhsCellSpaceGeometry, rhsCellSpaceGeometry, this.isSetCellSpaceGeometry(), that.isSetCellSpaceGeometry())) {
                return false;
            }
        }
        {
            StatePropertyType lhsDuality;
            lhsDuality = this.getDuality();
            StatePropertyType rhsDuality;
            rhsDuality = that.getDuality();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "duality", lhsDuality), LocatorUtils.property(thatLocator, "duality", rhsDuality), lhsDuality, rhsDuality, this.isSetDuality(), that.isSetDuality())) {
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
        {
            List<CellSpaceBoundaryPropertyType> lhsPartialboundedBy;
            lhsPartialboundedBy = (this.isSetPartialboundedBy()?this.getPartialboundedBy():null);
            List<CellSpaceBoundaryPropertyType> rhsPartialboundedBy;
            rhsPartialboundedBy = (that.isSetPartialboundedBy()?that.getPartialboundedBy():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "partialboundedBy", lhsPartialboundedBy), LocatorUtils.property(thatLocator, "partialboundedBy", rhsPartialboundedBy), lhsPartialboundedBy, rhsPartialboundedBy, this.isSetPartialboundedBy(), that.isSetPartialboundedBy())) {
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
            CellSpaceGeometryType theCellSpaceGeometry;
            theCellSpaceGeometry = this.getCellSpaceGeometry();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cellSpaceGeometry", theCellSpaceGeometry), currentHashCode, theCellSpaceGeometry, this.isSetCellSpaceGeometry());
        }
        {
            StatePropertyType theDuality;
            theDuality = this.getDuality();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "duality", theDuality), currentHashCode, theDuality, this.isSetDuality());
        }
        {
            List<ExternalReferenceType> theExternalReference;
            theExternalReference = (this.isSetExternalReference()?this.getExternalReference():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalReference", theExternalReference), currentHashCode, theExternalReference, this.isSetExternalReference());
        }
        {
            List<CellSpaceBoundaryPropertyType> thePartialboundedBy;
            thePartialboundedBy = (this.isSetPartialboundedBy()?this.getPartialboundedBy():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "partialboundedBy", thePartialboundedBy), currentHashCode, thePartialboundedBy, this.isSetPartialboundedBy());
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
        if (draftCopy instanceof CellSpaceType) {
            final CellSpaceType copy = ((CellSpaceType) draftCopy);
            {
                Boolean cellSpaceGeometryShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetCellSpaceGeometry());
                if (cellSpaceGeometryShouldBeCopiedAndSet == Boolean.TRUE) {
                    CellSpaceGeometryType sourceCellSpaceGeometry;
                    sourceCellSpaceGeometry = this.getCellSpaceGeometry();
                    CellSpaceGeometryType copyCellSpaceGeometry = ((CellSpaceGeometryType) strategy.copy(LocatorUtils.property(locator, "cellSpaceGeometry", sourceCellSpaceGeometry), sourceCellSpaceGeometry, this.isSetCellSpaceGeometry()));
                    copy.setCellSpaceGeometry(copyCellSpaceGeometry);
                } else {
                    if (cellSpaceGeometryShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.cellSpaceGeometry = null;
                    }
                }
            }
            {
                Boolean dualityShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetDuality());
                if (dualityShouldBeCopiedAndSet == Boolean.TRUE) {
                    StatePropertyType sourceDuality;
                    sourceDuality = this.getDuality();
                    StatePropertyType copyDuality = ((StatePropertyType) strategy.copy(LocatorUtils.property(locator, "duality", sourceDuality), sourceDuality, this.isSetDuality()));
                    copy.setDuality(copyDuality);
                } else {
                    if (dualityShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.duality = null;
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
            {
                Boolean partialboundedByShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetPartialboundedBy());
                if (partialboundedByShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<CellSpaceBoundaryPropertyType> sourcePartialboundedBy;
                    sourcePartialboundedBy = (this.isSetPartialboundedBy()?this.getPartialboundedBy():null);
                    @SuppressWarnings("unchecked")
                    List<CellSpaceBoundaryPropertyType> copyPartialboundedBy = ((List<CellSpaceBoundaryPropertyType> ) strategy.copy(LocatorUtils.property(locator, "partialboundedBy", sourcePartialboundedBy), sourcePartialboundedBy, this.isSetPartialboundedBy()));
                    copy.unsetPartialboundedBy();
                    if (copyPartialboundedBy!= null) {
                        List<CellSpaceBoundaryPropertyType> uniquePartialboundedByl = copy.getPartialboundedBy();
                        uniquePartialboundedByl.addAll(copyPartialboundedBy);
                    }
                } else {
                    if (partialboundedByShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetPartialboundedBy();
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new CellSpaceType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof CellSpaceType) {
            final CellSpaceType target = this;
            final CellSpaceType leftObject = ((CellSpaceType) left);
            final CellSpaceType rightObject = ((CellSpaceType) right);
            {
                Boolean cellSpaceGeometryShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetCellSpaceGeometry(), rightObject.isSetCellSpaceGeometry());
                if (cellSpaceGeometryShouldBeMergedAndSet == Boolean.TRUE) {
                    CellSpaceGeometryType lhsCellSpaceGeometry;
                    lhsCellSpaceGeometry = leftObject.getCellSpaceGeometry();
                    CellSpaceGeometryType rhsCellSpaceGeometry;
                    rhsCellSpaceGeometry = rightObject.getCellSpaceGeometry();
                    CellSpaceGeometryType mergedCellSpaceGeometry = ((CellSpaceGeometryType) strategy.merge(LocatorUtils.property(leftLocator, "cellSpaceGeometry", lhsCellSpaceGeometry), LocatorUtils.property(rightLocator, "cellSpaceGeometry", rhsCellSpaceGeometry), lhsCellSpaceGeometry, rhsCellSpaceGeometry, leftObject.isSetCellSpaceGeometry(), rightObject.isSetCellSpaceGeometry()));
                    target.setCellSpaceGeometry(mergedCellSpaceGeometry);
                } else {
                    if (cellSpaceGeometryShouldBeMergedAndSet == Boolean.FALSE) {
                        target.cellSpaceGeometry = null;
                    }
                }
            }
            {
                Boolean dualityShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetDuality(), rightObject.isSetDuality());
                if (dualityShouldBeMergedAndSet == Boolean.TRUE) {
                    StatePropertyType lhsDuality;
                    lhsDuality = leftObject.getDuality();
                    StatePropertyType rhsDuality;
                    rhsDuality = rightObject.getDuality();
                    StatePropertyType mergedDuality = ((StatePropertyType) strategy.merge(LocatorUtils.property(leftLocator, "duality", lhsDuality), LocatorUtils.property(rightLocator, "duality", rhsDuality), lhsDuality, rhsDuality, leftObject.isSetDuality(), rightObject.isSetDuality()));
                    target.setDuality(mergedDuality);
                } else {
                    if (dualityShouldBeMergedAndSet == Boolean.FALSE) {
                        target.duality = null;
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
            {
                Boolean partialboundedByShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetPartialboundedBy(), rightObject.isSetPartialboundedBy());
                if (partialboundedByShouldBeMergedAndSet == Boolean.TRUE) {
                    List<CellSpaceBoundaryPropertyType> lhsPartialboundedBy;
                    lhsPartialboundedBy = (leftObject.isSetPartialboundedBy()?leftObject.getPartialboundedBy():null);
                    List<CellSpaceBoundaryPropertyType> rhsPartialboundedBy;
                    rhsPartialboundedBy = (rightObject.isSetPartialboundedBy()?rightObject.getPartialboundedBy():null);
                    List<CellSpaceBoundaryPropertyType> mergedPartialboundedBy = ((List<CellSpaceBoundaryPropertyType> ) strategy.merge(LocatorUtils.property(leftLocator, "partialboundedBy", lhsPartialboundedBy), LocatorUtils.property(rightLocator, "partialboundedBy", rhsPartialboundedBy), lhsPartialboundedBy, rhsPartialboundedBy, leftObject.isSetPartialboundedBy(), rightObject.isSetPartialboundedBy()));
                    target.unsetPartialboundedBy();
                    if (mergedPartialboundedBy!= null) {
                        List<CellSpaceBoundaryPropertyType> uniquePartialboundedByl = target.getPartialboundedBy();
                        uniquePartialboundedByl.addAll(mergedPartialboundedBy);
                    }
                } else {
                    if (partialboundedByShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetPartialboundedBy();
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

    public void setPartialboundedBy(List<CellSpaceBoundaryPropertyType> value) {
        this.partialboundedBy = null;
        if (value!= null) {
            List<CellSpaceBoundaryPropertyType> draftl = this.getPartialboundedBy();
            draftl.addAll(value);
        }
    }

    public CellSpaceType withCellSpaceGeometry(CellSpaceGeometryType value) {
        setCellSpaceGeometry(value);
        return this;
    }

    public CellSpaceType withDuality(StatePropertyType value) {
        setDuality(value);
        return this;
    }

    public CellSpaceType withExternalReference(ExternalReferenceType... values) {
        if (values!= null) {
            for (ExternalReferenceType value: values) {
                getExternalReference().add(value);
            }
        }
        return this;
    }

    public CellSpaceType withExternalReference(Collection<ExternalReferenceType> values) {
        if (values!= null) {
            getExternalReference().addAll(values);
        }
        return this;
    }

    public CellSpaceType withPartialboundedBy(CellSpaceBoundaryPropertyType... values) {
        if (values!= null) {
            for (CellSpaceBoundaryPropertyType value: values) {
                getPartialboundedBy().add(value);
            }
        }
        return this;
    }

    public CellSpaceType withPartialboundedBy(Collection<CellSpaceBoundaryPropertyType> values) {
        if (values!= null) {
            getPartialboundedBy().addAll(values);
        }
        return this;
    }

    public CellSpaceType withExternalReference(List<ExternalReferenceType> value) {
        setExternalReference(value);
        return this;
    }

    public CellSpaceType withPartialboundedBy(List<CellSpaceBoundaryPropertyType> value) {
        setPartialboundedBy(value);
        return this;
    }

}
