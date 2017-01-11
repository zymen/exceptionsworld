package net.zymen.exceptionsworld.views;

import net.zymen.exceptionsworld.services.PackageClassInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainPageController {

    private final PackageClassInfoService packageClassInfoService;

    public MainPageController(PackageClassInfoService packageClassInfoService) {
        this.packageClassInfoService = packageClassInfoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView("views/mainPage");

        modelAndView.addObject("topPackageClassInfoList", packageClassInfoService.getTopPackageClassInfoList());
        return modelAndView;
    }
}
