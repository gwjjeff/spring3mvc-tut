package com.shsz.young.jeff.test;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

public class DummyTest {
	@Test
	public void test1() {
		BeanWrapper company = PropertyAccessorFactory.forBeanPropertyAccess(new Company());
		// setting the company name..
		company.setPropertyValue("name", "Some Company Inc.");
		// ... can also be done like this:
		PropertyValue value = new PropertyValue("name", "Some Company Inc.");
		company.setPropertyValue(value);

		// ok, let's create the director and tie it to the company:
		BeanWrapper jim = PropertyAccessorFactory.forBeanPropertyAccess(new Employee());
		jim.setPropertyValue("name", "Jim Stravinsky");
		jim.setPropertyValue("salary", 0.1f);
		company.setPropertyValue("managingDirector", jim.getWrappedInstance());

		// retrieving the salary of the managingDirector through the company
		Float salary = (Float) company.getPropertyValue("managingDirector.salary");
		Assert.assertEquals(salary, 0.1f);
	}
}
