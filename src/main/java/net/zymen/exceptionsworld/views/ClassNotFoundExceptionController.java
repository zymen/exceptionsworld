package net.zymen.exceptionsworld.views;

import net.zymen.exceptionsworld.services.PackageClassInfoService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@RequestMapping("/classNotFoundException")
public class ClassNotFoundExceptionController {

    private static final Logger log = getLogger(ClassNotFoundExceptionController.class);

    private final PackageClassInfoService packageClassInfoService;

    public ClassNotFoundExceptionController(PackageClassInfoService packageClassInfoService) {
        this.packageClassInfoService = packageClassInfoService;
    }

    @RequestMapping(value = "/{packageClassFullName}/{packageClassInfoKey}/", method = RequestMethod.GET)
    public ModelAndView packageClassInfoView(@PathVariable String packageClassInfoKey) {
        log.info("Building view for class '{}'", packageClassInfoKey);

        ModelAndView modelAndView = new ModelAndView("models/classNotFoundException/packageClassInfoView");

        modelAndView.addObject("packageClassInfo", packageClassInfoService.getOne(packageClassInfoKey));
        return modelAndView;
    }
}
