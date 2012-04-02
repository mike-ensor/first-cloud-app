package com.ensor.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
/**
 * Home Controller sample
 *
 * All Request to "/home" start here
 */
public class HomeController {

    /**
     * No additional request value mapping, but forces to only GET requests
     * @return String viewForInternalViewResolver
     * @param model
     */
    @RequestMapping(method= RequestMethod.GET)
    public String showHomePage(Model model) {
        String vcap_services = System.getenv("VCAP_SERVICES");
        model.addAttribute("vcap", vcap_services);
        return "home/home";
    }

}
