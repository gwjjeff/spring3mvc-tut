package net.zhepu.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.zhepu.web.model.Person;
import net.zhepu.web.model.User;
import net.zhepu.web.model.UserEditor;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MultiAction {

	@RequestMapping("/hello1")
	public ModelAndView hello1() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("handlerMethod", "hello1");
		mv.setViewName("multiactiontest");
		return mv;
	}

	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("handlerMethod", "hello2");
		mv.setViewName("multiactiontest");
		return mv;
	}

	// sample url
	// http://localhost:8080/springmvc/hello3?param1=1&param2=1&param3=1

	@RequestMapping(value = "/hello3", method = RequestMethod.GET, params = {
			"param1=1", "param2!=2", "param3" }, headers = { "Connection=keep-alive" })
	public ModelAndView hello3() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("handlerMethod", "hello3");
		mv.setViewName("multiactiontest");
		return mv;
	}

	@RequestMapping("/hello4")
	public ModelAndView hello4(Date date) {
		ModelAndView mv = new ModelAndView();
		System.out.println(date.getDate());
		mv.addObject("handlerMethod", "hello4");
		mv.setViewName("multiactiontest");
		return mv;
	}
}
