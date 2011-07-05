package net.zhepu.web.valid.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = FixLengthImpl.class)
public @interface FixLength {

	int length();
	String message() default "{net.zhepu.web.valid.fixlength.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
