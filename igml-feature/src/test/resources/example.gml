<?xml version="1.0" encoding="UTF-8"?>
<IndoorFeatures xmlns:gml="http://www.opengis.net/gml/3.2" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.opengis.net/indoorgml/1.0/core" xsi:schemaLocation="http://www.opengis.net/indoorgml/1.0/core indoorgmlcore.xsd" gml:id="IFs">
  <primalSpaceFeatures>
    <PrimalSpaceFeatures gml:id="PS1">
    </PrimalSpaceFeatures>
  </primalSpaceFeatures>
  <multiLayeredGraph>
		<MultiLayeredGraph gml:id="MG1">
    <spaceLayers gml:id="SL1">
      <spaceLayerMember>
        <SpaceLayer gml:id="IS1">
          <nodes gml:id="N1">
            <stateMember>
              <State gml:id="R1">
                <gml:name>002</gml:name>
                <duality xlink:href="#C1"/>
                <connects xlink:href="#T0"/>
                <connects xlink:href="#T1"/>
                <geometry>
                  <gml:Point gml:id="P1">
                    <gml:pos>445536.499779417 5444906.24858758 -2.02</gml:pos>
                  </gml:Point>
                </geometry>
              </State>
            </stateMember>
          </nodes>
          <edges gml:id="E1">
            <transitionMember>
              <Transition gml:id="T0">
                <weight>1</weight>
                <connects xlink:href="#R1"/>
                <connects xlink:href="#R3"/>
                <geometry>
                  <gml:LineString gml:id="LS0">
                    <gml:pos>445536.499779417 5444906.24858758 -2.02</gml:pos>
                    <gml:pos>445537.914644321 5444904.59001251 -2.02</gml:pos>
                    <gml:pos>445538.543473167 5444902.27372664 -2.02</gml:pos>
                  </gml:LineString>
                </geometry>
              </Transition>
            </transitionMember>
          </edges>
        </SpaceLayer>
      </spaceLayerMember>
    </spaceLayers>
  </MultiLayeredGraph>
</multiLayeredGraph>
</IndoorFeatures>
