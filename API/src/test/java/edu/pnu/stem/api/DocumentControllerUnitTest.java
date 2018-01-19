/**
 * 
 */
package edu.pnu.stem.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import edu.pnu.stem.api.config.AppInitializer;

/**
 * @author hyung
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppInitializer.class, Container.class}, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class DocumentControllerUnitTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    	MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new DocumentController()).build();
    }
    
    @Ignore
    @Test
    public void test_create_user_success() throws Exception {
        //User user = new User("Arya Stark");
        //when(userService.exists(user)).thenReturn(false);
        //doNothing().when(userService).create(user);
        mockMvc.perform(
                post("/document/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"doc1\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "http://localhost/document/doc1"));
        //verify(userService, times(1)).exists(user);
        //verify(userService, times(1)).create(user);
        //verifyNoMoreInteractions(userService);
    }
    
}
