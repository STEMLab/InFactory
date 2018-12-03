package edu.pnu.stem.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.core.CellSpace;
import edu.pnu.stem.feature.core.CellSpaceBoundary;
import edu.pnu.stem.feature.core.PrimalSpaceFeatures;

public class PrimalSpaceFeaturesDAO implements FeatureDAO{
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


	@Override
	public Object searchById(IndoorGMLMap map, String id) {
		
		return null;
	}

	@Override
	public List<Object> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void insertById(PrimalSpaceFeatures feature) {
		String sql = null;
		String tableName = "PrimalSpaceFeatures";
	
		String id = feature.getId();
		String name = feature.getName();
		String description = feature.getDescription();
		String parentId = feature.getParent().getId();
		
		List<String> csm = null;
		List<String> csbm = null;
		
		if (feature.getCellSpaceMember() != null && feature.getCellSpaceMember().size() != 0) {
			csm = new ArrayList<String>();
			for (CellSpace c : feature.getCellSpaceMember()) {
				csm.add(c.getId());
			}
		}

		if (feature.getCellSpaceBoundaryMember() != null && feature.getCellSpaceBoundaryMember().size() != 0) {
			csbm = new ArrayList<String>();
			for (CellSpaceBoundary c : feature.getCellSpaceBoundaryMember()) {
				csbm.add(c.getId());
			}
		}

		MapSqlParameterSource in = new MapSqlParameterSource();

		in.addValue("id", id);
		in.addValue("name", name);
		in.addValue("description", description);
		in.addValue("parentId", parentId);
		
		in.addValue("cellspacemember",csm );
		in.addValue("cellspaceboundarymember", csbm);
		
		//sql = "Insert into " + tableName + " values(" + id + "," + parentId + "," + name + "," + description + "," + csm
		//		+ "," + csbm + ")";
		sql = "Insert into " + tableName + " values(:id, :parentId, :name, :description, :cellspacemember, :cellspaceboundarymember)";
		namedParameterJdbcTemplate.update(sql, in.getValues());
		
		//return sql;
	}

}
