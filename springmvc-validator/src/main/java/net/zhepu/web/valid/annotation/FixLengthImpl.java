package net.zhepu.web.valid.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FixLengthImpl implements ConstraintValidator<FixLength, String> {
	private int length;
	@Override
	public boolean isValid(String validStr,
			ConstraintValidatorContext constraintContext) {
		if (validStr.length() != length) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void initialize(FixLength fixLen) {
		this.length = fixLen.length();
	}
}
