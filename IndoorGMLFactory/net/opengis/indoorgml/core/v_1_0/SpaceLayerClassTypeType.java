//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2017.11.22 시간 01:17:09 AM KST 
//


package net.opengis.indoorgml.core.v_1_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SpaceLayerClassTypeType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="SpaceLayerClassTypeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="TOPOGRAPHIC"/&gt;
 *     &lt;enumeration value="SENSOR"/&gt;
 *     &lt;enumeration value="LOGICAL"/&gt;
 *     &lt;enumeration value="TAGS"/&gt;
 *     &lt;enumeration value="UNKNOWN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SpaceLayerClassTypeType")
@XmlEnum
public enum SpaceLayerClassTypeType {

    TOPOGRAPHIC,
    SENSOR,
    LOGICAL,
    TAGS,
    UNKNOWN;

    public String value() {
        return name();
    }

    public static SpaceLayerClassTypeType fromValue(String v) {
        return valueOf(v);
    }

}
