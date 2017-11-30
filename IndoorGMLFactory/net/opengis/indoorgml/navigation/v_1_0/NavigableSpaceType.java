//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2017.11.22 시간 01:17:09 AM KST 
//


package net.opengis.indoorgml.navigation.v_1_0;

import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.v_3_2_1.CodeType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceBoundaryPropertyType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceGeometryType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceType;
import net.opengis.indoorgml.core.v_1_0.ExternalReferenceType;
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
 * <p>NavigableSpaceType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="NavigableSpaceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/indoorgml/1.0/core}CellSpaceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.opengis.net/gml/3.2}CodeType"/&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/gml/3.2}CodeType"/&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/gml/3.2}CodeType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NavigableSpaceType", propOrder = {
    "clazz",
    "function",
    "usage"
})
@XmlSeeAlso({
    GeneralSpaceType.class,
    TransferSpaceType.class
})
public class NavigableSpaceType
    extends CellSpaceType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    @XmlElement(name = "class", required = true)
    protected CodeType clazz;
    @XmlElement(required = true)
    protected CodeType function;
    @XmlElement(required = true)
    protected CodeType usage;

    /**
     * clazz 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getClazz() {
        return clazz;
    }

    /**
     * clazz 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setClazz(CodeType value) {
        this.clazz = value;
    }

    public boolean isSetClazz() {
        return (this.clazz!= null);
    }

    /**
     * function 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getFunction() {
        return function;
    }

    /**
     * function 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setFunction(CodeType value) {
        this.function = value;
    }

    public boolean isSetFunction() {
        return (this.function!= null);
    }

    /**
     * usage 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getUsage() {
        return usage;
    }

    /**
     * usage 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setUsage(CodeType value) {
        this.usage = value;
    }

    public boolean isSetUsage() {
        return (this.usage!= null);
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
            CodeType theClazz;
            theClazz = this.getClazz();
            strategy.appendField(locator, this, "clazz", buffer, theClazz, this.isSetClazz());
        }
        {
            CodeType theFunction;
            theFunction = this.getFunction();
            strategy.appendField(locator, this, "function", buffer, theFunction, this.isSetFunction());
        }
        {
            CodeType theUsage;
            theUsage = this.getUsage();
            strategy.appendField(locator, this, "usage", buffer, theUsage, this.isSetUsage());
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
        final NavigableSpaceType that = ((NavigableSpaceType) object);
        {
            CodeType lhsClazz;
            lhsClazz = this.getClazz();
            CodeType rhsClazz;
            rhsClazz = that.getClazz();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "clazz", lhsClazz), LocatorUtils.property(thatLocator, "clazz", rhsClazz), lhsClazz, rhsClazz, this.isSetClazz(), that.isSetClazz())) {
                return false;
            }
        }
        {
            CodeType lhsFunction;
            lhsFunction = this.getFunction();
            CodeType rhsFunction;
            rhsFunction = that.getFunction();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "function", lhsFunction), LocatorUtils.property(thatLocator, "function", rhsFunction), lhsFunction, rhsFunction, this.isSetFunction(), that.isSetFunction())) {
                return false;
            }
        }
        {
            CodeType lhsUsage;
            lhsUsage = this.getUsage();
            CodeType rhsUsage;
            rhsUsage = that.getUsage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "usage", lhsUsage), LocatorUtils.property(thatLocator, "usage", rhsUsage), lhsUsage, rhsUsage, this.isSetUsage(), that.isSetUsage())) {
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
            CodeType theClazz;
            theClazz = this.getClazz();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "clazz", theClazz), currentHashCode, theClazz, this.isSetClazz());
        }
        {
            CodeType theFunction;
            theFunction = this.getFunction();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "function", theFunction), currentHashCode, theFunction, this.isSetFunction());
        }
        {
            CodeType theUsage;
            theUsage = this.getUsage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "usage", theUsage), currentHashCode, theUsage, this.isSetUsage());
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
        if (draftCopy instanceof NavigableSpaceType) {
            final NavigableSpaceType copy = ((NavigableSpaceType) draftCopy);
            {
                Boolean clazzShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetClazz());
                if (clazzShouldBeCopiedAndSet == Boolean.TRUE) {
                    CodeType sourceClazz;
                    sourceClazz = this.getClazz();
                    CodeType copyClazz = ((CodeType) strategy.copy(LocatorUtils.property(locator, "clazz", sourceClazz), sourceClazz, this.isSetClazz()));
                    copy.setClazz(copyClazz);
                } else {
                    if (clazzShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.clazz = null;
                    }
                }
            }
            {
                Boolean functionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetFunction());
                if (functionShouldBeCopiedAndSet == Boolean.TRUE) {
                    CodeType sourceFunction;
                    sourceFunction = this.getFunction();
                    CodeType copyFunction = ((CodeType) strategy.copy(LocatorUtils.property(locator, "function", sourceFunction), sourceFunction, this.isSetFunction()));
                    copy.setFunction(copyFunction);
                } else {
                    if (functionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.function = null;
                    }
                }
            }
            {
                Boolean usageShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetUsage());
                if (usageShouldBeCopiedAndSet == Boolean.TRUE) {
                    CodeType sourceUsage;
                    sourceUsage = this.getUsage();
                    CodeType copyUsage = ((CodeType) strategy.copy(LocatorUtils.property(locator, "usage", sourceUsage), sourceUsage, this.isSetUsage()));
                    copy.setUsage(copyUsage);
                } else {
                    if (usageShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.usage = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new NavigableSpaceType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof NavigableSpaceType) {
            final NavigableSpaceType target = this;
            final NavigableSpaceType leftObject = ((NavigableSpaceType) left);
            final NavigableSpaceType rightObject = ((NavigableSpaceType) right);
            {
                Boolean clazzShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetClazz(), rightObject.isSetClazz());
                if (clazzShouldBeMergedAndSet == Boolean.TRUE) {
                    CodeType lhsClazz;
                    lhsClazz = leftObject.getClazz();
                    CodeType rhsClazz;
                    rhsClazz = rightObject.getClazz();
                    CodeType mergedClazz = ((CodeType) strategy.merge(LocatorUtils.property(leftLocator, "clazz", lhsClazz), LocatorUtils.property(rightLocator, "clazz", rhsClazz), lhsClazz, rhsClazz, leftObject.isSetClazz(), rightObject.isSetClazz()));
                    target.setClazz(mergedClazz);
                } else {
                    if (clazzShouldBeMergedAndSet == Boolean.FALSE) {
                        target.clazz = null;
                    }
                }
            }
            {
                Boolean functionShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetFunction(), rightObject.isSetFunction());
                if (functionShouldBeMergedAndSet == Boolean.TRUE) {
                    CodeType lhsFunction;
                    lhsFunction = leftObject.getFunction();
                    CodeType rhsFunction;
                    rhsFunction = rightObject.getFunction();
                    CodeType mergedFunction = ((CodeType) strategy.merge(LocatorUtils.property(leftLocator, "function", lhsFunction), LocatorUtils.property(rightLocator, "function", rhsFunction), lhsFunction, rhsFunction, leftObject.isSetFunction(), rightObject.isSetFunction()));
                    target.setFunction(mergedFunction);
                } else {
                    if (functionShouldBeMergedAndSet == Boolean.FALSE) {
                        target.function = null;
                    }
                }
            }
            {
                Boolean usageShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetUsage(), rightObject.isSetUsage());
                if (usageShouldBeMergedAndSet == Boolean.TRUE) {
                    CodeType lhsUsage;
                    lhsUsage = leftObject.getUsage();
                    CodeType rhsUsage;
                    rhsUsage = rightObject.getUsage();
                    CodeType mergedUsage = ((CodeType) strategy.merge(LocatorUtils.property(leftLocator, "usage", lhsUsage), LocatorUtils.property(rightLocator, "usage", rhsUsage), lhsUsage, rhsUsage, leftObject.isSetUsage(), rightObject.isSetUsage()));
                    target.setUsage(mergedUsage);
                } else {
                    if (usageShouldBeMergedAndSet == Boolean.FALSE) {
                        target.usage = null;
                    }
                }
            }
        }
    }

    public NavigableSpaceType withClazz(CodeType value) {
        setClazz(value);
        return this;
    }

    public NavigableSpaceType withFunction(CodeType value) {
        setFunction(value);
        return this;
    }

    public NavigableSpaceType withUsage(CodeType value) {
        setUsage(value);
        return this;
    }

    @Override
    public NavigableSpaceType withCellSpaceGeometry(CellSpaceGeometryType value) {
        setCellSpaceGeometry(value);
        return this;
    }

    @Override
    public NavigableSpaceType withDuality(StatePropertyType value) {
        setDuality(value);
        return this;
    }

    @Override
    public NavigableSpaceType withExternalReference(ExternalReferenceType... values) {
        if (values!= null) {
            for (ExternalReferenceType value: values) {
                getExternalReference().add(value);
            }
        }
        return this;
    }

    @Override
    public NavigableSpaceType withExternalReference(Collection<ExternalReferenceType> values) {
        if (values!= null) {
            getExternalReference().addAll(values);
        }
        return this;
    }

    @Override
    public NavigableSpaceType withPartialboundedBy(CellSpaceBoundaryPropertyType... values) {
        if (values!= null) {
            for (CellSpaceBoundaryPropertyType value: values) {
                getPartialboundedBy().add(value);
            }
        }
        return this;
    }

    @Override
    public NavigableSpaceType withPartialboundedBy(Collection<CellSpaceBoundaryPropertyType> values) {
        if (values!= null) {
            getPartialboundedBy().addAll(values);
        }
        return this;
    }

    @Override
    public NavigableSpaceType withExternalReference(List<ExternalReferenceType> value) {
        setExternalReference(value);
        return this;
    }

    @Override
    public NavigableSpaceType withPartialboundedBy(List<CellSpaceBoundaryPropertyType> value) {
        setPartialboundedBy(value);
        return this;
    }

}
