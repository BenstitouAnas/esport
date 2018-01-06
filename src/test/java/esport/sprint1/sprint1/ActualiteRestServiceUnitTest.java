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
    public void test_create_actualite_success() throws Exception {
        Actualite Act =  new Actualite();
        when(actualiteMetier.saveActualite(Act)).thenReturn(Act);
        mockMvc.perform(
                post("/actualites")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(Act)))
                .andExpect(status().isOk());
    }
    @Test
    public void test_update_actualite_success() throws Exception {
        Ville V = new Ville("Casablanca");
        V.setId(new Long(1));
        Journaliste O = new Journaliste();
        O.setId(new Long(1));
        O.setNom("Test");
        O.setVilleId(new Long(1));
        Jeu J = new Jeu();
        J.setId(new Long(1));
        Actualite T = new Actualite();
        T.setId(new Long(1));
        when(actualiteMetier.getActualite(T.getId())).thenReturn(T);
        when(actualiteMetier.updateActualite(T.getId(),T)).thenReturn(T);
        mockMvc.perform(
                put("/actualites/{id}", T.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(T)))
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
