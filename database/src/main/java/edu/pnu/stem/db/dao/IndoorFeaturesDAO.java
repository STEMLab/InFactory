package edu.pnu.stem.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.core.IndoorFeatures;
import edu.pnu.stem.feature.core.MultiLayeredGraph;
import edu.pnu.stem.feature.core.PrimalSpaceFeatures;

public class IndoorFeaturesDAO implements FeatureDAO {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Object searchById(IndoorGMLMap map, String id) {
		IndoorFeatures feature = new IndoorFeatures(map, id);
		String sql = "SELECT * from IndoorFeatures where id = :id";
		
		MapSqlParameterSource in = new MapSqlParameterSource();
		
		in.addValue("id", id);

		RowMapper<IndoorFeatures> mapper = new RowMapper<IndoorFeatures>() {
			public IndoorFeatures mapRow(ResultSet rs, int rowNum) throws SQLException {
				IndoorFeatures feature = new IndoorFeatures(map,id);
				String name = rs.getString("name");
				String description = rs.getString("description");
				String primalSpaceFeatures = rs.getString("primalspacefeatures");
				String multiLayeredGraph = rs.getString("multiLayeredGraph");

				feature.setName(name);
				feature.setDescription(description);				
				if (primalSpaceFeatures != null)
					feature.setPrimalSpaceFeatures(new PrimalSpaceFeatures(map, primalSpaceFeatures));
				if (multiLayeredGraph != null)
					feature.setMultiLayeredGraph(new MultiLayeredGraph(map, multiLayeredGraph));
				return feature;
			}
		};
			
		return this.namedParameterJdbcTemplate.query(sql, in.getValues(), mapper);

	}

	public void insertFeature(IndoorFeatures feature) {
		String tableName = "IndoorFeatures";
		MapSqlParameterSource in = new MapSqlParameterSource();

		String id = feature.getId();
		String name = feature.getName();
		String description = feature.getDescription();
		String primalspacefeatures = feature.getPrimalSpaceFeatures().getId();
		String multilayeredgraph = feature.getMultiLayeredGraph().getId();

		// String sql = "Insert into " + tableName + " values(" + id + "," + name + ","
		// + description + ","
		// + primalspacefeatures + "," + multilayeredgraph + ")";
		String sql = "Insert into " + tableName
				+ " values(:id, :name,:description,:primalspacefeatures,:multilayeredgraph)";

		in.addValue("id", id);
		in.addValue("name", name);
		in.addValue("description", description);
		in.addValue("primalspacefeatures", primalspacefeatures);
		in.addValue("multilayeredgraph", multilayeredgraph);

		namedParameterJdbcTemplate.update(sql, in.getValues());

	}

	@Override
	public List<Object> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
