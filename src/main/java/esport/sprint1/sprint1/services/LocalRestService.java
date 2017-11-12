package esport.sprint1.sprint1.services;

import esport.sprint1.sprint1.metier.LocalMetier;
import esport.sprint1.sprint1.models.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocalRestService {

    @RequestMapping(value = "/locales", method = RequestMethod.POST)
    public Local saveLocal(@RequestBody Local l) {
        return localMetier.saveLocal(l);
    }

    @RequestMapping(value = "/locales", method = RequestMethod.GET)
    public List<Local> listLocales() {
        return localMetier.listLocales();
    }

    @Autowired
    private LocalMetier localMetier;
}
