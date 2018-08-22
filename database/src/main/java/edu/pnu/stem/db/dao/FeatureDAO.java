package edu.pnu.stem.db.dao;

import java.util.List;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.AbstractFeature;
import edu.pnu.stem.feature.IndoorFeatures;

public interface FeatureDAO {
	public Object searchById(IndoorGMLMap map, String id);
	public List<Object>findAll();

	
}
