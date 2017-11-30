//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2017.11.22 시간 01:17:09 AM KST 
//


package net.opengis.indoorgml.core.v_1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.v_3_2_1.SolidPropertyType;
import net.opengis.gml.v_3_2_1.SurfacePropertyType;
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
 * <p>CellSpaceGeometryType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="CellSpaceGeometryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="Geometry3D" type="{http://www.opengis.net/gml/3.2}SolidPropertyType"/&gt;
 *         &lt;element name="Geometry2D" type="{http://www.opengis.net/gml/3.2}SurfacePropertyType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CellSpaceGeometryType", propOrder = {
    "geometry3D",
    "geometry2D"
})
public class CellSpaceGeometryType implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    @XmlElement(name = "Geometry3D")
    protected SolidPropertyType geometry3D;
    @XmlElement(name = "Geometry2D")
    protected SurfacePropertyType geometry2D;

    /**
     * geometry3D 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SolidPropertyType }
     *     
     */
    public SolidPropertyType getGeometry3D() {
        return geometry3D;
    }

    /**
     * geometry3D 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SolidPropertyType }
     *     
     */
    public void setGeometry3D(SolidPropertyType value) {
        this.geometry3D = value;
    }

    public boolean isSetGeometry3D() {
        return (this.geometry3D!= null);
    }

    /**
     * geometry2D 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SurfacePropertyType }
     *     
     */
    public SurfacePropertyType getGeometry2D() {
        return geometry2D;
    }

    /**
     * geometry2D 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SurfacePropertyType }
     *     
     */
    public void setGeometry2D(SurfacePropertyType value) {
        this.geometry2D = value;
    }

    public boolean isSetGeometry2D() {
        return (this.geometry2D!= null);
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
        {
            SolidPropertyType theGeometry3D;
            theGeometry3D = this.getGeometry3D();
            strategy.appendField(locator, this, "geometry3D", buffer, theGeometry3D, this.isSetGeometry3D());
        }
        {
            SurfacePropertyType theGeometry2D;
            theGeometry2D = this.getGeometry2D();
            strategy.appendField(locator, this, "geometry2D", buffer, theGeometry2D, this.isSetGeometry2D());
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
        final CellSpaceGeometryType that = ((CellSpaceGeometryType) object);
        {
            SolidPropertyType lhsGeometry3D;
            lhsGeometry3D = this.getGeometry3D();
            SolidPropertyType rhsGeometry3D;
            rhsGeometry3D = that.getGeometry3D();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "geometry3D", lhsGeometry3D), LocatorUtils.property(thatLocator, "geometry3D", rhsGeometry3D), lhsGeometry3D, rhsGeometry3D, this.isSetGeometry3D(), that.isSetGeometry3D())) {
                return false;
            }
        }
        {
            SurfacePropertyType lhsGeometry2D;
            lhsGeometry2D = this.getGeometry2D();
            SurfacePropertyType rhsGeometry2D;
            rhsGeometry2D = that.getGeometry2D();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "geometry2D", lhsGeometry2D), LocatorUtils.property(thatLocator, "geometry2D", rhsGeometry2D), lhsGeometry2D, rhsGeometry2D, this.isSetGeometry2D(), that.isSetGeometry2D())) {
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
        int currentHashCode = 1;
        {
            SolidPropertyType theGeometry3D;
            theGeometry3D = this.getGeometry3D();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "geometry3D", theGeometry3D), currentHashCode, theGeometry3D, this.isSetGeometry3D());
        }
        {
            SurfacePropertyType theGeometry2D;
            theGeometry2D = this.getGeometry2D();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "geometry2D", theGeometry2D), currentHashCode, theGeometry2D, this.isSetGeometry2D());
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
        if (draftCopy instanceof CellSpaceGeometryType) {
            final CellSpaceGeometryType copy = ((CellSpaceGeometryType) draftCopy);
            {
                Boolean geometry3DShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetGeometry3D());
                if (geometry3DShouldBeCopiedAndSet == Boolean.TRUE) {
                    SolidPropertyType sourceGeometry3D;
                    sourceGeometry3D = this.getGeometry3D();
                    SolidPropertyType copyGeometry3D = ((SolidPropertyType) strategy.copy(LocatorUtils.property(locator, "geometry3D", sourceGeometry3D), sourceGeometry3D, this.isSetGeometry3D()));
                    copy.setGeometry3D(copyGeometry3D);
                } else {
                    if (geometry3DShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.geometry3D = null;
                    }
                }
            }
            {
                Boolean geometry2DShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetGeometry2D());
                if (geometry2DShouldBeCopiedAndSet == Boolean.TRUE) {
                    SurfacePropertyType sourceGeometry2D;
                    sourceGeometry2D = this.getGeometry2D();
                    SurfacePropertyType copyGeometry2D = ((SurfacePropertyType) strategy.copy(LocatorUtils.property(locator, "geometry2D", sourceGeometry2D), sourceGeometry2D, this.isSetGeometry2D()));
                    copy.setGeometry2D(copyGeometry2D);
                } else {
                    if (geometry2DShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.geometry2D = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new CellSpaceGeometryType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        if (right instanceof CellSpaceGeometryType) {
            final CellSpaceGeometryType target = this;
            final CellSpaceGeometryType leftObject = ((CellSpaceGeometryType) left);
            final CellSpaceGeometryType rightObject = ((CellSpaceGeometryType) right);
            {
                Boolean geometry3DShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetGeometry3D(), rightObject.isSetGeometry3D());
                if (geometry3DShouldBeMergedAndSet == Boolean.TRUE) {
                    SolidPropertyType lhsGeometry3D;
                    lhsGeometry3D = leftObject.getGeometry3D();
                    SolidPropertyType rhsGeometry3D;
                    rhsGeometry3D = rightObject.getGeometry3D();
                    SolidPropertyType mergedGeometry3D = ((SolidPropertyType) strategy.merge(LocatorUtils.property(leftLocator, "geometry3D", lhsGeometry3D), LocatorUtils.property(rightLocator, "geometry3D", rhsGeometry3D), lhsGeometry3D, rhsGeometry3D, leftObject.isSetGeometry3D(), rightObject.isSetGeometry3D()));
                    target.setGeometry3D(mergedGeometry3D);
                } else {
                    if (geometry3DShouldBeMergedAndSet == Boolean.FALSE) {
                        target.geometry3D = null;
                    }
                }
            }
            {
                Boolean geometry2DShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetGeometry2D(), rightObject.isSetGeometry2D());
                if (geometry2DShouldBeMergedAndSet == Boolean.TRUE) {
                    SurfacePropertyType lhsGeometry2D;
                    lhsGeometry2D = leftObject.getGeometry2D();
                    SurfacePropertyType rhsGeometry2D;
                    rhsGeometry2D = rightObject.getGeometry2D();
                    SurfacePropertyType mergedGeometry2D = ((SurfacePropertyType) strategy.merge(LocatorUtils.property(leftLocator, "geometry2D", lhsGeometry2D), LocatorUtils.property(rightLocator, "geometry2D", rhsGeometry2D), lhsGeometry2D, rhsGeometry2D, leftObject.isSetGeometry2D(), rightObject.isSetGeometry2D()));
                    target.setGeometry2D(mergedGeometry2D);
                } else {
                    if (geometry2DShouldBeMergedAndSet == Boolean.FALSE) {
                        target.geometry2D = null;
                    }
                }
            }
        }
    }

    public CellSpaceGeometryType withGeometry3D(SolidPropertyType value) {
        setGeometry3D(value);
        return this;
    }

    public CellSpaceGeometryType withGeometry2D(SurfacePropertyType value) {
        setGeometry2D(value);
        return this;
    }

}
