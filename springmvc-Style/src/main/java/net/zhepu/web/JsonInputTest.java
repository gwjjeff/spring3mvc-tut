package net.zhepu.web;

import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import net.zhepu.web.model.JsonResult;
import net.zhepu.web.model.User;
import net.zhepu.web.xmlModel.BeanJaxbA;

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
	public JsonResult testJson1(@RequestBody User u) {
		log.info("get json input from request body annotation");
		log.info(u.getUserName());
		return new JsonResult(true, "return ok");
	}

	@RequestMapping("/json2")
	public ResponseEntity<JsonResult> testJson2(HttpEntity<User> u) {
		log.info("get json input from HttpEntity annotation");
		log.info(u.getBody().getUserName());
		ResponseEntity<JsonResult> responseResult = new ResponseEntity<JsonResult>(new JsonResult(true, "return ok"),
				HttpStatus.OK);
		return responseResult;
	}

	@RequestMapping("/json3.json")
	public JsonResult testJson3(@RequestBody User u) {
		log.info("handle json output from ContentNegotiatingViewResolver");
		return new JsonResult(true, "return ok");
	}

	@RequestMapping("/xml.xml")
	public BeanJaxbA testXML1(@RequestBody BeanJaxbA a) {
		System.out.println(">>>>>>>>>>>>>: bingo");
		System.out.println(a);
		BeanJaxbA a1 = new BeanJaxbA();
		a1.setId(2000);
		a1.setName("winzip");
		a1.setPassword("password");

		return a1;
	}

	@RequestMapping("/xml2.xml")
	public BeanJaxbA testXML2(@RequestBody DOMSource a) {
		System.out.println(">>>>>>>>>>>>>: bingo!");
		try {
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(a, result);
			System.out.println(writer.toString());
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BeanJaxbA a1 = new BeanJaxbA();
		a1.setId(2000);
		a1.setName("winzip");
		a1.setPassword("password");

		return a1;
	}
}
