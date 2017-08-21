package com.example.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(path="/")
public class HelloController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String helloWorld(Model model) {
        model.addAttribute("instanceId", "n/a");

        String instance = System.getenv("CF_INSTANCE_INDEX");
        if (StringUtils.isNotBlank(instance)) {
            model.addAttribute("instanceId", instance);
        }

        return "hello";
	}

    @RequestMapping(value="/kill", method=RequestMethod.GET)
    public void killInstance() {
        System.exit(0);
    }

}
