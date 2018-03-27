/**
 * 
 */
package edu.pnu.stem.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.pnu.stem.api.Container;

/**
 * @author hyung
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "edu.pnu.stem.api")
public class AppConfig implements WebMvcConfigurer{

	@Bean
    public Container container() {
        return Container.getInstance();
    }
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedMethods("PUT","GET","POST")
		.allowedOrigins("*")
		.allowedHeaders("*");
	}
	
}
