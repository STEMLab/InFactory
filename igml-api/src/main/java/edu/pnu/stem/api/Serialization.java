package edu.pnu.stem.api;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentHashMap;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.State;

public class Serialization {
	public static void main(String args[]) {
		try {
			IndoorGMLMap newMap = new IndoorGMLMap();
			newMap.setDocId("1234");

			CellSpace newFeature = new CellSpace(newMap, "123");
			State newFeature2 = new State(newMap, "S123");

			newFeature.setDuality(newFeature2);
			newFeature2.setDuality(newFeature);
			newMap.setFeature("123", "CellSpace", newFeature);
			
			serializateIndoorGMLMap(null, newMap);

			newMap.setFeature("S123", "State", newFeature2);
			
			serializateIndoorGMLMap(null,newMap);
			
			
			System.out.printf("Serialized HashMap data is saved in hashmap.ser");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		IndoorGMLMap result = null;

		try {
			FileInputStream fis = new FileInputStream("hashmap.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			// result = (IndoorGMLMap) ois.readObject();
			Object temp = ois.readObject();
			if (temp instanceof IndoorGMLMap)
				result = (IndoorGMLMap) temp;
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}

		System.out.println("Deserialized HashMap..");
		// Display content using Iterator
		ConcurrentHashMap container = ((IndoorGMLMap) result).getFeatureContainer("State");

		State state1 = (State) container.get("S123");
		System.out.println(state1.getId());
	}

	public IndoorGMLMap deSerializateIndoorGMLMap(String fileName) throws IOException{
		IndoorGMLMap result = null;
		FileInputStream fis = null;

		try {
			if (fileName == null) {
				fis = new FileInputStream("hashmap.ser");
			} else {
				fis = new FileInputStream(fileName);
			}

			ObjectInputStream ois = new ObjectInputStream(fis);
			result = (IndoorGMLMap) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
		}

		return result;
	}

	public static void serializateIndoorGMLMap(String fileName, IndoorGMLMap map) throws IOException{
		try {
			FileOutputStream fos = null;
			if (fileName == null) {
				fos = new FileOutputStream("hashmap.ser");
			} else {
				fos = new FileOutputStream(fileName);
			}

			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(map);
			oos.close();
			fos.close();
			System.out.printf("Serialized HashMap data is saved in hashmap.ser");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
