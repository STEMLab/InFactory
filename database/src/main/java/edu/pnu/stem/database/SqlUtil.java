package edu.pnu.stem.database;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Array;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

public class SqlUtil {
	public static String change2SqlString(String n) {
		if (n != null)
			n = "'" + n + "'";
		return n;
	}
	
	public static List<String> getArray(Array a) throws SQLException {
		List<String> result = new ArrayList<String>();
		Object[] tempArr = (Object[]) a.getArray();
		for (Object o : tempArr) {
			result.add((String) o);
		}
		return result;
	}
	
	public static Geometry changeBinary2Geometry(Blob blob) throws SQLException, IOException, ClassNotFoundException {
		Geometry result = null;
		ByteArrayInputStream in = new ByteArrayInputStream(blob.getBytes(1, (int) blob.length()));
		ObjectInputStream is = new ObjectInputStream(in);
		result = (Geometry) is.readObject();
		return result;
	}
	
	public static byte[] changeGeometry2Binary(Geometry geom) throws IOException {
		byte[] result;

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(geom);
		result = baos.toByteArray();

		return result;
	}
}
