package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.LocalMetier;
import esport.sprint1.sprint1.models.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LocalRestService {

    @RequestMapping(value = "/locales", method = RequestMethod.POST)
    public Local saveLocal(@RequestBody Local l) {
        return localMetier.saveLocal(l);
    }

    @RequestMapping(value = "/locales", method = RequestMethod.GET)
    public List<Local> listLocales() {
        return localMetier.listLocales();
    }

    @RequestMapping(value = "/locales/{id}", method = RequestMethod.DELETE)
    public boolean deleteLocal(@PathVariable Long id) {
        return localMetier.deleteLocal(id);
    }

    @RequestMapping(value = "/locales/{id}", method = RequestMethod.GET)
    public Local getLocal(@PathVariable Long id) {
        return localMetier.getLocal(id);
    }

    @RequestMapping(value = "/locales/{id}", method = RequestMethod.PUT)
    public Local updateLocal(@PathVariable Long id, @RequestBody Local l) {
        return localMetier.updateLocal(id, l);
    }

    @Autowired
    private LocalMetier localMetier;
}
