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
 * <p>PrimalSpaceFeaturesType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="PrimalSpaceFeaturesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cellSpaceMember" type="{http://www.opengis.net/indoorgml/1.0/core}CellSpaceMemberType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="cellSpaceBoundaryMember" type="{http://www.opengis.net/indoorgml/1.0/core}CellSpaceBoundaryMemberType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "PrimalSpaceFeaturesType", propOrder = {
    "cellSpaceMember",
    "cellSpaceBoundaryMember"
})
public class PrimalSpaceFeaturesType
    extends AbstractFeatureType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    protected List<CellSpaceMemberType> cellSpaceMember;
    protected List<CellSpaceBoundaryMemberType> cellSpaceBoundaryMember;
    @XmlAttribute(name = "aggregationType")
    protected AggregationType aggregationType;

    /**
     * Gets the value of the cellSpaceMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cellSpaceMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCellSpaceMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CellSpaceMemberType }
     * 
     * 
     */
    public List<CellSpaceMemberType> getCellSpaceMember() {
        if (cellSpaceMember == null) {
            cellSpaceMember = new ArrayList<CellSpaceMemberType>();
        }
        return this.cellSpaceMember;
    }

    public boolean isSetCellSpaceMember() {
        return ((this.cellSpaceMember!= null)&&(!this.cellSpaceMember.isEmpty()));
    }

    public void unsetCellSpaceMember() {
        this.cellSpaceMember = null;
    }

    /**
     * Gets the value of the cellSpaceBoundaryMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cellSpaceBoundaryMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCellSpaceBoundaryMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CellSpaceBoundaryMemberType }
     * 
     * 
     */
    public List<CellSpaceBoundaryMemberType> getCellSpaceBoundaryMember() {
        if (cellSpaceBoundaryMember == null) {
            cellSpaceBoundaryMember = new ArrayList<CellSpaceBoundaryMemberType>();
        }
        return this.cellSpaceBoundaryMember;
    }

    public boolean isSetCellSpaceBoundaryMember() {
        return ((this.cellSpaceBoundaryMember!= null)&&(!this.cellSpaceBoundaryMember.isEmpty()));
    }

    public void unsetCellSpaceBoundaryMember() {
        this.cellSpaceBoundaryMember = null;
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
            List<CellSpaceMemberType> theCellSpaceMember;
            theCellSpaceMember = (this.isSetCellSpaceMember()?this.getCellSpaceMember():null);
            strategy.appendField(locator, this, "cellSpaceMember", buffer, theCellSpaceMember, this.isSetCellSpaceMember());
        }
        {
            List<CellSpaceBoundaryMemberType> theCellSpaceBoundaryMember;
            theCellSpaceBoundaryMember = (this.isSetCellSpaceBoundaryMember()?this.getCellSpaceBoundaryMember():null);
            strategy.appendField(locator, this, "cellSpaceBoundaryMember", buffer, theCellSpaceBoundaryMember, this.isSetCellSpaceBoundaryMember());
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
        final PrimalSpaceFeaturesType that = ((PrimalSpaceFeaturesType) object);
        {
            List<CellSpaceMemberType> lhsCellSpaceMember;
            lhsCellSpaceMember = (this.isSetCellSpaceMember()?this.getCellSpaceMember():null);
            List<CellSpaceMemberType> rhsCellSpaceMember;
            rhsCellSpaceMember = (that.isSetCellSpaceMember()?that.getCellSpaceMember():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cellSpaceMember", lhsCellSpaceMember), LocatorUtils.property(thatLocator, "cellSpaceMember", rhsCellSpaceMember), lhsCellSpaceMember, rhsCellSpaceMember, this.isSetCellSpaceMember(), that.isSetCellSpaceMember())) {
                return false;
            }
        }
        {
            List<CellSpaceBoundaryMemberType> lhsCellSpaceBoundaryMember;
            lhsCellSpaceBoundaryMember = (this.isSetCellSpaceBoundaryMember()?this.getCellSpaceBoundaryMember():null);
            List<CellSpaceBoundaryMemberType> rhsCellSpaceBoundaryMember;
            rhsCellSpaceBoundaryMember = (that.isSetCellSpaceBoundaryMember()?that.getCellSpaceBoundaryMember():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cellSpaceBoundaryMember", lhsCellSpaceBoundaryMember), LocatorUtils.property(thatLocator, "cellSpaceBoundaryMember", rhsCellSpaceBoundaryMember), lhsCellSpaceBoundaryMember, rhsCellSpaceBoundaryMember, this.isSetCellSpaceBoundaryMember(), that.isSetCellSpaceBoundaryMember())) {
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
            List<CellSpaceMemberType> theCellSpaceMember;
            theCellSpaceMember = (this.isSetCellSpaceMember()?this.getCellSpaceMember():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cellSpaceMember", theCellSpaceMember), currentHashCode, theCellSpaceMember, this.isSetCellSpaceMember());
        }
        {
            List<CellSpaceBoundaryMemberType> theCellSpaceBoundaryMember;
            theCellSpaceBoundaryMember = (this.isSetCellSpaceBoundaryMember()?this.getCellSpaceBoundaryMember():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cellSpaceBoundaryMember", theCellSpaceBoundaryMember), currentHashCode, theCellSpaceBoundaryMember, this.isSetCellSpaceBoundaryMember());
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
        if (draftCopy instanceof PrimalSpaceFeaturesType) {
            final PrimalSpaceFeaturesType copy = ((PrimalSpaceFeaturesType) draftCopy);
            {
                Boolean cellSpaceMemberShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetCellSpaceMember());
                if (cellSpaceMemberShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<CellSpaceMemberType> sourceCellSpaceMember;
                    sourceCellSpaceMember = (this.isSetCellSpaceMember()?this.getCellSpaceMember():null);
                    @SuppressWarnings("unchecked")
                    List<CellSpaceMemberType> copyCellSpaceMember = ((List<CellSpaceMemberType> ) strategy.copy(LocatorUtils.property(locator, "cellSpaceMember", sourceCellSpaceMember), sourceCellSpaceMember, this.isSetCellSpaceMember()));
                    copy.unsetCellSpaceMember();
                    if (copyCellSpaceMember!= null) {
                        List<CellSpaceMemberType> uniqueCellSpaceMemberl = copy.getCellSpaceMember();
                        uniqueCellSpaceMemberl.addAll(copyCellSpaceMember);
                    }
                } else {
                    if (cellSpaceMemberShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetCellSpaceMember();
                    }
                }
            }
            {
                Boolean cellSpaceBoundaryMemberShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetCellSpaceBoundaryMember());
                if (cellSpaceBoundaryMemberShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<CellSpaceBoundaryMemberType> sourceCellSpaceBoundaryMember;
                    sourceCellSpaceBoundaryMember = (this.isSetCellSpaceBoundaryMember()?this.getCellSpaceBoundaryMember():null);
                    @SuppressWarnings("unchecked")
                    List<CellSpaceBoundaryMemberType> copyCellSpaceBoundaryMember = ((List<CellSpaceBoundaryMemberType> ) strategy.copy(LocatorUtils.property(locator, "cellSpaceBoundaryMember", sourceCellSpaceBoundaryMember), sourceCellSpaceBoundaryMember, this.isSetCellSpaceBoundaryMember()));
                    copy.unsetCellSpaceBoundaryMember();
                    if (copyCellSpaceBoundaryMember!= null) {
                        List<CellSpaceBoundaryMemberType> uniqueCellSpaceBoundaryMemberl = copy.getCellSpaceBoundaryMember();
                        uniqueCellSpaceBoundaryMemberl.addAll(copyCellSpaceBoundaryMember);
                    }
                } else {
                    if (cellSpaceBoundaryMemberShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.unsetCellSpaceBoundaryMember();
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
        return new PrimalSpaceFeaturesType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof PrimalSpaceFeaturesType) {
            final PrimalSpaceFeaturesType target = this;
            final PrimalSpaceFeaturesType leftObject = ((PrimalSpaceFeaturesType) left);
            final PrimalSpaceFeaturesType rightObject = ((PrimalSpaceFeaturesType) right);
            {
                Boolean cellSpaceMemberShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetCellSpaceMember(), rightObject.isSetCellSpaceMember());
                if (cellSpaceMemberShouldBeMergedAndSet == Boolean.TRUE) {
                    List<CellSpaceMemberType> lhsCellSpaceMember;
                    lhsCellSpaceMember = (leftObject.isSetCellSpaceMember()?leftObject.getCellSpaceMember():null);
                    List<CellSpaceMemberType> rhsCellSpaceMember;
                    rhsCellSpaceMember = (rightObject.isSetCellSpaceMember()?rightObject.getCellSpaceMember():null);
                    List<CellSpaceMemberType> mergedCellSpaceMember = ((List<CellSpaceMemberType> ) strategy.merge(LocatorUtils.property(leftLocator, "cellSpaceMember", lhsCellSpaceMember), LocatorUtils.property(rightLocator, "cellSpaceMember", rhsCellSpaceMember), lhsCellSpaceMember, rhsCellSpaceMember, leftObject.isSetCellSpaceMember(), rightObject.isSetCellSpaceMember()));
                    target.unsetCellSpaceMember();
                    if (mergedCellSpaceMember!= null) {
                        List<CellSpaceMemberType> uniqueCellSpaceMemberl = target.getCellSpaceMember();
                        uniqueCellSpaceMemberl.addAll(mergedCellSpaceMember);
                    }
                } else {
                    if (cellSpaceMemberShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetCellSpaceMember();
                    }
                }
            }
            {
                Boolean cellSpaceBoundaryMemberShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetCellSpaceBoundaryMember(), rightObject.isSetCellSpaceBoundaryMember());
                if (cellSpaceBoundaryMemberShouldBeMergedAndSet == Boolean.TRUE) {
                    List<CellSpaceBoundaryMemberType> lhsCellSpaceBoundaryMember;
                    lhsCellSpaceBoundaryMember = (leftObject.isSetCellSpaceBoundaryMember()?leftObject.getCellSpaceBoundaryMember():null);
                    List<CellSpaceBoundaryMemberType> rhsCellSpaceBoundaryMember;
                    rhsCellSpaceBoundaryMember = (rightObject.isSetCellSpaceBoundaryMember()?rightObject.getCellSpaceBoundaryMember():null);
                    List<CellSpaceBoundaryMemberType> mergedCellSpaceBoundaryMember = ((List<CellSpaceBoundaryMemberType> ) strategy.merge(LocatorUtils.property(leftLocator, "cellSpaceBoundaryMember", lhsCellSpaceBoundaryMember), LocatorUtils.property(rightLocator, "cellSpaceBoundaryMember", rhsCellSpaceBoundaryMember), lhsCellSpaceBoundaryMember, rhsCellSpaceBoundaryMember, leftObject.isSetCellSpaceBoundaryMember(), rightObject.isSetCellSpaceBoundaryMember()));
                    target.unsetCellSpaceBoundaryMember();
                    if (mergedCellSpaceBoundaryMember!= null) {
                        List<CellSpaceBoundaryMemberType> uniqueCellSpaceBoundaryMemberl = target.getCellSpaceBoundaryMember();
                        uniqueCellSpaceBoundaryMemberl.addAll(mergedCellSpaceBoundaryMember);
                    }
                } else {
                    if (cellSpaceBoundaryMemberShouldBeMergedAndSet == Boolean.FALSE) {
                        target.unsetCellSpaceBoundaryMember();
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

    public void setCellSpaceMember(List<CellSpaceMemberType> value) {
        this.cellSpaceMember = null;
        if (value!= null) {
            List<CellSpaceMemberType> draftl = this.getCellSpaceMember();
            draftl.addAll(value);
        }
    }

    public void setCellSpaceBoundaryMember(List<CellSpaceBoundaryMemberType> value) {
        this.cellSpaceBoundaryMember = null;
        if (value!= null) {
            List<CellSpaceBoundaryMemberType> draftl = this.getCellSpaceBoundaryMember();
            draftl.addAll(value);
        }
    }

    public PrimalSpaceFeaturesType withCellSpaceMember(CellSpaceMemberType... values) {
        if (values!= null) {
            for (CellSpaceMemberType value: values) {
                getCellSpaceMember().add(value);
            }
        }
        return this;
    }

    public PrimalSpaceFeaturesType withCellSpaceMember(Collection<CellSpaceMemberType> values) {
        if (values!= null) {
            getCellSpaceMember().addAll(values);
        }
        return this;
    }

    public PrimalSpaceFeaturesType withCellSpaceBoundaryMember(CellSpaceBoundaryMemberType... values) {
        if (values!= null) {
            for (CellSpaceBoundaryMemberType value: values) {
                getCellSpaceBoundaryMember().add(value);
            }
        }
        return this;
    }

    public PrimalSpaceFeaturesType withCellSpaceBoundaryMember(Collection<CellSpaceBoundaryMemberType> values) {
        if (values!= null) {
            getCellSpaceBoundaryMember().addAll(values);
        }
        return this;
    }

    public PrimalSpaceFeaturesType withAggregationType(AggregationType value) {
        setAggregationType(value);
        return this;
    }

    public PrimalSpaceFeaturesType withCellSpaceMember(List<CellSpaceMemberType> value) {
        setCellSpaceMember(value);
        return this;
    }

    public PrimalSpaceFeaturesType withCellSpaceBoundaryMember(List<CellSpaceBoundaryMemberType> value) {
        setCellSpaceBoundaryMember(value);
        return this;
    }

}
