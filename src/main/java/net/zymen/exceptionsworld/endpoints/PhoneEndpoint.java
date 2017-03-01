package net.zymen.exceptionsworld.endpoints;

import net.zymen.exceptionsworld.importer.PackageImportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/numer-telefonu")
public class PhoneEndpoint {

    @RequestMapping("/{phoneNumber}/kto-dzwonil")
    public ModelAndView phoneNumberDetails(@PathVariable("phoneNumber") String phoneNumber) {
        ModelAndView modelAndView = new ModelAndView("details");
        modelAndView.addObject("phoneNumber", phoneNumber);

        PackageImportService importService = new PackageImportService();
        //importService.run(() -> "https://repo.maven.apache.org/maven2/");
        return modelAndView;
    }
}
