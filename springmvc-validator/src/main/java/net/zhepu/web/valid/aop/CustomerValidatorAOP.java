package net.zhepu.web.valid.aop;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.validation.Valid;

import net.zhepu.web.model.JsonResult;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Aspect
public class CustomerValidatorAOP {
  private Validator validator;
 
  @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
  private void controllerInvocation() {
  }
 
  @Around("controllerInvocation()")
  public Object aroundController(ProceedingJoinPoint joinPoint) throws Throwable {
 
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    Method method = methodSignature.getMethod();
    System.out.println("======== " + method.getName());
    Annotation[] annotationList = method.getAnnotations();
    for(Annotation anno:annotationList){
    	System.out.print(" >>>>>>>> ");
    	System.out.print(anno.toString());
    	System.out.print(" >>>>>>>> ");
    	System.out.println(ResponseBody.class.isInstance(anno));
    }
    Annotation[][] argAnnotations = method.getParameterAnnotations();
    for(Annotation[] annoList:argAnnotations){
    	System.out.println(" p>>>>>>");
    	for(Annotation anno:annoList){
	    	System.out.print(" >>>>>>>> ");
	    	System.out.print(anno.toString());
	    	System.out.println();
    	}
    }
    String[] argNames = methodSignature.getParameterNames();
    for (String argName : argNames) {
    	System.out.println(">>> " + argName);
    }
    Object[] args = joinPoint.getArgs();
    for (Object arg : args) {
    	System.out.println(">>: " + arg);
    }
 
    for (int i = 0; i < args.length; i++) {
      if (hasRequestBodyAndValidAnnotations(argAnnotations[i])) {
    	  System.out.println(" ++++++++++++ bingo!");
        Object ret = validateArg(args[i], argNames[i]);
        if(ret != null){
        	return ret;
        }
      }
    }
 
    return joinPoint.proceed(args);
  }
 
  private boolean hasRequestBodyAndValidAnnotations(Annotation[] annotations) {
    if (annotations.length < 2)
      return false;
 
    boolean hasValid = false;
    boolean hasRequestBody = false;
 
    for (Annotation annotation : annotations) {
      if (Valid.class.isInstance(annotation))
        hasValid = true;
      else if (RequestBody.class.isInstance(annotation))
        hasRequestBody = true;
 
      if (hasValid && hasRequestBody)
        return true;
    }
    return false;
  }
 

  private JsonResult validateArg(Object arg, String argName) {
    BindingResult result = getBindingResult(arg, argName);
    validator.validate(arg, result);
    if (result.hasErrors()) {
      JsonResult jsonresult = new JsonResult();
      jsonresult.setSuccess(false);
      jsonresult.setMsg("fail");
      return jsonresult;
    }
    return null;
  }
 
  private BindingResult getBindingResult(Object target, String targetName) {
    return new BeanPropertyBindingResult(target, targetName);
  }
 
  @Required
  public void setValidator(Validator validator) {
    this.validator = validator;
  }
}