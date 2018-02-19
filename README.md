# InFactory

## Introduction

This project is for creating & editing OGC IndoorGML 1.0.3 formated data. This is based on ogc-schemas https://github.com/highsource/ogc-schemas, so later I will add License about this. 

**Warning : This project is now under being implemented. After 2018 FEB 1.0 version will be released. Sorry for delaying.**
If is there any issue or question please contact to 'hyemi.jeong@pnu.edu'.

## Authors

* Hyemi Jeong - IndoorGML CRUD DAO developer hyemi.jeong@pnu.edu
* Hyung-Gyu Ryoo - IndoorGML Restful API developer hgryoo@pnu.edu

## Project Setting

### Environment

If you want to set this project, then you need to set: 
1) OS : regardless of OS.  
2) Eclipse : This project currently doesn't support maven command line.
3) Maven 3.5 version

### Command

1) Project building : `mvn clean install`
2) Spring server executing : `mvn jetty:run`
	
   Also set parameter as

   - Parameter Name : `jetty.http.port`

   - Value : `9797(You can change port number as you want)`
   
 
### How to use


1) Clone this project and import at Eclipse.
2) Set `Run Configurations` as upper two commands.
3) Set `base_url` at your rest client : `http://localhost:(port number that you used at the parameter)/`.
4) You need to CRUD the element of IndoorGML from the top to the bottom of IndoorGML structure.
 
 ```
 ex) IndoorFeatures -> PrimalSpaceFeatures -> CellSpace
  
 ex) IndoorFeatures -> MultiLayeredGraph -> SpaceLayers -> SpaceLayer -> Nodes -> State
 ```
 
   You need to create the parent element firstly.
   If the level of elements are same, no order at creating. In this document, we will make the document which contains CellSpace element. And request format is JSON.
   
5) Turn on the jetty server of IndoorGML-Factory as the second command.

6) Create the document first as posting below request to this url : `{base_url}/Document`.
   The url address of post request will be this : `{base_url}/indoorfeatures|primalspacefeatures|cellspace...`
```
{
	"id":"doc1"
}
```

7) Create the IndoorFeatures element. Send post request as below to this url : `{base_url}/indoorfeatures`. 

```
{
	"docId":"doc1",
	"id":"lf1"
}
```

8) Create the PrimalSpaceFeatures element. Send post request as below to this url : `{base_url}/primalspacefeatures`.

```
{
	"docId":"doc1",
	"parentId":"lf1",
	"id":"psf1"
}
```

9) Create the CellSpace element like below. Send post request as below to this url : `{base_url}/cellspace`.

```
{
	"docId":"doc1",
	"parentId":"psf1",
	"id":"c1",
	"geometry":"SOLID (( ((0 0 0, 0 1 0, 1 1 0, 1 0 0, 0 0 0)), ((0 0 0, 0 1 0, 0 1 1, 0 0 1, 0 0 0)), ((0 0 0, 1 0 0, 1 0 1, 0 0 1, 0 0 0)), ((1 1 1, 1 0 1, 0 0 1, 0 1 1, 1 1 1)), ((1 1 1, 1 0 1, 1 0 0, 1 1 0, 1 1 1)), ((1 1 1, 1 1 0, 0 1 0, 0 1 1, 1 1 1)) ))",
	"duality":"s1"
}
```

10) Send get request to this url : `{base_url}/document/{document id}`. In this example we create the document which has the id `doc1`.
So the url will be this : `{base_url}/document/doc1`. Then you can get the document.
