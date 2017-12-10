package esport.sprint1.sprint1;

import com.fasterxml.jackson.databind.ObjectMapper;
import esport.sprint1.sprint1.metier.*;
import esport.sprint1.sprint1.models.*;
import esport.sprint1.sprint1.services.ActualiteRestService;
import esport.sprint1.sprint1.services.TournoisRestService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ActualiteRestServiceUnitTest {
    private MockMvc mockMvc;

    @Mock
    private ActualiteMetier actualiteMetier;
    @InjectMocks
    private ActualiteRestService actualiteController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(actualiteController)
                .build();
    }
    @Test
    public void test_get_all_success() throws Exception {
        Ville V = new Ville("Casablanca");
        V.setId(new Long(1));
        Journaliste J = new Journaliste();
        J.setId(new Long(1));
        J.setNom("Test");
        J.setVilleId(new Long(1));

        List<Actualite> actualites = Arrays.asList(
                new Actualite("Tournoi","Won by",new Date(),J){});
        when(actualiteMetier.listActualite()).thenReturn(actualites);
        mockMvc.perform(get("/actualites"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].titre", is("Tournoi")));
        verify(actualiteMetier, times(1)).listActualite();
        verifyNoMoreInteractions(actualiteMetier);
    }
    @Test
    public void test_create_actualite_success() throws Exception {
        Ville V = new Ville("Casablanca");
        V.setId(new Long(1));
        Journaliste J = new Journaliste();
        J.setId(new Long(1));
        J.setNom("Test");
        J.setVilleId(new Long(1));
        Actualite Act =  new Actualite("Tournoi","Won by",new Date(),J);
        when(actualiteMetier.saveActualite(Act)).thenReturn(Act);
        mockMvc.perform(
                post("/actualites")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(Act)))
                .andExpect(status().isOk());
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
