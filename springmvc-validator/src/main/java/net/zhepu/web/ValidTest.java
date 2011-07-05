package net.zhepu.web;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import net.zhepu.web.model.JsonResult;
import net.zhepu.web.model.User;
import net.zhepu.web.model.ValidModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ValidTest {
	Logger log = LoggerFactory.getLogger(ValidTest.class);

	@RequestMapping("/valid")
	public String valid(@ModelAttribute("vm") @Valid ValidModel vm, BindingResult result) {
		if (result.hasErrors()) {
/*			List<ObjectError> e = result.getAllErrors();
			List<FieldError> fes = result.getFieldErrors();
			for (ObjectError err : e) {
				log.error(err.getObjectName() + err.getDefaultMessage());
			}
			for (FieldError fe : fes) {
				log.error(fe.getField() + fe.getDefaultMessage());
			}*/
			return "validResult";
		}

		return "helloworld";
	}

	@RequestMapping("/validJson1")
	@ResponseBody
	public JsonResult processSubmitjson(@RequestBody ValidModel vm,
			HttpServletRequest request) {
		JsonResult jsonRst = new JsonResult();
		
		Set<ConstraintViolation<ValidModel>> set = validator.validate(vm);
		for (ConstraintViolation<ValidModel> violation : set) {

			String propertyPath = violation.getPropertyPath().toString();
			;
			String message = violation.getMessage();
			log.error("invalid value for: '" + propertyPath + "': "
					+ message);
		}		
		if (!set.isEmpty()){
			jsonRst.setSuccess(false);
			jsonRst.setMsg("输入有误!");
			return jsonRst;
		}

		jsonRst.setSuccess(true);
		jsonRst.setMsg("输入成功!");
		return jsonRst;
	}
	
    @RequestMapping("/validJson2")
    @ResponseBody
    public JsonResult testJson4(@RequestBody @Valid ValidModel vm){
    	log.info("handle json for valid");
    	return new JsonResult(true,"return ok");   	
    }	
    @Autowired
    private LocalValidatorFactoryBean validator;

	public LocalValidatorFactoryBean getValidator() {
		return validator;
	}

	public void setValidator(LocalValidatorFactoryBean validator) {
		this.validator = validator;
	}
}
