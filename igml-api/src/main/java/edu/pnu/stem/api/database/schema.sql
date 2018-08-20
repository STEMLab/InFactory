create table Documents (
	id CHAR(50),
	name CHAR(50)
);


CREATE TABLE IndoorFeatures (
	id CHAR(50), 
	name CHAR(50), 
	description CHAR(50), 
	primalspacefeatures CHAR(50), 
	multilayeredgraph CHAR(50)
);

CREATE TABLE PrimalSpaceFeatures (id CHAR(50),parentId CHAR(50), name CHAR(50), description CHAR(50), cellspacemember array, cellspaceboundarymember array);

CREATE TABLE MultiLayeredGraph (id CHAR(50),parentId CHAR(50), name CHAR(50), description CHAR(50), spaceLayers array,interEdges array);

CREATE TABLE CellSpace (id CHAR(50),parentId CHAR(50), name CHAR(50), description CHAR(50), duality CHAR(50), partialBoundedBy array, geometry CHAR(50));

CREATE TABLE CellSpaceBoundary (id CHAR(50),parentId CHAR(50), name CHAR(50), description CHAR(50), duality CHAR(50), geometry CHAR(50) );

CREATE TABLE SpaceLayers (id CHAR(50),parentId CHAR(50), name CHAR(50), description CHAR(50), spaceLayerMember array);

CREATE TABLE SpaceLayer (id CHAR(50),parentId CHAR(50), name CHAR(50), description CHAR(50), nodes array, edges array);

CREATE TABLE Nodes (id CHAR(50),parentId CHAR(50), name CHAR(50), description CHAR(50), stateMember array);

CREATE TABLE Edges (id CHAR(50),parentId CHAR(50), name CHAR(50), description CHAR(50), transitionMember array);

CREATE TABLE State (id CHAR(50),parentId CHAR(50), name CHAR(50), description CHAR(50), duality CHAR(50), connects array, geometry CHAR(50));

CREATE TABLE Transition (id CHAR(50),parentId CHAR(50), name CHAR(50), description CHAR(50), duality CHAR(50), connects array,geometry CHAR(50));

CREATE TABLE InterEdges (id CHAR(50),parentId CHAR(50), name CHAR(50), description CHAR(50), interLayerConnection array);

CREATE TABLE InterLayerConnection (id CHAR(50),parentId CHAR(50), name CHAR(50), description CHAR(50), interConnects array, connectedLayers array);

CREATE TABLE Geometry (id CHAR(50), geom BLOB);

CREATE TABLE Feature (id CHAR(50), type CHAR(50));
