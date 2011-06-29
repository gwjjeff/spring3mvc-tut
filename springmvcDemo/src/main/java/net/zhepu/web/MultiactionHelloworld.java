package net.zhepu.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.zhepu.web.model.Person;
import net.zhepu.web.model.User;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MultiactionHelloworld {

	@RequestMapping("/hello1")
	public ModelAndView hello1() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("helloworld");
		return mv;
	}

	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("helloworld");
		return mv;
	}

	// http://localhost:8080/springmvc/hello3.action?userid=1&username=winzip&email=winzip.cn@gmail.com
	// http://localhost:8080/springmvc/hello3.action?userid=1&username=winzip&person.email=winzip.cn@gmail.com&person.userid=1
	@RequestMapping("/hello3")
	public ModelAndView inputParamTest(User user, Person person,
			@RequestParam(required = false, value = "param1") String param) {
		System.out.println(param);
		System.out.println(user);
		System.out.println(person);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("helloworld");
		return mv;
	}

	@RequestMapping("/databind1")
	public ModelAndView databind1(Date date) {
		System.out.println(date);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("helloworld");
		return mv;
	}

	@ResponseStatus(reason="no reason",value=HttpStatus.BAD_REQUEST)
	@RequestMapping("/responsestatus")
	public void responseStatusTest(){
		
	}

	@RequestMapping("/exception")
	public void ExceptionTest() throws Exception{
		throw new Exception("i don't know");
	}	
	@ExceptionHandler
	public String handleException(Exception e,HttpServletRequest request){
		System.out.println(e.getMessage());
		return "helloworld";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
}
