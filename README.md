# InFactory

This project is for creating & editing OGC IndoorGML 1.0.3 formated data. This is based on ogc-schemas https://github.com/highsource/ogc-schemas, so later I will add License about this. 


## Getting Started

### Prerequisites

1) OS : regardless of OS.  
2) Maven : over 3.5 version. You need to install Maven and set MAVEN_HOME & PATH.
   * How to set MAVEN_HOME : [link for Window](https://www.mkyong.com/maven/how-to-install-maven-in-windows/) , [link for Linux](https://maven.apache.org/install.html)
3) Java : over 1.8 version. You need to install JDK and set JAVA_HOME & PATH.
   * How to set JAVA_HOME : [link](https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/) 

### Installing

1) Project building

`mvn clean install`

2) Spring server executing

`mvn jetty:run` 

I would like to recommend to use the other port number with parameter 

`"-Djetty.port=9797"`.
   
 
## Running

1) Clone this project and import at Eclipse.
2) Build the project with the first command.
3) Run the server with the second command. 


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [ogc-schemas](https://github.com/highsource/ogc-schemas) - JAXB Bindings for OGC xml schemas
* [Spring Framework 4.0](https://spring.io/) - Java web framework
* [h2gis](http://www.h2gis.org/) - Embedded Database

## How to make http request

I describe this to the wiki. Please refer that. 


## Authors

* Hyemi Jeong - IndoorGML CRUD DAO developer hyemi.jeong@pnu.edu
* Hyung-Gyu Ryoo - IndoorGML Restful API developer hgryoo@pnu.edu

## License 

This project is under the LGPL License - see the [LICENSE](https://github.com/STEMLab/InFactory/blob/master/LICENSE)

