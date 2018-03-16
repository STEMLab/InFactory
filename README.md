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

6) Create the document first as posting below request to this url : `{base_url}/Document/(id of the document)`.
   The url address of post request will be this : `{base_url}/indoorfeatures|primalspacefeatures|cellspace...`
```
{
	"id":"doc1"
}
```

7) Create the IndoorFeatures element. Send post request as below to this url : `{base_url}/indoorfeatures/(id of the element)`. 

```
{
	"docId":"doc1",
	"id":"lf1"
}
```

8) Create the PrimalSpaceFeatures element. Send post request as below to this url : `{base_url}/primalspacefeatures/(id of the element)`.

```
{
	"docId":"doc1",
	"parentId":"lf1",
	"id":"psf1"
}
```

9) Create the CellSpace element like below. Send post request as below to this url : `{base_url}/cellspace/(id of the element)`.

```
{
			"id": "C1",
			"parentId": "efc34ce5-acbc-402d-99fe-943362a37f21",
			"docId": "0064f868-24dd-3ed7-3ad3-6fb42579eb7e",
			"type": "CellSpace",
			"geometry": {
				"type": "Surface",
				"coordinates": [
					[
						9.090909090909092,
						17.742978566149297,
						0
					],
					[
						27.71618625277162,
						15.67350332594235,
						0
					],
					[
						27.71618625277162,
						48.785107169253514,
						0
					],
					[
						9.977827050997783,
						48.48946784922395,
						0
					],
					[
						9.090909090909092,
						17.742978566149297,
						0
					]
				],
				"properties": {
					"id": "CG-C1",
					"height": "20",
					"extrude": "true"
				}
			},
			"properties": {
				"name": "첫번째 방",
				"description": "1111111111111111",
				"partialboundedBy": [],
				"externalReference": [],
				"duality": ""
			}
		}
```

10) Send get request to this url : `{base_url}/document/(id of the document)`. In this example we create the document which has the id `doc1`.
So the url will be this : `{base_url}/document/doc1`. Then you can get the document.
