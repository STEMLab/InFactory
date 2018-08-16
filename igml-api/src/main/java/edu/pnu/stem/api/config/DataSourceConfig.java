package edu.pnu.stem.api.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;

@Configuration
public class DataSourceConfig {
	
	@Bean
    public DataSource dataSource() {
		  		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    		dataSource.setDriverClassName("org.h2.Driver");
	    		dataSource.setUrl("jdbc:h2:file:~/test;AUTO_SERVER=TRUE;");
	    		dataSource.setUsername("sa");
	    		dataSource.setPassword("sa");
	    		dataSource.setSchema("");
	    DataSource ds = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
	    return ds;
    }
	@Bean
	public NamedParameterJdbcTemplate namedParamJdbcTemplate() {
		NamedParameterJdbcTemplate namedParamJdbcTemplate = 
				new NamedParameterJdbcTemplate(dataSource());
		return namedParamJdbcTemplate;
	}

    
}