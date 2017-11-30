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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
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
 * <p>ExternalReferenceType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="ExternalReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="informationSystem" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
 *         &lt;element name="externalObject" type="{http://www.opengis.net/indoorgml/1.0/core}externalObjectReferenceType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalReferenceType", propOrder = {
    "informationSystem",
    "externalObject"
})
public class ExternalReferenceType implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    @XmlSchemaType(name = "anyURI")
    protected String informationSystem;
    @XmlElement(required = true)
    protected ExternalObjectReferenceType externalObject;

    /**
     * informationSystem 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformationSystem() {
        return informationSystem;
    }

    /**
     * informationSystem 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformationSystem(String value) {
        this.informationSystem = value;
    }

    public boolean isSetInformationSystem() {
        return (this.informationSystem!= null);
    }

    /**
     * externalObject 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ExternalObjectReferenceType }
     *     
     */
    public ExternalObjectReferenceType getExternalObject() {
        return externalObject;
    }

    /**
     * externalObject 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalObjectReferenceType }
     *     
     */
    public void setExternalObject(ExternalObjectReferenceType value) {
        this.externalObject = value;
    }

    public boolean isSetExternalObject() {
        return (this.externalObject!= null);
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
            String theInformationSystem;
            theInformationSystem = this.getInformationSystem();
            strategy.appendField(locator, this, "informationSystem", buffer, theInformationSystem, this.isSetInformationSystem());
        }
        {
            ExternalObjectReferenceType theExternalObject;
            theExternalObject = this.getExternalObject();
            strategy.appendField(locator, this, "externalObject", buffer, theExternalObject, this.isSetExternalObject());
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
        final ExternalReferenceType that = ((ExternalReferenceType) object);
        {
            String lhsInformationSystem;
            lhsInformationSystem = this.getInformationSystem();
            String rhsInformationSystem;
            rhsInformationSystem = that.getInformationSystem();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "informationSystem", lhsInformationSystem), LocatorUtils.property(thatLocator, "informationSystem", rhsInformationSystem), lhsInformationSystem, rhsInformationSystem, this.isSetInformationSystem(), that.isSetInformationSystem())) {
                return false;
            }
        }
        {
            ExternalObjectReferenceType lhsExternalObject;
            lhsExternalObject = this.getExternalObject();
            ExternalObjectReferenceType rhsExternalObject;
            rhsExternalObject = that.getExternalObject();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalObject", lhsExternalObject), LocatorUtils.property(thatLocator, "externalObject", rhsExternalObject), lhsExternalObject, rhsExternalObject, this.isSetExternalObject(), that.isSetExternalObject())) {
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
            String theInformationSystem;
            theInformationSystem = this.getInformationSystem();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informationSystem", theInformationSystem), currentHashCode, theInformationSystem, this.isSetInformationSystem());
        }
        {
            ExternalObjectReferenceType theExternalObject;
            theExternalObject = this.getExternalObject();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalObject", theExternalObject), currentHashCode, theExternalObject, this.isSetExternalObject());
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
        if (draftCopy instanceof ExternalReferenceType) {
            final ExternalReferenceType copy = ((ExternalReferenceType) draftCopy);
            {
                Boolean informationSystemShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetInformationSystem());
                if (informationSystemShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceInformationSystem;
                    sourceInformationSystem = this.getInformationSystem();
                    String copyInformationSystem = ((String) strategy.copy(LocatorUtils.property(locator, "informationSystem", sourceInformationSystem), sourceInformationSystem, this.isSetInformationSystem()));
                    copy.setInformationSystem(copyInformationSystem);
                } else {
                    if (informationSystemShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.informationSystem = null;
                    }
                }
            }
            {
                Boolean externalObjectShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetExternalObject());
                if (externalObjectShouldBeCopiedAndSet == Boolean.TRUE) {
                    ExternalObjectReferenceType sourceExternalObject;
                    sourceExternalObject = this.getExternalObject();
                    ExternalObjectReferenceType copyExternalObject = ((ExternalObjectReferenceType) strategy.copy(LocatorUtils.property(locator, "externalObject", sourceExternalObject), sourceExternalObject, this.isSetExternalObject()));
                    copy.setExternalObject(copyExternalObject);
                } else {
                    if (externalObjectShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.externalObject = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new ExternalReferenceType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        if (right instanceof ExternalReferenceType) {
            final ExternalReferenceType target = this;
            final ExternalReferenceType leftObject = ((ExternalReferenceType) left);
            final ExternalReferenceType rightObject = ((ExternalReferenceType) right);
            {
                Boolean informationSystemShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetInformationSystem(), rightObject.isSetInformationSystem());
                if (informationSystemShouldBeMergedAndSet == Boolean.TRUE) {
                    String lhsInformationSystem;
                    lhsInformationSystem = leftObject.getInformationSystem();
                    String rhsInformationSystem;
                    rhsInformationSystem = rightObject.getInformationSystem();
                    String mergedInformationSystem = ((String) strategy.merge(LocatorUtils.property(leftLocator, "informationSystem", lhsInformationSystem), LocatorUtils.property(rightLocator, "informationSystem", rhsInformationSystem), lhsInformationSystem, rhsInformationSystem, leftObject.isSetInformationSystem(), rightObject.isSetInformationSystem()));
                    target.setInformationSystem(mergedInformationSystem);
                } else {
                    if (informationSystemShouldBeMergedAndSet == Boolean.FALSE) {
                        target.informationSystem = null;
                    }
                }
            }
            {
                Boolean externalObjectShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetExternalObject(), rightObject.isSetExternalObject());
                if (externalObjectShouldBeMergedAndSet == Boolean.TRUE) {
                    ExternalObjectReferenceType lhsExternalObject;
                    lhsExternalObject = leftObject.getExternalObject();
                    ExternalObjectReferenceType rhsExternalObject;
                    rhsExternalObject = rightObject.getExternalObject();
                    ExternalObjectReferenceType mergedExternalObject = ((ExternalObjectReferenceType) strategy.merge(LocatorUtils.property(leftLocator, "externalObject", lhsExternalObject), LocatorUtils.property(rightLocator, "externalObject", rhsExternalObject), lhsExternalObject, rhsExternalObject, leftObject.isSetExternalObject(), rightObject.isSetExternalObject()));
                    target.setExternalObject(mergedExternalObject);
                } else {
                    if (externalObjectShouldBeMergedAndSet == Boolean.FALSE) {
                        target.externalObject = null;
                    }
                }
            }
        }
    }

    public ExternalReferenceType withInformationSystem(String value) {
        setInformationSystem(value);
        return this;
    }

    public ExternalReferenceType withExternalObject(ExternalObjectReferenceType value) {
        setExternalObject(value);
        return this;
    }

}
