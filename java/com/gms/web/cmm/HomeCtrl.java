package com.gms.web.cmm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class HomeCtrl {
	static final Logger logger = LoggerFactory.getLogger(HomeCtrl.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		model.addAttribute("context", YoonHo.ctx.apply(request) );
		return "main";
	}
	@RequestMapping(value="/move/{prefix}/{dir}/{page}")
	public String move(@PathVariable String prefix,
			@PathVariable String dir,
			@PathVariable String page) {
		logger.info("HomeController ::: move() {}.", "ENTER");
		return prefix+":"+dir+"/"+page+".tiles";
	}
}
