package net.zhepu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UrlTemplate {
//http://localhost:8080/springmvc/username/winzip/userid/10001?param1=1&param2=1&param3=1
	@RequestMapping(value = "/username/{username}/userid/{userid}",
			params =  {"param1=1","param2!=2","param3"},
			method=RequestMethod.GET)
	public ModelAndView test1(@PathVariable String username,
			@PathVariable int userid,String param1,String param2,String param3){
		ModelAndView mv = new ModelAndView();
		mv.addObject("userName", username);
		mv.addObject("userid", userid);
		mv.addObject("param1", param1);
		mv.addObject("param2", param2);
		mv.addObject("param3", param3);
		mv.setViewName("test002");
		return mv;		
	}
}
