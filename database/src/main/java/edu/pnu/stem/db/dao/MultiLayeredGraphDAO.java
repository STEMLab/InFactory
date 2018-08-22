package edu.pnu.stem.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.database.SqlUtil;
import edu.pnu.stem.feature.IndoorFeatures;
import edu.pnu.stem.feature.InterEdges;
import edu.pnu.stem.feature.MultiLayeredGraph;
import edu.pnu.stem.feature.PrimalSpaceFeatures;
import edu.pnu.stem.feature.SpaceLayers;

public class MultiLayeredGraphDAO implements FeatureDAO {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Object searchById(IndoorGMLMap map, String id) {

		MultiLayeredGraph feature = new MultiLayeredGraph(map, id);
		String sql = "SELECT * from MultiLayeredGraph where id = :id";

		MapSqlParameterSource in = new MapSqlParameterSource();

		in.addValue("id", id);

		RowMapper<MultiLayeredGraph> mapper = new RowMapper<MultiLayeredGraph>() {
			public MultiLayeredGraph mapRow(ResultSet rs, int rowNum) throws SQLException {
				MultiLayeredGraph feature = new MultiLayeredGraph(map, id);

				if (rs.next()) {
					String name = rs.getString("name");
					String description = rs.getString("description");
					String parentId = rs.getString("parentId");

					if (rs.getArray("InterEdges") != null) {
						List<String> ie = SqlUtil.getArray(rs.getArray("InterEdges"));
						List<InterEdges> iel = new ArrayList<InterEdges>();
						for (String i : ie) {
							iel.add(new InterEdges(map, i));
						}
						feature.setInterEdges(iel);
					}

					if (rs.getArray("SpaceLayers") != null) {
						List<String> sls = SqlUtil.getArray(rs.getArray("SpaceLayers"));
						List<SpaceLayers> slsl = new ArrayList<SpaceLayers>();

						for (String s : sls) {
							slsl.add(new SpaceLayers(map, s));
						}
						feature.setSpaceLayers(slsl);
					}

					feature.setName(name);
					feature.setParent(new IndoorFeatures(map, parentId));
					feature.setDescription(description);

					feature.setName(name);
					feature.setDescription(description);
				}

				return feature;
			}
		};
		
		return this.namedParameterJdbcTemplate.query(sql, in.getValues(), mapper);

	}

	public void insertById(MultiLayeredGraph feature) {
		String sql = null;
		String tableName = "MultiLayeredGraph";

		String id = feature.getId();
		String name = feature.getName();
		String description = feature.getDescription();
		String parentId = feature.getParent().getId();
		List<String> csm = null;
		List<String> csbm = null;

		if (feature.getSpaceLayers() != null && feature.getSpaceLayers().size() != 0) {
			csm = new ArrayList<String>();
			for (SpaceLayers c : feature.getSpaceLayers()) {
				csm.add(c.getId());
			}

		}

		if (feature.getInterEdges() != null && feature.getInterEdges().size() != 0) {
			csbm = new ArrayList<String>();
			for (InterEdges c : feature.getInterEdges()) {
				csbm.add(c.getId());
			}

		}

		MapSqlParameterSource in = new MapSqlParameterSource();

		in.addValue("id", id);
		in.addValue("name", name);
		in.addValue("description", description);
		in.addValue("parentId", parentId);

		in.addValue("cellspacemember", csm);
		in.addValue("cellspaceboundarymember", csbm);

		// sql = "Insert into " + tableName + " values(" + id + "," + parentId + "," +
		// name + "," + description + "," + csm
		// + "," + csbm + ")";
		sql = "Insert into " + tableName + " values(:id, :parentId, :name, :description, :spacelayers, :interedges)";
		namedParameterJdbcTemplate.update(sql, in.getValues());
	}

	@Override
	public List<Object> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
