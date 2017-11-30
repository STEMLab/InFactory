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
import net.opengis.gml.v_3_2_1.AbstractFeatureMemberType;
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
 * <p>RouteNodeMemberType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="RouteNodeMemberType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureMemberType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/indoorgml/1.0/navigation}RouteNode"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteNodeMemberType", propOrder = {
    "routeNode"
})
public class RouteNodeMemberType
    extends AbstractFeatureMemberType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    @XmlElement(name = "RouteNode", required = true)
    protected RouteNodeType routeNode;

    /**
     * routeNode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RouteNodeType }
     *     
     */
    public RouteNodeType getRouteNode() {
        return routeNode;
    }

    /**
     * routeNode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteNodeType }
     *     
     */
    public void setRouteNode(RouteNodeType value) {
        this.routeNode = value;
    }

    public boolean isSetRouteNode() {
        return (this.routeNode!= null);
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
            RouteNodeType theRouteNode;
            theRouteNode = this.getRouteNode();
            strategy.appendField(locator, this, "routeNode", buffer, theRouteNode, this.isSetRouteNode());
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
        final RouteNodeMemberType that = ((RouteNodeMemberType) object);
        {
            RouteNodeType lhsRouteNode;
            lhsRouteNode = this.getRouteNode();
            RouteNodeType rhsRouteNode;
            rhsRouteNode = that.getRouteNode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "routeNode", lhsRouteNode), LocatorUtils.property(thatLocator, "routeNode", rhsRouteNode), lhsRouteNode, rhsRouteNode, this.isSetRouteNode(), that.isSetRouteNode())) {
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
            RouteNodeType theRouteNode;
            theRouteNode = this.getRouteNode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "routeNode", theRouteNode), currentHashCode, theRouteNode, this.isSetRouteNode());
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
        if (draftCopy instanceof RouteNodeMemberType) {
            final RouteNodeMemberType copy = ((RouteNodeMemberType) draftCopy);
            {
                Boolean routeNodeShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetRouteNode());
                if (routeNodeShouldBeCopiedAndSet == Boolean.TRUE) {
                    RouteNodeType sourceRouteNode;
                    sourceRouteNode = this.getRouteNode();
                    RouteNodeType copyRouteNode = ((RouteNodeType) strategy.copy(LocatorUtils.property(locator, "routeNode", sourceRouteNode), sourceRouteNode, this.isSetRouteNode()));
                    copy.setRouteNode(copyRouteNode);
                } else {
                    if (routeNodeShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.routeNode = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new RouteNodeMemberType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof RouteNodeMemberType) {
            final RouteNodeMemberType target = this;
            final RouteNodeMemberType leftObject = ((RouteNodeMemberType) left);
            final RouteNodeMemberType rightObject = ((RouteNodeMemberType) right);
            {
                Boolean routeNodeShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetRouteNode(), rightObject.isSetRouteNode());
                if (routeNodeShouldBeMergedAndSet == Boolean.TRUE) {
                    RouteNodeType lhsRouteNode;
                    lhsRouteNode = leftObject.getRouteNode();
                    RouteNodeType rhsRouteNode;
                    rhsRouteNode = rightObject.getRouteNode();
                    RouteNodeType mergedRouteNode = ((RouteNodeType) strategy.merge(LocatorUtils.property(leftLocator, "routeNode", lhsRouteNode), LocatorUtils.property(rightLocator, "routeNode", rhsRouteNode), lhsRouteNode, rhsRouteNode, leftObject.isSetRouteNode(), rightObject.isSetRouteNode()));
                    target.setRouteNode(mergedRouteNode);
                } else {
                    if (routeNodeShouldBeMergedAndSet == Boolean.FALSE) {
                        target.routeNode = null;
                    }
                }
            }
        }
    }

    public RouteNodeMemberType withRouteNode(RouteNodeType value) {
        setRouteNode(value);
        return this;
    }

}
