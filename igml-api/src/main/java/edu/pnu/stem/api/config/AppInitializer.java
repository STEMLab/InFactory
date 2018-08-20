/**
 * 
 */
package edu.pnu.stem.api.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;

import org.h2.server.web.WebServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author hyung
 *
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	/*
	 @Override
	public void onStartup(ServletContext servletContext) 
			throws ServletException {
		super.onStartup(servletContext);
		DataSourceConfig dsc = new DataSourceConfig();
		DataSource ds = dsc.dataSource();
		try {
			Connection c = ds.getConnection();
			PreparedStatement ps = c.prepareStatement("");
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ServletRegistration.Dynamic servlet = servletContext.addServlet(
				"h2-console", new WebServlet());
		servlet.setLoadOnStartup(2);
		servlet.addMapping("/console/*");
	}
	 * */

}
