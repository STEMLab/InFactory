# InFactory

This project is for creating & editing OGC IndoorGML 1.0.3 formated data. This is based on ogc-schemas https://github.com/highsource/ogc-schemas, so later I will add License about this. 


## Getting Started

### Prerequisites

1) OS : regardless of OS  
2) Maven : over 3.5 version. You need to install Maven and set MAVEN_HOME & PATH.
   * How to set MAVEN_HOME : [link for Window](https://www.mkyong.com/maven/how-to-install-maven-in-windows/) , [link for Linux](https://maven.apache.org/install.html)
   * This project supports Maven wrapper. If you do not want to install Maven, follow 1-2) and 2-2)
3) Java : JDK 1.8 (and only JDK 1.8). You need to install JDK and set JAVA_HOME & PATH.
   * How to set JAVA_HOME : [link](https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/) 
   

### Installing

1-1. Project building with installed maven

`mvn clean install`

1-2. Project building with maven wrapper

`./mvnw clean install`

2-1. Spring server executing with installed maven

`mvn jetty:run` 

2-2. Spring server executing with maven wrapper

`./mvnw jetty:run`

It is recommended to use the other port number(9797) with parameter 

`mvn jetty:run "-Djetty.port=9797"` 
   
 
## Running

1) Clone the project
2) Go into the cloned project folder and build the project with `mvn clean install`.
3) Run the server with `mvn jetty:run` (Change the port as you want.). 


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Framework 4.0](https://spring.io/) - Java web framework
* [h2gis](http://www.h2gis.org/) - Embedded Database

## How to make http request

It is explained at the wiki.  


## Authors

* Hyemi Jeong - IndoorGML CRUD DAO developer stemlab@pnu.edu
* Hyung-Gyu Ryoo - IndoorGML Restful API developer hgryoo@pnu.edu
* Do-Hoon Kang - InFactory server developer and maintainer dhkang@pnu.edu

## Contributing

Please refer to each project's style guidelines and guidelines for submitting patches and additions. In general, we follow the "fork-and-pull" Git workflow.

1) Fork the repo on GitHub
2) Clone the project to your own machine
3) Commit changes to your own branch
4) Push your work back up to your fork
5) Submit a Pull request so that we can review your changes
NOTE: Be sure to merge the latest from "upstream" before making a pull request!

## License 

This project is under the MIT License - see the [LICENSE](https://github.com/STEMLab/InFactory/blob/master/LICENSE)

## More Information

More information is found at [Wiki](https://github.com/STEMLab/InFactory/wiki).

