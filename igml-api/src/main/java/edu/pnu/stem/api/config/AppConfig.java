/**
 * 
 */
package edu.pnu.stem.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import edu.pnu.stem.api.Container;

/**
 * @author hyung
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "edu.pnu.stem.api")
public class AppConfig {

	@Bean
    public Container container() {
        return Container.getInstance();
    }
	
}
