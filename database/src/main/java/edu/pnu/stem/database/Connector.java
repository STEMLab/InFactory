package edu.pnu.stem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.h2gis.ext.H2GISExtension;

/**
 * Short demo of in memory spatial database.
 */
public class Connector {
	private void createTable(Statement st) throws SQLException {
		List<String>tableName = new ArrayList<String>();		
		tableName.add("IndoorFeatures");
		tableName.add("PrimalSpaceFeatures");
		tableName.add("MultiLayeredGraph");
		tableName.add("CellSpace");
		tableName.add("CellSpaceBoundary");
		tableName.add("SpaceLayers");
		tableName.add("SpaceLayer");
		tableName.add("Nodes");
		tableName.add("Edges");
		tableName.add("State");
		tableName.add("Transition");
		tableName.add("InterEdges");
		tableName.add("InterLayerConnection");
		tableName.add("Geometry");
		tableName.add("Feature");
		
		st.execute("CREATE TABLE IndoorFeatures (id CHAR(50) name CHAR(50) description CHAR(50) primalspacefeature CHAR(50) multilayeredgraph CHAR(50))");
		st.execute("CREATE TABLE PrimalSpaceFeatures id CHAR(50) name CHAR(50) description CHAR(50) cellspacemember TEXT[] cellspaceboundarymember TEXT[]");
		st.execute("CREATE TABLE MultiLayeredGraph");
		st.execute("CREATE TABLE CellSpace");
		st.execute("CREATE TABLE CellSpaceBoundary");
		st.execute("CREATE TABLE SpaceLayers");
		st.execute("CREATE TABLE SpaceLayer");
		st.execute("CREATE TABLE Nodes");	
		st.execute("CREATE TABLE Edges");
		st.execute("CREATE TABLE State");
		st.execute("CREATE TABLE Transition");
		st.execute("CREATE TABLE InterEdges");
		st.execute("CREATE TABLE InterLayerConnection");
		st.execute("CREATE TABLE Geometry");
		st.execute("CREATE TABLE Feature id CHAR(50) type CHAR(50)");
	}
	
    public static void main (String[] args) {
        try {
            Class.forName("org.h2.Driver");
            // Open memory H2 table
            try(Connection connection = DriverManager.getConnection("jdbc:h2:mem:syntax","sa", "sa");
                Statement st = connection.createStatement()) {
                // Import spatial functions, domains and drivers
                // If you are using a file database, you have to do only that once.
                H2GISExtension.load(connection);
                // Create a table
                st.execute("CREATE TABLE ROADS (the_geom MULTILINESTRING, speed_limit INT)");
                
                // Add some roads
                st.execute("INSERT INTO ROADS VALUES ('MULTILINESTRING((15 5, 20 6, 25 7))', 80)");
                st.execute("INSERT INTO ROADS VALUES ('MULTILINESTRING((20 6, 21 15, 21 25))', 50)");
                // Compute the sum of roads length
                try(ResultSet rs = st.executeQuery("SELECT SUM(ST_LENGTH(the_geom)) total_length from ROADS")) {
                    if(rs.next()) {
                        System.out.println("Total length of roads: "+rs.getDouble("total_length")+" m");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}