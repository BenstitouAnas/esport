package esport.sprint1.sprint1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thetransactioncompany.cors.CORSFilter;
import esport.sprint1.sprint1.metier.LocalMetier;
import esport.sprint1.sprint1.metier.MatchesMetier;
import esport.sprint1.sprint1.metier.RoundsMetier;
import esport.sprint1.sprint1.metier.TournoisMetier;
import esport.sprint1.sprint1.models.*;
import esport.sprint1.sprint1.services.TournoisRestService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TournoisRestServiceUnitTest {
    private MockMvc mockMvc;

    @Mock
    private TournoisMetier tournoisMetier;
    @Mock
    private MatchesMetier matchesMetier;
    @Mock
    private RoundsMetier roundsMetier;
    @Mock
    private LocalMetier localMetier;
    @InjectMocks
    private TournoisRestService tournoisController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(tournoisController)
                .build();
    }
   @Test
    public void test_get_all_success() throws Exception {
        Local L = new Local(0,0);
        L.setId(new Long(1));
        Console C = new Console("PS4");
        C.setId(new Long(1));
        Ville V = new Ville("Casablanca");
        V.setId(new Long(1));
        Organisateur O = new Organisateur();
        O.setId(new Long(1));
        O.setNom("Test");
        O.setVilleId(new Long(1));
        Jeu J = new Jeu();
        J.setId(new Long(1));
        List<Tournois> users = Arrays.asList(
                new Tournois("Tournoi","Tournoi de siecle",false, 100.5, false, new Date(), new Date(), L, O, C, J,true) {
                });
        when(tournoisMetier.listTOurnois()).thenReturn(users);
        mockMvc.perform(get("/tournois"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].titre", is("Tournoi")));
        verify(tournoisMetier, times(1)).listTOurnois();
        verifyNoMoreInteractions(tournoisMetier);
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test_create_toornament_success() throws Exception {
        Local L = new Local(0,0);
        L.setId(new Long(1));
        Console C = new Console("PS4");
        C.setId(new Long(1));
        Ville V = new Ville("Casablanca");
        V.setId(new Long(1));
        Organisateur O = new Organisateur();
        O.setId(new Long(1));
        O.setNom("Test");
        O.setVilleId(new Long(1));
        Jeu J = new Jeu();
        J.setId(new Long(1));
        Tournois T = new TournoisEnEquipe();
        T.setConsole(C);
        T.setDateDebut(new Date());
        T.setDateFin(new Date());
        T.setDescription("");
        T.setJeu(J);
        T.setLocal(L);
        T.setOrganisateur(O);
        when(tournoisMetier.saveTournois(T)).thenReturn(T);
        mockMvc.perform(
                post("/tournois")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(T)))
                .andExpect(status().isOk());
    }
    @Test
    public void test_update_toornament_success() throws Exception {
        Local L = new Local(0,0);
        L.setId(new Long(1));
        Console C = new Console("PS4");
        C.setId(new Long(1));
        Ville V = new Ville("Casablanca");
        V.setId(new Long(1));
        Organisateur O = new Organisateur();
        O.setId(new Long(1));
        O.setNom("Test");
        O.setVilleId(new Long(1));
        Jeu J = new Jeu();
        J.setId(new Long(1));
        Tournois T = new TournoisEnEquipe();
        T.setConsole(C);
        T.setDateDebut(new Date());
        T.setDateFin(new Date());
        T.setDescription("");
        T.setJeu(J);
        T.setLocal(L);
        T.setOrganisateur(O);
        T.setId(new Long(1));
        when(localMetier.saveLocal(L)).thenReturn(L);
        when(tournoisMetier.getTournois(T.getId())).thenReturn(T);
        when(tournoisMetier.updateTournois(T.getId(),T)).thenReturn(T);
        mockMvc.perform(
                put("/tournois/{id}", T.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(T)))
                .andExpect(status().isOk());
    }
    @Test
    public void test_publier_toornament_success() throws Exception {
        Local L = new Local(0,0);
        L.setId(new Long(1));
        Console C = new Console("PS4");
        C.setId(new Long(1));
        Ville V = new Ville("Casablanca");
        V.setId(new Long(1));
        Organisateur O = new Organisateur();
        O.setId(new Long(1));
        O.setNom("Test");
        O.setVilleId(new Long(1));
        Jeu J = new Jeu();
        J.setId(new Long(1));
        Tournois T = new TournoisEnEquipe();
        T.setConsole(C);
        T.setDateDebut(new Date());
        T.setDateFin(new Date());
        T.setDescription("");
        T.setJeu(J);
        T.setLocal(L);
        T.setOrganisateur(O);
        T.setId(new Long(1));
        when(localMetier.saveLocal(L)).thenReturn(L);
        when(tournoisMetier.getTournois(T.getId())).thenReturn(T);
        when(tournoisMetier.updateTournois(T.getId(),T)).thenReturn(T);
        mockMvc.perform(
                put("/tournois/{id}/publier", T.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(T)))
                .andExpect(status().isOk());
    }
    @Test
    public void test_generer_toornament_success() throws Exception {
        Local L = new Local(0,0);
        L.setId(new Long(1));
        Console C = new Console("PS4");
        C.setId(new Long(1));
        Ville V = new Ville("Casablanca");
        V.setId(new Long(1));
        Organisateur O = new Organisateur();
        O.setId(new Long(1));
        O.setNom("Test");
        O.setVilleId(new Long(1));
        Jeu J = new Jeu();
        J.setId(new Long(1));
        TournoisIndividuel T = new TournoisIndividuel();
        T.setConsole(C);
        T.setDateDebut(new Date());
        T.setDateFin(new Date());
        T.setDescription("");
        T.setJeu(J);
        T.setLocal(L);
        T.setOrganisateur(O);
        T.setNbJoueurs(12);
        T.setId(new Long(1));
        when(localMetier.saveLocal(L)).thenReturn(L);
        when(tournoisMetier.saveTournois(T)).thenReturn(T);
        when(tournoisMetier.getTournois(T.getId())).thenReturn(T);
        Rounds R = new Rounds();
        Matches M = new Matches();
        when(roundsMetier.saveRound(R)).thenReturn(R);
        when(tournoisMetier.getTournois(T.getId())).thenReturn(T);
        mockMvc.perform(
                post("/tournois/{id}/generer", T.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(T)))
                .andExpect(status().isOk());
    }
}
