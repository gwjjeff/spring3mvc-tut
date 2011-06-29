package net.zhepu.web;

import net.zhepu.web.model.JsonResult;
import net.zhepu.web.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonInputTest {
	Logger log = LoggerFactory.getLogger(JsonInputTest.class);
	
    @RequestMapping("/json1")
    @ResponseBody
	public JsonResult testJson1(@RequestBody User u){
    	log.info("get json input from request body annotation");
    	log.info(u.getUserName());
    	return new JsonResult(true,"return ok");
    }
    
    @RequestMapping("/json2")
    
    public ResponseEntity<JsonResult> testJson2(HttpEntity<User> u){
    	log.info("get json input from HttpEntity annotation");
    	log.info(u.getBody().getUserName());
    	ResponseEntity<JsonResult> responseResult = new ResponseEntity<JsonResult>( new JsonResult(true,"return ok"),HttpStatus.OK);
    	return responseResult;
    }
    
    @RequestMapping("/json3.json")
    public JsonResult testJson3(@RequestBody User u){
    	log.info("handle json output from ContentNegotiatingViewResolver");
    	return new JsonResult(true,"return ok");
    }    
}
