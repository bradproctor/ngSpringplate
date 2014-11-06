package net.bradproctor.ngspringplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {


    /**
     * Point to main page.
     * @return
     */
	@RequestMapping
    public String getMain() {
		return "main";
	}
}
