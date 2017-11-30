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
 * <p>RouteType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="RouteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="startRouteNode" type="{http://www.opengis.net/indoorgml/1.0/navigation}RouteNodePropertyType"/&gt;
 *         &lt;element name="endRouteNode" type="{http://www.opengis.net/indoorgml/1.0/navigation}RouteNodePropertyType"/&gt;
 *         &lt;element name="routeNodes" type="{http://www.opengis.net/indoorgml/1.0/navigation}RouteNodesType"/&gt;
 *         &lt;element name="path" type="{http://www.opengis.net/indoorgml/1.0/navigation}PathType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteType", propOrder = {
    "startRouteNode",
    "endRouteNode",
    "routeNodes",
    "path"
})
public class RouteType
    extends AbstractFeatureType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2
{

    @XmlElement(required = true)
    protected RouteNodePropertyType startRouteNode;
    @XmlElement(required = true)
    protected RouteNodePropertyType endRouteNode;
    @XmlElement(required = true)
    protected RouteNodesType routeNodes;
    @XmlElement(required = true)
    protected PathType path;

    /**
     * startRouteNode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RouteNodePropertyType }
     *     
     */
    public RouteNodePropertyType getStartRouteNode() {
        return startRouteNode;
    }

    /**
     * startRouteNode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteNodePropertyType }
     *     
     */
    public void setStartRouteNode(RouteNodePropertyType value) {
        this.startRouteNode = value;
    }

    public boolean isSetStartRouteNode() {
        return (this.startRouteNode!= null);
    }

    /**
     * endRouteNode 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RouteNodePropertyType }
     *     
     */
    public RouteNodePropertyType getEndRouteNode() {
        return endRouteNode;
    }

    /**
     * endRouteNode 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteNodePropertyType }
     *     
     */
    public void setEndRouteNode(RouteNodePropertyType value) {
        this.endRouteNode = value;
    }

    public boolean isSetEndRouteNode() {
        return (this.endRouteNode!= null);
    }

    /**
     * routeNodes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RouteNodesType }
     *     
     */
    public RouteNodesType getRouteNodes() {
        return routeNodes;
    }

    /**
     * routeNodes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteNodesType }
     *     
     */
    public void setRouteNodes(RouteNodesType value) {
        this.routeNodes = value;
    }

    public boolean isSetRouteNodes() {
        return (this.routeNodes!= null);
    }

    /**
     * path 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PathType }
     *     
     */
    public PathType getPath() {
        return path;
    }

    /**
     * path 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PathType }
     *     
     */
    public void setPath(PathType value) {
        this.path = value;
    }

    public boolean isSetPath() {
        return (this.path!= null);
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
            RouteNodePropertyType theStartRouteNode;
            theStartRouteNode = this.getStartRouteNode();
            strategy.appendField(locator, this, "startRouteNode", buffer, theStartRouteNode, this.isSetStartRouteNode());
        }
        {
            RouteNodePropertyType theEndRouteNode;
            theEndRouteNode = this.getEndRouteNode();
            strategy.appendField(locator, this, "endRouteNode", buffer, theEndRouteNode, this.isSetEndRouteNode());
        }
        {
            RouteNodesType theRouteNodes;
            theRouteNodes = this.getRouteNodes();
            strategy.appendField(locator, this, "routeNodes", buffer, theRouteNodes, this.isSetRouteNodes());
        }
        {
            PathType thePath;
            thePath = this.getPath();
            strategy.appendField(locator, this, "path", buffer, thePath, this.isSetPath());
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
        final RouteType that = ((RouteType) object);
        {
            RouteNodePropertyType lhsStartRouteNode;
            lhsStartRouteNode = this.getStartRouteNode();
            RouteNodePropertyType rhsStartRouteNode;
            rhsStartRouteNode = that.getStartRouteNode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "startRouteNode", lhsStartRouteNode), LocatorUtils.property(thatLocator, "startRouteNode", rhsStartRouteNode), lhsStartRouteNode, rhsStartRouteNode, this.isSetStartRouteNode(), that.isSetStartRouteNode())) {
                return false;
            }
        }
        {
            RouteNodePropertyType lhsEndRouteNode;
            lhsEndRouteNode = this.getEndRouteNode();
            RouteNodePropertyType rhsEndRouteNode;
            rhsEndRouteNode = that.getEndRouteNode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "endRouteNode", lhsEndRouteNode), LocatorUtils.property(thatLocator, "endRouteNode", rhsEndRouteNode), lhsEndRouteNode, rhsEndRouteNode, this.isSetEndRouteNode(), that.isSetEndRouteNode())) {
                return false;
            }
        }
        {
            RouteNodesType lhsRouteNodes;
            lhsRouteNodes = this.getRouteNodes();
            RouteNodesType rhsRouteNodes;
            rhsRouteNodes = that.getRouteNodes();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "routeNodes", lhsRouteNodes), LocatorUtils.property(thatLocator, "routeNodes", rhsRouteNodes), lhsRouteNodes, rhsRouteNodes, this.isSetRouteNodes(), that.isSetRouteNodes())) {
                return false;
            }
        }
        {
            PathType lhsPath;
            lhsPath = this.getPath();
            PathType rhsPath;
            rhsPath = that.getPath();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "path", lhsPath), LocatorUtils.property(thatLocator, "path", rhsPath), lhsPath, rhsPath, this.isSetPath(), that.isSetPath())) {
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
            RouteNodePropertyType theStartRouteNode;
            theStartRouteNode = this.getStartRouteNode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "startRouteNode", theStartRouteNode), currentHashCode, theStartRouteNode, this.isSetStartRouteNode());
        }
        {
            RouteNodePropertyType theEndRouteNode;
            theEndRouteNode = this.getEndRouteNode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "endRouteNode", theEndRouteNode), currentHashCode, theEndRouteNode, this.isSetEndRouteNode());
        }
        {
            RouteNodesType theRouteNodes;
            theRouteNodes = this.getRouteNodes();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "routeNodes", theRouteNodes), currentHashCode, theRouteNodes, this.isSetRouteNodes());
        }
        {
            PathType thePath;
            thePath = this.getPath();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "path", thePath), currentHashCode, thePath, this.isSetPath());
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
        if (draftCopy instanceof RouteType) {
            final RouteType copy = ((RouteType) draftCopy);
            {
                Boolean startRouteNodeShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetStartRouteNode());
                if (startRouteNodeShouldBeCopiedAndSet == Boolean.TRUE) {
                    RouteNodePropertyType sourceStartRouteNode;
                    sourceStartRouteNode = this.getStartRouteNode();
                    RouteNodePropertyType copyStartRouteNode = ((RouteNodePropertyType) strategy.copy(LocatorUtils.property(locator, "startRouteNode", sourceStartRouteNode), sourceStartRouteNode, this.isSetStartRouteNode()));
                    copy.setStartRouteNode(copyStartRouteNode);
                } else {
                    if (startRouteNodeShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.startRouteNode = null;
                    }
                }
            }
            {
                Boolean endRouteNodeShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetEndRouteNode());
                if (endRouteNodeShouldBeCopiedAndSet == Boolean.TRUE) {
                    RouteNodePropertyType sourceEndRouteNode;
                    sourceEndRouteNode = this.getEndRouteNode();
                    RouteNodePropertyType copyEndRouteNode = ((RouteNodePropertyType) strategy.copy(LocatorUtils.property(locator, "endRouteNode", sourceEndRouteNode), sourceEndRouteNode, this.isSetEndRouteNode()));
                    copy.setEndRouteNode(copyEndRouteNode);
                } else {
                    if (endRouteNodeShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.endRouteNode = null;
                    }
                }
            }
            {
                Boolean routeNodesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetRouteNodes());
                if (routeNodesShouldBeCopiedAndSet == Boolean.TRUE) {
                    RouteNodesType sourceRouteNodes;
                    sourceRouteNodes = this.getRouteNodes();
                    RouteNodesType copyRouteNodes = ((RouteNodesType) strategy.copy(LocatorUtils.property(locator, "routeNodes", sourceRouteNodes), sourceRouteNodes, this.isSetRouteNodes()));
                    copy.setRouteNodes(copyRouteNodes);
                } else {
                    if (routeNodesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.routeNodes = null;
                    }
                }
            }
            {
                Boolean pathShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetPath());
                if (pathShouldBeCopiedAndSet == Boolean.TRUE) {
                    PathType sourcePath;
                    sourcePath = this.getPath();
                    PathType copyPath = ((PathType) strategy.copy(LocatorUtils.property(locator, "path", sourcePath), sourcePath, this.isSetPath()));
                    copy.setPath(copyPath);
                } else {
                    if (pathShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.path = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new RouteType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof RouteType) {
            final RouteType target = this;
            final RouteType leftObject = ((RouteType) left);
            final RouteType rightObject = ((RouteType) right);
            {
                Boolean startRouteNodeShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetStartRouteNode(), rightObject.isSetStartRouteNode());
                if (startRouteNodeShouldBeMergedAndSet == Boolean.TRUE) {
                    RouteNodePropertyType lhsStartRouteNode;
                    lhsStartRouteNode = leftObject.getStartRouteNode();
                    RouteNodePropertyType rhsStartRouteNode;
                    rhsStartRouteNode = rightObject.getStartRouteNode();
                    RouteNodePropertyType mergedStartRouteNode = ((RouteNodePropertyType) strategy.merge(LocatorUtils.property(leftLocator, "startRouteNode", lhsStartRouteNode), LocatorUtils.property(rightLocator, "startRouteNode", rhsStartRouteNode), lhsStartRouteNode, rhsStartRouteNode, leftObject.isSetStartRouteNode(), rightObject.isSetStartRouteNode()));
                    target.setStartRouteNode(mergedStartRouteNode);
                } else {
                    if (startRouteNodeShouldBeMergedAndSet == Boolean.FALSE) {
                        target.startRouteNode = null;
                    }
                }
            }
            {
                Boolean endRouteNodeShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetEndRouteNode(), rightObject.isSetEndRouteNode());
                if (endRouteNodeShouldBeMergedAndSet == Boolean.TRUE) {
                    RouteNodePropertyType lhsEndRouteNode;
                    lhsEndRouteNode = leftObject.getEndRouteNode();
                    RouteNodePropertyType rhsEndRouteNode;
                    rhsEndRouteNode = rightObject.getEndRouteNode();
                    RouteNodePropertyType mergedEndRouteNode = ((RouteNodePropertyType) strategy.merge(LocatorUtils.property(leftLocator, "endRouteNode", lhsEndRouteNode), LocatorUtils.property(rightLocator, "endRouteNode", rhsEndRouteNode), lhsEndRouteNode, rhsEndRouteNode, leftObject.isSetEndRouteNode(), rightObject.isSetEndRouteNode()));
                    target.setEndRouteNode(mergedEndRouteNode);
                } else {
                    if (endRouteNodeShouldBeMergedAndSet == Boolean.FALSE) {
                        target.endRouteNode = null;
                    }
                }
            }
            {
                Boolean routeNodesShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetRouteNodes(), rightObject.isSetRouteNodes());
                if (routeNodesShouldBeMergedAndSet == Boolean.TRUE) {
                    RouteNodesType lhsRouteNodes;
                    lhsRouteNodes = leftObject.getRouteNodes();
                    RouteNodesType rhsRouteNodes;
                    rhsRouteNodes = rightObject.getRouteNodes();
                    RouteNodesType mergedRouteNodes = ((RouteNodesType) strategy.merge(LocatorUtils.property(leftLocator, "routeNodes", lhsRouteNodes), LocatorUtils.property(rightLocator, "routeNodes", rhsRouteNodes), lhsRouteNodes, rhsRouteNodes, leftObject.isSetRouteNodes(), rightObject.isSetRouteNodes()));
                    target.setRouteNodes(mergedRouteNodes);
                } else {
                    if (routeNodesShouldBeMergedAndSet == Boolean.FALSE) {
                        target.routeNodes = null;
                    }
                }
            }
            {
                Boolean pathShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetPath(), rightObject.isSetPath());
                if (pathShouldBeMergedAndSet == Boolean.TRUE) {
                    PathType lhsPath;
                    lhsPath = leftObject.getPath();
                    PathType rhsPath;
                    rhsPath = rightObject.getPath();
                    PathType mergedPath = ((PathType) strategy.merge(LocatorUtils.property(leftLocator, "path", lhsPath), LocatorUtils.property(rightLocator, "path", rhsPath), lhsPath, rhsPath, leftObject.isSetPath(), rightObject.isSetPath()));
                    target.setPath(mergedPath);
                } else {
                    if (pathShouldBeMergedAndSet == Boolean.FALSE) {
                        target.path = null;
                    }
                }
            }
        }
    }

    public RouteType withStartRouteNode(RouteNodePropertyType value) {
        setStartRouteNode(value);
        return this;
    }

    public RouteType withEndRouteNode(RouteNodePropertyType value) {
        setEndRouteNode(value);
        return this;
    }

    public RouteType withRouteNodes(RouteNodesType value) {
        setRouteNodes(value);
        return this;
    }

    public RouteType withPath(PathType value) {
        setPath(value);
        return this;
    }

}
