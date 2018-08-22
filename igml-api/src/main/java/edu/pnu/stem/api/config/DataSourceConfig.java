package edu.pnu.stem.api.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.h2.tools.Server;
import org.h2gis.ext.H2GISExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
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
	    		
	    		
	    //DataSource ds = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("schema.sql").setName("test;DB_CLOSE_DELAY=-1;").build();
	    //return ds;
	    return dataSource;
	}
	@Bean
	public NamedParameterJdbcTemplate namedParamJdbcTemplate() {
		NamedParameterJdbcTemplate namedParamJdbcTemplate = 
				new NamedParameterJdbcTemplate(dataSource());
		return namedParamJdbcTemplate;
	}
	

	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server startDBserver() throws SQLException{
		return Server.createTcpServer("-tcpAllowOthers", "-tcpPort", "9092");
	}
	
	// Start WebServer, access http://localhost:8082
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server startDBManager() throws SQLException {
		return Server.createWebServer("-webAllowOthers", "-webPort", "8082");
	}
	
	

    
}