/**
 * 
 */
package edu.pnu.stem.api;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import edu.pnu.stem.api.config.AppInitializer;
/**
 * @author hyung
 *
 */
@ContextConfiguration(classes={AppInitializer.class, Container.class}, loader = AnnotationConfigContextLoader.class)
public class ContextJUnitTest extends AbstractJUnit4SpringContextTests {	
	
	@Ignore
	@Test
	public void testContext() {
		Assert.assertNotNull(applicationContext.getBean(Container.class));
	}
}